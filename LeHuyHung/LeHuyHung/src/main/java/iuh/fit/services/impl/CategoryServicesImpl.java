package iuh.fit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.entities.Category;
import iuh.fit.repositories.CategoryRepository;
import iuh.fit.services.CategoryServices;

@Service
public class CategoryServicesImpl implements CategoryServices{
	
	@Autowired
	private CategoryRepository categoryRepository;


	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

}
