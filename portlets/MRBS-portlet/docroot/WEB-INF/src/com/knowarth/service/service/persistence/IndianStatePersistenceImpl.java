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

import com.knowarth.service.NoSuchIndianStateException;
import com.knowarth.service.model.IndianState;
import com.knowarth.service.model.impl.IndianStateImpl;
import com.knowarth.service.model.impl.IndianStateModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the indian state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author shyam.vadera
 * @see IndianStatePersistence
 * @see IndianStateUtil
 * @generated
 */
public class IndianStatePersistenceImpl extends BasePersistenceImpl<IndianState>
	implements IndianStatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IndianStateUtil} to access the indian state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IndianStateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IndianStateModelImpl.ENTITY_CACHE_ENABLED,
			IndianStateModelImpl.FINDER_CACHE_ENABLED, IndianStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IndianStateModelImpl.ENTITY_CACHE_ENABLED,
			IndianStateModelImpl.FINDER_CACHE_ENABLED, IndianStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IndianStateModelImpl.ENTITY_CACHE_ENABLED,
			IndianStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public IndianStatePersistenceImpl() {
		setModelClass(IndianState.class);
	}

	/**
	 * Caches the indian state in the entity cache if it is enabled.
	 *
	 * @param indianState the indian state
	 */
	@Override
	public void cacheResult(IndianState indianState) {
		EntityCacheUtil.putResult(IndianStateModelImpl.ENTITY_CACHE_ENABLED,
			IndianStateImpl.class, indianState.getPrimaryKey(), indianState);

		indianState.resetOriginalValues();
	}

	/**
	 * Caches the indian states in the entity cache if it is enabled.
	 *
	 * @param indianStates the indian states
	 */
	@Override
	public void cacheResult(List<IndianState> indianStates) {
		for (IndianState indianState : indianStates) {
			if (EntityCacheUtil.getResult(
						IndianStateModelImpl.ENTITY_CACHE_ENABLED,
						IndianStateImpl.class, indianState.getPrimaryKey()) == null) {
				cacheResult(indianState);
			}
			else {
				indianState.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all indian states.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IndianStateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IndianStateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the indian state.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IndianState indianState) {
		EntityCacheUtil.removeResult(IndianStateModelImpl.ENTITY_CACHE_ENABLED,
			IndianStateImpl.class, indianState.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<IndianState> indianStates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (IndianState indianState : indianStates) {
			EntityCacheUtil.removeResult(IndianStateModelImpl.ENTITY_CACHE_ENABLED,
				IndianStateImpl.class, indianState.getPrimaryKey());
		}
	}

	/**
	 * Creates a new indian state with the primary key. Does not add the indian state to the database.
	 *
	 * @param stateId the primary key for the new indian state
	 * @return the new indian state
	 */
	@Override
	public IndianState create(long stateId) {
		IndianState indianState = new IndianStateImpl();

		indianState.setNew(true);
		indianState.setPrimaryKey(stateId);

		return indianState;
	}

	/**
	 * Removes the indian state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateId the primary key of the indian state
	 * @return the indian state that was removed
	 * @throws com.knowarth.service.NoSuchIndianStateException if a indian state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IndianState remove(long stateId)
		throws NoSuchIndianStateException, SystemException {
		return remove((Serializable)stateId);
	}

	/**
	 * Removes the indian state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the indian state
	 * @return the indian state that was removed
	 * @throws com.knowarth.service.NoSuchIndianStateException if a indian state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IndianState remove(Serializable primaryKey)
		throws NoSuchIndianStateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			IndianState indianState = (IndianState)session.get(IndianStateImpl.class,
					primaryKey);

			if (indianState == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIndianStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(indianState);
		}
		catch (NoSuchIndianStateException nsee) {
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
	protected IndianState removeImpl(IndianState indianState)
		throws SystemException {
		indianState = toUnwrappedModel(indianState);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(indianState)) {
				indianState = (IndianState)session.get(IndianStateImpl.class,
						indianState.getPrimaryKeyObj());
			}

			if (indianState != null) {
				session.delete(indianState);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (indianState != null) {
			clearCache(indianState);
		}

		return indianState;
	}

	@Override
	public IndianState updateImpl(
		com.knowarth.service.model.IndianState indianState)
		throws SystemException {
		indianState = toUnwrappedModel(indianState);

		boolean isNew = indianState.isNew();

		Session session = null;

		try {
			session = openSession();

			if (indianState.isNew()) {
				session.save(indianState);

				indianState.setNew(false);
			}
			else {
				session.merge(indianState);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(IndianStateModelImpl.ENTITY_CACHE_ENABLED,
			IndianStateImpl.class, indianState.getPrimaryKey(), indianState);

		return indianState;
	}

	protected IndianState toUnwrappedModel(IndianState indianState) {
		if (indianState instanceof IndianStateImpl) {
			return indianState;
		}

		IndianStateImpl indianStateImpl = new IndianStateImpl();

		indianStateImpl.setNew(indianState.isNew());
		indianStateImpl.setPrimaryKey(indianState.getPrimaryKey());

		indianStateImpl.setStateId(indianState.getStateId());
		indianStateImpl.setStateName(indianState.getStateName());

		return indianStateImpl;
	}

	/**
	 * Returns the indian state with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the indian state
	 * @return the indian state
	 * @throws com.knowarth.service.NoSuchIndianStateException if a indian state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IndianState findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIndianStateException, SystemException {
		IndianState indianState = fetchByPrimaryKey(primaryKey);

		if (indianState == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIndianStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return indianState;
	}

	/**
	 * Returns the indian state with the primary key or throws a {@link com.knowarth.service.NoSuchIndianStateException} if it could not be found.
	 *
	 * @param stateId the primary key of the indian state
	 * @return the indian state
	 * @throws com.knowarth.service.NoSuchIndianStateException if a indian state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IndianState findByPrimaryKey(long stateId)
		throws NoSuchIndianStateException, SystemException {
		return findByPrimaryKey((Serializable)stateId);
	}

	/**
	 * Returns the indian state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the indian state
	 * @return the indian state, or <code>null</code> if a indian state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IndianState fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		IndianState indianState = (IndianState)EntityCacheUtil.getResult(IndianStateModelImpl.ENTITY_CACHE_ENABLED,
				IndianStateImpl.class, primaryKey);

		if (indianState == _nullIndianState) {
			return null;
		}

		if (indianState == null) {
			Session session = null;

			try {
				session = openSession();

				indianState = (IndianState)session.get(IndianStateImpl.class,
						primaryKey);

				if (indianState != null) {
					cacheResult(indianState);
				}
				else {
					EntityCacheUtil.putResult(IndianStateModelImpl.ENTITY_CACHE_ENABLED,
						IndianStateImpl.class, primaryKey, _nullIndianState);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(IndianStateModelImpl.ENTITY_CACHE_ENABLED,
					IndianStateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return indianState;
	}

	/**
	 * Returns the indian state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateId the primary key of the indian state
	 * @return the indian state, or <code>null</code> if a indian state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IndianState fetchByPrimaryKey(long stateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stateId);
	}

	/**
	 * Returns all the indian states.
	 *
	 * @return the indian states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IndianState> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<IndianState> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<IndianState> findAll(int start, int end,
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

		List<IndianState> list = (List<IndianState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INDIANSTATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INDIANSTATE;

				if (pagination) {
					sql = sql.concat(IndianStateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<IndianState>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IndianState>(list);
				}
				else {
					list = (List<IndianState>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the indian states from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (IndianState indianState : findAll()) {
			remove(indianState);
		}
	}

	/**
	 * Returns the number of indian states.
	 *
	 * @return the number of indian states
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

				Query q = session.createQuery(_SQL_COUNT_INDIANSTATE);

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
	 * Initializes the indian state persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.knowarth.service.model.IndianState")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<IndianState>> listenersList = new ArrayList<ModelListener<IndianState>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<IndianState>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(IndianStateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INDIANSTATE = "SELECT indianState FROM IndianState indianState";
	private static final String _SQL_COUNT_INDIANSTATE = "SELECT COUNT(indianState) FROM IndianState indianState";
	private static final String _ORDER_BY_ENTITY_ALIAS = "indianState.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IndianState exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IndianStatePersistenceImpl.class);
	private static IndianState _nullIndianState = new IndianStateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<IndianState> toCacheModel() {
				return _nullIndianStateCacheModel;
			}
		};

	private static CacheModel<IndianState> _nullIndianStateCacheModel = new CacheModel<IndianState>() {
			@Override
			public IndianState toEntityModel() {
				return _nullIndianState;
			}
		};
}