<?php


namespace Configuracoes;


/**
 * @author Cristiano
 * @version 1.0
 * @created 14-nov-2017 17:50:31
 */
class Arquivo
{

	private $arquivo;
	private $arquivo_id;
	private $localDoArquivo;
	private $nomeDoArquivo;

	function __construct()
	{
	}

	function __destruct()
	{
	}



	/**
	 * 
	 * @param arquivo_id
	 */
	public function downloadArquivo(long $arquivo_id)
	{
	}

	/**
	 * 
	 * @param arquivo
	 */
	public function editarArquivo(Arquivo $arquivo)
	{
	}

	public function listarArquivos()
	{
	}

	/**
	 * 
	 * @param arquivo
	 */
	public function uploadArquivo(Arquivo $arquivo)
	{
	}

	/**
	 * 
	 * @param arquivo_id
	 */
	public function vsualizarArquivo(long $arquivo_id)
	{
	}

}
?>