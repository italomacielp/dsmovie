package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	//Busca pelo próprio nome do campo. Padrão do SpringDataJPA.
	User findByEmail(String email);
	
}
