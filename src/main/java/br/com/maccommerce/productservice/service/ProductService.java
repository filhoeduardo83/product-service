package br.com.maccommerce.productservice.service;

import java.util.List;
import java.util.Optional;

import br.com.maccommerce.productservice.entity.Product;

public interface ProductService {

	boolean save(Product product);

	boolean update(Integer id, Product product);

	Optional<Product> findById(Integer id);

	void delete(Integer id);

	List<Product> findAll();

}
