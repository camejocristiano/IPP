package br.net.ipp.models.financeiros;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Demonstrativo extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	//DADOS GERAIS 
	private String varDemonstrativo;
	//Jovem (codigo, nome, idade)
	private String nomeDoJovem;
	private String codigoDoJovem;
	private String idadeDoJovem;
	
	//Contrato (dataDeInicio)
	private String dataDaContratacao;
	
	//Parametro (base, seguroDeVida_PCMSO)
	private String base;
	private String seguroDeVida_PCMSO;
	private String mesReferente;
	
	private String vt;
	private String vr;
	
	//FREQUENCIAS
	/*private String faltasCurso;
	private String faltasEmpresa;*/
	private String faltas;
	private String diasTrabalhados;
	private String valorBruto;
	
	//DESCONTOS
	private String iNSS_20_porCento;
	private String fGTS_2_porCento;
	private String pIS_1_porCento;
	private String acidenteDeTrabalho_2_porCento;
	private String sistemaS_3_ponto_5_porCento;
	private String salarioEducacao_1_porCento;
	private String planoDeSaude;
	private String planoOdonto;
	private String taxaExtraAdicional_18_porCento_s_min;
	
	//Empresa(PAP)
	private String valorDaParceiriaEmpresa;
	
	//RESULTADOS
	private String totalLiquedo;
	private String diaDoCurso;
	private String terminoDoContrato;
	
	
	public String getVarDemonstrativo() {
		return varDemonstrativo;
	}
	public void setVarDemonstrativo(String varDemonstrativo) {
		this.varDemonstrativo = varDemonstrativo;
	}
	public String getNomeDoJovem() {
		return nomeDoJovem;
	}
	public void setNomeDoJovem(String nomeDoJovem) {
		this.nomeDoJovem = nomeDoJovem;
	}
	public String getCodigoDoJovem() {
		return codigoDoJovem;
	}
	public void setCodigoDoJovem(String codigoDoJovem) {
		this.codigoDoJovem = codigoDoJovem;
	}
	public String getIdadeDoJovem() {
		return idadeDoJovem;
	}
	public void setIdadeDoJovem(String idadeDoJovem) {
		this.idadeDoJovem = idadeDoJovem;
	}
	public String getDataDaContratacao() {
		return dataDaContratacao;
	}
	public void setDataDaContratacao(String dataDaContratacao) {
		this.dataDaContratacao = dataDaContratacao;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getSeguroDeVida_PCMSO() {
		return seguroDeVida_PCMSO;
	}
	public void setSeguroDeVida_PCMSO(String seguroDeVida_PCMSO) {
		this.seguroDeVida_PCMSO = seguroDeVida_PCMSO;
	}
	public String getMesReferente() {
		return mesReferente;
	}
	public void setMesReferente(String mesReferente) {
		this.mesReferente = mesReferente;
	}
	public String getVt() {
		return vt;
	}
	public void setVt(String vt) {
		this.vt = vt;
	}
	public String getVr() {
		return vr;
	}
	public void setVr(String vr) {
		this.vr = vr;
	}
	public String getFaltas() {
		return faltas;
	}
	public void setFaltas(String faltas) {
		this.faltas = faltas;
	}
	/*public String getFaltasCurso() {
		return faltasCurso;
	}
	public void setFaltasCurso(String faltasCurso) {
		this.faltasCurso = faltasCurso;
	}
	public String getFaltasEmpresa() {
		return faltasEmpresa;
	}
	public void setFaltasEmpresa(String faltasEmpresa) {
		this.faltasEmpresa = faltasEmpresa;
	}*/
	public String getDiasTrabalhados() {
		return diasTrabalhados;
	}
	public void setDiasTrabalhados(String diasTrabalhados) {
		this.diasTrabalhados = diasTrabalhados;
	}
	public String getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(String valorBruto) {
		this.valorBruto = valorBruto;
	}
	public String getiNSS_20_porCento() {
		return iNSS_20_porCento;
	}
	public void setiNSS_20_porCento(String iNSS_20_porCento) {
		this.iNSS_20_porCento = iNSS_20_porCento;
	}
	public String getfGTS_2_porCento() {
		return fGTS_2_porCento;
	}
	public void setfGTS_2_porCento(String fGTS_2_porCento) {
		this.fGTS_2_porCento = fGTS_2_porCento;
	}
	public String getpIS_1_porCento() {
		return pIS_1_porCento;
	}
	public void setpIS_1_porCento(String pIS_1_porCento) {
		this.pIS_1_porCento = pIS_1_porCento;
	}
	public String getAcidenteDeTrabalho_2_porCento() {
		return acidenteDeTrabalho_2_porCento;
	}
	public void setAcidenteDeTrabalho_2_porCento(String acidenteDeTrabalho_2_porCento) {
		this.acidenteDeTrabalho_2_porCento = acidenteDeTrabalho_2_porCento;
	}
	public String getSistemaS_3_ponto_5_porCento() {
		return sistemaS_3_ponto_5_porCento;
	}
	public void setSistemaS_3_ponto_5_porCento(String sistemaS_3_ponto_5_porCento) {
		this.sistemaS_3_ponto_5_porCento = sistemaS_3_ponto_5_porCento;
	}
	public String getSalarioEducacao_1_porCento() {
		return salarioEducacao_1_porCento;
	}
	public void setSalarioEducacao_1_porCento(String salarioEducacao_1_porCento) {
		this.salarioEducacao_1_porCento = salarioEducacao_1_porCento;
	}
	public String getPlanoDeSaude() {
		return planoDeSaude;
	}
	public void setPlanoDeSaude(String planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}
	public String getPlanoOdonto() {
		return planoOdonto;
	}
	public void setPlanoOdonto(String planoOdonto) {
		this.planoOdonto = planoOdonto;
	}
	public String getTaxaExtraAdicional_18_porCento_s_min() {
		return taxaExtraAdicional_18_porCento_s_min;
	}
	public void setTaxaExtraAdicional_18_porCento_s_min(String taxaExtraAdicional_18_porCento_s_min) {
		this.taxaExtraAdicional_18_porCento_s_min = taxaExtraAdicional_18_porCento_s_min;
	}
	public String getValorDaParceiriaEmpresa() {
		return valorDaParceiriaEmpresa;
	}
	public void setValorDaParceiriaEmpresa(String valorDaParceiriaEmpresa) {
		this.valorDaParceiriaEmpresa = valorDaParceiriaEmpresa;
	}
	public String getTotalLiquedo() {
		return totalLiquedo;
	}
	public void setTotalLiquedo(String totalLiquedo) {
		this.totalLiquedo = totalLiquedo;
	}
	public String getDiaDoCurso() {
		return diaDoCurso;
	}
	public void setDiaDoCurso(String diaDoCurso) {
		this.diaDoCurso = diaDoCurso;
	}
	public String getTerminoDoContrato() {
		return terminoDoContrato;
	}
	public void setTerminoDoContrato(String terminoDoContrato) {
		this.terminoDoContrato = terminoDoContrato;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
