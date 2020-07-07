package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Livro;
import utils.JPAUtils;

public class LivroDAO {

	public static void Cadastrar(Livro livroC) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.persist(livroC);
		manager.getTransaction().commit();
	}
	
	public static Livro Buscar(int id) {
		EntityManager manager = JPAUtils.getInstance();
		Livro livroB = manager.find(Livro.class, id);
		return livroB;
	}
	
	public static List<Livro> Listar(){
		EntityManager manager = JPAUtils.getInstance();
		List<Livro> livros = manager.createQuery("SELECT l FROM Livro l",Livro.class).getResultList();
		for (Livro livro : livros) {
			System.out.println(livro);
		}
		return livros;
	}
	
	public static void Remover (Livro livroR) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.remove(manager.merge(livroR));
		manager.getTransaction().commit();
	}
	
	public static void Alterar (Livro livroA) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();;
		manager.merge(livroA);
		manager.getTransaction().commit();
	}
	
}
