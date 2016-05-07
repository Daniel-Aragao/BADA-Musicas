package badamusicas.usuarios.beams;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import badamusicas.DAO.UsuarioDao;
import badamusicas.usuarios.Usuario;

@ManagedBean(name="usuarioForm")
@RequestScoped

public class UsuarioForm {
	
	private Usuario usuario;
	private boolean cadastro;
	
	public UsuarioForm(){
		usuario  = new Usuario();
	}
	
	public String fazerLogin(){
		UsuarioDao udao = new UsuarioDao();
		Usuario u = udao.buscar(usuario.getLogin());
		if (u.validarSenha(usuario.getSenha())){
			//FacesContext.getCurrentInstance().getExternalContext().getSessionMap()  - pegar a session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", u);
			return "gerenciarlistas";
		}
		return null;
	}
	
	public String cadastrarUsuario(Usuario usuario){
		UsuarioDao udao = new UsuarioDao();
		udao.adicionar(usuario);
		return "index";
	}
	
	public String cadastrar(){
		setCadastro(true);
		return "cadastro";
	}
	
	public String voltar(){
		if(getCadastro()){
			System.out.println("index");
			return "index";
		}
		System.out.println("gerenciar listas");
		return "gerenciarlistas";
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}

	public boolean getCadastro() {
		return cadastro;
	}

	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}
}
