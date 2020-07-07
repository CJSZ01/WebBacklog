package controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import dao.ObjetoDAO;
import model.Objeto;

@Named
@SessionScoped
public class ObjetoBean implements Serializable {

	public ObjetoBean() {
		listaObjetos = ObjetoDAO.Listar();
	}
	
	private List<Objeto> listaObjetos;

	public List<Objeto> getListaObjetos() {
		return listaObjetos;
	}

	public void setListaObjetos(List<Objeto> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}
}
