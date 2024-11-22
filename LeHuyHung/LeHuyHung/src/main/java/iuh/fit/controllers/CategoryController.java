package iuh.fit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import iuh.fit.entities.Category;
import iuh.fit.services.CategoryServices;

@Controller
public class CategoryController {

//	@Autowired
//	private CategoryServices categoryServices;
//	
//	@GetMapping("/addProduct")
//	String getlist(Model model) {
//		List<Category> listcategory = categoryServices.getAllCategories();
//		model.addAttribute("categories", listcategory);
//		return "AddProduct";
//	}
	
}
