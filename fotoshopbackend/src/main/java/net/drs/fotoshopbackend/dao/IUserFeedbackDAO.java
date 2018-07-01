
package net.drs.fotoshopbackend.dao;

import java.util.List;

import net.drs.fotoshopbackend.dto.UserFeedback;

public interface IUserFeedbackDAO {
	
	
	 boolean saveUserFeedback(UserFeedback userFeedback );
	 
	 List<UserFeedback> retriveAllFeedbacks();
	 

	 List<UserFeedback> retriveAllActiveFeedbacks();
	 
	 // based on feedbackId
	 boolean deleteFeedback(UserFeedback userFeedback);

}
