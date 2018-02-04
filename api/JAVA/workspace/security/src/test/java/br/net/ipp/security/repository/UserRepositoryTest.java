package br.net.ipp.security.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.net.ipp.security.model.GrupoDePermissoes;
import br.net.ipp.security.model.User;
import br.net.ipp.security.repository.GrupoDePermissoesRepository;
import br.net.ipp.security.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createShouldPersistData() {
		User user = new User();
		user.setEmail("IPP");
		user.setUsername("ipp");
		user.setPassword("ipp");
		user.setAdmin(true);
		GrupoDePermissoes grupoDePermissoes = new GrupoDePermissoes();
		grupoDePermissoes.setGrupo("TestGrupo");
		grupoDePermissoes.setUsuarioCadastrar(true);
		grupoDePermissoes.setUsuarioEditar(true);
		grupoDePermissoes.setUsuarioListar(true);
		grupoDePermissoes.setUsuarioVisualizar(true);
		this.grupoDePermissoesRepository.save(grupoDePermissoes);
		user.setGrupoDePermissoes(grupoDePermissoes);
		this.userRepository.save(user);
		assertThat(user.getId()).isNotNull();
		assertThat(user.getEmail()).isEqualTo("IPP");
		assertThat(user.getUsername()).isEqualTo("ipp");
		assertThat(user.getPassword()).isEqualTo("ipp");
		assertThat(user.getGrupoDePermissoes()).isEqualTo(grupoDePermissoes);
		assertThat(user.isAdmin()).isTrue();
		
		this.userRepository.delete(user);
		this.grupoDePermissoesRepository.delete(grupoDePermissoes);
	}
	
	@Test
	public void deleteShouldRemoveData() {
		User user = new User();
		user.setEmail("IPP");
		user.setUsername("ipp");
		user.setPassword("ipp");
		user.setAdmin(true);
		GrupoDePermissoes grupoDePermissoes = new GrupoDePermissoes();
		grupoDePermissoes.setGrupo("TestGrupo");
		grupoDePermissoes.setUsuarioCadastrar(true);
		grupoDePermissoes.setUsuarioEditar(true);
		grupoDePermissoes.setUsuarioListar(true);
		grupoDePermissoes.setUsuarioVisualizar(true);
		
		this.grupoDePermissoesRepository.save(grupoDePermissoes);
		user.setGrupoDePermissoes(grupoDePermissoes);
		this.userRepository.save(user);
		
		this.userRepository.delete(user);
		this.grupoDePermissoesRepository.delete(grupoDePermissoes);
		
		assertThat(userRepository.findOne(user.getId())).isNull();
	}
	
	@Test
	public void updateShouldPersistData() {
		User user = new User();
		user.setEmail("IPP");
		user.setUsername("ipp");
		user.setPassword("ipp");
		user.setAdmin(true);
		GrupoDePermissoes grupoDePermissoes = new GrupoDePermissoes();
		grupoDePermissoes.setGrupo("TestGrupo");
		grupoDePermissoes.setUsuarioCadastrar(true);
		grupoDePermissoes.setUsuarioEditar(true);
		grupoDePermissoes.setUsuarioListar(true);
		grupoDePermissoes.setUsuarioVisualizar(true);
		this.grupoDePermissoesRepository.save(grupoDePermissoes);
		user.setGrupoDePermissoes(grupoDePermissoes);
		this.userRepository.save(user);
		
		User user2 = new User();
		user2.setEmail("IPP2");
		user2.setUsername("ipp2");
		user2.setPassword("ipp2");
		user2.setAdmin(false);
		user2.setGrupoDePermissoes(grupoDePermissoes);
		
		user = this.userRepository.findOne(user.getId());
		this.userRepository.delete(user);
		user = this.userRepository.save(user2);
		
		assertThat(user.getId()).isNotNull();
		assertThat(user.getEmail()).isEqualTo("IPP2");
		assertThat(user.getUsername()).isEqualTo("ipp2");
		assertThat(user.getPassword()).isEqualTo("ipp2");
		assertThat(user.getGrupoDePermissoes()).isEqualTo(grupoDePermissoes);
		assertThat(user.isAdmin()).isFalse();
		
		this.userRepository.delete(user2);
		this.userRepository.delete(user);
		this.grupoDePermissoesRepository.delete(grupoDePermissoes);
	}

}