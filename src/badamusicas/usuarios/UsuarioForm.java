package badamusicas.usuarios;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import badamusicas.DAO.UsuarioDao;

@ManagedBean(name="usuarioForm")
@RequestScoped

public class UsuarioForm {
	private static final String LOGIN = "Daniel";
	private static final String SENHA = "123";
	
	private Usuario usuario;
	
	public UsuarioForm(){
		usuario  = new Usuario();
	}
	
	public String fazerLogin(){
//		UsuarioDao udao = new UsuarioDao();
//		Usuario u = udao.buscar(usuario.getLogin());
//		if (u.validarSenha(usuario.getSenha())){
//			//FacesContext.getCurrentInstance().getExternalContext().getSessionMap()  -  session
//			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", u);
//			return "saudacao";
//		}
		return null;
	}
	
	public String cadastrarUsuario(Usuario usuario){
		UsuarioDao udao = new UsuarioDao();
		udao.adicionar(usuario);
		return "index";
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
}
