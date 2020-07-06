package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Filme;
import utils.JPAUtils;

public class FilmeDAO {

	public static void Cadastrar(Filme FilmeC) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.persist(FilmeC);
		manager.getTransaction().commit();
	}
	
	public static Filme Buscar(int id) {
		EntityManager manager = JPAUtils.getInstance();
		Filme FilmeB = manager.find(Filme.class, id);
		return FilmeB;
	}
	
	public static List<Filme> Listar(){
		EntityManager manager = JPAUtils.getInstance();
		List<Filme> Filmes = manager.createQuery("SELECT j FROM Filme j",Filme.class).getResultList();
		return Filmes;
	}
	
	public static void Remover (Filme FilmeR) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.remove(manager.merge(FilmeR));
		manager.getTransaction().commit();
	}
	
	public static void Alterar (Filme FilmeA) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();;
		manager.merge(FilmeA);
		manager.getTransaction().commit();
	}
	
}
