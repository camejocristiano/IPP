<?php

namespace src\Provider;

use Pimple\Container;
use Pimple\ServiceProviderInterface;


class RouterServiceProvider implements ServiceProviderInterface
{
    public function register(Container $app)
    {

        $app->get('/cursos/', 'cursos:index');
        
        $app->post('/cursos/create', 'cursos:create');    
        $app->put('/cursos/update', 'cursos:update');
        $app->delete('/cursos/delete', 'cursos:delete');
        $app->get('/cursos/find/{id}', 'cursos:find');
        $app->get('/cursos/list', 'cursos:list');
    }

}