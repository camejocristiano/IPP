package br.net.ipp.configuracoes;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.CanalRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Canal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CanalRepositoryTest {

	@Autowired
	private CanalRepository canalRepository;

	@Autowired
	private JovemRepository jovemRepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createShouldPersistData() {
		Jovem jovem = new Jovem();
		jovem.setNome("jovem");
		jovem.setUsername("jovem");
		jovem.setPassword("jovem");
		jovem.setEmail("jovem@email.com");
		this.jovemRepository.save(jovem);
		
		Canal canal = new Canal();
		canal.setCanal("Canal");
		canal.setJovem(jovem);
		this.canalRepository.save(canal);

		assertThat(canal.getCanal()).isEqualTo("Canal");
		assertThat(canal.getJovem()).isEqualTo(jovem);

		this.canalRepository.delete(canal);
		this.jovemRepository.delete(jovem);
	}
	
	@Test
	public void deleteShouldRemoveData() {
		Canal canal = new Canal();
		canal.setCanal("Canal");
		Jovem jovem = new Jovem();
		jovem.setNome("jovem");
		jovem.setUsername("jovem");
		jovem.setPassword("jovem");
		jovem.setEmail("jovem@email.com");
		this.jovemRepository.save(jovem);
		canal.setJovem(jovem);
		this.canalRepository.save(canal);

		this.canalRepository.delete(canal);
		this.jovemRepository.delete(jovem);
		
		assertThat(canalRepository.findOne(canal.getId())).isNull();
	}

}