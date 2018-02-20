package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class OutroCurso extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String dataDeConclusao;
	private String instituicao;
	private String nomeDoCurso;
	@ManyToOne
	private Jovem jovem;
	
	public String getDataDeConclusao() {
		return dataDeConclusao;
	}
	public void setDataDeConclusao(String dataDeConclusao) {
		this.dataDeConclusao = dataDeConclusao;
	}
	public String getData() {
		return dataDeConclusao;
	}
	public void setData(String dataDeConclusao) {
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