package controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.FilmeDAO;
import model.Filme;
import model.Objeto;
import model.Resenha;

@Named
@SessionScoped
public class FilmeBean implements Serializable {

	private static final long serialVersionUID = 7355200089481055964L;

	public FilmeBean() {
		listaFilmes = FilmeDAO.Listar();
		FilmeB = new Filme();
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
	public Resenha getResenha() {
		return resenha;
	}
	public void setResenha(Resenha resenha) {
		this.resenha = resenha;
	}

	private Resenha resenha;
	
	private Filme FilmeB;
	public Filme getFilmeB() {
		return FilmeB;
	}
	public void setFilmeB(Filme FilmeB) {
		this.FilmeB = FilmeB;
	}
	
	private List<Filme> listaFilmes;
	
	public List<Filme> getListaFilmes(){
	listaFilmes = FilmeDAO.Listar();
	return listaFilmes;
	}
	public void setListaFilmes(List<Filme> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}
	
	
	
	public String Cadastrar() {
		FilmeDAO.Cadastrar(FilmeB);
		FilmeB = new Filme();
		return ("Filmes.xhtml?faces-redirect=true");
	}
	
	public String Remover (Filme FilmeB) {
		FilmeDAO.Remover(FilmeB);
		return("Filmes.xhtml?faces-redirect=true");
	}
	
	public String Detalhar() {
		int idFilme = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFilme"));
		FilmeB = FilmeDAO.Buscar(idFilme);
		return("AlterarFilme.xhtml?faces-redirect=true");
	}
	
	public String DetalharResenha() {
		int idFilme = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFilme"));
		FilmeB = FilmeDAO.Buscar(idFilme);
		return("CadastrarResenha.xhtml?faces-redirect=true");
	}
	
	
	public String Alterar() {
		FilmeDAO.Alterar(FilmeB);
		FilmeB = new Filme();
		objetoB = new Objeto();
		resenha = new Resenha();
		return("Filmes.xhtml?faces-redirect=true");
	}
	
}
