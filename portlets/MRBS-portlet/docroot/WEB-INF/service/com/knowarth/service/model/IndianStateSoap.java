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
 * This class is used by SOAP remote services, specifically {@link com.knowarth.service.service.http.IndianStateServiceSoap}.
 *
 * @author shyam.vadera
 * @see com.knowarth.service.service.http.IndianStateServiceSoap
 * @generated
 */
public class IndianStateSoap implements Serializable {
	public static IndianStateSoap toSoapModel(IndianState model) {
		IndianStateSoap soapModel = new IndianStateSoap();

		soapModel.setStateId(model.getStateId());
		soapModel.setStateName(model.getStateName());

		return soapModel;
	}

	public static IndianStateSoap[] toSoapModels(IndianState[] models) {
		IndianStateSoap[] soapModels = new IndianStateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IndianStateSoap[][] toSoapModels(IndianState[][] models) {
		IndianStateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IndianStateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IndianStateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IndianStateSoap[] toSoapModels(List<IndianState> models) {
		List<IndianStateSoap> soapModels = new ArrayList<IndianStateSoap>(models.size());

		for (IndianState model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IndianStateSoap[soapModels.size()]);
	}

	public IndianStateSoap() {
	}

	public long getPrimaryKey() {
		return _stateId;
	}

	public void setPrimaryKey(long pk) {
		setStateId(pk);
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	public String getStateName() {
		return _stateName;
	}

	public void setStateName(String stateName) {
		_stateName = stateName;
	}

	private long _stateId;
	private String _stateName;
}