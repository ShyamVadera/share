<div dir="ltr" style="text-align: left;" trbidi="on">
	<span style="font-family: Trebuchet MS, sans-serif;"><span
		style="font-size: small;">You might have observed very lo<span
			style="font-size: small;">ng urls of links / form<span
				style="font-size: small;">s</span> <span style="font-size: small;">of
					portlet<span style="font-size: small;">s placed on liferay
						pages<span style="font-size: small;">.</span>
				</span>
			</span></span></span></span> <span style="font-family: Trebuchet MS, sans-serif;"> </span> <span
		style="font-family: Trebuchet MS, sans-serif;">When we place
		the portlet on Liferay page, we don't have control over the URL. I
		mean to say the URLs on JSP page will only be generated runtime.</span> <span
		style="font-family: Trebuchet MS, sans-serif;"> </span> <span
		style="font-family: Trebuchet MS, sans-serif;">Let's see how
		this URL is created. For simplicity, we will create Liferay MVC
		portlet. This portlet will have one filed called Name and one submit
		button which will submit this name.</span> <span
		style="font-family: Trebuchet MS, sans-serif;"> </span> <span
		style="font-family: Trebuchet MS, sans-serif;">Please refer my
		previous blog <a
		href="http://opensource-techblog.blogspot.in/2012/08/creating-custom-liferay-mvc-portlet.html"
		target="_blank">How to create Liferay MVC Porltet</a>&nbsp;to create
		Liferay MVC portlet. Give the project name as '<b>friendly-url</b>' so
		that eclipse will append <b>-porltet </b>so that it will look like as
		below screenshot.
	</span> <span style="font-family: Trebuchet MS, sans-serif;"> </span>
	<div class="separator" style="clear: both; text-align: center;">
		<a
			href="http://1.bp.blogspot.com/-u1hyaVFpsGE/ULC4medvdKI/AAAAAAAAA-0/Tw3lQZ1T8ME/s1600/project+structure.png"
			imageanchor="1" style="margin-left: 1em; margin-right: 1em;"><img
			border="0"
			src="http://1.bp.blogspot.com/-u1hyaVFpsGE/ULC4medvdKI/AAAAAAAAA-0/Tw3lQZ1T8ME/s1600/project+structure.png" /></a>
	</div>
	<span style="font-family: Trebuchet MS, sans-serif;"> </span> <span
		style="font-family: &amp; quot;"><span
		style="font-size: small;"></span></span><span
		style="font-family: &amp; quot;"><span
		style="font-size: small;">I have set the portlet class name is
			<b>FriendlyUrlPorltet</b>&nbsp;and the package name is <b>com.opensource.techblog.portlet&nbsp;</b>
	</span></span> <span style="font-family: &amp; quot;"><span
		style="font-size: small;"><b> </b></span></span> <span
		style="font-family: &amp; quot;"><span
		style="font-size: small;">open <b>FriendlyUrlPortlet.java </b>class
			and add <b>doView</b> and <b>ProcessAction </b>method so that it will
			looks like below snippet.
	</span></span>
	<pre class="java" name="code">package com.opensource.techblog.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class FriendlyUrlPortlet extends MVCPortlet{

	//Default Render Method.
	public void doView(RenderRequest renderRequest,
				RenderResponse renderResponse) throws IOException, PortletException {
			super.doView(renderRequest, renderResponse);
		}

		@ProcessAction(name="name")
		public void addName(ActionRequest actionRequest,
				ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException{
			String userName = ParamUtil.get(actionRequest, "userName", StringPool.BLANK);
			System.out.println("userName is :="+userName);
		}

}

</pre>
	<span style="font-family: &amp; quot;"><span
		style="size: small;"> </span></span> <span style="font-family: &amp; quot;"><span
		style="size: small;"><b>Note:-</b> Click on <b>view plain </b>link
			at the top of code to copy it</span></span> <span style="font-family: &amp; quot;"><span
		style="size: small;"> </span></span><span style="font-family: &amp; quot;"><span
		style="font-size: small;"><b>Explanation:-</b> </span></span>

	<ul style="text-align: left;">
		<li><span style="font-family: Trebuchet MS, sans-serif;">We
				have simply added <b>ProcessAction </b>method with key "<b>name</b>".
		</span></li>
		<li><span style="font-family: Trebuchet MS, sans-serif;">In
				this method we are getting request parameter <b>userName </b>with
				the help of Liferay utility class <b>ParamUtil </b>and printing it
				to console ( by <b>System.out.println</b>) to just make sure
				whatever we enter username is reaching in controller.
		</span></li>
	</ul>
	<div>
		<span style="font-family: Trebuchet MS, sans-serif;">Now, add
			the code to <b>view.jsp </b>so that it will looks like below snippet.
		</span>
	</div>
	<div>
		<span style="font-family: Trebuchet MS, sans-serif;"> </span>
	</div>
	<div></div>
</div>