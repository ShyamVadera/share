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

import com.knowarth.service.service.ClpSerializer;
import com.knowarth.service.service.IndianStateLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shyam.vadera
 */
public class IndianStateClp extends BaseModelImpl<IndianState>
	implements IndianState {
	public IndianStateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return IndianState.class;
	}

	@Override
	public String getModelClassName() {
		return IndianState.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _stateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stateId", getStateId());
		attributes.put("stateName", getStateName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		String stateName = (String)attributes.get("stateName");

		if (stateName != null) {
			setStateName(stateName);
		}
	}

	@Override
	public long getStateId() {
		return _stateId;
	}

	@Override
	public void setStateId(long stateId) {
		_stateId = stateId;

		if (_indianStateRemoteModel != null) {
			try {
				Class<?> clazz = _indianStateRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_indianStateRemoteModel, stateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStateName() {
		return _stateName;
	}

	@Override
	public void setStateName(String stateName) {
		_stateName = stateName;

		if (_indianStateRemoteModel != null) {
			try {
				Class<?> clazz = _indianStateRemoteModel.getClass();

				Method method = clazz.getMethod("setStateName", String.class);

				method.invoke(_indianStateRemoteModel, stateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getIndianStateRemoteModel() {
		return _indianStateRemoteModel;
	}

	public void setIndianStateRemoteModel(BaseModel<?> indianStateRemoteModel) {
		_indianStateRemoteModel = indianStateRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _indianStateRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_indianStateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			IndianStateLocalServiceUtil.addIndianState(this);
		}
		else {
			IndianStateLocalServiceUtil.updateIndianState(this);
		}
	}

	@Override
	public IndianState toEscapedModel() {
		return (IndianState)ProxyUtil.newProxyInstance(IndianState.class.getClassLoader(),
			new Class[] { IndianState.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		IndianStateClp clone = new IndianStateClp();

		clone.setStateId(getStateId());
		clone.setStateName(getStateName());

		return clone;
	}

	@Override
	public int compareTo(IndianState indianState) {
		long primaryKey = indianState.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IndianStateClp)) {
			return false;
		}

		IndianStateClp indianState = (IndianStateClp)obj;

		long primaryKey = indianState.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{stateId=");
		sb.append(getStateId());
		sb.append(", stateName=");
		sb.append(getStateName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.knowarth.service.model.IndianState");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stateId</column-name><column-value><![CDATA[");
		sb.append(getStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateName</column-name><column-value><![CDATA[");
		sb.append(getStateName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _stateId;
	private String _stateName;
	private BaseModel<?> _indianStateRemoteModel;
	private Class<?> _clpSerializerClass = com.knowarth.service.service.ClpSerializer.class;
}