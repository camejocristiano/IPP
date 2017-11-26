<?php

namespace src\Repository;

use Silex\Application;

use src\Model\User;
use src\Repository\UserDAOImpl;

interface UserDAO 
{
    public function create( $user );   
    public function update( $user ); 
    public function delete( $id ); 
    public function find( $id );    
    public function listUsers(); 
}