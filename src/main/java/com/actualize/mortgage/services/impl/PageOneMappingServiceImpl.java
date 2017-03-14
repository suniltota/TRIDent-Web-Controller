package com.actualize.mortgage.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.mismo.residential._2009.schemas.ADDRESS;
import org.mismo.residential._2009.schemas.AddressBase;
import org.mismo.residential._2009.schemas.AddressUnitDesignatorBase;
import org.mismo.residential._2009.schemas.COLLATERAL;
import org.mismo.residential._2009.schemas.DEAL;
import org.mismo.residential._2009.schemas.DOCUMENT;
import org.mismo.residential._2009.schemas.LoanPurposeBase;
import org.mismo.residential._2009.schemas.PARTY;
import org.mismo.residential._2009.schemas.PartyRoleBase;

import com.actualize.mortgage.domainmodels.Address;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.PDFDocument;
import com.actualize.mortgage.services.PageOneMappingService;

public class PageOneMappingServiceImpl  implements PageOneMappingService{

	@Override
	public DOCUMENT mapClosingInformation(DOCUMENT document, PDFDocument pdfDocument) {
		
		ClosingInformation closingInformation = pdfDocument.getPageOne().getClosingInformation();
		String dateIssued = closingInformation.getDateIssued();
		String closingDate = closingInformation.getClosingDate();
		String disbursementDate = closingInformation.getDisbursementDate();
		String settlementAgent = closingInformation.getSettlementAgent();
		String fileNo = closingInformation.getFileNo();
		ADDRESS mismoAddress = new ADDRESS(); 
		Address jsonAddress = closingInformation.getProperty(); 
		
		DEAL deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		deal = document.getDEALSETS().getDEALSET().getDEALS().getDEAL();
		
		deal.getLOANS().getLOAN().getDOCUMENTSPECIFICDATASETS().getDOCUMENTSPECIFICDATASET().getINTEGRATEDDISCLOSURE().getINTEGRATEDDISCLOSUREDETAIL().getIntegratedDisclosureIssuedDate().setValue(dateIssued);
		deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getClosingDate().setValue(closingDate);
		deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getDisbursementDate().setValue(disbursementDate);
		deal.getLOANS().getLOAN().getCLOSINGINFORMATION().getCLOSINGINFORMATIONDETAIL().getClosingAgentOrderNumberIdentifier().setValue(fileNo);
		
		List<COLLATERAL> collaterals = deal.getCOLLATERALS().getCOLLATERAL();
		for(COLLATERAL collateral : collaterals)
		{
			 mismoAddress = collateral.getSUBJECTPROPERTY().getADDRESS();
			 
			if(null != mismoAddress)
			{
				mismoAddress.getAddressLineText().setValue(jsonAddress.getAddressLineText()== null ? "" : jsonAddress.getAddressLineText());
				mismoAddress.getAddressType().setValue(jsonAddress.getAddressType() == null ? AddressBase.fromValue("null") : AddressBase.fromValue(jsonAddress.getAddressType()));
				mismoAddress.getAddressUnitDesignatorType().setValue(jsonAddress.getAddressUnitDesignatorType()== null ? AddressUnitDesignatorBase.fromValue("null") : AddressUnitDesignatorBase.fromValue(jsonAddress.getAddressUnitDesignatorType()));
				mismoAddress.getAddressUnitIdentifier().setValue(mismoAddress.getAddressUnitIdentifier()== null ? "" :jsonAddress.getAddressUnitDesignatorType());
				mismoAddress.getCityName().setValue(jsonAddress.getCityName()== null ? "" : jsonAddress.getCityName());
				mismoAddress.getCountryCode().setValue((jsonAddress.getCountryCode()== null ? "" :jsonAddress.getCountryCode()));
				mismoAddress.getPostalCode().setValue(jsonAddress.getPostalCode()== null ? "" :jsonAddress.getPostalCode());
				mismoAddress.getStateCode().setValue(jsonAddress.getStateCode()== null ? "" :jsonAddress.getStateCode());
				
			}
			
		}
		
		List<PARTY> parties = deal.getPARTIES().getPARTY();
		parties.forEach(party ->{
			if(null != party.getROLES())
			{
				if(null != party.getROLES().getROLE().getROLEDETAIL())
					if(PartyRoleBase.CLOSING_AGENT == party.getROLES().getROLE().getROLEDETAIL().getPartyRoleType().getValue())
						party.getLEGALENTITY().getLEGALENTITYDETAIL().getFullName().setValue(settlementAgent);
			}
		});
		
		
		
		
		if(LoanPurposeBase.PURCHASE == deal.getLOANS().getLOAN().getTERMSOFLOAN().getLoanPurposeType().getValue())
		{
			collaterals.forEach(collateral ->{
				collateral.getSUBJECTPROPERTY().getSALESCONTRACTS().getSALESCONTRACT().getSALESCONTRACTDETAIL().getSalesContractAmount().setValue(new BigDecimal(closingInformation.getSalePrice()));
			});
		}
		
		document.getDEALSETS().getDEALSET().getDEALS().setDEAL(deal);
		return document;
	}

	@Override
	public DOCUMENT mapLoanInformation(DOCUMENT document, PDFDocument pdfDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DOCUMENT mapTransactionInformation(DOCUMENT document, PDFDocument pdfDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DOCUMENT mapLoanTerms(DOCUMENT document, PDFDocument pdfDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DOCUMENT mapProjectedPayments(DOCUMENT document, PDFDocument pdfDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DOCUMENT mapCostsAtClosing(DOCUMENT document, PDFDocument pdfDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
