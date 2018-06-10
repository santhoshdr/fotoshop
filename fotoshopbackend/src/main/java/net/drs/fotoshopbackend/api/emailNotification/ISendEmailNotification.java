package net.drs.fotoshopbackend.api.emailNotification;

import java.util.ArrayList;

import net.drs.fotoshopbackend.dto.User;

public interface ISendEmailNotification {
	
	// emailNotificationtemplate : is the email notificationtemplate for each notification kind.. 
	
	// Sending email notification to end user at the time of registration along with an email to admin of the application
	boolean sendEmailNotification(String emailNotificationtemplate, User user , ArrayList extraEmailsNotifications);
	
	
	// send email notification just to user
	boolean sendEmailNotification(String emailNotificationtemplate, User user);
	
	
	//send emails to app admin when exceptions occur
	boolean sendErrorEmailNotificationsToAppAdmin(String emailNotificationtemplate,ArrayList extraEmailsNotifications);
	
}
