package com.raiden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raiden.domain.Categorias;

@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Integer> {

	
}