package br.net.ipp.jpa.model.empresas;

import java.util.Calendar;

import javax.persistence.Entity;

import br.net.ipp.jpa.model.AbstractEntity;
import br.net.ipp.jpa.model.configuracoes.Unidade;
import br.net.ipp.jpa.model.configuracoes.Usuario;
import br.net.ipp.jpa.model.enums.Regiao;
import br.net.ipp.jpa.model.enums.TipoDeParceria;

/**
 * @author Cristiano
 * @version 1.0
 * @created 27-nov-2017 20:40:22
 */
@Entity
public class Empresa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private boolean assistenciaMedica;
	private boolean assistenciaOdontologica;
	private boolean autorizaDivulgacaoDaEmpresaNoSiteDoIpp;
	private String bairro;
	private boolean beneficiosAdministradosPor;
	private String cargaHorariaSemanal;
	private String cEP;
	private String cidade;
	private String cNPJ;
	private String complemento;
	private Calendar dataDeCadastro;
	private Calendar dataDeVencimentoDaFatura;
	private String endereco;
	private String estado;
	private String fax;
	private Usuario monitor;
	private String nomeFantazia;
	private boolean outros;
	private double porcentagemSobreATaxaExtraBaseSMF;
	private double porcentagemSobreOSMF;
	private String razaoSocial;
	private Regiao regiao;
	private String site;
	private boolean taxaDeAdministracaoDeBeneficiosConvenioDeSaude;
	private boolean taxaDeAdministracaoDeBeneficiosVR;
	private double taxaExtra18DoSMF;
	private String telefone;
	private String tipoDeEmpresa;
	private TipoDeParceria tipoDeParceria;
	private Unidade unidade;
	private boolean valeAlimentacao;
	private boolean valeRefeicao;
	private double valorPorcentagemSobreATaxaExtraBaseSMF;
	private double valorPorcentagemSobreOSMF;
	private Usuario vendedor;
	private boolean vinculoComOIPP;
	private boolean vRCurso;
	public Setor setor;

	public boolean isAssistenciaMedica() {
		return assistenciaMedica;
	}

	public void setAssistenciaMedica(boolean assistenciaMedica) {
		this.assistenciaMedica = assistenciaMedica;
	}

	public boolean isAssistenciaOdontologica() {
		return assistenciaOdontologica;
	}

	public void setAssistenciaOdontologica(boolean assistenciaOdontologica) {
		this.assistenciaOdontologica = assistenciaOdontologica;
	}

	public boolean isAutorizaDivulgacaoDaEmpresaNoSiteDoIpp() {
		return autorizaDivulgacaoDaEmpresaNoSiteDoIpp;
	}

	public void setAutorizaDivulgacaoDaEmpresaNoSiteDoIpp(boolean autorizaDivulgacaoDaEmpresaNoSiteDoIpp) {
		this.autorizaDivulgacaoDaEmpresaNoSiteDoIpp = autorizaDivulgacaoDaEmpresaNoSiteDoIpp;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public boolean isBeneficiosAdministradosPor() {
		return beneficiosAdministradosPor;
	}

	public void setBeneficiosAdministradosPor(boolean beneficiosAdministradosPor) {
		this.beneficiosAdministradosPor = beneficiosAdministradosPor;
	}

	public String getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}

	public void setCargaHorariaSemanal(String cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
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

	public Calendar getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Calendar dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public Calendar getDataDeVencimentoDaFatura() {
		return dataDeVencimentoDaFatura;
	}

	public void setDataDeVencimentoDaFatura(Calendar dataDeVencimentoDaFatura) {
		this.dataDeVencimentoDaFatura = dataDeVencimentoDaFatura;
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

	public Usuario getMonitor() {
		return monitor;
	}

	public void setMonitor(Usuario monitor) {
		this.monitor = monitor;
	}

	public String getNomeFantazia() {
		return nomeFantazia;
	}

	public void setNomeFantazia(String nomeFantazia) {
		this.nomeFantazia = nomeFantazia;
	}

	public boolean isOutros() {
		return outros;
	}

	public void setOutros(boolean outros) {
		this.outros = outros;
	}

	public double getPorcentagemSobreATaxaExtraBaseSMF() {
		return porcentagemSobreATaxaExtraBaseSMF;
	}

	public void setPorcentagemSobreATaxaExtraBaseSMF(double porcentagemSobreATaxaExtraBaseSMF) {
		this.porcentagemSobreATaxaExtraBaseSMF = porcentagemSobreATaxaExtraBaseSMF;
	}

	public double getPorcentagemSobreOSMF() {
		return porcentagemSobreOSMF;
	}

	public void setPorcentagemSobreOSMF(double porcentagemSobreOSMF) {
		this.porcentagemSobreOSMF = porcentagemSobreOSMF;
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

	public boolean isTaxaDeAdministracaoDeBeneficiosConvenioDeSaude() {
		return taxaDeAdministracaoDeBeneficiosConvenioDeSaude;
	}

	public void setTaxaDeAdministracaoDeBeneficiosConvenioDeSaude(
			boolean taxaDeAdministracaoDeBeneficiosConvenioDeSaude) {
		this.taxaDeAdministracaoDeBeneficiosConvenioDeSaude = taxaDeAdministracaoDeBeneficiosConvenioDeSaude;
	}

	public boolean isTaxaDeAdministracaoDeBeneficiosVR() {
		return taxaDeAdministracaoDeBeneficiosVR;
	}

	public void setTaxaDeAdministracaoDeBeneficiosVR(boolean taxaDeAdministracaoDeBeneficiosVR) {
		this.taxaDeAdministracaoDeBeneficiosVR = taxaDeAdministracaoDeBeneficiosVR;
	}

	public double getTaxaExtra18DoSMF() {
		return taxaExtra18DoSMF;
	}

	public void setTaxaExtra18DoSMF(double taxaExtra18DoSMF) {
		this.taxaExtra18DoSMF = taxaExtra18DoSMF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoDeEmpresa() {
		return tipoDeEmpresa;
	}

	public void setTipoDeEmpresa(String tipoDeEmpresa) {
		this.tipoDeEmpresa = tipoDeEmpresa;
	}

	public TipoDeParceria getTipoDeParceria() {
		return tipoDeParceria;
	}

	public void setTipoDeParceria(TipoDeParceria tipoDeParceria) {
		this.tipoDeParceria = tipoDeParceria;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public boolean isValeAlimentacao() {
		return valeAlimentacao;
	}

	public void setValeAlimentacao(boolean valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}

	public boolean isValeRefeicao() {
		return valeRefeicao;
	}

	public void setValeRefeicao(boolean valeRefeicao) {
		this.valeRefeicao = valeRefeicao;
	}

	public double getValorPorcentagemSobreATaxaExtraBaseSMF() {
		return valorPorcentagemSobreATaxaExtraBaseSMF;
	}

	public void setValorPorcentagemSobreATaxaExtraBaseSMF(double valorPorcentagemSobreATaxaExtraBaseSMF) {
		this.valorPorcentagemSobreATaxaExtraBaseSMF = valorPorcentagemSobreATaxaExtraBaseSMF;
	}

	public double getValorPorcentagemSobreOSMF() {
		return valorPorcentagemSobreOSMF;
	}

	public void setValorPorcentagemSobreOSMF(double valorPorcentagemSobreOSMF) {
		this.valorPorcentagemSobreOSMF = valorPorcentagemSobreOSMF;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public boolean isVinculoComOIPP() {
		return vinculoComOIPP;
	}

	public void setVinculoComOIPP(boolean vinculoComOIPP) {
		this.vinculoComOIPP = vinculoComOIPP;
	}

	public boolean isvRCurso() {
		return vRCurso;
	}

	public void setvRCurso(boolean vRCurso) {
		this.vRCurso = vRCurso;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}
