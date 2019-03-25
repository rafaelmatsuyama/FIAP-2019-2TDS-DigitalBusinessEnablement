package br.com.fiap.resource;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAOImpl<T,K> 
					implements GenericDAO<T, K>{

	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.classe = (Class<T>) ((ParameterizedType)
				getClass().getGenericSuperclass())
						.getActualTypeArguments()[0];
		this.em = em;
	}

	@Override
	public void cadastrar(T tabela) {
		em.persist(tabela);
	}

	@Override
	public void atualizar(T tabela) {
		em.merge(tabela);
	}

	@Override
	public void remover(K codigo) {
		T tabela;
		try {
			tabela = buscar(codigo);
			em.remove(tabela);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T buscar(K codigo) throws Exception {
		return em.find(classe, codigo);
	}

	@Override
	public void commit() throws Exception {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new Exception("Erro ao gravar");
		}
	}
}

