package net.drs.fotoshopbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.drs.fotoshopbackend.dao.IFotographerDAO;
import net.drs.fotoshopbackend.dto.Fotographer;
import net.drs.fotoshopbackend.dto.User;


@Repository("fotographerDAO")
@Transactional
public class FotographerDAOImpl implements IFotographerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Fotographer getFotographerbyId(Fotographer fotographer) {
		return (Fotographer) sessionFactory.getCurrentSession().get(Fotographer.class, fotographer.getFotographerId());
		
	}

	public boolean updateFotographer(Fotographer fotographer) {
		sessionFactory.getCurrentSession().update(fotographer);
		return true;
		
	}

	public List<Fotographer> getAllFotographers() {
		return null;
	}

	public List<Fotographer> getAllActiveFotographers() {
		// TODO Auto-generated method stub
		return null;
	}

}
