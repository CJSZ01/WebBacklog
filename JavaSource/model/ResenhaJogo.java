package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ResenhaJogo {

	@Id
	@GeneratedValue
	private int id;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Jogo jogo;

	private String titulo;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Jogo getJogo() {
		return jogo;
	}
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}


	private String texto;
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
