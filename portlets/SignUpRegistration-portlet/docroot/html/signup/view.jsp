<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri= "http://alloy.liferay.com/tld/aui"  prefix="aui"%>
<portlet:defineObjects />
<portlet:actionURL name="addUser" var="addUserURL"></portlet:actionURL>
<aui:form action="${addUserURL}">
<aui:input name="companyName" label="companyName"></aui:input>
<aui:input name="contactPerson" label="contactPerson"></aui:input>
<aui:input name="address1" label="address1"></aui:input>
<aui:input name="address2" label="address2"></aui:input>
<aui:input name="city" label="city"></aui:input>
<aui:input name="pinCode" label="pinCode"></aui:input>
<aui:input name="country" label="country"></aui:input>
<aui:input name="mobileNumber" label="mobileNumber"></aui:input>
<aui:input name="emailId" label="emailId"></aui:input>

 <aui:select name="securityQuestion1"  label="securityQuestion1" required="true" >
          <aui:option>select question</aui:option>
        <aui:option value="What was your first phone number?" >What was your first phone number?</aui:option>
         <aui:option value="What is your father's middle name?">What is your father's middle name?</aui:option>
         <aui:option value="What was your favorite teacher's name?">What was your favorite teacher's name?</aui:option>
         <aui:option value="In what city/town was your first job?">In what city/town was your first job?</aui:option>
         <aui:option value="What was the first company you ever worked for?">What was the first company you ever worked for?</aui:option>
         <aui:option value="What was the first car you owned?">What was the first car you owned?</aui:option>
    </aui:select>
  <aui:input type="text" name="securityAnswer1" value=""  helpMessage="answer">
    <aui:validator name="required" ></aui:validator>
    </aui:input>
  <aui:select name="securityQuestion2"  label="securityQuestion2" required="true" >
          <aui:option>select question</aui:option>
        <aui:option value="What was your first phone number?" >What was your first phone number?</aui:option>
         <aui:option value="What is your father's middle name?">What is your father's middle name?</aui:option>
         <aui:option value="What was your favorite teacher's name?">What was your favorite teacher's name?</aui:option>
         <aui:option value="In what city/town was your first job?">In what city/town was your first job?</aui:option>
         <aui:option value="What was the first company you ever worked for?">What was the first company you ever worked for?</aui:option>
         <aui:option value="What was the first car you owned?">What was the first car you owned?</aui:option>
    </aui:select>
  <aui:input type="text" name="securityAnswer2" value=""  helpMessage="answer">
    <aui:validator name="required" ></aui:validator>
    </aui:input>

<aui:input type="submit" name="" value="Sign Up"></aui:input>




</aui:form>
This is the <b>Sign Up</b> portlet in View modes.
