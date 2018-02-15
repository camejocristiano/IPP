package br.net.ipp.models.frequencias;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.TurnoEnum;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.cursos.Matricula;

@Entity
public class Frequencia extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Matricula matricula;
	private Integer dia;
	private Integer mes;
	private Integer ano;
	private TurnoEnum turno;
	private boolean frequencia;

	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes + 1;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public TurnoEnum getTurno() {
		return turno;
	}
	public void setTurno(TurnoEnum turno) {
		this.turno = turno;
	}
	public boolean isFrequencia() {
		return frequencia;
	}
	public void setFrequencia(boolean frequencia) {
		this.frequencia = frequencia;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
