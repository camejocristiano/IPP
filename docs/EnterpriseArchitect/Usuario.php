<?php
require_once ('Turma_Usuario.php');
require_once ('SituacaoDeSaude.php');
require_once ('Empresa.php');

namespace Configuracoes;



use Cursos;
use Aprendizes;
use Empresas;
/**
 * @author Cristiano
 * @version 1.0
 * @created 15-nov-2017 00:48:23
 */
class Usuario extends Turma_Usuario
{

	private $bairro;
	private $cargo;
	private $celular;
	private $cEP;
	private $cidade;
	private $cNPJMEI;
	private $complemento;
	private $cPF;
	/**
	 * Campo TEXT LONG
	 */
	private $curriculoResumido;
	private $dataDeAdmissao;
	private $DataDeDesligamento;
	private $dataDeExpedicao;
	private $dataDeNascimento;
	private $dataExpedicaoCTPS;
	private $disciplina;
	private $email;
	private $endereco;
	private $estado;
	private $estadoCivil;
	private $formacao;
	private $habilitacao;
	private $nome;
	private $numero;
	private $numeroCTPS;
	private $observacoes;
	private $orgaoEmissor;
	private $permissoes_id;
	private $regiao;
	private $relacaoFuncional;
	private $rG;
	private $serieCTPS;
	private $sexo;
	private $status;
	private $telefone;
	private $uFCTPS;
	private $usuario_id;
	public $m_SituacaoDeSaude;
	public $m_Empresa;

	function __construct()
	{
	}

	function __destruct()
	{
	}



	/**
	 * 
	 * @param usuario
	 */
	public function cadastrarUsuario(Usuario $usuario)
	{
	}

	/**
	 * 
	 * @param usuario
	 * @param usuario_id
	 */
	public function editarUsuario(Usuario $usuario, long $usuario_id)
	{
	}

	public function listarUsuarios()
	{
	}

	/**
	 * 
	 * @param usuario_id
	 */
	public function visualizarUsuario(long $usuario_id)
	{
	}

}
?>