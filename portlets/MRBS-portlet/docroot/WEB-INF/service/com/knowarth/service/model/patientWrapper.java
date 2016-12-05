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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link patient}.
 * </p>
 *
 * @author shyam.vadera
 * @see patient
 * @generated
 */
public class patientWrapper implements patient, ModelWrapper<patient> {
	public patientWrapper(patient patient) {
		_patient = patient;
	}

	@Override
	public Class<?> getModelClass() {
		return patient.class;
	}

	@Override
	public String getModelClassName() {
		return patient.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patientId", getPatientId());
		attributes.put("patientName", getPatientName());
		attributes.put("patientEmailId", getPatientEmailId());
		attributes.put("patientAge", getPatientAge());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		String patientName = (String)attributes.get("patientName");

		if (patientName != null) {
			setPatientName(patientName);
		}

		String patientEmailId = (String)attributes.get("patientEmailId");

		if (patientEmailId != null) {
			setPatientEmailId(patientEmailId);
		}

		Long patientAge = (Long)attributes.get("patientAge");

		if (patientAge != null) {
			setPatientAge(patientAge);
		}
	}

	/**
	* Returns the primary key of this patient.
	*
	* @return the primary key of this patient
	*/
	@Override
	public long getPrimaryKey() {
		return _patient.getPrimaryKey();
	}

	/**
	* Sets the primary key of this patient.
	*
	* @param primaryKey the primary key of this patient
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_patient.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the patient ID of this patient.
	*
	* @return the patient ID of this patient
	*/
	@Override
	public long getPatientId() {
		return _patient.getPatientId();
	}

	/**
	* Sets the patient ID of this patient.
	*
	* @param patientId the patient ID of this patient
	*/
	@Override
	public void setPatientId(long patientId) {
		_patient.setPatientId(patientId);
	}

	/**
	* Returns the patient name of this patient.
	*
	* @return the patient name of this patient
	*/
	@Override
	public java.lang.String getPatientName() {
		return _patient.getPatientName();
	}

	/**
	* Sets the patient name of this patient.
	*
	* @param patientName the patient name of this patient
	*/
	@Override
	public void setPatientName(java.lang.String patientName) {
		_patient.setPatientName(patientName);
	}

	/**
	* Returns the patient email ID of this patient.
	*
	* @return the patient email ID of this patient
	*/
	@Override
	public java.lang.String getPatientEmailId() {
		return _patient.getPatientEmailId();
	}

	/**
	* Sets the patient email ID of this patient.
	*
	* @param patientEmailId the patient email ID of this patient
	*/
	@Override
	public void setPatientEmailId(java.lang.String patientEmailId) {
		_patient.setPatientEmailId(patientEmailId);
	}

	/**
	* Returns the patient age of this patient.
	*
	* @return the patient age of this patient
	*/
	@Override
	public long getPatientAge() {
		return _patient.getPatientAge();
	}

	/**
	* Sets the patient age of this patient.
	*
	* @param patientAge the patient age of this patient
	*/
	@Override
	public void setPatientAge(long patientAge) {
		_patient.setPatientAge(patientAge);
	}

	@Override
	public boolean isNew() {
		return _patient.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_patient.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _patient.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_patient.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _patient.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _patient.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_patient.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _patient.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_patient.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_patient.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_patient.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new patientWrapper((patient)_patient.clone());
	}

	@Override
	public int compareTo(com.knowarth.service.model.patient patient) {
		return _patient.compareTo(patient);
	}

	@Override
	public int hashCode() {
		return _patient.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.knowarth.service.model.patient> toCacheModel() {
		return _patient.toCacheModel();
	}

	@Override
	public com.knowarth.service.model.patient toEscapedModel() {
		return new patientWrapper(_patient.toEscapedModel());
	}

	@Override
	public com.knowarth.service.model.patient toUnescapedModel() {
		return new patientWrapper(_patient.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _patient.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _patient.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_patient.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof patientWrapper)) {
			return false;
		}

		patientWrapper patientWrapper = (patientWrapper)obj;

		if (Validator.equals(_patient, patientWrapper._patient)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public patient getWrappedpatient() {
		return _patient;
	}

	@Override
	public patient getWrappedModel() {
		return _patient;
	}

	@Override
	public void resetOriginalValues() {
		_patient.resetOriginalValues();
	}

	private patient _patient;
}