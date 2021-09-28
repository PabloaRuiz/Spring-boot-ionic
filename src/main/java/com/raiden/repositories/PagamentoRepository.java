package com.raiden.repositories;

import com.raiden.domain.Pagamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamentos, Integer> {

	
}