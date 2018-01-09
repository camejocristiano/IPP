package br.net.ipp.models.cursos;

import java.util.Date;

import javax.persistence.Entity;

import br.net.ipp.enums.TipoDeValidacao;
import br.net.ipp.models.AbstractEntity;

@Entity
public class Validacao extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Date dataDaSolicitacao;
	private Date dataDaValidacao;
	private Date dataDeEnvio;
	private TipoDeValidacao tipoDeValidacao;
	public Curso curso;

	public Date getDataDaSolicitacao() {
		return dataDaSolicitacao;
	}
	public void setDataDaSolicitacao(Date dataDaSolicitacao) {
		this.dataDaSolicitacao = dataDaSolicitacao;
	}
	public Date getDataDaValidacao() {
		return dataDaValidacao;
	}
	public void setDataDaValidacao(Date dataDaValidacao) {
		this.dataDaValidacao = dataDaValidacao;
	}
	public Date getDataDeEnvio() {
		return dataDeEnvio;
	}
	public void setDataDeEnvio(Date dataDeEnvio) {
		this.dataDeEnvio = dataDeEnvio;
	}
	public TipoDeValidacao getTipoDeValidacao() {
		return tipoDeValidacao;
	}
	public void setTipoDeValidacao(TipoDeValidacao tipoDeValidacao) {
		this.tipoDeValidacao = tipoDeValidacao;
	}
	public Curso getM_Curso() {
		return curso;
	}
	public void setM_Curso(Curso curso) {
		this.curso = curso;
	}

}