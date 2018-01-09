package br.net.ipp.models.frequencias;

import java.util.Date;

import javax.persistence.Entity;

import br.net.ipp.enums.Frequencia;
import br.net.ipp.enums.MesEnum;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Turma;

@Entity
public class AulaExtra extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Jovem jovem;
	private Curso curso;
	private Date data;
	private MesEnum mes;
	
	private String semana;
	private Frequencia semanaManha;
	private Frequencia semanaTarde;
	private Turma turma;
	
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public MesEnum getMes() {
		return mes;
	}
	public void setMes(MesEnum mes) {
		this.mes = mes;
	}
	public String getSemana() {
		return semana;
	}
	public void setSemana(String semana) {
		this.semana = semana;
	}
	public Frequencia getSemanaManha() {
		return semanaManha;
	}
	public void setSemanaManha(Frequencia semanaManha) {
		this.semanaManha = semanaManha;
	}
	public Frequencia getSemanaTarde() {
		return semanaTarde;
	}
	public void setSemanaTarde(Frequencia semanaTarde) {
		this.semanaTarde = semanaTarde;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}