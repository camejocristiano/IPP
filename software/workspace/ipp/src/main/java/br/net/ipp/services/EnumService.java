package br.net.ipp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.net.ipp.enums.AEDiaDaSemana;
import br.net.ipp.enums.Area;
import br.net.ipp.enums.AuxilioDoGoverno;
import br.net.ipp.enums.DiaDaSemana;
import br.net.ipp.enums.Escolaridade;
import br.net.ipp.enums.EstadoCivil;
import br.net.ipp.enums.FrequenciaEnum;
import br.net.ipp.enums.HabilidadeManual;
import br.net.ipp.enums.MotivoDaDispensa;
import br.net.ipp.enums.Periodo;
import br.net.ipp.enums.Regiao;
import br.net.ipp.enums.RelacaoFuncional;
import br.net.ipp.enums.ServicoMilitarSituacao;
import br.net.ipp.enums.Sexo;
import br.net.ipp.enums.SituacaoAtual;
import br.net.ipp.enums.SituacaoDaMoradia;
import br.net.ipp.enums.Status;
import br.net.ipp.enums.StatusDaMatricula;
import br.net.ipp.enums.StatusPAP;
import br.net.ipp.enums.StatusValidacao;
import br.net.ipp.enums.TipoDeCNH;
import br.net.ipp.enums.TipoDeConstrucao;
import br.net.ipp.enums.TipoDeContratacao;
import br.net.ipp.enums.TipoDeEmpresa;
import br.net.ipp.enums.TipoDeInsercao;
import br.net.ipp.enums.TipoDeMoradia;
import br.net.ipp.enums.TipoDeParceria;
import br.net.ipp.enums.TipoDeValidacao;
import br.net.ipp.enums.TipoTurmaEnum;
import br.net.ipp.enums.TurnoEnum;

@Service
public class EnumService {

	public List<String> carregarSexo() {
		List<Sexo> lista = Arrays.asList(Sexo.values());
		List<String> sexo = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			sexo.add(lista.get(i).name());
		}
		return sexo;
	}
	
	public List<String> carregarStatus() {
		List<Status> lista = Arrays.asList(Status.values());
		List<String> status = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			status.add(lista.get(i).name());
		}
		return status;
	}
	
	public List<String> carregarEstadoCivil() {
		List<EstadoCivil> lista = Arrays.asList(EstadoCivil.values());
		List<String> estadoCivil = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			estadoCivil.add(lista.get(i).name());
		}
		return estadoCivil;
	}
	
	public List<String> carregarRelacaoFuncional() {
		List<RelacaoFuncional> lista = Arrays.asList(RelacaoFuncional.values());
		List<String> relacaoFuncional = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			relacaoFuncional.add(lista.get(i).name());
		}
		return relacaoFuncional;
	}
	
	public List<String> carregarRegiao() {
		List<Regiao> lista = Arrays.asList(Regiao.values());
		List<String> regiao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			regiao.add(lista.get(i).name());
		}
		return regiao;
	}
	
	public List<String> carregarStatusPAP() {
		List<StatusPAP> lista = Arrays.asList(StatusPAP.values());
		List<String> statusPAP = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			statusPAP.add(lista.get(i).name());
		}
		return statusPAP;
	}
	
	public List<String> carregarDiasDaSemana() {
		List<DiaDaSemana> lista = Arrays.asList(DiaDaSemana.values());
		List<String> diasDaSemana = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			diasDaSemana.add(lista.get(i).name());
		}
		return diasDaSemana;
	}
	
	public List<String> carregarAEDiasDaSemana() {
		List<AEDiaDaSemana> lista = Arrays.asList(AEDiaDaSemana.values());
		List<String> aEDiasDaSemana = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			aEDiasDaSemana.add(lista.get(i).name());
		}
		return aEDiasDaSemana;
	}
	
	public List<String> carregarArea() {
		List<Area> lista = Arrays.asList(Area.values());
		List<String> area = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			area.add(lista.get(i).name());
		}
		return area;
	}
	
	public List<String> carregarTipoDeInsercao() {
		List<TipoDeInsercao> lista = Arrays.asList(TipoDeInsercao.values());
		List<String> tipoDeInsercao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tipoDeInsercao.add(lista.get(i).name());
		}
		return tipoDeInsercao;
	}
	
	public List<String> carregarTiposDeCNH() {
		List<TipoDeCNH> lista = Arrays.asList(TipoDeCNH.values());
		List<String> tiposDeCNH = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeCNH.add(lista.get(i).name());
		}
		return tiposDeCNH;
	}
	
	public List<String> carregarServicoMilitarSituacoes() {
		List<ServicoMilitarSituacao> lista = Arrays.asList(ServicoMilitarSituacao.values());
		List<String> servicoMilitarSituacoes = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			servicoMilitarSituacoes.add(lista.get(i).name());
		}
		return servicoMilitarSituacoes;
	}

	public List<String> carregarFrequenciasEnum() {
		List<FrequenciaEnum> lista = Arrays.asList(FrequenciaEnum.values());
		List<String> frequencias = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			frequencias.add(lista.get(i).name());
		}
		return frequencias;
	}
	
	public List<String> carregarTiposTurmaEnum() {
		List<TipoTurmaEnum> lista = Arrays.asList(TipoTurmaEnum.values());
		List<String> tiposTurma = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposTurma.add(lista.get(i).name());
		}
		return tiposTurma;
	}
	
	public List<String> carregarTiposDeValidacao() {
		List<TipoDeValidacao> lista = Arrays.asList(TipoDeValidacao.values());
		List<String> tiposDeValidacao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeValidacao.add(lista.get(i).name());
		}
		return tiposDeValidacao;
	}
	
	public List<String> carregarStatusValidacao() {
		List<StatusValidacao> lista = Arrays.asList(StatusValidacao.values());
		List<String> statusValidacao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			statusValidacao.add(lista.get(i).name());
		}
		return statusValidacao;
	}
	
	public List<String> carregarStatusDeMatricula() {
		List<StatusDaMatricula> lista = Arrays.asList(StatusDaMatricula.values());
		List<String> statusDeMatricula = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			statusDeMatricula.add(lista.get(i).name());
		}
		return statusDeMatricula;
	}
	

	public List<String> carregarDiaDaSemana() {
		List<DiaDaSemana> lista = Arrays.asList(DiaDaSemana.values());
		List<String> diaDaSemana = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			diaDaSemana.add(lista.get(i).name());
		}
		return diaDaSemana;
	}

	public List<String> carregarTiposDeParceria() {
		List<TipoDeParceria> lista = Arrays.asList(TipoDeParceria.values());
		List<String> tiposDeParceria = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeParceria.add(lista.get(i).name());
		}
		return tiposDeParceria;
	}
	
	public List<String> carregarRegioes() {
		List<Regiao> lista = Arrays.asList(Regiao.values());
		List<String> regioes = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			regioes.add(lista.get(i).name());
		}
		return regioes;
	}
	
	public List<String> carregarTiposDeEmpresa() {
		List<TipoDeEmpresa> lista = Arrays.asList(TipoDeEmpresa.values());
		List<String> tiposDeEmpresa = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeEmpresa.add(lista.get(i).name());
		}
		return tiposDeEmpresa;
	}
	
	public List<String> carregarEscolaridades() {
		List<Escolaridade> lista = Arrays.asList(Escolaridade.values());
		List<String> escolaridades = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			escolaridades.add(lista.get(i).name());
		}
		return escolaridades;
	}
	
	public List<String> carregarAuxiliosDoGoverno() {
		List<AuxilioDoGoverno> lista = Arrays.asList(AuxilioDoGoverno.values());
		List<String> auxiliosDoGoverno = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			auxiliosDoGoverno.add(lista.get(i).name());
		}
		return auxiliosDoGoverno;
	}

	public List<String> carregarHabilidadesManuais() {
		List<HabilidadeManual> lista = Arrays.asList(HabilidadeManual.values());
		List<String> habilidadesManuais = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			habilidadesManuais.add(lista.get(i).name());
		}
		return habilidadesManuais;
	}

	public List<String> carregarTipoMoradia() {
		List<TipoDeMoradia> lista = Arrays.asList(TipoDeMoradia.values());
		List<String> tiposDeMoradia = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeMoradia.add(lista.get(i).name());
		}
		return tiposDeMoradia;
	}
	
	public List<String> carregarSituacaoDaMoradia() {
		List<SituacaoDaMoradia> lista = Arrays.asList(SituacaoDaMoradia.values());
		List<String> situacoesDaMoradia = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			situacoesDaMoradia.add(lista.get(i).name());
		}
		return situacoesDaMoradia;
	}
	
	public List<String> carregarTipoDeConstrucao() {
		List<TipoDeConstrucao> lista = Arrays.asList(TipoDeConstrucao.values());
		List<String> tiposDeConstrucao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeConstrucao.add(lista.get(i).name());
		}
		return tiposDeConstrucao;
	}
	
	public List<String> carregarSituacaoAtual() {
		List<SituacaoAtual> lista = Arrays.asList(SituacaoAtual.values());
		List<String> situacoesAtuais = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			situacoesAtuais.add(lista.get(i).name());
		}
		return situacoesAtuais;
	}

	public List<String> carregarTipoDeContratacao() {
		List<TipoDeContratacao> lista = Arrays.asList(TipoDeContratacao.values());
		List<String> tiposDeContratacao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeContratacao.add(lista.get(i).name());
		}
		return tiposDeContratacao;
	}
	
	public List<String> carregarMotivoDaDispensa() {
		List<MotivoDaDispensa> lista = Arrays.asList(MotivoDaDispensa.values());
		List<String> motivoDaDispensa = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			motivoDaDispensa.add(lista.get(i).name());
		}
		return motivoDaDispensa;
	}
	
	public List<String> carregarPeriodo() {
		List<Periodo> lista = Arrays.asList(Periodo.values());
		List<String> periodos = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			periodos.add(lista.get(i).name());
		}
		return periodos;
	}
	
	public List<String> carregarTurnos() {
		List<TurnoEnum> lista = Arrays.asList(TurnoEnum.values());
		List<String> turnos = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			turnos.add(lista.get(i).name());
		}
		return turnos;
	}

}