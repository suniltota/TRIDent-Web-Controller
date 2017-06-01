/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * this class defines Individual while creating XML from JSON Object
 * @author sboragala
 *
 */
public class MismoIndividualModel implements Serializable {
	
	private static final long serialVersionUID = 4173366077018893391L;
	
	private NameModel name;
	private List<MismoContactPointsModel> contactPoints = new LinkedList<>();
	
	/**
	 * @return the name
	 */
	public NameModel getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(NameModel name) {
		this.name = name;
	}
	/**
	 * @return the contactPoints
	 */
	public List<MismoContactPointsModel> getContactPoints() {
		return contactPoints;
	}
	/**
	 * @param contactPoints the contactPoints to set
	 */
	public void setContactPoints(List<MismoContactPointsModel> contactPoints) {
		this.contactPoints = contactPoints;
	}
	

}
