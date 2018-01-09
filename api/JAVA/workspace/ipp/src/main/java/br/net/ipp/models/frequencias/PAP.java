package br.net.ipp.models.frequencias;

import java.util.Date;

import javax.persistence.Entity;

import br.net.ipp.enums.Frequencia;
import br.net.ipp.enums.MesEnum;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Turma;

@Entity
public class PAP extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Jovem jovem;
	private Curso curso;
	private Date data;
	private MesEnum mes;
	
	private String semana01;
	private Frequencia semana01Manha;
	private Frequencia semana01Tarde;
	private String semana02;
	private Frequencia semana02Manha;
	private Frequencia semana02Tarde;
	private String semana03;
	private Frequencia semana03Manha;
	private Frequencia semana03Tarde;
	private String semana04;
	private Frequencia semana04Manha;
	private Frequencia semana04Tarde;
	private String semana05;
	private Frequencia semana05Manha;
	private Frequencia semana05Tarde;
	private String semana06;
	private Frequencia semana06Manha;
	private Frequencia semana06Tarde;
	private Turma turma;
	public Frequencia m_Frequencia;

	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public MesEnum getMes() {
		return mes;
	}
	public void setMes(MesEnum mes) {
		this.mes = mes;
	}
	public String getSemana01() {
		return semana01;
	}
	public void setSemana01(String semana01) {
		this.semana01 = semana01;
	}
	public Frequencia getSemana01Manha() {
		return semana01Manha;
	}
	public void setSemana01Manha(Frequencia semana01Manha) {
		this.semana01Manha = semana01Manha;
	}
	public Frequencia getSemana01Tarde() {
		return semana01Tarde;
	}
	public void setSemana01Tarde(Frequencia semana01Tarde) {
		this.semana01Tarde = semana01Tarde;
	}
	public String getSemana02() {
		return semana02;
	}
	public void setSemana02(String semana02) {
		this.semana02 = semana02;
	}
	public Frequencia getSemana02Manha() {
		return semana02Manha;
	}
	public void setSemana02Manha(Frequencia semana02Manha) {
		this.semana02Manha = semana02Manha;
	}
	public Frequencia getSemana02Tarde() {
		return semana02Tarde;
	}
	public void setSemana02Tarde(Frequencia semana02Tarde) {
		this.semana02Tarde = semana02Tarde;
	}
	public String getSemana03() {
		return semana03;
	}
	public void setSemana03(String semana03) {
		this.semana03 = semana03;
	}
	public Frequencia getSemana03Manha() {
		return semana03Manha;
	}
	public void setSemana03Manha(Frequencia semana03Manha) {
		this.semana03Manha = semana03Manha;
	}
	public Frequencia getSemana03Tarde() {
		return semana03Tarde;
	}
	public void setSemana03Tarde(Frequencia semana03Tarde) {
		this.semana03Tarde = semana03Tarde;
	}
	public String getSemana04() {
		return semana04;
	}
	public void setSemana04(String semana04) {
		this.semana04 = semana04;
	}
	public Frequencia getSemana04Manha() {
		return semana04Manha;
	}
	public void setSemana04Manha(Frequencia semana04Manha) {
		this.semana04Manha = semana04Manha;
	}
	public Frequencia getSemana04Tarde() {
		return semana04Tarde;
	}
	public void setSemana04Tarde(Frequencia semana04Tarde) {
		this.semana04Tarde = semana04Tarde;
	}
	public String getSemana05() {
		return semana05;
	}
	public void setSemana05(String semana05) {
		this.semana05 = semana05;
	}
	public Frequencia getSemana05Manha() {
		return semana05Manha;
	}
	public void setSemana05Manha(Frequencia semana05Manha) {
		this.semana05Manha = semana05Manha;
	}
	public Frequencia getSemana05Tarde() {
		return semana05Tarde;
	}
	public void setSemana05Tarde(Frequencia semana05Tarde) {
		this.semana05Tarde = semana05Tarde;
	}
	public String getSemana06() {
		return semana06;
	}
	public void setSemana06(String semana06) {
		this.semana06 = semana06;
	}
	public Frequencia getSemana06Manha() {
		return semana06Manha;
	}
	public void setSemana06Manha(Frequencia semana06Manha) {
		this.semana06Manha = semana06Manha;
	}
	public Frequencia getSemana06Tarde() {
		return semana06Tarde;
	}
	public void setSemana06Tarde(Frequencia semana06Tarde) {
		this.semana06Tarde = semana06Tarde;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Frequencia getM_Frequencia() {
		return m_Frequencia;
	}
	public void setM_Frequencia(Frequencia m_Frequencia) {
		this.m_Frequencia = m_Frequencia;
	}

}