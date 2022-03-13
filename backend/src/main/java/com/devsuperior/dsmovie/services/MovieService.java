package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

//Registra como um componente do sistema (Anotação 'Service'). É ideal para classes customizadas.

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	//Pageable ele fará busca por paginação.
	//ReadOnly indica que é somente de leitura, o método.
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		
		//Map, aplica uma função a cada elemento da lista.
		Page<MovieDTO> page= result.map(x -> new MovieDTO(x));
		return page;
	}
	
	//findById retorna um objeto do tipo Optional, esse método abaixo não faz tratamento de exceção para id nulo.
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}

}
