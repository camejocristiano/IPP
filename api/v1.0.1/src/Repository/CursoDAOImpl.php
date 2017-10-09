<?php

namespace src\Repository;

use Silex\Application;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Doctrine\ORM\EntityRepository;

use src\Model\Curso;
use src\Repository\CursoDAO;

class CursoDAOImpl implements CursoDAO
{
    private $app;
    
    public function __construct(Application $app)
    {
        $this->app = $app;
    }

    public function create( $curso ) {
        $entityManager = $this->app['orm.em'];
		$entityManager->getConnection()->beginTransaction();
		try {			
			$entityManager->persist($curso);
			$entityManager->flush();
			$entityManager->getConnection()->commit();
			$entityManager->close();
		} catch (Exception $e) {
			$entityManager->getConnection()->rollBack();
			throw $e;
        }	          
    }  
        
    public function update( $curso ) {
        $entityManager = $this->app['orm.em'];
		$entityManager->getConnection()->beginTransaction();
		try {			
			$entityManager->merge($curso);
			$entityManager->flush();
			$entityManager->getConnection()->commit();
			$entityManager->close();
		} catch (Exception $e) {
			$entityManager->getConnection()->rollBack();
			throw $e;
        }
    } 

    public function delete( $id ) {
        $entityManager = $this->app['orm.em'];
		$entityManager->getConnection()->beginTransaction();
		try {			
			$curso = $entityManager->find('src\Model\Curso', $id);
			$entityManager->remove($curso);
            $entityManager->flush();
			$entityManager->getConnection()->commit();
			$entityManager->close();
		} catch (Exception $e) {
			$entityManager->getConnection()->rollBack();
			throw $e;
		}		
    }

    public function find( $id ) {
        $entityManager = $this->app['orm.em'];
		$entityManager->getConnection()->beginTransaction();
		try {			
			$query = $entityManager->createQuery('SELECT c.name, c.turno FROM src\Model\Curso c WHERE c.id = '.$id);
            $entityManager->flush();
			$entityManager->getConnection()->commit();
			$entityManager->close();
		} catch (Exception $e) {
			$entityManager->getConnection()->rollBack();
			throw $e;
        }		
        return $query->getResult();
    }  
    
    public function listCursos() {
        $entityManager = $this->app['orm.em'];
		$entityManager->getConnection()->beginTransaction();
		try {			
            $query = $entityManager->createQuery('SELECT c FROM src\Model\Curso c');
            $entityManager->flush();
			$entityManager->getConnection()->commit();
			$entityManager->close();
		} catch (Exception $e) {
			$entityManager->getConnection()->rollBack();
			throw $e;
        }		
        return $query->getArrayResult();	
    } 
      
}