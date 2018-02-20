package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Escolaridade extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String nomeDoCurso;
	private String dataConclusaoEnsinoMedio;
	private String dataConclusaoCurso;
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
	public String getDataConclusaoEnsinoMedio() {
		return dataConclusaoEnsinoMedio;
	}
	public void setDataConclusaoEnsinoMedio(String dataConclusaoEnsinoMedio) {
		this.dataConclusaoEnsinoMedio = dataConclusaoEnsinoMedio;
	}
	public String getDataConclusaoCurso() {
		return dataConclusaoCurso;
	}
	public void setDataConclusaoCurso(String dataConclusaoCurso) {
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