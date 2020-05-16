package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LIVRO")
public class Livro {

	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(generator = "S_LIVRO")
	@SequenceGenerator(name = "S_LIVRO", sequenceName = "S_LIVRO", allocationSize = 1)
	private Long id;
	
	@Column(name="TITULO", nullable = false)
	private String titulo;
	
		
	@Column(name = "CATEGORIA", nullable = false)
	private String categoria;
	
	@Column(name = "AUTORES", nullable = false)
	private String autores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

}

	




