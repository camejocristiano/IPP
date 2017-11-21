<?php
namespace src\Entity;

use src\Entity\Contract\Entity;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\ORM\Mapping AS ORM;
use JMS\Serializer\Annotation as JMS;

/**
 * @ORM\Table("events")
 * @ORM\Entity
 */
class Event implements Entity
{
    /**
     * @JMS\Groups({"list"})
     *
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     * @ORM\Column(name="id", type="integer")
     */
    private $id;

    /**
     * @JMS\Groups({"list"})
     *
     * @ORM\Column(name="title", type="string")
     */
    private $title;

   
    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param mixed $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @return mixed
     */
    public function getTitle()
    {
        return $this->title;
    }

    /**
     * @param mixed $title
     */
    public function setTitle($title)
    {
        $this->title = $title;
    }

}