package br.net.ipp.models.cursos;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.DiaDaSemana;
import br.net.ipp.enums.TipoTurmaEnum;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.configuracoes.Usuario;

@Entity
public class Turma extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private String dataInicioTurma;
	private String dataFimTurma;
	private DiaDaSemana diaDaSemana;
	private String horaInicioTurma;
	private String horaFimTurma;
	@ManyToOne
	private Usuario orientadorTurma;
	@ManyToOne
	private Curso curso;
	private String numeroTurma;
	private TipoTurmaEnum tipoTurma;
	
	public String getDataInicioTurma() {
		return dataInicioTurma;
	}
	public void setDataInicioTurma(String dataInicioTurma) {
		this.dataInicioTurma = dataInicioTurma;
	}
	public String getDataFimTurma() {
		return dataFimTurma;
	}
	public void setDataFimTurma(String dataFimTurma) {
		this.dataFimTurma = dataFimTurma;
	}
	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	public String getHoraInicioTurma() {
		return horaInicioTurma;
	}
	public void setHoraInicioTurma(String horaInicioTurma) {
		this.horaInicioTurma = horaInicioTurma;
	}
	public String getHoraFimTurma() {
		return horaFimTurma;
	}
	public void setHoraFimTurma(String horaFimTurma) {
		this.horaFimTurma = horaFimTurma;
	}
	public Usuario getOrientadorTurma() {
		return orientadorTurma;
	}
	public void setOrientadorTurma(Usuario orientadorTurma) {
		this.orientadorTurma = orientadorTurma;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getNumeroTurma() {
		return numeroTurma;
	}
	public void setNumeroTurma(String numeroTurma) {
		this.numeroTurma = numeroTurma;
	}
	public TipoTurmaEnum getTipoTurma() {
		return tipoTurma;
	}
	public void setTipoTurma(TipoTurmaEnum tipoTurma) {
		this.tipoTurma = tipoTurma;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}