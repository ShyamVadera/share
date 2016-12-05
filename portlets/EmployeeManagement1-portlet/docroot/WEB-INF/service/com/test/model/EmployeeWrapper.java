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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author rashmin.mishra
 * @see Employee
 * @generated
 */
public class EmployeeWrapper implements Employee, ModelWrapper<Employee> {
	public EmployeeWrapper(Employee employee) {
		_employee = employee;
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeId", getEmployeeId());
		attributes.put("name", getName());
		attributes.put("age", getAge());
		attributes.put("birthDate", getBirthDate());
		attributes.put("joiningDate", getJoiningDate());
		attributes.put("department", getDepartment());
		attributes.put("emailId", getEmailId());
		attributes.put("country", getCountry());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long age = (Long)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		Date joiningDate = (Date)attributes.get("joiningDate");

		if (joiningDate != null) {
			setJoiningDate(joiningDate);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}
	}

	/**
	* Returns the primary key of this employee.
	*
	* @return the primary key of this employee
	*/
	@Override
	public long getPrimaryKey() {
		return _employee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this employee.
	*
	* @param primaryKey the primary key of this employee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the employee ID of this employee.
	*
	* @return the employee ID of this employee
	*/
	@Override
	public long getEmployeeId() {
		return _employee.getEmployeeId();
	}

	/**
	* Sets the employee ID of this employee.
	*
	* @param employeeId the employee ID of this employee
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_employee.setEmployeeId(employeeId);
	}

	/**
	* Returns the name of this employee.
	*
	* @return the name of this employee
	*/
	@Override
	public java.lang.String getName() {
		return _employee.getName();
	}

	/**
	* Sets the name of this employee.
	*
	* @param name the name of this employee
	*/
	@Override
	public void setName(java.lang.String name) {
		_employee.setName(name);
	}

	/**
	* Returns the age of this employee.
	*
	* @return the age of this employee
	*/
	@Override
	public long getAge() {
		return _employee.getAge();
	}

	/**
	* Sets the age of this employee.
	*
	* @param age the age of this employee
	*/
	@Override
	public void setAge(long age) {
		_employee.setAge(age);
	}

	/**
	* Returns the birth date of this employee.
	*
	* @return the birth date of this employee
	*/
	@Override
	public java.util.Date getBirthDate() {
		return _employee.getBirthDate();
	}

	/**
	* Sets the birth date of this employee.
	*
	* @param birthDate the birth date of this employee
	*/
	@Override
	public void setBirthDate(java.util.Date birthDate) {
		_employee.setBirthDate(birthDate);
	}

	/**
	* Returns the joining date of this employee.
	*
	* @return the joining date of this employee
	*/
	@Override
	public java.util.Date getJoiningDate() {
		return _employee.getJoiningDate();
	}

	/**
	* Sets the joining date of this employee.
	*
	* @param joiningDate the joining date of this employee
	*/
	@Override
	public void setJoiningDate(java.util.Date joiningDate) {
		_employee.setJoiningDate(joiningDate);
	}

	/**
	* Returns the department of this employee.
	*
	* @return the department of this employee
	*/
	@Override
	public java.lang.String getDepartment() {
		return _employee.getDepartment();
	}

	/**
	* Sets the department of this employee.
	*
	* @param department the department of this employee
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_employee.setDepartment(department);
	}

	/**
	* Returns the email ID of this employee.
	*
	* @return the email ID of this employee
	*/
	@Override
	public java.lang.String getEmailId() {
		return _employee.getEmailId();
	}

	/**
	* Sets the email ID of this employee.
	*
	* @param emailId the email ID of this employee
	*/
	@Override
	public void setEmailId(java.lang.String emailId) {
		_employee.setEmailId(emailId);
	}

	/**
	* Returns the country of this employee.
	*
	* @return the country of this employee
	*/
	@Override
	public java.lang.String getCountry() {
		return _employee.getCountry();
	}

	/**
	* Sets the country of this employee.
	*
	* @param country the country of this employee
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_employee.setCountry(country);
	}

	@Override
	public boolean isNew() {
		return _employee.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_employee.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _employee.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employee.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _employee.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _employee.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_employee.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employee.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_employee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_employee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmployeeWrapper((Employee)_employee.clone());
	}

	@Override
	public int compareTo(com.test.model.Employee employee) {
		return _employee.compareTo(employee);
	}

	@Override
	public int hashCode() {
		return _employee.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.test.model.Employee> toCacheModel() {
		return _employee.toCacheModel();
	}

	@Override
	public com.test.model.Employee toEscapedModel() {
		return new EmployeeWrapper(_employee.toEscapedModel());
	}

	@Override
	public com.test.model.Employee toUnescapedModel() {
		return new EmployeeWrapper(_employee.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _employee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _employee.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_employee.persist();
	}

	@Override
	public void setEmployeeBirthDate(java.util.Date d) {
		_employee.setEmployeeBirthDate(d);
	}

	@Override
	public java.lang.String getEmployeeBirthDate() {
		return _employee.getEmployeeBirthDate();
	}

	@Override
	public void setEmployeeJoiningDate(java.util.Date d) {
		_employee.setEmployeeJoiningDate(d);
	}

	@Override
	public java.lang.String getEmployeeJoiningDate() {
		return _employee.getEmployeeJoiningDate();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeWrapper)) {
			return false;
		}

		EmployeeWrapper employeeWrapper = (EmployeeWrapper)obj;

		if (Validator.equals(_employee, employeeWrapper._employee)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Employee getWrappedEmployee() {
		return _employee;
	}

	@Override
	public Employee getWrappedModel() {
		return _employee;
	}

	@Override
	public void resetOriginalValues() {
		_employee.resetOriginalValues();
	}

	private Employee _employee;
}