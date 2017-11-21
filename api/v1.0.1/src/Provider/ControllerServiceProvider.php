<?php

namespace src\Provider;

use Pimple\Container;
use Pimple\ServiceProviderInterface;
use src\Controller\CursosController;

class ControllerServiceProvider implements ServiceProviderInterface
{
    public function register(Container $app)
    {

        $app['cursos'] = function (Container $app) {
            return new CursosController($app);
        };
    }
}