package com.knowarth.common.util;

import com.knowarth.service.model.patient;
import com.knowarth.service.service.patientLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

public class PatientHelperUtil {
	
	public static boolean validatePatient(long patientId,String patientEmailId) throws SystemException{
		DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(patient.class,PortletClassLoaderUtil.getClassLoader());
		System.out.println("PatientHelper called");
		List<patient> patients=null;
		dynamicQuery.add(PropertyFactoryUtil.forName("patientId").ne(patientId));
		dynamicQuery.add(PropertyFactoryUtil.forName("patientEmailId").eq(patientEmailId));
		patients=patientLocalServiceUtil.dynamicQuery(dynamicQuery);
		if(Validator.isNotNull(patients)){
			System.out.println(patients.size());
			return false;
		}else{
			return true;
		}
	}

}
