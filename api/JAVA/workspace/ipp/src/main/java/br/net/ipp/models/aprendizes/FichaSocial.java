package br.net.ipp.models.aprendizes;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.net.ipp.enums.SituacaoDaMoradia;
import br.net.ipp.enums.TipoDeConstrucao;
import br.net.ipp.enums.TipoDeMoradia;
import br.net.ipp.models.AbstractEntity;

@Entity
public class FichaSocial extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String casoRepetiuQualAno;
	private String comoFoiAAdaptacaoAoMeioEscolar;
	private String comoSeRelacionaComOsColegas;
	private BigDecimal despesaAgua;
	private BigDecimal despesaAlimentacao;
	private BigDecimal despesaAluguelPrestacaoCasaApartamento;
	private BigDecimal despesaCondominio;
	private String despesaDescricaoDosImpostos;
	private BigDecimal despesaImpostos;
	private BigDecimal despesaLuz;
	private BigDecimal despesaTelefone;
	private BigDecimal despesaTransporte;
	private String dinamicaFamiliar;
	private boolean jaRepetiuDeAno;
	private String observacoesFamiliares;
	private String parecerConclusivo;
	private String primeiraInternacaoMotivo;
	private String segundaInternacaoMotivo;
	private String terceiraInternacaoMotivo;
	private String quantidadeDeBanheiros;
	private String quantidadeDeComodos;
	private String queTipoDeLaserMaisGosta;
	private BigDecimal receitaDaFamilia;
	private String seEntidadeSocialQualONome;
	private SituacaoDaMoradia situacaoDaMoradia;
	private boolean temDificuldadesEmAlgumaMateria;
	private String seTemDificuldadesQual;
	private TipoDeConstrucao tipoDeConstrucao;
	private TipoDeMoradia tipoDeMoradia;
	@OneToOne
	private Jovem jovem;

	
	public String getCasoRepetiuQualAno() {
		return casoRepetiuQualAno;
	}
	public void setCasoRepetiuQualAno(String casoRepetiuQualAno) {
		this.casoRepetiuQualAno = casoRepetiuQualAno;
	}
	public String getComoFoiAAdaptacaoAoMeioEscolar() {
		return comoFoiAAdaptacaoAoMeioEscolar;
	}
	public void setComoFoiAAdaptacaoAoMeioEscolar(String comoFoiAAdaptacaoAoMeioEscolar) {
		this.comoFoiAAdaptacaoAoMeioEscolar = comoFoiAAdaptacaoAoMeioEscolar;
	}
	public String getComoSeRelacionaComOsColegas() {
		return comoSeRelacionaComOsColegas;
	}
	public void setComoSeRelacionaComOsColegas(String comoSeRelacionaComOsColegas) {
		this.comoSeRelacionaComOsColegas = comoSeRelacionaComOsColegas;
	}
	public BigDecimal getDespesaAgua() {
		return despesaAgua;
	}
	public void setDespesaAgua(BigDecimal despesaAgua) {
		this.despesaAgua = despesaAgua;
	}
	public BigDecimal getDespesaAlimentacao() {
		return despesaAlimentacao;
	}
	public void setDespesaAlimentacao(BigDecimal despesaAlimentacao) {
		this.despesaAlimentacao = despesaAlimentacao;
	}
	public BigDecimal getDespesaAluguelPrestacaoCasaApartamento() {
		return despesaAluguelPrestacaoCasaApartamento;
	}
	public void setDespesaAluguelPrestacaoCasaApartamento(BigDecimal despesaAluguelPrestacaoCasaApartamento) {
		this.despesaAluguelPrestacaoCasaApartamento = despesaAluguelPrestacaoCasaApartamento;
	}
	public BigDecimal getDespesaCondominio() {
		return despesaCondominio;
	}
	public void setDespesaCondominio(BigDecimal despesaCondominio) {
		this.despesaCondominio = despesaCondominio;
	}
	public String getDespesaDescricaoDosImpostos() {
		return despesaDescricaoDosImpostos;
	}
	public void setDespesaDescricaoDosImpostos(String despesaDescricaoDosImpostos) {
		this.despesaDescricaoDosImpostos = despesaDescricaoDosImpostos;
	}
	public BigDecimal getDespesaImpostos() {
		return despesaImpostos;
	}
	public void setDespesaImpostos(BigDecimal despesaImpostos) {
		this.despesaImpostos = despesaImpostos;
	}
	public BigDecimal getDespesaLuz() {
		return despesaLuz;
	}
	public void setDespesaLuz(BigDecimal despesaLuz) {
		this.despesaLuz = despesaLuz;
	}
	public BigDecimal getDespesaTelefone() {
		return despesaTelefone;
	}
	public void setDespesaTelefone(BigDecimal despesaTelefone) {
		this.despesaTelefone = despesaTelefone;
	}
	public BigDecimal getDespesaTransporte() {
		return despesaTransporte;
	}
	public void setDespesaTransporte(BigDecimal despesaTransporte) {
		this.despesaTransporte = despesaTransporte;
	}
	public String getDinamicaFamiliar() {
		return dinamicaFamiliar;
	}
	public void setDinamicaFamiliar(String dinamicaFamiliar) {
		this.dinamicaFamiliar = dinamicaFamiliar;
	}
	public boolean isJaRepetiuDeAno() {
		return jaRepetiuDeAno;
	}
	public void setJaRepetiuDeAno(boolean jaRepetiuDeAno) {
		this.jaRepetiuDeAno = jaRepetiuDeAno;
	}
	public String getObservacoesFamiliares() {
		return observacoesFamiliares;
	}
	public void setObservacoesFamiliares(String observacoesFamiliares) {
		this.observacoesFamiliares = observacoesFamiliares;
	}
	public String getParecerConclusivo() {
		return parecerConclusivo;
	}
	public void setParecerConclusivo(String parecerConclusivo) {
		this.parecerConclusivo = parecerConclusivo;
	}
	public String getPrimeiraInternacaoMotivo() {
		return primeiraInternacaoMotivo;
	}
	public void setPrimeiraInternacaoMotivo(String primeiraInternacaoMotivo) {
		this.primeiraInternacaoMotivo = primeiraInternacaoMotivo;
	}
	public String getQuantidadeDeBanheiros() {
		return quantidadeDeBanheiros;
	}
	public void setQuantidadeDeBanheiros(String quantidadeDeBanheiros) {
		this.quantidadeDeBanheiros = quantidadeDeBanheiros;
	}
	public String getQuantidadeDeComodos() {
		return quantidadeDeComodos;
	}
	public void setQuantidadeDeComodos(String quantidadeDeComodos) {
		this.quantidadeDeComodos = quantidadeDeComodos;
	}
	public String getQueTipoDeLaserMaisGosta() {
		return queTipoDeLaserMaisGosta;
	}
	public void setQueTipoDeLaserMaisGosta(String queTipoDeLaserMaisGosta) {
		this.queTipoDeLaserMaisGosta = queTipoDeLaserMaisGosta;
	}
	public BigDecimal getReceitaDaFamilia() {
		return receitaDaFamilia;
	}
	public void setReceitaDaFamilia(BigDecimal receitaDaFamilia) {
		this.receitaDaFamilia = receitaDaFamilia;
	}
	public String getSeEntidadeSocialQualONome() {
		return seEntidadeSocialQualONome;
	}
	public void setSeEntidadeSocialQualONome(String seEntidadeSocialQualONome) {
		this.seEntidadeSocialQualONome = seEntidadeSocialQualONome;
	}
	public String getSegundaInternacaoMotivo() {
		return segundaInternacaoMotivo;
	}
	public void setSegundaInternacaoMotivo(String segundaInternacaoMotivo) {
		this.segundaInternacaoMotivo = segundaInternacaoMotivo;
	}
	public SituacaoDaMoradia getSituacaoDaMoradia() {
		return situacaoDaMoradia;
	}
	public void setSituacaoDaMoradia(SituacaoDaMoradia situacaoDaMoradia) {
		this.situacaoDaMoradia = situacaoDaMoradia;
	}
	public boolean isTemDificuldadesEmAlgumaMateria() {
		return temDificuldadesEmAlgumaMateria;
	}
	public void setTemDificuldadesEmAlgumaMateria(boolean temDificuldadesEmAlgumaMateria) {
		this.temDificuldadesEmAlgumaMateria = temDificuldadesEmAlgumaMateria;
	}
	public String getSeTemDificuldadesQual() {
		return seTemDificuldadesQual;
	}
	public void setSeTemDificuldadesQual(String seTemDificuldadesQual) {
		this.seTemDificuldadesQual = seTemDificuldadesQual;
	}
	public TipoDeConstrucao getTipoDeConstrucao() {
		return tipoDeConstrucao;
	}
	public void setTipoDeConstrucao(TipoDeConstrucao tipoDeConstrucao) {
		this.tipoDeConstrucao = tipoDeConstrucao;
	}
	public String getTerceiraInternacaoMotivo() {
		return terceiraInternacaoMotivo;
	}
	public void setTerceiraInternacaoMotivo(String terceiraInternacaoMotivo) {
		this.terceiraInternacaoMotivo = terceiraInternacaoMotivo;
	}
	public TipoDeMoradia getTipoDeMoradia() {
		return tipoDeMoradia;
	}
	public void setTipoDeMoradia(TipoDeMoradia tipoDeMoradia) {
		this.tipoDeMoradia = tipoDeMoradia;
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