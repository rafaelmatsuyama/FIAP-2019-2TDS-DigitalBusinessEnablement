import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CarrinhoBean {
	private List<String> listaSelecionados;
	private String quantidade;
	private String pagamento;

	public void comprar() {
		for(String valor : listaSelecionados) {
			System.out.println(valor);
		}
		
		System.out.println("Quantidade: " + getQuantidade());
		System.out.println("Forma de Pagamento: " + getPagamento());
	}
		
	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public List<Forma> getFormasPagamento() {
		List<Forma> formas = new ArrayList<Forma>();
		formas.add(new Forma(1, "Crédito"));
		formas.add(new Forma(2, "Débito"));
		formas.add(new Forma(3, "Boleto"));
		return formas;
	}
	
	public List<Produto> getProdutos(){
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto(1, "Notebook Sony"));
		produtos.add(new Produto(2, "Tablet Samsung"));
		produtos.add(new Produto(3, "Smartwatch Apple"));
		return produtos;
	}
	
	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public List<String> getListaSelecionados() {
		return listaSelecionados;
	}
	public void setListaSelecionados(List<String> listaSelecionados) {
		this.listaSelecionados = listaSelecionados;
	}
	public CarrinhoBean(List<String> listaSelecionados) {
		super();
		this.listaSelecionados = listaSelecionados;
	}
	public CarrinhoBean() {
		super();
	}
}
