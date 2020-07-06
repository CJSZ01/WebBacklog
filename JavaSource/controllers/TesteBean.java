package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import dao.TesteDao;
import model.Teste;

@Named
@SessionScoped
public class TesteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7355200089487055964L;

	public TesteBean() {
		
		listaTeste = TesteDao.Listar();
		teste1 = new Teste();
	}
	
	private Teste teste1;
	
	public Teste getTeste1() {
		return teste1;
	}

	public void setTeste1(Teste teste1) {
		this.teste1 = teste1;
	}
		
	
		
	private List<Teste> listaTeste;

	public List<Teste> getListaTeste() {
		listaTeste = TesteDao.Listar();
		return listaTeste;
	}

	public void setListaTeste(List<Teste> listaTeste) {
		this.listaTeste = listaTeste;
	}
	
	
	
	public String cadastrar() {
		TesteDao.Cadastrar(teste1);
		teste1 = new Teste();
		return("Index.xhtml?faces-redirect=true");
	}
	public String remover(Teste teste) {
		TesteDao.Remover(teste);
		return("Owo.xhtml?faces-redirect=true");
	}
	public String detalhar() {
		int idTeste = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTeste"));
		teste1 = TesteDao.Buscar(idTeste);
		return("Teste2.xhtml?faces-redirect=true");
	}
	public String alterar() {
		TesteDao.Alterar(teste1);
		teste1 = new Teste();
		return("Index.xhtml?faces-redirect=true");
	}
}
