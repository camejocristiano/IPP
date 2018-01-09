package br.net.ipp.models.cursos;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class CBO  extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private String numero;
	private String titulo;
	public ArcoOcupacional arcoOcupacional;

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ArcoOcupacional getArcoOcupacional() {
		return arcoOcupacional;
	}
	public void setM_ArcoOcupacional(ArcoOcupacional arcoOcupacional) {
		this.arcoOcupacional = arcoOcupacional;
	}

}