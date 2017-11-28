package br.net.ipp.jpa.model.configuracoes;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.jpa.model.AbstractEntity;

@Entity
public class Agendamento extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Calendar data;
	private String descricao;
	private Calendar hora;
	private String tempoPrevisto;
	@ManyToOne
	private Usuario usuario;

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
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