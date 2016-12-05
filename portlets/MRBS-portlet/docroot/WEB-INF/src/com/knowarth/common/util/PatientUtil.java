package com.knowarth.common.util;

import com.knowarth.service.model.patient;
import com.knowarth.service.model.impl.patientImpl;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;

public class PatientUtil {
	 public static patient getPatient(ActionRequest actionRequest){
		 patient patient=new patientImpl();
		 patient.setPatientName(ParamUtil.getString(actionRequest,"patientName"));
		 patient.setPatientAge(ParamUtil.getLong(actionRequest,"patientAge"));
		 patient.setPatientEmailId(ParamUtil.getString(actionRequest,"patientEmailId"));
		 return patient;
	 }

}
