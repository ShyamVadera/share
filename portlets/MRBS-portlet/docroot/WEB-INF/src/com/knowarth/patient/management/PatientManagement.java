package com.knowarth.patient.management;

import com.knowarth.common.util.PatientUtil;
import com.knowarth.service.model.patient;
import com.knowarth.service.service.patientLocalServiceUtil;
import com.liferay.portal.EmailAddressException;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.log4j.Logger;

/**
 * Portlet implementation class PatientManagement
 */
public class PatientManagement extends MVCPortlet {
	Logger log=Logger.getLogger(PatientManagement.class);

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		log.info("###Ajax called###");
		String patientEmailId=ParamUtil.getString(resourceRequest,"patientEmailId");
		String patientName=ParamUtil.getString(resourceRequest,"patientName");
		long patientId=ParamUtil.getLong(resourceRequest,"patientId");
		log.info("PatientName is"+patientName);
		log.info("patient email id"+patientEmailId);
		log.info("PatientId is"+patientId);
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		log.info("render called");
		String tab=ParamUtil.getString(renderRequest, "tabs","TabOne");
		log.info("tab value "+tab);
		renderRequest.setAttribute("tabs",tab);
		try {
			SearchContainer<patient> searchContainer=getSearchContainer(renderRequest,renderResponse);
			renderRequest.setAttribute("searchContainer",searchContainer);
		} catch (SystemException e) {

		}
		super.render(renderRequest, renderResponse);
	}
	private SearchContainer<patient> getSearchContainer(RenderRequest renderRequest,RenderResponse renderResponse) throws SystemException{
		SearchContainer<patient> container=new SearchContainer<>(renderRequest,renderResponse.createRenderURL(),null,"No Patient Found");
		List<patient> allPatient=patientLocalServiceUtil.getpatients(-1,-1);
		List<patient> sortablePatients=new ArrayList<patient>(allPatient);
		String orderByCol=ParamUtil.getString(renderRequest,"orderByCol","patientId");
		String orderByType=ParamUtil.getString(renderRequest,"orderByType","asc");
		int totalPatient=patientLocalServiceUtil.getpatientsCount();
		container.setTotal(totalPatient);
		container.setOrderByCol(orderByCol);
		container.setOrderByType(orderByType);
		Comparator<patient> comparable=new BeanComparator(orderByCol,new NullComparator(false));
		log.info(orderByType);
		log.info(orderByCol);
		Collections.sort(sortablePatients,comparable);
		if(orderByType.equalsIgnoreCase("desc")){
			Collections.reverse(sortablePatients);
		}
		container.setResults(sortablePatients);
		return container;
	}
	@ProcessAction(name="addPatient")
	public void addPatient(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		log.info("AddPatient Called");
		patient patient=PatientUtil.getPatient(actionRequest);
		long patientId=ParamUtil.getLong(actionRequest,"patientId");
		patient.setPatientId(patientId);
		log.info("patient id is"+patientId);
		try {
			patientLocalServiceUtil.savePatient(patient);
			log.info("Patient Added Successfully");
		} catch (SystemException e) {

		} catch (EmailAddressException e) {
			SessionErrors.add(actionRequest,"DuplicateEmail");
		}


	}
	@ProcessAction(name="deletePatient")
	public void deletePatient(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {
		log.info("delete patient called");
		long patientId=ParamUtil.getLong(actionRequest,"patientId");
		patientLocalServiceUtil.deletepatient(patientId);
	}

	@ProcessAction(name="editPatient")
	public void editPatient(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {
		log.info("edit patient called");
		long patientId=ParamUtil.getLong(actionRequest,"patientId");
		log.info("patient id is"+patientId);
		patient patient=patientLocalServiceUtil.getpatient(patientId);
		actionRequest.setAttribute("patient",patient);
		actionResponse.setRenderParameter("mvcPath","/html/patientmanagement/addPatient.jsp");

	}

}
