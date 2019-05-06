import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class CadastroBean {
	private String nome;
	private String cpf;
	private int idade;

	public void cadastrar() {
	}

	public void validaDado(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String valor = value.toString();
		
		if (valor.contains("@") || valor.contains("#") || valor.contains("'")) {
			throw new ValidatorException(new FacesMessage("Nome não pode conter caracteres especiais!"));
		}
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
