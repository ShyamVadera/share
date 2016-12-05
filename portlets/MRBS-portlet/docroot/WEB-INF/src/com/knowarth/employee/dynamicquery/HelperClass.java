package com.knowarth.employee.dynamicquery;

import com.knowarth.service.model.Employee;
import com.knowarth.service.service.EmployeeLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.support.tomcat.loader.PortalClassLoader;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.File;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class HelperClass {
	
	public static List<Employee> searchEmployee(String employeeName) throws SystemException{
	
	List<Employee> employees=null;
	ClassLoader portalClassLoader=PortletClassLoaderUtil.getClassLoader();
	
	DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(Employee.class,portalClassLoader);	
	dynamicQuery.add(PropertyFactoryUtil.forName("employeeName").eq(employeeName));
	employees=EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
	System.out.println(employees.size());
	return employees;
	
	}
	public static void searchEmployeeName() throws SystemException{
		List<Object> employeeName=null;
		DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(Employee.class,PortletClassLoaderUtil.getClassLoader());
		ProjectionList projectionList=ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.property("employeeName"));
		dynamicQuery.setProjection(projectionList);
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(new Long(20155)));
		employeeName=EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
		for(Object employee:employeeName){
			
			System.out.println(employee);
		}
	
	}public static void sendMail(String emailId){
		InternetAddress fromAddress=null;
		InternetAddress toAddress=null;
		File file=new File("D:\\rac-advt-120.pdf");
		try{
			fromAddress=new InternetAddress("vaderashyam93@gmail.com");
			toAddress=new InternetAddress(emailId);
			MailMessage mailMessage=new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject("This mail is to check mail demo");
			mailMessage.setBody("Hello Welcome to Employee Portal");
			mailMessage.addFileAttachment(file);
			MailServiceUtil.sendEmail(mailMessage);
			System.out.println("Mail send successfully");
		}catch(AddressException e){
			System.out.println("Exception occured");
		}
	}
	
}
