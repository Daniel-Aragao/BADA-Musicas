package badamusicas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import badamusicas.entities.Lista;
import badamusicas.entities.Musica;

public class ListaDao implements IDao<Lista>{

	@Override
	public Lista buscar(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lista buscar(int id) {
		Lista lista = null;
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
			con = Conexao.getConexao();
			stmt = con.prepareStatement("SELECT * FROM lista where id = ?");
			
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				lista = new Lista(
						rs.getInt("id"), 
						rs.getString("nome"),
						rs.getString("usuario_login"));				
			}
			
			
		}catch(SQLException ee){
			
		}

		
		return lista;
	}
	
	public void adicionarMusicas(ArrayList<Integer> musicasId, int listaId){
		for(int musicaId : musicasId){
			adicionarMusica(musicaId, listaId);
		}
	}
	public void adicionarMusica(int musicaId, int listaId){
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"insert into musica_da_lista values (?, ?, ?)");

			stmt.setInt(1, listaId);
			stmt.setInt(2, musicaId);
			stmt.setInt(3, 0);

			stmt.executeUpdate();
		} catch (SQLException ee) {
			ee.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException ee) {
				ee.printStackTrace();
			}
		}

	}

	public void adicionarAlbuns(ArrayList<Integer> musicasId, int listaId){
		for(int albumId : musicasId){
			adicionarAlbum(albumId, listaId);
		}		
	}
	
	private void adicionarAlbum(int albumId, int listaId) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"INSERT  INTO musica_da_lista (lista_id, musica_id, qtde_vezes_tocada) "
					+"SELECT ?, m.id, 0 FROM album a "
					+"JOIN musica m ON m.album_id  = a.id "
					+"WHERE a.id = ?");

			stmt.setInt(1, listaId);
			stmt.setInt(2, albumId);

			stmt.executeUpdate();
		} catch (SQLException ee) {
			ee.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException ee) {
				ee.printStackTrace();
			}
		}

	}

	@Override
	public boolean adicionar(Lista e) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"insert into lista(nome, usuario_login) values (?, ?)");

			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getUsuario_login());

			stmt.executeUpdate();
			return true;
		} catch (SQLException ee) {
			ee.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException ee) {
				ee.printStackTrace();
				return false;
			}
		}
	}
	
	
	@Override
	public void alterar(Lista e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Lista> getList(String param) {
		ArrayList<Lista> listas = new ArrayList<Lista>();
		
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
			con = Conexao.getConexao();
			stmt = con.prepareStatement("SELECT * FROM lista where usuario_login = ?");
			
			stmt.setString(1, param);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Lista lista = new Lista(
						rs.getInt("id"), 
						rs.getString("nome"),
						rs.getString("usuario_login")); 
				
				listas.add(lista);
			}
			
			
		}catch(SQLException ee){
			
		}

		
		return listas;
	}

	@Override
	public ArrayList<Lista> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remover(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(int id) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"DELETE FROM lista WHERE id = ?");

			stmt.setInt(1, id);			

			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}		
	}
	
	public boolean removerMusica(int id_lista, int id_musica) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"DELETE FROM musica_da_lista WHERE lista_id = ? AND musica_id = ?");

			stmt.setInt(1, id_lista);
			stmt.setInt(2, id_musica);

			stmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		
	}
	
	public ArrayList<Musica> getMusicasLista(int lista_id) {
		ArrayList<Musica> musicas = new ArrayList<Musica>();
		
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
			con = Conexao.getConexao();
			stmt = con.prepareStatement("SELECT * FROM musica m "
										+ "JOIN musica_da_lista ml on ml.musica_id = m.id "
										+ "WHERE ml.lista_id = ?");
			
			stmt.setInt(1, lista_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Musica musica = new Musica(
						rs.getInt("id"), 
						rs.getString("nome"),
						rs.getString("cantor"),
						rs.getString("nome_arquivo"),
						rs.getInt("album_id"),
						rs.getInt("qtde_vezes_tocada")); 
//				int id, String nome, String cantor, String nome_arquivo, int album_id
				musicas.add(musica);
			}
			
			
		}catch(SQLException ee){
			ee.printStackTrace();
		}

		
		return musicas;
	}
	
	public void tocada(int lista_id, int musica_id) {
		ArrayList<Musica> musicas = new ArrayList<Musica>();
		
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
			con = Conexao.getConexao();
			stmt = con.prepareStatement("UPDATE musica_da_lista "
						+"SET qtde_vezes_tocada = qtde_vezes_tocada + 1 "
						+"WHERE lista_id = ? AND musica_id = ?");
			
			stmt.setInt(1, lista_id);
			stmt.setInt(2, musica_id);
			
			stmt.executeUpdate();			
			
		}catch(SQLException ee){
			ee.printStackTrace();
		}
		
	}

}
