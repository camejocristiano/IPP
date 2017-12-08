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

import br.net.ipp.jpa.model.configuracoes.Unidade;
import br.net.ipp.jpa.model.enums.Status;
import br.net.ipp.jpa.repository.configuracoes.UnidadeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UnidadeEndpointTest {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	@MockBean
	private UnidadeRepository unidadeRepository;
	@Autowired
	private MockMvc mockMvc;

	@TestConfiguration
	static class Config {
		@Bean
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder();
		}
	}

	@Before
	public void setup() {
		Unidade unidade = new Unidade();
		unidade.setRazaoSocial("IPPTest");
		unidade.setEmail("email@test.com");
		unidade.setNomeFantazia("nomeFantazia");
		unidade.setStatus(Status.ATIVO);
		unidade.setcNPJ("99.999.999 / 0001 - 99");
		unidade.setFax("(11) 999 999 999");
		unidade.setTelefone("(11) 999 999 999");
		unidade.setDataDeCadastro(Calendar.getInstance().getTime());
		unidade.setEndereco("Teste de Endereço");
		unidade.setNumero("123");
		unidade.setComplemento("complemento");
		unidade.setBairro("Centro");
		unidade.setCidade("São Paulo");
		unidade.setEstado("São Paulo");
		unidade.setcEP("00000-000");
		BDDMockito.when(unidadeRepository.findOne(unidade.getId())).thenReturn(unidade);
	}

	@Test
	public void listUnidadesStatusCode200() {
		System.out.println(port);
		ResponseEntity<String> response = restTemplate.getForEntity("/unidades", String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}

}
