package com.raiden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raiden.domain.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

	
}