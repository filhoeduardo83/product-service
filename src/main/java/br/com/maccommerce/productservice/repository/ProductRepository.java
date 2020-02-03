package br.com.maccommerce.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.maccommerce.productservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
