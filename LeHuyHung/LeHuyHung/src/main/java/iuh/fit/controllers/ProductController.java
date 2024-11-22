package iuh.fit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.fit.entities.Category;
import iuh.fit.entities.Product;
import iuh.fit.services.CategoryServices;
import iuh.fit.services.ProductServices;
import jakarta.validation.Valid;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServices productServices;
	@Autowired
	private CategoryServices categoryServices;
	
	@GetMapping("/listProduct")
	String getlist(Model model) {
		List<Product> listproduct = productServices.getAllProducts();
		model.addAttribute("products", listproduct);
		
		List<Category> categories = categoryServices.getAllCategories();
	    model.addAttribute("categories", categories);
		
		return "ProductList";
	}
	
	@GetMapping("/addProduct")
	public String showAddProductForm(Model model) {
	    List<Category> categories = categoryServices.getAllCategories();
	    model.addAttribute("categories", categories);
	    model.addAttribute("product", new Product());  // Truyền đối tượng Product rỗng để người dùng nhập thông tin
	    return "AddProduct";  
	}

	@PostMapping("/addProduct")
	public String processAddProductForm(@Valid @ModelAttribute("product") Product product,
	                                    BindingResult bindingResult, Model model) {
	    if (bindingResult.hasErrors()) {
	        List<Category> categories = categoryServices.getAllCategories();
	        model.addAttribute("categories", categories);
	        return "AddProduct";
	    }

	    productServices.save(product);
	    return "redirect:/listProduct";
	}

	@PostMapping("/listProduct")
	public String timKiem(
	        @RequestParam(value = "category", required = false) String cate,
	        @RequestParam(value = "active", required = false) String active, Model model) {

	    System.out.println("Category ID: " + cate); 
	    System.out.println("Active: " + active);  

	    Integer category = null;
	    Boolean isActive = null;

	    if (cate != null && !cate.isEmpty()) {
	        category = Integer.parseInt(cate);
	    }

	    if (active != null && !active.isEmpty()) {
	        isActive = Boolean.parseBoolean(active);
	    }

	    List<Product> products = productServices.filterProducts(category, isActive);
	    model.addAttribute("products", products);
	    
	    List<Category> categories = categoryServices.getAllCategories();
	    model.addAttribute("categories", categories);

	    return "ProductList";
	}


    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productServices.deleteProduct(id);
        return "redirect:/listProduct";
    }

    
    @GetMapping("/update/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Product product = productServices.getProductById(id);
        List<Category> categories = categoryServices.getAllCategories();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "EditProduct";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(
            @PathVariable("id") Integer id,
            @Valid @ModelAttribute("product") Product product,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("product", product);
            List<Category> categories = categoryServices.getAllCategories();
	        model.addAttribute("categories", categories);
            return "EditProduct";
        }

        productServices.save(product);
        return "redirect:/listProduct";
    }

}
