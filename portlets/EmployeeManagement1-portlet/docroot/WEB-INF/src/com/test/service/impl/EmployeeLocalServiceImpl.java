/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.test.service.impl;

import com.knowarth.employee.customExceptions.*;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.test.NoSuchEmployeeException;
import com.test.model.Employee;
import com.test.service.EmployeeLocalServiceUtil;
import com.test.service.base.EmployeeLocalServiceBaseImpl;
import com.test.service.persistence.EmployeeFinderUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.test.service.EmployeeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author rashmin.mishra
 * @see com.test.service.base.EmployeeLocalServiceBaseImpl
 * @see com.test.service.EmployeeLocalServiceUtil
 */
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.test.service.EmployeeLocalServiceUtil} to access the employee local service.
	 */

	private  static Logger log=Logger.getLogger(EmployeeLocalServiceImpl.class);

	public Employee saveEmployee(Employee emp) throws EmailIdAlreadyExistsException,InvalidDateException,SystemException {

		String emailId=emp.getEmailId();
		long employeeId=emp.getEmployeeId();
		log.info("emp id here" +employeeId);
		Calendar cal=Calendar.getInstance();
		int currentYear=cal.get(Calendar.YEAR);
		Date birthDate=emp.getBirthDate();
		cal.setTime(birthDate);
		int birthYear=cal.get(Calendar.YEAR);
		Date joiningDate=emp.getJoiningDate();
		cal.setTime(joiningDate);
		int joiningYear=cal.get(Calendar.YEAR);
		int diff=joiningYear-birthYear;
		if(diff<20||joiningYear>currentYear||currentYear-birthYear>60) { 
			throw new InvalidDateException("Invalid date entered");
		} if(Validator.isNotNull(employeeId)) {
			List<Employee> employeeRecord=getEmployeeRecordByemailId(employeeId, emailId);
			if(employeeRecord.size()==0) {
				try {
					return updateEmployee(emp);
				} catch (SystemException e) {
					log.error("error occured" +e);
				}
			} else {
				throw new EmailIdAlreadyExistsException("already registered");
			}
		} else {
			try {
				Employee employee=getEmployeeByEmail(emailId);
				if(Validator.isNotNull(employee)) {
					throw new EmailIdAlreadyExistsException("you have already register");
				} else {
					return addEmployee(emp);
				}
			} catch (SystemException e) {
				log.error("error while " +e);	
				throw e;
			}
		}
		return null;
	}

	public Employee getEmployeeByEmail(String emailId) 
	{
		try {
			return employeePersistence.findByemailId(emailId);
		} catch (NoSuchEmployeeException e) {
			log.error("error while" +e);
		} catch (SystemException e) {
			log.error("error while" +e);
		}
		return null;
	}

	public List<Employee> getEmployeeRecordByemailId(long employeeId, String emailId)
	{
		return EmployeeFinderUtil.getEmployeeByEmailId(employeeId, emailId);
	}
}