package br.com.fiap.resource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/aula")
public class AulaResource {
	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AulaTO buscar(@PathParam("id") int codigo) throws Exception {
		EntityManager em = fabrica.createEntityManager();
		AulaDAOImpl dao = new AulaDAOImpl(em);
		return dao.buscar(codigo);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(AulaTO aula, @Context UriInfo uriInfo) throws Exception{
		EntityManager em = fabrica.createEntityManager();
		AulaDAOImpl dao = new AulaDAOImpl(em);
		dao.cadastrar(aula);
		dao.commit();
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(aula.getCodigo()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(AulaTO aula, @PathParam("id") int codigo) throws Exception{
		EntityManager em = fabrica.createEntityManager();
		AulaDAOImpl dao = new AulaDAOImpl(em);
		aula.setCodigo(codigo);
		dao.atualizar(aula);
		dao.commit();
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo) throws Exception{
		EntityManager em = fabrica.createEntityManager();
		AulaDAOImpl dao = new AulaDAOImpl(em);
		dao.remover(codigo);
		dao.commit();
	}

}
