package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ClienteDAOImpl extends 
	GenericDAOImpl<ClienteTO, Integer> implements ClienteDAO  {

	public ClienteDAOImpl(EntityManager em) {
		super(em);
	}
	
	public List<String> buscarPorNomeCliente(String nome) {
		TypedQuery<String> query = em.createQuery(
		"select c.nome from Cliente c where c.nome like :nome",String.class);
		query.setParameter("nome","%"+ nome + "%");
		return query.getResultList();
	}
}
