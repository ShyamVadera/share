

 <%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
 <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
 
 

 <liferay-ui:icon-menu>
 <portlet:actionURL var="editPatientURL" name="editPatient">
<portlet:param name="patientId" value="${apatient.patientId}"/> 
 </portlet:actionURL>
 <portlet:renderURL var="deactivatePatientURL">
 <portlet:param name="patientId" value="${apatient.patientId}"/> 
 </portlet:renderURL>

<portlet:actionURL var="deletePatientURL" name="deletePatient">
<portlet:param name="patientId" value="${apatient.patientId}"/> 
 </portlet:actionURL>
<liferay-ui:icon image="edit" url="${editPatientURL}" message="EditPatient"></liferay-ui:icon>
 
 <liferay-ui:icon-delete url="${deletePatientURL}" message="DeletePatient"></liferay-ui:icon-delete>
 <liferay-ui:icon-deactivate url="${deactivatePatientURL}"></liferay-ui:icon-deactivate>

 
 
 
 
 </liferay-ui:icon-menu>