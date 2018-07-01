package net.drs.fotoshopbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.drs.fotoshopbackend.dao.IUserFeedbackDAO;
import net.drs.fotoshopbackend.dto.UserFeedback;


@Repository("userFeedbackDAO")
@Transactional
public class FeedBackDAOImpl implements IUserFeedbackDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean saveUserFeedback(UserFeedback userFeedback) {
		sessionFactory.getCurrentSession().save(userFeedback);
		return true;
	}

	public List<UserFeedback> retriveAllFeedbacks() {
		return sessionFactory.getCurrentSession().createQuery("from UserFeedback").list();
	}

	public boolean deleteFeedback(UserFeedback userFeedback) {
		String selectQuery = "update UserFeedback set active = :isActive WHERE feedbackId = :feedbackId";
		return sessionFactory.getCurrentSession()
						.createQuery(selectQuery)
							.setParameter("feedbackId", userFeedback.getFeedbackId())
							.setParameter("isActive", false)
								.executeUpdate() >=  1 ? true : false;
	
	}

	public List<UserFeedback> retriveAllActiveFeedbacks() {
		String selectquery="from UserFeedback  where active= :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectquery);
		query.setParameter("active", true);
		return query.getResultList();
	}

}
