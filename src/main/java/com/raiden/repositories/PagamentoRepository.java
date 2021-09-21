package com.raiden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raiden.domain.Pagamentos;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamentos, Integer> {

	
}