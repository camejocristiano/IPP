package br.net.ipp.models.empresas;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Contato extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	/*	private String cargo;
	private String departamento;
	private String email;
	private String observacoes;
	private String telefone;
	private String tipoDeContato;
	@ManyToOne
	private Empresa empresa;*/
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

/*	public String getCargo() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}