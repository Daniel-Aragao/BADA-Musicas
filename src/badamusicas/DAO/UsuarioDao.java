package badamusicas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import badamusicas.entities.Usuario;

public class UsuarioDao implements IDao<Usuario>{

	public Usuario buscar(String login) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		Usuario user = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"SELECT * FROM usuario WHERE  login = ?");
			stmt.setString(1, login);
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				user = new Usuario(
						rs.getString("login"),
						rs.getString("senha"),
						rs.getString("nome"),
						rs.getString("cartao"),
						rs.getDate("validade"),
						rs.getInt("cvv"));
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

		return user;
	}

	@Override
	public Usuario buscar(int id) {
		return null;	
	}

	@Override
	public boolean adicionar(Usuario e) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConexao();
			stmt = con.prepareStatement(
					"insert into usuario (login, senha, nome, cartao, validade, cvv) values(?,?,?,?,?,?)");

			stmt.setString(1, e.getLogin());
			stmt.setString(2, e.getSenha());
			stmt.setString(3, e.getNome());
			stmt.setString(4, e.getCartao());
			stmt.setTimestamp(5, new Timestamp(e.getValidade().getTime()));
//			stmt.setDate(5, new java.sql.Date(e.getValidade().getTime()));
			stmt.setInt(6, e.getCvv());

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
	public void alterar(Usuario e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Usuario> getList(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> getAll() {
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
