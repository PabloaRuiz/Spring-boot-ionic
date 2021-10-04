package com.raiden.services;

import com.raiden.domain.ItemPedido;
import com.raiden.domain.PagamentoComBoleto;
import com.raiden.domain.Pedidos;
import com.raiden.domain.enums.EstadoPagamento;
import com.raiden.repositories.ItemPedidoRepository;
import com.raiden.repositories.PagamentoRepository;
import com.raiden.repositories.PedidoRepository;
import com.raiden.repositories.ProdutosRepository;
import com.raiden.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;



@Service
public class PedidoService {

	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ProdutosRepository produtosRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private PedidoRepository repo;

	public Pedidos find(Integer id) {
		Optional<Pedidos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedidos.class.getName()));
	}

	public Pedidos insert(Pedidos obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamentos().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamentos().setPedidos(obj);
		if (obj.getPagamentos() instanceof PagamentoComBoleto){
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamentos();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamentos());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtosRepository.findById(ip.getProduto().getId()).get().getPreco());
			ip.setPedidos(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}

}
