import java.util.Date;

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
	
	private int estrelas;
	private Date time;

	public void cadastrar() {
		System.out.println(estrelas);
		System.out.println(time);
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}



	public int getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
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
