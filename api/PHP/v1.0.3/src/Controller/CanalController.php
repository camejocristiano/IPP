<?php
namespace src\Controller;

use src\Entity\Canal;
use src\Service\EMService;
use JMS\Serializer\SerializationContext;
use JMS\Serializer\SerializerBuilder;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class CanalController extends BaseController
{
	public function index()
	{
		$canais = $this->app['orm.em']
			->getRepository('src\Entity\Canal')
			->findAll();

		$build = SerializerBuilder::create()->build();

		$response  = new Response($build->serialize(
			$canais,
			'json',
			SerializationContext::create()->setGroups(array('list'))), 200);

		$response->headers->set('Content-Type', 'application/json');

		return $response;
	}

	public function get($id)
	{
		$id = (int) $id;

		$canal = $this->app['orm.em']
			->getRepository('src\Entity\Canal')
			->find($id);

		$build = SerializerBuilder::create()->build();

		$response = new Response($build->serialize(
			$canal,
			'json',
			SerializationContext::create()->setGroups(array('list'))), 200);

		$response->headers->set('Content-Type', 'application/json');

		return $response;
	}

	public function save(Request $request)
	{
		$data = $request->request->all();

		$canal = new Canal();

		$canal->setNome($data['nome']);
		
		$em = new EMService($this->app['orm.em']);

		if(!$em->create($canal)) {
			return $this->app->json(['msg' => 'Error to created a new canal'], 401);
		}

		return $this->app->json(['msg' => 'Canal created with success'], 200);
	}

	public function update(Request $request)
	{
		$data = $request->request->all();

		$canal = $this->app['orm.em']
			->getRepository('src\Entity\Canal')
			->find($data['id']);

		foreach ($data as $key=>$value) {
			$set = "set" . ucfirst($key);
			$canal->$set($value);
		}

		$em = new EMService($this->app['orm.em']);

		if(!$em->update($canal)) {
			return $this->app->json(['msg' => 'Error to update canal'], 401);
		}

		return $this->app->json(['msg' => 'Canal updated with success'], 200);
	}

	public function delete($id)
	{
		$id = (int) $id;

		$canal = $this->app['orm.em']
			->getRepository('src\Entity\Canal')
			->find($id);

		$em = new EMService($this->app['orm.em']);

		if(!$em->delete($canal)) {
			return $this->app->json(['msg' => 'Error to delete canal'], 401);
		}

		return $this->app->json(['msg' => 'Canal deleted with success'], 200);
	}
}