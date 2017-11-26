<?php
namespace src\Provider;

use Pimple\Container;
use Pimple\ServiceProviderInterface;
use src\Controller\AuthController;
use src\Controller\UserController;
use src\Controller\EventController;
use src\Controller\SubscriptionController;

class ControllerServiceProvider implements ServiceProviderInterface
{
    public function register(Container $app)
    {

        $app['auth'] = function(Container $app) {
		    return new AuthController($app);
	    };

        $app['user'] = function (Container $app) {
            return new UserController($app);
        };

        $app['event'] = function (Container $app) {
            return new EventController($app);
        };

        $app['subscription'] = function (Container $app) {
            return new SubscriptionController($app);
        };
    }
}