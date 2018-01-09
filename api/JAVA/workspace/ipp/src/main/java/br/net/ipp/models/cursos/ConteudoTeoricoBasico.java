package br.net.ipp.models.cursos;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class ConteudoTeoricoBasico  extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String horaAula;
	private String titulo;
	
	public String getHoraAula() {
		return horaAula;
	}
	public void setHoraAula(String horaAula) {
		this.horaAula = horaAula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}