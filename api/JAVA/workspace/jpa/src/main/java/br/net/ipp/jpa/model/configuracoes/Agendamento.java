package br.net.ipp.jpa.model.configuracoes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.jpa.model.AbstractEntity;

@Entity
public class Agendamento extends AbstractEntity {

	private static final long serialVersionUID = 1L;

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