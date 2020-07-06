package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Resenha;
import utils.JPAUtils;

public class ResenhaDAO {

	public static void Cadastrar(Resenha resenhaC) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.persist(resenhaC);
		manager.getTransaction().commit();
	}
	
	public static Resenha Buscar(int ResenhaId) {
		EntityManager manager = JPAUtils.getInstance();
		Resenha resenhaB = manager.find(Resenha.class,ResenhaId);
		return resenhaB;
	}
	
	public static List<Resenha> Listar(){
		EntityManager manager = JPAUtils.getInstance();
		List<Resenha> resenhas = manager.createQuery("SELECT r FROM Resenha r",Resenha.class).getResultList();
		return resenhas;
	}
	
	public static void Remover (Resenha ResenhaR) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.remove(manager.merge(ResenhaR));
		manager.getTransaction().commit();
	}
	
	public static void Alterar (Resenha resenhaA) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();;
		manager.merge(resenhaA);
		manager.getTransaction().commit();
	
}
}
