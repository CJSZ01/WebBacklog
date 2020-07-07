package controllers;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.JogoDAO;
import dao.ObjetoDAO;
import model.Jogo;
import model.Objeto;
import model.Resenha;


@Named
@SessionScoped
public class JogoBean implements Serializable {

	private static final long serialVersionUID = 7355200089481055964L;

	public JogoBean() {
		listaJogos = JogoDAO.Listar();
		jogoB = new Jogo();
		objetoB = new Objeto();
		resenha = new Resenha();
	}
	
	private Objeto objetoB;
	
	public Objeto getObjetoB() {
		return objetoB;
	}
	public void setObjetoB(Objeto objetoB) {
		this.objetoB = objetoB;
	}

	private Jogo jogoB;
	public Jogo getJogoB() {
		return jogoB;
	}
	public void setJogoB(Jogo jogoB) {
		this.jogoB = jogoB;
	}
	
	private List<Jogo> listaJogos;
	
	public List<Jogo> getListaJogos(){
	listaJogos = JogoDAO.Listar();
	return listaJogos;
	}
	public void setListaJogos(List<Jogo> listaJogos) {
		this.listaJogos = listaJogos;
	}
	
	private Resenha resenha;
	
	
	public Resenha getResenha() {
		return resenha;
	}
	public void setResenha(Resenha resenha) {
		this.resenha = resenha;
	}
	public String Cadastrar() {
		JogoDAO.Cadastrar(jogoB);
		jogoB = new Jogo();
		return ("Jogos.xhtml?faces-redirect=true");
	}
	
	public String Remover (Jogo jogoB) {
		JogoDAO.Remover(jogoB);
		return("Jogos.xhtml?faces-redirect=true");
	}
	
	public String Detalhar() {
		int idJogo = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idJogo"));
		jogoB = JogoDAO.Buscar(idJogo);
		return("AlterarJogo.xhtml?faces-redirect=true");
	}
	
	public String DetalharResenha() {
		int idJogo = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idJogo"));
		objetoB = ObjetoDAO.Buscar(idJogo);
		System.out.println(objetoB.getTitulo() + "awawawawa");
		return("CadastrarResenha.xhtml?faces-redirect=true");
	}
	
	
	public String Alterar() {
		JogoDAO.Alterar(jogoB);
		jogoB = new Jogo();
		objetoB = new Objeto();
		resenha = new Resenha();
		return("Jogos.xhtml?faces-redirect=true");
	}
	
	
	
}

