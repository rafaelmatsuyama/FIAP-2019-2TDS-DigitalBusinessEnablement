package br.com.fiap.pesquisas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository
        extends JpaRepository<Produto,Integer> {
}
