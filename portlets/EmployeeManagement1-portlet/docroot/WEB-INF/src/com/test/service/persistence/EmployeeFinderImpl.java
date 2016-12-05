package com.test.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.test.model.*;
import com.test.model.impl.EmployeeImpl;
import java.util.List;
import org.apache.log4j.Logger;

public class EmployeeFinderImpl extends BasePersistenceImpl<Employee> implements EmployeeFinder {

	private  static Logger log=Logger.getLogger(EmployeeFinderImpl.class);

	public List<Employee> getEmployeeByEmailId(long employeeId,String emailId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get("employeeEmailValidationSQLQuery");
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addEntity("Employee", EmployeeImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(employeeId);
			qPos.add(emailId);
			return (List<Employee>) queryObject.list();	
		} catch (Exception e) {
			log.error("error occured" +e);
		}
		closeSession(session);
		return null;
	}
}
