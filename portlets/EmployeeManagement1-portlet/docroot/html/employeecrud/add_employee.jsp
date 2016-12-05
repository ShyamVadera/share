<%@ include file="init.jsp"%>

<portlet:actionURL name="addEmployee" var="updateDetails"></portlet:actionURL>
	<liferay-ui:error key="emailId-already-registered"
	message="emailId-already-registered" />
	<liferay-ui:error key="invalid-date-error" message="invalid-date-error"/>
	<liferay-ui:error key="add-or-edit-record-error" message="add-or-edit-record-error"/>
<aui:form action="${updateDetails}" method="post">
	<aui:input name="employeeId" type="hidden" value="${edit.employeeId }"></aui:input>
	<aui:input name="name" type="text" value="${edit.name}">
		<aui:validator name="required"></aui:validator>
		<aui:validator name="alpha"></aui:validator>
	</aui:input>
	<aui:input name="age" type="number" value="${edit.age}">
		<aui:validator name="min">20</aui:validator>
	</aui:input>
	<liferay-ui:message key="birthDate"></liferay-ui:message>
	<br>
	<liferay-ui:input-date yearValue="${birthYear}" dayValue="${birthDay}"
		monthValue="${birthMonth}" dayParam="day" monthParam="month"
		yearParam="year" name="birthDate">
	</liferay-ui:input-date>
	<br>
	<liferay-ui:message key="joiningDate"></liferay-ui:message>
	<br>
	<liferay-ui:input-date yearValue="${joiningYear}" dayValue="${joiningDay}"
		monthValue="${joiningMonth}" dayParam="day"
		monthParam="month" yearParam="year" name="joiningDate" />
	<br>
	<aui:input name="department" type="text" value="${edit.department}">
		<aui:validator name="required"></aui:validator>
		<aui:validator name="alpha"></aui:validator>
	</aui:input>
	<aui:input name="emailId" type="string" value="${edit.emailId}"
		label="emailId">
		<aui:validator name="email"></aui:validator>
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:select name="countries" label="countryName">
		<c:forEach items="${countryList}" var="country">
			<aui:option name="count"
				value="${country.getName(themeDisplay.getLocale())}">${country.getName(themeDisplay.getLocale())}</aui:option>
		</c:forEach>
	</aui:select>
	<aui:input name="" type="submit" value="Submit-detail"></aui:input>
</aui:form>