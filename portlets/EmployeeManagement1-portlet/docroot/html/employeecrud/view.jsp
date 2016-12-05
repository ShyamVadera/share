<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ include file="init.jsp"%>

<portlet:renderURL var="viewaddPageURL">
	<portlet:param name="jspPage" value="add_employee.jsp" />
	<portlet:param name="addEmployee" value="addEmployee" />
</portlet:renderURL>
<aui:button value="insert-record-button" name="insert-record-button"
	type="button" onClick="${viewaddPageURL}"></aui:button>

<liferay-ui:success key="insert-employee-successful"
	message="insert-employee-successful" />
<liferay-ui:success key="update-employee-successful"
	message="update-employee-successful" />
<liferay-ui:success key="remove-employee-successful"
	message="remove-employee-successful" />
<liferay-ui:success key="edit-employee-page"
	message="edit-employee-page" />
<liferay-ui:error key="employee-delete-error"
	message="employee-delete-error" />
<liferay-ui:error key="employee-view-error"
	message="employee-view-error" />
<liferay-ui:error key="update-employee-error"
	message="update-employee-error" />
<liferay-ui:error key="emailId-already-registered"
	message="emailId-already-registered" />
<liferay-ui:error key="invalid-date-error" message="invalid-date-error"/>
<liferay-ui:error key="add-or-edit-record-error"/>

<liferay-ui:search-container
	searchContainer="${employeeRecordsSearchContainer}" delta="5"
	deltaConfigurable="true"
	orderByCol="${employeeRecordsSearchContainer.orderByCol}"
	orderByType="${employeeRecordsSearchContainer.orderByType}">
	<liferay-ui:search-container-results
		results="${employeeRecordsSearchContainer.results}"
		total="${employeeRecordsSearchContainer.total}" />
	<liferay-ui:search-container-row className="com.test.model.Employee"
		modelVar="s" keyProperty="employeeId">
		<liferay-ui:search-container-column-text orderable="true"
			orderableProperty="employeeId" property="employeeId"
			name="employeeId"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text orderable="true"
			orderableProperty="name" property="name" name="name"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text orderable="true"
			orderableProperty="age" property="age" name="age"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="employeeBirthDate"
			name="birthDate"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text
			property="employeeJoiningDate" name="joiningDate"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="department"
			name="department"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="emailId"
			name="emailId"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="country"
			name="country">
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text align="right">
			<%@ include file="action.jsp"%></liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>