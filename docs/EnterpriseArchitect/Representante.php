<?php
require_once ('Unidade.php');

namespace Configuracoes;



use Configuracoes;
/**
 * @author Cristiano
 * @version 1.0
 * @created 14-nov-2017 17:50:42
 */
class Representante
{

	private $cargo;
	private $cPF;
	private $email;
	private $nome;
	private $rG;
	private $telefone;
	private $unidade_id;
	public $m_Unidade;

	function __construct()
	{
	}

	function __destruct()
	{
	}



	/**
	 * 
	 * @param representante
	 */
	public function cadastrarRepresentante(Representante $representante)
	{
	}

	/**
	 * 
	 * @param representante
	 * @param representante_id
	 */
	public function editarRepresentante(Representante $representante, long $representante_id)
	{
	}

	public function listarRepresentantes()
	{
	}

}
?>