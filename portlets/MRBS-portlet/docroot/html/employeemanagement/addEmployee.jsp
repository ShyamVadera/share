<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:actionURL name="addEmployee" var="addEmployeeURL"></portlet:actionURL>

<aui:form action="${addEmployeeURL}" method="post">
<aui:input name="employeeName" type="text"></aui:input>
<aui:input name="employeeEmailId" type="email"><aui:validator name="required"></aui:validator></aui:input>

<c:if test="${not empty indianState}">
<aui:select name="state" >
<c:forEach items="${indianState}" var="i">
<h3>hello</h3>
<aui:option value="${i.stateId}">${i.stateName}</aui:option> 
</c:forEach>

</aui:select>




</c:if>
<aui:input name="submit" type="submit"></aui:input>
</aui:form>