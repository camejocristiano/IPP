package br.net.ipp.models.financeiros;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.enums.Regiao;
import br.net.ipp.enums.TipoDeEmpresa;
import br.net.ipp.enums.TipoDeParceria;
import br.net.ipp.models.AbstractEntity;

@Entity
public class ContaAPagar extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String bairro;
	private String bancoNumero;
	private String cEP;
	private String cidade;
	private String cNPJ;
	private String complemento;
	@Column(name = "dataDeCadastro")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDeCadastro;
	private String endereco;
	private String estado;
	private String fax;
	private String nomeFantazia;
	private String razaoSocial;
	private Regiao regiao;
	private String site;
	private String telefone;
	private TipoDeParceria tipoDeParceria;
	private TipoDeEmpresa tipoDeEmpresa;
	
	
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
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	public TipoDeEmpresa getTipoDeEmpresa() {
		return tipoDeEmpresa;
	}
	public void setTipoDeEmpresa(TipoDeEmpresa tipoDeEmpresa) {
		this.tipoDeEmpresa = tipoDeEmpresa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
