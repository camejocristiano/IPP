<?php

require_once "vendor/autoload.php";

use Doctrine\ORM\Tools\Setup;
use Doctrine\ORM\EntityManager;
use Doctrine\ORM\Mapping\Driver\AnnotationDriver;
use Doctrine\Common\Annotations\AnnotationReader;
use Doctrine\Common\Annotations\AnnotationRegistry;

$isDevMode = false;

$paths = array(__DIR__ . '/src/Model');

/*$dbParams = array(
    'driver'   => 'pdo_mysql',
    'user'     => 'root',
    'password' => '',
    'dbname'   => 'apirestfulsilexdoctrine',
    'host'     => 'localhost'
);*/

$dbParams = array(
    'driver'   => 'pdo_mysql',
    'user'     => 'ippti_cristiano',
    'password' => '8876$55%#001Cri#',
    'dbname'   => 'ippti_erpipp',
    'host'     => 'robb0213.publiccloud.com.br'
);

$config = Setup::createConfiguration($isDevMode);

$driver = new AnnotationDriver(new AnnotationReader(), $paths);

$config->setMetadataDriverImpl($driver);

AnnotationRegistry::registerFile(
    __DIR__ . '/vendor/doctrine/orm/lib/Doctrine/ORM/Mapping/Driver/DoctrineAnnotations.php'
);

$entityManager = EntityManager::create($dbParams, $config);