package com.actualize.mortgage.services.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mismo.residential._2009.schemas.MESSAGE;
import org.mismo.residential._2009.schemas.ObjectFactory;
import org.w3c.dom.Document;

import com.actualize.mortgage.domainmodels.ConversionError;
import com.actualize.mortgage.domainmodels.DataElement;
import com.actualize.mortgage.domainmodels.IntermediateXMLData;
import com.actualize.mortgage.services.MortgageServices;
import com.actualize.mortgage.utils.OutputFormatter;

import transformer.TRIDTransformer;
import ucdutils.UCDArcRolesParty;
import ucdutils.UCDArcRolesSignatory;
import xmlutils.Utils;

public class MortgageServicesImpl implements MortgageServices{
	
    List<ConversionError> conversionErrorList = null;
	
	@Override
    public MESSAGE generateMasterXML(IntermediateXMLData intermediateXMLData) throws Exception {
        DOMResult res = new DOMResult();
        JAXBContext context = JAXBContext.newInstance(intermediateXMLData.getClass());
        context.createMarshaller().marshal(intermediateXMLData, res);
        Document doc = (Document) res.getNode();

        TRIDTransformer tridTransformer = new TRIDTransformer();
        Document xmlout = tridTransformer.transform(doc);
        Utils.removeEmptyNodes(xmlout);
        UCDArcRolesParty arcRoles = new UCDArcRolesParty();
        arcRoles.normalize(xmlout);
        UCDArcRolesSignatory arcSignatories = new UCDArcRolesSignatory();
        arcSignatories.normalize(xmlout);
        
        return transformXmlToObject(xmlout);
    }
	
	public MESSAGE transformXmlToObject(Document xmlout) throws Exception{
        // Prepare document to write
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.setOutputProperty(OutputKeys.METHOD, "xml");
        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        // Write xmldoc to stream out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        tr.transform(new DOMSource(xmlout), new StreamResult(out));
        out.close();

        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<MESSAGE> unmarshalledObject = (JAXBElement<MESSAGE>) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(out.toByteArray()));

        return unmarshalledObject.getValue();
    }
	
	@Override
    public IntermediateXMLData generateIntermediateXMLForTxtTemplate(InputStream mappingFile, Properties propFile) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(IntermediateXMLData.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IntermediateXMLData intermediateXMLMap = (IntermediateXMLData) jaxbUnmarshaller.unmarshal(mappingFile);

        List<DataElement> dataElementObjects = intermediateXMLMap.getDataElementObject();
        IntermediateXMLData intermediateDataObject = new IntermediateXMLData();
        List<DataElement> dataObjects = new ArrayList<>();
        conversionErrorList = new LinkedList<>();
        for(DataElement object : dataElementObjects){
            List<DataElement> expandedElements = expandDataElements(object, (Map)propFile);
            for (DataElement de : expandedElements)
                dataObjects.addAll(createDataElementsForTxtTemplate(de, null, propFile));
        }
        intermediateDataObject.setDataElementObject(dataObjects);
        return intermediateDataObject;
    }
	
	private List<DataElement> createDataElementsForTxtTemplate(DataElement dataElement, DataElement inheritedDataElement, Properties props) {
        List<DataElement> dataObjects = new ArrayList<>();
        String value = getDataValueFromProperties(dataElement, props);
        if (value != null) {
            inheritedDataElement = updateInheritedDataElement(dataElement, inheritedDataElement);
            DataElement intermediateObject = new DataElement();
            intermediateObject.setDataPointName(dataElement.getDataPointName());
            intermediateObject.setGroupIdentifier(inheritedDataElement.getGroupIdentifier());
            intermediateObject.setIncludeInXmlIndicator(inheritedDataElement.getIncludeInXmlIndicator());
            intermediateObject.setxPathValue(inheritedDataElement.getxPathValue());
            intermediateObject.setDataValue(value);
            dataObjects.add(intermediateObject);
            if (dataElement.getDataElement() != null)
                for (DataElement childDataElement : dataElement.getDataElement())
                    dataObjects.addAll(createDataElementsForTxtTemplate(childDataElement, inheritedDataElement, props));
        }
        return dataObjects;
    }
	
	private DataElement updateInheritedDataElement(DataElement dataElement, DataElement parentInheritedDataElement) {
        DataElement inheritedDataElement = new DataElement();
        inheritedDataElement.setGroupIdentifier(resolveGroupIdentifier(dataElement, parentInheritedDataElement));
        inheritedDataElement.setIncludeInXmlIndicator(resolveIncludeInXmlIndicator(dataElement, parentInheritedDataElement));
        inheritedDataElement.setxPathValue(resolveXPath(dataElement, parentInheritedDataElement));
        return inheritedDataElement;
    }
	
    private String resolveGroupIdentifier(DataElement dataElement, DataElement inheritedDataElement) {
        if (dataElement.getGroupIdentifier() == null && inheritedDataElement != null)
            return inheritedDataElement.getGroupIdentifier();
        return dataElement.getGroupIdentifier();
    }

    private String resolveIncludeInXmlIndicator(DataElement dataElement, DataElement inheritedDataElement) {
        if (dataElement.getIncludeInXmlIndicator() == null && inheritedDataElement != null)
            return inheritedDataElement.getIncludeInXmlIndicator() == null ? "TRUE" : inheritedDataElement.getIncludeInXmlIndicator();
        return dataElement.getIncludeInXmlIndicator() == null ? "TRUE" : dataElement.getIncludeInXmlIndicator();
    }

    private String resolveXPath(DataElement dataElement, DataElement inheritedDataElement) {
        if (dataElement.getxPathValue() == null && inheritedDataElement != null)
            return inheritedDataElement.getxPathValue();
        return dataElement.getxPathValue();
    }
	
	private List<DataElement> expandDataElements(DataElement dataElement, Map<String, String> parameters) {
        List<DataElement> dataObjects = new ArrayList<>();
        List<String> wildcardMatches = getWildcardMatches(dataElement.getInputId(), parameters);
        if (wildcardMatches.isEmpty())
            dataObjects.add(dataElement);
        else {
            for (String wildcard : wildcardMatches)
                dataObjects.add(substituteWildcard(dataElement, wildcard));
        }
        return dataObjects;
    }
	
	private List<String> getWildcardMatches(String inputId, Map<String, String> parameters) {
        List<String> wildcards = new ArrayList<>();
        if (inputId == null)
            return wildcards;       
        int index = inputId.indexOf("$$");
        if (index == -1)
            return wildcards;       
        Pattern p = Pattern.compile(inputId.replace("$$", "([0-9]+)"));
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            Matcher m = p.matcher(entry.getKey());
            if (m.matches())
                wildcards.add(m.group(1));
        }
        return wildcards;       
    }
    
    private DataElement substituteWildcard(DataElement dataElement, String wildcard) {
        DataElement element = new DataElement();
        List<DataElement> dataElements = new ArrayList<>();
        if (dataElement.getDataElement() != null) {
            for (DataElement de : dataElement.getDataElement())
                dataElements.add(substituteWildcard(de, wildcard));
            element.setDataElement(dataElements);
        }
        element.setDataPointName(dataElement.getDataPointName());
        element.setDataValue(dataElement.getDataValue());
        element.setEnumerationValues(dataElement.getEnumerationValues());
        if (dataElement.getGroupIdentifier() != null)
            element.setGroupIdentifier(dataElement.getGroupIdentifier().replace("$$", wildcard));
        element.setIncludeInXmlIndicator(dataElement.getIncludeInXmlIndicator());
        if (dataElement.getInputId() != null)
            element.setInputId(dataElement.getInputId().replace("$$", wildcard));
        element.setInputType(dataElement.getInputType());
        element.setOutputFormat(dataElement.getOutputFormat());
        element.setxPathValue(dataElement.getxPathValue());
        return element;
    }
    
    private String getDataValueFromProperties(DataElement dataElement, Properties props) {
        String value = dataElement.getInputId() == null ? dataElement.getDataValue() : props.getProperty(dataElement.getInputId());
        if (null != value && !value.isEmpty()) {
            String[] splitArr = value.split("!", 2);
            value = splitArr[0].trim();
        }
        return formatDataValue(dataElement, value);
    }
    
    private String formatDataValue(DataElement dataElement, String value) {
        if (ignoreValue(value))
            return null;
        if (isBuiltIn(value))
            return getBuiltInValue(value);
        if (!isEnum(dataElement) && dataElement.getOutputFormat() == null)
            return value;
        ConversionError conversionError;
        if (isEnum(dataElement))
            conversionError = getEnum(dataElement, value);
        else
            conversionError = getFormatter(dataElement).formatString(value);
        if (conversionError.getInputValue() == null) {
            conversionError.setInputId(dataElement.getInputId());
            conversionError.setInputType(dataElement.getInputType());
            conversionErrorList.add(conversionError);
        }
        return conversionError.getInputValue();
    }
    
    private boolean ignoreValue(String value) {
        return value==null || "".equals(value) || "null".equalsIgnoreCase(value);
    }
    
    private OutputFormatter getFormatter(DataElement dataElement) {
        String formatStyle = dataElement.getOutputFormat().trim().toUpperCase();
        return OutputFormatter.valueOf(formatStyle);
    }
    
    private boolean isBuiltIn(String value) {
        return value != null && value.length() > 1 && value.startsWith("$") && value.endsWith("$");
    }
    
    private String getBuiltInValue(String value) {
        switch (value.toUpperCase()) {
        case "$CURRENTDATETIME$":
            return LocalDateTime.now().format(OutputFormatter.DATE_TIME_FORMAT) + 'Z';
        default:
            return null;
        }
    }
    
    private boolean isEnum(DataElement dataElement) {
        return dataElement.getEnumerationValues() != null;
    }
    
    private ConversionError getEnum(DataElement dataElement, String value) {
        ConversionError conversionError = new ConversionError();
        Map<String, String> enumValues = getEnumMap(dataElement);
        String str = enumValues.get(canonicalSearchString(value));
        if (str != null)
            conversionError.setInputValue(str);
        else {
            conversionError.setErrorCode("Data value must be one of " + dataElement.getEnumerationValues().replaceAll("\\|", ", "));
            conversionError.setErrorMsg("Can't convert '" + value + "' to MISMO enumeration");
        }
        return conversionError;
    }
    
    private Map<String, String> getEnumMap(DataElement dataElement) {
        HashMap<String, String> enumMap = new HashMap<String, String>();
        List<String> entries = Arrays.asList(dataElement.getEnumerationValues().split("\\|"));
        for (String entry : entries) {
            int index = entry.indexOf('>');
            if (index == -1)
                enumMap.put(canonicalSearchString(entry), entry);
            else
                enumMap.put(canonicalSearchString(entry.substring(0, index)), entry.substring(index+1));
        }
        return enumMap;
    }
    
    private String canonicalSearchString(String str) {
        return str.replaceAll("\\s", "").toUpperCase();
    }

}
