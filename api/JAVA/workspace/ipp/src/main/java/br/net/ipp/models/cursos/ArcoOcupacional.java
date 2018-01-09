package br.net.ipp.models.cursos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.net.ipp.models.AbstractEntity;

@Entity
public class ArcoOcupacional  extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "arco_cbo", joinColumns = @JoinColumn(name = "arco_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "cbo_id", referencedColumnName = "id"))
	private List<CBO> listaDeCBOs;
	private String titulo;
	public Curso curso;

	public List<CBO> getListaDeCBOs() {
		return listaDeCBOs;
	}
	public void setListaDeCBOs(List<CBO> listaDeCBOs) {
		this.listaDeCBOs = listaDeCBOs;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}