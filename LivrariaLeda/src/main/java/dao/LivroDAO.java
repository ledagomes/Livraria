package dao;

import java.util.List;
import entidade.Livro;

public interface LivroDAO {
	
	public void inserir(Livro livro);
	
	public List<Livro> pesquisarPorTitulo(String titulo);
	public List<Livro> pesquisarPorAutores(String autores);
	public List<Livro> pesquisarPorCategoria(String categoria);

}

