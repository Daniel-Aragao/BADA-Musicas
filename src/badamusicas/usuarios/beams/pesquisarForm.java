package badamusicas.usuarios.beams;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import badamusicas.usuarios.Lista;
import badamusicas.usuarios.Usuario;

@ManagedBean(name="pesquisarForm")
@RequestScoped

public class PesquisarForm {
//	private ArrayList<Musica> musicas;
//	private ArrayList<Album> albuns;
	private Lista selectedList;
	private Usuario user;
	
	public PesquisarForm(){
		setSelectedList(new Lista());
		user= getSessionUser();
	}
	
	private Usuario getSessionUser(){
		Usuario u = new Usuario();
		
		u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogado");
		
		return u;
	}
	
	public String adicionar(){
		
		
		return null;
	}

	public Lista getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(Lista selectedList) {
		this.selectedList = selectedList;
	}
}
