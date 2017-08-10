/**
 * 
 */
package com.actualize.mortgage.datamodels;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author sboragala
 *
 */
@Entity
@Table(name="useractivity")
public class UserActivityEntity implements Serializable {


	private static final long serialVersionUID = 7442229687570970827L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")	
	private String useractivityId;
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private UserDetailsEntity userDetails;
	private String loanId;
	private String serviceUtilized;
	private String responseStatus;
	private String requestStartTime;
	private String timeLapsedForRequest;
	private Long requestSize;
	private Long responseSize;
	@Column(name="creationDate", updatable=false, insertable=false)
	private Date creationDate;
	@Column(name="modificationDate", updatable=false, insertable=false)
	private Date modificationDate;
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
	 * @return the userDetails
	 */
	public UserDetailsEntity getUserDetails() {
		return userDetails;
	}
	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDetailsEntity userDetails) {
		this.userDetails = userDetails;
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
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the modificationDate
	 */
	public Date getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	
}
