<?php
namespace src\Functional\Controller;

use src\FunctionalTestCase;

class UnidadeControllerTest extends FunctionalTestCase
{
	public function testAInsertNewUnidade()
	{

		$response = $this->makeLogin();
		
		$token = json_decode($response->getBody())->token;
		
		$client = $this->createClient();

		$data = array(
			'nome' => 'Nome'
		);

		$response = $client->request('POST', '/unidades', [
			'form_params' => $data,
			'headers' => [
				'Authorization' => 'Bearer ' . $token
			]
		]);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Unidade created with success', json_decode($response->getBody())->msg);
	}

	public function testGetAllUnidades()
	{
		$client = $this->createClient();

		$response = $client->request('GET', '/unidades');

		$this->assertEquals(200, $response->getStatusCode());

		$this->assertObjectHasAttribute('nome', json_decode($response->getBody())[0]);
	}

	public function testGetASpecificUnidade()
	{
		$client = $this->createClient();

		$unidades = $client->request('GET', '/unidades');

		$id    = json_decode($unidades->getBody())[0]->id;

		$response = $client->request('GET', '/unidades/' . $id);

		$this->assertEquals(200, $response->getStatusCode());

		//$this->assertObjectHasAttribute('nome', json_decode($response->getBody()));
	}

	public function testUpdateUnidade()
	{
		$client = $this->createClient();

		$unidades = $client->request('GET', '/unidades');

		$id    = json_decode($unidades->getBody())[0]->id;

		$dataUpdate = array(
			'nome' => 'Nome',
			'id'      => $id
		);

		$response = $client->request('PUT', '/unidades', [
			'form_params' => $dataUpdate
		]);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Unidade updated with success', json_decode($response->getBody())->msg);
	}

	public function testDeleteUnidade()
	{
		$client = $this->createClient();


		$unidades = $client->request('GET', '/unidades');

		$id    = json_decode($unidades->getBody())[0]->id;


		$response = $client->request('DELETE', '/unidades/' . $id);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Unidade deleted with success', json_decode($response->getBody())->msg);
	}
}