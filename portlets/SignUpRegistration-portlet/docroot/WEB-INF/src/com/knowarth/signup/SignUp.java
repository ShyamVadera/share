package com.knowarth.signup;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.PortletUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

/**
 * Portlet implementation class SignUp
 */
public class SignUp extends MVCPortlet {

	Logger log=Logger.getLogger(SignUp.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse arg1)
			throws PortletException, IOException {
		String portalURL=PortalUtil.getPortalURL(renderRequest);
		log.info(portalURL);
		log.info("render method called");
		super.render(renderRequest, arg1);
	}
	@ProcessAction(name="addUser")
	public void addUser(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		log.info("addUser called");
		String emailId=ParamUtil.getString(actionRequest,"emailId");
		String securityQuestion1=ParamUtil.getString(actionRequest, "securityQuestion1",StringPool.BLANK);
		String securityQuestion2=ParamUtil.getString(actionRequest,"securityQuestion2",StringPool.BLANK);
		log.info(securityQuestion1+securityQuestion2);
		ThemeDisplay themeDisplay=(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user=null;
		
		try{
			user=UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(),emailId);
			if(Validator.isNotNull(user)){
				log.info("user alreday exists");
			}else{
				
				log.info("new user");
			}
		}catch(Exception e){

		}
	}

}
