<?php
require_once ('Unidade_Usuario.php');
require_once ('Usuario.php');

namespace Configuracoes;



use Configuracoes;
use Configuracoes;
/**
 * @author Cristiano
 * @version 1.0
 * @created 14-nov-2017 17:52:55
 */
class GrupoDePermissoes extends Usuario
{

	private $grupo;
	private $grupoDePermissoes_id;
	private $grupoDePermissoesCadastrar;
	private $grupoDePermissoesEditar;
	private $grupoDePermissoesListar;
	private $grupoDePermissoesVisualizar;
	private $status;
	private $unidade;
	private $usuarioCadastrar;
	private $usuarioEditar;
	private $usuarioListar;
	private $usuarioVisualizar;
	public $m_Unidade_Usuario;

	function __construct()
	{
	}

	function __destruct()
	{
	}



	/**
	 * 
	 * @param grupoDePermissao
	 */
	public function cadastrarGrupoDePermissoes(GrupoDePermissoes $grupoDePermissao)
	{
	}

	/**
	 * 
	 * @param grupoDePermissoes
	 */
	public function editarGrupoDePermissoes(GrupoDePermissoes $grupoDePermissoes)
	{
	}

	public function listarGruposDePermissoes()
	{
	}

	/**
	 * 
	 * @param grupoDePermissoes_id
	 */
	public function visualizarGrupoDePermissoes(long $grupoDePermissoes_id)
	{
	}

}
?>