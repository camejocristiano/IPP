<?php
namespace src\Functional\Controller;

use src\FunctionalTestCase;

class CanalControllerTest extends FunctionalTestCase
{
	public function testAInsertNewCanal()
	{

		$response = $this->makeLogin();
		
		$token = json_decode($response->getBody())->token;
		
		$client = $this->createClient();

		$data = array(
			'nome' => 'Nome'
		);

		$response = $client->request('POST', '/canais', [
			'form_params' => $data,
			'headers' => [
				'Authorization' => 'Bearer ' . $token
			]
		]);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Canal created with success', json_decode($response->getBody())->msg);
	}

	public function testGetAllCanais()
	{
		$client = $this->createClient();

		$response = $client->request('GET', '/canais');

		$this->assertEquals(200, $response->getStatusCode());

		$this->assertObjectHasAttribute('nome', json_decode($response->getBody())[0]);
	}

	public function testGetASpecificCanal()
	{
		$client = $this->createClient();

		$canais = $client->request('GET', '/canais');

		$id    = json_decode($canais->getBody())[0]->id;

		$response = $client->request('GET', '/canais/' . $id);

		$this->assertEquals(200, $response->getStatusCode());

		$this->assertObjectHasAttribute('nome', json_decode($response->getBody()));
	}

	public function testUpdateCanal()
	{
		$client = $this->createClient();

		$canais = $client->request('GET', '/canais');

		$id    = json_decode($canais->getBody())[0]->id;

		$dataUpdate = array(
			'nome' => 'Nome',
			'id'      => $id
		);

		$response = $client->request('PUT', '/canais', [
			'form_params' => $dataUpdate
		]);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Canal updated with success', json_decode($response->getBody())->msg);
	}

	public function testDeleteCanal()
	{
		$client = $this->createClient();


		$canais = $client->request('GET', '/canais');

		$id    = json_decode($canais->getBody())[0]->id;


		$response = $client->request('DELETE', '/canais/' . $id);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Canal deleted with success', json_decode($response->getBody())->msg);
	}
}