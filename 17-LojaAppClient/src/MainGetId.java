import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainGetId {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int codigo = entrada.nextInt();
		entrada.close();
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/14-LojaAppPUT/rest/produto/" + codigo);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (response.getStatus() == 200) {
			ProdutoTO produto = response.getEntity(ProdutoTO.class);
			System.out.println(produto.getDescricao());
		} else {
			System.out.println("Erro - HTTP Status: " + response.getStatus());
		}
	}

}
