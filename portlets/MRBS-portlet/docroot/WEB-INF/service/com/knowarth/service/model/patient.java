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

package com.knowarth.service.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the patient service. Represents a row in the &quot;PatientDetails&quot; database table, with each column mapped to a property of this class.
 *
 * @author shyam.vadera
 * @see patientModel
 * @see com.knowarth.service.model.impl.patientImpl
 * @see com.knowarth.service.model.impl.patientModelImpl
 * @generated
 */
public interface patient extends patientModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.knowarth.service.model.impl.patientImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
}