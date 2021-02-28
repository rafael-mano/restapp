package com.example.RESTService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prod")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/allproducts")
	public List<Product> getAll() {
		return productService.getAll();
	}
	
	@PostMapping("/addproduct")
	public String add(Product product) {
		return productService.add(product);
	}
	
	@PutMapping("/updateproduct")
	public String update(Product product) {
		return productService.update(product);
	}
	
	@DeleteMapping("/deleteproduct")
	public String delete(@RequestParam("id") Long id) {
		return productService.delete(id);
	}
}
