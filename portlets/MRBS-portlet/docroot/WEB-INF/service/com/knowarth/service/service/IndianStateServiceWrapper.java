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

package com.knowarth.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IndianStateService}.
 *
 * @author shyam.vadera
 * @see IndianStateService
 * @generated
 */
public class IndianStateServiceWrapper implements IndianStateService,
	ServiceWrapper<IndianStateService> {
	public IndianStateServiceWrapper(IndianStateService indianStateService) {
		_indianStateService = indianStateService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _indianStateService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_indianStateService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _indianStateService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public IndianStateService getWrappedIndianStateService() {
		return _indianStateService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedIndianStateService(
		IndianStateService indianStateService) {
		_indianStateService = indianStateService;
	}

	@Override
	public IndianStateService getWrappedService() {
		return _indianStateService;
	}

	@Override
	public void setWrappedService(IndianStateService indianStateService) {
		_indianStateService = indianStateService;
	}

	private IndianStateService _indianStateService;
}