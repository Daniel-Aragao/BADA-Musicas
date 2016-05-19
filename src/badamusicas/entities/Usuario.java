package badamusicas.entities;

import java.util.Date;

public class Usuario {
	private String login;
	private String senha;
	private String nome;
	private String cartao;
	private Date validade;
	private int cvv;
	
	public Usuario(){
		
	}

	public Usuario(String login, String senha, String nome, String cartao, Date validade, int cvv) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cartao = cartao;
		this.validade = validade;
		this.cvv = cvv;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public boolean validarSenha(String senha2) {
		return senha.compareTo(senha2) == 0;
	}

}
