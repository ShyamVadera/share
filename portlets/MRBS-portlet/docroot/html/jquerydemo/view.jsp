<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />
<theme:defineObjects/>
This is the <b>J Query Demo</b> portlet in View mode.
<portlet:resourceURL var="testAjaxResourceUrl"></portlet:resourceURL>

<a href="#" onclick="ajaxCall()">ResourceURL in Ajax</a>
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
<form id="fm" method="post">
Site<input type="text" name="<portlet:namespace/>site"><br/>
Author<input type="text" name="<portlet:namespace/>author">
<input type="button" value="CallServerResource" onclick="ajaxCall()">

</form>
<script type="text/javascript">


	function ajaxCall(){
	    AUI().use('aui-io-request-deprecated', function(A){
	        A.io.request("${resourceURL}",{
	       
	        	form:{
	        		id:'fm'
	        	}
	        	
	        	
	        	
	        });
	    });
	}
	 

</script>