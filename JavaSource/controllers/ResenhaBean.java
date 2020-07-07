package controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.RollbackException;

import dao.FilmeDAO;
import dao.JogoDAO;
import dao.LivroDAO;
import dao.ResenhaDAO;
import model.Filme;
import model.Jogo;
import model.Livro;
import model.Resenha;

@Named
@SessionScoped
public class ResenhaBean implements Serializable {

	private static final long serialVersionUID = 7355269089481055964L;
	
	public ResenhaBean() {
		listaResenhas = ResenhaDAO.Listar();
		resenhaB = new Resenha();
		
		
	}
	
	private Jogo jogoA;
	private Filme filmeA;
	private Livro livroA;
	
	private Resenha resenhaB;
	
	private List<Resenha> listaResenhas;
	
	public Resenha getResenhaB() {
		return resenhaB;
	}
	public void setResenhaB(Resenha resenhaB) {
		this.resenhaB = resenhaB;
	}
	public List<Resenha> getlistaResenhas(){
	listaResenhas = ResenhaDAO.Listar();
	return listaResenhas;
	}
	public void setlistaResenhas(List<Resenha> listaResenhas) {
		this.listaResenhas = listaResenhas;
	}
	
	
	
	public String CadastrarResenha() {
		System.out.println(resenhaB);
		try{
			ResenhaDAO.Cadastrar(resenhaB);
		}catch (RollbackException  e) {
			return null;
		}
		resenhaB = new Resenha();
		return ("Jogos.xhtml?faces-redirect=true");
	}
	
	public String Remover (Resenha resenhaB) {
		ResenhaDAO.Remover(resenhaB);
		return("Jogos.xhtml?faces-redirect=true");
	}
	
	public String Detalhar() {
		int idResenha = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		resenhaB = ResenhaDAO.Buscar(idResenha);
		return("AlterarResenha.xhtml?faces-redirect=true");
	}
	public String Alterar() {
		ResenhaDAO.Alterar(resenhaB);
		resenhaB = new Resenha();
		return("Resenhas.xhtml?faces-redirect=true");
	}
	
	public String ReceberId() {
		int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		jogoA = JogoDAO.Buscar(id);
		
		resenhaB.setObjeto(jogoA);
		return("CadastrarResenha.xhtml?faces-redirect=true");
	}
	public String ReceberIdFilme() {
		int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		filmeA = FilmeDAO.Buscar(id);
		resenhaB.setObjeto(filmeA);
		return("CadastrarResenha.xhtml?faces-redirect=true");
	}
	public String ReceberIdLivro() {
		int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		livroA = LivroDAO.Buscar(id);
		resenhaB.setObjeto(livroA);
		return("CadastrarResenha.xhtml?faces-redirect=true");
	}
	
	public String Visualizar() {
		int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		resenhaB = ResenhaDAO.Buscar(id);
		System.out.println(resenhaB.getTitulo());
		return("Resenha.xhtml?faces-redirect=true");
	}
	
}
