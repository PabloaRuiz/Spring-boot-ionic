package com.raiden.resources;

import com.raiden.domain.Pedidos;
import com.raiden.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Pedidos")
public class PedidosResource {
	
	@Autowired
	private PedidoService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedidos> find(@PathVariable Integer id) {
		Pedidos obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
