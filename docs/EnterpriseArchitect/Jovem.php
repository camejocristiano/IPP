<?php
require_once ('Area.php');
require_once ('SituacaoDeSaude.php');
require_once ('ListaDeFrequencia_PITEPIP.php');
require_once ('ListaDeFrequencia_AulaExtra.php');
require_once ('ListaDeFrequencia_PIO.php');

namespace Aprendizes;



use Aprendizes;
use Aprendizes;
use Frequencias;
use Frequencias;
use Frequencias;
/**
 * @author Cristiano
 * @version 1.0
 * @created 14-nov-2017 18:01:22
 */
class Jovem
{

	private $aEDiaSem;
	private $aETurma;
	private $area;
	private $bairro;
	private $canal;
	private $celular;
	private $cEP;
	private $certidaoDeNascimentoCartorio;
	private $certidaoDeNascimentoFolhaNumero;
	private $certidaoDeNascimentoLivro;
	private $certidaoDeNascimentoTem;
	private $cidade;
	private $cNHNumero;
	private $cNHTem;
	private $cNHTipo;
	private $codigo;
	private $complemento;
	private $cPF;
	private $cPFPai;
	private $cPFResp;
	private $cTPSdataExpedicao;
	private $cTPSNumero;
	private $cTPSSerie;
	private $cTPSUF;
	private $dataDeNascimento;
	private $dataExpedicao;
	private $deficienciaFisicaDescricao;
	private $deficienciaFisicaTem;
	private $email;
	private $endereco;
	private $estado;
	private $estadoCivil;
	private $hrEmPAP;
	private $hrSdPAP;
	private $idade;
	private $jovem_id;
	private $medidasSocioEducativasEstaCumprindo;
	private $medidasSocioEducativasEUsuarioDeDrogas;
	private $medidasSocioEducativasJaTeveProblemasComALei;
	private $nameDaMae;
	private $naturalidadeCidade;
	private $naturalidadeEstado;
	private $naturalidadePais;
	private $nome;
	private $nomeDoPai;
	private $numeroPAP;
	private $numeroPIO;
	private $numeroPIP;
	private $numeroPIT;
	private $numeroResidencia;
	private $orgaoEmissor;
	private $pAPDiaDaSemana;
	private $pISNumero;
	private $regiao;
	private $responsavelLegal;
	private $rG;
	private $rGPai;
	private $rGResp;
	private $servicoMilitarNumero;
	private $servicoMilitarSeAlistou;
	private $servicoMilitarSituacao;
	private $sexo;
	private $status;
	private $telefone;
	private $tipoInsercao;
	private $tituloDeEleitorNumero;
	private $tituloDeEleitorSecao;
	private $tituloDeEleitorTem;
	private $tituloDeEleitorZona;
	private $unidade;
	public $m_Area;
	public $m_SituacaoDeSaude;
	public $m_ListaDeFrequencia_PITEPIP;
	public $m_ListaDeFrequencia_AulaExtra;
	public $m_ListaDeFrequencia_PIO;

	function __construct()
	{
	}

	function __destruct()
	{
	}



	/**
	 * 
	 * @param jovem
	 */
	public function cadastrarJovem(Jovem $jovem)
	{
	}

	/**
	 * 
	 * @param jovem_id
	 * @param jovem
	 */
	public function editarJovem(long $jovem_id, Jovem $jovem)
	{
	}

	public function listarJovens()
	{
	}

	/**
	 * 
	 * @param turma_id
	 */
	public function listJovensPorTurma(long $turma_id)
	{
	}

	/**
	 * 
	 * @param jovem_id
	 */
	public function visualizarJovem(long $jovem_id)
	{
	}

}
?>