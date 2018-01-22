package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.models.AbstractEntity;

@Entity
public class AvaliacaoPAPEmpresa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String avaliacoesPAPEmpresa_avaliador1avaliacao;
	private String avaliacoesPAPEmpresa_avaliador2avaliacao;
	private String avaliacoesPAPEmpresa_avaliador3avaliacao;
	private String avaliacoesPAPEmpresa_avaliador4avaliacao;
	private String avaliacoesPAPEmpresa_avaliador5avaliacao;
	private String avaliacoesPAPEmpresa_avaliador6avaliacao;
	private String avaliacoesPAPEmpresa_avaliador7avaliacao;
	private String avaliacoesPAPEmpresa_avaliador8avaliacao;

	private double avaliacoesPAPEmpresa_nota1avaliacao;
	private double avaliacoesPAPEmpresa_nota2avaliacao;
	private double avaliacoesPAPEmpresa_nota3avaliacao;
	private double avaliacoesPAPEmpresa_nota4avaliacao;
	private double avaliacoesPAPEmpresa_nota5avaliacao;
	private double avaliacoesPAPEmpresa_nota6avaliacao;
	private double avaliacoesPAPEmpresa_nota7avaliacao;
	private double avaliacoesPAPEmpresa_nota8avaliacao;
	
	@Column(name = "avaliacoesPAPEmpresa_data1avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPEmpresa_data1avaliacao;
	@Column(name = "avaliacoesPAPEmpresa_data2avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPEmpresa_data2avaliacao;
	@Column(name = "avaliacoesPAPEmpresa_data3avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPEmpresa_data3avaliacao;
	@Column(name = "avaliacoesPAPEmpresa_data4avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPEmpresa_data4avaliacao;
	@Column(name = "avaliacoesPAPEmpresa_data5avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPEmpresa_data5avaliacao;
	@Column(name = "avaliacoesPAPEmpresa_data6avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPEmpresa_data6avaliacao;
	@Column(name = "avaliacoesPAPEmpresa_data7avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPEmpresa_data7avaliacao;
	@Column(name = "avaliacoesPAPEmpresa_data8avaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPAPEmpresa_data8avaliacao;
	
	@ManyToOne
	private Jovem jovem;
	
	
	public String getAvaliacoesPAPEmpresa_avaliador1avaliacao() {
		return avaliacoesPAPEmpresa_avaliador1avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador1avaliacao(String avaliacoesPAPEmpresa_avaliador1avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador1avaliacao = avaliacoesPAPEmpresa_avaliador1avaliacao;
	}
	public String getAvaliacoesPAPEmpresa_avaliador2avaliacao() {
		return avaliacoesPAPEmpresa_avaliador2avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador2avaliacao(String avaliacoesPAPEmpresa_avaliador2avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador2avaliacao = avaliacoesPAPEmpresa_avaliador2avaliacao;
	}
	public String getAvaliacoesPAPEmpresa_avaliador3avaliacao() {
		return avaliacoesPAPEmpresa_avaliador3avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador3avaliacao(String avaliacoesPAPEmpresa_avaliador3avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador3avaliacao = avaliacoesPAPEmpresa_avaliador3avaliacao;
	}
	public String getAvaliacoesPAPEmpresa_avaliador4avaliacao() {
		return avaliacoesPAPEmpresa_avaliador4avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador4avaliacao(String avaliacoesPAPEmpresa_avaliador4avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador4avaliacao = avaliacoesPAPEmpresa_avaliador4avaliacao;
	}
	public String getAvaliacoesPAPEmpresa_avaliador5avaliacao() {
		return avaliacoesPAPEmpresa_avaliador5avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador5avaliacao(String avaliacoesPAPEmpresa_avaliador5avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador5avaliacao = avaliacoesPAPEmpresa_avaliador5avaliacao;
	}
	public String getAvaliacoesPAPEmpresa_avaliador6avaliacao() {
		return avaliacoesPAPEmpresa_avaliador6avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador6avaliacao(String avaliacoesPAPEmpresa_avaliador6avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador6avaliacao = avaliacoesPAPEmpresa_avaliador6avaliacao;
	}
	public String getAvaliacoesPAPEmpresa_avaliador7avaliacao() {
		return avaliacoesPAPEmpresa_avaliador7avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador7avaliacao(String avaliacoesPAPEmpresa_avaliador7avaliacao) {
		this.avaliacoesPAPEmpresa_avaliador7avaliacao = avaliacoesPAPEmpresa_avaliador7avaliacao;
	}
	public String getAvaliacoesPAPEmpresa_avaliador8avaliacao() {
		return avaliacoesPAPEmpresa_avaliador8avaliacao;
	}
	public void setAvaliacoesPAPEmpresa_avaliador8avaliacao(String avaliacoesPAPEmpresa_avaliador8avaliacao) {
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
