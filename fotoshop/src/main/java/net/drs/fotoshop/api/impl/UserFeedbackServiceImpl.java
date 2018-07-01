package net.drs.fotoshop.api.impl;

import java.util.List;

import net.drs.fotoshop.api.userdetails.IUserFeedbackService;
import net.drs.fotoshopbackend.dao.IUserFeedbackDAO;
import net.drs.fotoshopbackend.dto.UserFeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("userFeedbackService")
@Transactional
public class UserFeedbackServiceImpl implements IUserFeedbackService {

	@Autowired
	public IUserFeedbackDAO userFeedbackDAO;

	@Override
	public boolean saveUserFeedback(UserFeedback userFeedback) {
		return userFeedbackDAO.saveUserFeedback(userFeedback);
	}

	@Override
	public List<UserFeedback> retriveAllFeedbacks() {
		return userFeedbackDAO.retriveAllFeedbacks();
	}

	@Override
	public boolean deleteFeedback(UserFeedback userFeedback) {
		return userFeedbackDAO.deleteFeedback(userFeedback); 
	}

	@Override
	public List<UserFeedback> retriveAllActiveFeedbacks() {
		return userFeedbackDAO.retriveAllActiveFeedbacks();
	}
}
