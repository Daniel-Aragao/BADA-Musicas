package badamusicas.DAO;

import java.util.ArrayList;

public interface IDao<T> {

	public T buscar(String Id);
	public T buscar(int id);
	
	public boolean adicionar(T e);
	
	public void alterar(T e);
	
	public ArrayList<T> getList(String param);
	public ArrayList<T> getAll();
	
	public void remover(String id);
	public void remover(int id);
}
