import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainDelete {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/14-LojaAppPUT/rest/produto/404");
		ClientResponse response = webResource.delete(ClientResponse.class);
		if (response.getStatus() == 204) {
			System.out.println("Sucesso! ");
		} else {
			System.err.println("Erro: HTTP error code : " + response.getStatus());
		}
	}

}
