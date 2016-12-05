<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<portlet:defineObjects />
<portlet:actionURL var="updateEmployee" name="updateEmployee"></portlet:actionURL>

<aui:form action="${updateEmployee}" method="post">
<aui:input name="employeeId" type="hidden" value="${edit.employeeId }"></aui:input>
<aui:input name="name" type="text" value="${edit.name}"></aui:input>
<aui:input name="age" type="text" value="${edit.age}"></aui:input>
<aui:input name="birthDate" type="text" value="${edit.birthDate}"></aui:input>
<aui:input name="joiningDate" type="text" value="${edit.joiningDate}"></aui:input>
<aui:input name="department" type="text" value="${edit.department}"></aui:input>
<aui:input  name="submit" type="submit" value="submit"></aui:input>

</aui:form>






