package br.net.ipp.models.aprendizes;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.AuxilioDoGoverno;
import br.net.ipp.enums.Escolaridade;
import br.net.ipp.models.AbstractEntity;

@Entity
public class CaracteristicasDomiciliares extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private AuxilioDoGoverno auxilioDoGoverno;
	private String cursoDaMaeOuResponsavel;
	private boolean eArrimoDeFamilia;
	private Escolaridade escolaridadeDaMaeOuResponsavel;
	private String membrosDaFamiliaNoMesmoDomicilio;
	private boolean moraComAMaeOuResponsavel;
	private String outros;
	private boolean recebeAuxilioDoGoverno;
	private BigDecimal rendaDomiciliar;
	private boolean jovemEOResponsavelPeloCartao;
	private boolean situacaoConcluido;
	private boolean temFilhos;
	private boolean moramComOJovem;
	@ManyToOne
	public Jovem jovem;
	
	
	public AuxilioDoGoverno getAuxilioDoGoverno() {
		return auxilioDoGoverno;
	}
	public void setAuxilioDoGoverno(AuxilioDoGoverno auxilioDoGoverno) {
		this.auxilioDoGoverno = auxilioDoGoverno;
	}
	public String getCursoDaMaeOuResponsavel() {
		return cursoDaMaeOuResponsavel;
	}
	public void setCursoDaMaeOuResponsavel(String cursoDaMaeOuResponsavel) {
		this.cursoDaMaeOuResponsavel = cursoDaMaeOuResponsavel;
	}
	public boolean iseArrimoDeFamilia() {
		return eArrimoDeFamilia;
	}
	public void seteArrimoDeFamilia(boolean eArrimoDeFamilia) {
		this.eArrimoDeFamilia = eArrimoDeFamilia;
	}
	public Escolaridade getEscolaridadeDaMaeOuResponsavel() {
		return escolaridadeDaMaeOuResponsavel;
	}
	public void setEscolaridadeDaMaeOuResponsavel(Escolaridade escolaridadeDaMaeOuResponsavel) {
		this.escolaridadeDaMaeOuResponsavel = escolaridadeDaMaeOuResponsavel;
	}
	public String getMembrosDaFamiliaNoMesmoDomicilio() {
		return membrosDaFamiliaNoMesmoDomicilio;
	}
	public void setMembrosDaFamiliaNoMesmoDomicilio(String membrosDaFamiliaNoMesmoDomicilio) {
		this.membrosDaFamiliaNoMesmoDomicilio = membrosDaFamiliaNoMesmoDomicilio;
	}
	public boolean isMoraComAMaeOuResponsavel() {
		return moraComAMaeOuResponsavel;
	}
	public void setMoraComAMaeOuResponsavel(boolean moraComAMaeOuResponsavel) {
		this.moraComAMaeOuResponsavel = moraComAMaeOuResponsavel;
	}
	public boolean isMoramComOJovem() {
		return moramComOJovem;
	}
	public void setMoramComOJovem(boolean moramComOJovem) {
		this.moramComOJovem = moramComOJovem;
	}
	public String getOutros() {
		return outros;
	}
	public void setOutros(String outros) {
		this.outros = outros;
	}
	public boolean isRecebeAuxilioDoGoverno() {
		return recebeAuxilioDoGoverno;
	}
	public void setRecebeAuxilioDoGoverno(boolean recebeAuxilioDoGoverno) {
		this.recebeAuxilioDoGoverno = recebeAuxilioDoGoverno;
	}
	public BigDecimal getRendaDomiciliar() {
		return rendaDomiciliar;
	}
	public void setRendaDomiciliar(BigDecimal rendaDomiciliar) {
		this.rendaDomiciliar = rendaDomiciliar;
	}
	public boolean isJovemEOResponsavelPeloCartao() {
		return jovemEOResponsavelPeloCartao;
	}
	public void setJovemEOResponsavelPeloCartao(boolean jovemEOResponsavelPeloCartao) {
		this.jovemEOResponsavelPeloCartao = jovemEOResponsavelPeloCartao;
	}
	public boolean isSituacaoConcluido() {
		return situacaoConcluido;
	}
	public void setSituacaoConcluido(boolean situacaoConcluido) {
		this.situacaoConcluido = situacaoConcluido;
	}
	public boolean isTemFilhos() {
		return temFilhos;
	}
	public void setTemFilhos(boolean temFilhos) {
		this.temFilhos = temFilhos;
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
