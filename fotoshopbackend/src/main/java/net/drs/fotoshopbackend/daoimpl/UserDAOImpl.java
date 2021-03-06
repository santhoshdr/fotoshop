package net.drs.fotoshopbackend.daoimpl;

import java.util.List;

import net.drs.fotoshopbackend.dao.IUserDAO;
import net.drs.fotoshopbackend.dto.Otp;
import net.drs.fotoshopbackend.dto.User;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<User> getAllUsers() {
			return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public List<User> getAllActiveUsers() {
		String selectquery="from User where isActive= :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectquery);
		query.setParameter("active", true);
		return query.getResultList();
	}

	public User getUser(Long userId){
		// not working for 1 - need to check
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

	public boolean isUserActive(Long userId) {
		
		String selectQuery = "FROM User WHERE userId = :userId";		
		return (Boolean) sessionFactory.getCurrentSession()
						.createQuery(selectQuery)
							.setParameter("userId", userId)
								.getSingleResult();
	
	}

	public boolean activateUser(Long  userId) {
		String selectQuery = "update User set isActive = :isActive WHERE userId = :userId";
		return sessionFactory.getCurrentSession()
						.createQuery(selectQuery)
							.setParameter("userId", userId)
							.setParameter("isActive", true)
								.executeUpdate() >=  1 ? true : false;
		
	}

	public boolean deactivateUser(Long userId) {
		String selectQuery = "update User set isActive = :isActive WHERE userId = :userId";
		return sessionFactory.getCurrentSession()
						.createQuery(selectQuery)
							.setParameter("userId", userId)
							.setParameter("isActive", false)
								.executeUpdate() >=  1 ? true : false;
		
	}

	public boolean updateUser(User user) {
		// update the user and send back updated user object
		sessionFactory.getCurrentSession().update(user);
		return true;
		
	}

	
	public boolean validateOTPGenerate(Long userid, char[] generatedOTP,
			int vaidFor, boolean isValidated) {
		
		Otp otp = new Otp();
		otp.setUserId(userid);
		otp.setUniqueOTPSent(generatedOTP);
		otp.setOtpValidFor(vaidFor);
		otp.setIsvalidated(false);

		sessionFactory.getCurrentSession().persist(otp);			
		return true;
	}

	public boolean validateOTPVerify(Long userid, String generatedOTP,
		String vaidFor, boolean isValidated) {
		// TODO Auto-generated method stub
		return false;
	}

	public Otp getOTPForUserId(Long userid) {
		
		String otpQuery ="FROM Otp where userid = :userid";
		Otp otp = (Otp)sessionFactory.getCurrentSession()
					.createQuery(otpQuery)
						.setParameter("userid", userid).getSingleResult();
		return otp;
	}

	public boolean updateUserEnteredOTP(User user, String userEnteredOTP) {

		String otpQuery ="update Otp set userEnteredOTP = :userEnteredOTP where userid = :userid";
		return sessionFactory.getCurrentSession()
					.createQuery(otpQuery)
						.setParameter("userid", user.getUserId())
						.setParameter("userEnteredOTP", userEnteredOTP.toCharArray()).executeUpdate()> 0 ?true : false; 
						
	}

	
}
