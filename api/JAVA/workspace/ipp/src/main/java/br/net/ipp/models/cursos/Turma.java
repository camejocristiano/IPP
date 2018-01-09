package br.net.ipp.models.cursos;

import java.util.Date;

import javax.persistence.Entity;

import br.net.ipp.enums.DiaDaSemana;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.frequencias.AulaExtra;
import br.net.ipp.models.frequencias.PAP;
import br.net.ipp.models.frequencias.PIO;
import br.net.ipp.models.frequencias.PITEPIP;

@Entity
public class Turma  extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Date dataFimTurma;
	private Date dataInicioTurma;
	private DiaDaSemana diaDaSemanaTurma;
	private Date horaFimTurma;
	private Date horaInicioTurma;
	private String numeroTurma;
	private Usuario orientadorTurma;
	public DiaDaSemana m_DiaDaSemana;
	public Curso curso;
	public Jovem jovem;
	public PITEPIP m_ListaDeFrequencia_PITEPIP;
	public AulaExtra m_ListaDeFrequencia_AulaExtra;
	public PAP m_ListaDeFrequencia_PAP;
	public PIO m_ListaDeFrequencia_PIO;
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Date getDataFimTurma() {
		return dataFimTurma;
	}
	public void setDataFimTurma(Date dataFimTurma) {
		this.dataFimTurma = dataFimTurma;
	}
	public Date getDataInicioTurma() {
		return dataInicioTurma;
	}
	public void setDataInicioTurma(Date dataInicioTurma) {
		this.dataInicioTurma = dataInicioTurma;
	}
	public DiaDaSemana getDiaDaSemanaTurma() {
		return diaDaSemanaTurma;
	}
	public void setDiaDaSemanaTurma(DiaDaSemana diaDaSemanaTurma) {
		this.diaDaSemanaTurma = diaDaSemanaTurma;
	}
	public Date getHoraFimTurma() {
		return horaFimTurma;
	}
	public void setHoraFimTurma(Date horaFimTurma) {
		this.horaFimTurma = horaFimTurma;
	}
	public Date getHoraInicioTurma() {
		return horaInicioTurma;
	}
	public void setHoraInicioTurma(Date horaInicioTurma) {
		this.horaInicioTurma = horaInicioTurma;
	}
	public String getNumeroTurma() {
		return numeroTurma;
	}
	public void setNumeroTurma(String numeroTurma) {
		this.numeroTurma = numeroTurma;
	}
	public Usuario getOrientadorTurma() {
		return orientadorTurma;
	}
	public void setOrientadorTurma(Usuario orientadorTurma) {
		this.orientadorTurma = orientadorTurma;
	}
	public DiaDaSemana getM_DiaDaSemana() {
		return m_DiaDaSemana;
	}
	public void setM_DiaDaSemana(DiaDaSemana m_DiaDaSemana) {
		this.m_DiaDaSemana = m_DiaDaSemana;
	}
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public PITEPIP getM_ListaDeFrequencia_PITEPIP() {
		return m_ListaDeFrequencia_PITEPIP;
	}
	public void setM_ListaDeFrequencia_PITEPIP(PITEPIP m_ListaDeFrequencia_PITEPIP) {
		this.m_ListaDeFrequencia_PITEPIP = m_ListaDeFrequencia_PITEPIP;
	}
	public AulaExtra getM_ListaDeFrequencia_AulaExtra() {
		return m_ListaDeFrequencia_AulaExtra;
	}
	public void setM_ListaDeFrequencia_AulaExtra(AulaExtra m_ListaDeFrequencia_AulaExtra) {
		this.m_ListaDeFrequencia_AulaExtra = m_ListaDeFrequencia_AulaExtra;
	}
	public PAP getM_ListaDeFrequencia_PAP() {
		return m_ListaDeFrequencia_PAP;
	}
	public void setM_ListaDeFrequencia_PAP(PAP m_ListaDeFrequencia_PAP) {
		this.m_ListaDeFrequencia_PAP = m_ListaDeFrequencia_PAP;
	}
	public PIO getM_ListaDeFrequencia_PIO() {
		return m_ListaDeFrequencia_PIO;
	}
	public void setM_ListaDeFrequencia_PIO(PIO m_ListaDeFrequencia_PIO) {
		this.m_ListaDeFrequencia_PIO = m_ListaDeFrequencia_PIO;
	}
	
}