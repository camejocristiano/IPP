package br.net.ipp.models.frequencias;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.DiaDaSemana;
import br.net.ipp.enums.TipoDeInsercao;
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
	/*private TurnoEnum turno;*/
	private TipoDeInsercao tipoDeInsercao;
	private DiaDaSemana diaDaSemana;
	private boolean comparecido;
	private boolean justificativa;
	private String observacao;

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
		this.mes = mes;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public TipoDeInsercao getTipoDeInsercao() {
		return tipoDeInsercao;
	}
	public void setTipoDeInsercao(TipoDeInsercao tipoDeInsercao) {
		this.tipoDeInsercao = tipoDeInsercao;
	}
	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	/*public TurnoEnum getTurno() {
		return turno;
	}
	public void setTurno(TurnoEnum turno) {
		this.turno = turno;
	}*/
	public boolean isComparecido() {
		return comparecido;
	}
	public void setComparecido(boolean comparecido) {
		this.comparecido = comparecido;
	}
	public boolean isJustificativa() {
		return justificativa;
	}
	public void setJustificativa(boolean justificativa) {
		this.justificativa = justificativa;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
