package br.com.maccommerce.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.maccommerce.productservice.entity.Product;
import br.com.maccommerce.productservice.service.ProductServiceImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin
@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/products")
	public List<Product> listAllProducts(){
		log.info("Buscando lista de produtos");
		return productService.findAll();
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/products/{id}")
	public Optional<Product> findProductById(@PathVariable Integer id){
		log.info("Buscando produto de id "+id);
		return productService.findById(id);
	}
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/products")
	public void insertProduct(@RequestBody Product product) {
		log.info("Solicitando inclusão de novo produto");
		productService.save(product);

	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/products/{id}")
	public void updateProduct(@PathVariable Integer id,@RequestBody Product newProduct) {
		log.info("Solicitando atualização do produto de id "+ id);
		productService.update(id, newProduct);

	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		log.info("Solicitando exclusão do produto de id "+ id);
		productService.delete(id);
	}
	


}
