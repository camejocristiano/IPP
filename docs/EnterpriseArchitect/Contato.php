<?php
require_once ('Unidade.php');

namespace Configuracoes;



use Configuracoes;
/**
 * @author Cristiano
 * @version 1.0
 * @created 14-nov-2017 17:51:14
 */
class Contato
{

	private $cargo;
	private $departamento;
	private $email;
	private $nome;
	private $observacoes;
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
	 * @param contat
	 */
	public function cadastrarContato(Contato $contat)
	{
	}

	/**
	 * 
	 * @param contato
	 * @param contato_id
	 */
	public function editarContato(Contato $contato, long $contato_id)
	{
	}

	public function listarContatos()
	{
	}

	/**
	 * 
	 * @param contato_id
	 */
	public function visualizarContato(long $contato_id)
	{
	}

}
?>