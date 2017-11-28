package br.net.ipp.jpa.model.configuracoes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.net.ipp.jpa.model.AbstractEntity;
import br.net.ipp.jpa.model.enums.LocalDoArquivo;

@Entity
public class Arquivo extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String nomeDoArquivo;
	private String url;
	@Enumerated(EnumType.STRING)
	private LocalDoArquivo localDoArquivo;

	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDoArquivo getLocalDoArquivo() {
		return localDoArquivo;
	}
	public void setLocalDoArquivo(LocalDoArquivo localDoArquivo) {
		this.localDoArquivo = localDoArquivo;
	}
	public String getNomeDoArquivo() {
		return nomeDoArquivo;
	}
	public void setNomeDoArquivo(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

}
