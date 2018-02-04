package br.net.ipp.jpa.configuracoes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.net.ipp.jpa.model.configuracoes.Agendamento;
import br.net.ipp.jpa.model.configuracoes.Usuario;
import br.net.ipp.jpa.model.enums.EstadoCivil;
import br.net.ipp.jpa.repository.configuracoes.AgendamentoRepository;
import br.net.ipp.jpa.repository.configuracoes.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendamentoRepositoryTest {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
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
		this.userRepository.save(user);
		
		Agendamento agendamento = new Agendamento();
	    agendamento.setDescricao("Descrição do agendamento!");	
	    agendamento.setTempoPrevisto("2 horas");
	    agendamento.setUsuario(user);
	    agendamento.setData(c.getTime());
	    agendamento.setHora(c.getTime());
		
		this.agendamentoRepository.save(agendamento);

		assertThat(agendamento.getDescricao()).isEqualTo("Descrição do agendamento!");	
	    assertThat(agendamento.getTempoPrevisto()).isEqualTo("2 horas");
	    assertThat(agendamento.getUsuario()).isEqualTo(user);
	    assertThat(agendamento.getData()).isToday();
	    assertThat(agendamento.getHora()).isToday();

	    this.agendamentoRepository.delete(agendamento);
	    this.userRepository.delete(user);
	}
	
	@Test
	public void deleteShouldRemoveData() {
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
		this.userRepository.save(user);
		
		Agendamento agendamento = new Agendamento();
	    agendamento.setDescricao("Descrição do agendamento!");	
	    agendamento.setTempoPrevisto("2 horas");
	    agendamento.setUsuario(user);
	    agendamento.setData(c.getTime());
	    agendamento.setHora(c.getTime());
		
		this.agendamentoRepository.save(agendamento);

	    this.agendamentoRepository.delete(agendamento);
	    this.userRepository.delete(user);
		assertThat(agendamentoRepository.findOne(agendamento.getId())).isNull();
	}
	
	@Test
	public void updateShouldChangeAndPersistData() {
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
		this.userRepository.save(user);
		
		Agendamento agendamento = new Agendamento();
	    agendamento.setDescricao("Descrição do agendamento!");	
	    agendamento.setTempoPrevisto("2 horas");
	    agendamento.setUsuario(user);
	    agendamento.setData(c.getTime());
	    agendamento.setHora(c.getTime());
		
		this.agendamentoRepository.save(agendamento);
		
		Agendamento agendamento2 = new Agendamento();
	    agendamento2.setDescricao("Descrição do agendamento 2!");	
	    agendamento2.setTempoPrevisto("4 horas");
	    agendamento2.setUsuario(user);
	    agendamento2.setData(c.getTime());
	    agendamento2.setHora(c.getTime());
		
		this.agendamentoRepository.save(agendamento2);
		this.agendamentoRepository.delete(agendamento);
		agendamento = this.agendamentoRepository.findOne(agendamento2.getId());

		assertThat(agendamento.getDescricao()).isEqualTo("Descrição do agendamento 2!");	
	    assertThat(agendamento.getTempoPrevisto()).isEqualTo("4 horas");
	    assertThat(agendamento.getUsuario()).isEqualTo(user);
	    assertThat(agendamento.getData()).isToday();
	    assertThat(agendamento.getHora()).isToday();
		
	    this.agendamentoRepository.delete(agendamento);
		this.userRepository.delete(user);
	}
}
