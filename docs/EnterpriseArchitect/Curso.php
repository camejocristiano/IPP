<?php
require_once ('Curso_Unidade.php');
require_once ('CBO.php');
require_once ('Curso_ConteudoTeoricoEspecifico.php');
require_once ('Curso_ConteudoTeoricoBasico.php');

namespace Cursos;



use Cursos;
use Cursos;
use Cursos;
use Cursos;
/**
 * @author Cristiano
 * @version 1.0
 * @created 14-nov-2017 23:07:57
 */
class Curso extends Curso_Unidade, Curso_ConteudoTeoricoEspecifico, Curso_ConteudoTeoricoBasico
{

	private $arcoOcupacional;
	private $articulacaoComOutrasAreas;
	private $atividadePraticas;
	private $cargaHorariaTotal;
	private $cargaHorarioSemanal;
	private $cBO;
	private $conteudosTeoricosBasicos;
	private $conteudosTeoricosEspecificos;
	private $dataDoCadastro;
	private $livre;
	private $nomeDoCurso;
	private $numeroDoCurso;
	private $pAP;
	private $publicoAlvo;
	private $resumo;
	private $statusDoCurso;
	private $unidades;
	private $validacoes;
	public $m_CBO;

	function __construct()
	{
	}

	function __destruct()
	{
	}



	/**
	 * 
	 * @param curso
	 */
	public function cadastrarCurso(Curso $curso)
	{
	}

	/**
	 * 
	 * @param curso_id
	 * @param curso
	 */
	public function editarCurso(long $curso_id, Curso $curso)
	{
	}

	public function listarCursos()
	{
	}

	/**
	 * 
	 * @param curso_id
	 */
	public function visualizarCurso(long $curso_id)
	{
	}

}
?>