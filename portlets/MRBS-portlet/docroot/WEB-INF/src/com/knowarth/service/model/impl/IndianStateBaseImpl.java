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
import com.knowarth.service.service.IndianStateLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the IndianState service. Represents a row in the &quot;IndianState&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IndianStateImpl}.
 * </p>
 *
 * @author shyam.vadera
 * @see IndianStateImpl
 * @see com.knowarth.service.model.IndianState
 * @generated
 */
public abstract class IndianStateBaseImpl extends IndianStateModelImpl
	implements IndianState {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a indian state model instance should use the {@link IndianState} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			IndianStateLocalServiceUtil.addIndianState(this);
		}
		else {
			IndianStateLocalServiceUtil.updateIndianState(this);
		}
	}
}