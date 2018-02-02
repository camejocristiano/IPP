package br.net.ipp.security.endpoint;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserEndpointTest {
/*    @Autowired
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
    }*/

}