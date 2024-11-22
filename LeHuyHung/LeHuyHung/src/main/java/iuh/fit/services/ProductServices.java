package iuh.fit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.entities.Product;
import iuh.fit.repositories.ProductRepository;

public interface ProductServices {
	public List<Product> getAllProducts();
	public Product save(Product product);
	public List<Product> filterProducts(Integer cate, Boolean active);
	public boolean deleteProduct(int id);
	public Product getProductById(int id);
//	public boolean updateProduct(int id,Product product);
}
