<?php
namespace src\Entity;

use src\Entity\Event;

class EventTest extends \PHPUnit_Framework_TestCase
{
    public function assertPreConditions()
    {
        $this->assertTrue(class_exists($class = 'src\Entity\Event'),
            'Class not found: ' . $class);
    }

    public function testIfGettersAndSetterHasWorking()
    {
        $event = new Event();

        $event->setTitle("Event Test");
       
        $this->assertEquals("Event Test", $event->getTitle());
    }
}