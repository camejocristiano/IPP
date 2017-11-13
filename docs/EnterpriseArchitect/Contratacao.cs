<?php


namespace Aprendizes;


/**
 * @author Cristiano
 * @version 1.0
 * @created 13-nov-2017 07:04:00
 */
class Contratacao
{

	private $contratacao_id;
	private $contratacaoObservacoes;
	private $dadosDoCursoCBO;
	private $dataDeInicioDoCurso;
	private $diaDoCurso;
	private $domingo;
	private $empresa;
	private $exameAdmissional;
	private $feriasDataDeFim;
	private $feriasDataDeInicio;
	private $feriasDataDeVencimento;
	private $feriasDiasAGozar;
	private $gestor;
	private $horarioDeTrabalho;
	private $localDeTrgabalho;
	private $quarta;
	private $quinta;
	private $sabado;
	private $segunda;
	private $sexta;
	private $terca;
	private $terminoDoContrato;
	private $tipoDeContratacao;
	private $totalDeHorasSemanai;

	function __construct()
	{
	}

	function __destruct()
	{
	}



	/**
	 * 
	 * @param contratacao
	 */
	public function cadastrarContratacao(Contratacao $contratacao)
	{
	}

	/**
	 * 
	 * @param contratacao_id
	 * @param contratacao
	 */
	public function editarContratacao(long $contratacao_id, Contratacao $contratacao)
	{
	}

	public function listarContratacoes()
	{
	}

	/**
	 * 
	 * @param aprendiz_id
	 */
	public function listarContratacoesPorAprendiz(long $aprendiz_id)
	{
	}

	/**
	 * 
	 * @param contratacao_id
	 */
	public function visualizarContratacao(long $contratacao_id)
	{
	}

}
?>