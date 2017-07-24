package com.actualize.mortgage.authentication.services.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.actualize.mortgage.cd.datamodels.Deal;
import com.actualize.mortgage.cd.datamodels.Document;
import com.actualize.mortgage.cd.datamodels.FeeSummaryDetail;
import com.actualize.mortgage.cd.datamodels.MISMODocument;
import com.actualize.mortgage.cd.datamodels.MaturityRule;
import com.actualize.mortgage.cd.datamodels.TermsOfLoan;
import com.actualize.mortgage.domainmodels.CalculationError;
import com.actualize.mortgage.domainmodels.LateChargeRuleModelUI;
import com.actualize.mortgage.domainmodels.LateChargeRuleObject;
import com.actualize.mortgage.domainmodels.LateChargeRuleUIObject;
import com.actualize.mortgage.domainmodels.LateRuleProperties;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.pdf.mismodao.Buydown;
import com.actualize.mortgage.pdf.mismodao.LoanDetail;
import com.actualize.mortgage.ucd.calculationutils.CalculationErrorType;

@Service
public class LateChargeRuleServiceImpl {

	 private static final String FILE_NAME = "/srv/LateChargeRuleConditions.xlsx";
	 private static final String MISMO_URL = "http://www.mismo.org/residential/2009/schemas";
	 private static final String GSE_URL = "http://www.datamodelextension.org";
	 
	 private XPath xpath = null;
	 private LinkedList<CalculationError> errors = new LinkedList<CalculationError>();

	 
	  public LateRuleProperties  findRange(String value)
	  {
		  value = value.replaceAll(" ", ""); 
		  
		  LateRuleProperties lateRuleProperties =  new LateRuleProperties();
		 if(value.contains("<=") || value.contains("=<"))
		 {
			 if(value.contains("<="))
				 value = value.replaceAll("<=", "");
			 else
				 value = value.replaceAll("=<", "");
			 
			 lateRuleProperties.setComparand("LessThanEqualTo");
			 lateRuleProperties.setUpperLimit(Double.parseDouble(value));
			 
			 return lateRuleProperties;
		 }
		 else if(value.contains("<"))
		 {
			 if(value.contains("<"))
				 value = value.replaceAll("<", "");
			 
			 lateRuleProperties.setComparand("LessThan");
			 lateRuleProperties.setUpperLimit(Double.parseDouble(value));
			 
			 return lateRuleProperties;
		 }
		 else if(value.contains(">=") || value.contains("=>"))
		 {
			 if(value.contains(">="))
				 value = value.replaceAll(">=", "");
			 else
				 value = value.replaceAll("=>", "");
			 
			 lateRuleProperties.setComparand("GreaterThanEqualTo");
			 lateRuleProperties.setUpperLimit(Double.parseDouble(value));
			 
			 return lateRuleProperties;
		 }
		 else if(value.contains(">"))
		 {
			 if(value.contains(">"))
				 value = value.replaceAll(">", "");
		 
			 lateRuleProperties.setComparand("GreaterThan");
			 lateRuleProperties.setUpperLimit(Double.parseDouble(value));
		 
			 return lateRuleProperties;
		 }
		 else if(value.contains("-"))
		 {
			 String[] values = value.split("-");
			 lateRuleProperties.setComparand("Range");
			 lateRuleProperties.setLowerLimit(Double.parseDouble(values[0]));
			 lateRuleProperties.setUpperLimit(Double.parseDouble(values[1]));
			 return lateRuleProperties;
		 }
		 else
		 {
			lateRuleProperties.setComparand("null");
			return lateRuleProperties;
		 }
		 
	  }
	 
	 
	 
	    @SuppressWarnings("deprecation")
	    public List<LateChargeRuleObject> readLateChangeRulePropertiesFromExcel() throws ServiceException{
	        try {

	            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	            Workbook workbook = new XSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator();
	            List<LateChargeRuleModelUI> lateChargeRuleModelUIs = new LinkedList<>();
	            
	            for(int i=1;i<datatypeSheet.getLastRowNum()+1; i++)
	            {
	            	
	            	LateChargeRuleModelUI lateChargeRuleModelUI = new LateChargeRuleModelUI();
	            	lateChargeRuleModelUI.setStateCode(datatypeSheet.getRow(i).getCell(0).getStringCellValue());
                	lateChargeRuleModelUI.setLienPriorityType(datatypeSheet.getRow(i).getCell(1).getStringCellValue());
                	lateChargeRuleModelUI.setNoteAmount(datatypeSheet.getRow(i).getCell(2).getStringCellValue());
                	lateChargeRuleModelUI.setLoanPurposeType(datatypeSheet.getRow(i).getCell(3).getStringCellValue());
                	lateChargeRuleModelUI.setLoanToValuePercent(datatypeSheet.getRow(i).getCell(4).getStringCellValue());
                	lateChargeRuleModelUI.setLoanMaturityPeriodCount(datatypeSheet.getRow(i).getCell(5).getStringCellValue());
                	lateChargeRuleModelUI.setAprPercent(datatypeSheet.getRow(i).getCell(6).getStringCellValue());
                	lateChargeRuleModelUI.setNoteRatePercent(datatypeSheet.getRow(i).getCell(7).getStringCellValue());
                	lateChargeRuleModelUI.setMortgageType(datatypeSheet.getRow(i).getCell(8).getStringCellValue());
                	
                	if(datatypeSheet.getRow(i).getCell(9).getCellTypeEnum() == CellType.STRING )
                		lateChargeRuleModelUI.setLateChargeGracePeriodDaysCount(datatypeSheet.getRow(i).getCell(9).getStringCellValue());
                	else if(datatypeSheet.getRow(i).getCell(9).getCellTypeEnum() == CellType.NUMERIC)
                		lateChargeRuleModelUI.setLateChargeGracePeriodDaysCount(String.valueOf(datatypeSheet.getRow(i).getCell(9).getNumericCellValue()));
                	
                	if(datatypeSheet.getRow(i).getCell(10).getCellTypeEnum() == CellType.STRING )
                		lateChargeRuleModelUI.setLateChargeRatePercent(datatypeSheet.getRow(i).getCell(10).getStringCellValue());
                	else if(datatypeSheet.getRow(i).getCell(10).getCellTypeEnum() == CellType.NUMERIC)
                		lateChargeRuleModelUI.setLateChargeRatePercent(String.valueOf(datatypeSheet.getRow(i).getCell(10).getNumericCellValue()));
                	
                	if(datatypeSheet.getRow(i).getCell(11).getCellTypeEnum() == CellType.STRING )
                		lateChargeRuleModelUI.setLateChargeMinimumAmount(datatypeSheet.getRow(i).getCell(11).getStringCellValue());
                	else if(datatypeSheet.getRow(i).getCell(11).getCellTypeEnum() == CellType.NUMERIC)
                		lateChargeRuleModelUI.setLateChargeMinimumAmount(String.valueOf(datatypeSheet.getRow(i).getCell(11).getNumericCellValue()));

                	
                	if(datatypeSheet.getRow(i).getCell(12).getCellTypeEnum() == CellType.STRING )
                		lateChargeRuleModelUI.setLateChargeMaximumAmount(datatypeSheet.getRow(i).getCell(12).getStringCellValue());
                	else if(datatypeSheet.getRow(i).getCell(12).getCellTypeEnum() == CellType.NUMERIC)
                		lateChargeRuleModelUI.setLateChargeMaximumAmount(String.valueOf(datatypeSheet.getRow(i).getCell(12).getNumericCellValue()));
	            	
                	lateChargeRuleModelUIs.add(lateChargeRuleModelUI);
	            }
	            LateChargeRuleServiceImpl lateChargeRuleServiceImpl = new LateChargeRuleServiceImpl();
	          return  lateChargeRuleServiceImpl.evaluateExcelProperties(lateChargeRuleModelUIs);

	        } catch (FileNotFoundException e) {
	           throw new ServiceException("Excel file with Name 'LateChargeRuleConditions.xlsx' not found in srv folder");
	        } catch (IOException e) {
	        	throw new ServiceException("Invalid excel or excel contains inappropriate data");
	        }
	    }
	    
	    public List<LateChargeRuleObject> evaluateExcelProperties(List<LateChargeRuleModelUI> lateChargeRuleModelUIs)
	    {
	    	List<LateChargeRuleObject> lateChargeRuleObjects = new LinkedList<>();
	    	lateChargeRuleModelUIs.stream().forEach(rule -> 
	    	{
	    		LateChargeRuleObject lateChargeRuleObject = new LateChargeRuleObject();
	    		LateRuleProperties noteAmount = findRange(rule.getNoteAmount());
	    		
	    		LateRuleProperties loanToValuePercent = findRange(rule.getLoanToValuePercent());
	    		LateRuleProperties loanMaturityPeriodCount = findRange(rule.getLoanMaturityPeriodCount());
	    		LateRuleProperties aprPercent = findRange(rule.getAprPercent());
	    		LateRuleProperties noteRatePercent = findRange(rule.getNoteRatePercent());
	    		
	    		lateChargeRuleObject.setStateCode(rule.getStateCode());
	    		lateChargeRuleObject.setLienPriorityType(rule.getLienPriorityType());
	    		lateChargeRuleObject.setNoteAmount(noteAmount);
	    		lateChargeRuleObject.setLoanPurpose(null == rule.getLoanPurposeType() ? "" : rule.getLoanPurposeType());
	    		lateChargeRuleObject.setLoanToValuePercent(loanToValuePercent);
	    		lateChargeRuleObject.setLoanMaturityPeriodCount(loanMaturityPeriodCount);
	    		lateChargeRuleObject.setAprPercent(aprPercent);
	    		lateChargeRuleObject.setNoteRatePercent(noteRatePercent);
	    		if(null != rule.getMortgageType())
	    			lateChargeRuleObject.setMortgageType(getMortgageTypes(rule.getMortgageType()));
	    		lateChargeRuleObject.setLateChargeGracePeriodDaysCount(rule.getLateChargeGracePeriodDaysCount());
	    		lateChargeRuleObject.setLateChargeRatePercent(rule.getLateChargeRatePercent());
	    		lateChargeRuleObject.setLateChargeMinimumAmount(rule.getLateChargeMinimumAmount());
	    		lateChargeRuleObject.setLateChargeMaximumAmount(rule.getLateChargeMaximumAmount());
	    		lateChargeRuleObjects.add(lateChargeRuleObject);
	    	});
	    	
	    	return lateChargeRuleObjects;
	    }

		private List<String> getMortgageTypes(String mortgageType) {
			
			List<String> mortgageTypes = new LinkedList<>();
			if(mortgageType.contains(","))
			{
				String[] types = mortgageType.split(",");
				
				for(int i=0; i< types.length; i++)
					mortgageTypes.add(types[i]);
			}
			else
				mortgageTypes.add(mortgageType);
			
			return mortgageTypes;
		}
	    
		private LateChargeRuleUIObject getValuesFromMISMO(InputStream inputXmlStream) throws ServiceException
		{
			LateChargeRuleUIObject lateChargeRuleUIObject = new LateChargeRuleUIObject();
			String noteRatePercent = "";
			try {
				MISMODocument mismodoc = new MISMODocument(inputXmlStream);
				 Document document = null;
			        NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
			        if (nodes.getLength() > 0)
			            document = new Document(Document.NS, (Element)nodes.item(0));
			        
			   Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));
			   TermsOfLoan loanTerm = new TermsOfLoan((Element)deal.getElementAddNS("LOANS/LOAN/TERMS_OF_LOAN"));
			   FeeSummaryDetail feeSummaryDetail = new FeeSummaryDetail((Element)deal.getElementAddNS("LOANS/LOAN/FEE_INFORMATION/FEES_SUMMARY/FEE_SUMMARY_DETAIL"));
			   MaturityRule maturityRule = new MaturityRule((Element)deal.getElementAddNS("LOANS/LOAN/MATURITY/MATURITY_RULE"));
			   LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS("LOANS/LOAN/LOAN_DETAIL"));
			   Buydown buydownRule = new Buydown(null, (Element)deal.getElementAddNS("LOANS/LOAN/BUYDOWN/BUYDOWN_RULE"));
			   String stateCode = deal.getValueAddNS("COLLATERALS/COLLATERAL/SUBJECT_PROPERTY/ADDRESS/StateCode");
			   
			   if (buydownRule.buydownRule.extension.other.buydownReflectedInNoteIndicator.equalsIgnoreCase("true")) {
				   noteRatePercent = buydownRule.buydownOccurences.buydownOccurences[0].BuydownInitialEffectiveInterestRatePercent;
				} else if(!loanTerm.disclosedFullyIndexedRatePercent.equals("")) {
					noteRatePercent = loanTerm.disclosedFullyIndexedRatePercent;
				} else if (!loanTerm.weightedAverageInterestRatePercent.equals("")) {
					noteRatePercent = loanTerm.weightedAverageInterestRatePercent;
				} else {
					noteRatePercent = loanTerm.noteRatePercent;
				}
			   
			   
			   
			   if(null == stateCode || stateCode.isEmpty())
				   throw new ServiceException("Required field stateCode is missing in SUBJECT_PROPERTY");
			   
			   if(null == loanTerm.lienPriorityType || loanTerm.lienPriorityType.isEmpty())
				   throw new ServiceException("Required field lienPriorityType is missing in LOAN_TERMS");
			   
			   if(null == loanTerm.mortgageType || loanTerm.mortgageType.isEmpty())
				   throw new ServiceException("Required field mortgageType is missing in LOAN_TERMS");

			   lateChargeRuleUIObject.setAprPercent(feeSummaryDetail.aprPercent);
			   lateChargeRuleUIObject.setLienPriorityType(loanTerm.lienPriorityType);
			   lateChargeRuleUIObject.setLoanMaturityPeriodCount(maturityRule.loanMaturityPeriodCount);
			   lateChargeRuleUIObject.setLoanPurpose(loanTerm.loanPurposeType);
			  // lateChargeRuleUIObject.setLoanToValuePercent(loanTerms.);
			   lateChargeRuleUIObject.setMortgageType(loanTerm.mortgageType);
			   lateChargeRuleUIObject.setNoteAmount(loanTerm.noteAmount);
			   lateChargeRuleUIObject.setNoteRatePercent(noteRatePercent);
			   lateChargeRuleUIObject.setStateCode(stateCode);
			   
			} catch (ParserConfigurationException | SAXException | IOException e) {
				 new ServiceException("Invalid or not well formmatted MISMO xml");
			}
			  
			return lateChargeRuleUIObject; 
			  
		}
		
		public String calculateLateChargeRule(String mismoString) throws ServiceException, TransformerException
		
		{
			InputStream inputXmlStream = new ByteArrayInputStream(mismoString.getBytes(StandardCharsets.UTF_8));
			
			org.w3c.dom.Document doc =  updateDocumentWithLateChargeRule(mismoString, getLateChargeRuleValues(readLateChangeRulePropertiesFromExcel(), getValuesFromMISMO(inputXmlStream)));
			
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			
		        tr.setOutputProperty(OutputKeys.INDENT, "yes");
		        tr.setOutputProperty(OutputKeys.METHOD, "xml");
		        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		        StreamResult result = new StreamResult(new StringWriter());
	        	tr.transform(new DOMSource(doc), result);
	        
	        return result.getWriter().toString();
			
		}
	    
		
		private LateChargeRuleObject getLateChargeRuleValues(List<LateChargeRuleObject> lateChargeRuleObjects, LateChargeRuleUIObject lateChargeRuleUIObject) throws ServiceException
		{
			LateChargeRuleObject lateChargeRuleValues = new LateChargeRuleObject();
			List<LateChargeRuleObject> filteredLateChargeRuleObjects = new LinkedList<>();
			lateChargeRuleObjects.stream().forEach(rule ->{
				if(null != rule.getStateCode() && lateChargeRuleUIObject.getStateCode().equalsIgnoreCase(rule.getStateCode()))
					if(null != rule.getLienPriorityType() && lateChargeRuleUIObject.getLienPriorityType().equalsIgnoreCase(rule.getLienPriorityType()))
						if((null != rule.getLoanPurpose() && !rule.getLoanPurpose().isEmpty()) ? lateChargeRuleUIObject.getLoanPurpose().equalsIgnoreCase(rule.getLoanPurpose()) : true)
							if((null != rule.getMortgageType() || "SecondLien".equalsIgnoreCase(rule.getLienPriorityType())) ? rule.getMortgageType().contains(lateChargeRuleUIObject.getMortgageType()) : true)
								filteredLateChargeRuleObjects.add(rule);
			});
			
			if(filteredLateChargeRuleObjects.size() > 1)
			{
				List<LateChargeRuleObject> noteAmountList = calculateNoteAmount(filteredLateChargeRuleObjects, lateChargeRuleUIObject.getNoteAmount());
				if(checkSize(noteAmountList))
				{
					List<LateChargeRuleObject> loanToValuePercentList = calculateLoanToValue(noteAmountList, lateChargeRuleUIObject.getLoanToValuePercent());
					if(checkSize(loanToValuePercentList))
					{
						List<LateChargeRuleObject> loanMaturityPeriodCountList = calculateMaturityPeriod(loanToValuePercentList, lateChargeRuleUIObject.getLoanMaturityPeriodCount());
						if(checkSize(loanMaturityPeriodCountList))
						{
							List<LateChargeRuleObject> aprPercentList = calculateAprPercent(loanMaturityPeriodCountList, lateChargeRuleUIObject.getAprPercent());
							if(checkSize(aprPercentList))
							{
								List<LateChargeRuleObject> noteRatePercentList = calculateNoteRatePercent(loanMaturityPeriodCountList, lateChargeRuleUIObject.getAprPercent());
								if(checkSize(noteRatePercentList))
									throw new ServiceException("More than One result Found");
								else
									lateChargeRuleValues = noteRatePercentList.get(0);
							}
							else
								lateChargeRuleValues = aprPercentList.get(0);
						}
						else
							lateChargeRuleValues = loanMaturityPeriodCountList.get(0);		
					}
					else
						lateChargeRuleValues = loanToValuePercentList.get(0);	
				}
				else
					lateChargeRuleValues = noteAmountList.get(0);
			}
			else if(filteredLateChargeRuleObjects.size() == 1)
				lateChargeRuleValues = filteredLateChargeRuleObjects.get(0);
			else if(filteredLateChargeRuleObjects.isEmpty())
				throw new ServiceException("No Results Found");
				
			return	lateChargeRuleValues;	
				
		}
		
		boolean checkSize(List<LateChargeRuleObject> lateChargeRuleList) throws ServiceException
		{
			if(lateChargeRuleList.size() > 1)
				return true;
			else if(lateChargeRuleList.size() == 1)
				return false;
			else
				throw new ServiceException("unable to find appropriate values");
			
		}
		
		private org.w3c.dom.Document updateDocumentWithLateChargeRule(String xmldoc, LateChargeRuleObject lateChargeRuleObject ){
			 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        factory.setNamespaceAware(true);
		        DocumentBuilder builder = null;
		        org.w3c.dom.Document doc = null;
		            try {
						builder = factory.newDocumentBuilder();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
		            try {
						doc = builder.parse(new InputSource(new StringReader(xmldoc)));
						Node root = doc.getDocumentElement();
						xpath = createXPath(root);
						String mismo = xpath.getNamespaceContext().getPrefix(MISMO_URL);
						String gse = xpath.getNamespaceContext().getPrefix(GSE_URL);
						
						Node lateChargeRules = constructNodePath(root, addNamespace("//mismo:LOAN/mismo:LATE_CHARGE/mismo:EXTENSION/mismo:OTHER/gse:LATE_CHARGE_RULES", ""));
						if (lateChargeRules == null)
							errors.add(new CalculationError(CalculationErrorType.INTERNAL_ERROR, "required container 'LOAN' is missing and can't be added"));
						Node lateChargeRule = replaceNode(doc, lateChargeRules, addNamespace("LATE_CHARGE_RULE", gse));
						lateChargeRule.appendChild(doc.createElement(addNamespace("LateChargeGracePeriodDaysCount", gse))).appendChild(doc.createTextNode(null == lateChargeRuleObject.getLateChargeGracePeriodDaysCount() ? "" : lateChargeRuleObject.getLateChargeGracePeriodDaysCount()));
						lateChargeRule.appendChild(doc.createElement(addNamespace("LateChargeRatePercent", gse))).appendChild(doc.createTextNode(null == lateChargeRuleObject.getLateChargeRatePercent() ? "" : String.format("%.5g", Double.parseDouble(lateChargeRuleObject.getLateChargeRatePercent())*100)));
						lateChargeRule.appendChild(doc.createElement(addNamespace("LateChargeMinimumAmount", gse))).appendChild(doc.createTextNode(null == lateChargeRuleObject.getLateChargeMinimumAmount() ? "" : lateChargeRuleObject.getLateChargeMinimumAmount()));
						lateChargeRule.appendChild(doc.createElement(addNamespace("LateChargeMaxmimumAmount", gse))).appendChild(doc.createTextNode(null == lateChargeRuleObject.getLateChargeMaximumAmount() ? "" : lateChargeRuleObject.getLateChargeMaximumAmount()));
												
					} catch (SAXException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		       return doc;     
		}
		
		private List<LateChargeRuleObject> calculateNoteAmount(List<LateChargeRuleObject> filteredLateChargeRuleObjects, String noteAmount) throws ServiceException
		{
			if(null != noteAmount && !noteAmount.isEmpty()){
				double amount;
				
				List<LateRuleProperties> lateRulePropertiesList = new LinkedList<>();
				List<LateChargeRuleObject> filteredLateChargeRuleNoteAmountList = new LinkedList<>();
				try {
					 amount = Double.parseDouble(noteAmount);
				}
				catch(NumberFormatException e)
				{
					throw new ServiceException("noteAmount in not a valid number"); 
				}
				
				for(LateChargeRuleObject rule : filteredLateChargeRuleObjects){
						lateRulePropertiesList.addAll(comparision(rule.getNoteAmount(), amount));
				}
				
				for(LateChargeRuleObject rule: filteredLateChargeRuleObjects ){
					if(!rule.getNoteAmount().getComparand().equalsIgnoreCase("null"))
					{	
						for(LateRuleProperties ruleProperty: lateRulePropertiesList)
						{
							if(ruleProperty.getComparand().equalsIgnoreCase(rule.getNoteAmount().getComparand()))
								filteredLateChargeRuleNoteAmountList.add(rule);
						}
					}
					else
						filteredLateChargeRuleNoteAmountList.add(rule);
						
				}
				return filteredLateChargeRuleNoteAmountList;
			}
			return filteredLateChargeRuleObjects;
		}
		private List<LateChargeRuleObject> calculateLoanToValue(List<LateChargeRuleObject> filteredLateChargeRuleObjects, String loanToValue) throws ServiceException
		{
			if(null != loanToValue && !loanToValue.isEmpty() ){
				double amount;
				List<LateRuleProperties> lateRulePropertiesList = new LinkedList<>();
				List<LateChargeRuleObject> filteredLateChargeRuleNoteAmountList = new LinkedList<>();
				try {
					 amount = Double.parseDouble(loanToValue);
				}
				catch(NumberFormatException e)
				{
					throw new ServiceException("loanToValue in not a valid number"); 
				}
			
					for(LateChargeRuleObject rule : filteredLateChargeRuleObjects){
						if(!"null".equalsIgnoreCase(rule.getLoanToValuePercent().getComparand()))
							lateRulePropertiesList.addAll(comparision(rule.getLoanToValuePercent(), amount));
						else
							filteredLateChargeRuleNoteAmountList.add(rule);
					}
					
					for(LateChargeRuleObject rule: filteredLateChargeRuleObjects )
						for(LateRuleProperties ruleProperty: lateRulePropertiesList)
						{
							if(ruleProperty.getComparand().equalsIgnoreCase(rule.getLoanToValuePercent().getComparand()))
								filteredLateChargeRuleNoteAmountList.add(rule);
						}
				return filteredLateChargeRuleNoteAmountList;	
			}
			return filteredLateChargeRuleObjects; 
		}
		private List<LateChargeRuleObject> calculateMaturityPeriod(List<LateChargeRuleObject> filteredLateChargeRuleObjects, String maturityPeriod) throws ServiceException
		{
			if(null != maturityPeriod && !maturityPeriod.isEmpty()){
				double amount;
				List<LateRuleProperties> lateRulePropertiesList = new LinkedList<>();
				List<LateChargeRuleObject> filteredLateChargeRuleNoteAmountList = new LinkedList<>();
				try {
					 amount = Double.parseDouble(maturityPeriod);
				}
				catch(NumberFormatException e){
					throw new ServiceException("maturityPeriod in not a valid number"); 
				}
				
				for(LateChargeRuleObject rule : filteredLateChargeRuleObjects){
					if(!"null".equalsIgnoreCase(rule.getLoanMaturityPeriodCount().getComparand()))
						lateRulePropertiesList.addAll(comparision(rule.getLoanMaturityPeriodCount(), amount));
					else
						filteredLateChargeRuleNoteAmountList.add(rule);
					}
				
				for(LateChargeRuleObject rule: filteredLateChargeRuleObjects )
					for(LateRuleProperties ruleProperty: lateRulePropertiesList)
					{
						if(ruleProperty.getComparand().equalsIgnoreCase(rule.getLoanMaturityPeriodCount().getComparand()))
							filteredLateChargeRuleNoteAmountList.add(rule);
					}
			
				return filteredLateChargeRuleNoteAmountList;
			}
			return filteredLateChargeRuleObjects;
		}
		private List<LateChargeRuleObject> calculateAprPercent(List<LateChargeRuleObject> filteredLateChargeRuleObjects, String aprPercent) throws ServiceException
		{
			if(null != aprPercent && !aprPercent.isEmpty()){
				double amount;
				List<LateRuleProperties> lateRulePropertiesList = new LinkedList<>();
				List<LateChargeRuleObject> filteredLateChargeRuleNoteAmountList = new LinkedList<>();
				try {
					 amount = Double.parseDouble(aprPercent);
				}
				catch(NumberFormatException e){
					throw new ServiceException("apr Percent is not a valid number"); 
				}
				
				for(LateChargeRuleObject rule : filteredLateChargeRuleObjects){
					if(!"null".equalsIgnoreCase(rule.getAprPercent().getComparand()))
							lateRulePropertiesList.addAll(comparision(rule.getAprPercent(), amount));
					else
						filteredLateChargeRuleNoteAmountList.add(rule);
					}
				
				for(LateChargeRuleObject rule: filteredLateChargeRuleObjects )
					for(LateRuleProperties ruleProperty: lateRulePropertiesList)
					{
						if(ruleProperty.getComparand().equalsIgnoreCase(rule.getAprPercent().getComparand()))
							filteredLateChargeRuleNoteAmountList.add(rule);
					}
			
				return filteredLateChargeRuleNoteAmountList;
			}
			return filteredLateChargeRuleObjects;
		}
		private List<LateChargeRuleObject> calculateNoteRatePercent(List<LateChargeRuleObject> filteredLateChargeRuleObjects, String noteRatePercent) throws ServiceException
		{
			if(null != noteRatePercent && !noteRatePercent.isEmpty()){
				double amount;
				List<LateRuleProperties> lateRulePropertiesList = new LinkedList<>();
				List<LateChargeRuleObject> filteredLateChargeRuleNoteAmountList = new LinkedList<>();
				try {
					 amount = Double.parseDouble(noteRatePercent);
				}
				catch(NumberFormatException e){
					throw new ServiceException("Note Rate Percent is not a valid number"); 
				}
				
				for(LateChargeRuleObject rule : filteredLateChargeRuleObjects){
					if(!"null".equalsIgnoreCase(rule.getNoteRatePercent().getComparand()))
							lateRulePropertiesList.addAll(comparision(rule.getNoteRatePercent(), amount));
					else
						filteredLateChargeRuleNoteAmountList.add(rule);
					}
				
				for(LateChargeRuleObject rule: filteredLateChargeRuleObjects )
					for(LateRuleProperties ruleProperty: lateRulePropertiesList)
					{
						if(ruleProperty.getComparand().equalsIgnoreCase(rule.getNoteRatePercent().getComparand()))
							filteredLateChargeRuleNoteAmountList.add(rule);
					}
			
				return filteredLateChargeRuleNoteAmountList;
			}
			return filteredLateChargeRuleObjects;
		}
		private List<LateRuleProperties> comparision(LateRuleProperties lateRule, double value)
		{
			List<LateRuleProperties> lateRulePropertiesList = new LinkedList<>();
				
			if(lateRule.getUpperLimit() != 0.0 && value > lateRule.getUpperLimit() && "GreaterThan".equalsIgnoreCase(lateRule.getComparand()))
			{
				LateRuleProperties lateRuleProperties = new LateRuleProperties();
					lateRuleProperties.setComparand("GreaterThan");
					lateRulePropertiesList.add(lateRuleProperties);	
			}
			else if(lateRule.getUpperLimit() != 0.0 && value >= lateRule.getUpperLimit() && "GreaterThanEqualTo".equalsIgnoreCase(lateRule.getComparand()))
			{
				LateRuleProperties lateRuleProperties = new LateRuleProperties();
				lateRuleProperties.setComparand("GreaterThanEqualTo");
				lateRulePropertiesList.add(lateRuleProperties);	
			}
			
			if(lateRule.getUpperLimit() != 0.0  && value < lateRule.getUpperLimit() && "LessThan".equalsIgnoreCase(lateRule.getComparand()))
			{
				LateRuleProperties lateRuleProperties = new LateRuleProperties();
				lateRuleProperties.setComparand("LessThan");
				lateRulePropertiesList.add(lateRuleProperties);	
			}
			else if(lateRule.getUpperLimit() != 0.0  && value <= lateRule.getUpperLimit() && "LessThanEqualTo".equalsIgnoreCase(lateRule.getComparand()))
			{
				LateRuleProperties lateRuleProperties = new LateRuleProperties();
				lateRuleProperties.setComparand("LessThanEqualTo");
				lateRulePropertiesList.add(lateRuleProperties);	
			}
			
			if(lateRule.getUpperLimit() != 0.0  && value <= lateRule.getLowerLimit() && value >= lateRule.getUpperLimit() && "Range".equalsIgnoreCase(lateRule.getComparand()))
			{
				LateRuleProperties lateRuleProperties = new LateRuleProperties();
				lateRuleProperties.setComparand("Range");
				lateRulePropertiesList.add(lateRuleProperties);	
			}
			if("null".equalsIgnoreCase(lateRule.getComparand()))
			{
				LateRuleProperties lateRuleProperties = new LateRuleProperties();
				lateRuleProperties.setComparand("null");
				lateRulePropertiesList.add(lateRuleProperties);	
			}
	
			return lateRulePropertiesList;
			
		}
		
		private Node getNode(Node node, String expression) {
			NodeList nodeList = getNodeList(node, expression);
			if (nodeList.getLength() > 0)
				return nodeList.item(0);
			return null;
		}
		
		private NodeList getNodeList(Node node, String expression) {
			try {
				return (NodeList)xpath.evaluate(expression, node, XPathConstants.NODESET);
			} catch (XPathExpressionException e) {
				errors.add(new CalculationError(CalculationErrorType.INTERNAL_ERROR, "bad xpath expression '" + expression + "'"));
				return null;
			}
		}
		
		private Node constructNodePath(Node node, String nodePathToAdd) {
			String nodeName = "";
			String[] nodes = nodePathToAdd.split("/");
			for (int i = 0; i < nodes.length; i++)
				if ("".equals(nodes[i]))
					nodeName += "/";
				else {
					nodeName += nodes[i];
					Node n = getNode(node, nodeName);
					if (n == null)
						errors.add(new CalculationError(CalculationErrorType.INTERNAL_ERROR, "required container " + nodeName + " is missing and can't be inserted"));
					else
						return traverseContainerPath(n, Arrays.copyOfRange(nodes, i+1, nodes.length));
					break;
				}
			return null;
		}
		
		private Node traverseContainerPath(Node node, String[] nodesToAdd) {
			for (int i = 0; i < nodesToAdd.length; i++) {
				Node n = getNode(node, nodesToAdd[i]);
				if (n == null)
					return insertContainerPath(node, Arrays.copyOfRange(nodesToAdd, i, nodesToAdd.length));
				node = n;
			}
			return node;
		}
		
		private Node replaceNode(org.w3c.dom.Document doc, Node parent, String name) {
			Node oldNode = getNode(parent, name);
			Node newNode = doc.createElement(name);
			if (oldNode == null)
				return parent.insertBefore(newNode, findLocation(parent, name));
			parent.replaceChild(newNode, oldNode);
			return newNode;
		}
		
		private static Node findLocation(Node node, String child) {
			for (Node n = node.getFirstChild(); n != null; n = n.getNextSibling())
				if (child.compareTo(n.getNodeName()) < 0)
					return n;
			return null;
		}
		
		static private Node insertContainerPath(Node node, String[] nodesToAdd) {
			org.w3c.dom.Document doc = node.getOwnerDocument();
			Node newNode = doc.createElement(nodesToAdd[0]);
			node = node.insertBefore(newNode, findLocation(node, nodesToAdd[0]));
			for (int i = 1; i < nodesToAdd.length; i++)
				node = node.appendChild(doc.createElement(nodesToAdd[i]));
			return node;
		}
		
		private static XPath createXPath(Node root) {
			XPath xpath = XPathFactory.newInstance().newXPath();
			NamedNodeMap attributes = root.getAttributes();
			TreeMap<String, String> nsPrefixToURI = new TreeMap<String, String>();
			TreeMap<String, String> nsURIToPrefix = new TreeMap<String, String>();
			for (int i = 0; i < attributes.getLength(); i++) {
				Node attr = attributes.item(i);
				String prefix = attr.getNodeName();
				if (attr.getNodeType() == Node.ATTRIBUTE_NODE && prefix.startsWith("xmlns")) {
					prefix = prefix.indexOf(':')==-1 ? "" : prefix.substring(6);
					nsPrefixToURI.put(prefix, attr.getNodeValue());
					nsURIToPrefix.put(attr.getNodeValue(), prefix);
				}
			}
			xpath.setNamespaceContext(new NamespaceContext() {
				private TreeMap<String, String> toURI = nsPrefixToURI;
				private TreeMap<String, String> toPrefix = nsURIToPrefix;

				@Override
				public String getNamespaceURI(String prefix) {
					return toURI.get(prefix);
				}

				@Override
				public String getPrefix(String namespaceURI) {
					return toPrefix.get(namespaceURI);
				}

				@SuppressWarnings("rawtypes")
				@Override
				public Iterator getPrefixes(String namespaceURI) {
					throw new IllegalAccessError("Not implemented!");
				}
			});
			return xpath;
		}
		
		private static String addNamespace(String path, String namespace) {
			if ("".equals(namespace))
				return path;
			String[] outer = path.split("/");
			for (int i = 0; i < outer.length; i++) {
				String[] inner = outer[i].split("\\[");
				for (int j = 0; j < inner.length; j++)
					if (!"".equals(inner[j]) && inner[j].indexOf(':') == -1)
						inner[j] = namespace + ":" + inner[j];
				outer[i] = String.join("[", inner);
			}
			return String.join("/", outer);
		}

}
