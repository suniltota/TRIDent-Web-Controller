/**
 * 
 */
package com.actualize.mortgage.services.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actualize.mortgage.datamodels.UserActivityEntity;
import com.actualize.mortgage.domainmodels.UserActivityModel;
import com.actualize.mortgage.exceptions.ServiceException;
import com.actualize.mortgage.manager.UserActivityManager;
import com.actualize.mortgage.services.UserActivityService;
import com.actualize.mortgage.web.utils.Convertor;

/**
 * @author sboragala
 *
 */
@Service
public class UserActivityServiceImpl implements UserActivityService {

	@Autowired
	UserActivityManager userActivitymanagerImpl;

	@Autowired
	Convertor convertor;

	@Override
	public UserActivityModel insertUserActivity(HttpServletRequest request, HttpServletResponse response, String loanId, String serviceName)
			throws ServiceException {
		UserActivityEntity userActivityEntity = userActivitymanagerImpl.insertUserActivity(convertor.toUserActivityEntity(request, response, loanId, serviceName));

		return convertor.toUserActivityModel(userActivityEntity);
	}


}
