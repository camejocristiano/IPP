package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.models.AbstractEntity;

@Entity
public class AvaliacaoPAPIPP extends AbstractEntity {

	private static final long serialVersionUID = 1L;

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
	
	@Column(name = "avaliacoesPAPIPP_data1avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPIPP_data1avaliacao;
	@Column(name = "avaliacoesPAPIPP_data2avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPIPP_data2avaliacao;
	@Column(name = "avaliacoesPAPIPP_data3avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPIPP_data3avaliacao;
	@Column(name = "avaliacoesPAPIPP_data4avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPIPP_data4avaliacao;
	@Column(name = "avaliacoesPAPIPP_data5avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPIPP_data5avaliacao;
	@Column(name = "avaliacoesPAPIPP_data6avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPIPP_data6avaliacao;
	@Column(name = "avaliacoesPAPIPP_data7avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPIPP_data7avaliacao;
	@Column(name = "avaliacoesPAPIPP_data8avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPIPP_data8avaliacao;
	@ManyToOne
	private Jovem jovem;
	
	
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
	public Date getAvaliacoesPAPIPP_data8avaliacao() {
		return avaliacoesPAPIPP_data8avaliacao;
	}
	public void setAvaliacoesPAPIPP_data8avaliacao(Date avaliacoesPAPIPP_data8avaliacao) {
		this.avaliacoesPAPIPP_data8avaliacao = avaliacoesPAPIPP_data8avaliacao;
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
