package br.net.ipp.models.cursos;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.StatusDaMatricula;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.aprendizes.Jovem;

@Entity
public class Matricula extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private StatusDaMatricula statusDaMatricula;
	@ManyToOne
	private Jovem jovem;
	@ManyToOne
	public Turma turma;
	
	
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public StatusDaMatricula getStatusDaMatricula() {
		return statusDaMatricula;
	}
	public void setStatusDaMatricula(StatusDaMatricula statusDaMatricula) {
		this.statusDaMatricula = statusDaMatricula;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}