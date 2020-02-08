package br.com.maccommerce.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.maccommerce.productservice.entity.Product;
import br.com.maccommerce.productservice.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping("/products")
	public List<Product> listAllProducts(){
		return productService.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> findProductById(@PathVariable Integer id){
		return productService.findById(id);
	}
	
	@PostMapping("/products")
	public void insertProduct(@RequestBody Product product) {
		productService.save(product);

	}
	
	@PutMapping("/products/{id}")
	public void insertProduct(@PathVariable Integer id,@RequestBody Product newProduct) {
		productService.update(id, newProduct);

	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productService.delete(id);
	}
	


}
