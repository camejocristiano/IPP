package br.net.ipp.configuracoes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.enums.EstadoCivil;
import br.net.ipp.models.configuracoes.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository userRepository;
	Calendar c = Calendar.getInstance();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createShouldPersistData() {
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
		user.setcPF("123456789");
		user.setCurriculoResumido("Texto de currículo resumido.");
		user.setDataDeAdmissao(c.getTime());
		user.setDataDeDesligamento(c.getTime());
		user.setDataDeExpedicaoRG("01/01/2018");
		user.setDataDeNascimento(c.getTime());
		user.setDataExpedicaoCTPS(c.getTime());
		user.setDisciplina("Português");
		user.setEndereco("Rua da Alegria");
		user.setNumero("123");
		user.setEstado("São Paulo");
		user.setEstadoCivil(EstadoCivil.CASADO);
		user.setFormacao("Graduação");
		
		this.userRepository.save(user);

		assertThat(user.getNome()).isEqualTo("IPPTest");
		assertThat(user.getUsername()).isEqualTo("ipptest");
		assertThat(user.getPassword()).isEqualTo("ipptest");
		assertThat(user.getEmail()).isEqualTo("emailusuariocadastrando@teste.com");
		assertThat(user.getBairro()).isEqualTo("Centro");
		assertThat(user.getCargo()).isEqualTo("Cargo");
		assertThat(user.getCelular()).isEqualTo("(11) 999 999 999");
		assertThat(user.getcEP()).isEqualTo("99999-9999");
		assertThat(user.getCidade()).isEqualTo("São Paulo");
		assertThat(user.getcNPJMEI()).isEqualTo("99.999.999/0001-99");
		assertThat(user.getComplemento()).isEqualTo("complemento");
		assertThat(user.getcPF()).isEqualTo(123456789);
		assertThat(user.getCurriculoResumido()).isEqualTo("Texto de currículo resumido.");
		assertThat(user.getDataDeAdmissao()).isToday();
		assertThat(user.getDataDeDesligamento()).isToday();
		assertThat(user.getDataDeExpedicaoRG()).isEqualTo("01/01/2018");
		assertThat(user.getDataDeNascimento()).isToday();
		assertThat(user.getDataExpedicaoCTPS()).isToday();
		assertThat(user.getDisciplina()).isEqualTo("Português");
		assertThat(user.getEndereco()).isEqualTo("Rua da Alegria");
		assertThat(user.getNumero()).isEqualTo("123");
		assertThat(user.getEstado()).isEqualTo("São Paulo");
		assertThat(user.getEstadoCivil()).isEqualTo(EstadoCivil.CASADO);
		assertThat(user.getFormacao()).isEqualTo("Graduação");
		
		this.userRepository.delete(user);
	}
	
	@Test
	public void deleteShouldRemoveData() {
		Usuario user = new Usuario();
		user.setNome("IPPTest");
		user.setUsername("ipptest");
		user.setPassword("ipptest");
		user.setEmail("emailusuariodeletando@teste.com");
		user.setBairro("Centro");
		user.setCargo("Cargo");
		user.setCelular("(11) 999 999 999");
		user.setcEP("99999-9999");
		user.setCidade("São Paulo");
		user.setcNPJMEI("99.999.999/0001-99");
		user.setComplemento("complemento");
		user.setcPF("123456789");
		user.setCurriculoResumido("Texto de currículo resumido.");
		user.setDataDeAdmissao(c.getTime());
		user.setDataDeDesligamento(c.getTime());
		user.setDataDeExpedicaoRG("01/01/2018");
		user.setDataDeNascimento(c.getTime());
		user.setDataExpedicaoCTPS(c.getTime());
		user.setDisciplina("Português");
		user.setEndereco("Rua da Alegria");
		user.setNumero("123");
		user.setEstado("São Paulo");
		user.setEstadoCivil(EstadoCivil.CASADO);
		user.setFormacao("Graduação");
		this.userRepository.save(user);
		this.userRepository.delete(user);
		assertThat(userRepository.findOne(user.getId())).isNull();
	}
	
	@Test
	public void updateShouldChangeAndPersistData() {
		Usuario user = new Usuario();
		user.setNome("IPPTest");
		user.setUsername("ipptest");
		user.setPassword("ipptest");
		user.setEmail("emailusuariocadastro@teste.com");
		user.setBairro("Centro");
		user.setCargo("Cargo");
		user.setCelular("(11) 999 999 999");
		user.setcEP("99999-9999");
		user.setCidade("São Paulo");
		user.setcNPJMEI("99.999.999/0001-99");
		user.setComplemento("complemento");
		user.setcPF("123456789");
		user.setCurriculoResumido("Texto de currículo resumido.");
		user.setDataDeAdmissao(c.getTime());
		user.setDataDeDesligamento(c.getTime());
		user.setDataDeExpedicaoRG("01/01/2018");
		user.setDataDeNascimento(c.getTime());
		user.setDataExpedicaoCTPS(c.getTime());
		user.setDisciplina("Português");
		user.setEndereco("Rua da Alegria");
		user.setNumero("123");
		user.setEstado("São Paulo");
		user.setEstadoCivil(EstadoCivil.CASADO);
		user.setFormacao("Graduação");
		this.userRepository.save(user);
		Usuario user2 = new Usuario();
		user2.setNome("IPPTestUpdate");
		user2.setUsername("ipptestUpdate");
		user2.setPassword("ipptestUpdate");
		user2.setEmail("emailusuarioupdate@teste.com");
		user2.setBairro("Centro Update");
		user2.setCargo("Cargo Update");
		user2.setCelular("(11) 888 888 888");
		user2.setcEP("88888-8888");
		user2.setCidade("São Paulo Update");
		user2.setcNPJMEI("88.888.888/0001-88");
		user2.setComplemento("complemento Update");
		user2.setcPF("123456789");
		user2.setCurriculoResumido("Texto de currículo resumido Update.");
		user2.setDataDeAdmissao(c.getTime());
		user2.setDataDeDesligamento(c.getTime());
		user2.setDataDeExpedicaoRG("02/02/2018");
		user2.setDataDeNascimento(c.getTime());
		user2.setDataExpedicaoCTPS(c.getTime());
		user2.setDisciplina("Português Update");
		user2.setEndereco("Rua da Alegria Update");
		user2.setNumero("123888");
		user2.setEstado("São Paulo Update");
		user2.setEstadoCivil(EstadoCivil.SOLTEIRO);
		user2.setFormacao("Graduação Update");
		this.userRepository.delete(user);
		this.userRepository.save(user2);
		user = this.userRepository.findOne(user2.getId());

		assertThat(user.getNome()).isEqualTo("IPPTestUpdate");
		assertThat(user.getUsername()).isEqualTo("ipptestUpdate");
		assertThat(user.getPassword()).isEqualTo("ipptestUpdate");
		assertThat(user.getEmail()).isEqualTo("emailusuarioupdate@teste.com");
		assertThat(user.getBairro()).isEqualTo("Centro Update");
		assertThat(user.getCargo()).isEqualTo("Cargo Update");
		assertThat(user.getCelular()).isEqualTo("(11) 888 888 888");
		assertThat(user.getcEP()).isEqualTo("88888-8888");
		assertThat(user.getCidade()).isEqualTo("São Paulo Update");
		assertThat(user.getcNPJMEI()).isEqualTo("88.888.888/0001-88");
		assertThat(user.getComplemento()).isEqualTo("complemento Update");
		assertThat(user.getcPF()).isEqualTo(123456789);
		assertThat(user.getCurriculoResumido()).isEqualTo("Texto de currículo resumido Update.");
		assertThat(user.getDataDeAdmissao()).isToday();
		assertThat(user.getDataDeDesligamento()).isToday();
		assertThat(user.getDataDeExpedicaoRG()).isEqualTo("02/02/2018");
		assertThat(user.getDataDeNascimento()).isToday();
		assertThat(user.getDataExpedicaoCTPS()).isToday();
		assertThat(user.getDisciplina()).isEqualTo("Português Update");
		assertThat(user.getEndereco()).isEqualTo("Rua da Alegria Update");
		assertThat(user.getNumero()).isEqualTo("123888");
		assertThat(user.getEstado()).isEqualTo("São Paulo Update");
		assertThat(user.getEstadoCivil()).isEqualTo(EstadoCivil.SOLTEIRO);
		assertThat(user.getFormacao()).isEqualTo("Graduação Update");
		
		this.userRepository.delete(user);
	}
	
	@Test
    public void ListAll() {
		Usuario user = new Usuario();
		user.setNome("IPPTest");
		user.setUsername("ipptest");
		user.setPassword("ipptest");
		user.setEmail("emailusuariolist@teste.com");
		user.setBairro("Centro");
		user.setCargo("Cargo");
		user.setCelular("(11) 999 999 999");
		user.setcEP("99999-9999");
		user.setCidade("São Paulo");
		user.setcNPJMEI("99.999.999/0001-99");
		user.setComplemento("complemento");
		user.setcPF("123456789");
		user.setCurriculoResumido("Texto de currículo resumido.");
		user.setDataDeAdmissao(c.getTime());
		user.setDataDeDesligamento(c.getTime());
		user.setDataDeExpedicaoRG("01/01/2018");
		user.setDataDeNascimento(c.getTime());
		user.setDataExpedicaoCTPS(c.getTime());
		user.setDisciplina("Português");
		user.setEndereco("Rua da Alegria");
		user.setNumero("123");
		user.setEstado("São Paulo");
		user.setEstadoCivil(EstadoCivil.CASADO);
		user.setFormacao("Graduação");
		this.userRepository.save(user);
		Usuario user2 = new Usuario();
		user2.setNome("IPPTestUpdate");
		user2.setUsername("ipptestUpdate");
		user2.setPassword("ipptestUpdate");
		user2.setEmail("emailusuariolist2@teste.com");
		user2.setBairro("Centro Update");
		user2.setCargo("Cargo Update");
		user2.setCelular("(11) 888 888 888");
		user2.setcEP("88888-8888");
		user2.setCidade("São Paulo Update");
		user2.setcNPJMEI("88.888.888/0001-88");
		user2.setComplemento("complemento Update");
		user2.setcPF("123456789");
		user2.setCurriculoResumido("Texto de currículo resumido Update.");
		user2.setDataDeAdmissao(c.getTime());
		user2.setDataDeDesligamento(c.getTime());
		user2.setDataDeExpedicaoRG("02/02/2018");
		user2.setDataDeNascimento(c.getTime());
		user2.setDataExpedicaoCTPS(c.getTime());
		user2.setDisciplina("Português Update");
		user2.setEndereco("Rua da Alegria Update");
		user2.setNumero("123888");
		user2.setEstado("São Paulo Update");
		user2.setEstadoCivil(EstadoCivil.SOLTEIRO);
		user2.setFormacao("Graduação Update");
        this.userRepository.save(user2);
        List<Usuario> userList = (List<Usuario>) userRepository.findAll();
        assertThat(userList.size()).isEqualTo(2);
        
        this.userRepository.delete(user);
        this.userRepository.delete(user2);
    }
	
}
