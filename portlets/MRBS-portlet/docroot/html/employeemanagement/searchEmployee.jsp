<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:actionURL name="searchEmployee" var="searchEmployeeURL">
<portlet:param name="request" value="searchEmp"/>
</portlet:actionURL>
<aui:form action="${searchEmployeeURL}" method="post">
<aui:input name="employeeName" type="text"></aui:input>
<aui:input name="submit" type="submit"></aui:input>
</aui:form>
<c:if test="${not empty searchContainer}">

<liferay-ui:search-container searchContainer="${searchContainer}">
	<liferay-ui:search-container-results
		results="${searchContainer.results}"
		total="${searchContainer.total}"
/>

	<liferay-ui:search-container-row
		className="com.knowarth.service.model.Employee"
		modelVar="aEmployee"
	>
	
		<liferay-ui:search-container-column-text property="employeeId" />

		<liferay-ui:search-container-column-text property="employeeName" />
 <liferay-ui:search-container-column-text align="right">
<%@ include file="action.jsp" %>
</liferay-ui:search-container-column-text> 
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</c:if>