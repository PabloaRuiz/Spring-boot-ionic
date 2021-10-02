package com.raiden.services;

import com.raiden.domain.Categorias;
import com.raiden.domain.Pedidos;
import com.raiden.domain.Produtos;
import com.raiden.repositories.CategoriaRepository;
import com.raiden.repositories.PedidoRepository;
import com.raiden.repositories.ProdutosRepository;
import com.raiden.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProdutoService {

	@Autowired
	private ProdutosRepository repo;


	@Autowired
	private CategoriaRepository categoriaRepository;

	public Produtos find(Integer id) {
		Optional<Produtos> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException( 
		  "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedidos.class.getName())); 
		 }

		 public Page<Produtos> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
			 PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
			 List<Categorias> categorias = categoriaRepository.findAllById(ids);
			 return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
		 }
}
