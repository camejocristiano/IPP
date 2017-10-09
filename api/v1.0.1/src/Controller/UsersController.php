<?php

namespace src\Controller;

use Silex\Application;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use src\Model\User;
use src\Repository\UserDAOImpl;

class UsersController
{
	private $app;

	public function __construct(Application $app)
	{
		$this->app = $app;
	}
	
    public function index()
    {
        return "Users Controller";
	}
	
	public function create() {
		$user = new User;
		$user->setFirstName($_POST['firstName']);
		$user->setLastName($_POST['lastName']);
		$userrep = new UserDAOImpl($this->app);		
		$userrep->create($user);
		$response = new Response('Usuário criado com sucesso!', 201);
		$response->headers->set('Content-Type', 'application/json');	
		return $response;
	}

	public function update(Request $request) {
		$usercame = new User;
		$usercame->setFirstName($request->get('firstName'));
		$usercame->setLastName($request->get('lstName'));
		$entityManager = $this->app['orm.em'];
		$user = $entityManager->getRepository(User::class)->find($request->get('id'));
		if (!$user) {
			throw $this->createNotFoundException(
				'No user found for id '.$id
			);
		}
		$user->setFirstName($usercame->getFirstName());
		$user->setLastName($usercame->getLastName());
		$userrep = new UserDAOImpl($this->app);		
		$userrep->update($user);
		$response = new Response('Usuário atualizado com sucesso!', 202);
		$response->headers->set('Content-Type', 'application/json');	
		return $response;
	}

	public function delete(Request $request) {	
		$id = $request->get('id');
		$users = new UserDAOImpl($this->app);		
		$result = $users->delete($id);
		$response = new Response('Usuário deletado com sucesso!', 202);
		$response->headers->set('Content-Type', 'application/json');	
		return $response;
	}

	public function find(Request $request) {
		$id = $request->get('id');
		$users = new UserDAOImpl($this->app);		
		$result = $users->find($id);
		$response = new Response(json_encode($result), 302);
		$response->headers->set('Content-Type', 'application/json');	
		return $response;
	}

	public function list() {
		$users = new UserDAOImpl($this->app);		
		$result = $users->listUsers();
		$response = new Response(json_encode($result), 200);
		$response->headers->set('Content-Type', 'application/json');
		$response->headers->set('Access-Control-Allow-Origin', '*');
        $response->headers->set('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, DELETE');
        $response->headers->set('Access-Control-Allow-Headers', 'Content-Type');

		return $response;
	}
}