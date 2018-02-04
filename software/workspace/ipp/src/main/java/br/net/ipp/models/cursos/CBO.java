package br.net.ipp.models.cursos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import br.net.ipp.models.AbstractEntity;

@Entity
public class CBO  extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private String numero;
	private String titulo;
	@ManyToMany(mappedBy = "cbos")
	private List<ArcoOcupacional> arcos;

	
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
	public List<ArcoOcupacional> getArcosOcupacionais() {
		return arcos;
	}
	public void setArcosOcupacionais(List<ArcoOcupacional> arcos) {
		this.arcos = arcos;
	}

}