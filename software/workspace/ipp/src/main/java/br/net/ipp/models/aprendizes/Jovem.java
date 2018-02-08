package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.enums.AEDiaDaSemana;
import br.net.ipp.enums.Area;
import br.net.ipp.enums.DiaDaSemana;
import br.net.ipp.enums.EstadoCivil;
import br.net.ipp.enums.Regiao;
import br.net.ipp.enums.ServicoMilitarSituacao;
import br.net.ipp.enums.Sexo;
import br.net.ipp.enums.Status;
import br.net.ipp.enums.TipoDeCNH;
import br.net.ipp.enums.TipoDeInsercao;
import br.net.ipp.models.User;
import br.net.ipp.models.configuracoes.Canal;
import br.net.ipp.models.configuracoes.Unidade;
import br.net.ipp.models.cursos.Turma;

@Entity
public class Jovem extends User {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String telefone;
	private String celular;
	private String endereco;
	private String numeroResidencia;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cEP;
	private String idade;
	// Naturalidade
	private String naturalidadeCidade;
	private String naturalidadeEstado;
	private String naturalidadePais;
	private String cPF;
	private String rG;
	private String orgaoEmissor;
	private String codigoDoJovem;
	private String responsavelLegal;
	private String nomeDoPai;
	private String nomeDaMae;
	private String rGPai;
	private String rGResp;
	private String cPFPai;
	private String cPFResp;
	// CTPS
	@Column(name = "cTPSdataExpedicao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date cTPSdataExpedicao;
	private String cTPSNumero;
	private String cTPSSerie;
	private String cTPSUF;
	// CNH
	private Boolean cNHTem;
	private String cNHNumero;
	private TipoDeCNH cNHTipo;
	// Medidas Sócio Educativas
	private Boolean medidasSocioEducativasEstaCumprindo;
	private Boolean medidasSocioEducativasEUsuarioDeDrogas;
	private Boolean medidasSocioEducativasJaTeveProblemasComALei;
	// Certidão de Nascimento
	private Boolean certidaoDeNascimentoTem;
	private String certidaoDeNascimentoCartorio;
	private String certidaoDeNascimentoFolhaNumero;
	private String certidaoDeNascimentoLivro;
	// Título De Eleitor
	private Boolean tituloDeEleitorTem;
	private String tituloDeEleitorNumero;
	private String tituloDeEleitorSessao;
	private String tituloDeEleitorZona;
	// Serviço Militar
	private String servicoMilitarNumero;
	private Boolean servicoMilitarSeAlistou;
	private ServicoMilitarSituacao servicoMilitarSituacao;
	// Deficiência Física
	private String deficienciaFisicaDescricao;
	private Boolean deficienciaFisicaTem;
	// PIS
	private String pISNumero;
	private String hrEmPAP;
	private String hrSdPAP;
	private String numeroPAP;
	private String numeroPIO;
	private String numeroPIP;
	private String numeroPIT;
	private Turma aETurma;
	private AEDiaDaSemana aEDiaSem;
	private DiaDaSemana pAPDiaDaSemana;
	@Column(name = "dataDeNascimento")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDeNascimento;
	@Column(name = "dataExpedicao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataExpedicao;
	@ManyToOne
	private Canal canal;
	@ManyToOne
	private Unidade unidade;
	private TipoDeInsercao tipoDeInsercao;
	private EstadoCivil estadoCivil;
	private Sexo sexo; 
	private Status status;
	private Area area;
	private Regiao regiao;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumeroResidencia() {
		return numeroResidencia;
	}
	public void setNumeroResidencia(String numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getcEP() {
		return cEP;
	}
	public void setcEP(String cEP) {
		this.cEP = cEP;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getcPF() {
		return cPF;
	}
	public void setcPF(String cPF) {
		this.cPF = cPF;
	}
	public String getrG() {
		return rG;
	}
	public void setrG(String rG) {
		this.rG = rG;
	}
	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}
	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public Canal getCanal() {
		return canal;
	}
	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public Date getDataExpedicao() {
		return dataExpedicao;
	}
	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNaturalidadeCidade() {
		return naturalidadeCidade;
	}
	public void setNaturalidadeCidade(String naturalidadeCidade) {
		this.naturalidadeCidade = naturalidadeCidade;
	}
	public String getNaturalidadeEstado() {
		return naturalidadeEstado;
	}
	public void setNaturalidadeEstado(String naturalidadeEstado) {
		this.naturalidadeEstado = naturalidadeEstado;
	}
	public String getNaturalidadePais() {
		return naturalidadePais;
	}
	public void setNaturalidadePais(String naturalidadePais) {
		this.naturalidadePais = naturalidadePais;
	}
	public String getCertidaoDeNascimentoCartorio() {
		return certidaoDeNascimentoCartorio;
	}
	public void setCertidaoDeNascimentoCartorio(String certidaoDeNascimentoCartorio) {
		this.certidaoDeNascimentoCartorio = certidaoDeNascimentoCartorio;
	}
	public String getCertidaoDeNascimentoFolhaNumero() {
		return certidaoDeNascimentoFolhaNumero;
	}
	public void setCertidaoDeNascimentoFolhaNumero(String certidaoDeNascimentoFolhaNumero) {
		this.certidaoDeNascimentoFolhaNumero = certidaoDeNascimentoFolhaNumero;
	}
	public String getCertidaoDeNascimentoLivro() {
		return certidaoDeNascimentoLivro;
	}
	public void setCertidaoDeNascimentoLivro(String certidaoDeNascimentoLivro) {
		this.certidaoDeNascimentoLivro = certidaoDeNascimentoLivro;
	}
	public String getcNHNumero() {
		return cNHNumero;
	}
	public void setcNHNumero(String cNHNumero) {
		this.cNHNumero = cNHNumero;
	}
	public String getServicoMilitarNumero() {
		return servicoMilitarNumero;
	}
	public void setServicoMilitarNumero(String servicoMilitarNumero) {
		this.servicoMilitarNumero = servicoMilitarNumero;
	}
	public String getTituloDeEleitorNumero() {
		return tituloDeEleitorNumero;
	}
	public void setTituloDeEleitorNumero(String tituloDeEleitorNumero) {
		this.tituloDeEleitorNumero = tituloDeEleitorNumero;
	}
	public String getTituloDeEleitorSessao() {
		return tituloDeEleitorSessao;
	}
	public void setTituloDeEleitorSessao(String tituloDeEleitorSessao) {
		this.tituloDeEleitorSessao = tituloDeEleitorSessao;
	}
	public String getTituloDeEleitorZona() {
		return tituloDeEleitorZona;
	}
	public void setTituloDeEleitorZona(String tituloDeEleitorZona) {
		this.tituloDeEleitorZona = tituloDeEleitorZona;
	}
	public String getpISNumero() {
		return pISNumero;
	}
	public void setpISNumero(String pISNumero) {
		this.pISNumero = pISNumero;
	}
	public String getCodigoDoJovem() {
		return codigoDoJovem;
	}
	public void setCodigoDoJovem(String codigoDoJovem) {
		this.codigoDoJovem = codigoDoJovem;
	}
	public String getResponsavelLegal() {
		return responsavelLegal;
	}
	public void setResponsavelLegal(String responsavelLegal) {
		this.responsavelLegal = responsavelLegal;
	}
	public String getNomeDoPai() {
		return nomeDoPai;
	}
	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
	}
	public String getNomeDaMae() {
		return nomeDaMae;
	}
	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}
	public String getrGPai() {
		return rGPai;
	}
	public void setrGPai(String rGPai) {
		this.rGPai = rGPai;
	}
	public String getrGResp() {
		return rGResp;
	}
	public void setrGResp(String rGResp) {
		this.rGResp = rGResp;
	}
	public String getcPFPai() {
		return cPFPai;
	}
	public void setcPFPai(String cPFPai) {
		this.cPFPai = cPFPai;
	}
	public String getcPFResp() {
		return cPFResp;
	}
	public void setcPFResp(String cPFResp) {
		this.cPFResp = cPFResp;
	}
	public Date getcTPSdataExpedicao() {
		return cTPSdataExpedicao;
	}
	public void setcTPSdataExpedicao(Date cTPSdataExpedicao) {
		this.cTPSdataExpedicao = cTPSdataExpedicao;
	}
	public String getcTPSNumero() {
		return cTPSNumero;
	}
	public void setcTPSNumero(String cTPSNumero) {
		this.cTPSNumero = cTPSNumero;
	}
	public String getcTPSSerie() {
		return cTPSSerie;
	}
	public void setcTPSSerie(String cTPSSerie) {
		this.cTPSSerie = cTPSSerie;
	}
	public String getcTPSUF() {
		return cTPSUF;
	}
	public void setcTPSUF(String cTPSUF) {
		this.cTPSUF = cTPSUF;
	}
	public String getDeficienciaFisicaDescricao() {
		return deficienciaFisicaDescricao;
	}
	public void setDeficienciaFisicaDescricao(String deficienciaFisicaDescricao) {
		this.deficienciaFisicaDescricao = deficienciaFisicaDescricao;
	}
	public String getHrEmPAP() {
		return hrEmPAP;
	}
	public void setHrEmPAP(String hrEmPAP) {
		this.hrEmPAP = hrEmPAP;
	}
	public String getHrSdPAP() {
		return hrSdPAP;
	}
	public void setHrSdPAP(String hrSdPAP) {
		this.hrSdPAP = hrSdPAP;
	}
	public String getNumeroPAP() {
		return numeroPAP;
	}
	public void setNumeroPAP(String numeroPAP) {
		this.numeroPAP = numeroPAP;
	}
	public String getNumeroPIO() {
		return numeroPIO;
	}
	public void setNumeroPIO(String numeroPIO) {
		this.numeroPIO = numeroPIO;
	}
	public String getNumeroPIP() {
		return numeroPIP;
	}
	public void setNumeroPIP(String numeroPIP) {
		this.numeroPIP = numeroPIP;
	}
	public String getNumeroPIT() {
		return numeroPIT;
	}
	public void setNumeroPIT(String numeroPIT) {
		this.numeroPIT = numeroPIT;
	}
	public Boolean getTituloDeEleitorTem() {
		return tituloDeEleitorTem;
	}
	public void setTituloDeEleitorTem(Boolean tituloDeEleitorTem) {
		this.tituloDeEleitorTem = tituloDeEleitorTem;
	}
	public Boolean getCertidaoDeNascimentoTem() {
		return certidaoDeNascimentoTem;
	}
	public void setCertidaoDeNascimentoTem(Boolean certidaoDeNascimentoTem) {
		this.certidaoDeNascimentoTem = certidaoDeNascimentoTem;
	}
	public Boolean getcNHTem() {
		return cNHTem;
	}
	public void setcNHTem(Boolean cNHTem) {
		this.cNHTem = cNHTem;
	}
	public Boolean getMedidasSocioEducativasEstaCumprindo() {
		return medidasSocioEducativasEstaCumprindo;
	}
	public void setMedidasSocioEducativasEstaCumprindo(Boolean medidasSocioEducativasEstaCumprindo) {
		this.medidasSocioEducativasEstaCumprindo = medidasSocioEducativasEstaCumprindo;
	}
	public Boolean getMedidasSocioEducativasEUsuarioDeDrogas() {
		return medidasSocioEducativasEUsuarioDeDrogas;
	}
	public void setMedidasSocioEducativasEUsuarioDeDrogas(Boolean medidasSocioEducativasEUsuarioDeDrogas) {
		this.medidasSocioEducativasEUsuarioDeDrogas = medidasSocioEducativasEUsuarioDeDrogas;
	}
	public Boolean getMedidasSocioEducativasJaTeveProblemasComALei() {
		return medidasSocioEducativasJaTeveProblemasComALei;
	}
	public void setMedidasSocioEducativasJaTeveProblemasComALei(Boolean medidasSocioEducativasJaTeveProblemasComALei) {
		this.medidasSocioEducativasJaTeveProblemasComALei = medidasSocioEducativasJaTeveProblemasComALei;
	}
	public Boolean getDeficienciaFisicaTem() {
		return deficienciaFisicaTem;
	}
	public void setDeficienciaFisicaTem(Boolean deficienciaFisicaTem) {
		this.deficienciaFisicaTem = deficienciaFisicaTem;
	}
	public Boolean getServicoMilitarSeAlistou() {
		return servicoMilitarSeAlistou;
	}
	public void setServicoMilitarSeAlistou(Boolean servicoMilitarSeAlistou) {
		this.servicoMilitarSeAlistou = servicoMilitarSeAlistou;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public TipoDeInsercao getTipoDeInsercao() {
		return tipoDeInsercao;
	}
	public void setTipoDeInsercao(TipoDeInsercao tipoDeInsercao) {
		this.tipoDeInsercao = tipoDeInsercao;
	}
	public Turma getAETurma() {
		return aETurma;
	}
	public void setAETurma(Turma aETurma) {
		this.aETurma = aETurma;
	}
	public DiaDaSemana getpAPDiaDaSemana() {
		return pAPDiaDaSemana;
	}
	public void setpAPDiaDaSemana(DiaDaSemana pAPDiaDaSemana) {
		this.pAPDiaDaSemana = pAPDiaDaSemana;
	}
	public AEDiaDaSemana getaEDiaSem() {
		return aEDiaSem;
	}
	public void setaEDiaSem(AEDiaDaSemana aEDiaSem) {
		this.aEDiaSem = aEDiaSem;
	}
	public TipoDeCNH getcNHTipo() {
		return cNHTipo;
	}
	public void setcNHTipo(TipoDeCNH cNHTipo) {
		this.cNHTipo = cNHTipo;
	}
	public ServicoMilitarSituacao getServicoMilitarSituacao() {
		return servicoMilitarSituacao;
	}
	public void setServicoMilitarSituacao(ServicoMilitarSituacao servicoMilitarSituacao) {
		this.servicoMilitarSituacao = servicoMilitarSituacao;
	}
		
}