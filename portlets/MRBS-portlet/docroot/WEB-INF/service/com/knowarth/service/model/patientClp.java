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
import com.knowarth.service.service.patientLocalServiceUtil;

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
public class patientClp extends BaseModelImpl<patient> implements patient {
	public patientClp() {
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
	public long getPrimaryKey() {
		return _patientId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPatientId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _patientId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getPatientId() {
		return _patientId;
	}

	@Override
	public void setPatientId(long patientId) {
		_patientId = patientId;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setPatientId", long.class);

				method.invoke(_patientRemoteModel, patientId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPatientName() {
		return _patientName;
	}

	@Override
	public void setPatientName(String patientName) {
		_patientName = patientName;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setPatientName", String.class);

				method.invoke(_patientRemoteModel, patientName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPatientEmailId() {
		return _patientEmailId;
	}

	@Override
	public void setPatientEmailId(String patientEmailId) {
		_patientEmailId = patientEmailId;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setPatientEmailId",
						String.class);

				method.invoke(_patientRemoteModel, patientEmailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPatientAge() {
		return _patientAge;
	}

	@Override
	public void setPatientAge(long patientAge) {
		_patientAge = patientAge;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setPatientAge", long.class);

				method.invoke(_patientRemoteModel, patientAge);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getpatientRemoteModel() {
		return _patientRemoteModel;
	}

	public void setpatientRemoteModel(BaseModel<?> patientRemoteModel) {
		_patientRemoteModel = patientRemoteModel;
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

		Class<?> remoteModelClass = _patientRemoteModel.getClass();

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

		Object returnValue = method.invoke(_patientRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			patientLocalServiceUtil.addpatient(this);
		}
		else {
			patientLocalServiceUtil.updatepatient(this);
		}
	}

	@Override
	public patient toEscapedModel() {
		return (patient)ProxyUtil.newProxyInstance(patient.class.getClassLoader(),
			new Class[] { patient.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		patientClp clone = new patientClp();

		clone.setPatientId(getPatientId());
		clone.setPatientName(getPatientName());
		clone.setPatientEmailId(getPatientEmailId());
		clone.setPatientAge(getPatientAge());

		return clone;
	}

	@Override
	public int compareTo(patient patient) {
		long primaryKey = patient.getPrimaryKey();

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

		if (!(obj instanceof patientClp)) {
			return false;
		}

		patientClp patient = (patientClp)obj;

		long primaryKey = patient.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{patientId=");
		sb.append(getPatientId());
		sb.append(", patientName=");
		sb.append(getPatientName());
		sb.append(", patientEmailId=");
		sb.append(getPatientEmailId());
		sb.append(", patientAge=");
		sb.append(getPatientAge());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.knowarth.service.model.patient");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>patientId</column-name><column-value><![CDATA[");
		sb.append(getPatientId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patientName</column-name><column-value><![CDATA[");
		sb.append(getPatientName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patientEmailId</column-name><column-value><![CDATA[");
		sb.append(getPatientEmailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patientAge</column-name><column-value><![CDATA[");
		sb.append(getPatientAge());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _patientId;
	private String _patientName;
	private String _patientEmailId;
	private long _patientAge;
	private BaseModel<?> _patientRemoteModel;
	private Class<?> _clpSerializerClass = com.knowarth.service.service.ClpSerializer.class;
}