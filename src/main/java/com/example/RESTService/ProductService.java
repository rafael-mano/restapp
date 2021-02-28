package com.example.RESTService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAll() {
		return getProductsList();
	}
	
	public String add(Product product) {
		try {
			product.setCreationDate(new Date());
			productRepository.save(product);
			return "Product created!";
		} catch (Exception e) {
			return "Sorry, the Product was not created: " + e.getMessage();
		}
	}

	public String delete(Long id) {
		if(productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return "Product deleted!";
		}
		return "Sorry, the Product doesn't exist.";
	}
	
	private List<Product> getProductsList() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	public String update(Product product) {
		Optional<Product> productExists = productRepository.findById(product.getId());
		if(null != productExists && productExists.isPresent()) {
			product.setCreationDate(productExists.get().getCreationDate());
			productRepository.save(product);
			return "Product updated!";
		}
		return "Sorry, the Product doesn't exist."; 
	}
}
