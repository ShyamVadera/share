<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%-- <portlet:actionURL name="addEmployee" var="addEmployeeURL">
<portlet:param name="mvcPath" value="/html/employeemanagement/addEmployee.jsp"/>
</portlet:actionURL>
 --%>
 <portlet:defineObjects />

 <portlet:renderURL var="addEmployee">

<portlet:param name="request" value="addEmployee"/>
</portlet:renderURL> 
<portlet:renderURL var="searchEmployee">
<portlet:param name="request" value="searchEmployee"/>
</portlet:renderURL> 
<portlet:renderURL var="tabDemo">
<portlet:param name="request" value="tabDemo"/>
</portlet:renderURL>

<aui:button onClick="${addEmployee}" value="Add Employee">

</aui:button>
<aui:button onClick="${searchEmployee}" value="Search Employee"></aui:button>
<aui:button onClick="${tabDemo}" value="Tab Demo"></aui:button>
<liferay-ui:search-container searchContainer="${searchContainer}">
	<liferay-ui:search-container-results
		results="${searchContainer.results}"
		total="${searchContainer.total}" />

	<liferay-ui:search-container-row
		className="com.knowarth.service.model.Employee"
		modelVar="aEmployee"
	>
	
		<liferay-ui:search-container-column-text property="employeeEmailId"></liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text property="companyId" />

		<liferay-ui:search-container-column-text property="employeeId" />

		<liferay-ui:search-container-column-text property="employeeName" />

		<liferay-ui:search-container-column-text property="userName" />
		<liferay-ui:search-container-column-text property="stateId" />
		

		<liferay-ui:search-container-column-text property="userId" />

		<liferay-ui:search-container-column-text align="right">
		<%@ include file="action.jsp" %>
		
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>