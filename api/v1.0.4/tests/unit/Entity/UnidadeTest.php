<?php
namespace src\Entity;

use src\Entity\Unidade;

class UnidadeTest extends \PHPUnit_Framework_TestCase
{
    public function assertPreConditions()
    {
        $this->assertTrue(class_exists($class = 'src\Entity\Unidade'),
            'Class not found: ' . $class);
    }

    public function testIfGettersAndSetterHasWorking()
    {
        $unidade = new Unidade();

        $unidade->setNome("Nome");
      
        $this->assertEquals("Nome", $unidade->getNome());
       
    }
}