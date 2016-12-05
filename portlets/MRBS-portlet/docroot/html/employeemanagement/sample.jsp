<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

Select Time Zone: 

<liferay-ui:input-time-zone
    name="timezone"
    value="Europe/Paris"
    displayStyle="0"
/>