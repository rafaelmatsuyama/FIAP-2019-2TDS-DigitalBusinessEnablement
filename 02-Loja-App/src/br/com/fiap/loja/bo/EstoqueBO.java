package br.com.fiap.loja.bo;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {
	public static ProdutoTO consultarProduto(int codigo) {
		if(codigo == 401) {
			return new ProdutoTO(codigo, "Camiseta branca", 4, 2.99);
		} else if(codigo == 402) {
			return new ProdutoTO(codigo, "Camiseta azul", 4, 2.99);
		} else if(codigo == 403) {
			return new ProdutoTO(codigo, "Camiseta rosa", 4, 2.99);
		} else {
			return new ProdutoTO(-1, "Produto não encontrado", 0, 0);
		}
	}
}
