package iuh.fit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.entities.Product;
import iuh.fit.repositories.ProductRepository;
import iuh.fit.services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices{
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> filterProducts(Integer cate, Boolean active) {
		// TODO Auto-generated method stub
		return productRepository.filterProducts(cate, active);
	}

	@Override
	public boolean deleteProduct(int id) {
		productRepository.deleteById(id);
		return true;
	}

//	@Override
//	public boolean updateProduct(int id,Product product) {
//		if (productRepository.existsById(id)) {
//			productRepository.save(product);
//			return true;
//		}
//		return false;
//	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElse(null);
	}
}
