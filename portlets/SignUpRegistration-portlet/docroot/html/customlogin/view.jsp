<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui"  prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />
<portlet:actionURL name="Login" var="loginActionURL"></portlet:actionURL>
<liferay-ui:error key="EMAIL_NOT_EXIST-key" message="email-not-found"></liferay-ui:error>
<liferay-ui:error key="WRONG_PASSWORD-key" message="WRONG_PASSWORD-key"></liferay-ui:error>
<aui:form action="${loginActionURL}">
<aui:input name="emailId" label="emailId"></aui:input>
<aui:input name="userPassord" type="password" label="password"></aui:input>
<aui:input name="" type="submit" value="Login"></aui:input>
</aui:form>

