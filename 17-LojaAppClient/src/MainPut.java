import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainPut {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/14-LojaAppPUT/rest/produto/404");
		ProdutoTO produto = new ProdutoTO(404, "Camiseta preta", 300, 110);
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class, produto);
		if (response.getStatus() == 200) {
			System.out.println("Sucesso! ");
		} else {
			System.err.println("Erro: HTTP error code : " + response.getStatus());
		}
	}

}
