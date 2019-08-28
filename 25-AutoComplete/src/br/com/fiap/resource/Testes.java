package br.com.fiap.resource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Testes {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		ClienteTO a = new ClienteTO();
		a.setNome("Joseh");
		
		ClienteTO b = new ClienteTO();
		b.setNome("Josyas");
		
		ClienteTO c = new ClienteTO();
		c.setNome("Joselito");
		
		ClienteDAOImpl dao = new ClienteDAOImpl(em);
		dao.cadastrar(a);
		dao.cadastrar(b);
		dao.cadastrar(c);
		
		try {
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
