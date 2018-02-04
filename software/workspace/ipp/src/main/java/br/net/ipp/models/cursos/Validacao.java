package br.net.ipp.models.cursos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.enums.StatusValidacao;
import br.net.ipp.enums.TipoDeValidacao;
import br.net.ipp.models.AbstractEntity;

@Entity
public class Validacao extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "dataDaSolicitacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDaSolicitacao;
	@Column(name = "dataDaValidacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDaValidacao;
	@Column(name = "dataDeEnvio")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDeEnvio;
	private TipoDeValidacao tipoDeValidacao;
	private StatusValidacao statusValidacao;
	@ManyToOne
	private Curso curso;

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