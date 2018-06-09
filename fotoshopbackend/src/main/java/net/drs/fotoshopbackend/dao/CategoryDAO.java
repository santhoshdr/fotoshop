package net.drs.fotoshopbackend.dao;

import java.util.List;

import net.drs.fotoshopbackend.dto.Category;

public interface CategoryDAO {

	boolean add(Category  category);
	List<Category>   list();
	Category get(int id);

}
