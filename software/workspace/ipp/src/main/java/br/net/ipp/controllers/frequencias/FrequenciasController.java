package br.net.ipp.controllers.frequencias;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.daos.frequencias.FrequenciaRepository;
import br.net.ipp.enums.FrequenciaEnum;
import br.net.ipp.enums.TipoTurmaEnum;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.models.frequencias.Frequencia;

@Controller
@Transactional
@RequestMapping("/frequencias")
public class FrequenciasController {

	private FrequenciaRepository frequenciaRepository;
	private MatriculaRepository matriculaRepository;
	private TurmaRepository turmaRepository;
	Calendar c = Calendar.getInstance();
	
	@Autowired
	public void FrequenciasEndPoint(
			FrequenciaRepository frequenciaRepository,
			MatriculaRepository matriculaRepository,
			TurmaRepository turmaRepository
			) {
		this.frequenciaRepository = frequenciaRepository;
		this.matriculaRepository = matriculaRepository;
		this.turmaRepository = turmaRepository;
	}
	
	@GetMapping("/mes/{id}")
	public ModelAndView frequenciaMes(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("frequencias/mes");
		List<List<Frequencia>> frequencias = new ArrayList<>();
		Turma turma = turmaRepository.findOne(id);
		modelAndView.addObject("turma", turma);
		List<Matricula> matriculas = matriculaRepository.findAllByTurma(turma);
		modelAndView.addObject("matriculas", matriculas);
		List<Frequencia> cabecalho = new ArrayList<Frequencia>();
		for (Matricula matricula : matriculas) {
			cabecalho = frequenciaRepository.findByMatriculaAndMes(matricula, 1);
			List<Frequencia> freq = frequenciaRepository.findByMatriculaAndMes(matricula, 1);
			frequencias.add(freq);
		}
		modelAndView.addObject("cabecalho", cabecalho);
		modelAndView.addObject("frequencias", frequencias);
		return modelAndView;
	}
	
	@GetMapping("/geral/{id}")
	public ModelAndView frequenciaGeral(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("frequencias/mes");
		List<List<Frequencia>> frequencias = new ArrayList<>();
		Turma turma = turmaRepository.findOne(id);
		modelAndView.addObject("turma", turma);
		List<Matricula> matriculas = matriculaRepository.findAllByTurma(turma);
		modelAndView.addObject("matriculas", matriculas);
		List<Frequencia> cabecalho = new ArrayList<Frequencia>();
		for (Matricula matricula : matriculas) {
			cabecalho = frequenciaRepository.findByMatricula(matricula);
			List<Frequencia> freq = frequenciaRepository.findAllByMatricula(matricula);
			frequencias.add(freq);
		}
		modelAndView.addObject("cabecalho", cabecalho);
		modelAndView.addObject("frequencias", frequencias);
		return modelAndView;
	}
	
	@GetMapping("/turma/{id}")
	public ModelAndView frequenciaTurma(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("frequencias/turma");
		Turma turma = turmaRepository.findOne(id);
		modelAndView.addObject("turma", turma);
		List<Matricula> matriculas = matriculaRepository.findAllByTurma(turma);
		modelAndView.addObject("matriculas", matriculas);
		List<String> frequencias = this.carregarFrequenciasEnum();
		modelAndView.addObject("frequencias", frequencias);
		return modelAndView;
	}

	@PostMapping("/turma/{id}")
	public ModelAndView save(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect:/frequencias");
		String matriculas[] = request.getParameterValues("matriculas");
		String frequenciasManha[] = request.getParameterValues("frequenciasManha");
		String frequenciasTarde[] = request.getParameterValues("frequenciasTarde");
		for (int i = 0; i < matriculas.length; i++) {
			Frequencia frequencia = new Frequencia();
			Matricula matricula = matriculaRepository.findOne(Long.parseLong(matriculas[i]));
			frequencia.setMatricula(matricula);
			frequencia.setFrequenciaManha(FrequenciaEnum.valueOf(frequenciasManha[i]));
			frequencia.setFrequenciaTarde(FrequenciaEnum.valueOf(frequenciasTarde[i]));
			frequencia.setDia(c.get(Calendar.DAY_OF_MONTH));
			frequencia.setMes(c.get(Calendar.MONTH));
			frequencia.setAno(c.get(Calendar.YEAR));
			frequenciaRepository.save(frequencia);
		}
		return modelAndView;
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
	
}
