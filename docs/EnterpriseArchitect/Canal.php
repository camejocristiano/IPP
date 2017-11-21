<?php
require_once ('Jovem.php');

namespace Configuracoes;



use Aprendizes;
/**
 * @author Cristiano
 * @version 1.0
 * @created 14-nov-2017 17:50:18
 */
class Canal
{

	private $canal_id;
	private $nome;
	public $m_Jovem;

	function __construct()
	{
	}

	function __destruct()
	{
	}



	/**
	 * 
	 * @param canal
	 */
	public function cadastrarCanal(Canal $canal)
	{
	}

	/**
	 * 
	 * @param canal
	 * @param canal_id
	 */
	public function editarCanal(Canal $canal, long $canal_id)
	{
	}

	public function listarCanais()
	{
	}

	/**
	 * 
	 * @param canal_id
	 */
	public function visualizarCanal(long $canal_id)
	{
	}

}
?>