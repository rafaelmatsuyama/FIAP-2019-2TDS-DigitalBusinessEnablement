

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.apache.ws.axis2.EstoqueBOStub;
import org.apache.ws.axis2.EstoqueBOStub.ConsultarProduto;
import org.apache.ws.axis2.EstoqueBOStub.ConsultarProdutoResponse;
import org.apache.ws.axis2.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {
	private static Logger log = Logger.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) throws RemoteException {
		log.warn("Início da Aplicação");
		String nome = "Loja FIAP Run";
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = 
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(nome + " " + hoje.format(formatador));
		System.out.println("Digite o código do produto desejado: ");
		Scanner scanner = new Scanner(System.in);
		int codigo = scanner.nextInt();
		scanner.close();
		EstoqueBOStub stub = new EstoqueBOStub();
		ConsultarProduto consulta = new ConsultarProduto();
		consulta.setCodigo(codigo);
		ConsultarProdutoResponse response = 
				stub.consultarProduto(consulta);
		ProdutoTO produto = response.get_return();
		System.out.println(produto.getDescricao());
		log.warn("Final da Aplicação");
	}
}
