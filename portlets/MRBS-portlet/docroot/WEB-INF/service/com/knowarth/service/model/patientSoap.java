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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.knowarth.service.service.http.patientServiceSoap}.
 *
 * @author shyam.vadera
 * @see com.knowarth.service.service.http.patientServiceSoap
 * @generated
 */
public class patientSoap implements Serializable {
	public static patientSoap toSoapModel(patient model) {
		patientSoap soapModel = new patientSoap();

		soapModel.setPatientId(model.getPatientId());
		soapModel.setPatientName(model.getPatientName());
		soapModel.setPatientEmailId(model.getPatientEmailId());
		soapModel.setPatientAge(model.getPatientAge());

		return soapModel;
	}

	public static patientSoap[] toSoapModels(patient[] models) {
		patientSoap[] soapModels = new patientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static patientSoap[][] toSoapModels(patient[][] models) {
		patientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new patientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new patientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static patientSoap[] toSoapModels(List<patient> models) {
		List<patientSoap> soapModels = new ArrayList<patientSoap>(models.size());

		for (patient model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new patientSoap[soapModels.size()]);
	}

	public patientSoap() {
	}

	public long getPrimaryKey() {
		return _patientId;
	}

	public void setPrimaryKey(long pk) {
		setPatientId(pk);
	}

	public long getPatientId() {
		return _patientId;
	}

	public void setPatientId(long patientId) {
		_patientId = patientId;
	}

	public String getPatientName() {
		return _patientName;
	}

	public void setPatientName(String patientName) {
		_patientName = patientName;
	}

	public String getPatientEmailId() {
		return _patientEmailId;
	}

	public void setPatientEmailId(String patientEmailId) {
		_patientEmailId = patientEmailId;
	}

	public long getPatientAge() {
		return _patientAge;
	}

	public void setPatientAge(long patientAge) {
		_patientAge = patientAge;
	}

	private long _patientId;
	private String _patientName;
	private String _patientEmailId;
	private long _patientAge;
}