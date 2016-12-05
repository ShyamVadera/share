<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<portlet:defineObjects/>

<portlet:renderURL var="tabURL"></portlet:renderURL>

<liferay-ui:tabs names="Tab One,Tab Two" url="${tabURL}"  tabsValues="one,two"  param="tabs"></liferay-ui:tabs>
<c:out value="${tabs}"></c:out> 
