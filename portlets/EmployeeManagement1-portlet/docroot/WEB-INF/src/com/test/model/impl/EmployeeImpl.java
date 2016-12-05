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

package com.test.model.impl;

import com.test.EmployeeConstants;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The extended model implementation for the Employee service. Represents a row in the &quot;Employee_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.test.model.Employee} interface.
 * </p>
 *
 * @author rashmin.mishra
 */
public class EmployeeImpl extends EmployeeBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a employee model instance should use the {@link com.test.model.Employee} interface instead.
	 */
	public EmployeeImpl() {
	}
	SimpleDateFormat dateFormat = new SimpleDateFormat(EmployeeConstants.EMPLOYEE_PARAM_DATE_FORMAT);
	String birthDate;
	String joiningDate;
	public void setEmployeeBirthDate(Date d)
	{
		birthDate=dateFormat.format(d);
	}
	public String getEmployeeBirthDate()
	{
		return birthDate;
	}
	public void setEmployeeJoiningDate(Date d)
	{	
		joiningDate=dateFormat.format(d);
	}
	public String getEmployeeJoiningDate()
	{
		return joiningDate;
	}
}