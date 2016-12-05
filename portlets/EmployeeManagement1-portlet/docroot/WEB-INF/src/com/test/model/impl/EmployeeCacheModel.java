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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.test.model.Employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author rashmin.mishra
 * @see Employee
 * @generated
 */
public class EmployeeCacheModel implements CacheModel<Employee>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{employeeId=");
		sb.append(employeeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", age=");
		sb.append(age);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", joiningDate=");
		sb.append(joiningDate);
		sb.append(", department=");
		sb.append(department);
		sb.append(", emailId=");
		sb.append(emailId);
		sb.append(", country=");
		sb.append(country);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmployeeId(employeeId);

		if (name == null) {
			employeeImpl.setName(StringPool.BLANK);
		}
		else {
			employeeImpl.setName(name);
		}

		employeeImpl.setAge(age);

		if (birthDate == Long.MIN_VALUE) {
			employeeImpl.setBirthDate(null);
		}
		else {
			employeeImpl.setBirthDate(new Date(birthDate));
		}

		if (joiningDate == Long.MIN_VALUE) {
			employeeImpl.setJoiningDate(null);
		}
		else {
			employeeImpl.setJoiningDate(new Date(joiningDate));
		}

		if (department == null) {
			employeeImpl.setDepartment(StringPool.BLANK);
		}
		else {
			employeeImpl.setDepartment(department);
		}

		if (emailId == null) {
			employeeImpl.setEmailId(StringPool.BLANK);
		}
		else {
			employeeImpl.setEmailId(emailId);
		}

		if (country == null) {
			employeeImpl.setCountry(StringPool.BLANK);
		}
		else {
			employeeImpl.setCountry(country);
		}

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeId = objectInput.readLong();
		name = objectInput.readUTF();
		age = objectInput.readLong();
		birthDate = objectInput.readLong();
		joiningDate = objectInput.readLong();
		department = objectInput.readUTF();
		emailId = objectInput.readUTF();
		country = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(employeeId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(age);
		objectOutput.writeLong(birthDate);
		objectOutput.writeLong(joiningDate);

		if (department == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(department);
		}

		if (emailId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailId);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}
	}

	public long employeeId;
	public String name;
	public long age;
	public long birthDate;
	public long joiningDate;
	public String department;
	public String emailId;
	public String country;
}