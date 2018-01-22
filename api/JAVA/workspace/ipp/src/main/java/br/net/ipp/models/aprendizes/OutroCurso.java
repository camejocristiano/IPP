package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.models.AbstractEntity;

@Entity
public class OutroCurso extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "dataDeConclusao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date dataDeConclusao;
	private String instituicao;
	private String nomeDoCurso;
	@ManyToOne
	private Jovem jovem;
	
	public Date getDataDeConclusao() {
		return dataDeConclusao;
	}
	public void setDataDeConclusao(Date dataDeConclusao) {
		this.dataDeConclusao = dataDeConclusao;
	}
	public Date getData() {
		return dataDeConclusao;
	}
	public void setData(Date dataDeConclusao) {
		this.dataDeConclusao = dataDeConclusao;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNomeDoCurso() {
		return nomeDoCurso;
	}
	public void setNomeDoCurso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}

}