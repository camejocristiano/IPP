package br.net.ipp.models.cursos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import br.net.ipp.models.AbstractEntity;

@Entity
public class ConteudoTeoricoBasico  extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String horaAula;
	private String titulo;
	@ManyToMany(mappedBy = "conteudosTeoricosBasicos")
	private List<Curso> cursos;
	
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
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