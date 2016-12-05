package com.knowarth.jquery.demo;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;



/**
 * Portlet implementation class JQueryDemo
 */
public class JQueryDemo extends MVCPortlet {
 
@Override
public void serveResource(ResourceRequest resourceRequest,
		ResourceResponse resourceResponse) throws IOException,
		PortletException {
String site=ParamUtil.getString(resourceRequest,"site");
String author=ParamUtil.getString(resourceRequest,"author");
System.out.println(site+author);
	super.serveResource(resourceRequest, resourceResponse);
}
}
