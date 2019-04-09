import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CadastroBean {
	private List<String> listaSelecionados;

	public void cadastrar() {
		for(String valor : listaSelecionados) {
			System.out.println(valor);
		}
	}
	
	public List<String> getListaSelecionados() {
		return listaSelecionados;
	}
	public void setListaSelecionados(List<String> listaSelecionados) {
		this.listaSelecionados = listaSelecionados;
	}
	public CadastroBean(List<String> listaSelecionados) {
		super();
		this.listaSelecionados = listaSelecionados;
	}
	public CadastroBean() {
		super();
	}
}
