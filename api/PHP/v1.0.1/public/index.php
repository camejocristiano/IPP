<?php 

$baseDir = chdir(dirname(__DIR__));

$loader = require __DIR__ . '/../vendor/autoload.php';

use Silex\Application;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Doctrine\Common\Annotations\AnnotationRegistry;
use Silex\Provider\DoctrineServiceProvider;
use Dflydev\Provider\DoctrineOrm\DoctrineOrmServiceProvider;
use Pimple\ServiceProviderInterface;
use Silex\Provider\ServiceControllerServiceProvider;
use src\Provider\ConnectionServiceProvider;
use src\Provider\ControllerServiceProvider;
use src\Provider\RouterServiceProvider;


use src\Repository\UserRepository;

$app = new Application();

$app['debug'] = true;

$app->register(new ServiceControllerServiceProvider());
$app->register(new ControllerServiceProvider());
$app->register(new RouterServiceProvider());

$app->get('/', function(){
    return new Response('Silex index!', 200);
});

$app->error(function (Exception $e) use ($app) {
    return new \Symfony\Component\HttpFoundation\Response("Something goes terribly wrong: " . $e->getMessage());
});

// Doctrine
AnnotationRegistry::registerLoader([$loader, 'loadClass']);

// Doctrine
$app->register(
    new DoctrineServiceProvider(),
    [
        'db.options' => [
            'driver'        => 'pdo_mysql',
            'host'          => 'robb0213.publiccloud.com.br',
            'dbname'        => 'ippti_erpipp',
            'user'          => 'ippti_cristiano',
            'password'      => '8876$55%#001Cri#',
            'charset'       => 'utf8',
            'driverOptions' => [
                1002 => 'SET NAMES utf8',
            ],
        ],
    ]
);

// Doctrine
$app->register(new DoctrineOrmServiceProvider(), [
    'orm.proxies_dir'             => $baseDir . 'src\Model/Proxy',
    'orm.auto_generate_proxies'   => $app['debug'],
    'orm.em.options'              => [
        'mappings' => [
            [
                'type'                         => 'annotation',
                'namespace'                    => 'src\Model\\',
                'path'                         => $baseDir. 'src/Model',
                'use_simple_annotation_reader' => false,
            ],
        ],
    ]
]);

$app->run();