package br.net.ipp.configuracoes;


import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.net.ipp.daos.configuracoes.UnidadeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnidadeRepositoryTest {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/*@Test
	public void createShouldPersistData() {
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

		assertThat(unidade.getRazaoSocial()).isEqualTo("IPPTest");
		assertThat(unidade.getEmail()).isEqualTo("email@test.com");
		assertThat(unidade.getNomeFantazia()).isEqualTo("nomeFantazia");
		assertThat(unidade.getStatus()).isEqualTo(Status.ATIVO);
		assertThat(unidade.getcNPJ()).isEqualTo("99.999.999 / 0001 - 99");
		assertThat(unidade.getFax()).isEqualTo("(11) 999 999 999");
		assertThat(unidade.getTelefone()).isEqualTo("(11) 999 999 999");
	    assertThat(unidade.getDataDeCadastro()).isToday();
	    assertThat(unidade.getEndereco()).isEqualTo("Teste de Endereço");
	    assertThat(unidade.getNumero()).isEqualTo("123");
	    assertThat(unidade.getComplemento()).isEqualTo("complemento");
	    assertThat(unidade.getBairro()).isEqualTo("Centro");
	    assertThat(unidade.getCidade()).isEqualTo("São Paulo");
	    assertThat(unidade.getEstado()).isEqualTo("São Paulo");
	    assertThat(unidade.getcEP()).isEqualTo("00000-000");
	    
	    this.unidadeRepository.delete(unidade);
	}
	
	@Test
	public void deleteShouldRemoveData() {
		Unidade unidade = new Unidade();
		unidade.setRazaoSocial("IPPTestDelete");
		unidade.setEmail("emaildelete@test.com");
		unidade.setNomeFantazia("DeleteNomeFantazia");
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
		this.unidadeRepository.delete(unidade);
		assertThat(unidadeRepository.findOne(unidade.getId())).isNull();
	}
	
	@Test
	public void updateShouldChangeAndPersistData() {
		Unidade unidade = new Unidade();
		unidade.setRazaoSocial("IPPTest");
		unidade.setEmail("email@testI.com");
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
		Unidade unidade2 = new Unidade();
		unidade2.setRazaoSocial("IPPTestII");
		unidade2.setEmail("email2@test.com");
		unidade2.setNomeFantazia("nomeFantaziaII");
		unidade2.setStatus(Status.INATIVO);
		unidade2.setcNPJ("88.888.888 / 0001 - 88");
		unidade2.setFax("(11) 888 888 888");
	    unidade2.setTelefone("(11) 888 888 888");
	    unidade2.setDataDeCadastro(Calendar.getInstance().getTime());
	    unidade2.setEndereco("Teste de EndereçoII");
	    unidade2.setNumero("123II");
	    unidade2.setComplemento("complementoII");
	    unidade2.setBairro("CentroII");
	    unidade2.setCidade("São PauloII");
	    unidade2.setEstado("São PauloII");
	    unidade2.setcEP("00000-000II");	    
		this.unidadeRepository.save(unidade2);
		this.unidadeRepository.delete(unidade);
		unidade = this.unidadeRepository.findOne(unidade2.getId());
		assertThat(unidade.getRazaoSocial()).isEqualTo("IPPTestII");
		assertThat(unidade.getEmail()).isEqualTo("email2@test.com");
		assertThat(unidade.getNomeFantazia()).isEqualTo("nomeFantaziaII");
		assertThat(unidade.getStatus()).isEqualTo(Status.INATIVO);
		assertThat(unidade.getcNPJ()).isEqualTo("88.888.888 / 0001 - 88");
		assertThat(unidade.getFax()).isEqualTo("(11) 888 888 888");
		assertThat(unidade.getTelefone()).isEqualTo("(11) 888 888 888");
	    assertThat(unidade.getDataDeCadastro()).isToday();
	    assertThat(unidade.getEndereco()).isEqualTo("Teste de EndereçoII");
	    assertThat(unidade.getNumero()).isEqualTo("123II");
	    assertThat(unidade.getComplemento()).isEqualTo("complementoII");
	    assertThat(unidade.getBairro()).isEqualTo("CentroII");
	    assertThat(unidade.getCidade()).isEqualTo("São PauloII");
	    assertThat(unidade.getEstado()).isEqualTo("São PauloII");
	    assertThat(unidade.getcEP()).isEqualTo("00000-000II");
	    
        this.unidadeRepository.delete(unidade2);
	}
	
    @Test
    public void ListAll() {
		Unidade unidade = new Unidade();
		unidade.setRazaoSocial("IPPTest");
		unidade.setEmail("emaillist@test.com");
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
		
		Unidade unidade2 = new Unidade();
		unidade2.setRazaoSocial("IPPTestII");
		unidade2.setEmail("emaillist2@test.com");
		unidade2.setNomeFantazia("nomeFantaziaII");
		unidade2.setStatus(Status.INATIVO);
		unidade2.setcNPJ("88.888.888 / 0001 - 88");
		unidade2.setFax("(11) 888 888 888");
	    unidade2.setTelefone("(11) 888 888 888");
	    unidade2.setDataDeCadastro(Calendar.getInstance().getTime());
	    unidade2.setEndereco("Teste de EndereçoII");
	    unidade2.setNumero("123II");
	    unidade2.setComplemento("complementoII");
	    unidade2.setBairro("CentroII");
	    unidade2.setCidade("São PauloII");
	    unidade2.setEstado("São PauloII");
	    unidade2.setcEP("00000-000II");
	    
        this.unidadeRepository.save(unidade2);
        List<Unidade> unidadeList = (List<Unidade>) unidadeRepository.findAll();
        
        assertThat(unidadeList.size()).isEqualTo(2);
        
        this.unidadeRepository.delete(unidade);
        this.unidadeRepository.delete(unidade2);
        
        
    }
*/	
}
