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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing patient in entity cache.
 *
 * @author shyam.vadera
 * @see patient
 * @generated
 */
public class patientCacheModel implements CacheModel<patient>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{patientId=");
		sb.append(patientId);
		sb.append(", patientName=");
		sb.append(patientName);
		sb.append(", patientEmailId=");
		sb.append(patientEmailId);
		sb.append(", patientAge=");
		sb.append(patientAge);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public patient toEntityModel() {
		patientImpl patientImpl = new patientImpl();

		patientImpl.setPatientId(patientId);

		if (patientName == null) {
			patientImpl.setPatientName(StringPool.BLANK);
		}
		else {
			patientImpl.setPatientName(patientName);
		}

		if (patientEmailId == null) {
			patientImpl.setPatientEmailId(StringPool.BLANK);
		}
		else {
			patientImpl.setPatientEmailId(patientEmailId);
		}

		patientImpl.setPatientAge(patientAge);

		patientImpl.resetOriginalValues();

		return patientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		patientId = objectInput.readLong();
		patientName = objectInput.readUTF();
		patientEmailId = objectInput.readUTF();
		patientAge = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(patientId);

		if (patientName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(patientName);
		}

		if (patientEmailId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(patientEmailId);
		}

		objectOutput.writeLong(patientAge);
	}

	public long patientId;
	public String patientName;
	public String patientEmailId;
	public long patientAge;
}