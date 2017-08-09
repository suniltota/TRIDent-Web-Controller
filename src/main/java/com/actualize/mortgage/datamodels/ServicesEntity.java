/**
 * 
 */
package com.actualize.mortgage.datamodels;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author sboragala
 *
 */
@Entity
@Table(name="services")
public class ServicesEntity implements Serializable {


	private static final long serialVersionUID = -3482359323627070382L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String serviceId;
	private String serviceName;
	private String serviceDisplayName;
	private String serviceDescription;
	private Timestamp creationDate;
	private Timestamp modificationDate;

	/**
	 * @return the serviceId
	 */
	public String getServiceId() {
		return serviceId;
	}
	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}
	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return the serviceDisplayName
	 */
	public String getServiceDisplayName() {
		return serviceDisplayName;
	}
	/**
	 * @param serviceDisplayName the serviceDisplayName to set
	 */
	public void setServiceDisplayName(String serviceDisplayName) {
		this.serviceDisplayName = serviceDisplayName;
	}
	/**
	 * @return the serviceDescription
	 */
	public String getServiceDescription() {
		return serviceDescription;
	}
	/**
	 * @param serviceDescription the serviceDescription to set
	 */
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	/**
	 * @return the creationDate
	 */
	public Timestamp getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the modificationDate
	 */
	public Timestamp getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}


}
