package br.net.ipp.models.empresas;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Setor extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
/*	@OneToOne
	private Gestor gestor;
	@ManyToOne
	private Empresa empresa;*/
	

/*	public Gestor getGestor() {
		return gestor;
	}
	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
/*	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}*/
	
}