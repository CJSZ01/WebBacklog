package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Jogo;
import model.Objeto;
import utils.JPAUtils;

public class ObjetoDAO {

	/*public static Jogo Buscar(int id) {
		EntityManager manager = JPAUtils.getInstance();
		Jogo jogoB = manager.find(Jogo.class, id);
		return jogoB;
	}*/
	
	public static Objeto Buscar(int id) {
		EntityManager manager = JPAUtils.getInstance();
		Objeto objetoB = manager.find(Objeto.class, id);
		return objetoB;
	}
	
	public static List<Objeto> Listar(){
		EntityManager manager = JPAUtils.getInstance();
		List<Objeto> objetos = manager.createQuery("SELECT o FROM Objeto o",Objeto.class).getResultList();
		return objetos;
	}
	
}
