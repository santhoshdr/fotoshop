package net.drs.fotoshopbackend.test;

import static org.junit.Assert.*;
import net.drs.fotoshopbackend.dao.CategoryDAO;
import net.drs.fotoshopbackend.dto.Category;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTest{
	
	
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;

	@Autowired
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init(){
		
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.drs.fotoshopbackend");
		annotationConfigApplicationContext.refresh();
		annotationConfigApplicationContext.getBeanDefinitionNames();
		categoryDAO = (CategoryDAO) annotationConfigApplicationContext.getBean("categoryDAO");
	
	}
/*	
	@Test
	public void testAddCategory(){
		
		category = new Category();
		category.setDescription("firstCategory");
		category.setImageURL("image1.png");
		category.setName("FirstCategory");
	
		
		assertEquals("Success",true,categoryDAO.add(category));
	}
	*/
	
	@Test
	public void testGetALlCategories(){
			assertEquals("Success",true,categoryDAO.list().size()>1);
	}
	
}
