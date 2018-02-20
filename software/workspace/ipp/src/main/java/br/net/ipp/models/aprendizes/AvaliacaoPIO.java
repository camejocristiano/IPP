package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class AvaliacaoPIO extends AbstractEntity {

	private static final long serialVersionUID = 1L;

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
	private double avaliacoesPIO_avOrient2avaliacao;
	private double avaliacoesPIO_avOrient3avaliacao;
	private double avaliacoesPIO_avOrient4avaliacao;
	private double avaliacoesPIO_avOrient5avaliacao;
	private double avaliacoesPIO_avOrient6avaliacao;
	private double avaliacoesPIO_avOrient7avaliacao;
	private double avaliacoesPIO_avOrient8avaliacao;
	
	private String avaliacoesPIO_data1avaliacao;
	private String avaliacoesPIO_data2avaliacao;
	private String avaliacoesPIO_data3avaliacao;
	private String avaliacoesPIO_data4avaliacao;
	private String avaliacoesPIO_data5avaliacao;
	private String avaliacoesPIO_data6avaliacao;
	private String avaliacoesPIO_data7avaliacao;
	private String avaliacoesPIO_data8avaliacao;
	@ManyToOne
	private Jovem jovem;
	
	
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
	public double getAvaliacoesPIO_avOrient2avaliacao() {
		return avaliacoesPIO_avOrient2avaliacao;
	}
	public void setAvaliacoesPIO_avOrient2avaliacao(double avaliacoesPIO_avOrient2avaliacao) {
		this.avaliacoesPIO_avOrient2avaliacao = avaliacoesPIO_avOrient2avaliacao;
	}
	public double getAvaliacoesPIO_avOrient3avaliacao() {
		return avaliacoesPIO_avOrient3avaliacao;
	}
	public void setAvaliacoesPIO_avOrient3avaliacao(double avaliacoesPIO_avOrient3avaliacao) {
		this.avaliacoesPIO_avOrient3avaliacao = avaliacoesPIO_avOrient3avaliacao;
	}
	public double getAvaliacoesPIO_avOrient4avaliacao() {
		return avaliacoesPIO_avOrient4avaliacao;
	}
	public void setAvaliacoesPIO_avOrient4avaliacao(double avaliacoesPIO_avOrient4avaliacao) {
		this.avaliacoesPIO_avOrient4avaliacao = avaliacoesPIO_avOrient4avaliacao;
	}
	public double getAvaliacoesPIO_avOrient5avaliacao() {
		return avaliacoesPIO_avOrient5avaliacao;
	}
	public void setAvaliacoesPIO_avOrient5avaliacao(double avaliacoesPIO_avOrient5avaliacao) {
		this.avaliacoesPIO_avOrient5avaliacao = avaliacoesPIO_avOrient5avaliacao;
	}
	public double getAvaliacoesPIO_avOrient6avaliacao() {
		return avaliacoesPIO_avOrient6avaliacao;
	}
	public void setAvaliacoesPIO_avOrient6avaliacao(double avaliacoesPIO_avOrient6avaliacao) {
		this.avaliacoesPIO_avOrient6avaliacao = avaliacoesPIO_avOrient6avaliacao;
	}
	public double getAvaliacoesPIO_avOrient7avaliacao() {
		return avaliacoesPIO_avOrient7avaliacao;
	}
	public void setAvaliacoesPIO_avOrient7avaliacao(double avaliacoesPIO_avOrient7avaliacao) {
		this.avaliacoesPIO_avOrient7avaliacao = avaliacoesPIO_avOrient7avaliacao;
	}
	public double getAvaliacoesPIO_avOrient8avaliacao() {
		return avaliacoesPIO_avOrient8avaliacao;
	}
	public void setAvaliacoesPIO_avOrient8avaliacao(double avaliacoesPIO_avOrient8avaliacao) {
		this.avaliacoesPIO_avOrient8avaliacao = avaliacoesPIO_avOrient8avaliacao;
	}
	public String getAvaliacoesPIO_data1avaliacao() {
		return avaliacoesPIO_data1avaliacao;
	}
	public void setAvaliacoesPIO_data1avaliacao(String avaliacoesPIO_data1avaliacao) {
		this.avaliacoesPIO_data1avaliacao = avaliacoesPIO_data1avaliacao;
	}
	public String getAvaliacoesPIO_data2avaliacao() {
		return avaliacoesPIO_data2avaliacao;
	}
	public void setAvaliacoesPIO_data2avaliacao(String avaliacoesPIO_data2avaliacao) {
		this.avaliacoesPIO_data2avaliacao = avaliacoesPIO_data2avaliacao;
	}
	public String getAvaliacoesPIO_data3avaliacao() {
		return avaliacoesPIO_data3avaliacao;
	}
	public void setAvaliacoesPIO_data3avaliacao(String avaliacoesPIO_data3avaliacao) {
		this.avaliacoesPIO_data3avaliacao = avaliacoesPIO_data3avaliacao;
	}
	public String getAvaliacoesPIO_data4avaliacao() {
		return avaliacoesPIO_data4avaliacao;
	}
	public void setAvaliacoesPIO_data4avaliacao(String avaliacoesPIO_data4avaliacao) {
		this.avaliacoesPIO_data4avaliacao = avaliacoesPIO_data4avaliacao;
	}
	public String getAvaliacoesPIO_data5avaliacao() {
		return avaliacoesPIO_data5avaliacao;
	}
	public void setAvaliacoesPIO_data5avaliacao(String avaliacoesPIO_data5avaliacao) {
		this.avaliacoesPIO_data5avaliacao = avaliacoesPIO_data5avaliacao;
	}
	public String getAvaliacoesPIO_data6avaliacao() {
		return avaliacoesPIO_data6avaliacao;
	}
	public void setAvaliacoesPIO_data6avaliacao(String avaliacoesPIO_data6avaliacao) {
		this.avaliacoesPIO_data6avaliacao = avaliacoesPIO_data6avaliacao;
	}
	public String getAvaliacoesPIO_data7avaliacao() {
		return avaliacoesPIO_data7avaliacao;
	}
	public void setAvaliacoesPIO_data7avaliacao(String avaliacoesPIO_data7avaliacao) {
		this.avaliacoesPIO_data7avaliacao = avaliacoesPIO_data7avaliacao;
	}
	public String getAvaliacoesPIO_data8avaliacao() {
		return avaliacoesPIO_data8avaliacao;
	}
	public void setAvaliacoesPIO_data8avaliacao(String avaliacoesPIO_data8avaliacao) {
		this.avaliacoesPIO_data8avaliacao = avaliacoesPIO_data8avaliacao;
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
