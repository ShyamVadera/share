package com.knowarth.login;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.PasswordTrackerLocalService;
import com.liferay.portal.service.PasswordTrackerLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.PasswordTrackerUtil;
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
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Portlet implementation class CustomLogin
 */
public class CustomLogin extends MVCPortlet {
	Logger log=Logger.getLogger(CustomLogin.class);
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		super.render(renderRequest,renderResponse);
	}
	@ProcessAction(name="Login")
	public void Login(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		log.info("Login method called");
		String emailId=ParamUtil.getString(actionRequest,"emailId");
		String password=ParamUtil.getString(actionRequest,"userPassord");
		log.info(emailId+password);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		User userDetails=null;

		try{
			userDetails=UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), emailId);
			if(Validator.isNull(userDetails)){
				SessionErrors.add(actionRequest,"EMAIL_NOT_EXIST-key");
			}else{
				log.info("email found");
				boolean passwordMatched=PasswordTrackerLocalServiceUtil.isSameAsCurrentPassword(userDetails.getUserId(),password);
				log.info("Passowrd Match"+passwordMatched);
				if(passwordMatched==false){
					SessionErrors.add(actionRequest,"WRONG_PASSWORD-key");
				}else{
					HttpServletRequest request=PortalUtil.getHttpServletRequest(actionRequest);
					String portalURL=PortalUtil.getPortalURL(actionRequest);
					log.info(portalURL);
				String redirectURL=	getRedirectionUrl(userDetails,themeDisplay,request, actionRequest);
				System.out.println(portalURL+"/group"+redirectURL);
				//actionResponse.setRenderParameter("jspPage",portalURL+"/group"+redirectURL);
				actionResponse.sendRedirect(portalURL+"/group"+redirectURL);
				}
			}
		}catch(Exception e){

		}
	}
	private String getRedirectionUrl(User user, ThemeDisplay themeDisplay,HttpServletRequest request,ActionRequest actionRequest) throws PortalException, SystemException {
		log.info("getRedirectionUrl called");
		
		Group group=GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(),"27301");
		System.out.println("Friendly url"+group.getFriendlyURL());
		return group.getFriendlyURL();
	}
}

