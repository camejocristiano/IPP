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

	private String titulo;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cbo_arco", 
      joinColumns = @JoinColumn(name = "arco_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "cbo_id", 
      referencedColumnName = "id"))
	private List<CBO> cbos;

	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<CBO> getCbos() {
		return cbos;
	}
	public void setCbos(List<CBO> cbos) {
		this.cbos = cbos;
	}
	
}