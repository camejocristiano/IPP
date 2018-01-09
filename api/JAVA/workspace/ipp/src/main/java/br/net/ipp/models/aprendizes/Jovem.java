package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.User;

@Entity
public class Jovem extends User {

	private static final long serialVersionUID = 1L;

	private String nome;
	/*private AEDiaDaSemana aEDiaSem;
	private Turma aETurma;
	private Area area;
	private String bairro;
	private Canal canal;
	private String celular;
	private String cEP;
	private String certidaoDeNascimentoCartorio;
	private String certidaoDeNascimentoFolhaNumero;
	private String certidaoDeNascimentoLivro;
	private Boolean certidaoDeNascimentoTem;
	private String cidade;
	private String cNHNumero;
	private Boolean cNHTem;
	private TipoDeCNH cNHTipo;
	private String codigo;
	private String complemento;
	private int cPF;
	private int cPFPai;
	private int cPFResp;
	private String cTPSdataExpedicao;
	private String cTPSNumero;
	private String cTPSSerie;
	private String cTPSUF;
	private Date dataDeNascimento;
	private Date dataExpedicao;
	private String deficienciaFisicaDescricao;
	private Boolean deficienciaFisicaTem;
	private String email;
	private String endereco;
	private String estado;
	private EstadoCivil estadoCivil;
	private String hrEmPAP;
	private String hrSdPAP;
	private String idade;
	private Boolean medidasSocioEducativasEstaCumprindo;
	private Boolean medidasSocioEducativasEUsuarioDeDrogas;
	private Boolean medidasSocioEducativasJaTeveProblemasComALei;
	private String nameDaMae;
	private String naturalidadeCidade;
	private String naturalidadeEstado;
	private String naturalidadePais;
	private String nomeDoPai;
	private String numeroPAP;
	private String numeroPIO;
	private String numeroPIP;
	private String numeroPIT;
	private String numeroResidencia;
	private String orgaoEmissor;
	private DiaDaSemana pAPDiaDaSemana;
	private String pISNumero;
	private Regiao regiao;
	private String responsavelLegal;
	private String rG;
	private String rGPai;
	private String rGResp;
	private String servicoMilitarNumero;
	private Boolean servicoMilitarSeAlistou;
	private ServicoMilitarSituacao servicoMilitarSituacao;
	private Sexo sexo;
	private Status status;
	private String telefone;
	private TipoDeInsercao tipoInsercao;
	private String tituloDeEleitorNumero;
	private String tituloDeEleitorSecao;
	private Boolean tituloDeEleitorTem;
	private String tituloDeEleitorZona;
	private Unidade unidade;
	public Area m_Area;
	public SituacaoDeSaude m_SituacaoDeSaude;
	public PITEPIP m_ListaDeFrequencia_PITEPIP;
	public AulaExtra m_ListaDeFrequencia_AulaExtra;
	public PIO m_ListaDeFrequencia_PIO;*/
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*public AEDiaDaSemana getaEDiaSem() {
		return aEDiaSem;
	}
	public void setaEDiaSem(AEDiaDaSemana aEDiaSem) {
		this.aEDiaSem = aEDiaSem;
	}
	public Turma getaETurma() {
		return aETurma;
	}
	public void setaETurma(Turma aETurma) {
		this.aETurma = aETurma;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Canal getCanal() {
		return canal;
	}
	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getcEP() {
		return cEP;
	}
	public void setcEP(String cEP) {
		this.cEP = cEP;
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
	public Boolean getCertidaoDeNascimentoTem() {
		return certidaoDeNascimentoTem;
	}
	public void setCertidaoDeNascimentoTem(Boolean certidaoDeNascimentoTem) {
		this.certidaoDeNascimentoTem = certidaoDeNascimentoTem;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getcNHNumero() {
		return cNHNumero;
	}
	public void setcNHNumero(String cNHNumero) {
		this.cNHNumero = cNHNumero;
	}
	public Boolean getcNHTem() {
		return cNHTem;
	}
	public void setcNHTem(Boolean cNHTem) {
		this.cNHTem = cNHTem;
	}
	public TipoDeCNH getcNHTipo() {
		return cNHTipo;
	}
	public void setcNHTipo(TipoDeCNH cNHTipo) {
		this.cNHTipo = cNHTipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getcPF() {
		return cPF;
	}
	public void setcPF(int cPF) {
		this.cPF = cPF;
	}
	public int getcPFPai() {
		return cPFPai;
	}
	public void setcPFPai(int cPFPai) {
		this.cPFPai = cPFPai;
	}
	public int getcPFResp() {
		return cPFResp;
	}
	public void setcPFResp(int cPFResp) {
		this.cPFResp = cPFResp;
	}
	public String getcTPSdataExpedicao() {
		return cTPSdataExpedicao;
	}
	public void setcTPSdataExpedicao(String cTPSdataExpedicao) {
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
	public String getDeficienciaFisicaDescricao() {
		return deficienciaFisicaDescricao;
	}
	public void setDeficienciaFisicaDescricao(String deficienciaFisicaDescricao) {
		this.deficienciaFisicaDescricao = deficienciaFisicaDescricao;
	}
	public Boolean getDeficienciaFisicaTem() {
		return deficienciaFisicaTem;
	}
	public void setDeficienciaFisicaTem(Boolean deficienciaFisicaTem) {
		this.deficienciaFisicaTem = deficienciaFisicaTem;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
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
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
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
	public String getNameDaMae() {
		return nameDaMae;
	}
	public void setNameDaMae(String nameDaMae) {
		this.nameDaMae = nameDaMae;
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
	public String getNomeDoPai() {
		return nomeDoPai;
	}
	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
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
	public String getNumeroResidencia() {
		return numeroResidencia;
	}
	public void setNumeroResidencia(String numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}
	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}
	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}
	public DiaDaSemana getpAPDiaDaSemana() {
		return pAPDiaDaSemana;
	}
	public void setpAPDiaDaSemana(DiaDaSemana pAPDiaDaSemana) {
		this.pAPDiaDaSemana = pAPDiaDaSemana;
	}
	public String getpISNumero() {
		return pISNumero;
	}
	public void setpISNumero(String pISNumero) {
		this.pISNumero = pISNumero;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	public String getResponsavelLegal() {
		return responsavelLegal;
	}
	public void setResponsavelLegal(String responsavelLegal) {
		this.responsavelLegal = responsavelLegal;
	}
	public String getrG() {
		return rG;
	}
	public void setrG(String rG) {
		this.rG = rG;
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
	public String getServicoMilitarNumero() {
		return servicoMilitarNumero;
	}
	public void setServicoMilitarNumero(String servicoMilitarNumero) {
		this.servicoMilitarNumero = servicoMilitarNumero;
	}
	public Boolean getServicoMilitarSeAlistou() {
		return servicoMilitarSeAlistou;
	}
	public void setServicoMilitarSeAlistou(Boolean servicoMilitarSeAlistou) {
		this.servicoMilitarSeAlistou = servicoMilitarSeAlistou;
	}
	public ServicoMilitarSituacao getServicoMilitarSituacao() {
		return servicoMilitarSituacao;
	}
	public void setServicoMilitarSituacao(ServicoMilitarSituacao servicoMilitarSituacao) {
		this.servicoMilitarSituacao = servicoMilitarSituacao;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public TipoDeInsercao getTipoInsercao() {
		return tipoInsercao;
	}
	public void setTipoInsercao(TipoDeInsercao tipoInsercao) {
		this.tipoInsercao = tipoInsercao;
	}
	public String getTituloDeEleitorNumero() {
		return tituloDeEleitorNumero;
	}
	public void setTituloDeEleitorNumero(String tituloDeEleitorNumero) {
		this.tituloDeEleitorNumero = tituloDeEleitorNumero;
	}
	public String getTituloDeEleitorSecao() {
		return tituloDeEleitorSecao;
	}
	public void setTituloDeEleitorSecao(String tituloDeEleitorSecao) {
		this.tituloDeEleitorSecao = tituloDeEleitorSecao;
	}
	public Boolean getTituloDeEleitorTem() {
		return tituloDeEleitorTem;
	}
	public void setTituloDeEleitorTem(Boolean tituloDeEleitorTem) {
		this.tituloDeEleitorTem = tituloDeEleitorTem;
	}
	public String getTituloDeEleitorZona() {
		return tituloDeEleitorZona;
	}
	public void setTituloDeEleitorZona(String tituloDeEleitorZona) {
		this.tituloDeEleitorZona = tituloDeEleitorZona;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public Area getM_Area() {
		return m_Area;
	}
	public void setM_Area(Area m_Area) {
		this.m_Area = m_Area;
	}
	public SituacaoDeSaude getM_SituacaoDeSaude() {
		return m_SituacaoDeSaude;
	}
	public void setM_SituacaoDeSaude(SituacaoDeSaude m_SituacaoDeSaude) {
		this.m_SituacaoDeSaude = m_SituacaoDeSaude;
	}
	public PITEPIP getM_ListaDeFrequencia_PITEPIP() {
		return m_ListaDeFrequencia_PITEPIP;
	}
	public void setM_ListaDeFrequencia_PITEPIP(PITEPIP m_ListaDeFrequencia_PITEPIP) {
		this.m_ListaDeFrequencia_PITEPIP = m_ListaDeFrequencia_PITEPIP;
	}
	public AulaExtra getM_ListaDeFrequencia_AulaExtra() {
		return m_ListaDeFrequencia_AulaExtra;
	}
	public void setM_ListaDeFrequencia_AulaExtra(AulaExtra m_ListaDeFrequencia_AulaExtra) {
		this.m_ListaDeFrequencia_AulaExtra = m_ListaDeFrequencia_AulaExtra;
	}
	public PIO getM_ListaDeFrequencia_PIO() {
		return m_ListaDeFrequencia_PIO;
	}
	public void setM_ListaDeFrequencia_PIO(PIO m_ListaDeFrequencia_PIO) {
		this.m_ListaDeFrequencia_PIO = m_ListaDeFrequencia_PIO;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
*/	
}