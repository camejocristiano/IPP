package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class DadosFinanceiros extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String testDadosFinanceiros;
	/*private TipoDeContratacao assistenciaMedica_administradoPor;
	private Boolean assistenciaMedica_possui;
	private double assistenciaMedica_valor;
	private TipoDeContratacao assistenciaOdontologica_administradoPor;
	private Boolean assistenciaOdontologica_possui;
	private double assistenciaOdontologica_valor;
	private String contaCorrente_agencia;
	private String contaCorrente_banco;
	private String contaCorrente_cc;
	private String contaCorrente_numeroDoBanco;
	private String contaSalario_agencia;
	private String contaSalario_banco;
	private String contaSalario_cs;
	private String contaSalario_numeroDoBanco;
	private TipoDeContratacao dadosSalariais_administradoPor;
	private double dadosSalariais_salarioRS;
	private double dadosSalariais_salarioSMF;
	private TipoDeContratacao valeAlimentacao_administradoPor;
	private Boolean valeAlimentacao_usa;
	private double valeAlimentacao_valorRS;
	private Periodo valeAlimentacao_valorRSPeriodo;
	private double valeAlimentacao_valorSMF;
	private Periodo valeAlimentacao_valorSMFPeriodo;
	private Boolean valeRefeicao_usaValeRefeicao;
	private double valeRefeicao_valorEmpresaRS;
	private Periodo valeRefeicao_valorEmpresaRSPeriodo;
	private double valeRefeicao_valorEmpresaSMF;
	private Periodo valeRefeicao_valorEmpresaSMFPeriodo;
	private double valeRefeicao_valorIPPRS;
	private Periodo valeRefeicao_valorIPPRSPeriodo;
	private double valeRefeicao_valorIPPSMF;
	private Periodo valeRefeicao_valorIPPSMFPeriodo;
	private TipoDeContratacao valeRefeicaoEmpresa_administradoPor;
	private TipoDeContratacao valeRefeicaoIPP_administradoPor;
	private TipoDeContratacao valeTransporteEmpresaTrabalho_administradoPor;
	private Boolean valeTransporteEmpresaTrabalho_bem;
	private double valeTransporteEmpresaTrabalho_bemValor;
	private Boolean valeTransporteEmpresaTrabalho_bom;
	private double valeTransporteEmpresaTrabalho_bomValor;
	private Boolean valeTransporteEmpresaTrabalho_integracao;
	private double valeTransporteEmpresaTrabalho_integracaoValor;
	private Boolean valeTransporteEmpresaTrabalho_metro;
	private double valeTransporteEmpresaTrabalho_metroValor;
	private Boolean valeTransporteEmpresaTrabalho_onibusMunicipal;
	private double valeTransporteEmpresaTrabalho_onibusMunicipalValor;
	private Boolean valeTransporteEmpresaTrabalho_trem;
	private double valeTransporteEmpresaTrabalho_tremValor;
	private Boolean valeTransporteEmpresaTrabalho_usa;
	private TipoDeContratacao valeTransporteIPPCurso_administradoPor;
	private Boolean valeTransporteIPPCurso_bem;
	private double valeTransporteIPPCurso_bemValor;
	private Boolean valeTransporteIPPCurso_bom;
	private double valeTransporteIPPCurso_bomValor;
	private Boolean valeTransporteIPPCurso_integracao;
	private double valeTransporteIPPCurso_integracaoValor;
	private Boolean valeTransporteIPPCurso_metro;
	private double valeTransporteIPPCurso_metroValor;
	private Boolean valeTransporteIPPCurso_onibusMunicipal;
	private double valeTransporteIPPCurso_onibusMunicipalValor;
	private Boolean valeTransporteIPPCurso_trem;
	private double valeTransporteIPPCurso_tremValor;
	private Boolean valeTransporteIPPCurso_usa;*/

	public String getTestDadosFinanceiros() {
		return testDadosFinanceiros;
	}

	public void setTestDadosFinanceiros(String testDadosFinanceiros) {
		this.testDadosFinanceiros = testDadosFinanceiros;
	}
	
	
	
	/*public TipoDeContratacao getAssistenciaMedica_administradoPor() {
		return assistenciaMedica_administradoPor;
	}
	public void setAssistenciaMedica_administradoPor(TipoDeContratacao assistenciaMedica_administradoPor) {
		this.assistenciaMedica_administradoPor = assistenciaMedica_administradoPor;
	}
	public Boolean getAssistenciaMedica_possui() {
		return assistenciaMedica_possui;
	}
	public void setAssistenciaMedica_possui(Boolean assistenciaMedica_possui) {
		this.assistenciaMedica_possui = assistenciaMedica_possui;
	}
	public double getAssistenciaMedica_valor() {
		return assistenciaMedica_valor;
	}
	public void setAssistenciaMedica_valor(double assistenciaMedica_valor) {
		this.assistenciaMedica_valor = assistenciaMedica_valor;
	}
	public TipoDeContratacao getAssistenciaOdontologica_administradoPor() {
		return assistenciaOdontologica_administradoPor;
	}
	public void setAssistenciaOdontologica_administradoPor(TipoDeContratacao assistenciaOdontologica_administradoPor) {
		this.assistenciaOdontologica_administradoPor = assistenciaOdontologica_administradoPor;
	}
	public Boolean getAssistenciaOdontologica_possui() {
		return assistenciaOdontologica_possui;
	}
	public void setAssistenciaOdontologica_possui(Boolean assistenciaOdontologica_possui) {
		this.assistenciaOdontologica_possui = assistenciaOdontologica_possui;
	}
	public double getAssistenciaOdontologica_valor() {
		return assistenciaOdontologica_valor;
	}
	public void setAssistenciaOdontologica_valor(double assistenciaOdontologica_valor) {
		this.assistenciaOdontologica_valor = assistenciaOdontologica_valor;
	}
	public String getContaCorrente_agencia() {
		return contaCorrente_agencia;
	}
	public void setContaCorrente_agencia(String contaCorrente_agencia) {
		this.contaCorrente_agencia = contaCorrente_agencia;
	}
	public String getContaCorrente_banco() {
		return contaCorrente_banco;
	}
	public void setContaCorrente_banco(String contaCorrente_banco) {
		this.contaCorrente_banco = contaCorrente_banco;
	}
	public String getContaCorrente_cc() {
		return contaCorrente_cc;
	}
	public void setContaCorrente_cc(String contaCorrente_cc) {
		this.contaCorrente_cc = contaCorrente_cc;
	}
	public String getContaCorrente_numeroDoBanco() {
		return contaCorrente_numeroDoBanco;
	}
	public void setContaCorrente_numeroDoBanco(String contaCorrente_numeroDoBanco) {
		this.contaCorrente_numeroDoBanco = contaCorrente_numeroDoBanco;
	}
	public String getContaSalario_agencia() {
		return contaSalario_agencia;
	}
	public void setContaSalario_agencia(String contaSalario_agencia) {
		this.contaSalario_agencia = contaSalario_agencia;
	}
	public String getContaSalario_banco() {
		return contaSalario_banco;
	}
	public void setContaSalario_banco(String contaSalario_banco) {
		this.contaSalario_banco = contaSalario_banco;
	}
	public String getContaSalario_cs() {
		return contaSalario_cs;
	}
	public void setContaSalario_cs(String contaSalario_cs) {
		this.contaSalario_cs = contaSalario_cs;
	}
	public String getContaSalario_numeroDoBanco() {
		return contaSalario_numeroDoBanco;
	}
	public void setContaSalario_numeroDoBanco(String contaSalario_numeroDoBanco) {
		this.contaSalario_numeroDoBanco = contaSalario_numeroDoBanco;
	}
	public TipoDeContratacao getDadosSalariais_administradoPor() {
		return dadosSalariais_administradoPor;
	}
	public void setDadosSalariais_administradoPor(TipoDeContratacao dadosSalariais_administradoPor) {
		this.dadosSalariais_administradoPor = dadosSalariais_administradoPor;
	}
	public double getDadosSalariais_salarioRS() {
		return dadosSalariais_salarioRS;
	}
	public void setDadosSalariais_salarioRS(double dadosSalariais_salarioRS) {
		this.dadosSalariais_salarioRS = dadosSalariais_salarioRS;
	}
	public double getDadosSalariais_salarioSMF() {
		return dadosSalariais_salarioSMF;
	}
	public void setDadosSalariais_salarioSMF(double dadosSalariais_salarioSMF) {
		this.dadosSalariais_salarioSMF = dadosSalariais_salarioSMF;
	}
	public TipoDeContratacao getValeAlimentacao_administradoPor() {
		return valeAlimentacao_administradoPor;
	}
	public void setValeAlimentacao_administradoPor(TipoDeContratacao valeAlimentacao_administradoPor) {
		this.valeAlimentacao_administradoPor = valeAlimentacao_administradoPor;
	}
	public Boolean getValeAlimentacao_usa() {
		return valeAlimentacao_usa;
	}
	public void setValeAlimentacao_usa(Boolean valeAlimentacao_usa) {
		this.valeAlimentacao_usa = valeAlimentacao_usa;
	}
	public double getValeAlimentacao_valorRS() {
		return valeAlimentacao_valorRS;
	}
	public void setValeAlimentacao_valorRS(double valeAlimentacao_valorRS) {
		this.valeAlimentacao_valorRS = valeAlimentacao_valorRS;
	}
	public Periodo getValeAlimentacao_valorRSPeriodo() {
		return valeAlimentacao_valorRSPeriodo;
	}
	public void setValeAlimentacao_valorRSPeriodo(Periodo valeAlimentacao_valorRSPeriodo) {
		this.valeAlimentacao_valorRSPeriodo = valeAlimentacao_valorRSPeriodo;
	}
	public double getValeAlimentacao_valorSMF() {
		return valeAlimentacao_valorSMF;
	}
	public void setValeAlimentacao_valorSMF(double valeAlimentacao_valorSMF) {
		this.valeAlimentacao_valorSMF = valeAlimentacao_valorSMF;
	}
	public Periodo getValeAlimentacao_valorSMFPeriodo() {
		return valeAlimentacao_valorSMFPeriodo;
	}
	public void setValeAlimentacao_valorSMFPeriodo(Periodo valeAlimentacao_valorSMFPeriodo) {
		this.valeAlimentacao_valorSMFPeriodo = valeAlimentacao_valorSMFPeriodo;
	}
	public Boolean getValeRefeicao_usaValeRefeicao() {
		return valeRefeicao_usaValeRefeicao;
	}
	public void setValeRefeicao_usaValeRefeicao(Boolean valeRefeicao_usaValeRefeicao) {
		this.valeRefeicao_usaValeRefeicao = valeRefeicao_usaValeRefeicao;
	}
	public double getValeRefeicao_valorEmpresaRS() {
		return valeRefeicao_valorEmpresaRS;
	}
	public void setValeRefeicao_valorEmpresaRS(double valeRefeicao_valorEmpresaRS) {
		this.valeRefeicao_valorEmpresaRS = valeRefeicao_valorEmpresaRS;
	}
	public Periodo getValeRefeicao_valorEmpresaRSPeriodo() {
		return valeRefeicao_valorEmpresaRSPeriodo;
	}
	public void setValeRefeicao_valorEmpresaRSPeriodo(Periodo valeRefeicao_valorEmpresaRSPeriodo) {
		this.valeRefeicao_valorEmpresaRSPeriodo = valeRefeicao_valorEmpresaRSPeriodo;
	}
	public double getValeRefeicao_valorEmpresaSMF() {
		return valeRefeicao_valorEmpresaSMF;
	}
	public void setValeRefeicao_valorEmpresaSMF(double valeRefeicao_valorEmpresaSMF) {
		this.valeRefeicao_valorEmpresaSMF = valeRefeicao_valorEmpresaSMF;
	}
	public Periodo getValeRefeicao_valorEmpresaSMFPeriodo() {
		return valeRefeicao_valorEmpresaSMFPeriodo;
	}
	public void setValeRefeicao_valorEmpresaSMFPeriodo(Periodo valeRefeicao_valorEmpresaSMFPeriodo) {
		this.valeRefeicao_valorEmpresaSMFPeriodo = valeRefeicao_valorEmpresaSMFPeriodo;
	}
	public double getValeRefeicao_valorIPPRS() {
		return valeRefeicao_valorIPPRS;
	}
	public void setValeRefeicao_valorIPPRS(double valeRefeicao_valorIPPRS) {
		this.valeRefeicao_valorIPPRS = valeRefeicao_valorIPPRS;
	}
	public Periodo getValeRefeicao_valorIPPRSPeriodo() {
		return valeRefeicao_valorIPPRSPeriodo;
	}
	public void setValeRefeicao_valorIPPRSPeriodo(Periodo valeRefeicao_valorIPPRSPeriodo) {
		this.valeRefeicao_valorIPPRSPeriodo = valeRefeicao_valorIPPRSPeriodo;
	}
	public double getValeRefeicao_valorIPPSMF() {
		return valeRefeicao_valorIPPSMF;
	}
	public void setValeRefeicao_valorIPPSMF(double valeRefeicao_valorIPPSMF) {
		this.valeRefeicao_valorIPPSMF = valeRefeicao_valorIPPSMF;
	}
	public Periodo getValeRefeicao_valorIPPSMFPeriodo() {
		return valeRefeicao_valorIPPSMFPeriodo;
	}
	public void setValeRefeicao_valorIPPSMFPeriodo(Periodo valeRefeicao_valorIPPSMFPeriodo) {
		this.valeRefeicao_valorIPPSMFPeriodo = valeRefeicao_valorIPPSMFPeriodo;
	}
	public TipoDeContratacao getValeRefeicaoEmpresa_administradoPor() {
		return valeRefeicaoEmpresa_administradoPor;
	}
	public void setValeRefeicaoEmpresa_administradoPor(TipoDeContratacao valeRefeicaoEmpresa_administradoPor) {
		this.valeRefeicaoEmpresa_administradoPor = valeRefeicaoEmpresa_administradoPor;
	}
	public TipoDeContratacao getValeRefeicaoIPP_administradoPor() {
		return valeRefeicaoIPP_administradoPor;
	}
	public void setValeRefeicaoIPP_administradoPor(TipoDeContratacao valeRefeicaoIPP_administradoPor) {
		this.valeRefeicaoIPP_administradoPor = valeRefeicaoIPP_administradoPor;
	}
	public TipoDeContratacao getValeTransporteEmpresaTrabalho_administradoPor() {
		return valeTransporteEmpresaTrabalho_administradoPor;
	}
	public void setValeTransporteEmpresaTrabalho_administradoPor(
			TipoDeContratacao valeTransporteEmpresaTrabalho_administradoPor) {
		this.valeTransporteEmpresaTrabalho_administradoPor = valeTransporteEmpresaTrabalho_administradoPor;
	}
	public Boolean getValeTransporteEmpresaTrabalho_bem() {
		return valeTransporteEmpresaTrabalho_bem;
	}
	public void setValeTransporteEmpresaTrabalho_bem(Boolean valeTransporteEmpresaTrabalho_bem) {
		this.valeTransporteEmpresaTrabalho_bem = valeTransporteEmpresaTrabalho_bem;
	}
	public double getValeTransporteEmpresaTrabalho_bemValor() {
		return valeTransporteEmpresaTrabalho_bemValor;
	}
	public void setValeTransporteEmpresaTrabalho_bemValor(double valeTransporteEmpresaTrabalho_bemValor) {
		this.valeTransporteEmpresaTrabalho_bemValor = valeTransporteEmpresaTrabalho_bemValor;
	}
	public Boolean getValeTransporteEmpresaTrabalho_bom() {
		return valeTransporteEmpresaTrabalho_bom;
	}
	public void setValeTransporteEmpresaTrabalho_bom(Boolean valeTransporteEmpresaTrabalho_bom) {
		this.valeTransporteEmpresaTrabalho_bom = valeTransporteEmpresaTrabalho_bom;
	}
	public double getValeTransporteEmpresaTrabalho_bomValor() {
		return valeTransporteEmpresaTrabalho_bomValor;
	}
	public void setValeTransporteEmpresaTrabalho_bomValor(double valeTransporteEmpresaTrabalho_bomValor) {
		this.valeTransporteEmpresaTrabalho_bomValor = valeTransporteEmpresaTrabalho_bomValor;
	}
	public Boolean getValeTransporteEmpresaTrabalho_integracao() {
		return valeTransporteEmpresaTrabalho_integracao;
	}
	public void setValeTransporteEmpresaTrabalho_integracao(Boolean valeTransporteEmpresaTrabalho_integracao) {
		this.valeTransporteEmpresaTrabalho_integracao = valeTransporteEmpresaTrabalho_integracao;
	}
	public double getValeTransporteEmpresaTrabalho_integracaoValor() {
		return valeTransporteEmpresaTrabalho_integracaoValor;
	}
	public void setValeTransporteEmpresaTrabalho_integracaoValor(double valeTransporteEmpresaTrabalho_integracaoValor) {
		this.valeTransporteEmpresaTrabalho_integracaoValor = valeTransporteEmpresaTrabalho_integracaoValor;
	}
	public Boolean getValeTransporteEmpresaTrabalho_metro() {
		return valeTransporteEmpresaTrabalho_metro;
	}
	public void setValeTransporteEmpresaTrabalho_metro(Boolean valeTransporteEmpresaTrabalho_metro) {
		this.valeTransporteEmpresaTrabalho_metro = valeTransporteEmpresaTrabalho_metro;
	}
	public double getValeTransporteEmpresaTrabalho_metroValor() {
		return valeTransporteEmpresaTrabalho_metroValor;
	}
	public void setValeTransporteEmpresaTrabalho_metroValor(double valeTransporteEmpresaTrabalho_metroValor) {
		this.valeTransporteEmpresaTrabalho_metroValor = valeTransporteEmpresaTrabalho_metroValor;
	}
	public Boolean getValeTransporteEmpresaTrabalho_onibusMunicipal() {
		return valeTransporteEmpresaTrabalho_onibusMunicipal;
	}
	public void setValeTransporteEmpresaTrabalho_onibusMunicipal(Boolean valeTransporteEmpresaTrabalho_onibusMunicipal) {
		this.valeTransporteEmpresaTrabalho_onibusMunicipal = valeTransporteEmpresaTrabalho_onibusMunicipal;
	}
	public double getValeTransporteEmpresaTrabalho_onibusMunicipalValor() {
		return valeTransporteEmpresaTrabalho_onibusMunicipalValor;
	}
	public void setValeTransporteEmpresaTrabalho_onibusMunicipalValor(
			double valeTransporteEmpresaTrabalho_onibusMunicipalValor) {
		this.valeTransporteEmpresaTrabalho_onibusMunicipalValor = valeTransporteEmpresaTrabalho_onibusMunicipalValor;
	}
	public Boolean getValeTransporteEmpresaTrabalho_trem() {
		return valeTransporteEmpresaTrabalho_trem;
	}
	public void setValeTransporteEmpresaTrabalho_trem(Boolean valeTransporteEmpresaTrabalho_trem) {
		this.valeTransporteEmpresaTrabalho_trem = valeTransporteEmpresaTrabalho_trem;
	}
	public double getValeTransporteEmpresaTrabalho_tremValor() {
		return valeTransporteEmpresaTrabalho_tremValor;
	}
	public void setValeTransporteEmpresaTrabalho_tremValor(double valeTransporteEmpresaTrabalho_tremValor) {
		this.valeTransporteEmpresaTrabalho_tremValor = valeTransporteEmpresaTrabalho_tremValor;
	}
	public Boolean getValeTransporteEmpresaTrabalho_usa() {
		return valeTransporteEmpresaTrabalho_usa;
	}
	public void setValeTransporteEmpresaTrabalho_usa(Boolean valeTransporteEmpresaTrabalho_usa) {
		this.valeTransporteEmpresaTrabalho_usa = valeTransporteEmpresaTrabalho_usa;
	}
	public TipoDeContratacao getValeTransporteIPPCurso_administradoPor() {
		return valeTransporteIPPCurso_administradoPor;
	}
	public void setValeTransporteIPPCurso_administradoPor(TipoDeContratacao valeTransporteIPPCurso_administradoPor) {
		this.valeTransporteIPPCurso_administradoPor = valeTransporteIPPCurso_administradoPor;
	}
	public Boolean getValeTransporteIPPCurso_bem() {
		return valeTransporteIPPCurso_bem;
	}
	public void setValeTransporteIPPCurso_bem(Boolean valeTransporteIPPCurso_bem) {
		this.valeTransporteIPPCurso_bem = valeTransporteIPPCurso_bem;
	}
	public double getValeTransporteIPPCurso_bemValor() {
		return valeTransporteIPPCurso_bemValor;
	}
	public void setValeTransporteIPPCurso_bemValor(double valeTransporteIPPCurso_bemValor) {
		this.valeTransporteIPPCurso_bemValor = valeTransporteIPPCurso_bemValor;
	}
	public Boolean getValeTransporteIPPCurso_bom() {
		return valeTransporteIPPCurso_bom;
	}
	public void setValeTransporteIPPCurso_bom(Boolean valeTransporteIPPCurso_bom) {
		this.valeTransporteIPPCurso_bom = valeTransporteIPPCurso_bom;
	}
	public double getValeTransporteIPPCurso_bomValor() {
		return valeTransporteIPPCurso_bomValor;
	}
	public void setValeTransporteIPPCurso_bomValor(double valeTransporteIPPCurso_bomValor) {
		this.valeTransporteIPPCurso_bomValor = valeTransporteIPPCurso_bomValor;
	}
	public Boolean getValeTransporteIPPCurso_integracao() {
		return valeTransporteIPPCurso_integracao;
	}
	public void setValeTransporteIPPCurso_integracao(Boolean valeTransporteIPPCurso_integracao) {
		this.valeTransporteIPPCurso_integracao = valeTransporteIPPCurso_integracao;
	}
	public double getValeTransporteIPPCurso_integracaoValor() {
		return valeTransporteIPPCurso_integracaoValor;
	}
	public void setValeTransporteIPPCurso_integracaoValor(double valeTransporteIPPCurso_integracaoValor) {
		this.valeTransporteIPPCurso_integracaoValor = valeTransporteIPPCurso_integracaoValor;
	}
	public Boolean getValeTransporteIPPCurso_metro() {
		return valeTransporteIPPCurso_metro;
	}
	public void setValeTransporteIPPCurso_metro(Boolean valeTransporteIPPCurso_metro) {
		this.valeTransporteIPPCurso_metro = valeTransporteIPPCurso_metro;
	}
	public double getValeTransporteIPPCurso_metroValor() {
		return valeTransporteIPPCurso_metroValor;
	}
	public void setValeTransporteIPPCurso_metroValor(double valeTransporteIPPCurso_metroValor) {
		this.valeTransporteIPPCurso_metroValor = valeTransporteIPPCurso_metroValor;
	}
	public Boolean getValeTransporteIPPCurso_onibusMunicipal() {
		return valeTransporteIPPCurso_onibusMunicipal;
	}
	public void setValeTransporteIPPCurso_onibusMunicipal(Boolean valeTransporteIPPCurso_onibusMunicipal) {
		this.valeTransporteIPPCurso_onibusMunicipal = valeTransporteIPPCurso_onibusMunicipal;
	}
	public double getValeTransporteIPPCurso_onibusMunicipalValor() {
		return valeTransporteIPPCurso_onibusMunicipalValor;
	}
	public void setValeTransporteIPPCurso_onibusMunicipalValor(double valeTransporteIPPCurso_onibusMunicipalValor) {
		this.valeTransporteIPPCurso_onibusMunicipalValor = valeTransporteIPPCurso_onibusMunicipalValor;
	}
	public Boolean getValeTransporteIPPCurso_trem() {
		return valeTransporteIPPCurso_trem;
	}
	public void setValeTransporteIPPCurso_trem(Boolean valeTransporteIPPCurso_trem) {
		this.valeTransporteIPPCurso_trem = valeTransporteIPPCurso_trem;
	}
	public double getValeTransporteIPPCurso_tremValor() {
		return valeTransporteIPPCurso_tremValor;
	}
	public void setValeTransporteIPPCurso_tremValor(double valeTransporteIPPCurso_tremValor) {
		this.valeTransporteIPPCurso_tremValor = valeTransporteIPPCurso_tremValor;
	}
	public Boolean getValeTransporteIPPCurso_usa() {
		return valeTransporteIPPCurso_usa;
	}
	public void setValeTransporteIPPCurso_usa(Boolean valeTransporteIPPCurso_usa) {
		this.valeTransporteIPPCurso_usa = valeTransporteIPPCurso_usa;
	}*/
	
}