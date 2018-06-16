package net.drs.fotoshopbackend.api.emailNotification.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.drs.fotoshopbackend.api.emailNotification.ISendEmailNotification;
import net.drs.fotoshopbackend.dto.User;


@Repository("sendEmailNotification")
public class SendEmailNotificationImpl implements ISendEmailNotification {

	static{
		
		
		
		
	}
	
	public boolean sendEmailNotification(String emailNotificationtemplate,
			User user, ArrayList extraEmailsNotifications) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean sendEmailNotification(String emailNotificationtemplate,
			User user) {
		// send email notification.. Now assumption is true
		return true;
	}

	public boolean sendErrorEmailNotificationsToAppAdmin(
			String emailNotificationtemplate, ArrayList extraEmailsNotifications) {
		// TODO Auto-generated method stub
		return false;
	}

}
