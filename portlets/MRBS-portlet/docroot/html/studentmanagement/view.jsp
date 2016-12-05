<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:renderURL var="AddStateURL">
<portlet:param name="request" value="AddState"/>
</portlet:renderURL>
<%-- <portlet:renderURL var="addStudent">
<portlet:param name="request" value="addStudent"/>
</portlet:renderURL> --%>
This is the <b>State Management</b> portlet in View mode.
<a href="${AddStateURL}">Click Here to add States</a>