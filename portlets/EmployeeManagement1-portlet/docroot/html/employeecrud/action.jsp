<%@ include file="init.jsp"%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editEmployee">
		<portlet:param name="addEmployee" value="editEmployee" />
		<portlet:param name="editId" value="${s.employeeId}" />
	</portlet:renderURL>

	<portlet:actionURL var="deleteEmployee" name="deleteEmployee">
		<portlet:param name="deleteId" value="${s.employeeId}" />
	</portlet:actionURL>

	<liferay-ui:icon image="edit" message="edit" url="${editEmployee}">
	</liferay-ui:icon>
	<liferay-ui:icon-delete image="delete" message="delete"
		url="${deleteEmployee}">
	</liferay-ui:icon-delete>


</liferay-ui:icon-menu>