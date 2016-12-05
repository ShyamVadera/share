<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<portlet:defineObjects />
<theme:defineObjects/>
<portlet:actionURL name="addPatient" var="addPatientURL">
</portlet:actionURL>
<portlet:resourceURL var="resourceURL">
</portlet:resourceURL>
<aui:script>
function ajaxCall(){
  
   AUI().use('aui-io-request',function(A){
	   var patientEmailId=A.one("#<portlet:namespace/>patientEmailId").get('value');
	   var patientName=A.one("#<portlet:namespace/>patientName").get('value');
	   var patientId=A.one("#<portlet:namespace/>patientId").get('value');
	   alert(patientEmailId);
	   alert(patientName);
	   A.io.request("${resourceURL}",{
		  data:{
			  <portlet:namespace/>patientEmailId: patientEmailId,
              <portlet:namespace/>patientName: patientName,
              <portlet:namespace/>patientId: patientId,
                
		  }
	   
	  });
})
}
</aui:script>
<aui:form action="${addPatientURL}" method="post">
<aui:input name="patientId" type="hidden" value="${patient.patientId}"></aui:input>
<aui:input name="patientName" label="patientName" value="${patient.patientName}">
<aui:validator name="alpha"></aui:validator>
</aui:input>
<aui:input name="patientEmailId" label="patientEmailId" value="${patient.patientEmailId}" onChange="ajaxCall()">
<aui:validator name="email"></aui:validator>
</aui:input>
<aui:input name="patientAge" label="patientAge" value="${patient.patientAge}">
<aui:validator name="number"></aui:validator>
</aui:input>
<aui:input name="" value="Add Patient" type="submit"></aui:input>
</aui:form>
