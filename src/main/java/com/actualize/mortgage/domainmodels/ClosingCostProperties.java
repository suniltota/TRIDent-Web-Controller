package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class ClosingCostProperties implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 943579811603225142L;
	
		private String displayLabel;
		private String feeType; 
		private String bpAtClosing;
		private String bpB4Closing;
		private String spAtClosing;
		private String spB4Closing;
		private String paidByOthers;
		private String toEntity;
		
		/**
		 * @return the feeType
		 */
		public String getFeeType() {
			return feeType;
		}
		/**
		 * @param feeType the feeType to set
		 */
		public void setFeeType(String feeType) {
			this.feeType = feeType;
		}
		/**
		 * @return the bpAtClosing
		 */
		public String getBpAtClosing() {
			return bpAtClosing;
		}
		/**
		 * @param bpAtClosing the bpAtClosing to set
		 */
		public void setBpAtClosing(String bpAtClosing) {
			this.bpAtClosing = bpAtClosing;
		}
		/**
		 * @return the bpB4Closing
		 */
		public String getBpB4Closing() {
			return bpB4Closing;
		}
		/**
		 * @param bpB4Closing the bpB4Closing to set
		 */
		public void setBpB4Closing(String bpB4Closing) {
			this.bpB4Closing = bpB4Closing;
		}
		/**
		 * @return the spAtClosing
		 */
		public String getSpAtClosing() {
			return spAtClosing;
		}
		/**
		 * @param spAtClosing the spAtClosing to set
		 */
		public void setSpAtClosing(String spAtClosing) {
			this.spAtClosing = spAtClosing;
		}
		/**
		 * @return the spB4Closing
		 */
		public String getSpB4Closing() {
			return spB4Closing;
		}
		/**
		 * @param spB4Closing the spB4Closing to set
		 */
		public void setSpB4Closing(String spB4Closing) {
			this.spB4Closing = spB4Closing;
		}
		/**
		 * @return the paidByOthers
		 */
		public String getPaidByOthers() {
			return paidByOthers;
		}
		/**
		 * @param paidByOthers the paidByOthers to set
		 */
		public void setPaidByOthers(String paidByOthers) {
			this.paidByOthers = paidByOthers;
		}
		/**
		 * @return the toEntity
		 */
		public String getToEntity() {
			return toEntity;
		}
		/**
		 * @param toEntity the toEntity to set
		 */
		public void setToEntity(String toEntity) {
			this.toEntity = toEntity;
		}
		public String getDisplayLabel() {
			return displayLabel;
		}
		public void setDisplayLabel(String displayLabel) {
			this.displayLabel = displayLabel;
		}
		

}
