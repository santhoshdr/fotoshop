package net.drs.fotoshopbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.drs.fotoshopbackend.dao.IRegistrationDAO;
import net.drs.fotoshopbackend.dto.Category;
import net.drs.fotoshopbackend.dto.Fotographer;
import net.drs.fotoshopbackend.dto.User;



@Repository("registrationDAO")
@Transactional
public class RegistrationDAOImpl  implements  IRegistrationDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addUser(User user) {
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	
	
	public boolean addFotographer(Fotographer fotographer) {
		sessionFactory.getCurrentSession().save(fotographer);
		return true;
	}

		
}
