/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * @author sboragala
 *
 */
public class UserActivityModel implements Serializable {

	private static final long serialVersionUID = 2234833233247172504L;
	private String useractivityId;
	private UserDetailsModel userDetailsModel;
	private String loanId;
	private String serviceUtilized;
	private String responseStatus;
	private String requestStartTime;
	private String timeLapsedForRequest;
	private Long requestSize;
	private Long responseSize;
	private String creationDate;
	private String modificationDate;
	/**
	 * @return the useractivityId
	 */
	public String getUseractivityId() {
		return useractivityId;
	}
	/**
	 * @param useractivityId the useractivityId to set
	 */
	public void setUseractivityId(String useractivityId) {
		this.useractivityId = useractivityId;
	}
	/**
	 * @return the userDetailsModel
	 */
	public UserDetailsModel getUserDetailsModel() {
		return userDetailsModel;
	}
	/**
	 * @param userDetailsModel the userDetailsModel to set
	 */
	public void setUserDetailsModel(UserDetailsModel userDetailsModel) {
		this.userDetailsModel = userDetailsModel;
	}
	/**
	 * @return the loanId
	 */
	public String getLoanId() {
		return loanId;
	}
	/**
	 * @param loanId the loanId to set
	 */
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	/**
	 * @return the serviceUtilized
	 */
	public String getServiceUtilized() {
		return serviceUtilized;
	}
	/**
	 * @param serviceUtilized the serviceUtilized to set
	 */
	public void setServiceUtilized(String serviceUtilized) {
		this.serviceUtilized = serviceUtilized;
	}
	/**
	 * @return the responseStatus
	 */
	public String getResponseStatus() {
		return responseStatus;
	}
	/**
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	/**
	 * @return the requestStartTime
	 */
	public String getRequestStartTime() {
		return requestStartTime;
	}
	/**
	 * @param requestStartTime the requestStartTime to set
	 */
	public void setRequestStartTime(String requestStartTime) {
		this.requestStartTime = requestStartTime;
	}
	/**
	 * @return the timeLapsedForRequest
	 */
	public String getTimeLapsedForRequest() {
		return timeLapsedForRequest;
	}
	/**
	 * @param timeLapsedForRequest the timeLapsedForRequest to set
	 */
	public void setTimeLapsedForRequest(String timeLapsedForRequest) {
		this.timeLapsedForRequest = timeLapsedForRequest;
	}
	/**
	 * @return the requestSize
	 */
	public Long getRequestSize() {
		return requestSize;
	}
	/**
	 * @param requestSize the requestSize to set
	 */
	public void setRequestSize(Long requestSize) {
		this.requestSize = requestSize;
	}
	/**
	 * @return the responseSize
	 */
	public Long getResponseSize() {
		return responseSize;
	}
	/**
	 * @param responseSize the responseSize to set
	 */
	public void setResponseSize(Long responseSize) {
		this.responseSize = responseSize;
	}
	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the modificationDate
	 */
	public String getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}


}
