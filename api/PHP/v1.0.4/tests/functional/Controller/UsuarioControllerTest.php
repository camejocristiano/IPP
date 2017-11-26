<?php
namespace src\Functional\Controller;

use src\FunctionalTestCase;

class UsuarioControllerTest extends FunctionalTestCase
{
	public function testAInsertNewUsuario()
	{

		$response = $this->makeLogin();
		
		$token = json_decode($response->getBody())->token;
		
		$client = $this->createClient();

		$data = array(
			'bairro' => 'Teste',
			'cargo' => 'Teste',
			'celular' => 'Teste',
			'cEP' => 'Teste',
			'cidade' => 'Teste',
			'cNPJMEI' => 'Teste',
			'complemento' => 'Teste',
			'cPF' => 'Teste',
			'curriculoResumido' => 'Teste',
			'dataDeAdmissao' => 'Teste',
			'DataDeDesligamento' => 'Teste',
			'dataDeExpedicao' => 'Teste',
			'dataDeNascimento' => 'Teste',
			'dataExpedicaoCTPS' => 'Teste',
			'disciplina' => 'Teste',
			'email' => 'Teste',
			'endereco' => 'Teste',
			'estado' => 'Teste',
			'estadoCivil' => 'Teste',
			'formacao' => 'Teste',
			'habilitacao' => 'Teste',
			'nome' => 'Teste',
			'numero' => 'Teste',
			'numeroCTPS' => 'Teste',
			'observacoes' => 'Teste',
			'orgaoEmissor' => 'Teste',
			'permissoes_id' => 'Teste',
			'regiao' => 'Teste',
			'relacaoFuncional' => 'Teste',
			'rG' => 'Teste',
			'serieCTPS' => 'Teste',
			'sexo' => 'Teste',
			'status' => 'Teste',
			'telefone' => 'Teste',
			'uFCTPS' => 'Teste'
		);

		$response = $client->request('POST', '/usuarios', [
			'form_params' => $data,
			'headers' => [
				'Authorization' => 'Bearer ' . $token
			]
		]);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Usuario created with success', json_decode($response->getBody())->msg);
	}

	public function testGetAllUsuarios()
	{
		$client = $this->createClient();

		$response = $client->request('GET', '/usuarios');

		$this->assertEquals(200, $response->getStatusCode());

		$this->assertObjectHasAttribute('bairro' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('cargo' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('celular' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('cEP' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('cidade' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('cNPJMEI' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('complemento' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('cPF' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('curriculoResumido' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('dataDeAdmissao' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('DataDeDesligamento' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('dataDeExpedicao' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('dataDeNascimento' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('dataExpedicaoCTPS' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('disciplina' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('email' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('endereco' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('estado' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('estadoCivil' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('formacao' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('habilitacao' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('nome' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('numero' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('numeroCTPS' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('observacoes' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('orgaoEmissor' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('permissoes_id' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('regiao' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('relacaoFuncional' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('rG' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('serieCTPS' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('sexo' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('status' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('telefone' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('uFCTPS' , json_decode($response->getBody())[0]);
	}

	public function testGetASpecificUsuario()
	{
		$client = $this->createClient();

		$usuarios = $client->request('GET', '/usuarios');

		$id    = json_decode($usuarios->getBody())[0]->id;

		$response = $client->request('GET', '/usuarios/' . $id);

		$this->assertEquals(200, $response->getStatusCode());

		$this->assertObjectHasAttribute('bairro' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('cargo' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('celular' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('cEP' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('cidade' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('cNPJMEI' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('complemento' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('cPF' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('curriculoResumido' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('dataDeAdmissao' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('DataDeDesligamento' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('dataDeExpedicao' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('dataDeNascimento' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('dataExpedicaoCTPS' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('disciplina' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('email' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('endereco' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('estado' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('estadoCivil' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('formacao' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('habilitacao' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('nome' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('numero' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('numeroCTPS' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('observacoes' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('orgaoEmissor' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('permissoes_id' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('regiao' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('relacaoFuncional' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('rG' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('serieCTPS' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('sexo' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('status' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('telefone' , json_decode($response->getBody())[0]);
		$this->assertObjectHasAttribute('uFCTPS' , json_decode($response->getBody())[0]);
	}

	public function testUpdateUsuario()
	{
		$client = $this->createClient();

		$usuarios = $client->request('GET', '/usuarios');

		$id    = json_decode($usuarios->getBody())[0]->id;

		$dataUpdate = array(
			'bairro' => 'TesteII',
			'cargo' => 'TesteII',
			'celular' => 'TesteII',
			'cEP' => 'TesteII',
			'cidade' => 'TesteII',
			'cNPJMEI' => 'TesteII',
			'complemento' => 'TesteII',
			'cPF' => 'TesteII',
			'curriculoResumido' => 'TesteII',
			'dataDeAdmissao' => 'TesteII',
			'DataDeDesligamento' => 'TesteII',
			'dataDeExpedicao' => 'TesteII',
			'dataDeNascimento' => 'TesteII',
			'dataExpedicaoCTPS' => 'TesteII',
			'disciplina' => 'TesteII',
			'email' => 'TesteII',
			'endereco' => 'TesteII',
			'estado' => 'TesteII',
			'estadoCivil' => 'TesteII',
			'formacao' => 'TesteII',
			'habilitacao' => 'TesteII',
			'nome' => 'TesteII',
			'numero' => 'TesteII',
			'numeroCTPS' => 'TesteII',
			'observacoes' => 'TesteII',
			'orgaoEmissor' => 'TesteII',
			'permissoes_id' => 'TesteII',
			'regiao' => 'TesteII',
			'relacaoFuncional' => 'TesteII',
			'rG' => 'TesteII',
			'serieCTPS' => 'TesteII',
			'sexo' => 'TesteII',
			'status' => 'TesteII',
			'telefone' => 'TesteII',
			'uFCTPS' => 'TesteII',
			'id'      => $id
		);

		$response = $client->request('PUT', '/usuarios', [
			'form_params' => $dataUpdate
		]);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Usuario updated with success', json_decode($response->getBody())->msg);
	}

	public function testDeleteUsuario()
	{
		$client = $this->createClient();


		$usuarios = $client->request('GET', '/usuarios');

		$id    = json_decode($usuarios->getBody())[0]->id;


		$response = $client->request('DELETE', '/usuarios/' . $id);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Usuario deleted with success', json_decode($response->getBody())->msg);
	}
}