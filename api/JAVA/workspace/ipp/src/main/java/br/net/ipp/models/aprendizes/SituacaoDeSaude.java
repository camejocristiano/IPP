package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.configuracoes.Usuario;

@Entity
public class SituacaoDeSaude  extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String alergiasContraIndicacoes;
	private boolean asma;
	private boolean cardiopatias;
	private String convenioMedicoFamiliar;
	private boolean convulcoes;
	@Column(name = "dataDaEntrevista")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDaEntrevista;
	private boolean desmaios;
	private boolean diabetes;
	private String emCasoDeEmergenciaGrauDeParentesco;
	private String emCasoDeEmergenciaNome;
	private String emCasoDeEmergenciaTelefones;
	private boolean enxaqueca;
	private boolean epilepsia;
	private boolean fornecidoPelaEmpresa;
	private String grauDeParentesco;
	private boolean hipoglicemia;
	private String medicamentosEmUso;
	private String nomeDoEntrevistado;
	private String outrasDoencas;
	private boolean possuiConvenioMedicoFamiliar;
	private String sePossuiQual;
	private String situacaoDeSaudeObservacoes;
	@ManyToOne
	private Usuario quemEntrevistou;
	@ManyToOne
	private Jovem jovem;
	
	public String getAlergiasContraIndicacoes() {
		return alergiasContraIndicacoes;
	}
	public void setAlergiasContraIndicacoes(String alergiasContraIndicacoes) {
		this.alergiasContraIndicacoes = alergiasContraIndicacoes;
	}
	public boolean isAsma() {
		return asma;
	}
	public void setAsma(boolean asma) {
		this.asma = asma;
	}
	public boolean isCardiopatias() {
		return cardiopatias;
	}
	public void setCardiopatias(boolean cardiopatias) {
		this.cardiopatias = cardiopatias;
	}
	public String getConvenioMedicoFamiliar() {
		return convenioMedicoFamiliar;
	}
	public void setConvenioMedicoFamiliar(String convenioMedicoFamiliar) {
		this.convenioMedicoFamiliar = convenioMedicoFamiliar;
	}
	public boolean isConvulcoes() {
		return convulcoes;
	}
	public void setConvulcoes(boolean convulcoes) {
		this.convulcoes = convulcoes;
	}
	public Date getDataDaEntrevista() {
		return dataDaEntrevista;
	}
	public void setDataDaEntrevista(Date dataDaEntrevista) {
		this.dataDaEntrevista = dataDaEntrevista;
	}
	public boolean isDesmaios() {
		return desmaios;
	}
	public void setDesmaios(boolean desmaios) {
		this.desmaios = desmaios;
	}
	public boolean isDiabetes() {
		return diabetes;
	}
	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}
	public String getEmCasoDeEmergenciaGrauDeParentesco() {
		return emCasoDeEmergenciaGrauDeParentesco;
	}
	public void setEmCasoDeEmergenciaGrauDeParentesco(String emCasoDeEmergenciaGrauDeParentesco) {
		this.emCasoDeEmergenciaGrauDeParentesco = emCasoDeEmergenciaGrauDeParentesco;
	}
	public String getEmCasoDeEmergenciaNome() {
		return emCasoDeEmergenciaNome;
	}
	public void setEmCasoDeEmergenciaNome(String emCasoDeEmergenciaNome) {
		this.emCasoDeEmergenciaNome = emCasoDeEmergenciaNome;
	}
	public String getEmCasoDeEmergenciaTelefones() {
		return emCasoDeEmergenciaTelefones;
	}
	public void setEmCasoDeEmergenciaTelefones(String emCasoDeEmergenciaTelefones) {
		this.emCasoDeEmergenciaTelefones = emCasoDeEmergenciaTelefones;
	}
	public boolean isEnxaqueca() {
		return enxaqueca;
	}
	public void setEnxaqueca(boolean enxaqueca) {
		this.enxaqueca = enxaqueca;
	}
	public boolean isEpilepsia() {
		return epilepsia;
	}
	public void setEpilepsia(boolean epilepsia) {
		this.epilepsia = epilepsia;
	}
	public boolean isFornecidoPelaEmpresa() {
		return fornecidoPelaEmpresa;
	}
	public void setFornecidoPelaEmpresa(boolean fornecidoPelaEmpresa) {
		this.fornecidoPelaEmpresa = fornecidoPelaEmpresa;
	}
	public String getGrauDeParentesco() {
		return grauDeParentesco;
	}
	public void setGrauDeParentesco(String grauDeParentesco) {
		this.grauDeParentesco = grauDeParentesco;
	}
	public boolean isHipoglicemia() {
		return hipoglicemia;
	}
	public void setHipoglicemia(boolean hipoglicemia) {
		this.hipoglicemia = hipoglicemia;
	}
	public String getMedicamentosEmUso() {
		return medicamentosEmUso;
	}
	public void setMedicamentosEmUso(String medicamentosEmUso) {
		this.medicamentosEmUso = medicamentosEmUso;
	}
	public String getNomeDoEntrevistado() {
		return nomeDoEntrevistado;
	}
	public void setNomeDoEntrevistado(String nomeDoEntrevistado) {
		this.nomeDoEntrevistado = nomeDoEntrevistado;
	}
	public String getOutrasDoencas() {
		return outrasDoencas;
	}
	public void setOutrasDoencas(String outrasDoencas) {
		this.outrasDoencas = outrasDoencas;
	}
	public boolean isPossuiConvenioMedicoFamiliar() {
		return possuiConvenioMedicoFamiliar;
	}
	public void setPossuiConvenioMedicoFamiliar(boolean possuiConvenioMedicoFamiliar) {
		this.possuiConvenioMedicoFamiliar = possuiConvenioMedicoFamiliar;
	}
	public String getSePossuiQual() {
		return sePossuiQual;
	}
	public void setSePossuiQual(String sePossuiQual) {
		this.sePossuiQual = sePossuiQual;
	}
	public String getSituacaoDeSaudeObservacoes() {
		return situacaoDeSaudeObservacoes;
	}
	public void setSituacaoDeSaudeObservacoes(String situacaoDeSaudeObservacoes) {
		this.situacaoDeSaudeObservacoes = situacaoDeSaudeObservacoes;
	}
	public Usuario getQuemEntrevistou() {
		return quemEntrevistou;
	}
	public void setQuemEntrevistou(Usuario quemEntrevistou) {
		this.quemEntrevistou = quemEntrevistou;
	}
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}