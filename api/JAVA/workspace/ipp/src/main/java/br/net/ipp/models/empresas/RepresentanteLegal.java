package br.net.ipp.models.empresas;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class RepresentanteLegal extends AbstractEntity {

	private static final long serialVersionUID = 1L;

    private String nome;
  /*	private String cargo;
	private String cPF;
	private String email;
	private String rG;
	private String telefone;
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
	public String getcPF() {
		return cPF;
	}
	public void setcPF(String cPF) {
		this.cPF = cPF;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getrG() {
		return rG;
	}
	public void setrG(String rG) {
		this.rG = rG;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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