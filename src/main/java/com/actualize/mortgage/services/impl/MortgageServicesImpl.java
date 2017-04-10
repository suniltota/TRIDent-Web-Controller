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

import org.mismo.residential._2009.schemas.ADDRESS;
import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.MESSAGE;
import org.mismo.residential._2009.schemas.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;

import com.actualize.mortgage.domainmodels.Address;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.ConversionError;
import com.actualize.mortgage.domainmodels.CostsAtClosing;
import com.actualize.mortgage.domainmodels.DataElement;
import com.actualize.mortgage.domainmodels.IntermediateXMLData;
import com.actualize.mortgage.domainmodels.Lender;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.ClosingDisclosureDocument;
import com.actualize.mortgage.domainmodels.PageOne;
import com.actualize.mortgage.domainmodels.PageThree;
import com.actualize.mortgage.domainmodels.PageTwo;
import com.actualize.mortgage.domainmodels.ProjectedPayments;
import com.actualize.mortgage.domainmodels.Seller;
import com.actualize.mortgage.domainmodels.TransactionInformation;
import com.actualize.mortgage.services.MortgageServices;
import com.actualize.mortgage.services.PageOneMappingService;
import com.actualize.mortgage.services.PageOneService;
import com.actualize.mortgage.services.PageThreeService;
import com.actualize.mortgage.services.PageTwoService;
import com.actualize.mortgage.utils.Convertor;
import com.actualize.mortgage.utils.DocumentType;
import com.actualize.mortgage.utils.OutputFormatter;

import transformer.TRIDTransformer;
import ucdutils.UCDArcRolesParty;
import ucdutils.UCDArcRolesSignatory;
import xmlutils.Utils;

public class MortgageServicesImpl implements MortgageServices{
	
    List<ConversionError> conversionErrorList = null;
	DEAL deal = null;
	Address property = new Address();
	ADDRESS address = new ADDRESS();
	Convertor convertor = new Convertor();
	ClosingInformation closingInformation = new ClosingInformation();
	TransactionInformation transactionInformation = new TransactionInformation();
	LoanInformation loanInformation = new LoanInformation();
	DocumentType documentType = new DocumentType();
	
	List<Borrower> borrowers = new LinkedList<>();
	List<Seller> sellers = new LinkedList<>();
	List<Lender> lenders = new LinkedList<>();
	
	
	@Autowired
	private PageOneService pageOneService;
	
	@Autowired
	private PageTwoService pageTwoService;
	
	@Autowired
	private PageThreeService pageThreeService;
	
	@Autowired
	private PageOneMappingService pageOneMappingService;
	
	@Override
	public DocumentType documentDetail(DOCUMENT document) throws Exception {
		DocumentType documentType = new DocumentType();
			documentType.setStandardView(DocumentType.isStandardView(document));
			documentType.setLoanType(documentType.getLoanType(document));
			documentType.setAlternateView(DocumentType.isAlternateView(document));
			documentType.setHomeEquityLoanIndicator(DocumentType.HomeEquityLoanIndicator());
			documentType.setPayoffsAndPayments(DocumentType.PayoffsAndPayments());
			documentType.setRefinanceTypeLoan(DocumentType.isRefinanceTypeLoan(document));
			documentType.setSellerOnly(DocumentType.isSellerOnly(document));
			documentType.setLoanId(documentType.getLoanIdentifier(document));
		return documentType;
	}
	
	@Override
	public PageOne populatePageOne(DOCUMENT document) throws Exception {
		
		
		ClosingInformation closingInformation = new ClosingInformation();
		TransactionInformation transactionInformation = new TransactionInformation();
		LoanInformation loanInformation = new LoanInformation();
		LoanTerms loanTerms = new LoanTerms();
		ProjectedPayments projectedPayments = new ProjectedPayments();
		CostsAtClosing costsAtClosing = new CostsAtClosing();
		
		closingInformation = pageOneService.createClosingInformation(document);
		transactionInformation = pageOneService.createTransactionInformation(document);
		loanInformation = pageOneService.createLoanInformation(document);
		loanTerms = pageOneService.createLoanTerms(document);
		projectedPayments = pageOneService.createProjectedPayments(document);
		costsAtClosing = pageOneService.createCostsAtClosing(document);
				
		PageOne pageOne = new PageOne();
		
			pageOne.setClosingInformation(closingInformation);
			pageOne.setTransactionInformation(transactionInformation);
			pageOne.setLoanInformation(loanInformation);
			pageOne.setLoanTerms(loanTerms);
			pageOne.setProjectedPayments(projectedPayments);
			pageOne.setCostsAtClosing(costsAtClosing);
		
		return pageOne;
	}

	@Override
	public List<ClosingDisclosureDocument> createDocument(MESSAGE message) throws Exception {
		List<ClosingDisclosureDocument> pdfDocuments = new ArrayList<>();
		List<DOCUMENT> documents = message.getDOCUMENTSETS().getDOCUMENTSET().getDOCUMENTS().getDOCUMENT();
			
		for(DOCUMENT document : documents)
		{
			ClosingDisclosureDocument pdfDocument = new ClosingDisclosureDocument();
			DocumentType documentType = new DocumentType();
			PageOne pageOne = new PageOne();
			PageTwo pageTwo = new PageTwo();
			documentType = documentDetail(document);
			documentType.setAboutVersionIdentifier(DocumentType.getAboutVersionIdentifier(message));
			pageOne = populatePageOne(document);
			pageTwo = populatePageTwo(document);
			pdfDocument.setDocumentType(documentType);
			pdfDocument.setPageOne(pageOne);
			pdfDocument.setPageTwo(pageTwo);
			pdfDocument.setPageThree(populatePageThree(document));
			pdfDocuments.add(pdfDocument);
		}
		return pdfDocuments;
	}

	@Override
	public PageTwo populatePageTwo(DOCUMENT document) throws Exception {
		PageTwo pageTwo = new PageTwo();
		ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts = new ClosingCostDetailsLoanCosts();
		ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts = new ClosingCostDetailsOtherCosts();
		
		closingCostDetailsLoanCosts = pageTwoService.createClosingCostDetailsLoanCosts(document);
		closingCostDetailsOtherCosts = pageTwoService.createClosingCostDetailsOtherCosts(document);
		
		pageTwo.setClosingCostDetailsLoanCosts(closingCostDetailsLoanCosts);
		pageTwo.setClosingCostDetailsOtherCosts(closingCostDetailsOtherCosts);
		
		return pageTwo;
	}

    @Override
    public MESSAGE updateMismoObject(MESSAGE currentXMLObject, ClosingDisclosureDocument modifiedJSONObject) throws Exception {

        MESSAGE message = currentXMLObject;
        List<DOCUMENT> documents = currentXMLObject.getDOCUMENTSETS().getDOCUMENTSET().getDOCUMENTS().getDOCUMENT();
        for (DOCUMENT document : documents) {
            document = pageOneMappingService.mapClosingInformation(document, modifiedJSONObject);
            document = pageOneMappingService.mapLoanInformation(document, modifiedJSONObject);
            document = pageOneMappingService.mapTransactionInformation(document, modifiedJSONObject);
            document = pageOneMappingService.mapLoanTerms(document, modifiedJSONObject);
            document = pageOneMappingService.mapProjectedPayments(document, modifiedJSONObject);
            document = pageOneMappingService.mapCostsAtClosing(document, modifiedJSONObject);
        }
        return message;
    }
	
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

	@Override
	public PageThree populatePageThree(DOCUMENT document) throws Exception {
		
		PageThree pageThree = new PageThree();
		pageThree.setCashToCloses(pageThreeService.createCalculatingCashtoClose(document));
		if(!DocumentType.isAlternateView(document))
			pageThree.setSummariesofTransactions(pageThreeService.createSummariesofTransactions(document));
		return pageThree;
	}

}
