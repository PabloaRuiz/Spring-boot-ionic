package com.raiden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raiden.repositories.CategoriaRepository;
import com.raiden.repositories.CidadeRepository;
import com.raiden.repositories.ClienteRepository;
import com.raiden.repositories.EnderecoRepository;
import com.raiden.repositories.EstadoRepository;
import com.raiden.repositories.ItemPedidoRepository;
import com.raiden.repositories.PagamentoRepository;
import com.raiden.repositories.PedidoRepository;
import com.raiden.repositories.ProdutosRepository;


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
    }
}