package br.net.ipp.security.endpoint;

import static java.util.Arrays.asList;
import static org.springframework.http.HttpMethod.DELETE;

import java.util.List;

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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.net.ipp.security.model.User;
import br.net.ipp.security.repository.UserRepository;

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
    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class Config {
        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder().basicAuthorization("ipp", "ipp");
        }
    }

    @Before
    public void setup() {
        User user = new User(1L, "username0", "password0", "nome0", true );
        BDDMockito.when(userRepository.findOne(user.getId())).thenReturn(user);
    }

    @Test
    public void listUsersWhenUsernameAndPasswordAreCorrectShouldReturnStatusCode200() {
        List<User> users = asList(new User(1L, "username1", "password1", "nome1", true ),
                new User(2L, "username2", "password2", "nome2", false ));
        BDDMockito.when(userRepository.findAll()).thenReturn(users);
        ResponseEntity<String> response = restTemplate.getForEntity("/endpoint/admin/users/", String.class);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

}