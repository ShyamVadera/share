
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<liferay-theme:defineObjects />

<liferay-portlet:renderURL var="portletURL"/>

<% 
String tabValue = ParamUtil.getString(request, "tab", "sunday");
String tabsURL = "/jsps/" + tabValue.trim() + ".jsp";
String tabNames="Sunday,Monday,Tuesday" ;
String tabVal="sunday,monday,tuesday" ;
if(permissionChecker.isCompanyAdmin(themeDisplay.getCompanyId())){
	tabNames+=",Admin" ;
	tabVal+=",admin" ;
}
%>

<liferay-ui:tabs 
	names="<%=tabNames%>"
	tabsValues="<%=tabVal%>"
	param="tab" 
	url="<%= portletURL %>"
/>


<c:import url="<%= tabsURL %>"></c:import>
