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

package com.knowarth.service.model.impl;

import com.knowarth.service.model.patient;
import com.knowarth.service.service.patientLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the patient service. Represents a row in the &quot;PatientDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link patientImpl}.
 * </p>
 *
 * @author shyam.vadera
 * @see patientImpl
 * @see com.knowarth.service.model.patient
 * @generated
 */
public abstract class patientBaseImpl extends patientModelImpl
	implements patient {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a patient model instance should use the {@link patient} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			patientLocalServiceUtil.addpatient(this);
		}
		else {
			patientLocalServiceUtil.updatepatient(this);
		}
	}
}