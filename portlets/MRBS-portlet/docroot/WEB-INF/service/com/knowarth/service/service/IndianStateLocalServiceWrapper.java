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
 * Provides a wrapper for {@link IndianStateLocalService}.
 *
 * @author shyam.vadera
 * @see IndianStateLocalService
 * @generated
 */
public class IndianStateLocalServiceWrapper implements IndianStateLocalService,
	ServiceWrapper<IndianStateLocalService> {
	public IndianStateLocalServiceWrapper(
		IndianStateLocalService indianStateLocalService) {
		_indianStateLocalService = indianStateLocalService;
	}

	/**
	* Adds the indian state to the database. Also notifies the appropriate model listeners.
	*
	* @param indianState the indian state
	* @return the indian state that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.knowarth.service.model.IndianState addIndianState(
		com.knowarth.service.model.IndianState indianState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.addIndianState(indianState);
	}

	/**
	* Creates a new indian state with the primary key. Does not add the indian state to the database.
	*
	* @param stateId the primary key for the new indian state
	* @return the new indian state
	*/
	@Override
	public com.knowarth.service.model.IndianState createIndianState(
		long stateId) {
		return _indianStateLocalService.createIndianState(stateId);
	}

	/**
	* Deletes the indian state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stateId the primary key of the indian state
	* @return the indian state that was removed
	* @throws PortalException if a indian state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.knowarth.service.model.IndianState deleteIndianState(
		long stateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.deleteIndianState(stateId);
	}

	/**
	* Deletes the indian state from the database. Also notifies the appropriate model listeners.
	*
	* @param indianState the indian state
	* @return the indian state that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.knowarth.service.model.IndianState deleteIndianState(
		com.knowarth.service.model.IndianState indianState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.deleteIndianState(indianState);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _indianStateLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.knowarth.service.model.impl.IndianStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.knowarth.service.model.impl.IndianStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.knowarth.service.model.IndianState fetchIndianState(long stateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.fetchIndianState(stateId);
	}

	/**
	* Returns the indian state with the primary key.
	*
	* @param stateId the primary key of the indian state
	* @return the indian state
	* @throws PortalException if a indian state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.knowarth.service.model.IndianState getIndianState(long stateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.getIndianState(stateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the indian states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.knowarth.service.model.impl.IndianStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of indian states
	* @param end the upper bound of the range of indian states (not inclusive)
	* @return the range of indian states
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.knowarth.service.model.IndianState> getIndianStates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.getIndianStates(start, end);
	}

	/**
	* Returns the number of indian states.
	*
	* @return the number of indian states
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getIndianStatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.getIndianStatesCount();
	}

	/**
	* Updates the indian state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param indianState the indian state
	* @return the indian state that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.knowarth.service.model.IndianState updateIndianState(
		com.knowarth.service.model.IndianState indianState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _indianStateLocalService.updateIndianState(indianState);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _indianStateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_indianStateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _indianStateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public IndianStateLocalService getWrappedIndianStateLocalService() {
		return _indianStateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedIndianStateLocalService(
		IndianStateLocalService indianStateLocalService) {
		_indianStateLocalService = indianStateLocalService;
	}

	@Override
	public IndianStateLocalService getWrappedService() {
		return _indianStateLocalService;
	}

	@Override
	public void setWrappedService(
		IndianStateLocalService indianStateLocalService) {
		_indianStateLocalService = indianStateLocalService;
	}

	private IndianStateLocalService _indianStateLocalService;
}