<?php
namespace src\Functional\Controller;

use src\FunctionalTestCase;

class EventControllerTest extends FunctionalTestCase
{
	public function testAInsertNewEvent()
	{
		
		$client = $this->createClient();

		$data = array(
			'title' => '8.PHP - Fórum Nacional de Profissionais PHP do MA'
		);

		$response = $client->request('POST', '/events', [
			'form_params' => $data,
			'headers' => [
				'Authorization' => 'Bearer ' . $token
			]
		]);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Event created with success', json_decode($response->getBody())->msg);
	}

	public function testGetAllEvents()
	{
		$client = $this->createClient();

		$response = $client->request('GET', '/events');

		$this->assertEquals(200, $response->getStatusCode());

		$this->assertObjectHasAttribute('title', json_decode($response->getBody())[0]);
	}

	public function testGetASpecificEvent()
	{
		$client = $this->createClient();

		$events = $client->request('GET', '/events');

		$id    = json_decode($events->getBody())[0]->id;

		$response = $client->request('GET', '/events/' . $id);

		$this->assertEquals(200, $response->getStatusCode());

		$this->assertObjectHasAttribute('title', json_decode($response->getBody()));
	}

	public function testUpdateEvent()
	{
		$client = $this->createClient();

		$events = $client->request('GET', '/events');

		$id    = json_decode($events->getBody())[0]->id;

		$dataUpdate = array(
			'title' => '8.PHP - Fórum Nacional de Profissionais PHP do MA',
			'id'      => $id
		);

		$response = $client->request('PUT', '/events', [
			'form_params' => $dataUpdate
		]);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Event updated with success', json_decode($response->getBody())->msg);
	}

	public function testDeleteEvent()
	{
		$client = $this->createClient();


		$events = $client->request('GET', '/events');

		$id    = json_decode($events->getBody())[0]->id;


		$response = $client->request('DELETE', '/events/' . $id);

		$this->assertEquals(200, $response->getStatusCode());
		$this->assertEquals('Event deleted with success', json_decode($response->getBody())->msg);
	}
}