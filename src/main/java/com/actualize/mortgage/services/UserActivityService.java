/**
 * 
 */
package com.actualize.mortgage.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actualize.mortgage.domainmodels.UserActivityModel;
import com.actualize.mortgage.exceptions.ServiceException;

/**
 * @author sboragala
 *
 */

public interface UserActivityService {


	public UserActivityModel insertUserActivity(HttpServletRequest request, HttpServletResponse response, String loanId, String serviceName)
			throws ServiceException;

}
