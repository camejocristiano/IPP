<?php

namespace src\Model;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Security\Core\User\UserInterface;

/**
 * @ORM\Entity @ORM\Table(name="cursos")
 **/
class Curso
{
    /**
     * @ORM\Id @ORM\GeneratedValue @ORM\Column(type="integer")
     * @var int
     **/
    protected $id;

    /**
     * @ORM\Column(type="string")
     * @var string
     **/
    private $name;

    /**
     * @ORM\Column(type="string")
     * @var string
     **/
    private $turno;

    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
        $this->id = $id;
    }

    public function getName()
    {
        return $this->name;
    }

    public function setName($name)
    {
        $this->name = $name;
    }
    
    public function getTurno()
    {
        return $this->turno;
    }

    public function setTurno($turno)
    {
        $this->turno = $turno;
    }

}