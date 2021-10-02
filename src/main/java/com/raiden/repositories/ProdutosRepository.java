package com.raiden.repositories;

import com.raiden.domain.Categorias;
import com.raiden.domain.Produtos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

    @Transactional(readOnly=true)
    @Query("SELECT DISTINCT obj FROM Produtos obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
    Page<Produtos> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome, @Param("categorias")List<Categorias> categorias, Pageable pageRequest);
}
