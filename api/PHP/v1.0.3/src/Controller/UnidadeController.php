<?php
namespace src\Controller;

use src\Entity\Unidade;
use src\Service\EMService;
use JMS\Serializer\SerializationContext;
use JMS\Serializer\SerializerBuilder;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class UnidadeController extends BaseController
{
	public function index()
	{
		$unidades = $this->app['orm.em']
			->getRepository('src\Entity\Unidade')
			->findAll();

		$build = SerializerBuilder::create()->build();

		$response  = new Response($build->serialize(
			$unidades,
			'json',
			SerializationContext::create()->setGroups(array('list'))), 200);

		$response->headers->set('Content-Type', 'application/json');

		return $response;
	}

	public function get($id)
	{
		$id = (int) $id;

		$unidade = $this->app['orm.em']
			->getRepository('src\Entity\Unidade')
			->find($id);

		$build = SerializerBuilder::create()->build();

		$response = new Response($build->serialize(
			$unidade,
			'json',
			SerializationContext::create()->setGroups(array('list'))), 200);

		$response->headers->set('Content-Type', 'application/json');

		return $response;
	}

	public function save(Request $request)
	{
		$data = $request->request->all();

		$unidade = new Unidade();

		$unidade->setNome($data['nome']);
		
		$em = new EMService($this->app['orm.em']);

		if(!$em->create($unidade)) {
			return $this->app->json(['msg' => 'Error to created a new unidade'], 401);
		}

		return $this->app->json(['msg' => 'Unidade created with success'], 200);
	}

	public function update(Request $request)
	{
		$data = $request->request->all();

		$unidade = $this->app['orm.em']
			->getRepository('src\Entity\Unidade')
			->find($data['id']);

		foreach ($data as $key=>$value) {
			$set = "set" . ucfirst($key);
			$unidade->$set($value);
		}

		$em = new EMService($this->app['orm.em']);

		if(!$em->update($unidade)) {
			return $this->app->json(['msg' => 'Error to update unidade'], 401);
		}

		return $this->app->json(['msg' => 'Unidade updated with success'], 200);
	}

	public function delete($id)
	{
		$id = (int) $id;

		$unidade = $this->app['orm.em']
			->getRepository('src\Entity\Unidade')
			->find($id);

		$em = new EMService($this->app['orm.em']);

		if(!$em->delete($unidade)) {
			return $this->app->json(['msg' => 'Error to delete unidade'], 401);
		}

		return $this->app->json(['msg' => 'Unidade deleted with success'], 200);
	}
}