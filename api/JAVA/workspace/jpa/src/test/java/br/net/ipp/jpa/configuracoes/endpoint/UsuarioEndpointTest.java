package br.net.ipp.jpa.configuracoes.endpoint;

import java.util.Calendar;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.net.ipp.jpa.model.configuracoes.Usuario;
import br.net.ipp.jpa.model.enums.EstadoCivil;
import br.net.ipp.jpa.repository.configuracoes.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UsuarioEndpointTest {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	@MockBean
	private UsuarioRepository userRepository;
	@Autowired
	private MockMvc mockMvc;
	Calendar c = Calendar.getInstance();

	@TestConfiguration
	static class Config {
		@Bean
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder();
		}
	}

	@Before
	public void setup() {
		Usuario user = new Usuario();
		user.setNome("IPPTest");
		user.setUsername("ipptest");
		user.setPassword("ipptest");
		user.setEmail("emailusuariocadastrando@teste.com");
		user.setBairro("Centro");
		user.setCargo("Cargo");
		user.setCelular("(11) 999 999 999");
		user.setcEP("99999-9999");
		user.setCidade("São Paulo");
		user.setcNPJMEI("99.999.999/0001-99");
		user.setComplemento("complemento");
		user.setcPF(123456789);
		user.setCurriculoResumido("Texto de currículo resumido.");
		user.setDataDeAdmissao(c.getTime());
		user.setDataDeDesligamento(c.getTime());
		user.setDataDeExpedicao("01/01/2018");
		user.setDataDeNascimento(c.getTime());
		user.setDataExpedicaoCTPS(c.getTime());
		user.setDisciplina("Português");
		user.setEndereco("Rua da Alegria");
		user.setNumero("123");
		user.setEstado("São Paulo");
		user.setEstadoCivil(EstadoCivil.CASADO);
		user.setFormacao("Graduação");
		
		BDDMockito.when(userRepository.findOne(user.getId())).thenReturn(user);
	}
	
	@Test
	public void listUsuariosStatusCode200() {
		System.out.println(port);
		ResponseEntity<String> response = restTemplate.getForEntity("/usuarios", String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}

}
