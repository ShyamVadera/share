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

import com.knowarth.service.model.IndianState;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the indian state service. This utility wraps {@link IndianStatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author shyam.vadera
 * @see IndianStatePersistence
 * @see IndianStatePersistenceImpl
 * @generated
 */
public class IndianStateUtil {
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
	public static void clearCache(IndianState indianState) {
		getPersistence().clearCache(indianState);
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
	public static List<IndianState> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IndianState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IndianState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static IndianState update(IndianState indianState)
		throws SystemException {
		return getPersistence().update(indianState);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static IndianState update(IndianState indianState,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(indianState, serviceContext);
	}

	/**
	* Caches the indian state in the entity cache if it is enabled.
	*
	* @param indianState the indian state
	*/
	public static void cacheResult(
		com.knowarth.service.model.IndianState indianState) {
		getPersistence().cacheResult(indianState);
	}

	/**
	* Caches the indian states in the entity cache if it is enabled.
	*
	* @param indianStates the indian states
	*/
	public static void cacheResult(
		java.util.List<com.knowarth.service.model.IndianState> indianStates) {
		getPersistence().cacheResult(indianStates);
	}

	/**
	* Creates a new indian state with the primary key. Does not add the indian state to the database.
	*
	* @param stateId the primary key for the new indian state
	* @return the new indian state
	*/
	public static com.knowarth.service.model.IndianState create(long stateId) {
		return getPersistence().create(stateId);
	}

	/**
	* Removes the indian state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stateId the primary key of the indian state
	* @return the indian state that was removed
	* @throws com.knowarth.service.NoSuchIndianStateException if a indian state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.knowarth.service.model.IndianState remove(long stateId)
		throws com.knowarth.service.NoSuchIndianStateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(stateId);
	}

	public static com.knowarth.service.model.IndianState updateImpl(
		com.knowarth.service.model.IndianState indianState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(indianState);
	}

	/**
	* Returns the indian state with the primary key or throws a {@link com.knowarth.service.NoSuchIndianStateException} if it could not be found.
	*
	* @param stateId the primary key of the indian state
	* @return the indian state
	* @throws com.knowarth.service.NoSuchIndianStateException if a indian state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.knowarth.service.model.IndianState findByPrimaryKey(
		long stateId)
		throws com.knowarth.service.NoSuchIndianStateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(stateId);
	}

	/**
	* Returns the indian state with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stateId the primary key of the indian state
	* @return the indian state, or <code>null</code> if a indian state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.knowarth.service.model.IndianState fetchByPrimaryKey(
		long stateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(stateId);
	}

	/**
	* Returns all the indian states.
	*
	* @return the indian states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.knowarth.service.model.IndianState> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.knowarth.service.model.IndianState> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the indian states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.knowarth.service.model.impl.IndianStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of indian states
	* @param end the upper bound of the range of indian states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of indian states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.knowarth.service.model.IndianState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the indian states from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of indian states.
	*
	* @return the number of indian states
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static IndianStatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (IndianStatePersistence)PortletBeanLocatorUtil.locate(com.knowarth.service.service.ClpSerializer.getServletContextName(),
					IndianStatePersistence.class.getName());

			ReferenceRegistry.registerReference(IndianStateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(IndianStatePersistence persistence) {
	}

	private static IndianStatePersistence _persistence;
}