package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Escolaridade extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String curso;
	private Date anoConclusaoEnsinoMedio;
	private Boolean concluiuOEnsinoMedio;
	private String cursoEnsinoMedio;
	private Boolean fequentaEscola;
	private String nomeDaEscola;
	private String serieAno;
	@OneToOne
	private Jovem jovem;
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Date getAnoConclusaoEnsinoMedio() {
		return anoConclusaoEnsinoMedio;
	}
	public void setAnoConclusaoEnsinoMedio(Date anoConclusaoEnsinoMedio) {
		this.anoConclusaoEnsinoMedio = anoConclusaoEnsinoMedio;
	}
	public Boolean getConcluiuOEnsinoMedio() {
		return concluiuOEnsinoMedio;
	}
	public void setConcluiuOEnsinoMedio(Boolean concluiuOEnsinoMedio) {
		this.concluiuOEnsinoMedio = concluiuOEnsinoMedio;
	}
	public String getCursoEnsinoMedio() {
		return cursoEnsinoMedio;
	}
	public void setCursoEnsinoMedio(String cursoEnsinoMedio) {
		this.cursoEnsinoMedio = cursoEnsinoMedio;
	}
	public Boolean getFequentaEscola() {
		return fequentaEscola;
	}
	public void setFequentaEscola(Boolean fequentaEscola) {
		this.fequentaEscola = fequentaEscola;
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