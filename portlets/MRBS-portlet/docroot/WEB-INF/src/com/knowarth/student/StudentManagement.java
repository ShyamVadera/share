package com.knowarth.student;

import com.knowarth.service.model.IndianState;
import com.knowarth.service.model.impl.IndianStateImpl;
import com.knowarth.service.service.IndianStateLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

/**
 * Portlet implementation class StudentManagement
 */
public class StudentManagement extends MVCPortlet {
	Logger log=Logger.getLogger(MVCPortlet.class);
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		System.out.println("render called");
		String request=ParamUtil.getString(renderRequest,"request");
		if(Validator.equals(request,"AddState")){
			
			PortletRequestDispatcher dispatcher=getPortletContext().getRequestDispatcher("/html/studentmanagement/addState.jsp");
			dispatcher.include(renderRequest,renderResponse);
		}
		else{
			PortletRequestDispatcher dispatcher=getPortletContext().getRequestDispatcher("/html/studentmanagement/view.jsp");
			dispatcher.include(renderRequest,renderResponse);
		}
	}
	@ProcessAction(name="addState")
	public void addState(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, SystemException {
		System.out.println("Add State Called");
		String stateName=ParamUtil.getString(actionRequest,"stateName");
		log.info("State name is "+stateName);
		IndianState indianState=new IndianStateImpl();
		indianState.setStateName(stateName);
		IndianStateLocalServiceUtil.addIndianState(indianState);
		log.info("State Added Successfully");
	}

}
