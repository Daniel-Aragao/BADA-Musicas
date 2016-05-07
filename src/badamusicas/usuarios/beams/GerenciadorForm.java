package badamusicas.usuarios.beams;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import badamusicas.DAO.ListaDao;
import badamusicas.usuarios.Lista;
import badamusicas.usuarios.Usuario;

@ManagedBean(name="gerenciadorForm")
@RequestScoped

public class GerenciadorForm {
	
	private ArrayList<Lista> listas;
	private Usuario user;
	
	private Lista novaLista;
	private Lista selectedList;
	
	public GerenciadorForm(){
		listas = new ArrayList<Lista>();
		
		user = getSessionUser();
		
		novaLista = new Lista();
		selectedList = new Lista();
		
		listas.addAll(new ListaDao().getList(user.getLogin()));
	}
	
	public Lista getLista(int id){
		Lista lista = new ListaDao().buscar(id);				
		return lista;
	}
	
	public String addLista(){
		
		Lista lista = new Lista(novaLista.getNome(), user.getLogin());
		
		new ListaDao().adicionar(lista);
		
		novaLista.setNome("");
		
		return "gerenciarlistas";
	}
	
	public String removeList(){		
		new ListaDao().remover(selectedList.getId());
		
		return "gerenciarlistas";
	}

	public ArrayList<Lista> getListas() {
		return listas;
	}

	public void setListas(ArrayList<Lista> listas) {
		this.listas = listas;
	}
	
	private Usuario getSessionUser(){
		Usuario u = new Usuario();
		
		u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogado");
		
		return u;
	}

	public Lista getNovaLista() {
		return novaLista;
	}

	public void setNovaLista(Lista novaLista) {
		this.novaLista = novaLista;
	}

	public Lista getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(Lista selectedList) {
		this.selectedList = selectedList;
	}


}
