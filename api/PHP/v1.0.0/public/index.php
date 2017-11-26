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
//$app->register(new ConnectionServiceProvider());


$app->get('/', function(){
    return new Response('Silex index!', 200);
});

$app->error(function (Exception $e) use ($app) {
    return new \Symfony\Component\HttpFoundation\Response("Something goes terribly wrong: " . $e->getMessage());
});

/**
 *  DB PDO
 *      Connection
 */
/* $app->register(new ConnectionServiceProvider(), array(
    'db.name' => 'apirestfulsilexdoctrine',
    'db.host' => 'localhost',
    'db.user' => 'root',
    'db.password' => ''
));

$app->get('/pdo', function(Application $app) {
    $users = $app['pdo'];
    $users = $users->query("SELECT * FROM users");
    var_dump($users->fetchAll());
    return new Response('PDO is running!', 200);
}); */
// FIM DB PDO





/**
 * Doctrine Bloco de testes
 */

// Doctrine
AnnotationRegistry::registerLoader([$loader, 'loadClass']);

// Doctrine
$app->register(
    new DoctrineServiceProvider(),
    [
        'db.options' => [
            'driver'        => 'pdo_mysql',
            'host'          => 'localhost',
            'dbname'        => 'api',
            'user'          => 'root',
            'password'      => '',
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

/* // Doctrine
$app->get('/user', function (Application $app) {
    $user = new src\Model\User();
    $user->setName('Hello');
    $entityManager = $app['orm.em'];
    $entityManager->persist($user);
    $entityManager->flush();
    return new Response('Successfully inserted!');
});

// Doctrine
$app->get('/create-user', function(Application $app){
	$entityManager = $app['orm.em'];
	$entityManager->getConnection()->beginTransaction(); // suspend auto-commit
	try {
		$user = new src\Model\User;
		$user->setName("Camejo");
		$user->setEmail("cris@camejo");
		$entityManager->persist($user);
		$entityManager->flush();
		$entityManager->getConnection()->commit();
		$entityManager->close();
	} catch (Exception $e) {
		$entityManager->getConnection()->rollBack();
		throw $e;
	}
	return new Response('Successfully inserted!');
}); */

// Final Doctrine

$app->run();