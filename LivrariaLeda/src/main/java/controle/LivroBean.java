package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.LivroDAO;
import dao.LivroDAOImpl;
import entidade.Livro;

@ManagedBean(name = "LivroBean")
@SessionScoped
public class LivroBean {

	private Livro livro;
	private String pesquisaTitulo;
	private String pesquisaAutores;
	private String pesquisaCategoria;
	
	private LivroDAO livroDAO;
	
	public LivroBean() {
		this.livroDAO = new LivroDAOImpl();
		this.livro = new Livro();
	}
	

	public List<Livro> pesquisarPorCategoria(){
		return this.livroDAO.pesquisarPorCategoria(this.pesquisaCategoria);
	}
	
	public List<Livro> pesquisarPorTitulo(){
		return this.livroDAO.pesquisarPorTitulo(this.pesquisaTitulo);
		
	}
	public List<Livro> pesquisarPorAutores(){
		return this.livroDAO.pesquisarPorAutores(this.pesquisaAutores);
	}
	
	public void inserir() {
		this.livroDAO.inserir(this.livro);
	}
	public Livro getLivro() {
		return this.livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public String getPesquisaTitulo() {
		return pesquisaTitulo;
	}


	public void setPesquisaTitulo(String pesquisaTitulo) {
		this.pesquisaTitulo = pesquisaTitulo;
	}


	public String getPesquisaAutores() {
		return pesquisaAutores;
	}


	public void setPesquisaAutores(String pesquisaAutores) {
		this.pesquisaAutores = pesquisaAutores;
	}


	public String getPesquisaCategoria() {
		return pesquisaCategoria;
	}


	public void setPesquisaCategoria(String pesquisaCategoria) {
		this.pesquisaCategoria = pesquisaCategoria;
	}



}
	
	