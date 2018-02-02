package br.net.ipp.models.empresas;

import javax.persistence.Entity;

import br.net.ipp.models.User;

@Entity
public class Contato extends User {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cargo;
	private String departamento;
	private String observacoes;
	private String telefone;
	private String tipoDeContato;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipoDeContato() {
		return tipoDeContato;
	}
	public void setTipoDeContato(String tipoDeContato) {
		this.tipoDeContato = tipoDeContato;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}