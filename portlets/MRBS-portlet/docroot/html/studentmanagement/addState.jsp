
    <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
    <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
    <portlet:defineObjects/>

<portlet:actionURL name="addState" var="addStateURL">
</portlet:actionURL>
<aui:form action="${addStateURL}">
<aui:input name="stateName" type="text"></aui:input>
<aui:input value="AddState" name="" type="submit"></aui:input>

</aui:form>
