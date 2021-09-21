package com.raiden.domain;

import javax.persistence.Entity;

import com.raiden.domain.enums.EstadoPagamento;


@Entity
public class PagamentoComCartao extends Pagamentos{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	
	public PagamentoComCartao() {
		
	}


	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedidos pedidos, Integer numeroDeParcelas) {
		super(id, estado, pedidos);
		this.numeroDeParcelas = numeroDeParcelas;
	}


	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}


	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
	

}
