<?php
namespace src\Provider;

use Pimple\Container;
use Pimple\ServiceProviderInterface;
use src\Controller\EventController;

class ControllerServiceProvider implements ServiceProviderInterface
{
    public function register(Container $app)
    {

        $app['event'] = function (Container $app) {
            return new EventController($app);
        };

    }
}