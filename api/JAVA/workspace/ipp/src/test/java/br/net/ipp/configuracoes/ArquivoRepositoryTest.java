package br.net.ipp.configuracoes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.net.ipp.daos.configuracoes.ArquivoRepository;
import br.net.ipp.enums.LocalDoArquivo;
import br.net.ipp.models.configuracoes.Arquivo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArquivoRepositoryTest {

	@Autowired
	private ArquivoRepository arquivoRepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createShouldPersistData() {
		Arquivo arquivo = new Arquivo();
		arquivo.setNomeDoArquivo("nomeDoArquivo");
		arquivo.setUrl("/url");
		arquivo.setLocalDoArquivo(LocalDoArquivo.EMPRESA);
		
		this.arquivoRepository.save(arquivo);
		
		assertThat(arquivo.getNomeDoArquivo()).isEqualTo("nomeDoArquivo");
		assertThat(arquivo.getLocalDoArquivo()).isEqualTo(LocalDoArquivo.EMPRESA);
		assertThat(arquivo.getUrl()).isEqualTo("/url");
		
		this.arquivoRepository.delete(arquivo);
	}
	
	@Test
	public void deleteShouldRemoveData() {
		Arquivo arquivo = new Arquivo();
		arquivo.setNomeDoArquivo("nomeDoArquivo");
		arquivo.setUrl("/url");
		arquivo.setLocalDoArquivo(LocalDoArquivo.EMPRESA);
		
		this.arquivoRepository.save(arquivo);		
		this.arquivoRepository.delete(arquivo);
		
		assertThat(arquivoRepository.findOne(arquivo.getId())).isNull();
	}
	
	@Test
	public void updateShouldPersistData() {
		Arquivo arquivo = new Arquivo();
		arquivo.setNomeDoArquivo("nomeDoArquivo");
		arquivo.setUrl("/url");
		arquivo.setLocalDoArquivo(LocalDoArquivo.EMPRESA);
		
		this.arquivoRepository.save(arquivo);
		
		Arquivo arquivo2 = new Arquivo();
		arquivo2.setNomeDoArquivo("nomeDoArquivo2");
		arquivo2.setUrl("/url2");
		arquivo2.setLocalDoArquivo(LocalDoArquivo.IPP);
		
		arquivo = this.arquivoRepository.save(arquivo2);
		
		assertThat(arquivo.getNomeDoArquivo()).isEqualTo("nomeDoArquivo2");
		assertThat(arquivo.getLocalDoArquivo()).isEqualTo(LocalDoArquivo.IPP);
		assertThat(arquivo.getUrl()).isEqualTo("/url2");
		
		this.arquivoRepository.delete(arquivo2);
		this.arquivoRepository.delete(arquivo);
	}

}