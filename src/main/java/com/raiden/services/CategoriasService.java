package com.raiden.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.raiden.domain.Categorias;
import com.raiden.repositories.CategoriaRepository;
import com.raiden.services.exceptions.DataIntegrrityException;
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
	
	public Categorias insert(Categorias obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categorias update(Categorias obj) {
		return repo.save(obj);
	}
	
	public Categorias delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e ){
			throw new DataIntegrrityException("Não é possivel excluir uma categoria que tem produtos");
		}
		return null;
	}
	
	public List<Categorias> findAll() {
		return repo.findAll();
	}
	
	public Page<Categorias> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
