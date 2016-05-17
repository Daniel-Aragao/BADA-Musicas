package badamusicas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import badamusicas.entities.Musica;

public class MusicaDAO implements IDao<Musica>{

	@Override
	public Musica buscar(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Musica buscar(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		Musica musica = null;
		
		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM musica WHERE  id = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				musica = new Musica(
						rs.getInt("id"), 
						rs.getString("nome"),
						rs.getString("cantor"),
						rs.getString("nome_arquivo"),
						rs.getInt("album_id"),
						rs.getInt("qtde_vezes_tocada")); 
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return musica;
	}

	@Override
	public boolean adicionar(Musica e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void alterar(Musica e) {
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
			
			stmt.setString(1, "%"+nome+"%");
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
			ee.printStackTrace();
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
						rs.getInt("album_id"),
						rs.getInt("qtde_vezes_tocada")); 
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
						rs.getInt("album_id"),
						rs.getInt("qtde_vezes_tocada")); 
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
