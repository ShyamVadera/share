<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<portlet:defineObjects/>

<portlet:renderURL var="tabURL"></portlet:renderURL>

<liferay-ui:tabs names="BasicDetails,ContactDetails" url="${tabURL}"   param="tabs"></liferay-ui:tabs>

<c:if test="${fn:containsIgnoreCase(tabs,'BasicDetails')}">
<%@ include file="/html/tabdemo/BasicDetails.jsp" %>

</c:if>
<c:if test="${fn:containsIgnoreCase(tabs,'ContactDetails')}">

<%@ include file="/html/tabdemo/ContactDetails.jsp" %>
</c:if>
