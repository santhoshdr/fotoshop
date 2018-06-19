package net.drs.fotoshopbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import net.drs.fotoshopbackend.dao.IFotographerDAO;
import net.drs.fotoshopbackend.dto.Fotographer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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
		return sessionFactory.getCurrentSession().createQuery("from Fotographer").list();
	}

	public List<Fotographer> getAllActiveFotographers() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Fotographer where isactive = :isactive");
		query.setParameter("isactive", true);
		List<Fotographer> list = (List<Fotographer>)query.getResultList();
		return list;
	}

	public boolean activateFotographer(Fotographer fotographer) {
		String selectQuery = "update Fotographer set isActive = :isActive WHERE fotographerId = :fotographerId";
		return sessionFactory.getCurrentSession()
						.createQuery(selectQuery)
							.setParameter("fotographerId", fotographer.getFotographerId())
							.setParameter("isActive", true)
								.executeUpdate() >=  1 ? true : false;
	}

	public boolean deactivateFotographer(Fotographer fotographer) {
		String selectQuery = "update Fotographer set isActive = :isActive WHERE fotographerId = :fotographerId";
		return sessionFactory.getCurrentSession()
						.createQuery(selectQuery)
							.setParameter("fotographerId", fotographer.getFotographerId())
							.setParameter("isActive", false)
								.executeUpdate() >=  1 ? true : false;
	}

}
