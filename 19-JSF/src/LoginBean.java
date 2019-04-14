import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
	private String login;
	private String senha;
	private boolean termo;

	public String logar() {
		if ("rafael".equals(getLogin()) && "123".equals(getSenha())) {
			System.out.println("Usuario logado: " + getLogin());
			System.out.println(isTermo());
			return "carrinho";
		} else {
			System.out.println("Usuario com senha incorreta");
			return "login";
		}
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
	public boolean isTermo() {
		return termo;
	}

	public void setTermo(boolean termo) {
		this.termo = termo;
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