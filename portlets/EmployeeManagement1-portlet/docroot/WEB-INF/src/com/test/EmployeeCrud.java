package com.test;

import com.knowarth.employee.ActionUtil;
import com.knowarth.employee.customExceptions.EmailIdAlreadyExistsException;
import com.knowarth.employee.customExceptions.InvalidDateException;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.test.model.Employee;
import com.test.service.EmployeeLocalServiceUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.log4j.Logger;

/**
 * This controller is for Employee management
 * 
 * @author rashmin.mishra
 */

public class EmployeeCrud extends MVCPortlet  {

	private static Logger log=Logger.getLogger(EmployeeCrud.class);

	/* 
	 * This method is for displaying and editing all employee records
	 */
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String addRecord=renderRequest.getParameter(EmployeeConstants.EMPLOYEE_PARAM_ADD);
		if(Validator.equals(addRecord,EmployeeConstants.EMPLOYEE_PARAM_ADD)||Validator.equals(addRecord,EmployeeConstants.EDIT_EMPLOYEE)||Validator.equals(addRecord,EmployeeConstants.EMPLOYEE_PARAM_PAGE_REDIRECT))
		{
			try {
				List<Country> countryList=CountryServiceUtil.getCountries();
				renderRequest.setAttribute(EmployeeConstants.COUNTRY_LIST, countryList); 
				if(Validator.equals(addRecord,EmployeeConstants.EDIT_EMPLOYEE))	{
					long editId=ParamUtil.getLong(renderRequest,EmployeeConstants.EDIT_PARAM_ID);
					Employee employee = EmployeeLocalServiceUtil.getEmployee(editId);
					Date birthDate=employee.getBirthDate();
					Date joiningDate=employee.getJoiningDate();
					Calendar cal=Calendar.getInstance();
					cal.setTime(birthDate);
					renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_PARAM_BIRTHYEAR,cal.get(Calendar.YEAR));
					renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_PARAM_BIRTHMONTH, cal.get(Calendar.MONTH));
					renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_PARAM_BIRTHDAY, cal.get(Calendar.DAY_OF_MONTH));
					cal.setTime(joiningDate);
					renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_PARAM_JOININGYEAR, cal.get(Calendar.YEAR));
					renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_PARAM_JOININGMONTH, cal.get(Calendar.MONTH));
					renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_PARAM_JOININGDAY, cal.get(Calendar.DAY_OF_MONTH));
					renderRequest.setAttribute(EmployeeConstants.EDIT_PARAM,employee);
				}
			} catch(Exception e) {
				SessionErrors.add(renderRequest,EmployeeConstants.EMPLOYEE_RECORD_ERROR);
			}
			PortletRequestDispatcher requestDispatcher=getPortletContext().getRequestDispatcher("/html/employeecrud/add_employee.jsp");
			requestDispatcher.include(renderRequest,renderResponse);
		}
		else {
			try{
				SearchContainer<Employee> searchContainer=getSearchContainer(renderRequest, renderResponse);
				renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_PARAM_SEARCH_CONTAINER, searchContainer);
				PortletRequestDispatcher requestDispatcher=getPortletContext().getRequestDispatcher("/html/employeecrud/view.jsp");
				requestDispatcher.include(renderRequest,renderResponse);
			} catch(Exception e){
				log.error("error while " +e);
				SessionErrors.add(renderRequest,EmployeeConstants.VIEW_EMPLOYEE_ERROR);
			}
		}
	}

	private static SearchContainer<Employee> getSearchContainer(RenderRequest renderRequest,RenderResponse renderResponse) 
	{
		try {
			SearchContainer<Employee> searchContainer = new SearchContainer<Employee>(renderRequest, renderResponse.createRenderURL(), null, EmployeeConstants.EMPLOYEE_PARAM_EMPTY_LIST);
			List<Employee> allEmployee = EmployeeLocalServiceUtil.getEmployees(searchContainer.getStart(), searchContainer.getEnd());
			List<Employee> sortableEmployee=new ArrayList<Employee>(allEmployee);
			int employeeCountValue=EmployeeLocalServiceUtil.getEmployeesCount();
			searchContainer.setTotal(employeeCountValue);
			String orderByCol = ParamUtil.get(renderRequest,EmployeeConstants.ORDER_BY_COL,EmployeeConstants.EMPLOYEE_PARAM_ID); 
			String orderByType=ParamUtil.get(renderRequest, EmployeeConstants.ORDER_BY_TYPE,EmployeeConstants.COLUMN_ORDER_ASC);
			searchContainer.setOrderByCol(orderByCol);
			searchContainer.setOrderByType(orderByType);
			Comparator<Employee> comparator=new BeanComparator(orderByCol, new NullComparator(false));
			Collections.sort(sortableEmployee, comparator);
			if(orderByType.equalsIgnoreCase(EmployeeConstants.COLUMN_ORDER_DESC)) {
				Collections.reverse(sortableEmployee);
			} for(int i=0;i<sortableEmployee.size();i++) {
				Employee employeeRecords=sortableEmployee.get(i);
				employeeRecords.setEmployeeBirthDate(employeeRecords.getBirthDate());	
				employeeRecords.setEmployeeJoiningDate(employeeRecords.getJoiningDate());
			}	
			searchContainer.setResults(sortableEmployee);
			return searchContainer;
		} catch (SystemException e) {
			log.error("error occured" +e);
			SessionErrors.add(renderRequest,EmployeeConstants.EMPLOYEE_PARAM_ERROR);
		}
		return null;
	}

	/*
	 * This method will add and update employee record in the table
	 */
	public void addEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortalException, PortletException {
		Employee employee=ActionUtil.getEmployeeByRequest(actionRequest);
		long employeeId=ParamUtil.getLong(actionRequest,EmployeeConstants.EMPLOYEE_PARAM_ID);
		employee.setEmployeeId(employeeId);
		log.info(employeeId);
		try {
			EmployeeLocalServiceUtil.saveEmployee(employee);
			log.info("Employee details submitted successfully");
			SessionMessages.add(actionRequest, EmployeeConstants.INSERT_EMPLOYEE_SUCCESSFUL);
		} catch(EmailIdAlreadyExistsException e) {
			log.error("EmailId exception" +e);
			actionResponse.setRenderParameter(EmployeeConstants.EMPLOYEE_PARAM_ADD,EmployeeConstants.EMPLOYEE_PARAM_PAGE_REDIRECT);
			SessionErrors.add(actionRequest,EmployeeConstants.EMAIL_ID_ALREADY_REGISTERED);
		} catch (InvalidDateException e) {
			log.error("invalid date" +e);
			actionResponse.setRenderParameter(EmployeeConstants.EMPLOYEE_PARAM_ADD,EmployeeConstants.EMPLOYEE_PARAM_PAGE_REDIRECT);
			SessionErrors.add(actionRequest,EmployeeConstants.EMPLOYEE_PARAM_DATE_ERROR);
		} catch (SystemException e) {
			SessionErrors.add(actionRequest,EmployeeConstants.EMPLOYEE_PARAM_ERROR);
		}
	} 

	/*
	 * This method will delete Employee record
	 */
	@ProcessAction(name="deleteEmployee")
	public void deleteEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		long employeeId=ParamUtil.getInteger(actionRequest, EmployeeConstants.DELETE_PARAM_ID);
		try {
			//Calling service method for deleting employee record
			EmployeeLocalServiceUtil.deleteEmployee(employeeId);
			log.info("employee record deleted successfully");
			SessionMessages.add(actionRequest,EmployeeConstants.REMOVE_EMPLOYEE_SUCCESSFUL);
		} 	catch (PortalException e) {
			log.error("error occured while deleting record" +e);
			SessionErrors.add(actionRequest,EmployeeConstants.EMPLOYEE_DELETE_ERROR);
		} 	catch (SystemException e){
			log.error("unexpected error occured while deleting record" +e);
			SessionErrors.add(actionRequest,EmployeeConstants.EMPLOYEE_PARAM_ERROR);
		}
	}
}