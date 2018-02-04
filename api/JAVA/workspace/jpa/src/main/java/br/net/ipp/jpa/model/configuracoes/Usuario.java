package br.net.ipp.jpa.model.configuracoes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

import br.net.ipp.jpa.model.User;
import br.net.ipp.jpa.model.enums.EstadoCivil;
import br.net.ipp.jpa.model.enums.Regiao;
import br.net.ipp.jpa.model.enums.RelacaoFuncional;
import br.net.ipp.jpa.model.enums.Sexo;
import br.net.ipp.jpa.model.enums.Status;

@Entity
public class Usuario extends User {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String nome;
	private String telefone;
	private String celular;
	private Sexo sexo;
	private Status status;

	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cEP;
	private Regiao regiao;

	private String numeroCTPS;
	private String serieCTPS;
	private String orgaoEmissor;
	private String uFCTPS;
	private Date dataExpedicaoCTPS;

	private Date dataDeNascimento;
	private EstadoCivil estadoCivil;
	private String formacao;

	private String habilitacao;
	private String dataDeExpedicao;

	private String cNPJMEI;
	private int cPF;
	private String rG;

	private String curriculoResumido;
	private Date dataDeAdmissao;
	private Date DataDeDesligamento;
	private String disciplina;
	private String cargo;
	private RelacaoFuncional relacaoFuncional;

	@ManyToOne
	private GrupoDePermissoes grupoDePermissoes;
	private String observacoes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getcEP() {
		return cEP;
	}

	public void setcEP(String cEP) {
		this.cEP = cEP;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public String getNumeroCTPS() {
		return numeroCTPS;
	}

	public void setNumeroCTPS(String numeroCTPS) {
		this.numeroCTPS = numeroCTPS;
	}

	public String getSerieCTPS() {
		return serieCTPS;
	}

	public void setSerieCTPS(String serieCTPS) {
		this.serieCTPS = serieCTPS;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public String getuFCTPS() {
		return uFCTPS;
	}

	public void setuFCTPS(String uFCTPS) {
		this.uFCTPS = uFCTPS;
	}

	public Date getDataExpedicaoCTPS() {
		return dataExpedicaoCTPS;
	}

	public void setDataExpedicaoCTPS(Date dataExpedicaoCTPS) {
		this.dataExpedicaoCTPS = dataExpedicaoCTPS;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}

	public String getDataDeExpedicao() {
		return dataDeExpedicao;
	}

	public void setDataDeExpedicao(String dataDeExpedicao) {
		this.dataDeExpedicao = dataDeExpedicao;
	}

	public String getcNPJMEI() {
		return cNPJMEI;
	}

	public void setcNPJMEI(String cNPJMEI) {
		this.cNPJMEI = cNPJMEI;
	}

	public int getcPF() {
		return cPF;
	}

	public void setcPF(int cPF) {
		this.cPF = cPF;
	}

	public String getrG() {
		return rG;
	}

	public void setrG(String rG) {
		this.rG = rG;
	}

	public String getCurriculoResumido() {
		return curriculoResumido;
	}

	public void setCurriculoResumido(String curriculoResumido) {
		this.curriculoResumido = curriculoResumido;
	}

	public Date getDataDeAdmissao() {
		return dataDeAdmissao;
	}

	public void setDataDeAdmissao(Date dataDeAdmissao) {
		this.dataDeAdmissao = dataDeAdmissao;
	}

	public Date getDataDeDesligamento() {
		return DataDeDesligamento;
	}

	public void setDataDeDesligamento(Date dataDeDesligamento) {
		DataDeDesligamento = dataDeDesligamento;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public RelacaoFuncional getRelacaoFuncional() {
		return relacaoFuncional;
	}

	public void setRelacaoFuncional(RelacaoFuncional relacaoFuncional) {
		this.relacaoFuncional = relacaoFuncional;
	}

	public GrupoDePermissoes getGrupoDePermissoes() {
		return grupoDePermissoes;
	}

	public void setGrupoDePermissoes(GrupoDePermissoes grupoDePermissoes) {
		this.grupoDePermissoes = grupoDePermissoes;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
