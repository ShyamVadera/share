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

package com.knowarth.service.service.persistence;

import com.knowarth.service.model.patient;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the patient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author shyam.vadera
 * @see patientPersistenceImpl
 * @see patientUtil
 * @generated
 */
public interface patientPersistence extends BasePersistence<patient> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link patientUtil} to access the patient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the patient where patientEmailId = &#63; or throws a {@link com.knowarth.service.NoSuchpatientException} if it could not be found.
	*
	* @param patientEmailId the patient email ID
	* @return the matching patient
	* @throws com.knowarth.service.NoSuchpatientException if a matching patient could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.knowarth.service.model.patient findByEmailId(
		java.lang.String patientEmailId)
		throws com.knowarth.service.NoSuchpatientException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient where patientEmailId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param patientEmailId the patient email ID
	* @return the matching patient, or <code>null</code> if a matching patient could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.knowarth.service.model.patient fetchByEmailId(
		java.lang.String patientEmailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient where patientEmailId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param patientEmailId the patient email ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching patient, or <code>null</code> if a matching patient could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.knowarth.service.model.patient fetchByEmailId(
		java.lang.String patientEmailId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the patient where patientEmailId = &#63; from the database.
	*
	* @param patientEmailId the patient email ID
	* @return the patient that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.knowarth.service.model.patient removeByEmailId(
		java.lang.String patientEmailId)
		throws com.knowarth.service.NoSuchpatientException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patients where patientEmailId = &#63;.
	*
	* @param patientEmailId the patient email ID
	* @return the number of matching patients
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailId(java.lang.String patientEmailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the patient in the entity cache if it is enabled.
	*
	* @param patient the patient
	*/
	public void cacheResult(com.knowarth.service.model.patient patient);

	/**
	* Caches the patients in the entity cache if it is enabled.
	*
	* @param patients the patients
	*/
	public void cacheResult(
		java.util.List<com.knowarth.service.model.patient> patients);

	/**
	* Creates a new patient with the primary key. Does not add the patient to the database.
	*
	* @param patientId the primary key for the new patient
	* @return the new patient
	*/
	public com.knowarth.service.model.patient create(long patientId);

	/**
	* Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patientId the primary key of the patient
	* @return the patient that was removed
	* @throws com.knowarth.service.NoSuchpatientException if a patient with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.knowarth.service.model.patient remove(long patientId)
		throws com.knowarth.service.NoSuchpatientException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.knowarth.service.model.patient updateImpl(
		com.knowarth.service.model.patient patient)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient with the primary key or throws a {@link com.knowarth.service.NoSuchpatientException} if it could not be found.
	*
	* @param patientId the primary key of the patient
	* @return the patient
	* @throws com.knowarth.service.NoSuchpatientException if a patient with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.knowarth.service.model.patient findByPrimaryKey(long patientId)
		throws com.knowarth.service.NoSuchpatientException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param patientId the primary key of the patient
	* @return the patient, or <code>null</code> if a patient with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.knowarth.service.model.patient fetchByPrimaryKey(long patientId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patients.
	*
	* @return the patients
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.knowarth.service.model.patient> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.knowarth.service.model.patient> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.knowarth.service.model.impl.patientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patients
	* @param end the upper bound of the range of patients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of patients
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.knowarth.service.model.patient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patients from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patients.
	*
	* @return the number of patients
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}