package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class FichaSocial extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String casoRepetiuQualAno;
	/*private String comoFoiAAdaptacaoAoMeioEscolar;
	private String comoSeRelacionaComOsColegas;
	private double despesaAgua;
	private double despesaAlimentacao;
	private double despesaAluguelPrestacaoCasaApartamento;
	private double despesaCondominio;
	private String despesaDescricaoDosImpostos;
	private double despesaImpostos;
	private double despesaLuz;
	private double despesaTelefone;
	private double despesaTransporte;
	private String dinamicaFamiliar;
	private Boolean jaRepetiuDeAno;
	private String observacoesFamiliares;
	private String parecerConclusivo;
	private String primeiraInternacaoMotivo;
	private int quantidadeDeBanheiros;
	private int quantidadeDeComodos;
	private String queTipoDeLaserMaisGosta;
	private double receitaDaFamilia;
	private String seEntidadeSocialQualONome;
	private String segundaInternacaoMotivo;
	private SituacaoDaMoradia situacaoDaMoradia;
	private Boolean temDificuldadesEmAlgumaMateria;
	private String terceiraInternacaoMotivo;
	private TipoDaMoradia tipoDeMoradia;*/

	public String getCasoRepetiuQualAno() {
		return casoRepetiuQualAno;
	}
	public void setCasoRepetiuQualAno(String casoRepetiuQualAno) {
		this.casoRepetiuQualAno = casoRepetiuQualAno;
	}
	/*public String getComoFoiAAdaptacaoAoMeioEscolar() {
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
	public double getDespesaAgua() {
		return despesaAgua;
	}
	public void setDespesaAgua(double despesaAgua) {
		this.despesaAgua = despesaAgua;
	}
	public double getDespesaAlimentacao() {
		return despesaAlimentacao;
	}
	public void setDespesaAlimentacao(double despesaAlimentacao) {
		this.despesaAlimentacao = despesaAlimentacao;
	}
	public double getDespesaAluguelPrestacaoCasaApartamento() {
		return despesaAluguelPrestacaoCasaApartamento;
	}
	public void setDespesaAluguelPrestacaoCasaApartamento(double despesaAluguelPrestacaoCasaApartamento) {
		this.despesaAluguelPrestacaoCasaApartamento = despesaAluguelPrestacaoCasaApartamento;
	}
	public double getDespesaCondominio() {
		return despesaCondominio;
	}
	public void setDespesaCondominio(double despesaCondominio) {
		this.despesaCondominio = despesaCondominio;
	}
	public String getDespesaDescricaoDosImpostos() {
		return despesaDescricaoDosImpostos;
	}
	public void setDespesaDescricaoDosImpostos(String despesaDescricaoDosImpostos) {
		this.despesaDescricaoDosImpostos = despesaDescricaoDosImpostos;
	}
	public double getDespesaImpostos() {
		return despesaImpostos;
	}
	public void setDespesaImpostos(double despesaImpostos) {
		this.despesaImpostos = despesaImpostos;
	}
	public double getDespesaLuz() {
		return despesaLuz;
	}
	public void setDespesaLuz(double despesaLuz) {
		this.despesaLuz = despesaLuz;
	}
	public double getDespesaTelefone() {
		return despesaTelefone;
	}
	public void setDespesaTelefone(double despesaTelefone) {
		this.despesaTelefone = despesaTelefone;
	}
	public double getDespesaTransporte() {
		return despesaTransporte;
	}
	public void setDespesaTransporte(double despesaTransporte) {
		this.despesaTransporte = despesaTransporte;
	}
	public String getDinamicaFamiliar() {
		return dinamicaFamiliar;
	}
	public void setDinamicaFamiliar(String dinamicaFamiliar) {
		this.dinamicaFamiliar = dinamicaFamiliar;
	}
	public Boolean getJaRepetiuDeAno() {
		return jaRepetiuDeAno;
	}
	public void setJaRepetiuDeAno(Boolean jaRepetiuDeAno) {
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
	public int getQuantidadeDeBanheiros() {
		return quantidadeDeBanheiros;
	}
	public void setQuantidadeDeBanheiros(int quantidadeDeBanheiros) {
		this.quantidadeDeBanheiros = quantidadeDeBanheiros;
	}
	public int getQuantidadeDeComodos() {
		return quantidadeDeComodos;
	}
	public void setQuantidadeDeComodos(int quantidadeDeComodos) {
		this.quantidadeDeComodos = quantidadeDeComodos;
	}
	public String getQueTipoDeLaserMaisGosta() {
		return queTipoDeLaserMaisGosta;
	}
	public void setQueTipoDeLaserMaisGosta(String queTipoDeLaserMaisGosta) {
		this.queTipoDeLaserMaisGosta = queTipoDeLaserMaisGosta;
	}
	public double getReceitaDaFamilia() {
		return receitaDaFamilia;
	}
	public void setReceitaDaFamilia(double receitaDaFamilia) {
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
	public Boolean getTemDificuldadesEmAlgumaMateria() {
		return temDificuldadesEmAlgumaMateria;
	}
	public void setTemDificuldadesEmAlgumaMateria(Boolean temDificuldadesEmAlgumaMateria) {
		this.temDificuldadesEmAlgumaMateria = temDificuldadesEmAlgumaMateria;
	}
	public String getTerceiraInternacaoMotivo() {
		return terceiraInternacaoMotivo;
	}
	public void setTerceiraInternacaoMotivo(String terceiraInternacaoMotivo) {
		this.terceiraInternacaoMotivo = terceiraInternacaoMotivo;
	}
	public TipoDaMoradia getTipoDeMoradia() {
		return tipoDeMoradia;
	}
	public void setTipoDeMoradia(TipoDaMoradia tipoDeMoradia) {
		this.tipoDeMoradia = tipoDeMoradia;
	}*/

}