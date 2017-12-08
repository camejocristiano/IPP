package br.net.ipp.testes;

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

import br.net.ipp.testes.model.User;
import br.net.ipp.testes.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserEndpointTest {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	@MockBean
	private UserRepository userRepository;

	@TestConfiguration
	static class Config {
		@Bean
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder().basicAuthorization("ipp", "ipp");
		}
	}

	@Before
	public void setup() {
		User user = new User();
		user.setNome("IPP");
		user.setUsername("ipp");
		user.setPassword("ipp");
		
		BDDMockito.when(userRepository.findOne(user.getId())).thenReturn(user);
	}
	
	@Test
    public void listUsersWhenUsernameAndPasswordAreIncorrectShouldReturnStatusCode401() {
        System.out.println(port);
        restTemplate = restTemplate.withBasicAuth("1", "1");
        ResponseEntity<String> response = restTemplate.getForEntity("/admin/users", String.class);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(401);
    }
	
	@Test
    public void listUsersWhenUsernameAndPasswordAreCorrectShouldReturnStatusCode200() {
        System.out.println(port);
        restTemplate = restTemplate.withBasicAuth("ipp", "ipp");
        ResponseEntity<String> response = restTemplate.getForEntity("/admin/users", String.class);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(401);
    }

}