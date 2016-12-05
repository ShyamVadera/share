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
import com.knowarth.service.model.patientModel;
import com.knowarth.service.model.patientSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the patient service. Represents a row in the &quot;PatientDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.knowarth.service.model.patientModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link patientImpl}.
 * </p>
 *
 * @author shyam.vadera
 * @see patientImpl
 * @see com.knowarth.service.model.patient
 * @see com.knowarth.service.model.patientModel
 * @generated
 */
@JSON(strict = true)
public class patientModelImpl extends BaseModelImpl<patient>
	implements patientModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a patient model instance should use the {@link com.knowarth.service.model.patient} interface instead.
	 */
	public static final String TABLE_NAME = "PatientDetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "patientId", Types.BIGINT },
			{ "patientName", Types.VARCHAR },
			{ "patientEmailId", Types.VARCHAR },
			{ "patientAge", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table PatientDetails (patientId LONG not null primary key,patientName VARCHAR(75) null,patientEmailId VARCHAR(75) null,patientAge LONG)";
	public static final String TABLE_SQL_DROP = "drop table PatientDetails";
	public static final String ORDER_BY_JPQL = " ORDER BY patient.patientId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY PatientDetails.patientId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.knowarth.service.model.patient"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.knowarth.service.model.patient"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.knowarth.service.model.patient"),
			true);
	public static long PATIENTEMAILID_COLUMN_BITMASK = 1L;
	public static long PATIENTID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static patient toModel(patientSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		patient model = new patientImpl();

		model.setPatientId(soapModel.getPatientId());
		model.setPatientName(soapModel.getPatientName());
		model.setPatientEmailId(soapModel.getPatientEmailId());
		model.setPatientAge(soapModel.getPatientAge());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<patient> toModels(patientSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<patient> models = new ArrayList<patient>(soapModels.length);

		for (patientSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.knowarth.service.model.patient"));

	public patientModelImpl() {
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

	@JSON
	@Override
	public long getPatientId() {
		return _patientId;
	}

	@Override
	public void setPatientId(long patientId) {
		_patientId = patientId;
	}

	@JSON
	@Override
	public String getPatientName() {
		if (_patientName == null) {
			return StringPool.BLANK;
		}
		else {
			return _patientName;
		}
	}

	@Override
	public void setPatientName(String patientName) {
		_patientName = patientName;
	}

	@JSON
	@Override
	public String getPatientEmailId() {
		if (_patientEmailId == null) {
			return StringPool.BLANK;
		}
		else {
			return _patientEmailId;
		}
	}

	@Override
	public void setPatientEmailId(String patientEmailId) {
		_columnBitmask |= PATIENTEMAILID_COLUMN_BITMASK;

		if (_originalPatientEmailId == null) {
			_originalPatientEmailId = _patientEmailId;
		}

		_patientEmailId = patientEmailId;
	}

	public String getOriginalPatientEmailId() {
		return GetterUtil.getString(_originalPatientEmailId);
	}

	@JSON
	@Override
	public long getPatientAge() {
		return _patientAge;
	}

	@Override
	public void setPatientAge(long patientAge) {
		_patientAge = patientAge;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			patient.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public patient toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (patient)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		patientImpl patientImpl = new patientImpl();

		patientImpl.setPatientId(getPatientId());
		patientImpl.setPatientName(getPatientName());
		patientImpl.setPatientEmailId(getPatientEmailId());
		patientImpl.setPatientAge(getPatientAge());

		patientImpl.resetOriginalValues();

		return patientImpl;
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

		if (!(obj instanceof patient)) {
			return false;
		}

		patient patient = (patient)obj;

		long primaryKey = patient.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		patientModelImpl patientModelImpl = this;

		patientModelImpl._originalPatientEmailId = patientModelImpl._patientEmailId;

		patientModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<patient> toCacheModel() {
		patientCacheModel patientCacheModel = new patientCacheModel();

		patientCacheModel.patientId = getPatientId();

		patientCacheModel.patientName = getPatientName();

		String patientName = patientCacheModel.patientName;

		if ((patientName != null) && (patientName.length() == 0)) {
			patientCacheModel.patientName = null;
		}

		patientCacheModel.patientEmailId = getPatientEmailId();

		String patientEmailId = patientCacheModel.patientEmailId;

		if ((patientEmailId != null) && (patientEmailId.length() == 0)) {
			patientCacheModel.patientEmailId = null;
		}

		patientCacheModel.patientAge = getPatientAge();

		return patientCacheModel;
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

	private static ClassLoader _classLoader = patient.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			patient.class
		};
	private long _patientId;
	private String _patientName;
	private String _patientEmailId;
	private String _originalPatientEmailId;
	private long _patientAge;
	private long _columnBitmask;
	private patient _escapedModel;
}