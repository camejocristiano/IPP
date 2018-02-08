package br.net.ipp.models.configuracoes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Agendamento extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "data")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date data;
	private String descricao;
	private Date hora;
	private String tempoPrevisto;
	@ManyToOne
	private Usuario usuario;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getTempoPrevisto() {
		return tempoPrevisto;
	}

	public void setTempoPrevisto(String tempoPrevisto) {
		this.tempoPrevisto = tempoPrevisto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}