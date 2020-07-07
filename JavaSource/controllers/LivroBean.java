package controllers;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.LivroDAO;
import dao.ObjetoDAO;
import model.Livro;
import model.Objeto;
import model.Resenha;

@Named
@SessionScoped
public class LivroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7355200055481055964L;

	public LivroBean() {
		listaLivros = LivroDAO.Listar();
		livroB = new Livro();
		objetoB = new Objeto();
		resenha = new Resenha();
	}
	
	private Objeto objetoB;
	
	private Livro livroB;
	
	private List<Livro> listaLivros;
	
	public Objeto getObjetoB() {
		return objetoB;
	}

	public void setObjetoB(Objeto objetoB) {
		this.objetoB = objetoB;
	}

	public Livro getLivroB() {
		return livroB;
	}

	public void setLivroB(Livro livroB) {
		this.livroB = livroB;
	}

	public List<Livro> getListaLivros() {
		listaLivros = LivroDAO.Listar();
		return listaLivros;
	}

	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public Resenha getResenha() {
		return resenha;
	}

	public void setResenha(Resenha resenha) {
		this.resenha = resenha;
	}

	private Resenha resenha;
	
	public String Cadastrar() {
		LivroDAO.Cadastrar(livroB);
		livroB = new Livro();
		return ("Livros.xhtml?faces-redirect=true");
	}
	
	public String Remover (Livro livroB) {
		LivroDAO.Remover(livroB);
		return("Livros.xhtml?faces-redirect=true");
	}
	
	public String Detalhar() {
		int idLivro = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idLivro"));
		livroB = LivroDAO.Buscar(idLivro);
		return("AlterarLivro.xhtml?faces-redirect=true");
	}
	
	public String DetalharResenha() {
		int idLivro = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idLivro"));
		objetoB = ObjetoDAO.Buscar(idLivro);
		System.out.println(objetoB.getTitulo() + "awawawawa");
		return("CadastrarResenha.xhtml?faces-redirect=true");
	}
	
	
	public String Alterar() {
		LivroDAO.Alterar(livroB);
		livroB = new Livro();
		objetoB = new Objeto();
		resenha = new Resenha();
		return("Livros.xhtml?faces-redirect=true");
	}
	
}
