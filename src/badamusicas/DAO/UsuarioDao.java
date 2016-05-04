package badamusicas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import badamusicas.usuarios.Usuario;

public class UsuarioDao implements IDao<Usuario>{

	public Usuario buscar(String login) {
		
		
		
		return null;
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
					"insert into e (login, senha, nome, cartao, validade, cvv) values(?,?,?,?,?,?)");

			stmt.setString(1, e.getLogin());
			stmt.setString(2, e.getSenha());
			stmt.setString(3, e.getNome());
			stmt.setString(4, e.getCartao());
			stmt.setTimestamp(5, e.getValidade());
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
	public void remover(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
