package net.drs.fotoshop.api.userdetails;

import java.util.List;

import net.drs.fotoshopbackend.dto.UserFeedback;

public interface IUserFeedbackService {

 boolean saveUserFeedback(UserFeedback userFeedback );
 
 List<UserFeedback> retriveAllFeedbacks();
 
 
 List<UserFeedback> retriveAllActiveFeedbacks();
 
 // based on feedbackId
 boolean deleteFeedback(UserFeedback userFeedback);
 
 
 
 

}

