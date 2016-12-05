<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />
<portlet:renderURL var="addPatientURL">
<portlet:param name="jspPage" value="/html/patientmanagement/addPatient.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="tabDemoURL">
<portlet:param name="jspPage" value="/html/patientmanagement/demoTabs.jsp"/>
</portlet:renderURL>
<liferay-ui:error key="DuplicateEmail" message="DuplicateEmail"></liferay-ui:error>

<a href="${tabDemoURL}">Tab Demo</a>
<a href="${addPatientURL}"><h3>AddPatient</h3></a>
<liferay-ui:search-container searchContainer="${searchContainer}" orderByCol="${searchContainer.orderByCol}"
orderByType="${searchContainer.orderByType}" delta="5" deltaConfigurable="true"
>
	<liferay-ui:search-container-results
		results="${searchContainer.results}"
		total="${searchContainer.total}"
	/>

	<liferay-ui:search-container-row
		className="com.knowarth.service.model.patient"
		modelVar="apatient"
	>
	<liferay-ui:search-container-column-text property="patientId" orderable="true" orderableProperty="patientId" />
	<liferay-ui:search-container-column-text property="patientName" orderable="true"  orderableProperty="patientName"/>
		
		<liferay-ui:search-container-column-text property="patientEmailId" orderable="true" orderableProperty="patientEmailId"/>
	
		<liferay-ui:search-container-column-text property="patientAge" />

<liferay-ui:search-container-column-text align="right">
<%@ include file="action.jsp"%> 

</liferay-ui:search-container-column-text>
	
		
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>