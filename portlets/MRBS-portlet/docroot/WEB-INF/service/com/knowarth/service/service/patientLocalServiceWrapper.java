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
 * Provides a wrapper for {@link patientLocalService}.
 *
 * @author shyam.vadera
 * @see patientLocalService
 * @generated
 */
public class patientLocalServiceWrapper implements patientLocalService,
	ServiceWrapper<patientLocalService> {
	public patientLocalServiceWrapper(patientLocalService patientLocalService) {
		_patientLocalService = patientLocalService;
	}

	/**
	* Adds the patient to the database. Also notifies the appropriate model listeners.
	*
	* @param patient the patient
	* @return the patient that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.knowarth.service.model.patient addpatient(
		com.knowarth.service.model.patient patient)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patientLocalService.addpatient(patient);
	}

	/**
	* Creates a new patient with the primary key. Does not add the patient to the database.
	*
	* @param patientId the primary key for the new patient
	* @return the new patient
	*/
	@Override
	public com.knowarth.service.model.patient createpatient(long patientId) {
		return _patientLocalService.createpatient(patientId);
	}

	/**
	* Deletes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patientId the primary key of the patient
	* @return the patient that was removed
	* @throws PortalException if a patient with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.knowarth.service.model.patient deletepatient(long patientId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patientLocalService.deletepatient(patientId);
	}

	/**
	* Deletes the patient from the database. Also notifies the appropriate model listeners.
	*
	* @param patient the patient
	* @return the patient that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.knowarth.service.model.patient deletepatient(
		com.knowarth.service.model.patient patient)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patientLocalService.deletepatient(patient);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _patientLocalService.dynamicQuery();
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
		return _patientLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.knowarth.service.model.impl.patientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _patientLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.knowarth.service.model.impl.patientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _patientLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _patientLocalService.dynamicQueryCount(dynamicQuery);
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
		return _patientLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.knowarth.service.model.patient fetchpatient(long patientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patientLocalService.fetchpatient(patientId);
	}

	/**
	* Returns the patient with the primary key.
	*
	* @param patientId the primary key of the patient
	* @return the patient
	* @throws PortalException if a patient with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.knowarth.service.model.patient getpatient(long patientId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patientLocalService.getpatient(patientId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _patientLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the patients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.knowarth.service.model.impl.patientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patients
	* @param end the upper bound of the range of patients (not inclusive)
	* @return the range of patients
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.knowarth.service.model.patient> getpatients(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patientLocalService.getpatients(start, end);
	}

	/**
	* Returns the number of patients.
	*
	* @return the number of patients
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getpatientsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patientLocalService.getpatientsCount();
	}

	/**
	* Updates the patient in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param patient the patient
	* @return the patient that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.knowarth.service.model.patient updatepatient(
		com.knowarth.service.model.patient patient)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patientLocalService.updatepatient(patient);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _patientLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_patientLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _patientLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void savePatient(com.knowarth.service.model.patient patient)
		throws com.liferay.portal.EmailAddressException,
			com.liferay.portal.kernel.exception.SystemException {
		_patientLocalService.savePatient(patient);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public patientLocalService getWrappedpatientLocalService() {
		return _patientLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedpatientLocalService(
		patientLocalService patientLocalService) {
		_patientLocalService = patientLocalService;
	}

	@Override
	public patientLocalService getWrappedService() {
		return _patientLocalService;
	}

	@Override
	public void setWrappedService(patientLocalService patientLocalService) {
		_patientLocalService = patientLocalService;
	}

	private patientLocalService _patientLocalService;
}