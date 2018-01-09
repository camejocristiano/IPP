package br.net.ipp.models.empresas;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Gestor extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	/*	private String email;
	private Boolean permitirQueVisualizaeTodosOsJovens;
	private String ramal;
	private String senha;
	private String telefone;
	@OneToOne
	private Contratacao contratacao;
	@ManyToOne
	private Empresa empresa;
	@OneToOne
	private Setor setor;*/

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

/*	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getPermitirQueVisualizaeTodosOsJovens() {
		return permitirQueVisualizaeTodosOsJovens;
	}
	public void setPermitirQueVisualizaeTodosOsJovens(Boolean permitirQueVisualizaeTodosOsJovens) {
		this.permitirQueVisualizaeTodosOsJovens = permitirQueVisualizaeTodosOsJovens;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Contratacao getContratacao() {
		return contratacao;
	}
	public void setContratacao(Contratacao contratacao) {
		this.contratacao = contratacao;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}	*/
}