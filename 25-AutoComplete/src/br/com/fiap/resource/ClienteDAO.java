package br.com.fiap.resource;

import java.util.List;

public interface ClienteDAO extends GenericDAO<ClienteTO, Integer> {
	public List<String> buscarPorNomeCliente(String nome);
}
