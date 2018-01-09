package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Historico extends AbstractEntity {

	private static final long serialVersionUID = 1L;

/*	private double avaliacoesPAPEmpresa_avaliador1avaliacao;
	private double avaliacoesPAPEmpresa_avaliador2avaliacao;
	private double avaliacoesPAPEmpresa_avaliador3avaliacao;
	private double avaliacoesPAPEmpresa_avaliador4avaliacao;
	private double avaliacoesPAPEmpresa_avaliador5avaliacao;
	private double avaliacoesPAPEmpresa_avaliador6avaliacao;
	private double avaliacoesPAPEmpresa_avaliador7avaliacao;
	private double avaliacoesPAPEmpresa_avaliador8avaliacao;
	private Date avaliacoesPAPEmpresa_data1avaliacao;
	private Date avaliacoesPAPEmpresa_data2avaliacao;
	private Date avaliacoesPAPEmpresa_data3avaliacao;
	private Date avaliacoesPAPEmpresa_data4avaliacao;
	private Date avaliacoesPAPEmpresa_data5avaliacao;
	private Date avaliacoesPAPEmpresa_data6avaliacao;
	private Date avaliacoesPAPEmpresa_data7avaliacao;
	private Date avaliacoesPAPEmpresa_data8avaliacao;
	private double avaliacoesPAPEmpresa_nota1avaliacao;
	private double avaliacoesPAPEmpresa_nota2avaliacao;
	private double avaliacoesPAPEmpresa_nota3avaliacao;
	private double avaliacoesPAPEmpresa_nota4avaliacao;
	private double avaliacoesPAPEmpresa_nota5avaliacao;
	private double avaliacoesPAPEmpresa_nota6avaliacao;
	private double avaliacoesPAPEmpresa_nota7avaliacao;
	private double avaliacoesPAPEmpresa_nota8avaliacao;
	private double avaliacoesPAPIPP_autoav1avaliacao;
	private double avaliacoesPAPIPP_autoav2avaliacao;
	private double avaliacoesPAPIPP_autoav3avaliacao;
	private double avaliacoesPAPIPP_autoav4avaliacao;
	private double avaliacoesPAPIPP_autoav5avaliacao;
	private double avaliacoesPAPIPP_autoav6avaliacao;
	private double avaliacoesPAPIPP_autoav7avaliacao;
	private double avaliacoesPAPIPP_autoav8avaliacao;
	private double avaliacoesPAPIPP_avConteudo1avaliacao;
	private double avaliacoesPAPIPP_avConteudo2avaliacao;
	private double avaliacoesPAPIPP_avConteudo3avaliacao;
	private double avaliacoesPAPIPP_avConteudo4avaliacao;
	private double avaliacoesPAPIPP_avConteudo5avaliacao;
	private double avaliacoesPAPIPP_avConteudo6avaliacao;
	private double avaliacoesPAPIPP_avConteudo7avaliacao;
	private double avaliacoesPAPIPP_avConteudo8avaliacao;
	private double avaliacoesPAPIPP_avOrient1avaliacao;
	private double avaliacoesPAPIPP_avOrient2avaliacao;
	private double avaliacoesPAPIPP_avOrient3avaliacao;
	private double avaliacoesPAPIPP_avOrient4avaliacao;
	private double avaliacoesPAPIPP_avOrient5avaliacao;
	private double avaliacoesPAPIPP_avOrient6avaliacao;
	private double avaliacoesPAPIPP_avOrient7avaliacao;
	private double avaliacoesPAPIPP_avOrient8avaliacao;
	private Date avaliacoesPAPIPP_data1avaliacao;
	private Date avaliacoesPAPIPP_data2avaliacao;
	private Date avaliacoesPAPIPP_data3avaliacao;
	private Date avaliacoesPAPIPP_data4avaliacao;
	private Date avaliacoesPAPIPP_data5avaliacao;
	private Date avaliacoesPAPIPP_data6avaliacao;
	private Date avaliacoesPAPIPP_data7avaliacao;
	private double avaliacoesPIO_autoav1avaliacao;
	private double avaliacoesPIO_autoav2avaliacao;
	private double avaliacoesPIO_autoav3avaliacao;
	private double avaliacoesPIO_autoav4avaliacao;
	private double avaliacoesPIO_autoav5avaliacao;
	private double avaliacoesPIO_autoav6avaliacao;
	private double avaliacoesPIO_autoav7avaliacao;
	private double avaliacoesPIO_autoav8avaliacao;
	private double avaliacoesPIO_avCont1avaliacao;
	private double avaliacoesPIO_avCont2avaliacao;
	private double avaliacoesPIO_avCont3avaliacao;
	private double avaliacoesPIO_avCont4avaliacao;
	private double avaliacoesPIO_avCont5avaliacao;
	private double avaliacoesPIO_avCont6avaliacao;
	private double avaliacoesPIO_avCont7avaliacao;
	private double avaliacoesPIO_avCont8avaliacao;
	private double avaliacoesPIO_avOrient1avaliacao;
	private Date avaliacoesPIO_avOrient2avaliacao;
	private Date avaliacoesPIO_avOrient3avaliacao;
	private Date avaliacoesPIO_avOrient4avaliacao;
	private Date avaliacoesPIO_avOrient5avaliacao;
	private Date avaliacoesPIO_avOrient6avaliacao;
	private Date avaliacoesPIO_avOrient7avaliacao;
	private Date avaliacoesPIO_avOrient8avaliacao;
	private Date avaliacoesPIO_data1avaliacao;
	private Date avaliacoesPIO_data2avaliacao;
	private Date avaliacoesPIO_data3avaliacao;
	private Date avaliacoesPIO_data4avaliacao;
	private Date avaliacoesPIO_data5avaliacao;
	private Date avaliacoesPIO_data6avaliacao;
	private Date avaliacoesPIO_data7avaliacao;
	private Date avaliacoesPIO_data8avaliacao;
	private Boolean avaliacoesPITEPIP_avaliacaoPIT;
	private Date avaliacoesPITEPIP_dataAutoAvaliacao;
	private Date avaliacoesPITEPIP_dataAvaliacaoInformatica;
	private Date avaliacoesPITEPIP_dataAvaliacaoMatematica;
	private Date avaliacoesPITEPIP_dataAvaliacaoOrientador;
	private Date avaliacoesPITEPIP_dataAvaliacaoPortugues;
	private Date avaliacoesPITEPIP_dataAvaliacaoVivencia;
	private double avaliacoesPITEPIP_notaAutoavaliacao;
	private double avaliacoesPITEPIP_notaAvaliacaoInformatica;
	private double avaliacoesPITEPIP_notaAvaliacaoMatematica;
	private double avaliacoesPITEPIP_notaAvaliacaoOrientador;
	private double avaliacoesPITEPIP_notaAvaliacaoPortugues;
	private double avaliacoesPITEPIP_notaAvaliacaoVivencia;*/
	private String observacoes;
	
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	/*@OneToMany
	private List<Ocorrencia> ocorrencias;
	
	public double getAvaliacoesPAPEmpresa_avaliador1avaliacao() {
		return avaliacoesPAPEmpresa_avaliador1avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador1avaliacao(double avaliacoesPAPEmpresa_avaliador1avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador1avaliacao = avaliacoesPAPEmpresa_avaliador1avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_avaliador2avaliacao() {
		return avaliacoesPAPEmpresa_avaliador2avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador2avaliacao(double avaliacoesPAPEmpresa_avaliador2avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador2avaliacao = avaliacoesPAPEmpresa_avaliador2avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_avaliador3avaliacao() {
		return avaliacoesPAPEmpresa_avaliador3avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador3avaliacao(double avaliacoesPAPEmpresa_avaliador3avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador3avaliacao = avaliacoesPAPEmpresa_avaliador3avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_avaliador4avaliacao() {
		return avaliacoesPAPEmpresa_avaliador4avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador4avaliacao(double avaliacoesPAPEmpresa_avaliador4avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador4avaliacao = avaliacoesPAPEmpresa_avaliador4avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_avaliador5avaliacao() {
		return avaliacoesPAPEmpresa_avaliador5avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador5avaliacao(double avaliacoesPAPEmpresa_avaliador5avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador5avaliacao = avaliacoesPAPEmpresa_avaliador5avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_avaliador6avaliacao() {
		return avaliacoesPAPEmpresa_avaliador6avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador6avaliacao(double avaliacoesPAPEmpresa_avaliador6avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador6avaliacao = avaliacoesPAPEmpresa_avaliador6avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_avaliador7avaliacao() {
		return avaliacoesPAPEmpresa_avaliador7avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador7avaliacao(double avaliacoesPAPEmpresa_avaliador7avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador7avaliacao = avaliacoesPAPEmpresa_avaliador7avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_avaliador8avaliacao() {
		return avaliacoesPAPEmpresa_avaliador8avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador8avaliacao(double avaliacoesPAPEmpresa_avaliador8avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador8avaliacao = avaliacoesPAPEmpresa_avaliador8avaliacao;
	}
	public Date getAvaliacoesPAPEmpresa_data1avaliacao() {
		return avaliacoesPAPEmpresa_data1avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_data1avaliacao(Date avaliacoesPAPEmpresa_data1avaliacao) {
		this.avaliacoesPAPEmpresa_data1avaliacao = avaliacoesPAPEmpresa_data1avaliacao;
	}
	public Date getAvaliacoesPAPEmpresa_data2avaliacao() {
		return avaliacoesPAPEmpresa_data2avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_data2avaliacao(Date avaliacoesPAPEmpresa_data2avaliacao) {
		this.avaliacoesPAPEmpresa_data2avaliacao = avaliacoesPAPEmpresa_data2avaliacao;
	}
	public Date getAvaliacoesPAPEmpresa_data3avaliacao() {
		return avaliacoesPAPEmpresa_data3avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_data3avaliacao(Date avaliacoesPAPEmpresa_data3avaliacao) {
		this.avaliacoesPAPEmpresa_data3avaliacao = avaliacoesPAPEmpresa_data3avaliacao;
	}
	public Date getAvaliacoesPAPEmpresa_data4avaliacao() {
		return avaliacoesPAPEmpresa_data4avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_data4avaliacao(Date avaliacoesPAPEmpresa_data4avaliacao) {
		this.avaliacoesPAPEmpresa_data4avaliacao = avaliacoesPAPEmpresa_data4avaliacao;
	}
	public Date getAvaliacoesPAPEmpresa_data5avaliacao() {
		return avaliacoesPAPEmpresa_data5avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_data5avaliacao(Date avaliacoesPAPEmpresa_data5avaliacao) {
		this.avaliacoesPAPEmpresa_data5avaliacao = avaliacoesPAPEmpresa_data5avaliacao;
	}
	public Date getAvaliacoesPAPEmpresa_data6avaliacao() {
		return avaliacoesPAPEmpresa_data6avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_data6avaliacao(Date avaliacoesPAPEmpresa_data6avaliacao) {
		this.avaliacoesPAPEmpresa_data6avaliacao = avaliacoesPAPEmpresa_data6avaliacao;
	}
	public Date getAvaliacoesPAPEmpresa_data7avaliacao() {
		return avaliacoesPAPEmpresa_data7avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_data7avaliacao(Date avaliacoesPAPEmpresa_data7avaliacao) {
		this.avaliacoesPAPEmpresa_data7avaliacao = avaliacoesPAPEmpresa_data7avaliacao;
	}
	public Date getAvaliacoesPAPEmpresa_data8avaliacao() {
		return avaliacoesPAPEmpresa_data8avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_data8avaliacao(Date avaliacoesPAPEmpresa_data8avaliacao) {
		this.avaliacoesPAPEmpresa_data8avaliacao = avaliacoesPAPEmpresa_data8avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_nota1avaliacao() {
		return avaliacoesPAPEmpresa_nota1avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_nota1avaliacao(double avaliacoesPAPEmpresa_nota1avaliacao) {
		this.avaliacoesPAPEmpresa_nota1avaliacao = avaliacoesPAPEmpresa_nota1avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_nota2avaliacao() {
		return avaliacoesPAPEmpresa_nota2avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_nota2avaliacao(double avaliacoesPAPEmpresa_nota2avaliacao) {
		this.avaliacoesPAPEmpresa_nota2avaliacao = avaliacoesPAPEmpresa_nota2avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_nota3avaliacao() {
		return avaliacoesPAPEmpresa_nota3avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_nota3avaliacao(double avaliacoesPAPEmpresa_nota3avaliacao) {
		this.avaliacoesPAPEmpresa_nota3avaliacao = avaliacoesPAPEmpresa_nota3avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_nota4avaliacao() {
		return avaliacoesPAPEmpresa_nota4avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_nota4avaliacao(double avaliacoesPAPEmpresa_nota4avaliacao) {
		this.avaliacoesPAPEmpresa_nota4avaliacao = avaliacoesPAPEmpresa_nota4avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_nota5avaliacao() {
		return avaliacoesPAPEmpresa_nota5avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_nota5avaliacao(double avaliacoesPAPEmpresa_nota5avaliacao) {
		this.avaliacoesPAPEmpresa_nota5avaliacao = avaliacoesPAPEmpresa_nota5avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_nota6avaliacao() {
		return avaliacoesPAPEmpresa_nota6avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_nota6avaliacao(double avaliacoesPAPEmpresa_nota6avaliacao) {
		this.avaliacoesPAPEmpresa_nota6avaliacao = avaliacoesPAPEmpresa_nota6avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_nota7avaliacao() {
		return avaliacoesPAPEmpresa_nota7avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_nota7avaliacao(double avaliacoesPAPEmpresa_nota7avaliacao) {
		this.avaliacoesPAPEmpresa_nota7avaliacao = avaliacoesPAPEmpresa_nota7avaliacao;
	}
	public double getAvaliacoesPAPEmpresa_nota8avaliacao() {
		return avaliacoesPAPEmpresa_nota8avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_nota8avaliacao(double avaliacoesPAPEmpresa_nota8avaliacao) {
		this.avaliacoesPAPEmpresa_nota8avaliacao = avaliacoesPAPEmpresa_nota8avaliacao;
	}
	public double getAvaliacoesPAPIPP_autoav1avaliacao() {
		return avaliacoesPAPIPP_autoav1avaliacao;
	}
	public void setAvaliacoesPAPIPP_autoav1avaliacao(double avaliacoesPAPIPP_autoav1avaliacao) {
		this.avaliacoesPAPIPP_autoav1avaliacao = avaliacoesPAPIPP_autoav1avaliacao;
	}
	public double getAvaliacoesPAPIPP_autoav2avaliacao() {
		return avaliacoesPAPIPP_autoav2avaliacao;
	}
	public void setAvaliacoesPAPIPP_autoav2avaliacao(double avaliacoesPAPIPP_autoav2avaliacao) {
		this.avaliacoesPAPIPP_autoav2avaliacao = avaliacoesPAPIPP_autoav2avaliacao;
	}
	public double getAvaliacoesPAPIPP_autoav3avaliacao() {
		return avaliacoesPAPIPP_autoav3avaliacao;
	}
	public void setAvaliacoesPAPIPP_autoav3avaliacao(double avaliacoesPAPIPP_autoav3avaliacao) {
		this.avaliacoesPAPIPP_autoav3avaliacao = avaliacoesPAPIPP_autoav3avaliacao;
	}
	public double getAvaliacoesPAPIPP_autoav4avaliacao() {
		return avaliacoesPAPIPP_autoav4avaliacao;
	}
	public void setAvaliacoesPAPIPP_autoav4avaliacao(double avaliacoesPAPIPP_autoav4avaliacao) {
		this.avaliacoesPAPIPP_autoav4avaliacao = avaliacoesPAPIPP_autoav4avaliacao;
	}
	public double getAvaliacoesPAPIPP_autoav5avaliacao() {
		return avaliacoesPAPIPP_autoav5avaliacao;
	}
	public void setAvaliacoesPAPIPP_autoav5avaliacao(double avaliacoesPAPIPP_autoav5avaliacao) {
		this.avaliacoesPAPIPP_autoav5avaliacao = avaliacoesPAPIPP_autoav5avaliacao;
	}
	public double getAvaliacoesPAPIPP_autoav6avaliacao() {
		return avaliacoesPAPIPP_autoav6avaliacao;
	}
	public void setAvaliacoesPAPIPP_autoav6avaliacao(double avaliacoesPAPIPP_autoav6avaliacao) {
		this.avaliacoesPAPIPP_autoav6avaliacao = avaliacoesPAPIPP_autoav6avaliacao;
	}
	public double getAvaliacoesPAPIPP_autoav7avaliacao() {
		return avaliacoesPAPIPP_autoav7avaliacao;
	}
	public void setAvaliacoesPAPIPP_autoav7avaliacao(double avaliacoesPAPIPP_autoav7avaliacao) {
		this.avaliacoesPAPIPP_autoav7avaliacao = avaliacoesPAPIPP_autoav7avaliacao;
	}
	public double getAvaliacoesPAPIPP_autoav8avaliacao() {
		return avaliacoesPAPIPP_autoav8avaliacao;
	}
	public void setAvaliacoesPAPIPP_autoav8avaliacao(double avaliacoesPAPIPP_autoav8avaliacao) {
		this.avaliacoesPAPIPP_autoav8avaliacao = avaliacoesPAPIPP_autoav8avaliacao;
	}
	public double getAvaliacoesPAPIPP_avConteudo1avaliacao() {
		return avaliacoesPAPIPP_avConteudo1avaliacao;
	}
	public void setAvaliacoesPAPIPP_avConteudo1avaliacao(double avaliacoesPAPIPP_avConteudo1avaliacao) {
		this.avaliacoesPAPIPP_avConteudo1avaliacao = avaliacoesPAPIPP_avConteudo1avaliacao;
	}
	public double getAvaliacoesPAPIPP_avConteudo2avaliacao() {
		return avaliacoesPAPIPP_avConteudo2avaliacao;
	}
	public void setAvaliacoesPAPIPP_avConteudo2avaliacao(double avaliacoesPAPIPP_avConteudo2avaliacao) {
		this.avaliacoesPAPIPP_avConteudo2avaliacao = avaliacoesPAPIPP_avConteudo2avaliacao;
	}
	public double getAvaliacoesPAPIPP_avConteudo3avaliacao() {
		return avaliacoesPAPIPP_avConteudo3avaliacao;
	}
	public void setAvaliacoesPAPIPP_avConteudo3avaliacao(double avaliacoesPAPIPP_avConteudo3avaliacao) {
		this.avaliacoesPAPIPP_avConteudo3avaliacao = avaliacoesPAPIPP_avConteudo3avaliacao;
	}
	public double getAvaliacoesPAPIPP_avConteudo4avaliacao() {
		return avaliacoesPAPIPP_avConteudo4avaliacao;
	}
	public void setAvaliacoesPAPIPP_avConteudo4avaliacao(double avaliacoesPAPIPP_avConteudo4avaliacao) {
		this.avaliacoesPAPIPP_avConteudo4avaliacao = avaliacoesPAPIPP_avConteudo4avaliacao;
	}
	public double getAvaliacoesPAPIPP_avConteudo5avaliacao() {
		return avaliacoesPAPIPP_avConteudo5avaliacao;
	}
	public void setAvaliacoesPAPIPP_avConteudo5avaliacao(double avaliacoesPAPIPP_avConteudo5avaliacao) {
		this.avaliacoesPAPIPP_avConteudo5avaliacao = avaliacoesPAPIPP_avConteudo5avaliacao;
	}
	public double getAvaliacoesPAPIPP_avConteudo6avaliacao() {
		return avaliacoesPAPIPP_avConteudo6avaliacao;
	}
	public void setAvaliacoesPAPIPP_avConteudo6avaliacao(double avaliacoesPAPIPP_avConteudo6avaliacao) {
		this.avaliacoesPAPIPP_avConteudo6avaliacao = avaliacoesPAPIPP_avConteudo6avaliacao;
	}
	public double getAvaliacoesPAPIPP_avConteudo7avaliacao() {
		return avaliacoesPAPIPP_avConteudo7avaliacao;
	}
	public void setAvaliacoesPAPIPP_avConteudo7avaliacao(double avaliacoesPAPIPP_avConteudo7avaliacao) {
		this.avaliacoesPAPIPP_avConteudo7avaliacao = avaliacoesPAPIPP_avConteudo7avaliacao;
	}
	public double getAvaliacoesPAPIPP_avConteudo8avaliacao() {
		return avaliacoesPAPIPP_avConteudo8avaliacao;
	}
	public void setAvaliacoesPAPIPP_avConteudo8avaliacao(double avaliacoesPAPIPP_avConteudo8avaliacao) {
		this.avaliacoesPAPIPP_avConteudo8avaliacao = avaliacoesPAPIPP_avConteudo8avaliacao;
	}
	public double getAvaliacoesPAPIPP_avOrient1avaliacao() {
		return avaliacoesPAPIPP_avOrient1avaliacao;
	}
	public void setAvaliacoesPAPIPP_avOrient1avaliacao(double avaliacoesPAPIPP_avOrient1avaliacao) {
		this.avaliacoesPAPIPP_avOrient1avaliacao = avaliacoesPAPIPP_avOrient1avaliacao;
	}
	public double getAvaliacoesPAPIPP_avOrient2avaliacao() {
		return avaliacoesPAPIPP_avOrient2avaliacao;
	}
	public void setAvaliacoesPAPIPP_avOrient2avaliacao(double avaliacoesPAPIPP_avOrient2avaliacao) {
		this.avaliacoesPAPIPP_avOrient2avaliacao = avaliacoesPAPIPP_avOrient2avaliacao;
	}
	public double getAvaliacoesPAPIPP_avOrient3avaliacao() {
		return avaliacoesPAPIPP_avOrient3avaliacao;
	}
	public void setAvaliacoesPAPIPP_avOrient3avaliacao(double avaliacoesPAPIPP_avOrient3avaliacao) {
		this.avaliacoesPAPIPP_avOrient3avaliacao = avaliacoesPAPIPP_avOrient3avaliacao;
	}
	public double getAvaliacoesPAPIPP_avOrient4avaliacao() {
		return avaliacoesPAPIPP_avOrient4avaliacao;
	}
	public void setAvaliacoesPAPIPP_avOrient4avaliacao(double avaliacoesPAPIPP_avOrient4avaliacao) {
		this.avaliacoesPAPIPP_avOrient4avaliacao = avaliacoesPAPIPP_avOrient4avaliacao;
	}
	public double getAvaliacoesPAPIPP_avOrient5avaliacao() {
		return avaliacoesPAPIPP_avOrient5avaliacao;
	}
	public void setAvaliacoesPAPIPP_avOrient5avaliacao(double avaliacoesPAPIPP_avOrient5avaliacao) {
		this.avaliacoesPAPIPP_avOrient5avaliacao = avaliacoesPAPIPP_avOrient5avaliacao;
	}
	public double getAvaliacoesPAPIPP_avOrient6avaliacao() {
		return avaliacoesPAPIPP_avOrient6avaliacao;
	}
	public void setAvaliacoesPAPIPP_avOrient6avaliacao(double avaliacoesPAPIPP_avOrient6avaliacao) {
		this.avaliacoesPAPIPP_avOrient6avaliacao = avaliacoesPAPIPP_avOrient6avaliacao;
	}
	public double getAvaliacoesPAPIPP_avOrient7avaliacao() {
		return avaliacoesPAPIPP_avOrient7avaliacao;
	}
	public void setAvaliacoesPAPIPP_avOrient7avaliacao(double avaliacoesPAPIPP_avOrient7avaliacao) {
		this.avaliacoesPAPIPP_avOrient7avaliacao = avaliacoesPAPIPP_avOrient7avaliacao;
	}
	public double getAvaliacoesPAPIPP_avOrient8avaliacao() {
		return avaliacoesPAPIPP_avOrient8avaliacao;
	}
	public void setAvaliacoesPAPIPP_avOrient8avaliacao(double avaliacoesPAPIPP_avOrient8avaliacao) {
		this.avaliacoesPAPIPP_avOrient8avaliacao = avaliacoesPAPIPP_avOrient8avaliacao;
	}
	public Date getAvaliacoesPAPIPP_data1avaliacao() {
		return avaliacoesPAPIPP_data1avaliacao;
	}
	public void setAvaliacoesPAPIPP_data1avaliacao(Date avaliacoesPAPIPP_data1avaliacao) {
		this.avaliacoesPAPIPP_data1avaliacao = avaliacoesPAPIPP_data1avaliacao;
	}
	public Date getAvaliacoesPAPIPP_data2avaliacao() {
		return avaliacoesPAPIPP_data2avaliacao;
	}
	public void setAvaliacoesPAPIPP_data2avaliacao(Date avaliacoesPAPIPP_data2avaliacao) {
		this.avaliacoesPAPIPP_data2avaliacao = avaliacoesPAPIPP_data2avaliacao;
	}
	public Date getAvaliacoesPAPIPP_data3avaliacao() {
		return avaliacoesPAPIPP_data3avaliacao;
	}
	public void setAvaliacoesPAPIPP_data3avaliacao(Date avaliacoesPAPIPP_data3avaliacao) {
		this.avaliacoesPAPIPP_data3avaliacao = avaliacoesPAPIPP_data3avaliacao;
	}
	public Date getAvaliacoesPAPIPP_data4avaliacao() {
		return avaliacoesPAPIPP_data4avaliacao;
	}
	public void setAvaliacoesPAPIPP_data4avaliacao(Date avaliacoesPAPIPP_data4avaliacao) {
		this.avaliacoesPAPIPP_data4avaliacao = avaliacoesPAPIPP_data4avaliacao;
	}
	public Date getAvaliacoesPAPIPP_data5avaliacao() {
		return avaliacoesPAPIPP_data5avaliacao;
	}
	public void setAvaliacoesPAPIPP_data5avaliacao(Date avaliacoesPAPIPP_data5avaliacao) {
		this.avaliacoesPAPIPP_data5avaliacao = avaliacoesPAPIPP_data5avaliacao;
	}
	public Date getAvaliacoesPAPIPP_data6avaliacao() {
		return avaliacoesPAPIPP_data6avaliacao;
	}
	public void setAvaliacoesPAPIPP_data6avaliacao(Date avaliacoesPAPIPP_data6avaliacao) {
		this.avaliacoesPAPIPP_data6avaliacao = avaliacoesPAPIPP_data6avaliacao;
	}
	public Date getAvaliacoesPAPIPP_data7avaliacao() {
		return avaliacoesPAPIPP_data7avaliacao;
	}
	public void setAvaliacoesPAPIPP_data7avaliacao(Date avaliacoesPAPIPP_data7avaliacao) {
		this.avaliacoesPAPIPP_data7avaliacao = avaliacoesPAPIPP_data7avaliacao;
	}
	public double getAvaliacoesPIO_autoav1avaliacao() {
		return avaliacoesPIO_autoav1avaliacao;
	}
	public void setAvaliacoesPIO_autoav1avaliacao(double avaliacoesPIO_autoav1avaliacao) {
		this.avaliacoesPIO_autoav1avaliacao = avaliacoesPIO_autoav1avaliacao;
	}
	public double getAvaliacoesPIO_autoav2avaliacao() {
		return avaliacoesPIO_autoav2avaliacao;
	}
	public void setAvaliacoesPIO_autoav2avaliacao(double avaliacoesPIO_autoav2avaliacao) {
		this.avaliacoesPIO_autoav2avaliacao = avaliacoesPIO_autoav2avaliacao;
	}
	public double getAvaliacoesPIO_autoav3avaliacao() {
		return avaliacoesPIO_autoav3avaliacao;
	}
	public void setAvaliacoesPIO_autoav3avaliacao(double avaliacoesPIO_autoav3avaliacao) {
		this.avaliacoesPIO_autoav3avaliacao = avaliacoesPIO_autoav3avaliacao;
	}
	public double getAvaliacoesPIO_autoav4avaliacao() {
		return avaliacoesPIO_autoav4avaliacao;
	}
	public void setAvaliacoesPIO_autoav4avaliacao(double avaliacoesPIO_autoav4avaliacao) {
		this.avaliacoesPIO_autoav4avaliacao = avaliacoesPIO_autoav4avaliacao;
	}
	public double getAvaliacoesPIO_autoav5avaliacao() {
		return avaliacoesPIO_autoav5avaliacao;
	}
	public void setAvaliacoesPIO_autoav5avaliacao(double avaliacoesPIO_autoav5avaliacao) {
		this.avaliacoesPIO_autoav5avaliacao = avaliacoesPIO_autoav5avaliacao;
	}
	public double getAvaliacoesPIO_autoav6avaliacao() {
		return avaliacoesPIO_autoav6avaliacao;
	}
	public void setAvaliacoesPIO_autoav6avaliacao(double avaliacoesPIO_autoav6avaliacao) {
		this.avaliacoesPIO_autoav6avaliacao = avaliacoesPIO_autoav6avaliacao;
	}
	public double getAvaliacoesPIO_autoav7avaliacao() {
		return avaliacoesPIO_autoav7avaliacao;
	}
	public void setAvaliacoesPIO_autoav7avaliacao(double avaliacoesPIO_autoav7avaliacao) {
		this.avaliacoesPIO_autoav7avaliacao = avaliacoesPIO_autoav7avaliacao;
	}
	public double getAvaliacoesPIO_autoav8avaliacao() {
		return avaliacoesPIO_autoav8avaliacao;
	}
	public void setAvaliacoesPIO_autoav8avaliacao(double avaliacoesPIO_autoav8avaliacao) {
		this.avaliacoesPIO_autoav8avaliacao = avaliacoesPIO_autoav8avaliacao;
	}
	public double getAvaliacoesPIO_avCont1avaliacao() {
		return avaliacoesPIO_avCont1avaliacao;
	}
	public void setAvaliacoesPIO_avCont1avaliacao(double avaliacoesPIO_avCont1avaliacao) {
		this.avaliacoesPIO_avCont1avaliacao = avaliacoesPIO_avCont1avaliacao;
	}
	public double getAvaliacoesPIO_avCont2avaliacao() {
		return avaliacoesPIO_avCont2avaliacao;
	}
	public void setAvaliacoesPIO_avCont2avaliacao(double avaliacoesPIO_avCont2avaliacao) {
		this.avaliacoesPIO_avCont2avaliacao = avaliacoesPIO_avCont2avaliacao;
	}
	public double getAvaliacoesPIO_avCont3avaliacao() {
		return avaliacoesPIO_avCont3avaliacao;
	}
	public void setAvaliacoesPIO_avCont3avaliacao(double avaliacoesPIO_avCont3avaliacao) {
		this.avaliacoesPIO_avCont3avaliacao = avaliacoesPIO_avCont3avaliacao;
	}
	public double getAvaliacoesPIO_avCont4avaliacao() {
		return avaliacoesPIO_avCont4avaliacao;
	}
	public void setAvaliacoesPIO_avCont4avaliacao(double avaliacoesPIO_avCont4avaliacao) {
		this.avaliacoesPIO_avCont4avaliacao = avaliacoesPIO_avCont4avaliacao;
	}
	public double getAvaliacoesPIO_avCont5avaliacao() {
		return avaliacoesPIO_avCont5avaliacao;
	}
	public void setAvaliacoesPIO_avCont5avaliacao(double avaliacoesPIO_avCont5avaliacao) {
		this.avaliacoesPIO_avCont5avaliacao = avaliacoesPIO_avCont5avaliacao;
	}
	public double getAvaliacoesPIO_avCont6avaliacao() {
		return avaliacoesPIO_avCont6avaliacao;
	}
	public void setAvaliacoesPIO_avCont6avaliacao(double avaliacoesPIO_avCont6avaliacao) {
		this.avaliacoesPIO_avCont6avaliacao = avaliacoesPIO_avCont6avaliacao;
	}
	public double getAvaliacoesPIO_avCont7avaliacao() {
		return avaliacoesPIO_avCont7avaliacao;
	}
	public void setAvaliacoesPIO_avCont7avaliacao(double avaliacoesPIO_avCont7avaliacao) {
		this.avaliacoesPIO_avCont7avaliacao = avaliacoesPIO_avCont7avaliacao;
	}
	public double getAvaliacoesPIO_avCont8avaliacao() {
		return avaliacoesPIO_avCont8avaliacao;
	}
	public void setAvaliacoesPIO_avCont8avaliacao(double avaliacoesPIO_avCont8avaliacao) {
		this.avaliacoesPIO_avCont8avaliacao = avaliacoesPIO_avCont8avaliacao;
	}
	public double getAvaliacoesPIO_avOrient1avaliacao() {
		return avaliacoesPIO_avOrient1avaliacao;
	}
	public void setAvaliacoesPIO_avOrient1avaliacao(double avaliacoesPIO_avOrient1avaliacao) {
		this.avaliacoesPIO_avOrient1avaliacao = avaliacoesPIO_avOrient1avaliacao;
	}
	public Date getAvaliacoesPIO_avOrient2avaliacao() {
		return avaliacoesPIO_avOrient2avaliacao;
	}
	public void setAvaliacoesPIO_avOrient2avaliacao(Date avaliacoesPIO_avOrient2avaliacao) {
		this.avaliacoesPIO_avOrient2avaliacao = avaliacoesPIO_avOrient2avaliacao;
	}
	public Date getAvaliacoesPIO_avOrient3avaliacao() {
		return avaliacoesPIO_avOrient3avaliacao;
	}
	public void setAvaliacoesPIO_avOrient3avaliacao(Date avaliacoesPIO_avOrient3avaliacao) {
		this.avaliacoesPIO_avOrient3avaliacao = avaliacoesPIO_avOrient3avaliacao;
	}
	public Date getAvaliacoesPIO_avOrient4avaliacao() {
		return avaliacoesPIO_avOrient4avaliacao;
	}
	public void setAvaliacoesPIO_avOrient4avaliacao(Date avaliacoesPIO_avOrient4avaliacao) {
		this.avaliacoesPIO_avOrient4avaliacao = avaliacoesPIO_avOrient4avaliacao;
	}
	public Date getAvaliacoesPIO_avOrient5avaliacao() {
		return avaliacoesPIO_avOrient5avaliacao;
	}
	public void setAvaliacoesPIO_avOrient5avaliacao(Date avaliacoesPIO_avOrient5avaliacao) {
		this.avaliacoesPIO_avOrient5avaliacao = avaliacoesPIO_avOrient5avaliacao;
	}
	public Date getAvaliacoesPIO_avOrient6avaliacao() {
		return avaliacoesPIO_avOrient6avaliacao;
	}
	public void setAvaliacoesPIO_avOrient6avaliacao(Date avaliacoesPIO_avOrient6avaliacao) {
		this.avaliacoesPIO_avOrient6avaliacao = avaliacoesPIO_avOrient6avaliacao;
	}
	public Date getAvaliacoesPIO_avOrient7avaliacao() {
		return avaliacoesPIO_avOrient7avaliacao;
	}
	public void setAvaliacoesPIO_avOrient7avaliacao(Date avaliacoesPIO_avOrient7avaliacao) {
		this.avaliacoesPIO_avOrient7avaliacao = avaliacoesPIO_avOrient7avaliacao;
	}
	public Date getAvaliacoesPIO_avOrient8avaliacao() {
		return avaliacoesPIO_avOrient8avaliacao;
	}
	public void setAvaliacoesPIO_avOrient8avaliacao(Date avaliacoesPIO_avOrient8avaliacao) {
		this.avaliacoesPIO_avOrient8avaliacao = avaliacoesPIO_avOrient8avaliacao;
	}
	public Date getAvaliacoesPIO_data1avaliacao() {
		return avaliacoesPIO_data1avaliacao;
	}
	public void setAvaliacoesPIO_data1avaliacao(Date avaliacoesPIO_data1avaliacao) {
		this.avaliacoesPIO_data1avaliacao = avaliacoesPIO_data1avaliacao;
	}
	public Date getAvaliacoesPIO_data2avaliacao() {
		return avaliacoesPIO_data2avaliacao;
	}
	public void setAvaliacoesPIO_data2avaliacao(Date avaliacoesPIO_data2avaliacao) {
		this.avaliacoesPIO_data2avaliacao = avaliacoesPIO_data2avaliacao;
	}
	public Date getAvaliacoesPIO_data3avaliacao() {
		return avaliacoesPIO_data3avaliacao;
	}
	public void setAvaliacoesPIO_data3avaliacao(Date avaliacoesPIO_data3avaliacao) {
		this.avaliacoesPIO_data3avaliacao = avaliacoesPIO_data3avaliacao;
	}
	public Date getAvaliacoesPIO_data4avaliacao() {
		return avaliacoesPIO_data4avaliacao;
	}
	public void setAvaliacoesPIO_data4avaliacao(Date avaliacoesPIO_data4avaliacao) {
		this.avaliacoesPIO_data4avaliacao = avaliacoesPIO_data4avaliacao;
	}
	public Date getAvaliacoesPIO_data5avaliacao() {
		return avaliacoesPIO_data5avaliacao;
	}
	public void setAvaliacoesPIO_data5avaliacao(Date avaliacoesPIO_data5avaliacao) {
		this.avaliacoesPIO_data5avaliacao = avaliacoesPIO_data5avaliacao;
	}
	public Date getAvaliacoesPIO_data6avaliacao() {
		return avaliacoesPIO_data6avaliacao;
	}
	public void setAvaliacoesPIO_data6avaliacao(Date avaliacoesPIO_data6avaliacao) {
		this.avaliacoesPIO_data6avaliacao = avaliacoesPIO_data6avaliacao;
	}
	public Date getAvaliacoesPIO_data7avaliacao() {
		return avaliacoesPIO_data7avaliacao;
	}
	public void setAvaliacoesPIO_data7avaliacao(Date avaliacoesPIO_data7avaliacao) {
		this.avaliacoesPIO_data7avaliacao = avaliacoesPIO_data7avaliacao;
	}
	public Date getAvaliacoesPIO_data8avaliacao() {
		return avaliacoesPIO_data8avaliacao;
	}
	public void setAvaliacoesPIO_data8avaliacao(Date avaliacoesPIO_data8avaliacao) {
		this.avaliacoesPIO_data8avaliacao = avaliacoesPIO_data8avaliacao;
	}
	public Boolean getAvaliacoesPITEPIP_avaliacaoPIT() {
		return avaliacoesPITEPIP_avaliacaoPIT;
	}
	public void setAvaliacoesPITEPIP_avaliacaoPIT(Boolean avaliacoesPITEPIP_avaliacaoPIT) {
		this.avaliacoesPITEPIP_avaliacaoPIT = avaliacoesPITEPIP_avaliacaoPIT;
	}
	public Date getAvaliacoesPITEPIP_dataAutoAvaliacao() {
		return avaliacoesPITEPIP_dataAutoAvaliacao;
	}
	public void setAvaliacoesPITEPIP_dataAutoAvaliacao(Date avaliacoesPITEPIP_dataAutoAvaliacao) {
		this.avaliacoesPITEPIP_dataAutoAvaliacao = avaliacoesPITEPIP_dataAutoAvaliacao;
	}
	public Date getAvaliacoesPITEPIP_dataAvaliacaoInformatica() {
		return avaliacoesPITEPIP_dataAvaliacaoInformatica;
	}
	public void setAvaliacoesPITEPIP_dataAvaliacaoInformatica(Date avaliacoesPITEPIP_dataAvaliacaoInformatica) {
		this.avaliacoesPITEPIP_dataAvaliacaoInformatica = avaliacoesPITEPIP_dataAvaliacaoInformatica;
	}
	public Date getAvaliacoesPITEPIP_dataAvaliacaoMatematica() {
		return avaliacoesPITEPIP_dataAvaliacaoMatematica;
	}
	public void setAvaliacoesPITEPIP_dataAvaliacaoMatematica(Date avaliacoesPITEPIP_dataAvaliacaoMatematica) {
		this.avaliacoesPITEPIP_dataAvaliacaoMatematica = avaliacoesPITEPIP_dataAvaliacaoMatematica;
	}
	public Date getAvaliacoesPITEPIP_dataAvaliacaoOrientador() {
		return avaliacoesPITEPIP_dataAvaliacaoOrientador;
	}
	public void setAvaliacoesPITEPIP_dataAvaliacaoOrientador(Date avaliacoesPITEPIP_dataAvaliacaoOrientador) {
		this.avaliacoesPITEPIP_dataAvaliacaoOrientador = avaliacoesPITEPIP_dataAvaliacaoOrientador;
	}
	public Date getAvaliacoesPITEPIP_dataAvaliacaoPortugues() {
		return avaliacoesPITEPIP_dataAvaliacaoPortugues;
	}
	public void setAvaliacoesPITEPIP_dataAvaliacaoPortugues(Date avaliacoesPITEPIP_dataAvaliacaoPortugues) {
		this.avaliacoesPITEPIP_dataAvaliacaoPortugues = avaliacoesPITEPIP_dataAvaliacaoPortugues;
	}
	public Date getAvaliacoesPITEPIP_dataAvaliacaoVivencia() {
		return avaliacoesPITEPIP_dataAvaliacaoVivencia;
	}
	public void setAvaliacoesPITEPIP_dataAvaliacaoVivencia(Date avaliacoesPITEPIP_dataAvaliacaoVivencia) {
		this.avaliacoesPITEPIP_dataAvaliacaoVivencia = avaliacoesPITEPIP_dataAvaliacaoVivencia;
	}
	public double getAvaliacoesPITEPIP_notaAutoavaliacao() {
		return avaliacoesPITEPIP_notaAutoavaliacao;
	}
	public void setAvaliacoesPITEPIP_notaAutoavaliacao(double avaliacoesPITEPIP_notaAutoavaliacao) {
		this.avaliacoesPITEPIP_notaAutoavaliacao = avaliacoesPITEPIP_notaAutoavaliacao;
	}
	public double getAvaliacoesPITEPIP_notaAvaliacaoInformatica() {
		return avaliacoesPITEPIP_notaAvaliacaoInformatica;
	}
	public void setAvaliacoesPITEPIP_notaAvaliacaoInformatica(double avaliacoesPITEPIP_notaAvaliacaoInformatica) {
		this.avaliacoesPITEPIP_notaAvaliacaoInformatica = avaliacoesPITEPIP_notaAvaliacaoInformatica;
	}
	public double getAvaliacoesPITEPIP_notaAvaliacaoMatematica() {
		return avaliacoesPITEPIP_notaAvaliacaoMatematica;
	}
	public void setAvaliacoesPITEPIP_notaAvaliacaoMatematica(double avaliacoesPITEPIP_notaAvaliacaoMatematica) {
		this.avaliacoesPITEPIP_notaAvaliacaoMatematica = avaliacoesPITEPIP_notaAvaliacaoMatematica;
	}
	public double getAvaliacoesPITEPIP_notaAvaliacaoOrientador() {
		return avaliacoesPITEPIP_notaAvaliacaoOrientador;
	}
	public void setAvaliacoesPITEPIP_notaAvaliacaoOrientador(double avaliacoesPITEPIP_notaAvaliacaoOrientador) {
		this.avaliacoesPITEPIP_notaAvaliacaoOrientador = avaliacoesPITEPIP_notaAvaliacaoOrientador;
	}
	public double getAvaliacoesPITEPIP_notaAvaliacaoPortugues() {
		return avaliacoesPITEPIP_notaAvaliacaoPortugues;
	}
	public void setAvaliacoesPITEPIP_notaAvaliacaoPortugues(double avaliacoesPITEPIP_notaAvaliacaoPortugues) {
		this.avaliacoesPITEPIP_notaAvaliacaoPortugues = avaliacoesPITEPIP_notaAvaliacaoPortugues;
	}
	public double getAvaliacoesPITEPIP_notaAvaliacaoVivencia() {
		return avaliacoesPITEPIP_notaAvaliacaoVivencia;
	}
	public void setAvaliacoesPITEPIP_notaAvaliacaoVivencia(double avaliacoesPITEPIP_notaAvaliacaoVivencia) {
		this.avaliacoesPITEPIP_notaAvaliacaoVivencia = avaliacoesPITEPIP_notaAvaliacaoVivencia;
	}
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
*/	
}