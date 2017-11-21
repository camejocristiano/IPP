<?php
require_once ('Usuario.php');

namespace Configuracoes;



use Configuracoes;
/**
 * @author Cristiano
 * @version 1.0
 * @created 14-nov-2017 17:52:25
 */
class Agendamento extends Usuario
{

	private $agendamento_id;
	private $data;
	private $descricao;
	private $hora;
	private $status;
	private $tempoPrevisto;
	private $usuario;

	function __construct()
	{
	}

	function __destruct()
	{
	}



	/**
	 * 
	 * @param agendamento
	 */
	public function cadastrarAgendamento(Agendamento $agendamento)
	{
	}

	/**
	 * 
	 * @param agendamento
	 * @param agendamento_id
	 */
	public function editarAgendamento(Agendamento $agendamento, long $agendamento_id)
	{
	}

	/**
	 * 
	 * @param usuario
	 */
	public function listarAgendamentoPorUsuario(Usuario $usuario)
	{
	}

	public function listarAgendamentos()
	{
	}

	/**
	 * 
	 * @param agendamento_id
	 */
	public function visualizarAgendamento(long $agendamento_id)
	{
	}

}
?>