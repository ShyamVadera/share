package com.knowarth.employee;

import com.knowarth.common.util.EmployeeUtil;
import com.knowarth.employee.dynamicquery.HelperClass;
import com.knowarth.service.model.Employee;
import com.knowarth.service.model.IndianState;
import com.knowarth.service.service.EmployeeLocalServiceUtil;
import com.knowarth.service.service.IndianStateLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

/**
 * Portlet implementation class EmployeeManagement
 */
public class EmployeeManagement extends MVCPortlet {

	private static Logger log=Logger.getLogger(EmployeeManagement.class); 


	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		log.info("render called");
		String renderRequest=ParamUtil.getString(request, "request");
		String tab=ParamUtil.get(request,"tabs","tab2");
		request.setAttribute("Current tab value",tab);
		log.info("Current tab is"+tab);
		List<IndianState> indianStates = null;
		List<String> states=null;
		if(Validator.equals(renderRequest,"addEmployee")){
			try {
				indianStates=searchState();
			} catch (SystemException e) {

			}

			for(int i=0;i<indianStates.size();i++){
				IndianState indianState=indianStates.get(i);
				System.out.println(indianState.getStateName());
			}
			request.setAttribute("indianState",indianStates);
			PortletRequestDispatcher requestDispatcher=getPortletContext().getRequestDispatcher("/html/employeemanagement/addEmployee.jsp");
			requestDispatcher.include(request,response);
		}
		else if(Validator.equals(renderRequest,"searchEmployee")){
			PortletRequestDispatcher requestDispatcher=getPortletContext().getRequestDispatcher("/html/employeemanagement/searchEmployee.jsp");
			requestDispatcher.include(request,response);
		}
		else if(Validator.equals(renderRequest,"searchEmp")){
			log.info("Inside searchEmp");
			PortletRequestDispatcher requestDispatcher=getPortletContext().getRequestDispatcher("/html/employeemanagement/searchEmployee.jsp");
			requestDispatcher.include(request, response);
		}
		else if(Validator.equals(renderRequest,"tabDemo")){
			PortletRequestDispatcher dispatcher=getPortletContext().getRequestDispatcher("/html/employeemanagement/TabDemo.jsp");
			dispatcher.include(request, response);
		}
		else{
			try {
				log.info("inside try");
				SearchContainer<Employee> searchContainer=getSearchContainer(request, response);
				log.info(searchContainer.getTotal());
				request.setAttribute("searchContainer",searchContainer);
				PortletRequestDispatcher requestDispatcher=getPortletContext().getRequestDispatcher("/html/employeemanagement/view.jsp");
				requestDispatcher.include(request,response);
			} catch (SystemException e) {

			}
		}

	}
	private List<IndianState> searchState() throws SystemException{
		List<IndianState> indianStates=IndianStateLocalServiceUtil.getIndianStates(-1,-1);
		return indianStates;
	}

	private SearchContainer<Employee> getSearchContainer(RenderRequest renderRequest,RenderResponse renderResponse) throws SystemException{

		SearchContainer< Employee> searchContainer=new SearchContainer<>(renderRequest,renderResponse.createRenderURL(),null,"No Employee");
		List<Employee> allEmployee=EmployeeLocalServiceUtil.getEmployees(searchContainer.getStart(),searchContainer.getEnd());
		List<Employee> sortableEmployee=new ArrayList<Employee>(allEmployee);
		int total=EmployeeLocalServiceUtil.getEmployeesCount();
		searchContainer.setTotal(total);
		searchContainer.setResults(sortableEmployee);
		return searchContainer;
	}
	@ProcessAction(name="addEmployee")
	public void addEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, SystemException, PortalException {
		log.info("add method called");
		ThemeDisplay themeDisplay=(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Employee employee=EmployeeUtil.getEmployee(actionRequest);
		long currentUser=themeDisplay.getUserId();
		long groupId=themeDisplay.getCompanyId();
		long companyId=themeDisplay.getCompanyId();
		User user=UserLocalServiceUtil.getUser(currentUser);
		String screenName=user.getScreenName();
		employee.setUserName(screenName);
		employee.setUserId(currentUser);
		employee.setGroupId(groupId);
		employee.setCompanyId(companyId);
		EmployeeLocalServiceUtil.addEmployee(employee);
		//HelperClass.sendMail(employee.getEmployeeEmailId());
		HelperClass.searchEmployeeName();
		log.info("Employee Added Successfully");

	}

	@ProcessAction(name="deleteEmployee")
	public void deleteEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {
		long employeeId=ParamUtil.getLong(actionRequest,"employeeId");
		log.info(employeeId);
		Employee employee=EmployeeLocalServiceUtil.getEmployee(employeeId);
		EmployeeLocalServiceUtil.deleteEmployee(employee);
		log.info("Employee Deleted Successfully");

	}
	@ProcessAction(name="searchEmployee")
	public void searchEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, SystemException {

		String employeeName=ParamUtil.getString(actionRequest,"employeeName");
		log.info("Search for"+employeeName);
		SearchContainer<Employee> searchContainer=getNewSearchContainer(actionRequest, actionResponse, employeeName);
		actionRequest.setAttribute("searchContainer",searchContainer);
		actionResponse.setRenderParameter("request","searchEmp");

	}

	SearchContainer<Employee> getNewSearchContainer(ActionRequest actionRequest,ActionResponse actionResponse,String employeeName) throws SystemException{

		SearchContainer<Employee> container=new SearchContainer<Employee>();
		List<Employee> employees=HelperClass.searchEmployee(employeeName);
		container.setResults(employees);
		container.setTotal(employees.size());
		return container;
	}

}
