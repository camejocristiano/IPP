package br.net.ipp.models.empresas;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Empresa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String razaoSocial;
	
	/*	private Boolean assistenciaMedica;
	private Boolean assistenciaOdontologica;
	private Boolean autorizaDivulgacaoDaEmpresaNoSiteDoIpp;
	private String bairro;
	private Boolean beneficiosAdministradosPor;
	private String cargaHorariaSemanal;
	private String cEP;
	private String cidade;
	private String cNPJ;
	private String complemento;
	private Date dataDeCadastro;
	private Date dataDeVencimentoDaFatura;
	private String endereco;
	private String estado;
	private String fax;
	private Usuario monitor;
	private String nomeFantazia;
	private Boolean outros;
	private double porcentagemSobreATaxaExtraBaseSMF;
	private double porcentagemSobreOSMF;
	private Regiao regiao;
	private String site;
	private Boolean taxaDeAdministracaoDeBeneficiosConvenioDeSaude;
	private Boolean taxaDeAdministracaoDeBeneficiosVR;
	private double taxaExtra18DoSMF;
	private String telefone;
	private String tipoDeEmpresa;
	private TipoDeParceria tipoDeParceria;
	private Unidade unidade;
	private Boolean valeAlimentacao;
	private Boolean valeRefeicao;
	private double valorPorcentagemSobreATaxaExtraBaseSMF;
	private double valorPorcentagemSobreOSMF;
	private Usuario vendedor;
	private Boolean vinculoComOIPP;
	private Boolean vRCurso;
	@OneToMany
	public List<Setor> setores;
	@OneToMany
	public List<Gestor> gestores;
	@OneToMany
	public List<Contato> contatos;
	@OneToMany
	public List<RepresentanteLegal> representantesLegais;*/

	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
/*	public Boolean getAssistenciaMedica() {
		return assistenciaMedica;
	}
	public void setAssistenciaMedica(Boolean assistenciaMedica) {
		this.assistenciaMedica = assistenciaMedica;
	}
	public Boolean getAssistenciaOdontologica() {
		return assistenciaOdontologica;
	}
	public void setAssistenciaOdontologica(Boolean assistenciaOdontologica) {
		this.assistenciaOdontologica = assistenciaOdontologica;
	}
	public Boolean getAutorizaDivulgacaoDaEmpresaNoSiteDoIpp() {
		return autorizaDivulgacaoDaEmpresaNoSiteDoIpp;
	}
	public void setAutorizaDivulgacaoDaEmpresaNoSiteDoIpp(Boolean autorizaDivulgacaoDaEmpresaNoSiteDoIpp) {
		this.autorizaDivulgacaoDaEmpresaNoSiteDoIpp = autorizaDivulgacaoDaEmpresaNoSiteDoIpp;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Boolean getBeneficiosAdministradosPor() {
		return beneficiosAdministradosPor;
	}
	public void setBeneficiosAdministradosPor(Boolean beneficiosAdministradosPor) {
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
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public Date getDataDeVencimentoDaFatura() {
		return dataDeVencimentoDaFatura;
	}
	public void setDataDeVencimentoDaFatura(Date dataDeVencimentoDaFatura) {
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
	public Boolean getOutros() {
		return outros;
	}
	public void setOutros(Boolean outros) {
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
	public Boolean getTaxaDeAdministracaoDeBeneficiosConvenioDeSaude() {
		return taxaDeAdministracaoDeBeneficiosConvenioDeSaude;
	}
	public void setTaxaDeAdministracaoDeBeneficiosConvenioDeSaude(Boolean taxaDeAdministracaoDeBeneficiosConvenioDeSaude) {
		this.taxaDeAdministracaoDeBeneficiosConvenioDeSaude = taxaDeAdministracaoDeBeneficiosConvenioDeSaude;
	}
	public Boolean getTaxaDeAdministracaoDeBeneficiosVR() {
		return taxaDeAdministracaoDeBeneficiosVR;
	}
	public void setTaxaDeAdministracaoDeBeneficiosVR(Boolean taxaDeAdministracaoDeBeneficiosVR) {
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
	public Boolean getValeAlimentacao() {
		return valeAlimentacao;
	}
	public void setValeAlimentacao(Boolean valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}
	public Boolean getValeRefeicao() {
		return valeRefeicao;
	}
	public void setValeRefeicao(Boolean valeRefeicao) {
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
	public Boolean getVinculoComOIPP() {
		return vinculoComOIPP;
	}
	public void setVinculoComOIPP(Boolean vinculoComOIPP) {
		this.vinculoComOIPP = vinculoComOIPP;
	}
	public Boolean getvRCurso() {
		return vRCurso;
	}
	public void setvRCurso(Boolean vRCurso) {
		this.vRCurso = vRCurso;
	}
	public List<Setor> getSetores() {
		return setores;
	}
	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}
	public List<Gestor> getGestores() {
		return gestores;
	}
	public void setGestores(List<Gestor> gestores) {
		this.gestores = gestores;
	}
	public List<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	public List<RepresentanteLegal> getRepresentantesLegais() {
		return representantesLegais;
	}
	public void setRepresentantesLegais(List<RepresentanteLegal> representantesLegais) {
		this.representantesLegais = representantesLegais;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	*/
	
}