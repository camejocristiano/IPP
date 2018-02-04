<?php
namespace src\Entity;

use src\Entity\Event;

class CanalTest extends \PHPUnit_Framework_TestCase
{
    public function assertPreConditions()
    {
        $this->assertTrue(class_exists($class = 'src\Entity\Canal'),
            'Class not found: ' . $class);
    }

    public function testIfGettersAndSetterHasWorking()
    {
        $canal = new Canal();

        $canal->setNome("canal Test");

        $this->assertEquals("canal Test", $canal->getNome());

    }
}