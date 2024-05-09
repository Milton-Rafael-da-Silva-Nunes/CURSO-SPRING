package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.repositories.CategoryRepository;
import com.educandoweb.curso.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Category insert(Category obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Category update(Long id, Category obj) {
		Category category = repository.getReferenceById(id);
		updateData(category, obj);
		return repository.save(category);
	}

	private void updateData(Category category, Category obj) {
		category.setName(obj.getName());
	}
}
