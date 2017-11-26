<?php

namespace src\Provider;

use Pimple\Container;
use Pimple\ServiceProviderInterface;
use src\Controller\CursosController;
use src\Controller\UsersController;

class ControllerServiceProvider implements ServiceProviderInterface
{
    public function register(Container $app)
    {
        $app['users'] = function (Container $app) {
            return new UsersController($app);
        };

        $app['cursos'] = function (Container $app) {
            return new CursosController($app);
        };
    }
}