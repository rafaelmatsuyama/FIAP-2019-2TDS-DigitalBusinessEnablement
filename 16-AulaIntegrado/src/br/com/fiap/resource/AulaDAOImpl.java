package br.com.fiap.resource;

import javax.persistence.EntityManager;

public class AulaDAOImpl extends 
	GenericDAOImpl<AulaTO, Integer> implements AulaDAO  {

	public AulaDAOImpl(EntityManager em) {
		super(em);
	}
}
