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

package com.test.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Employee service. Represents a row in the &quot;Employee_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.test.model.impl.EmployeeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.test.model.impl.EmployeeImpl}.
 * </p>
 *
 * @author rashmin.mishra
 * @see Employee
 * @see com.test.model.impl.EmployeeImpl
 * @see com.test.model.impl.EmployeeModelImpl
 * @generated
 */
public interface EmployeeModel extends BaseModel<Employee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee model instance should use the {@link Employee} interface instead.
	 */

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee ID of this employee.
	 *
	 * @return the employee ID of this employee
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee.
	 *
	 * @param employeeId the employee ID of this employee
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the name of this employee.
	 *
	 * @return the name of this employee
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this employee.
	 *
	 * @param name the name of this employee
	 */
	public void setName(String name);

	/**
	 * Returns the age of this employee.
	 *
	 * @return the age of this employee
	 */
	public long getAge();

	/**
	 * Sets the age of this employee.
	 *
	 * @param age the age of this employee
	 */
	public void setAge(long age);

	/**
	 * Returns the birth date of this employee.
	 *
	 * @return the birth date of this employee
	 */
	public Date getBirthDate();

	/**
	 * Sets the birth date of this employee.
	 *
	 * @param birthDate the birth date of this employee
	 */
	public void setBirthDate(Date birthDate);

	/**
	 * Returns the joining date of this employee.
	 *
	 * @return the joining date of this employee
	 */
	public Date getJoiningDate();

	/**
	 * Sets the joining date of this employee.
	 *
	 * @param joiningDate the joining date of this employee
	 */
	public void setJoiningDate(Date joiningDate);

	/**
	 * Returns the department of this employee.
	 *
	 * @return the department of this employee
	 */
	@AutoEscape
	public String getDepartment();

	/**
	 * Sets the department of this employee.
	 *
	 * @param department the department of this employee
	 */
	public void setDepartment(String department);

	/**
	 * Returns the email ID of this employee.
	 *
	 * @return the email ID of this employee
	 */
	@AutoEscape
	public String getEmailId();

	/**
	 * Sets the email ID of this employee.
	 *
	 * @param emailId the email ID of this employee
	 */
	public void setEmailId(String emailId);

	/**
	 * Returns the country of this employee.
	 *
	 * @return the country of this employee
	 */
	@AutoEscape
	public String getCountry();

	/**
	 * Sets the country of this employee.
	 *
	 * @param country the country of this employee
	 */
	public void setCountry(String country);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.test.model.Employee employee);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.test.model.Employee> toCacheModel();

	@Override
	public com.test.model.Employee toEscapedModel();

	@Override
	public com.test.model.Employee toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}