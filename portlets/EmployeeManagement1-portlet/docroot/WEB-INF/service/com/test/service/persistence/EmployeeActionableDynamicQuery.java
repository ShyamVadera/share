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

package com.test.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.test.model.Employee;

import com.test.service.EmployeeLocalServiceUtil;

/**
 * @author rashmin.mishra
 * @generated
 */
public abstract class EmployeeActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public EmployeeActionableDynamicQuery() throws SystemException {
		setBaseLocalService(EmployeeLocalServiceUtil.getService());
		setClass(Employee.class);

		setClassLoader(com.test.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("employeeId");
	}
}