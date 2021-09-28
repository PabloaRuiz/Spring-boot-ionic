package com.raiden.domain;

import com.raiden.domain.enums.EstadoPagamento;

import javax.persistence.Entity;


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
