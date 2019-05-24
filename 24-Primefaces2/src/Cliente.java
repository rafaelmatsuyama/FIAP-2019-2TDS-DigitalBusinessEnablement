import java.util.Date;

public class Cliente {
	private String nome, cpf;
	private Date time;
	
	public Cliente(String nome, String cpf, Date time) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.time = time;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
