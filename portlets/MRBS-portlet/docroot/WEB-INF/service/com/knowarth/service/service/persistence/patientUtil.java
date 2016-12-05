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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the patient service. This utility wraps {@link patientPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author shyam.vadera
 * @see patientPersistence
 * @see patientPersistenceImpl
 * @generated
 */
public class patientUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(patient patient) {
		getPersistence().clearCache(patient);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<patient> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<patient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<patient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static patient update(patient patient) throws SystemException {
		return getPersistence().update(patient);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static patient update(patient patient, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(patient, serviceContext);
	}

	/**
	* Returns the patient where patientEmailId = &#63; or throws a {@link com.knowarth.service.NoSuchpatientException} if it could not be found.
	*
	* @param patientEmailId the patient email ID
	* @return the matching patient
	* @throws com.knowarth.service.NoSuchpatientException if a matching patient could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.knowarth.service.model.patient findByEmailId(
		java.lang.String patientEmailId)
		throws com.knowarth.service.NoSuchpatientException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailId(patientEmailId);
	}

	/**
	* Returns the patient where patientEmailId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param patientEmailId the patient email ID
	* @return the matching patient, or <code>null</code> if a matching patient could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.knowarth.service.model.patient fetchByEmailId(
		java.lang.String patientEmailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmailId(patientEmailId);
	}

	/**
	* Returns the patient where patientEmailId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param patientEmailId the patient email ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching patient, or <code>null</code> if a matching patient could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.knowarth.service.model.patient fetchByEmailId(
		java.lang.String patientEmailId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmailId(patientEmailId, retrieveFromCache);
	}

	/**
	* Removes the patient where patientEmailId = &#63; from the database.
	*
	* @param patientEmailId the patient email ID
	* @return the patient that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.knowarth.service.model.patient removeByEmailId(
		java.lang.String patientEmailId)
		throws com.knowarth.service.NoSuchpatientException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByEmailId(patientEmailId);
	}

	/**
	* Returns the number of patients where patientEmailId = &#63;.
	*
	* @param patientEmailId the patient email ID
	* @return the number of matching patients
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailId(java.lang.String patientEmailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailId(patientEmailId);
	}

	/**
	* Caches the patient in the entity cache if it is enabled.
	*
	* @param patient the patient
	*/
	public static void cacheResult(com.knowarth.service.model.patient patient) {
		getPersistence().cacheResult(patient);
	}

	/**
	* Caches the patients in the entity cache if it is enabled.
	*
	* @param patients the patients
	*/
	public static void cacheResult(
		java.util.List<com.knowarth.service.model.patient> patients) {
		getPersistence().cacheResult(patients);
	}

	/**
	* Creates a new patient with the primary key. Does not add the patient to the database.
	*
	* @param patientId the primary key for the new patient
	* @return the new patient
	*/
	public static com.knowarth.service.model.patient create(long patientId) {
		return getPersistence().create(patientId);
	}

	/**
	* Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patientId the primary key of the patient
	* @return the patient that was removed
	* @throws com.knowarth.service.NoSuchpatientException if a patient with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.knowarth.service.model.patient remove(long patientId)
		throws com.knowarth.service.NoSuchpatientException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(patientId);
	}

	public static com.knowarth.service.model.patient updateImpl(
		com.knowarth.service.model.patient patient)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(patient);
	}

	/**
	* Returns the patient with the primary key or throws a {@link com.knowarth.service.NoSuchpatientException} if it could not be found.
	*
	* @param patientId the primary key of the patient
	* @return the patient
	* @throws com.knowarth.service.NoSuchpatientException if a patient with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.knowarth.service.model.patient findByPrimaryKey(
		long patientId)
		throws com.knowarth.service.NoSuchpatientException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(patientId);
	}

	/**
	* Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param patientId the primary key of the patient
	* @return the patient, or <code>null</code> if a patient with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.knowarth.service.model.patient fetchByPrimaryKey(
		long patientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(patientId);
	}

	/**
	* Returns all the patients.
	*
	* @return the patients
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.knowarth.service.model.patient> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.knowarth.service.model.patient> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.knowarth.service.model.patient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the patients from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of patients.
	*
	* @return the number of patients
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static patientPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (patientPersistence)PortletBeanLocatorUtil.locate(com.knowarth.service.service.ClpSerializer.getServletContextName(),
					patientPersistence.class.getName());

			ReferenceRegistry.registerReference(patientUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(patientPersistence persistence) {
	}

	private static patientPersistence _persistence;
}