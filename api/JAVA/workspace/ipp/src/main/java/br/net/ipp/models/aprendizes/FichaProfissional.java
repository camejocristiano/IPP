package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class FichaProfissional extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String observacoesSituacaoProfissional;
	/*@OneToMany
	private List<Contratacao> contratacoes;
	@OneToMany
	private List<Entrevista> entrevistas;
	private SituacaoAtual situacaoAtual;
	private Status status;
	public Entrevista m_Entrevista;
	public Contratacao m_Contratacao;*/

	public String getObservacoesSituacaoProfissional() {
		return observacoesSituacaoProfissional;
	}
	public void setObservacoesSituacaoProfissional(String observacoesSituacaoProfissional) {
		this.observacoesSituacaoProfissional = observacoesSituacaoProfissional;
	}
	
	/*	public List<Contratacao> getContratacoes() {
		return contratacoes;
	}
	public void setContratacoes(List<Contratacao> contratacoes) {
		this.contratacoes = contratacoes;
	}
	public List<Entrevista> getEntrevistas() {
		return entrevistas;
	}
	public void setEntrevistas(List<Entrevista> entrevistas) {
		this.entrevistas = entrevistas;
	}
	public SituacaoAtual getSituacaoAtual() {
		return situacaoAtual;
	}
	public void setSituacaoAtual(SituacaoAtual situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Entrevista getM_Entrevista() {
		return m_Entrevista;
	}
	public void setM_Entrevista(Entrevista m_Entrevista) {
		this.m_Entrevista = m_Entrevista;
	}
	public Contratacao getM_Contratacao() {
		return m_Contratacao;
	}
	public void setM_Contratacao(Contratacao m_Contratacao) {
		this.m_Contratacao = m_Contratacao;
	}*/

}