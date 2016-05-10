package badamusicas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import badamusicas.usuarios.Lista;
import badamusicas.usuarios.Musica;

public class MusicaDAO implements IDao{

	@Override
	public Object buscar(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean adicionar(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void alterar(Object e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Musica> getList(String nome) {
		ArrayList<Musica> musicas = new ArrayList<Musica>();
		
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
			con = Conexao.getConexao();
			stmt = con.prepareStatement("SELECT * FROM musica WHERE nome LIKE ?");
			
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Musica musica = new Musica(
						rs.getInt("id"), 
						rs.getString("nome"),
						rs.getString("cantor"),
						rs.getString("nome_arquivo"),
						rs.getInt("album_id")); 
//				int id, String nome, String cantor, String nome_arquivo, int album_id
				musicas.add(musica);
			}
			
			
		}catch(SQLException ee){
			
		}

		
		return musicas;
	}
	
	public ArrayList<Musica> getMusicasLista(int lista_id) {
		ArrayList<Musica> musicas = new ArrayList<Musica>();
		
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
			con = Conexao.getConexao();
			stmt = con.prepareStatement("SELECT m.id,m.nome,m.cantor,m.nome_arquivo,m.album_id FROM musica m"
										+ "JOIN musica_da_lista ml on ml.musica_id = m.id"
										+ "WHERE ml.lista_id = ?");
			
			stmt.setInt(1, lista_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Musica musica = new Musica(
						rs.getInt("id"), 
						rs.getString("nome"),
						rs.getString("cantor"),
						rs.getString("nome_arquivo"),
						rs.getInt("album_id")); 
//				int id, String nome, String cantor, String nome_arquivo, int album_id
				musicas.add(musica);
			}
			
			
		}catch(SQLException ee){
			
		}

		
		return musicas;
	}
	
	public ArrayList<Musica> getMusicasAlbum(int album_id) {
		ArrayList<Musica> musicas = new ArrayList<Musica>();
		
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
			con = Conexao.getConexao();
			stmt = con.prepareStatement("SELECT * FROM musica m"
										+ "WHERE m.album_id = ?");
			
			stmt.setInt(1, album_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Musica musica = new Musica(
						rs.getInt("id"), 
						rs.getString("nome"),
						rs.getString("cantor"),
						rs.getString("nome_arquivo"),
						rs.getInt("album_id")); 
//				int id, String nome, String cantor, String nome_arquivo, int album_id
				musicas.add(musica);
			}
			
			
		}catch(SQLException ee){
			
		}

		
		return musicas;
	}
	
	@Override
	public ArrayList<Musica> getAll() {
		ArrayList<Musica> musicas = new ArrayList<Musica>();
		
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
			con = Conexao.getConexao();
			stmt = con.prepareStatement("SELECT * FROM musica");

			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Musica musica = new Musica(
						rs.getInt("id"), 
						rs.getString("nome"),
						rs.getString("cantor"),
						rs.getString("nome_arquivo"),
						rs.getInt("album_id")); 
//				int id, String nome, String cantor, String nome_arquivo, int album_id
				musicas.add(musica);
			}
			
			
		}catch(SQLException ee){
			
		}

		
		return musicas;
	}

	@Override
	public boolean remover(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
