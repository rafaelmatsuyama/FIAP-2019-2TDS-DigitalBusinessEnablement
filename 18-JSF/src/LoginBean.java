import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
	private String login;
	private String senha;
	private boolean termo;

	public void logar() {
		if ("rafael".equals(getLogin()) && "1234".equals(getSenha())) {
			System.out.println("Usuario logado: " + getLogin());
			System.out.println(isTermo());
		} else
			System.out.println("Usuario com senha incorreta");
	}

	public boolean isTermo() {
		return termo;
	}

	public void setTermo(boolean termo) {
		this.termo = termo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LoginBean(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	public LoginBean() {
		super();
	}
}
