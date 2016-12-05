<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-ui:icon-menu>
<portlet:actionURL name="deleteEmployee" var="deleteEmployeeURL">
<portlet:param name="employeeId" value="${aEmployee.employeeId}"/>

</portlet:actionURL>

<liferay-ui:icon image="edit" url="editEmployee"></liferay-ui:icon>
<liferay-ui:icon image="delete" url="${deleteEmployeeURL}"></liferay-ui:icon>
</liferay-ui:icon-menu>