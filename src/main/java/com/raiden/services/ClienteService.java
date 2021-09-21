package com.raiden.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import com.raiden.domain.Cliente;
import com.raiden.repositories.ClienteRepository;
import com.raiden.services.exceptions.ObjectNotFoundException;



@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException( 
		  "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
		 } 

}
