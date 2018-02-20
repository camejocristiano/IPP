package br.net.ipp.models.configuracoes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Agendamento extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String data;
	
	private Integer dia;
	private Integer mes;
	private Integer ano;
	private Integer hora;
	private Integer minuto;
	
	private String titulo;
	private String descricao;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "agendamento_usuario", 
      joinColumns = @JoinColumn(name = "agendamento_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "usuario_id", 
      referencedColumnName = "id"))
	private List<Usuario> usuariosEnvolvidos;
	@ManyToOne
	private Usuario usuarioResponsavel;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getHora() {
		return hora;
	}
	public void setHora(Integer hora) {
		this.hora = hora;
	}
	public Integer getMinuto() {
		return minuto;
	}
	public void setMinuto(Integer minuto) {
		this.minuto = minuto;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Usuario> getUsuariosEnvolvidos() {
		return usuariosEnvolvidos;
	}
	public void setUsuariosEnvolvidos(List<Usuario> usuariosEnvolvidos) {
		this.usuariosEnvolvidos = usuariosEnvolvidos;
	}
	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}
	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}