package com.raiden;

import com.raiden.domain.*;
import com.raiden.domain.enums.EstadoPagamento;
import com.raiden.domain.enums.TipoCliente;
import com.raiden.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class McApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cateoriaRepository;
	@Autowired
	private ProdutosRepository produtosRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(McApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		 Categorias cat1 = new Categorias(null, "Informatica");
		 Categorias cat2 = new Categorias(null, "Escritorio");
		 Categorias cat3 = new Categorias(null, "Cama mesa e banho");
		 Categorias cat4 = new Categorias(null, "Eletrônicos em geral");
		 Categorias cat5 = new Categorias(null, "Hardware");
		 Categorias cat6 = new Categorias(null, "Software");
		 Categorias cat7 = new Categorias(null, "Decoração");
		 Categorias cat8 = new Categorias(null, "Jardinagem");
		 
		 Produtos p1 = new Produtos(null, "Computador", 2000.00);
		 Produtos p2 = new Produtos(null, "Impressora", 800.00);
		 Produtos p3 = new Produtos(null, "Mouse", 80.00);
		 Produtos p4 = new Produtos(null, "Teclado", 180.00);
		 
		 cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3,p4));
		 cat2.getProdutos().addAll(Arrays.asList(p2));
		 
		 p1.getCategorias().addAll(Arrays.asList(cat1));
		 p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		 p3.getCategorias().addAll(Arrays.asList(cat1));
		 p4.getCategorias().addAll(Arrays.asList(cat1));
		 
		 Estado est1 = new Estado(null, "Minas Gerais");
		 Estado est2 = new Estado(null, "São Paulo");
		 
		 Cidade ct1 = new Cidade(null, "Uberlândia", est1);
		 Cidade ct2 = new Cidade(null, "São Paulo", est2);
		 Cidade ct3 = new Cidade(null, "Campinas", est2);
		 Cidade ct4 = new Cidade(null, "Santa Rita do Passa Quatro", est2);
		 
		 est1.getCidades().addAll(Arrays.asList(ct1));
		 est2.getCidades().addAll(Arrays.asList(ct2,ct3,ct4));
		 
		 
		 cateoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		 produtosRepository.saveAll(Arrays.asList(p1, p2, p3, p4)); 
		 estadoRepository.saveAll(Arrays.asList(est1, est2));
		 cidadeRepository.saveAll(Arrays.asList(ct1,ct1,ct3,ct4));
		 
		 
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "40860288892", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("1999582125", "01935835445"));
		
		Endereco e1 = new Endereco(null, "Rua flores", "2450", "S/C", "Jardim das flores", "13690554", cli1, ct4); 
		
		cli1.getEndereco().addAll(Arrays.asList(e1));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedidos ped1 = new Pedidos(null, sdf.parse("30/09/2017 10:32"), cli1, e1); 
		Pagamentos pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamentos(pagto1);
		
		
		cli1.getPedidos().addAll(Arrays.asList(ped1));
		
		
		pedidoRepository.saveAll(Arrays.asList(ped1));
		pagamentoRepository.saveAll(Arrays.asList(pagto1));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 200.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1));
	}
}
