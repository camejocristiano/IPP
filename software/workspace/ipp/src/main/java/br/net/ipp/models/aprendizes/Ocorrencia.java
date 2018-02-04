package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.enums.TipoDeOcorrencia;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.configuracoes.Usuario;

@Entity
public class Ocorrencia extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String descricao;	
	private String titulo;
	@Column(name = "data")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date data;
	private TipoDeOcorrencia tipo;
	@ManyToOne
	private Usuario responsavel;
	@ManyToOne
	private Jovem jovem;
	
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
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
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}