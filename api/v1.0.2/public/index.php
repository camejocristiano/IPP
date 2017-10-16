<?php

require __DIR__ . '/../bootstrap.php';

use Silex\Application;
use Silex\Provider\ServiceControllerServiceProvider;
use src\Service\JWTServiceProvider;
use src\Provider\ControllerServiceProvider;
use src\Provider\RouterServiceProvider;

$app = new Application();

$app['debug'] = true;

$app->register(new ServiceControllerServiceProvider());
$app->register(new ControllerServiceProvider());
$app->register(new RouterServiceProvider());

$app->register(new JWTServiceProvider(), [
	'iss' => $_SERVER['SERVER_NAME'],
	'secret' => 'xyzxyz',
	'expires' => 3600,
	'signer' => 'HMACS'
]);

/**
 * Registra o Doctrine ORM Service Provider
 */
$app->register(new \Silex\Provider\DoctrineServiceProvider(), array(
    'dbs.options' => array(
        'default' => $dbParams
    )
));

$app->register(new \Dflydev\Provider\DoctrineOrm\DoctrineOrmServiceProvider(), array(
    'orm.proxies_dir' => '/tmp',
    'orm.em.options' => array(
        'mappings' => array(
            array(
                'type' => 'annotation',
                'use_simple_annotation_reader' => false,
                'namespace' => 'src\Entity',
                'path' => __DIR__ . '/src'
            ),
        ),
    ),
    'orm.proxies_namespace' => 'EntityProxy',
    'orm.auto_generate_proxies' => true,
    'orm.default_cache' => 'array'
));

$app->run();