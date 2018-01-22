package br.net.ipp.models.aprendizes;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.net.ipp.enums.Periodo;
import br.net.ipp.enums.TipoDeContratacao;
import br.net.ipp.models.AbstractEntity;

@Entity
public class DadosFinanceiros extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	// Dados Salariais
	private BigDecimal dadosSalariais_salarioRS;
	private BigDecimal dadosSalariais_salarioSMF;
	private TipoDeContratacao dadosSalariais_administradoPor;
	// Conta Salário
	private String contaSalario_agencia;
	private String contaSalario_banco;
	private String contaSalario_cs;
	private String contaSalario_numeroDoBanco;
	// Conta Corrente
	private String contaCorrente_agencia;
	private String contaCorrente_banco;
	private String contaCorrente_cc;
	private String contaCorrente_numeroDoBanco;
	// Vale Transporte Empresa Trabalho
	private TipoDeContratacao valeTransporteEmpresaTrabalho_administradoPor;
	private boolean valeTransporteEmpresaTrabalho_bem;
	private BigDecimal valeTransporteEmpresaTrabalho_bemValor;
	private boolean valeTransporteEmpresaTrabalho_bom;
	private BigDecimal valeTransporteEmpresaTrabalho_bomValor;
	private boolean valeTransporteEmpresaTrabalho_integracao;
	private BigDecimal valeTransporteEmpresaTrabalho_integracaoValor;
	private boolean valeTransporteEmpresaTrabalho_metro;
	private BigDecimal valeTransporteEmpresaTrabalho_metroValor;
	private boolean valeTransporteEmpresaTrabalho_onibusMunicipal;
	private BigDecimal valeTransporteEmpresaTrabalho_onibusMunicipalValor;
	private boolean valeTransporteEmpresaTrabalho_trem;
	private BigDecimal valeTransporteEmpresaTrabalho_tremValor;
	private boolean valeTransporteEmpresaTrabalho_usa;
	// Vale Transporte Ipp Curso
	private TipoDeContratacao valeTransporteIPPCurso_administradoPor;
	private boolean valeTransporteIPPCurso_bem;
	private BigDecimal valeTransporteIPPCurso_bemValor;
	private boolean valeTransporteIPPCurso_bom;
	private BigDecimal valeTransporteIPPCurso_bomValor;
	private boolean valeTransporteIPPCurso_integracao;
	private BigDecimal valeTransporteIPPCurso_integracaoValor;
	private boolean valeTransporteIPPCurso_metro;
	private BigDecimal valeTransporteIPPCurso_metroValor;
	private boolean valeTransporteIPPCurso_onibusMunicipal;
	private BigDecimal valeTransporteIPPCurso_onibusMunicipalValor;
	private boolean valeTransporteIPPCurso_trem;
	private BigDecimal valeTransporteIPPCurso_tremValor;
	private boolean valeTransporteIPPCurso_usa;
	// Vale Refeição
	private boolean valeRefeicao_usaValeRefeicao;
	private BigDecimal valeRefeicao_valorEmpresaRS;
	private Periodo valeRefeicao_valorEmpresaRSPeriodo;
	private BigDecimal valeRefeicao_valorEmpresaSMF;
	private Periodo valeRefeicao_valorEmpresaSMFPeriodo;
	private BigDecimal valeRefeicao_valorIPPRS;
	private Periodo valeRefeicao_valorIPPRSPeriodo;
	private BigDecimal valeRefeicao_valorIPPSMF;
	private Periodo valeRefeicao_valorIPPSMFPeriodo;
	private TipoDeContratacao valeRefeicaoEmpresa_administradoPor;
	private TipoDeContratacao valeRefeicaoIPP_administradoPor;
	// Vale Alimentação
	private TipoDeContratacao valeAlimentacao_administradoPor;
	private boolean valeAlimentacao_usa;
	private BigDecimal valeAlimentacao_valorRS;
	private Periodo valeAlimentacao_valorRSPeriodo;
	private BigDecimal valeAlimentacao_valorSMF;
	private Periodo valeAlimentacao_valorSMFPeriodo;
	// Assistência Médica
	private TipoDeContratacao assistenciaMedica_administradoPor;
	private boolean assistenciaMedica_possui;
	private BigDecimal assistenciaMedica_valor;
	// Assistência Odontológica
	private TipoDeContratacao assistenciaOdontologica_administradoPor;
	private boolean assistenciaOdontologica_possui;
	private BigDecimal assistenciaOdontologica_valor;
	// Observações
	private String observacoes; 
	// Jovem
	@OneToOne
	private Jovem jovem;
	
	
	public BigDecimal getDadosSalariais_salarioRS() {
		return dadosSalariais_salarioRS;
	}
	public void setDadosSalariais_salarioRS(BigDecimal dadosSalariais_salarioRS) {
		this.dadosSalariais_salarioRS = dadosSalariais_salarioRS;
	}
	public BigDecimal getDadosSalariais_salarioSMF() {
		return dadosSalariais_salarioSMF;
	}
	public void setDadosSalariais_salarioSMF(BigDecimal dadosSalariais_salarioSMF) {
		this.dadosSalariais_salarioSMF = dadosSalariais_salarioSMF;
	}
	public TipoDeContratacao getDadosSalariais_administradoPor() {
		return dadosSalariais_administradoPor;
	}
	public void setDadosSalariais_administradoPor(TipoDeContratacao dadosSalariais_administradoPor) {
		this.dadosSalariais_administradoPor = dadosSalariais_administradoPor;
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
	public TipoDeContratacao getValeTransporteEmpresaTrabalho_administradoPor() {
		return valeTransporteEmpresaTrabalho_administradoPor;
	}
	public void setValeTransporteEmpresaTrabalho_administradoPor(
			TipoDeContratacao valeTransporteEmpresaTrabalho_administradoPor) {
		this.valeTransporteEmpresaTrabalho_administradoPor = valeTransporteEmpresaTrabalho_administradoPor;
	}
	public boolean isValeTransporteEmpresaTrabalho_bem() {
		return valeTransporteEmpresaTrabalho_bem;
	}
	public void setValeTransporteEmpresaTrabalho_bem(boolean valeTransporteEmpresaTrabalho_bem) {
		this.valeTransporteEmpresaTrabalho_bem = valeTransporteEmpresaTrabalho_bem;
	}
	public BigDecimal getValeTransporteEmpresaTrabalho_bemValor() {
		return valeTransporteEmpresaTrabalho_bemValor;
	}
	public void setValeTransporteEmpresaTrabalho_bemValor(BigDecimal valeTransporteEmpresaTrabalho_bemValor) {
		this.valeTransporteEmpresaTrabalho_bemValor = valeTransporteEmpresaTrabalho_bemValor;
	}
	public boolean isValeTransporteEmpresaTrabalho_bom() {
		return valeTransporteEmpresaTrabalho_bom;
	}
	public void setValeTransporteEmpresaTrabalho_bom(boolean valeTransporteEmpresaTrabalho_bom) {
		this.valeTransporteEmpresaTrabalho_bom = valeTransporteEmpresaTrabalho_bom;
	}
	public BigDecimal getValeTransporteEmpresaTrabalho_bomValor() {
		return valeTransporteEmpresaTrabalho_bomValor;
	}
	public void setValeTransporteEmpresaTrabalho_bomValor(BigDecimal valeTransporteEmpresaTrabalho_bomValor) {
		this.valeTransporteEmpresaTrabalho_bomValor = valeTransporteEmpresaTrabalho_bomValor;
	}
	public boolean isValeTransporteEmpresaTrabalho_integracao() {
		return valeTransporteEmpresaTrabalho_integracao;
	}
	public void setValeTransporteEmpresaTrabalho_integracao(boolean valeTransporteEmpresaTrabalho_integracao) {
		this.valeTransporteEmpresaTrabalho_integracao = valeTransporteEmpresaTrabalho_integracao;
	}
	public BigDecimal getValeTransporteEmpresaTrabalho_integracaoValor() {
		return valeTransporteEmpresaTrabalho_integracaoValor;
	}
	public void setValeTransporteEmpresaTrabalho_integracaoValor(BigDecimal valeTransporteEmpresaTrabalho_integracaoValor) {
		this.valeTransporteEmpresaTrabalho_integracaoValor = valeTransporteEmpresaTrabalho_integracaoValor;
	}
	public boolean isValeTransporteEmpresaTrabalho_metro() {
		return valeTransporteEmpresaTrabalho_metro;
	}
	public void setValeTransporteEmpresaTrabalho_metro(boolean valeTransporteEmpresaTrabalho_metro) {
		this.valeTransporteEmpresaTrabalho_metro = valeTransporteEmpresaTrabalho_metro;
	}
	public BigDecimal getValeTransporteEmpresaTrabalho_metroValor() {
		return valeTransporteEmpresaTrabalho_metroValor;
	}
	public void setValeTransporteEmpresaTrabalho_metroValor(BigDecimal valeTransporteEmpresaTrabalho_metroValor) {
		this.valeTransporteEmpresaTrabalho_metroValor = valeTransporteEmpresaTrabalho_metroValor;
	}
	public boolean isValeTransporteEmpresaTrabalho_onibusMunicipal() {
		return valeTransporteEmpresaTrabalho_onibusMunicipal;
	}
	public void setValeTransporteEmpresaTrabalho_onibusMunicipal(boolean valeTransporteEmpresaTrabalho_onibusMunicipal) {
		this.valeTransporteEmpresaTrabalho_onibusMunicipal = valeTransporteEmpresaTrabalho_onibusMunicipal;
	}
	public BigDecimal getValeTransporteEmpresaTrabalho_onibusMunicipalValor() {
		return valeTransporteEmpresaTrabalho_onibusMunicipalValor;
	}
	public void setValeTransporteEmpresaTrabalho_onibusMunicipalValor(
			BigDecimal valeTransporteEmpresaTrabalho_onibusMunicipalValor) {
		this.valeTransporteEmpresaTrabalho_onibusMunicipalValor = valeTransporteEmpresaTrabalho_onibusMunicipalValor;
	}
	public boolean isValeTransporteEmpresaTrabalho_trem() {
		return valeTransporteEmpresaTrabalho_trem;
	}
	public void setValeTransporteEmpresaTrabalho_trem(boolean valeTransporteEmpresaTrabalho_trem) {
		this.valeTransporteEmpresaTrabalho_trem = valeTransporteEmpresaTrabalho_trem;
	}
	public BigDecimal getValeTransporteEmpresaTrabalho_tremValor() {
		return valeTransporteEmpresaTrabalho_tremValor;
	}
	public void setValeTransporteEmpresaTrabalho_tremValor(BigDecimal valeTransporteEmpresaTrabalho_tremValor) {
		this.valeTransporteEmpresaTrabalho_tremValor = valeTransporteEmpresaTrabalho_tremValor;
	}
	public boolean isValeTransporteEmpresaTrabalho_usa() {
		return valeTransporteEmpresaTrabalho_usa;
	}
	public void setValeTransporteEmpresaTrabalho_usa(boolean valeTransporteEmpresaTrabalho_usa) {
		this.valeTransporteEmpresaTrabalho_usa = valeTransporteEmpresaTrabalho_usa;
	}
	public TipoDeContratacao getValeTransporteIPPCurso_administradoPor() {
		return valeTransporteIPPCurso_administradoPor;
	}
	public void setValeTransporteIPPCurso_administradoPor(TipoDeContratacao valeTransporteIPPCurso_administradoPor) {
		this.valeTransporteIPPCurso_administradoPor = valeTransporteIPPCurso_administradoPor;
	}
	public boolean isValeTransporteIPPCurso_bem() {
		return valeTransporteIPPCurso_bem;
	}
	public void setValeTransporteIPPCurso_bem(boolean valeTransporteIPPCurso_bem) {
		this.valeTransporteIPPCurso_bem = valeTransporteIPPCurso_bem;
	}
	public BigDecimal getValeTransporteIPPCurso_bemValor() {
		return valeTransporteIPPCurso_bemValor;
	}
	public void setValeTransporteIPPCurso_bemValor(BigDecimal valeTransporteIPPCurso_bemValor) {
		this.valeTransporteIPPCurso_bemValor = valeTransporteIPPCurso_bemValor;
	}
	public boolean isValeTransporteIPPCurso_bom() {
		return valeTransporteIPPCurso_bom;
	}
	public void setValeTransporteIPPCurso_bom(boolean valeTransporteIPPCurso_bom) {
		this.valeTransporteIPPCurso_bom = valeTransporteIPPCurso_bom;
	}
	public BigDecimal getValeTransporteIPPCurso_bomValor() {
		return valeTransporteIPPCurso_bomValor;
	}
	public void setValeTransporteIPPCurso_bomValor(BigDecimal valeTransporteIPPCurso_bomValor) {
		this.valeTransporteIPPCurso_bomValor = valeTransporteIPPCurso_bomValor;
	}
	public boolean isValeTransporteIPPCurso_integracao() {
		return valeTransporteIPPCurso_integracao;
	}
	public void setValeTransporteIPPCurso_integracao(boolean valeTransporteIPPCurso_integracao) {
		this.valeTransporteIPPCurso_integracao = valeTransporteIPPCurso_integracao;
	}
	public BigDecimal getValeTransporteIPPCurso_integracaoValor() {
		return valeTransporteIPPCurso_integracaoValor;
	}
	public void setValeTransporteIPPCurso_integracaoValor(BigDecimal valeTransporteIPPCurso_integracaoValor) {
		this.valeTransporteIPPCurso_integracaoValor = valeTransporteIPPCurso_integracaoValor;
	}
	public boolean isValeTransporteIPPCurso_metro() {
		return valeTransporteIPPCurso_metro;
	}
	public void setValeTransporteIPPCurso_metro(boolean valeTransporteIPPCurso_metro) {
		this.valeTransporteIPPCurso_metro = valeTransporteIPPCurso_metro;
	}
	public BigDecimal getValeTransporteIPPCurso_metroValor() {
		return valeTransporteIPPCurso_metroValor;
	}
	public void setValeTransporteIPPCurso_metroValor(BigDecimal valeTransporteIPPCurso_metroValor) {
		this.valeTransporteIPPCurso_metroValor = valeTransporteIPPCurso_metroValor;
	}
	public boolean isValeTransporteIPPCurso_onibusMunicipal() {
		return valeTransporteIPPCurso_onibusMunicipal;
	}
	public void setValeTransporteIPPCurso_onibusMunicipal(boolean valeTransporteIPPCurso_onibusMunicipal) {
		this.valeTransporteIPPCurso_onibusMunicipal = valeTransporteIPPCurso_onibusMunicipal;
	}
	public BigDecimal getValeTransporteIPPCurso_onibusMunicipalValor() {
		return valeTransporteIPPCurso_onibusMunicipalValor;
	}
	public void setValeTransporteIPPCurso_onibusMunicipalValor(BigDecimal valeTransporteIPPCurso_onibusMunicipalValor) {
		this.valeTransporteIPPCurso_onibusMunicipalValor = valeTransporteIPPCurso_onibusMunicipalValor;
	}
	public boolean isValeTransporteIPPCurso_trem() {
		return valeTransporteIPPCurso_trem;
	}
	public void setValeTransporteIPPCurso_trem(boolean valeTransporteIPPCurso_trem) {
		this.valeTransporteIPPCurso_trem = valeTransporteIPPCurso_trem;
	}
	public BigDecimal getValeTransporteIPPCurso_tremValor() {
		return valeTransporteIPPCurso_tremValor;
	}
	public void setValeTransporteIPPCurso_tremValor(BigDecimal valeTransporteIPPCurso_tremValor) {
		this.valeTransporteIPPCurso_tremValor = valeTransporteIPPCurso_tremValor;
	}
	public boolean isValeTransporteIPPCurso_usa() {
		return valeTransporteIPPCurso_usa;
	}
	public void setValeTransporteIPPCurso_usa(boolean valeTransporteIPPCurso_usa) {
		this.valeTransporteIPPCurso_usa = valeTransporteIPPCurso_usa;
	}
	public boolean isValeRefeicao_usaValeRefeicao() {
		return valeRefeicao_usaValeRefeicao;
	}
	public void setValeRefeicao_usaValeRefeicao(boolean valeRefeicao_usaValeRefeicao) {
		this.valeRefeicao_usaValeRefeicao = valeRefeicao_usaValeRefeicao;
	}
	public BigDecimal getValeRefeicao_valorEmpresaRS() {
		return valeRefeicao_valorEmpresaRS;
	}
	public void setValeRefeicao_valorEmpresaRS(BigDecimal valeRefeicao_valorEmpresaRS) {
		this.valeRefeicao_valorEmpresaRS = valeRefeicao_valorEmpresaRS;
	}
	public Periodo getValeRefeicao_valorEmpresaRSPeriodo() {
		return valeRefeicao_valorEmpresaRSPeriodo;
	}
	public void setValeRefeicao_valorEmpresaRSPeriodo(Periodo valeRefeicao_valorEmpresaRSPeriodo) {
		this.valeRefeicao_valorEmpresaRSPeriodo = valeRefeicao_valorEmpresaRSPeriodo;
	}
	public BigDecimal getValeRefeicao_valorEmpresaSMF() {
		return valeRefeicao_valorEmpresaSMF;
	}
	public void setValeRefeicao_valorEmpresaSMF(BigDecimal valeRefeicao_valorEmpresaSMF) {
		this.valeRefeicao_valorEmpresaSMF = valeRefeicao_valorEmpresaSMF;
	}
	public Periodo getValeRefeicao_valorEmpresaSMFPeriodo() {
		return valeRefeicao_valorEmpresaSMFPeriodo;
	}
	public void setValeRefeicao_valorEmpresaSMFPeriodo(Periodo valeRefeicao_valorEmpresaSMFPeriodo) {
		this.valeRefeicao_valorEmpresaSMFPeriodo = valeRefeicao_valorEmpresaSMFPeriodo;
	}
	public BigDecimal getValeRefeicao_valorIPPRS() {
		return valeRefeicao_valorIPPRS;
	}
	public void setValeRefeicao_valorIPPRS(BigDecimal valeRefeicao_valorIPPRS) {
		this.valeRefeicao_valorIPPRS = valeRefeicao_valorIPPRS;
	}
	public Periodo getValeRefeicao_valorIPPRSPeriodo() {
		return valeRefeicao_valorIPPRSPeriodo;
	}
	public void setValeRefeicao_valorIPPRSPeriodo(Periodo valeRefeicao_valorIPPRSPeriodo) {
		this.valeRefeicao_valorIPPRSPeriodo = valeRefeicao_valorIPPRSPeriodo;
	}
	public BigDecimal getValeRefeicao_valorIPPSMF() {
		return valeRefeicao_valorIPPSMF;
	}
	public void setValeRefeicao_valorIPPSMF(BigDecimal valeRefeicao_valorIPPSMF) {
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
	public TipoDeContratacao getValeAlimentacao_administradoPor() {
		return valeAlimentacao_administradoPor;
	}
	public void setValeAlimentacao_administradoPor(TipoDeContratacao valeAlimentacao_administradoPor) {
		this.valeAlimentacao_administradoPor = valeAlimentacao_administradoPor;
	}
	public boolean isValeAlimentacao_usa() {
		return valeAlimentacao_usa;
	}
	public void setValeAlimentacao_usa(boolean valeAlimentacao_usa) {
		this.valeAlimentacao_usa = valeAlimentacao_usa;
	}
	public BigDecimal getValeAlimentacao_valorRS() {
		return valeAlimentacao_valorRS;
	}
	public void setValeAlimentacao_valorRS(BigDecimal valeAlimentacao_valorRS) {
		this.valeAlimentacao_valorRS = valeAlimentacao_valorRS;
	}
	public Periodo getValeAlimentacao_valorRSPeriodo() {
		return valeAlimentacao_valorRSPeriodo;
	}
	public void setValeAlimentacao_valorRSPeriodo(Periodo valeAlimentacao_valorRSPeriodo) {
		this.valeAlimentacao_valorRSPeriodo = valeAlimentacao_valorRSPeriodo;
	}
	public BigDecimal getValeAlimentacao_valorSMF() {
		return valeAlimentacao_valorSMF;
	}
	public void setValeAlimentacao_valorSMF(BigDecimal valeAlimentacao_valorSMF) {
		this.valeAlimentacao_valorSMF = valeAlimentacao_valorSMF;
	}
	public Periodo getValeAlimentacao_valorSMFPeriodo() {
		return valeAlimentacao_valorSMFPeriodo;
	}
	public void setValeAlimentacao_valorSMFPeriodo(Periodo valeAlimentacao_valorSMFPeriodo) {
		this.valeAlimentacao_valorSMFPeriodo = valeAlimentacao_valorSMFPeriodo;
	}
	public TipoDeContratacao getAssistenciaMedica_administradoPor() {
		return assistenciaMedica_administradoPor;
	}
	public void setAssistenciaMedica_administradoPor(TipoDeContratacao assistenciaMedica_administradoPor) {
		this.assistenciaMedica_administradoPor = assistenciaMedica_administradoPor;
	}
	public boolean isAssistenciaMedica_possui() {
		return assistenciaMedica_possui;
	}
	public void setAssistenciaMedica_possui(boolean assistenciaMedica_possui) {
		this.assistenciaMedica_possui = assistenciaMedica_possui;
	}
	public BigDecimal getAssistenciaMedica_valor() {
		return assistenciaMedica_valor;
	}
	public void setAssistenciaMedica_valor(BigDecimal assistenciaMedica_valor) {
		this.assistenciaMedica_valor = assistenciaMedica_valor;
	}
	public TipoDeContratacao getAssistenciaOdontologica_administradoPor() {
		return assistenciaOdontologica_administradoPor;
	}
	public void setAssistenciaOdontologica_administradoPor(TipoDeContratacao assistenciaOdontologica_administradoPor) {
		this.assistenciaOdontologica_administradoPor = assistenciaOdontologica_administradoPor;
	}
	public boolean isAssistenciaOdontologica_possui() {
		return assistenciaOdontologica_possui;
	}
	public void setAssistenciaOdontologica_possui(boolean assistenciaOdontologica_possui) {
		this.assistenciaOdontologica_possui = assistenciaOdontologica_possui;
	}
	public BigDecimal getAssistenciaOdontologica_valor() {
		return assistenciaOdontologica_valor;
	}
	public void setAssistenciaOdontologica_valor(BigDecimal assistenciaOdontologica_valor) {
		this.assistenciaOdontologica_valor = assistenciaOdontologica_valor;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}