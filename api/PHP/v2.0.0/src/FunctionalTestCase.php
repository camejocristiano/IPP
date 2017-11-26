<?php
namespace src;

use src\Entity\Event;
use src\Service\EMService;
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

	protected function createEvent()
	{
		$event = new Event();

		$event->setTitle("8.PHP - Fórum Nacional de Profissionais PHP");
		
		$emService = new EMService($this->getEntityManagerTest());
		return $emService->create($event);
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

	
}