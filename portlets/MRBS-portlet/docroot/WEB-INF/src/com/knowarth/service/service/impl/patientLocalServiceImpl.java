/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.knowarth.service.service.impl;

import com.knowarth.common.util.PatientHelperUtil;
import com.knowarth.service.NoSuchpatientException;
import com.knowarth.service.model.patient;
import com.knowarth.service.service.base.patientLocalServiceBaseImpl;
import com.liferay.portal.EmailAddressException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the patient local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.knowarth.service.service.patientLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author shyam.vadera
 * @see com.knowarth.service.service.base.patientLocalServiceBaseImpl
 * @see com.knowarth.service.service.patientLocalServiceUtil
 */
public class patientLocalServiceImpl extends patientLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.knowarth.service.service.patientLocalServiceUtil} to access the patient local service.
	 */
	public void savePatient(patient patient) throws SystemException,EmailAddressException{
		System.out.println("save Patient called");
		long patientId=patient.getPatientId();
		if(patientId>0){
			String patientEmailId=patient.getPatientEmailId();
			if(PatientHelperUtil.validatePatient(patientId, patientEmailId)){
				updatepatient(patient);
			}else{
				System.out.println("Exception thrown");
				throw new EmailAddressException("this email is already taken");
			}
		}else{
			patient patient2=validatePatient(patient.getPatientEmailId());
			if(Validator.isNotNull(patient2)){
				throw new EmailAddressException("you have already registered");
			}else{
				addpatient(patient);
			}}
	}
	private patient validatePatient(String patientEmailId){
		try {
	patient patient=patientPersistence.findByEmailId(patientEmailId);
	return patient;
		} catch (NoSuchpatientException e) {
		} catch (SystemException e) {

		}
		return null;
	}
}