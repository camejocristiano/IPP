package br.net.ipp.configuracoes;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.net.ipp.daos.configuracoes.GrupoDePermissoesRepository;
import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.enums.Status;
import br.net.ipp.models.configuracoes.GrupoDePermissoes;
import br.net.ipp.models.configuracoes.Unidade;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrupoDePermissoesRepositoryTest {

	@Autowired
	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createShouldPersistData() {
		GrupoDePermissoes grupoDePermissoes = new GrupoDePermissoes();
		grupoDePermissoes.setGrupo("TestGrupo");
		grupoDePermissoes.setStatus(Status.ATIVO);
		
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
	    this.unidadeRepository.save(unidade);
	    
		grupoDePermissoes.setUnidade(unidade);

		grupoDePermissoes.setGrupoDePermissoesCadastrar(true);
		grupoDePermissoes.setGrupoDePermissoesEditar(true);
		grupoDePermissoes.setGrupoDePermissoesListar(true);
		grupoDePermissoes.setGrupoDePermissoesVisualizar(true);

		grupoDePermissoes.setUsuarioCadastrar(true);
		grupoDePermissoes.setUsuarioEditar(true);
		grupoDePermissoes.setUsuarioListar(true);
		grupoDePermissoes.setUsuarioVisualizar(true);
		
		grupoDePermissoes.setCanalCadastrar(true);
		grupoDePermissoes.setCanalEditar(true);
		grupoDePermissoes.setCanalListar(true);
		grupoDePermissoes.setCanalVisualizar(true);
		
		grupoDePermissoes.setUnidadeCadastrar(true);
		grupoDePermissoes.setUnidadeEditar(true);
		grupoDePermissoes.setUnidadeListar(true);
		grupoDePermissoes.setUnidadeVisualizar(true);
		
		grupoDePermissoes.setArquivoCadastrar(true);
		grupoDePermissoes.setArquivoEditar(true);
		grupoDePermissoes.setArquivoListar(true);
		grupoDePermissoes.setArquivoVisualizar(true);

		grupoDePermissoes.setAgendamentoCadastrar(true);
		grupoDePermissoes.setAgendamentoEditar(true);
		grupoDePermissoes.setAgendamentoListar(true);
		grupoDePermissoes.setAgendamentoVisualizar(true);
		
		this.grupoDePermissoesRepository.save(grupoDePermissoes);
		
		assertThat(grupoDePermissoes.getGrupo()).isEqualTo("TestGrupo");
		assertThat(grupoDePermissoes.getStatus()).isEqualTo(Status.ATIVO);
		assertThat(grupoDePermissoes.getUnidade()).isEqualTo(unidade);

		assertThat(grupoDePermissoes.isGrupoDePermissoesCadastrar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isGrupoDePermissoesEditar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isGrupoDePermissoesListar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isGrupoDePermissoesVisualizar()).isEqualTo(true);

		assertThat(grupoDePermissoes.isUsuarioCadastrar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isUsuarioEditar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isUsuarioListar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isUsuarioVisualizar()).isEqualTo(true);
		
		assertThat(grupoDePermissoes.isCanalCadastrar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isCanalEditar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isCanalListar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isCanalVisualizar()).isEqualTo(true);
		
		assertThat(grupoDePermissoes.isUnidadeCadastrar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isUnidadeEditar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isUnidadeListar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isUnidadeVisualizar()).isEqualTo(true);
		
		assertThat(grupoDePermissoes.isArquivoCadastrar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isArquivoEditar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isArquivoListar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isArquivoVisualizar()).isEqualTo(true);

		assertThat(grupoDePermissoes.isAgendamentoCadastrar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isAgendamentoEditar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isAgendamentoListar()).isEqualTo(true);
		assertThat(grupoDePermissoes.isAgendamentoVisualizar()).isEqualTo(true);
		
		this.grupoDePermissoesRepository.delete(grupoDePermissoes);
		this.unidadeRepository.delete(unidade);
	}
	
	@Test
	public void deleteShouldRemoveData() {
		GrupoDePermissoes grupoDePermissoes = new GrupoDePermissoes();
		grupoDePermissoes.setGrupo("TestGrupo");
		grupoDePermissoes.setStatus(Status.ATIVO);
		
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
	    this.unidadeRepository.save(unidade);
	    
		grupoDePermissoes.setUnidade(unidade);

		grupoDePermissoes.setGrupoDePermissoesCadastrar(true);
		grupoDePermissoes.setGrupoDePermissoesEditar(true);
		grupoDePermissoes.setGrupoDePermissoesListar(true);
		grupoDePermissoes.setGrupoDePermissoesVisualizar(true);

		grupoDePermissoes.setUsuarioCadastrar(true);
		grupoDePermissoes.setUsuarioEditar(true);
		grupoDePermissoes.setUsuarioListar(true);
		grupoDePermissoes.setUsuarioVisualizar(true);
		
		grupoDePermissoes.setCanalCadastrar(true);
		grupoDePermissoes.setCanalEditar(true);
		grupoDePermissoes.setCanalListar(true);
		grupoDePermissoes.setCanalVisualizar(true);
		
		grupoDePermissoes.setUnidadeCadastrar(true);
		grupoDePermissoes.setUnidadeEditar(true);
		grupoDePermissoes.setUnidadeListar(true);
		grupoDePermissoes.setUnidadeVisualizar(true);
		
		grupoDePermissoes.setArquivoCadastrar(true);
		grupoDePermissoes.setArquivoEditar(true);
		grupoDePermissoes.setArquivoListar(true);
		grupoDePermissoes.setArquivoVisualizar(true);

		grupoDePermissoes.setAgendamentoCadastrar(true);
		grupoDePermissoes.setAgendamentoEditar(true);
		grupoDePermissoes.setAgendamentoListar(true);
		grupoDePermissoes.setAgendamentoVisualizar(true);
		
		this.grupoDePermissoesRepository.save(grupoDePermissoes);
		
		this.grupoDePermissoesRepository.delete(grupoDePermissoes);
		this.unidadeRepository.delete(unidade);
		
		assertThat(grupoDePermissoesRepository.findOne(unidade.getId())).isNull();
		assertThat(unidadeRepository.findOne(unidade.getId())).isNull();
	}
	
	@Test
	public void updateShouldPersistData() {
		GrupoDePermissoes grupoDePermissoes = new GrupoDePermissoes();
		grupoDePermissoes.setGrupo("TestGrupo");
		grupoDePermissoes.setStatus(Status.ATIVO);
		
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
	    this.unidadeRepository.save(unidade);
	    
		grupoDePermissoes.setUnidade(unidade);

		grupoDePermissoes.setGrupoDePermissoesCadastrar(true);
		grupoDePermissoes.setGrupoDePermissoesEditar(true);
		grupoDePermissoes.setGrupoDePermissoesListar(true);
		grupoDePermissoes.setGrupoDePermissoesVisualizar(true);

		grupoDePermissoes.setUsuarioCadastrar(true);
		grupoDePermissoes.setUsuarioEditar(true);
		grupoDePermissoes.setUsuarioListar(true);
		grupoDePermissoes.setUsuarioVisualizar(true);
		
		grupoDePermissoes.setCanalCadastrar(true);
		grupoDePermissoes.setCanalEditar(true);
		grupoDePermissoes.setCanalListar(true);
		grupoDePermissoes.setCanalVisualizar(true);
		
		grupoDePermissoes.setUnidadeCadastrar(true);
		grupoDePermissoes.setUnidadeEditar(true);
		grupoDePermissoes.setUnidadeListar(true);
		grupoDePermissoes.setUnidadeVisualizar(true);
		
		grupoDePermissoes.setArquivoCadastrar(true);
		grupoDePermissoes.setArquivoEditar(true);
		grupoDePermissoes.setArquivoListar(true);
		grupoDePermissoes.setArquivoVisualizar(true);

		grupoDePermissoes.setAgendamentoCadastrar(true);
		grupoDePermissoes.setAgendamentoEditar(true);
		grupoDePermissoes.setAgendamentoListar(true);
		grupoDePermissoes.setAgendamentoVisualizar(true);
		
		GrupoDePermissoes grupoDePermissoes2 = new GrupoDePermissoes();
		
		grupoDePermissoes2.setGrupo("TestGrupo2");
		grupoDePermissoes2.setStatus(Status.INATIVO);
		
		grupoDePermissoes2.setUnidade(unidade);

		grupoDePermissoes2.setGrupoDePermissoesCadastrar(false);
		grupoDePermissoes2.setGrupoDePermissoesEditar(false);
		grupoDePermissoes2.setGrupoDePermissoesListar(false);
		grupoDePermissoes2.setGrupoDePermissoesVisualizar(false);

		grupoDePermissoes2.setUsuarioCadastrar(false);
		grupoDePermissoes2.setUsuarioEditar(false);
		grupoDePermissoes2.setUsuarioListar(false);
		grupoDePermissoes2.setUsuarioVisualizar(false);
		
		grupoDePermissoes2.setCanalCadastrar(false);
		grupoDePermissoes2.setCanalEditar(false);
		grupoDePermissoes2.setCanalListar(false);
		grupoDePermissoes2.setCanalVisualizar(false);
		
		grupoDePermissoes2.setUnidadeCadastrar(false);
		grupoDePermissoes2.setUnidadeEditar(false);
		grupoDePermissoes2.setUnidadeListar(false);
		grupoDePermissoes2.setUnidadeVisualizar(false);
		
		grupoDePermissoes2.setArquivoCadastrar(false);
		grupoDePermissoes2.setArquivoEditar(false);
		grupoDePermissoes2.setArquivoListar(false);
		grupoDePermissoes2.setArquivoVisualizar(false);

		grupoDePermissoes2.setAgendamentoCadastrar(false);
		grupoDePermissoes2.setAgendamentoEditar(false);
		grupoDePermissoes2.setAgendamentoListar(false);
		grupoDePermissoes2.setAgendamentoVisualizar(false);
		
		grupoDePermissoes = this.grupoDePermissoesRepository.save(grupoDePermissoes2);
		
		assertThat(grupoDePermissoes.getGrupo()).isEqualTo("TestGrupo2");
		assertThat(grupoDePermissoes.getStatus()).isEqualTo(Status.INATIVO);
		assertThat(grupoDePermissoes.getUnidade()).isEqualTo(unidade);

		assertThat(grupoDePermissoes.isGrupoDePermissoesCadastrar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isGrupoDePermissoesEditar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isGrupoDePermissoesListar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isGrupoDePermissoesVisualizar()).isEqualTo(false);

		assertThat(grupoDePermissoes.isUsuarioCadastrar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isUsuarioEditar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isUsuarioListar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isUsuarioVisualizar()).isEqualTo(false);
		
		assertThat(grupoDePermissoes.isCanalCadastrar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isCanalEditar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isCanalListar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isCanalVisualizar()).isEqualTo(false);
		
		assertThat(grupoDePermissoes.isUnidadeCadastrar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isUnidadeEditar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isUnidadeListar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isUnidadeVisualizar()).isEqualTo(false);
		
		assertThat(grupoDePermissoes.isArquivoCadastrar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isArquivoEditar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isArquivoListar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isArquivoVisualizar()).isEqualTo(false);

		assertThat(grupoDePermissoes.isAgendamentoCadastrar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isAgendamentoEditar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isAgendamentoListar()).isEqualTo(false);
		assertThat(grupoDePermissoes.isAgendamentoVisualizar()).isEqualTo(false);
		
		this.grupoDePermissoesRepository.delete(grupoDePermissoes2);
		this.grupoDePermissoesRepository.delete(grupoDePermissoes);
		this.unidadeRepository.delete(unidade);
	}

}