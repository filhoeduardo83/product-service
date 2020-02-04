package br.com.maccommerce.productservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.maccommerce.productservice.entity.Product;
import br.com.maccommerce.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	Logger logger =  LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private final ProductRepository productRepository;
	


	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public boolean save(@RequestBody Product product) {
		boolean saveSucess=false;
		
		productRepository.save(product);
		
		return saveSucess;
	}

	@Override
	public boolean update(@PathVariable Integer id, @RequestBody Product newProduct) {
		boolean updateSucess = false;
		
		Optional<Product> oldProduct = productRepository.findById(id);	
		newProduct.setId(id);
		productRepository.saveAndFlush(newProduct);
		
		updateSucess=true;

		
		return updateSucess;
	}

	@Override
	public Optional<Product> findById(Integer id) {
		
		Optional<Product> product = productRepository.findById(id);
		
		if(!product.isPresent()) {
			logger.info("Produto não encontrado");
		}
		
		return product;
	}

	@Override
	public void delete(Integer id) {
		
		productRepository.deleteById(id);
		
	}
	
	@Override
	public List<Product> findAll(){
		
		List<Product> productList = productRepository.findAll();
		logger.info("Consultando produtos cadastrados");

		return productList;
	}
	

		

}
