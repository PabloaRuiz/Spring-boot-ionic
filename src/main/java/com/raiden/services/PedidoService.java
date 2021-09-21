package com.raiden.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import com.raiden.domain.Pedidos;
import com.raiden.repositories.PedidoRepository;
import com.raiden.services.exceptions.ObjectNotFoundException;



@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedidos find(Integer id) {
		Optional<Pedidos> obj = repo.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException( 
		  "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedidos.class.getName())); 
		 } 

}
