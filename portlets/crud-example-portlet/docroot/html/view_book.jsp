<%@page import="com.proliferay.util.WebKeys"%>
<%@page import="com.proliferay.sbuilder.example.crud.model.Book"%>
<%@page import="com.proliferay.sbuilder.example.crud.service.BookLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/init.jsp" %>

<portlet:renderURL var="backURL">
	<portlet:param name="jspPage" value="/html/view.jsp"/>
</portlet:renderURL>

<liferay-ui:header backURL="<%=backURL%>" title="Back" />

<%
	Book book = (Book) request.getAttribute(WebKeys.BOOK_ENTRY);
%>


<aui:form>
	<aui:model-context bean="<%=book%>" model="<%=Book.class%>" />
	<aui:input name="bookName" label="Book Name" disabled="true"/>
	<aui:input type="textarea" name="description" label="Description" disabled="true"/>
	<aui:input name="authorName" label="Author Name" disabled="true"/>
	<aui:input name="isbn" label="ISBN" disabled="true"/>
	<aui:input name="price" label="Price" disabled="true"/>		
</aui:form>


