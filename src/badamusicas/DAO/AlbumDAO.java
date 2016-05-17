package badamusicas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import badamusicas.entities.Album;

public class AlbumDAO implements IDao<Album> {

	@Override
	public Album buscar(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album buscar(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		Album album = null;
		
		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM musica WHERE  id = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				album = new Album(rs.getInt("id"), rs.getString("nome")); 
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

		return album;
	}

	@Override
	public boolean adicionar(Album e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void alterar(Album e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Album> getList(String nome) {
		ArrayList<Album> albums = new ArrayList<Album>();
		
		Connection con = null;		
		PreparedStatement stmt = null;
		
		try{
			con = Conexao.getConexao();
			stmt = con.prepareStatement("SELECT * FROM album WHERE nome LIKE ?");
			
			stmt.setString(1, "%"+nome+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Album album = new Album(rs.getInt("id"), rs.getString("nome")); 

				albums.add(album);
			}
			
			
		}catch(SQLException ee){
			
		}

		
		return albums;
	}

	@Override
	public ArrayList<Album> getAll() {
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
		// TODO Auto-generated method stub
		return false;
	}

}
