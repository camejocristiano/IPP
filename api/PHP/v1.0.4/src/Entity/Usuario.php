<?php
namespace src\Entity;

use src\Entity\Contract\Entity;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\ORM\Mapping AS ORM;
use JMS\Serializer\Annotation as JMS;


/**
 * @ORM\Table("usuarios")
 * @ORM\Entity
 */
class Usuario implements Entity
{
    /**
     * @JMS\Groups({"list"})
     *
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     * @ORM\Column(name="id", type="integer")
     */private $id;

    /**
     * @ORM\Column(type="string")
     */private $bairro;
    /**
     * @ORM\Column(type="string")
     */private $cargo;
    /**
     * @ORM\Column(type="string")
     */private $celular;
    /**
     * @ORM\Column(type="string")
     */private $cEP;
    /**
     * @ORM\Column(type="string")
     */private $cidade;
    /**
     * @ORM\Column(type="string")
     */private $cNPJMEI;
    /**
     * @ORM\Column(type="string")
     */private $complemento;
    /**
     * @ORM\Column(type="string")
     */private $cPF;
    /**
     * @ORM\Column(type="string")
     */private $curriculoResumido;
    /**
     * @ORM\Column(type="string")
     */private $dataDeAdmissao;
    /**
     * @ORM\Column(type="string")
     */private $DataDeDesligamento;
    /**
     * @ORM\Column(type="string")
     */private $dataDeExpedicao;
    /**
     * @ORM\Column(type="string")
     */private $dataDeNascimento;
    /**
     * @ORM\Column(type="string")
     */private $dataExpedicaoCTPS;
    /**
     * @ORM\Column(type="string")
     */private $disciplina;
    /**
     * @ORM\Column(type="string")
     */private $email;
    /**
     * @ORM\Column(type="string")
     */private $endereco;
    /**
     * @ORM\Column(type="string")
     */private $estado;
    /**
     * @ORM\Column(type="string")
     */private $estadoCivil;
    /**
     * @ORM\Column(type="string")
     */private $formacao;
    /**
     * @ORM\Column(type="string")
     */private $habilitacao;
    /**
     * @ORM\Column(type="string")
     */private $nome;
    /**
     * @ORM\Column(type="string")
     */private $numero;
    /**
     * @ORM\Column(type="string")
     */private $numeroCTPS;
    /**
     * @ORM\Column(type="string")
     */private $observacoes;
    /**
     * @ORM\Column(type="string")
     */private $orgaoEmissor;
    /**
     * @ORM\Column(type="integer")
     */private $permissoes_id;
    /**
     * @ORM\Column(type="string")
     */private $regiao;
    /**
     * @ORM\Column(type="string")
     */private $relacaoFuncional;
    /**
     * @ORM\Column(type="string")
     */private $rG;
    /**
     * @ORM\Column(type="string")
     */private $serieCTPS;
    /**
     * @ORM\Column(type="string")
     */private $sexo;
    /**
     * @ORM\Column(type="string")
     */private $status;
    /**
     * @ORM\Column(type="string")
     */private $telefone;
    /**
     * @ORM\Column(type="string")
     */private $uFCTPS;

    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param mixed $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @return mixed
     */
    public function getBairro()
    {
        return $this->bairro;
    }

    /**
     * @param mixed $bairro
     */
    public function setBairro($bairro)
    {
        $this->bairro = $bairro;
    }

    /**
     * @return mixed
     */
    public function getCargo()
    {
        return $this->cargo;
    }

    /**
     * @param mixed $cargo
     */
    public function setCargo($cargo)
    {
        $this->cargo = $cargo;
    }

    /**
     * @return mixed
     */
    public function getCelular()
    {
        return $this->celular;
    }

    /**
     * @param mixed $celular
     */
    public function setCelular($celular)
    {
        $this->celular = $celular;
    }

    /**
     * @return mixed
     */
    public function getCEP()
    {
        return $this->cEP;
    }

    /**
     * @param mixed $cEP
     */
    public function setCEP($cEP)
    {
        $this->cEP = $cEP;
    }

    /**
     * @return mixed
     */
    public function getCidade()
    {
        return $this->cidade;
    }

    /**
     * @param mixed $cidade
     */
    public function setCidade($cidade)
    {
        $this->cidade = $cidade;
    }

    /**
     * @return mixed
     */
    public function getCNPJMEI()
    {
        return $this->cNPJMEI;
    }

    /**
     * @param mixed $cNPJMEI
     */
    public function setCNPJMEI($cNPJMEI)
    {
        $this->cNPJMEI = $cNPJMEI;
    }

    /**
     * @return mixed
     */
    public function getComplemento()
    {
        return $this->complemento;
    }

    /**
     * @param mixed $complemento
     */
    public function setComplemento($complemento)
    {
        $this->complemento = $complemento;
    }

    /**
     * @return mixed
     */
    public function getCPF()
    {
        return $this->cPF;
    }

    /**
     * @param mixed $cPF
     */
    public function setCPF($cPF)
    {
        $this->cPF = $cPF;
    }

    /**
     * @return mixed
     */
    public function getCurriculoResumido()
    {
        return $this->curriculoResumido;
    }

    /**
     * @param mixed $curriculoResumido
     */
    public function setCurriculoResumido($curriculoResumido)
    {
        $this->curriculoResumido = $curriculoResumido;
    }

    /**
     * @return mixed
     */
    public function getDataDeAdmissao()
    {
        return $this->dataDeAdmissao;
    }

    /**
     * @param mixed $dataDeAdmissao
     */
    public function setDataDeAdmissao($dataDeAdmissao)
    {
        $this->dataDeAdmissao = $dataDeAdmissao;
    }

    /**
     * @return mixed
     */
    public function getDataDeDesligamento()
    {
        return $this->DataDeDesligamento;
    }

    /**
     * @param mixed $DataDeDesligamento
     */
    public function setDataDeDesligamento($DataDeDesligamento)
    {
        $this->DataDeDesligamento = $DataDeDesligamento;
    }

    /**
     * @return mixed
     */
    public function getDataDeExpedicao()
    {
        return $this->dataDeExpedicao;
    }

    /**
     * @param mixed $dataDeExpedicao
     */
    public function setDataDeExpedicao($dataDeExpedicao)
    {
        $this->dataDeExpedicao = $dataDeExpedicao;
    }

    /**
     * @return mixed
     */
    public function getDataDeNascimento()
    {
        return $this->dataDeNascimento;
    }

    /**
     * @param mixed $dataDeNascimento
     */
    public function setDataDeNascimento($dataDeNascimento)
    {
        $this->dataDeNascimento = $dataDeNascimento;
    }

    /**
     * @return mixed
     */
    public function getDataExpedicaoCTPS()
    {
        return $this->dataExpedicaoCTPS;
    }

    /**
     * @param mixed $dataExpedicaoCTPS
     */
    public function setDataExpedicaoCTPS($dataExpedicaoCTPS)
    {
        $this->dataExpedicaoCTPS = $dataExpedicaoCTPS;
    }

    /**
     * @return mixed
     */
    public function getDisciplina()
    {
        return $this->disciplina;
    }

    /**
     * @param mixed $disciplina
     */
    public function setDisciplina($disciplina)
    {
        $this->disciplina = $disciplina;
    }

    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param mixed $email
     */
    public function setEmail($email)
    {
        $this->email = $email;
    }

    /**
     * @return mixed
     */
    public function getEndereco()
    {
        return $this->endereco;
    }

    /**
     * @param mixed $endereco
     */
    public function setEndereco($endereco)
    {
        $this->endereco = $endereco;
    }

    /**
     * @return mixed
     */
    public function getEstado()
    {
        return $this->estado;
    }

    /**
     * @param mixed $estado
     */
    public function setEstado($estado)
    {
        $this->estado = $estado;
    }

    /**
     * @return mixed
     */
    public function getEstadoCivil()
    {
        return $this->estadoCivil;
    }

    /**
     * @param mixed $estadoCivil
     */
    public function setEstadoCivil($estadoCivil)
    {
        $this->estadoCivil = $estadoCivil;
    }

    /**
     * @return mixed
     */
    public function getFormacao()
    {
        return $this->formacao;
    }

    /**
     * @param mixed $formacao
     */
    public function setFormacao($formacao)
    {
        $this->formacao = $formacao;
    }

    /**
     * @return mixed
     */
    public function getHabilitacao()
    {
        return $this->habilitacao;
    }

    /**
     * @param mixed $habilitacao
     */
    public function setHabilitacao($habilitacao)
    {
        $this->habilitacao = $habilitacao;
    }

    /**
     * @return mixed
     */
    public function getNome()
    {
        return $this->nome;
    }

    /**
     * @param mixed $nome
     */
    public function setNome($nome)
    {
        $this->nome = $nome;
    }

    /**
     * @return mixed
     */
    public function getNumero()
    {
        return $this->numero;
    }

    /**
     * @param mixed $numero
     */
    public function setNumero($numero)
    {
        $this->numero = $numero;
    }

    /**
     * @return mixed
     */
    public function getNumeroCTPS()
    {
        return $this->numeroCTPS;
    }

    /**
     * @param mixed $numeroCTPS
     */
    public function setNumeroCTPS($numeroCTPS)
    {
        $this->numeroCTPS = $numeroCTPS;
    }

    /**
     * @return mixed
     */
    public function getObservacoes()
    {
        return $this->observacoes;
    }

    /**
     * @param mixed $observacoes
     */
    public function setObservacoes($observacoes)
    {
        $this->observacoes = $observacoes;
    }

    /**
     * @return mixed
     */
    public function getOrgaoEmissor()
    {
        return $this->orgaoEmissor;
    }

    /**
     * @param mixed $orgaoEmissor
     */
    public function setOrgaoEmissor($orgaoEmissor)
    {
        $this->orgaoEmissor = $orgaoEmissor;
    }

    /**
     * @return mixed
     */
    public function getPermissoesId()
    {
        return $this->permissoes_id;
    }

    /**
     * @param mixed $permissoes_id
     */
    public function setPermissoesId($permissoes_id)
    {
        $this->permissoes_id = $permissoes_id;
    }

    /**
     * @return mixed
     */
    public function getRegiao()
    {
        return $this->regiao;
    }

    /**
     * @param mixed $regiao
     */
    public function setRegiao($regiao)
    {
        $this->regiao = $regiao;
    }

    /**
     * @return mixed
     */
    public function getRelacaoFuncional()
    {
        return $this->relacaoFuncional;
    }

    /**
     * @param mixed $relacaoFuncional
     */
    public function setRelacaoFuncional($relacaoFuncional)
    {
        $this->relacaoFuncional = $relacaoFuncional;
    }

    /**
     * @return mixed
     */
    public function getRG()
    {
        return $this->rG;
    }

    /**
     * @param mixed $rG
     */
    public function setRG($rG)
    {
        $this->rG = $rG;
    }

    /**
     * @return mixed
     */
    public function getSerieCTPS()
    {
        return $this->serieCTPS;
    }

    /**
     * @param mixed $serieCTPS
     */
    public function setSerieCTPS($serieCTPS)
    {
        $this->serieCTPS = $serieCTPS;
    }

    /**
     * @return mixed
     */
    public function getSexo()
    {
        return $this->sexo;
    }

    /**
     * @param mixed $sexo
     */
    public function setSexo($sexo)
    {
        $this->sexo = $sexo;
    }

    /**
     * @return mixed
     */
    public function getStatus()
    {
        return $this->status;
    }

    /**
     * @param mixed $status
     */
    public function setStatus($status)
    {
        $this->status = $status;
    }

    /**
     * @return mixed
     */
    public function getTelefone()
    {
        return $this->telefone;
    }

    /**
     * @param mixed $telefone
     */
    public function setTelefone($telefone)
    {
        $this->telefone = $telefone;
    }

    /**
     * @return mixed
     */
    public function getUFCTPS()
    {
        return $this->uFCTPS;
    }

    /**
     * @param mixed $uFCTPS
     */
    public function setUFCTPS($uFCTPS)
    {
        $this->uFCTPS = $uFCTPS;
    }





}
