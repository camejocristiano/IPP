package br.com.contatos.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Evento extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private String nome;
    private String local;
    private Date datahorainicio;
    private Date datahoratermino;
    private String status;
    private String anotacoes;
    
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Date getDatahorainicio() {
		return datahorainicio;
	}
	public void setDatahorainicio(Date datahorainicio) {
		this.datahorainicio = datahorainicio;
	}
	public Date getDatahoratermino() {
		return datahoratermino;
	}
	public void setDatahoratermino(Date datahoratermino) {
		this.datahoratermino = datahoratermino;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAnotacoes() {
		return anotacoes;
	}
	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}
    
}
