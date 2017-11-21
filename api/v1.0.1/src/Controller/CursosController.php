<?php

namespace src\Controller;

use Silex\Application;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use src\Model\Curso;
use src\Repository\CursoDAOImpl;

class CursosController
{
	private $app;

	public function __construct(Application $app)
	{
		$this->app = $app;
	}
	
    public function index()
    {
        return "Cursos Controller";
	}
	
	public function create() {
		$curso = new Curso;
		$curso->setName($_POST['name']);
		$curso->setTurno($_POST['turno']);
		$cursorep = new CursoDAOImpl($this->app);		
		$cursorep->create($curso);
		$response = new Response('Curso criado com sucesso!', 201);
		$response->headers->set('Content-Type', 'application/json');	
		return $response;
	}

	public function update(Request $request) {
		$cursocame = new Curso;
		$cursocame->setName($request->get('name'));
		$cursocame->setTurno($request->get('turno'));
		$entityManager = $this->app['orm.em'];
		$curso = $entityManager->getRepository(Curso::class)->find($request->get('id'));
		if (!$curso) {
			throw $this->createNotFoundException(
				'No curso found for id '.$id
			);
		}
		$curso->setName($cursocame->getName());
		$curso->setTurno($cursocame->getTurno());		
		$cursorep = new CursoDAOImpl($this->app);		
		$cursorep->update($curso);
		$response = new Response('Curso atualizado com sucesso!', 202);
		$response->headers->set('Content-Type', 'application/json');	
		return $response;
	}

	public function delete(Request $request) {	
		$id = $request->get('id');
		$cursos = new CursoDAOImpl($this->app);		
		$result = $cursos->delete($id);
		$response = new Response('Curso deletado com sucesso!', 202);
		$response->headers->set('Content-Type', 'application/json');	
		return $response;
	}

	public function find(Request $request) {
		$id = $request->get('id');
		$cursos = new CursoDAOImpl($this->app);		
		$result = $cursos->find($id);
		$response = new Response(json_encode($result), 302);
		$response->headers->set('Content-Type', 'application/json');	
		return $response;
	}

	public function list() {
		$cursos = new CursoDAOImpl($this->app);		
		$result = $cursos->listCursos();
		$response = new Response(json_encode($result), 200);
		$response->headers->set('Content-Type', 'application/json');	
		return $response;
	}
}