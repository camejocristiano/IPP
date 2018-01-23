package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Escolaridade extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String nomeDoCurso;
	@Column(name = "dataConclusaoEnsinoMedio")  
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date dataConclusaoEnsinoMedio;
	@Column(name = "dataConclusaoCurso")  
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date dataConclusaoCurso;
	private boolean concluiuOEnsinoMedio;
	private String cursoEnsinoMedio;
	private boolean frequentaAEscola;
	private String nomeDaEscola;
	private String serieAno;
	@OneToOne
	private Jovem jovem;
	
	public String getNomeDoCurso() {
		return nomeDoCurso;
	}
	public void setNomeDoCurso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}
	public Date getDataConclusaoEnsinoMedio() {
		return dataConclusaoEnsinoMedio;
	}
	public void setDataConclusaoEnsinoMedio(Date dataConclusaoEnsinoMedio) {
		this.dataConclusaoEnsinoMedio = dataConclusaoEnsinoMedio;
	}
	public Date getDataConclusaoCurso() {
		return dataConclusaoCurso;
	}
	public void setDataConclusaoCurso(Date dataConclusaoCurso) {
		this.dataConclusaoCurso = dataConclusaoCurso;
	}
	public boolean isConcluiuOEnsinoMedio() {
		return concluiuOEnsinoMedio;
	}
	public void setConcluiuOEnsinoMedio(boolean concluiuOEnsinoMedio) {
		this.concluiuOEnsinoMedio = concluiuOEnsinoMedio;
	}
	public String getCursoEnsinoMedio() {
		return cursoEnsinoMedio;
	}
	public void setCursoEnsinoMedio(String cursoEnsinoMedio) {
		this.cursoEnsinoMedio = cursoEnsinoMedio;
	}
	public boolean isFrequentaAEscola() {
		return frequentaAEscola;
	}
	public void setFrequentaAEscola(boolean frequentaAEscola) {
		this.frequentaAEscola = frequentaAEscola;
	}
	public String getNomeDaEscola() {
		return nomeDaEscola;
	}
	public void setNomeDaEscola(String nomeDaEscola) {
		this.nomeDaEscola = nomeDaEscola;
	}
	public String getSerieAno() {
		return serieAno;
	}
	public void setSerieAno(String serieAno) {
		this.serieAno = serieAno;
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