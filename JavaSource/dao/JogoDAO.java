package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Jogo;
import utils.JPAUtils;

public class JogoDAO {

	public static void Cadastrar(Jogo jogoC) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.persist(jogoC);
		manager.getTransaction().commit();
	}
	
	public static Jogo Buscar(int id) {
		EntityManager manager = JPAUtils.getInstance();
		Jogo jogoB = manager.find(Jogo.class, id);
		return jogoB;
	}
	
	public static List<Jogo> Listar(){
		EntityManager manager = JPAUtils.getInstance();
		List<Jogo> jogos = manager.createQuery("SELECT j FROM Jogo j",Jogo.class).getResultList();
		return jogos;
	}
	
	public static void Remover (Jogo jogoR) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.remove(manager.merge(jogoR));
		manager.getTransaction().commit();
	}
	
	public static void Alterar (Jogo jogoA) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();;
		manager.merge(jogoA);
		manager.getTransaction().commit();
	}
}
