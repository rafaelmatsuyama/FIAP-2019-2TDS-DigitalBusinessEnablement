package br.com.fiap.exemplo.repository;

import br.com.fiap.exemplo.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository
        extends JpaRepository<Produto,Integer> {
}
