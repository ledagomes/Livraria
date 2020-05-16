package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Livro;
import entidade.Usuario;
import util.JpaUtil;

public class LivroDAOImpl implements LivroDAO {

	public void inserir(Livro livro) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(livro);
		
		tx.commit();
		ent.close();

	}


	public List<Livro> pesquisarPorTitulo(String titulo) {
		EntityManager ent = JpaUtil.getEntityManager();
		
		Query query = ent.createQuery("select * from Livros L where L.Titulo like :ptitulo")
						 .setParameter("ptitulo", "%" + titulo + "%");
		
		List<Livro> livros = query.getResultList();
		
		return livros;
	}
	
	public List<Livro> pesquisarPorAutores(String autores) {
		EntityManager ent = JpaUtil.getEntityManager();
		
		Query query = ent.createQuery("select * from Livros L where L.Autores like :pautores")
						 .setParameter("pautores", "%" + autores + "%");
		
		List<Livro> livros = query.getResultList();
		
		return livros;
	}
	
	public List<Livro> pesquisarPorCategoria(String categoria) {
		EntityManager ent = JpaUtil.getEntityManager();
		
		Query query = ent.createQuery("from Livros L where L.Categoria = :pcategoria")
						 .setParameter("pcategoria", categoria);

		List<Livro> livros = query.getResultList();
		
		return livros;
	}
}
