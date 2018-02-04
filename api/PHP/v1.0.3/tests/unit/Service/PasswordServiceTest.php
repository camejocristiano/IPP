<?php
namespace src\Service;

use src\UnitTestCase;
use src\Service\PasswordService;

class PasswordServiceTest extends UnitTestCase
{
    private $password;

    public function setup()
    {
        $this->password = new PasswordService();
    }

    public function testIfPasswordHasBeenGeneratedWithSuccess()
    {
        $password = 'Silex';

        $proccess = $this->password->setPassword($password);

        $hash = $proccess->generate();

        $this->assertTrue($proccess->isValidPassword($password, $hash));
    }
}