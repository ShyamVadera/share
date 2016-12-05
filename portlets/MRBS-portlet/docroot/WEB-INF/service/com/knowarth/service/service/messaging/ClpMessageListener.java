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

package com.knowarth.service.service.messaging;

import com.knowarth.service.service.ClpSerializer;
import com.knowarth.service.service.EmployeeLocalServiceUtil;
import com.knowarth.service.service.EmployeeServiceUtil;
import com.knowarth.service.service.IndianStateLocalServiceUtil;
import com.knowarth.service.service.IndianStateServiceUtil;
import com.knowarth.service.service.patientLocalServiceUtil;
import com.knowarth.service.service.patientServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author shyam.vadera
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			EmployeeLocalServiceUtil.clearService();

			EmployeeServiceUtil.clearService();
			IndianStateLocalServiceUtil.clearService();

			IndianStateServiceUtil.clearService();
			patientLocalServiceUtil.clearService();

			patientServiceUtil.clearService();
		}
	}
}