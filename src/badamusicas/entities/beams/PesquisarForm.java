package badamusicas.entities.beams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import badamusicas.DAO.AlbumDAO;
import badamusicas.DAO.ListaDao;
import badamusicas.DAO.MusicaDAO;
import badamusicas.entities.Album;
import badamusicas.entities.Lista;
import badamusicas.entities.Musica;
import badamusicas.entities.Usuario;

@ManagedBean(name="pesquisarForm")
@SessionScoped

public class PesquisarForm {
	private ArrayList<Musica> musicas;
	private Map<Long, Boolean> checkedMusics ;
	
	private ArrayList<Album> albuns;
	private Map<Long, Boolean> checkedAlbuns = new HashMap<Long, Boolean>();
	
	private ArrayList<Lista> listas;
	
	private int selectedList;
	private Usuario user;
	
	private String searchName;
	
	public PesquisarForm(){
		setSelectedList(0);
		user= getSessionUser();
		albuns = new ArrayList<Album>();
		musicas = new ArrayList<Musica>();
		
		checkedMusics = new HashMap<Long, Boolean>();
		checkedAlbuns = new HashMap<Long, Boolean>();
		
		setListas(new ListaDao().getList(user.getLogin()));
	}
	
	private Usuario getSessionUser(){
		Usuario u = new Usuario();
		
		u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogado");
		
		return u;
	}
	
	public String buscarMusicas(){
		musicas = new MusicaDAO().getList(searchName);
		albuns = new AlbumDAO().getList(searchName);
		
				
		return "pesquisarmusicas";
	}
	
	public String adicionar(){
		ArrayList<Integer> musicasId = new ArrayList<Integer>();
		//ADD MUSICAS
		
		for(Musica musica : musicas){
			if(checkedMusics.get(musica.getId())){
				musicasId.add(musica.getId());				
			}
		}
		
		new ListaDao().adicionarMusicas(musicasId, selectedList);
		
		//ADD ALBUMS
		
		ArrayList<Integer> albumsId = new ArrayList<Integer>();
		
		for(Album album : albuns){
			if(checkedAlbuns.get(album.getId())){
				albumsId.add(album.getId());
			}
		}
		
		new ListaDao().adicionarAlbuns(albumsId, selectedList);
		
//		checkedMusics.clear();
		return "pesquisarmusicas";
		
	}

	public int getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(int selectedList) {
		this.selectedList = selectedList;
	}

	public ArrayList<Lista> getListas() {
		return listas;
	}

	public void setListas(ArrayList<Lista> listas) {
		this.listas = listas;
	}

	public ArrayList<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}

	public ArrayList<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(ArrayList<Album> albuns) {
		this.albuns = albuns;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Map<Long, Boolean> getCheckedMusics() {
		return checkedMusics;
	}

	public void setCheckedMusics(Map<Long, Boolean> checkedMusics) {
		this.checkedMusics = checkedMusics;
	}

	public Map<Long, Boolean> getCheckedAlbuns() {
		return checkedAlbuns;
	}

	public void setCheckedAlbuns(Map<Long, Boolean> checkedAlbuns) {
		this.checkedAlbuns = checkedAlbuns;
	}
}
