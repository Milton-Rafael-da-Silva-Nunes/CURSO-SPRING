package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
	public void insert(Product obj) {
		repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Product update(Long id, Product obj) {
		Product product = repository.getReferenceById(id);
		updateDate(product, obj);
		return repository.save(product);
	}

	private void updateDate(Product product, Product obj) {
		product.setName(obj.getName());
		product.setDescription(obj.getDescription());
		product.setPrice(obj.getPrice());
	}
}
