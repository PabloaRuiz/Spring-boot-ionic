package com.raiden.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import com.raiden.domain.Categorias;
import com.raiden.repositories.CategoriaRepository;
import com.raiden.services.exceptions.ObjectNotFoundException;



@Service
public class CategoriasService {

	@Autowired
	private CategoriaRepository repo;

	public Categorias find(Integer id) {
		Optional<Categorias> obj = repo.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException( 
		  "Objeto não encontrado! Id: " + id + ", Tipo: " + Categorias.class.getName())); 
		 } 

}
