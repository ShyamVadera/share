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

import com.knowarth.service.NoSuchpatientException;
import com.knowarth.service.model.impl.patientImpl;
import com.knowarth.service.model.impl.patientModelImpl;
import com.knowarth.service.model.patient;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the patient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author shyam.vadera
 * @see patientPersistence
 * @see patientUtil
 * @generated
 */
public class patientPersistenceImpl extends BasePersistenceImpl<patient>
	implements patientPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link patientUtil} to access the patient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = patientImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(patientModelImpl.ENTITY_CACHE_ENABLED,
			patientModelImpl.FINDER_CACHE_ENABLED, patientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(patientModelImpl.ENTITY_CACHE_ENABLED,
			patientModelImpl.FINDER_CACHE_ENABLED, patientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(patientModelImpl.ENTITY_CACHE_ENABLED,
			patientModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILID = new FinderPath(patientModelImpl.ENTITY_CACHE_ENABLED,
			patientModelImpl.FINDER_CACHE_ENABLED, patientImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmailId",
			new String[] { String.class.getName() },
			patientModelImpl.PATIENTEMAILID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILID = new FinderPath(patientModelImpl.ENTITY_CACHE_ENABLED,
			patientModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailId",
			new String[] { String.class.getName() });

	/**
	 * Returns the patient where patientEmailId = &#63; or throws a {@link com.knowarth.service.NoSuchpatientException} if it could not be found.
	 *
	 * @param patientEmailId the patient email ID
	 * @return the matching patient
	 * @throws com.knowarth.service.NoSuchpatientException if a matching patient could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patient findByEmailId(String patientEmailId)
		throws NoSuchpatientException, SystemException {
		patient patient = fetchByEmailId(patientEmailId);

		if (patient == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("patientEmailId=");
			msg.append(patientEmailId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchpatientException(msg.toString());
		}

		return patient;
	}

	/**
	 * Returns the patient where patientEmailId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param patientEmailId the patient email ID
	 * @return the matching patient, or <code>null</code> if a matching patient could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patient fetchByEmailId(String patientEmailId)
		throws SystemException {
		return fetchByEmailId(patientEmailId, true);
	}

	/**
	 * Returns the patient where patientEmailId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param patientEmailId the patient email ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching patient, or <code>null</code> if a matching patient could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patient fetchByEmailId(String patientEmailId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { patientEmailId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILID,
					finderArgs, this);
		}

		if (result instanceof patient) {
			patient patient = (patient)result;

			if (!Validator.equals(patientEmailId, patient.getPatientEmailId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PATIENT_WHERE);

			boolean bindPatientEmailId = false;

			if (patientEmailId == null) {
				query.append(_FINDER_COLUMN_EMAILID_PATIENTEMAILID_1);
			}
			else if (patientEmailId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILID_PATIENTEMAILID_3);
			}
			else {
				bindPatientEmailId = true;

				query.append(_FINDER_COLUMN_EMAILID_PATIENTEMAILID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPatientEmailId) {
					qPos.add(patientEmailId);
				}

				List<patient> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"patientPersistenceImpl.fetchByEmailId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					patient patient = list.get(0);

					result = patient;

					cacheResult(patient);

					if ((patient.getPatientEmailId() == null) ||
							!patient.getPatientEmailId().equals(patientEmailId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILID,
							finderArgs, patient);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (patient)result;
		}
	}

	/**
	 * Removes the patient where patientEmailId = &#63; from the database.
	 *
	 * @param patientEmailId the patient email ID
	 * @return the patient that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patient removeByEmailId(String patientEmailId)
		throws NoSuchpatientException, SystemException {
		patient patient = findByEmailId(patientEmailId);

		return remove(patient);
	}

	/**
	 * Returns the number of patients where patientEmailId = &#63;.
	 *
	 * @param patientEmailId the patient email ID
	 * @return the number of matching patients
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailId(String patientEmailId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILID;

		Object[] finderArgs = new Object[] { patientEmailId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATIENT_WHERE);

			boolean bindPatientEmailId = false;

			if (patientEmailId == null) {
				query.append(_FINDER_COLUMN_EMAILID_PATIENTEMAILID_1);
			}
			else if (patientEmailId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILID_PATIENTEMAILID_3);
			}
			else {
				bindPatientEmailId = true;

				query.append(_FINDER_COLUMN_EMAILID_PATIENTEMAILID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPatientEmailId) {
					qPos.add(patientEmailId);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAILID_PATIENTEMAILID_1 = "patient.patientEmailId IS NULL";
	private static final String _FINDER_COLUMN_EMAILID_PATIENTEMAILID_2 = "patient.patientEmailId = ?";
	private static final String _FINDER_COLUMN_EMAILID_PATIENTEMAILID_3 = "(patient.patientEmailId IS NULL OR patient.patientEmailId = '')";

	public patientPersistenceImpl() {
		setModelClass(patient.class);
	}

	/**
	 * Caches the patient in the entity cache if it is enabled.
	 *
	 * @param patient the patient
	 */
	@Override
	public void cacheResult(patient patient) {
		EntityCacheUtil.putResult(patientModelImpl.ENTITY_CACHE_ENABLED,
			patientImpl.class, patient.getPrimaryKey(), patient);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILID,
			new Object[] { patient.getPatientEmailId() }, patient);

		patient.resetOriginalValues();
	}

	/**
	 * Caches the patients in the entity cache if it is enabled.
	 *
	 * @param patients the patients
	 */
	@Override
	public void cacheResult(List<patient> patients) {
		for (patient patient : patients) {
			if (EntityCacheUtil.getResult(
						patientModelImpl.ENTITY_CACHE_ENABLED,
						patientImpl.class, patient.getPrimaryKey()) == null) {
				cacheResult(patient);
			}
			else {
				patient.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all patients.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(patientImpl.class.getName());
		}

		EntityCacheUtil.clearCache(patientImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the patient.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(patient patient) {
		EntityCacheUtil.removeResult(patientModelImpl.ENTITY_CACHE_ENABLED,
			patientImpl.class, patient.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(patient);
	}

	@Override
	public void clearCache(List<patient> patients) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (patient patient : patients) {
			EntityCacheUtil.removeResult(patientModelImpl.ENTITY_CACHE_ENABLED,
				patientImpl.class, patient.getPrimaryKey());

			clearUniqueFindersCache(patient);
		}
	}

	protected void cacheUniqueFindersCache(patient patient) {
		if (patient.isNew()) {
			Object[] args = new Object[] { patient.getPatientEmailId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILID, args,
				patient);
		}
		else {
			patientModelImpl patientModelImpl = (patientModelImpl)patient;

			if ((patientModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { patient.getPatientEmailId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILID, args,
					patient);
			}
		}
	}

	protected void clearUniqueFindersCache(patient patient) {
		patientModelImpl patientModelImpl = (patientModelImpl)patient;

		Object[] args = new Object[] { patient.getPatientEmailId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILID, args);

		if ((patientModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILID.getColumnBitmask()) != 0) {
			args = new Object[] { patientModelImpl.getOriginalPatientEmailId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILID, args);
		}
	}

	/**
	 * Creates a new patient with the primary key. Does not add the patient to the database.
	 *
	 * @param patientId the primary key for the new patient
	 * @return the new patient
	 */
	@Override
	public patient create(long patientId) {
		patient patient = new patientImpl();

		patient.setNew(true);
		patient.setPrimaryKey(patientId);

		return patient;
	}

	/**
	 * Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient that was removed
	 * @throws com.knowarth.service.NoSuchpatientException if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patient remove(long patientId)
		throws NoSuchpatientException, SystemException {
		return remove((Serializable)patientId);
	}

	/**
	 * Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patient
	 * @return the patient that was removed
	 * @throws com.knowarth.service.NoSuchpatientException if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patient remove(Serializable primaryKey)
		throws NoSuchpatientException, SystemException {
		Session session = null;

		try {
			session = openSession();

			patient patient = (patient)session.get(patientImpl.class, primaryKey);

			if (patient == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchpatientException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(patient);
		}
		catch (NoSuchpatientException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected patient removeImpl(patient patient) throws SystemException {
		patient = toUnwrappedModel(patient);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patient)) {
				patient = (patient)session.get(patientImpl.class,
						patient.getPrimaryKeyObj());
			}

			if (patient != null) {
				session.delete(patient);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (patient != null) {
			clearCache(patient);
		}

		return patient;
	}

	@Override
	public patient updateImpl(com.knowarth.service.model.patient patient)
		throws SystemException {
		patient = toUnwrappedModel(patient);

		boolean isNew = patient.isNew();

		Session session = null;

		try {
			session = openSession();

			if (patient.isNew()) {
				session.save(patient);

				patient.setNew(false);
			}
			else {
				session.merge(patient);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !patientModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(patientModelImpl.ENTITY_CACHE_ENABLED,
			patientImpl.class, patient.getPrimaryKey(), patient);

		clearUniqueFindersCache(patient);
		cacheUniqueFindersCache(patient);

		return patient;
	}

	protected patient toUnwrappedModel(patient patient) {
		if (patient instanceof patientImpl) {
			return patient;
		}

		patientImpl patientImpl = new patientImpl();

		patientImpl.setNew(patient.isNew());
		patientImpl.setPrimaryKey(patient.getPrimaryKey());

		patientImpl.setPatientId(patient.getPatientId());
		patientImpl.setPatientName(patient.getPatientName());
		patientImpl.setPatientEmailId(patient.getPatientEmailId());
		patientImpl.setPatientAge(patient.getPatientAge());

		return patientImpl;
	}

	/**
	 * Returns the patient with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the patient
	 * @return the patient
	 * @throws com.knowarth.service.NoSuchpatientException if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patient findByPrimaryKey(Serializable primaryKey)
		throws NoSuchpatientException, SystemException {
		patient patient = fetchByPrimaryKey(primaryKey);

		if (patient == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchpatientException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return patient;
	}

	/**
	 * Returns the patient with the primary key or throws a {@link com.knowarth.service.NoSuchpatientException} if it could not be found.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient
	 * @throws com.knowarth.service.NoSuchpatientException if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patient findByPrimaryKey(long patientId)
		throws NoSuchpatientException, SystemException {
		return findByPrimaryKey((Serializable)patientId);
	}

	/**
	 * Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patient
	 * @return the patient, or <code>null</code> if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patient fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		patient patient = (patient)EntityCacheUtil.getResult(patientModelImpl.ENTITY_CACHE_ENABLED,
				patientImpl.class, primaryKey);

		if (patient == _nullpatient) {
			return null;
		}

		if (patient == null) {
			Session session = null;

			try {
				session = openSession();

				patient = (patient)session.get(patientImpl.class, primaryKey);

				if (patient != null) {
					cacheResult(patient);
				}
				else {
					EntityCacheUtil.putResult(patientModelImpl.ENTITY_CACHE_ENABLED,
						patientImpl.class, primaryKey, _nullpatient);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(patientModelImpl.ENTITY_CACHE_ENABLED,
					patientImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return patient;
	}

	/**
	 * Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientId the primary key of the patient
	 * @return the patient, or <code>null</code> if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public patient fetchByPrimaryKey(long patientId) throws SystemException {
		return fetchByPrimaryKey((Serializable)patientId);
	}

	/**
	 * Returns all the patients.
	 *
	 * @return the patients
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<patient> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<patient> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<patient> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<patient> list = (List<patient>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PATIENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PATIENT;

				if (pagination) {
					sql = sql.concat(patientModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<patient>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<patient>(list);
				}
				else {
					list = (List<patient>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the patients from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (patient patient : findAll()) {
			remove(patient);
		}
	}

	/**
	 * Returns the number of patients.
	 *
	 * @return the number of patients
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PATIENT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the patient persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.knowarth.service.model.patient")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<patient>> listenersList = new ArrayList<ModelListener<patient>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<patient>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(patientImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PATIENT = "SELECT patient FROM patient patient";
	private static final String _SQL_SELECT_PATIENT_WHERE = "SELECT patient FROM patient patient WHERE ";
	private static final String _SQL_COUNT_PATIENT = "SELECT COUNT(patient) FROM patient patient";
	private static final String _SQL_COUNT_PATIENT_WHERE = "SELECT COUNT(patient) FROM patient patient WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "patient.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No patient exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No patient exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(patientPersistenceImpl.class);
	private static patient _nullpatient = new patientImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<patient> toCacheModel() {
				return _nullpatientCacheModel;
			}
		};

	private static CacheModel<patient> _nullpatientCacheModel = new CacheModel<patient>() {
			@Override
			public patient toEntityModel() {
				return _nullpatient;
			}
		};
}