<?php

namespace src\Provider;

use Pimple\Container;
use Pimple\ServiceProviderInterface;
use Symfony\Component\HttpFoundation\Request;


class RouterServiceProvider implements ServiceProviderInterface
{
    public function register(Container $app)
    {

	    /**
	     * Events Routes
	     */
	    $app->get('/events', 'event:index');
	    $app->get('/events/{id}', 'event:get');
	    $app->post('/events', 'event:save');
	    $app->put('/events', 'event:update');
		$app->delete('/events/{id}', 'event:delete');

    }

}