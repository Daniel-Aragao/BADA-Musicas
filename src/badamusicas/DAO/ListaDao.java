package badamusicas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import badamusicas.usuarios.Lista;

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

}
