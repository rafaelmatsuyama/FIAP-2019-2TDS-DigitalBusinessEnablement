package br.com.fiap.resource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Testes {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		AulaTO a = new AulaTO();
		a.setMateria("Digital Business Enablement");
		a.setProfessor("Rafael");
		a.setSala(707);
		
		AulaDAOImpl dao = new AulaDAOImpl(em);
		dao.cadastrar(a);
		
		try {
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
