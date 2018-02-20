package br.net.ipp.models.configuracoes;

import javax.persistence.Entity;

import br.net.ipp.enums.LocalDoArquivo;
import br.net.ipp.models.AbstractEntity;

@Entity
public class Arquivo extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String nomeDoArquivo;
	private String url;
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
