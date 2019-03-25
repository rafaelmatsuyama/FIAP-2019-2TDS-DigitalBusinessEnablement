package br.com.fiap.resource;

public interface GenericDAO<T,K> {

	void cadastrar(T tabela);
	
	void atualizar(T tabela);
	
	void remover(K codigo);
	
	T buscar(K codigo) throws Exception;
	
	void commit() throws Exception;
}
