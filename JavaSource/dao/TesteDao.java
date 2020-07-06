package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Teste;
import utils.JPAUtils;

public class TesteDao {

	public static void Cadastrar(Teste teste1) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.persist(teste1);
		manager.getTransaction().commit();
	} 
	
	public static Teste Buscar (int id) {
		EntityManager manager = JPAUtils.getInstance();
		Teste teste1 = manager.find(Teste.class, id);
		return teste1;
	}
	
	public static List<Teste> Listar (){
		EntityManager manager = JPAUtils.getInstance();
		List <Teste> testes = manager.createQuery("SELECT t FROM Teste t", Teste.class ).getResultList();
	return testes;
	}
	
	public static void Remover (Teste teste) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.remove(manager.merge(teste));
		manager.getTransaction().commit();
	}
	
	public static void Alterar (Teste teste) {
		EntityManager manager = JPAUtils.getInstance();
		manager.getTransaction().begin();
		manager.merge(teste);
		manager.getTransaction().commit();
	}
}
