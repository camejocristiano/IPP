package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Ocorrencia extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String descricao;	
/*	private Date data;
	private String ocorrencia;
	private Usuario responsavel;
	private TipoDeOcorrencia tipo;
	public Historico m_Historico;*/

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
/*	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	public Usuario getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	public TipoDeOcorrencia getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeOcorrencia tipo) {
		this.tipo = tipo;
	}
	public Historico getM_Historico() {
		return m_Historico;
	}
	public void setM_Historico(Historico m_Historico) {
		this.m_Historico = m_Historico;
	}*/

}