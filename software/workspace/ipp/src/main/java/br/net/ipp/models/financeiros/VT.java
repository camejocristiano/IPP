package br.net.ipp.models.financeiros;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class VT extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String varVT;
	private String cod;	
	private String aprendiz;	
	private String empresa;	
	private String mesReferente;	
	private String pap;

	private String unico; 	 
	private String unicoIdaEVolta; 	 
	private String unicoParaJovem; 	 
	private String unicoParaSPTans;
	
	private String bom; 	 
	private String bomIdaEVolta; 	 
	private String bomParaJovem; 	 
	private String bomParaCMT; 
	
	private String bEM; 	 
	private String bEMIdaEVolta; 	 
	private String bEMParaJovem; 	
	
	private String segunda;	
	private String terca;
	private String quarta;	
	private String quinta;
	private String sexta;	
	private String sab;
	
	private String diasMes;	
	private String faltasCurso;	
	private String faltasEmpresa; 
	private String faltasEmpresaInjustificada;	
	private String faltasEmpresaJustificada;
	private String diasAPagar;	 
	private String totalAluno; 	 
	private String totalConcessionaria; 	
	private String observacao;	

	private String valorIPP;
	private String valorEmpresa;
	private String dataInicioContrato;
	private String dataFimContrato;

	
	public String getVarVT() {
		return varVT;
	}
	public void setVarVT(String varVT) {
		this.varVT = varVT;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getAprendiz() {
		return aprendiz;
	}
	public void setAprendiz(String aprendiz) {
		this.aprendiz = aprendiz;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getMesReferente() {
		return mesReferente;
	}
	public void setMesReferente(String mesReferente) {
		this.mesReferente = mesReferente;
	}
	public String getPap() {
		return pap;
	}
	public void setPap(String pap) {
		this.pap = pap;
	}
	public String getUnico() {
		return unico;
	}
	public void setUnico(String unico) {
		this.unico = unico;
	}
	public String getUnicoIdaEVolta() {
		return unicoIdaEVolta;
	}
	public void setUnicoIdaEVolta(String unicoIdaEVolta) {
		this.unicoIdaEVolta = unicoIdaEVolta;
	}
	public String getUnicoParaJovem() {
		return unicoParaJovem;
	}
	public void setUnicoParaJovem(String unicoParaJovem) {
		this.unicoParaJovem = unicoParaJovem;
	}
	public String getUnicoParaSPTans() {
		return unicoParaSPTans;
	}
	public void setUnicoParaSPTans(String unicoParaSPTans) {
		this.unicoParaSPTans = unicoParaSPTans;
	}
	public String getBom() {
		return bom;
	}
	public void setBom(String bom) {
		this.bom = bom;
	}
	public String getBomIdaEVolta() {
		return bomIdaEVolta;
	}
	public void setBomIdaEVolta(String bomIdaEVolta) {
		this.bomIdaEVolta = bomIdaEVolta;
	}
	public String getBomParaJovem() {
		return bomParaJovem;
	}
	public void setBomParaJovem(String bomParaJovem) {
		this.bomParaJovem = bomParaJovem;
	}
	public String getBomParaCMT() {
		return bomParaCMT;
	}
	public void setBomParaCMT(String bomParaCMT) {
		this.bomParaCMT = bomParaCMT;
	}
	public String getbEM() {
		return bEM;
	}
	public void setbEM(String bEM) {
		this.bEM = bEM;
	}
	public String getbEMIdaEVolta() {
		return bEMIdaEVolta;
	}
	public void setbEMIdaEVolta(String bEMIdaEVolta) {
		this.bEMIdaEVolta = bEMIdaEVolta;
	}
	public String getbEMParaJovem() {
		return bEMParaJovem;
	}
	public void setbEMParaJovem(String bEMParaJovem) {
		this.bEMParaJovem = bEMParaJovem;
	}
	public String getSegunda() {
		return segunda;
	}
	public void setSegunda(String segunda) {
		this.segunda = segunda;
	}
	public String getTerca() {
		return terca;
	}
	public void setTerca(String terca) {
		this.terca = terca;
	}
	public String getQuarta() {
		return quarta;
	}
	public void setQuarta(String quarta) {
		this.quarta = quarta;
	}
	public String getQuinta() {
		return quinta;
	}
	public void setQuinta(String quinta) {
		this.quinta = quinta;
	}
	public String getSexta() {
		return sexta;
	}
	public void setSexta(String sexta) {
		this.sexta = sexta;
	}
	public String getSab() {
		return sab;
	}
	public void setSab(String sab) {
		this.sab = sab;
	}
	public String getDiasMes() {
		return diasMes;
	}
	public void setDiasMes(String diasMes) {
		this.diasMes = diasMes;
	}
	public String getFaltasCurso() {
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
	}
	public String getFaltasEmpresaInjustificada() {
		return faltasEmpresaInjustificada;
	}
	public void setFaltasEmpresaInjustificada(String faltasEmpresaInjustificada) {
		this.faltasEmpresaInjustificada = faltasEmpresaInjustificada;
	}
	public String getFaltasEmpresaJustificada() {
		return faltasEmpresaJustificada;
	}
	public void setFaltasEmpresaJustificada(String faltasEmpresaJustificada) {
		this.faltasEmpresaJustificada = faltasEmpresaJustificada;
	}
	public String getDiasAPagar() {
		return diasAPagar;
	}
	public void setDiasAPagar(String diasAPagar) {
		this.diasAPagar = diasAPagar;
	}
	public String getTotalAluno() {
		return totalAluno;
	}
	public void setTotalAluno(String totalAluno) {
		this.totalAluno = totalAluno;
	}
	public String getTotalConcessionaria() {
		return totalConcessionaria;
	}
	public void setTotalConcessionaria(String totalConcessionaria) {
		this.totalConcessionaria = totalConcessionaria;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getValorIPP() {
		return valorIPP;
	}
	public void setValorIPP(String valorIPP) {
		this.valorIPP = valorIPP;
	}
	public String getValorEmpresa() {
		return valorEmpresa;
	}
	public void setValorEmpresa(String valorEmpresa) {
		this.valorEmpresa = valorEmpresa;
	}
	public String getDataInicioContrato() {
		return dataInicioContrato;
	}
	public void setDataInicioContrato(String dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}
	public String getDataFimContrato() {
		return dataFimContrato;
	}
	public void setDataFimContrato(String dataFimContrato) {
		this.dataFimContrato = dataFimContrato;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
