package com.knowarth.common.util;

import com.knowarth.service.model.Employee;
import com.knowarth.service.model.impl.EmployeeImpl;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;

public class EmployeeUtil {
	
	public static Employee getEmployee(ActionRequest actionRequest){
		
		Employee employee=new EmployeeImpl();
		employee.setEmployeeName(ParamUtil.getString(actionRequest,"employeeName"));
		employee.setEmployeeEmailId(ParamUtil.getString(actionRequest,"employeeEmailId"));
		employee.setStateId(ParamUtil.getLong(actionRequest,"state"));
		return employee;
	}

}
