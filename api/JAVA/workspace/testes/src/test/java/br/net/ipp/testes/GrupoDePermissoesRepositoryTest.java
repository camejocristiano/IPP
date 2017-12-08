package br.net.ipp.testes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.net.ipp.testes.model.GrupoDePermissoes;
import br.net.ipp.testes.repository.GrupoDePermissoesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrupoDePermissoesRepositoryTest {

	@Autowired
	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createShouldPersistData() {
		GrupoDePermissoes grupoDePermissoes = new GrupoDePermissoes();
		grupoDePermissoes.setGrupo("TestGrupo");
		
		grupoDePermissoes.setUsuarioCadastrar(true);
		grupoDePermissoes.setUsuarioEditar(true);
		grupoDePermissoes.setUsuarioListar(true);
		grupoDePermissoes.setUsuarioVisualizar(true);
		
		this.grupoDePermissoesRepository.save(grupoDePermissoes);
		
		assertThat(grupoDePermissoes.getGrupo()).isEqualTo("TestGrupo");

		assertThat(grupoDePermissoes.isUsuarioCadastrar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isUsuarioEditar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isUsuarioListar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isUsuarioVisualizar()).isEqualTo(true);
		
		this.grupoDePermissoesRepository.delete(grupoDePermissoes);
	}
	
	@Test
	public void deleteShouldRemoveData() {
		GrupoDePermissoes grupoDePermissoes = new GrupoDePermissoes();
		grupoDePermissoes.setGrupo("TestGrupo");
		
		grupoDePermissoes.setUsuarioCadastrar(true);
		grupoDePermissoes.setUsuarioEditar(true);
		grupoDePermissoes.setUsuarioListar(true);
		grupoDePermissoes.setUsuarioVisualizar(true);
		
		this.grupoDePermissoesRepository.save(grupoDePermissoes);
		
		this.grupoDePermissoesRepository.delete(grupoDePermissoes);
		
		assertThat(grupoDePermissoesRepository.findOne(grupoDePermissoes.getId())).isNull();
	}
	
	@Test
	public void updateShouldPersistData() {
		GrupoDePermissoes grupoDePermissoes = new GrupoDePermissoes();
		grupoDePermissoes.setGrupo("TestGrupo");

		grupoDePermissoes.setUsuarioCadastrar(true);
		grupoDePermissoes.setUsuarioEditar(true);
		grupoDePermissoes.setUsuarioListar(true);
		grupoDePermissoes.setUsuarioVisualizar(true);
		
		this.grupoDePermissoesRepository.save(grupoDePermissoes);
		
		GrupoDePermissoes grupoDePermissoes2 = new GrupoDePermissoes();
		
		grupoDePermissoes2.setGrupo("TestGrupo2");

		grupoDePermissoes2.setUsuarioCadastrar(false);
		grupoDePermissoes2.setUsuarioEditar(false);
		grupoDePermissoes2.setUsuarioListar(false);
		grupoDePermissoes2.setUsuarioVisualizar(false);
		
		grupoDePermissoes = this.grupoDePermissoesRepository.findOne(grupoDePermissoes.getId());
		this.grupoDePermissoesRepository.delete(grupoDePermissoes);
		grupoDePermissoes = this.grupoDePermissoesRepository.save(grupoDePermissoes2);
		
		assertThat(grupoDePermissoes.getGrupo()).isEqualTo("TestGrupo2");

		assertThat(grupoDePermissoes.isUsuarioCadastrar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isUsuarioEditar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isUsuarioListar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isUsuarioVisualizar()).isEqualTo(false);
		
		this.grupoDePermissoesRepository.delete(grupoDePermissoes2);
		this.grupoDePermissoesRepository.delete(grupoDePermissoes);
	}

}