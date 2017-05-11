package com.actualize.mortgage.ledatamodels;

import java.io.Serializable;
import java.util.List;

import com.actualize.mortgage.domainmodels.ClosingAdjustmentItemModel;
import com.actualize.mortgage.domainmodels.LiabilityModel;

/**
 *  defines PayoffsAndPayments in JSON response
 * @author sboragala
 *
 */
public class PayoffsAndPayments implements Serializable {


	private static final long serialVersionUID = 422836147116062115L;

	List<LiabilityModel> liabilitiesList;
	List<ClosingAdjustmentItemModel> closingAdjustmentItemList;
	
	/**
	 * @return the liabilitiesList
	 */
	public List<LiabilityModel> getLiabilitiesList() {
		return liabilitiesList;
	}
	/**
	 * @param liabilitiesList the liabilitiesList to set
	 */
	public void setLiabilitiesList(List<LiabilityModel> liabilitiesList) {
		this.liabilitiesList = liabilitiesList;
	}
	/**
	 * @return the closingAdjustmentItemList
	 */
	public List<ClosingAdjustmentItemModel> getClosingAdjustmentItemList() {
		return closingAdjustmentItemList;
	}
	/**
	 * @param closingAdjustmentItemList the closingAdjustmentItemList to set
	 */
	public void setClosingAdjustmentItemList(List<ClosingAdjustmentItemModel> closingAdjustmentItemList) {
		this.closingAdjustmentItemList = closingAdjustmentItemList;
	}
	
	
}
