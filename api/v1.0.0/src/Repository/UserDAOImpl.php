<?php

namespace src\Repository;

use Silex\Application;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Doctrine\ORM\EntityRepository;

use src\Model\User;
use src\Repository\UserDAO;

class UserDAOImpl implements UserDAO
{
    private $app;
    
    public function __construct(Application $app)
    {
        $this->app = $app;
    }

    public function create( $user ) {
        $entityManager = $this->app['orm.em'];
		$entityManager->getConnection()->beginTransaction();
		try {			
			$entityManager->persist($user);
			$entityManager->flush();
			$entityManager->getConnection()->commit();
			$entityManager->close();
		} catch (Exception $e) {
			$entityManager->getConnection()->rollBack();
			throw $e;
        }	          
    }  
        
    public function update( $user ) {
        $entityManager = $this->app['orm.em'];
		$entityManager->getConnection()->beginTransaction();
		try {			
			$entityManager->merge($user);
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
			$user = $entityManager->find('src\Model\User', $id);
			$entityManager->remove($user);
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
			$query = $entityManager->createQuery('SELECT u.name, u.email FROM src\Model\User u WHERE u.id = '.$id);
            $entityManager->flush();
			$entityManager->getConnection()->commit();
			$entityManager->close();
		} catch (Exception $e) {
			$entityManager->getConnection()->rollBack();
			throw $e;
        }		
        return $query->getResult();
    }  
    
    public function listUsers() {
        $entityManager = $this->app['orm.em'];
		$entityManager->getConnection()->beginTransaction();
		try {			
            $query = $entityManager->createQuery('SELECT u FROM src\Model\User u');
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