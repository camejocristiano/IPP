<?php

namespace src\Repository;

use Silex\Application;

use src\Model\Curso;
use src\Repository\CursoDAOImpl;

interface CursoDAO 
{
    public function create( $curso );   
    public function update( $curso ); 
    public function delete( $id ); 
    public function find( $id );    
    public function listCursos(); 
}