package badamusicas.usuarios;

public class Musica {
	private int id;
	private String nome;
	private String cantor;
	private String nome_arquivo;
	private int album_id;
	private int qtdeTocada;
	private boolean checked;
	
	public Musica(int id, String nome, String cantor, String nome_arquivo, int album_id, int qtdeTocada) {
		this.id = id;
		this.nome = nome;
		this.cantor = cantor;
		this.nome_arquivo = nome_arquivo;
		this.album_id = album_id;
		this.setQtdeTocada(qtdeTocada);
	}
	public Musica(int id, String nome, String cantor, String nome_arquivo, int album_id) {
		this.id = id;
		this.nome = nome;
		this.cantor = cantor;
		this.nome_arquivo = nome_arquivo;
		this.album_id = album_id;
		this.setQtdeTocada(qtdeTocada);
	}
	public Musica(String nome, String cantor, String nome_arquivo, int album_id) {
		this.nome = nome;
		this.cantor = cantor;
		this.nome_arquivo = nome_arquivo;
		this.album_id = album_id;
	}
	public Musica(){
		
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
	public String getCantor() {
		return cantor;
	}
	public void setCantor(String cantor) {
		this.cantor = cantor;
	}
	public String getNome_arquivo() {
		return nome_arquivo;
	}
	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public int getQtdeTocada() {
		return qtdeTocada;
	}
	public void setQtdeTocada(int qtdeTocada) {
		this.qtdeTocada = qtdeTocada;
	}

}
