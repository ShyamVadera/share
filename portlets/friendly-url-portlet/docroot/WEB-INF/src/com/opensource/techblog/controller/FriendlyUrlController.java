package com.opensource.techblog.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

@Controller(value = "FriendlyUrlController")
@RequestMapping("VIEW")
public class FriendlyUrlController {

	private static Log log = LogFactoryUtil.getLog(FriendlyUrlController.class);
	/*
	 * Default Render Method
	 */
	@RenderMapping
	public String handleRenderRequest(RenderRequest request,RenderResponse response,Model model){
		
		return "view";
	}
	
	@ActionMapping(params = "action=addUserName") 
	public void addUserName(ActionRequest request, ActionResponse response) {
		String userName=ParamUtil.get(request, "userName", "");
		log.info("userName is==>"+userName);
	}
	
	@RenderMapping(params ="action=viewUser")
	public String viewUser(RenderRequest request,RenderResponse response,Model model){
		
		return "viewUser";
	}
	@RenderMapping(params ="action=editUser")
	public String editUser(RenderRequest request,RenderResponse response,Model model){
		
		return "editUser";
	}
	

}
