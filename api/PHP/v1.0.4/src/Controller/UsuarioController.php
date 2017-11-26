<?php
namespace src\Controller;

use src\Entity\Usuario;
use src\Service\EMService;
use src\Service\PasswordService;
use JMS\Serializer\SerializationContext;
use JMS\Serializer\SerializerBuilder;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class UsuarioController extends BaseController
{
	public function index()
	{
		$usuarios = $this->app['orm.em']
			->getRepository('src\Entity\Usuario')
			->findAll();

		$build = SerializerBuilder::create()->build();

		$response =  new Response($build->serialize(
			$usuarios,
			'json',
			SerializationContext::create()->setGroups(array('list'))), 200);

		$response->headers->set('Content-Type', 'application/json');

		return $response;
	}

	public function get($id)
	{
		$id = (int) $id;

		$usuario = $this->app['orm.em']
			->getRepository('src\Entity\Usuario')
			->find($id);

		$build = SerializerBuilder::create()->build();

		$response = new Response($build->serialize(
			$usuario,
			'json',
			SerializationContext::create()->setGroups(array('list'))), 200);

		$response->headers->set('Content-Type', 'application/json');

		return $response;
	}

	public function save(Request $request)
	{
		$data = $request->request->all();

		$usuario = new Usuario();

		$usuario->setBairro($data["Centro"]);
		$usuario->setCargo($data["ADMINISTRADOR"]);
		$usuario->setCelular($data["11 999 999 999"]);
		$usuario->setCEP($data["00000-000"]);
		$usuario->setCidade($data["Local"]);
		$usuario->setCNPJMEI($data["123.456.7898-14"]);
		$usuario->setComplemento($data[""]);
		$usuario->setCPF($data["999.999.999-55"]);
		$usuario->setCurriculoResumido($data["asd"]);
		$usuario->setDataDeAdmissao($data["11/11/77"]);
		$usuario->setDataDeDesligamento($data["11/11/77"]);
		$usuario->setDataDeExpedicao($data["11/11/77"]);
		$usuario->setDataDeNascimento($data["11/11/77"]);
		$usuario->setDataExpedicaoCTPS($data["11/11/77"]);
		$usuario->setDisciplina($data["Português"]);
		$usuario->setEmail($data["email@test.com"]);
		$usuario->setEndereco($data["Rua da Alegria"]);
		$usuario->setEstado($data["SP"]);
		$usuario->setEstadoCivil($data[1]);
		$usuario->setFormacao($data["Graduado"]);
		$usuario->setHabilitacao($data["1234567"]);
		$usuario->setNome($data["Jovem Aprendiz"]);
		$usuario->setNumero($data["1234"]);
		$usuario->setNumeroCTPS($data["12345"]);
		$usuario->setObservacoes($data["observações"]);
		$usuario->setOrgaoEmissor($data["SSP"]);
		$usuario->setPermissoesId($data[1]);
		$usuario->setRegiao($data[1]);
		$usuario->setRelacaoFuncional($data[1]);
		$usuario->setRG($data["123.456.78"]);
		$usuario->setSerieCTPS($data["123224-7"]);
		$usuario->setSexo($data[1]);
		$usuario->setStatus($data[1]);
		$usuario->setTelefone($data["11 999 999 999"]);
		$usuario->setUFCTPS($data["SP"]);

		$em = new EMService($this->app['orm.em']);

		if(!$em->create($usuario)) {
			return $this->app->json(['msg' => 'Error to created a new usuario'], 401);
		}

		return $this->app->json(['msg' => 'Usuario created with success'], 200);
	}

	public function update(Request $request)
	{
		$data = $request->request->all();

		$usuario = $this->app['orm.em']
			->getRepository('src\Entity\Usuario')
			->find($data['id']);

		foreach ($data as $key=>$value) {
			$set = "set" . ucfirst($key);
			$usuario->$set($value);
		}

		$em = new EMService($this->app['orm.em']);

		if(!$em->update($usuario)) {
			return $this->app->json(['msg' => 'Error to update usuario'], 401);
		}

		return $this->app->json(['msg' => 'Usuario updated with success'], 200);
	}

	public function delete($id)
	{
		$id = (int) $id;

		$usuario = $this->app['orm.em']
			->getRepository('src\Entity\Usuario')
			->find($id);

		$em = new EMService($this->app['orm.em']);

		if(!$em->delete($usuario)) {
			return $this->app->json(['msg' => 'Error to delete usuario'], 401);
		}

		return $this->app->json(['msg' => 'Usuario deleted with success'], 200);
	}
}