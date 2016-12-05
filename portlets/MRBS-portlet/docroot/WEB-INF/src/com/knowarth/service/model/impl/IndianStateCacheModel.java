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

import com.knowarth.service.model.IndianState;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing IndianState in entity cache.
 *
 * @author shyam.vadera
 * @see IndianState
 * @generated
 */
public class IndianStateCacheModel implements CacheModel<IndianState>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{stateId=");
		sb.append(stateId);
		sb.append(", stateName=");
		sb.append(stateName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IndianState toEntityModel() {
		IndianStateImpl indianStateImpl = new IndianStateImpl();

		indianStateImpl.setStateId(stateId);

		if (stateName == null) {
			indianStateImpl.setStateName(StringPool.BLANK);
		}
		else {
			indianStateImpl.setStateName(stateName);
		}

		indianStateImpl.resetOriginalValues();

		return indianStateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stateId = objectInput.readLong();
		stateName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stateId);

		if (stateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stateName);
		}
	}

	public long stateId;
	public String stateName;
}