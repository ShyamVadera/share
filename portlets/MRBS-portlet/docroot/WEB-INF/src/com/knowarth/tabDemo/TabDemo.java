package com.knowarth.tabDemo;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class TabDemo
 */
public class TabDemo extends MVCPortlet {
 
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		
		String tab=ParamUtil.getString(renderRequest, "tabs","TabOne");
		renderRequest.setAttribute("tabs",tab);
	
		super.render(renderRequest, renderResponse);
	}

}
