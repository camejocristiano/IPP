<?php
namespace src\Entity;

use src\Entity\Usuario;

class UsuarioTest extends \PHPUnit_Framework_TestCase
{
    public function assertPreConditions()
    {
        $this->assertTrue(class_exists($class = 'src\Entity\Usuario'),
            'Class not found: ' . $class);
    }

    public function testIfGettersAndSetterHasWorking()
    {
        $usuario = new Usuario();

		$usuario->setBairro("Centro");
		$usuario->setCargo("ADMINISTRADOR");
		$usuario->setCelular("11 999 999 999");
		$usuario->setCEP("00000-000");
		$usuario->setCidade("Local");
		$usuario->setCNPJMEI("123.456.7898-14");
		$usuario->setComplemento("");
		$usuario->setCPF("999.999.999-55");
		$usuario->setCurriculoResumido("asd");
		$usuario->setDataDeAdmissao("11/11/77");
		$usuario->setDataDeDesligamento("11/11/77");
		$usuario->setDataDeExpedicao("11/11/77");
		$usuario->setDataDeNascimento("11/11/77");
		$usuario->setDataExpedicaoCTPS("11/11/77");
		$usuario->setDisciplina("Português");
		$usuario->setEmail("email@test.com");
		$usuario->setEndereco("Rua da Alegria");
		$usuario->setEstado("SP");
		$usuario->setEstadoCivil(1);
		$usuario->setFormacao("Graduado");
		$usuario->setHabilitacao("1234567");
		$usuario->setNome("Jovem Aprendiz");
		$usuario->setNumero("1234");
		$usuario->setNumeroCTPS("12345");
		$usuario->setObservacoes("observações");
		$usuario->setOrgaoEmissor("SSP");
		$usuario->setPermissoesId(1);
		$usuario->setRegiao(1);
		$usuario->setRelacaoFuncional(1);
		$usuario->setRG("123.456.78");
		$usuario->setSerieCTPS("123224-7");
		$usuario->setSexo(1);
		$usuario->setStatus(1);
		$usuario->setTelefone("11 999 999 999");
		$usuario->setUFCTPS("SP");

		$this->assertEquals("Centro", $usuario->getBairro());
		$this->assertEquals("ADMINISTRADOR", $usuario->getCargo());
		$this->assertEquals("11 999 999 999", $usuario->getCelular());
		$this->assertEquals("00000-000", $usuario->getCEP());
		$this->assertEquals("Local", $usuario->getCidade());
		$this->assertEquals("123.456.7898-14", $usuario->getCNPJMEI());
		$this->assertEquals("", $usuario->getComplemento());
		$this->assertEquals("999.999.999-55", $usuario->getCPF());
		$this->assertEquals("asd", $usuario->getCurriculoResumido("asd"));
		$this->assertEquals("11/11/77", $usuario->getDataDeAdmissao());
		$this->assertEquals("11/11/77", $usuario->getDataDeDesligamento());
		$this->assertEquals("11/11/77", $usuario->getDataDeExpedicao());
		$this->assertEquals("11/11/77", $usuario->getDataDeNascimento());
		$this->assertEquals("11/11/77", $usuario->getDataExpedicaoCTPS());
		$this->assertEquals("Português", $usuario->getDisciplina());
		$this->assertEquals("email@test.com", $usuario->getEmail());
		$this->assertEquals("Rua da Alegria", $usuario->getEndereco());
		$this->assertEquals("SP", $usuario->getEstado());
		$this->assertEquals(1, $usuario->getEstadoCivil());
		$this->assertEquals("Graduado", $usuario->getFormacao());
		$this->assertEquals("1234567", $usuario->getHabilitacao());
		$this->assertEquals("Jovem Aprendiz", $usuario->getNome());
		$this->assertEquals("1234", $usuario->getNumero());
		$this->assertEquals("12345", $usuario->getNumeroCTPS());
		$this->assertEquals("observações", $usuario->getObservacoes());
		$this->assertEquals("SSP", $usuario->getOrgaoEmissor());
		$this->assertEquals(1, $usuario->getPermissoesId());
		$this->assertEquals(1, $usuario->getRegiao());
		$this->assertEquals(1, $usuario->getRelacaoFuncional());
		$this->assertEquals("123.456.78", $usuario->getRG());
		$this->assertEquals("123224-7", $usuario->getSerieCTPS());
		$this->assertEquals(1, $usuario->getSexo());
		$this->assertEquals(1, $usuario->getStatus());
		$this->assertEquals("11 999 999 999", $usuario->getTelefone());
		$this->assertEquals("SP", $usuario->getUFCTPS());


    }
}