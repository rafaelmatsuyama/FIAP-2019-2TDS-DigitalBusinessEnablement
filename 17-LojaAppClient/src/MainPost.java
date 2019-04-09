import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainPost {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource =
		client.resource("http://localhost:8080/14-LojaAppPUT/rest/produto/");
		ProdutoTO produto = new ProdutoTO(404, "Camiseta coral", 500, 10);
		ClientResponse response =
		webResource.type("application/json").post(ClientResponse.class, produto);
		if (response.getStatus() == 201) {
		System.out.println("Sucesso! " + response.getLocation());
		}else{
		System.err.println("Erro: HTTP error code : " + response.getStatus());
		}
	}

}
