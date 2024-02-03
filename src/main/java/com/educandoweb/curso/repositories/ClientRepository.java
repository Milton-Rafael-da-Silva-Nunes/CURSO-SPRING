package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
