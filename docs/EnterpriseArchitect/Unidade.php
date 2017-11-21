<?php
require_once ('Jovem.php');
require_once ('Empresa.php');
require_once ('Curso_Unidade.php');

namespace Configuracoes;



use Aprendizes;
use Empresas;
use Cursos;
/**
 * @author Cristiano
 * @version 1.0
 * @created 14-nov-2017 17:51:01
 */
class Unidade extends Curso_Unidade
{

	private $bairro;
	private $cEP;
	private $cidade;
	private $cNPJ;
	private $complemento;
	private $dataDeCadastro;
	private $email;
	private $endereco;
	private $estado;
	private $fax;
	private $nomeFantazia;
	private $numero;
	private $razaoSocial;
	private $status;
	private $telefone;
	private $unidade_id;

	function __construct()
	{
	}

	function __destruct()
	{
	}



	/**
	 * 
	 * @param unidade
	 */
	public function cadastrarUnidade(Unidade $unidade)
	{
	}

	/**
	 * 
	 * @param unidade
	 * @param unidade_id
	 */
	public function editarUnidade(Unidade $unidade, long $unidade_id)
	{
	}

	public function listarUnidades()
	{
	}

	/**
	 * 
	 * @param unidade_id
	 */
	public function visualizarUnidade(long $unidade_id)
	{
	}

}
?>