package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.TipoDeOcorrencia;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.configuracoes.Usuario;

@Entity
public class Ocorrencia extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String descricao;	
	private String titulo;
	private String data;
	private TipoDeOcorrencia tipo;
	@ManyToOne
	private Usuario responsavel;
	@ManyToOne
	private Historico historico;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public TipoDeOcorrencia getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeOcorrencia tipo) {
		this.tipo = tipo;
	}
	public Usuario getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	public Historico getHistorico() {
		return historico;
	}
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}