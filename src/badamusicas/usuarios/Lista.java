package badamusicas.usuarios;

public class Lista {
	private int id;
	private String nome;
	private String usuario_login;
		
	public Lista(int id, String nome, String usuario_login) {
		this.id = id;
		this.nome = nome;
		this.usuario_login = usuario_login;
	}
	
	public Lista(){
		
	}
	
	public Lista(String nome, String usuario_login) {
		this.nome = nome;
		this.usuario_login = usuario_login;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario_login() {
		return usuario_login;
	}
	public void setUsuario_login(String usuario_login) {
		this.usuario_login = usuario_login;
	}
}
