package badamusicas.usuarios;

import badamusicas.DAO.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
		return "saudacao";
	}
	
	public String cadastrarUsuario(Usuario usuario){
		
		if(usuario.validarCampos()){
			//salvar usuario
			return "index";
		}		
		
		return null;
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
}
