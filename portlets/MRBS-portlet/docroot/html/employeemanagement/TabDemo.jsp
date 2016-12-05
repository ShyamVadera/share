<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<theme:defineObjects/>
<portlet:defineObjects/>
<%
String tab=request.getParameter("tabs21");
System.out.println(tab);
%>
<c:out value="${tabs}"></c:out>
<liferay-ui:tabs names="tab1,tab2,tab3" tabsValues="tab1,tab2,tab3" param="tabs21" value="tab3">
<liferay-ui:section>Tab1</liferay-ui:section>
<liferay-ui:section>Tab2</liferay-ui:section>
<liferay-ui:section>Tab3</liferay-ui:section>

</liferay-ui:tabs>