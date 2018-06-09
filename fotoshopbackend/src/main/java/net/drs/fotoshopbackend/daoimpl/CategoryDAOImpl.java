package net.drs.fotoshopbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.drs.fotoshopbackend.dao.CategoryDAO;
import net.drs.fotoshopbackend.dto.Category;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<Category>();
	
	static{
		
		Category category = new Category();
		category.setId(1);
		category.setDescription("firstCategory");
		category.setImageURL("image1.png");
		category.setName("FirstCategory");
		
		categories.add(category);
		
		
		category = new Category();
		category.setId(2);
		category.setDescription("second");
		category.setImageURL("image2.png");
		category.setName("SecondCategory");
		
		categories.add(category);
		
		
		category = new Category();
		category.setId(3);
		category.setDescription("thirdCategory");
		category.setImageURL("image3.png");
		category.setName("ThirdCategory");
		
		categories.add(category);
		
		category = new Category();
		category.setId(4);
		category.setDescription("fourthCategory");
		category.setImageURL("image4.png");
		category.setName("FourthCategory");
		
		categories.add(category);
		
	}
	
	public List<Category> list() {
		
		String selectquery="from Category where active= :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectquery);
		query.setParameter("active", true);
		return query.getResultList();
	}


	@Transactional
	public boolean add(Category category) {
		
		try{
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		// TODO Auto-generated method stub
		
	}

	public Category get(int id) {
		
		//sessionFactory.getCurrentSession().get
		
		return null;
	}


}
