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
 * This class is a wrapper for {@link IndianState}.
 * </p>
 *
 * @author shyam.vadera
 * @see IndianState
 * @generated
 */
public class IndianStateWrapper implements IndianState,
	ModelWrapper<IndianState> {
	public IndianStateWrapper(IndianState indianState) {
		_indianState = indianState;
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

	/**
	* Returns the primary key of this indian state.
	*
	* @return the primary key of this indian state
	*/
	@Override
	public long getPrimaryKey() {
		return _indianState.getPrimaryKey();
	}

	/**
	* Sets the primary key of this indian state.
	*
	* @param primaryKey the primary key of this indian state
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_indianState.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the state ID of this indian state.
	*
	* @return the state ID of this indian state
	*/
	@Override
	public long getStateId() {
		return _indianState.getStateId();
	}

	/**
	* Sets the state ID of this indian state.
	*
	* @param stateId the state ID of this indian state
	*/
	@Override
	public void setStateId(long stateId) {
		_indianState.setStateId(stateId);
	}

	/**
	* Returns the state name of this indian state.
	*
	* @return the state name of this indian state
	*/
	@Override
	public java.lang.String getStateName() {
		return _indianState.getStateName();
	}

	/**
	* Sets the state name of this indian state.
	*
	* @param stateName the state name of this indian state
	*/
	@Override
	public void setStateName(java.lang.String stateName) {
		_indianState.setStateName(stateName);
	}

	@Override
	public boolean isNew() {
		return _indianState.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_indianState.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _indianState.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_indianState.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _indianState.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _indianState.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_indianState.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _indianState.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_indianState.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_indianState.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_indianState.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new IndianStateWrapper((IndianState)_indianState.clone());
	}

	@Override
	public int compareTo(com.knowarth.service.model.IndianState indianState) {
		return _indianState.compareTo(indianState);
	}

	@Override
	public int hashCode() {
		return _indianState.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.knowarth.service.model.IndianState> toCacheModel() {
		return _indianState.toCacheModel();
	}

	@Override
	public com.knowarth.service.model.IndianState toEscapedModel() {
		return new IndianStateWrapper(_indianState.toEscapedModel());
	}

	@Override
	public com.knowarth.service.model.IndianState toUnescapedModel() {
		return new IndianStateWrapper(_indianState.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _indianState.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _indianState.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_indianState.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IndianStateWrapper)) {
			return false;
		}

		IndianStateWrapper indianStateWrapper = (IndianStateWrapper)obj;

		if (Validator.equals(_indianState, indianStateWrapper._indianState)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public IndianState getWrappedIndianState() {
		return _indianState;
	}

	@Override
	public IndianState getWrappedModel() {
		return _indianState;
	}

	@Override
	public void resetOriginalValues() {
		_indianState.resetOriginalValues();
	}

	private IndianState _indianState;
}