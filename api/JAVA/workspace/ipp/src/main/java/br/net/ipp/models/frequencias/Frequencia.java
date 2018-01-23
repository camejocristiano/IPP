package br.net.ipp.models.frequencias;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.FrequenciaEnum;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.cursos.Matricula;

@Entity
public class Frequencia extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Matricula matricula;
	private FrequenciaEnum frequenciaManha;
	private FrequenciaEnum frequenciaTarde;
	private Integer dia;
	private Integer mes;
	private Integer ano;

	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	public FrequenciaEnum getFrequenciaManha() {
		return frequenciaManha;
	}
	public void setFrequenciaManha(FrequenciaEnum frequenciaManha) {
		this.frequenciaManha = frequenciaManha;
	}
	public FrequenciaEnum getFrequenciaTarde() {
		return frequenciaTarde;
	}
	public void setFrequenciaTarde(FrequenciaEnum frequenciaTarde) {
		this.frequenciaTarde = frequenciaTarde;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
