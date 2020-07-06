package controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.ResenhaDAO;
import model.Resenha;

@Named
@SessionScoped
public class ResenhaBean implements Serializable {

	private static final long serialVersionUID = 7355269089481055964L;
	
	public ResenhaBean() {
		listaResenhas = ResenhaDAO.Listar();
		resenhaB = new Resenha();
	}
	
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
		ResenhaDAO.Cadastrar(resenhaB);
		resenhaB = new Resenha();
		return ("Jogos.xhtml?faces-redirect=true");
	}
	

	
	public String Remover (Resenha resenhaB) {
		ResenhaDAO.Remover(resenhaB);
		return("Jogos.xhtml?faces-redirect=true");
	}
	
	public String Detalhar() {
		int idResenha = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idResenha"));
		resenhaB = ResenhaDAO.Buscar(idResenha);
		return("AlterarJogo.xhtml?faces-redirect=true");
	}
	public String Alterar() {
		ResenhaDAO.Alterar(resenhaB);
		resenhaB = new Resenha();
		return("Jogos.xhtml?faces-redirect=true");
	}
	
}
