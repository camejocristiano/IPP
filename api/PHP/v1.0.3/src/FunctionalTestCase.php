<?php
namespace src;

use src\Entity\Event;
use src\Entity\User;
use src\Entity\Unidade;
use src\Entity\Canal;
use src\Service\EMService;
use src\Service\PasswordService;
use Doctrine\ORM\Tools\SchemaTool;
use GuzzleHttp\Client;

class FunctionalTestCase extends \PHPUnit_Framework_TestCase
{
	/**
	 * @author Elton Minetto <eminetto@gmail.com>
	 */
	public function setUp()
	{
		$em = $this->getEntityManagerTest();

		$tool = new SchemaTool($em);

		$classes = $em->getMetadataFactory()->getAllMetadata();

		$tool->createSchema($classes);

		parent::setup();
	}

	/**
	 * @author Elton Minetto <eminetto@gmail.com>
	 */
	public function tearDown()
	{
		$em = $this->getEntityManagerTest();

		$tool = new SchemaTool($em);

		$classes = $em->getMetadataFactory()->getAllMetadata();

		$tool->dropSchema($classes);

		parent::tearDown();
	}

	/**
	 * @author Elton Minetto <eminetto@gmail.com>
	 */
	public function getEntityManagerTest()
	{
		$entity = require __DIR__ . '/../tests/bootstrap.php';

		return $entity;
	}

	protected function createUser()
	{
		$password = new PasswordService();
		$password = $password->setPassword('123456')
		                     ->generate();

		$user = new User();
		
		$user->setName("User Test");
		$user->setEmail("emailTest@email.com");
		$user->setUsername("userTest");
		$user->setPassword($password);
		$user->setIsActive(true);
		$user->setCreatedAt(new \DateTime("now", new \DateTimeZone("America/Sao_Paulo")));
		$user->setUpdatedAt(new \DateTime("now", new \DateTimeZone("America/Sao_Paulo")));

		$emService = new EMService($this->getEntityManagerTest());
		return $emService->create($user);
	}

	protected function createEvent()
	{
		$event = new Event();

		$event->setTitle("8.PHP - Fórum Nacional de Profissionais PHP");
		$event->setContent("Content set test");
		$event->setDescription("Event Description");
		$event->setVenue("São Luis - MA");
		$event->setAddress("Address test");
		$event->setStartDate("2016-11-14");
		$event->setEndDate("2016-11-14");
		$event->setStartTime("09:00");
		$event->setEndTime("20:00");
		$event->setIsActive(true);
		$event->setCreatedAt(new \DateTime("now", new \DateTimeZone("America/Sao_Paulo")));
		$event->setUpdatedAt(new \DateTime("now", new \DateTimeZone("America/Sao_Paulo")));

		$emService = new EMService($this->getEntityManagerTest());
		return $emService->create($event);
	}

	protected function createUnidade()
	{
		
		$unidade = new Unidade();

		$unidade->setNome("Nome Fantazia");
		
		$emService = new EMService($this->getEntityManagerTest());
		return $emService->create($unidade);
	}

	protected function createCanal()
	{
		
		$canal = new Canal();

		$canal->setNome("Teste Nome");
		
		$emService = new EMService($this->getEntityManagerTest());
		return $emService->create($canal);
	}

	protected function createClient()
	{
		$client = new Client(array(
			'base_uri' => 'http://localhost:3000',
			'request.options' => array(
				'exceptions' => false,
			),
			'http_errors' => false
		));

		return $client;
	}

	protected function makeLogin()
	{
		$client = $this->createClient();

		$credentials = [
			'email' => 'emailTest@email.com',
			'password' => '123456'
		];

		$response = $client->request('POST', '/auth/login', [
			'form_params' => $credentials
		]);

		return $response;
	}

}