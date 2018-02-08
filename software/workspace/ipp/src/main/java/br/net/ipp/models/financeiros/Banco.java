package br.net.ipp.models.financeiros;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.enums.Regiao;
import br.net.ipp.enums.TipoDeParceria;
import br.net.ipp.models.AbstractEntity;

@Entity
public class Banco extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String agenciaNumero;
	private String bairro;
	private String bancoNumero;
	private String cEP;
	private String cidade;
	private String cNPJ;
	private String complemento;
	private String contaNumero;
	@Column(name = "dataDeCadastro")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDeCadastro;
	private String enderecoDaAgencia;
	private String estado;
	private String fax;
	private String nomeFantazia;
	private String razaoSocial;
	private Regiao regiao;
	private String site;
	private String telefone;
	private TipoDeParceria tipoDeParceria;
	
	
	public String getAgenciaNumero() {
		return agenciaNumero;
	}
	public void setAgenciaNumero(String agenciaNumero) {
		this.agenciaNumero = agenciaNumero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getBancoNumero() {
		return bancoNumero;
	}
	public void setBancoNumero(String bancoNumero) {
		this.bancoNumero = bancoNumero;
	}
	public String getcEP() {
		return cEP;
	}
	public void setcEP(String cEP) {
		this.cEP = cEP;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getcNPJ() {
		return cNPJ;
	}
	public void setcNPJ(String cNPJ) {
		this.cNPJ = cNPJ;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getContaNumero() {
		return contaNumero;
	}
	public void setContaNumero(String contaNumero) {
		this.contaNumero = contaNumero;
	}
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public String getEnderecoDaAgencia() {
		return enderecoDaAgencia;
	}
	public void setEnderecoDaAgencia(String enderecoDaAgencia) {
		this.enderecoDaAgencia = enderecoDaAgencia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getNomeFantazia() {
		return nomeFantazia;
	}
	public void setNomeFantazia(String nomeFantazia) {
		this.nomeFantazia = nomeFantazia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public TipoDeParceria getTipoDeParceria() {
		return tipoDeParceria;
	}
	public void setTipoDeParceria(TipoDeParceria tipoDeParceria) {
		this.tipoDeParceria = tipoDeParceria;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
