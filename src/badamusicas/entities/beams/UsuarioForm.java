package badamusicas.entities.beams;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import badamusicas.DAO.UsuarioDao;
import badamusicas.entities.Usuario;

@ManagedBean(name = "usuarioForm")
@RequestScoped

public class UsuarioForm {

	private Usuario usuario;
	
	@ManagedProperty(value="#{usuarioLogado}")
	private Usuario usuarioLogado;
	
	private boolean cadastro;
	UsuarioDao udao = new UsuarioDao();

	public UsuarioForm() {
		usuario = new Usuario();
	}

	public String fazerLogin() {
		UsuarioDao udao = new UsuarioDao();
		Usuario u = udao.buscar(usuario.getLogin());
		if (u != null && u.validarSenha(usuario.getSenha())) {
			// FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
			// - pegar a session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", u);
			return "gerenciarlistas";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Usuário não encontrado ou senha incorreta."));
		}
		return null;
	}

	public String fazerLogoff() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		return "index";
	}

	public String cadastrarUsuario(Usuario usuario) {
		udao.adicionar(usuario);
		return "index";
	}

	public String cadastrar() {
		setCadastro(true);
		return "cadastro";
	}

	public String alterarUsuario() {
		udao.alterar(usuarioLogado);
		return fazerLogoff();
	}

	public String voltar() {
		if (getCadastro()) {
			System.out.println("index");
			return "index";
		}
		System.out.println("gerenciar listas");
		return "gerenciarlistas";
	}

	public String checkloged() {
		if (getSessionUser() == null) {
			return null;
		} else {
			return "gerenciarlistas";
		}
	}

	private Usuario getSessionUser() {
		Usuario u = new Usuario();

		u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogado");

		return u;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean getCadastro() {
		return cadastro;
	}

	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	
}
