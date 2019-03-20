package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/produto")
public class ProdutoResource {
	private EstoqueBO estoqueBo = EstoqueBO.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> buscar() {
		return estoqueBo.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoTO buscar(@PathParam("id") int codigo) {
		return estoqueBo.consultarProduto(codigo);
	}

	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo) {
		estoqueBo.remover(codigo);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uriInfo) {
		estoqueBo.cadastrar(produto);
		System.out.println(produto.getCodigo());
		System.out.println(produto.getDescricao());
		System.out.println(produto.getPreco());
		System.out.println(produto.getQuantidade());
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(produto.getCodigo()));
		return Response.created(builder.build()).build();
	}
}
