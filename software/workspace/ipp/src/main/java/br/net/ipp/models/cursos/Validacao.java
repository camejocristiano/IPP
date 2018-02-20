package br.net.ipp.models.cursos;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.StatusValidacao;
import br.net.ipp.enums.TipoDeValidacao;
import br.net.ipp.models.AbstractEntity;

@Entity
public class Validacao extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String dataDaSolicitacao;
	private String dataDaValidacao;
	private String dataDeEnvio;
	private TipoDeValidacao tipoDeValidacao;
	private StatusValidacao statusValidacao;
	@ManyToOne
	private Curso curso;

	public String getDataDaSolicitacao() {
		return dataDaSolicitacao;
	}
	public void setDataDaSolicitacao(String dataDaSolicitacao) {
		this.dataDaSolicitacao = dataDaSolicitacao;
	}
	public String getDataDaValidacao() {
		return dataDaValidacao;
	}
	public void setDataDaValidacao(String dataDaValidacao) {
		this.dataDaValidacao = dataDaValidacao;
	}
	public String getDataDeEnvio() {
		return dataDeEnvio;
	}
	public void setDataDeEnvio(String dataDeEnvio) {
		this.dataDeEnvio = dataDeEnvio;
	}
	public TipoDeValidacao getTipoDeValidacao() {
		return tipoDeValidacao;
	}
	public void setTipoDeValidacao(TipoDeValidacao tipoDeValidacao) {
		this.tipoDeValidacao = tipoDeValidacao;
	}
	public StatusValidacao getStatusValidacao() {
		return statusValidacao;
	}
	public void setStatusValidacao(StatusValidacao statusValidacao) {
		this.statusValidacao = statusValidacao;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}