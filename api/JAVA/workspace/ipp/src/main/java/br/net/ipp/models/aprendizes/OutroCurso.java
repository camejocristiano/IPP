package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class OutroCurso extends AbstractEntity {

	private static final long serialVersionUID = 1L;

/*	private Date data;
	private String instituicao;*/
	private String nomeDoCurso;

	public Habilidades m_Habilidades;
	
/*	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}*/
	public String getNomeDoCurso() {
		return nomeDoCurso;
	}
	public void setNomeDoCurso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}
	/*public Habilidades getM_Habilidades() {
		return m_Habilidades;
	}
	public void setM_Habilidades(Habilidades m_Habilidades) {
		this.m_Habilidades = m_Habilidades;
	}*/

}