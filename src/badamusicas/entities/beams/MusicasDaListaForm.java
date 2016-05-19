package badamusicas.entities.beams;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import badamusicas.DAO.ListaDao;
import badamusicas.entities.Lista;
import badamusicas.entities.Musica;

@ManagedBean(name="musicasDaListaForm")
@ViewScoped

public class MusicasDaListaForm {
	private Lista lista;
	private ListaDao listaDao;
	private ArrayList<Musica> musicas;
	
	public MusicasDaListaForm(){
		listaDao = new ListaDao();
		this.lista = (Lista)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("lista");
		musicas = listaDao.getMusicasLista(lista.getId());
	}
	
	public String removerMusica(Musica musica){
		listaDao.removerMusica(lista.getId(), musica.getId());
		musicas = listaDao.getMusicasLista(lista.getId());
		return null;
	}

	public ArrayList<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}
	
	/*public String carregarMusicas(Lista l) {
		this.lista = l;
		musicas = listaDao.getMusicasLista(lista.getId());
		return "musicasdalista";
	}*/
}
