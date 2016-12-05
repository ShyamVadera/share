package com.knowarth.employee;

import com.liferay.portal.kernel.util.ParamUtil;
import com.test.EmployeeConstants;
import com.test.model.Employee;
import com.test.model.impl.EmployeeImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;

public class ActionUtil {
	
	public static Employee getEmployeeByRequest(ActionRequest request){
		Employee employee=new EmployeeImpl();
		
		
		DateFormat df=new SimpleDateFormat("MM/dd/yy");
		employee.setName(ParamUtil.getString(request,EmployeeConstants.EMPLOYEE_NAME));
		employee.setAge(ParamUtil.getInteger(request,EmployeeConstants.EMPLOYEE_AGE));
		employee.setBirthDate(ParamUtil.getDate(request, EmployeeConstants.BIRTH_DATE,df));
		employee.setJoiningDate(ParamUtil.getDate(request,EmployeeConstants.JOINING_DATE,df));
		employee.setDepartment(ParamUtil.getString(request,EmployeeConstants.DEPARTMENT));
		employee.setEmailId(ParamUtil.getString(request,EmployeeConstants.EMAIL_ID));
		employee.setCountry(ParamUtil.getString(request,EmployeeConstants.COUNTRIES));
		return employee;
	}
}

