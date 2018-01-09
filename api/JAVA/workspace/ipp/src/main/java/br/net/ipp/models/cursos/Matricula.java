package br.net.ipp.models.cursos;

import javax.persistence.Entity;

import br.net.ipp.enums.StatusDaMatricula;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.aprendizes.Jovem;

@Entity
public class Matricula extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String nomeTest;
	private Jovem jovem;
	private StatusDaMatricula statusDaMaticula;
	private Turma Turma;
	public Curso curso;
	
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
	public Turma getTurma() {
		return Turma;
	}
	public void setTurma(Turma turma) {
		Turma = turma;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getNomeTest() {
		return nomeTest;
	}
	public void setNomeTest(String nomeTest) {
		this.nomeTest = nomeTest;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}