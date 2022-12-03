package br.com.luane.apiprodutos.repository;

import br.com.luane.apiprodutos.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoEntity, Long> {
}
