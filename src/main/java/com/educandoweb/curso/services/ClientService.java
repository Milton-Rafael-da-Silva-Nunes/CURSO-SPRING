package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Client;
import com.educandoweb.curso.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.get();
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Client update(Long id, Client obj) {
		Client client = repository.getReferenceById(id);
		updateDate(client, obj);
		return repository.save(client);
	}

	private void updateDate(Client client, Client obj) {
		client.setName(obj.getName());
		client.setCpf(obj.getCpf());
		client.setEmail(obj.getEmail());
	}
}
