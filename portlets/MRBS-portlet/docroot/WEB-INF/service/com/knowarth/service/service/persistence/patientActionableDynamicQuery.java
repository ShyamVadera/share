/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.knowarth.service.service.persistence;

import com.knowarth.service.model.patient;
import com.knowarth.service.service.patientLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author shyam.vadera
 * @generated
 */
public abstract class patientActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public patientActionableDynamicQuery() throws SystemException {
		setBaseLocalService(patientLocalServiceUtil.getService());
		setClass(patient.class);

		setClassLoader(com.knowarth.service.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("patientId");
	}
}