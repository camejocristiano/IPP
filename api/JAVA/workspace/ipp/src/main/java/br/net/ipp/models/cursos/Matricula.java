package br.net.ipp.models.cursos;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.net.ipp.enums.StatusDaMatricula;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.aprendizes.Jovem;

@Entity
@Table(name="matricula")
public class Matricula extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private StatusDaMatricula statusDaMaticula;
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
	public StatusDaMatricula getStatusDaMaticula() {
		return statusDaMaticula;
	}
	public void setStatusDaMaticula(StatusDaMatricula statusDaMaticula) {
		this.statusDaMaticula = statusDaMaticula;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
}