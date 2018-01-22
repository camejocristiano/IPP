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
import br.net.ipp.daos.frequencias.PITEPIPRepository;
import br.net.ipp.enums.Frequencia;
import br.net.ipp.enums.TipoTurma;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.models.frequencias.PITEPIP;

@Controller
@Transactional
@RequestMapping("/frequencia")
public class FrequenciasController {

	private PITEPIPRepository pITEPIPRepository;
	private MatriculaRepository matriculaRepository;
	private TurmaRepository turmaRepository;
	Calendar c = Calendar.getInstance();
	
	@Autowired
	public void FrequenciasEndPoint(
			PITEPIPRepository pITEPIPRepository,
			MatriculaRepository matriculaRepository,
			TurmaRepository turmaRepository
			) {
		this.pITEPIPRepository = pITEPIPRepository;
		this.matriculaRepository = matriculaRepository;
		this.turmaRepository = turmaRepository;
	}
	
	@GetMapping("/turma/{id}")
	public ModelAndView pitEPipTurma(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("frequencias/pitsepips/turma");
		Turma turma = turmaRepository.findOne(id);
		modelAndView.addObject("turma", turma);
		List<Matricula> matriculas = matriculaRepository.findAllByTurma(turma);
		modelAndView.addObject("matriculas", matriculas);
		List<String> frequencias = this.carregarFrequencias();
		modelAndView.addObject("frequencias", frequencias);
		return modelAndView;
	}

	@PostMapping("/turma/{id}")
	public ModelAndView save(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect:/frequencia/turma/"+id);
		String matriculas[] = request.getParameterValues("matriculas");
		String frequencias[] = request.getParameterValues("frequencias");
		for (int i = 0; i < matriculas.length; i++) {
			PITEPIP pitepip = new PITEPIP();
			Matricula matricula = matriculaRepository.findOne(Long.parseLong(matriculas[i]));
			pitepip.setMatricula(matricula);
			pitepip.setFrequencia(Frequencia.valueOf(frequencias[i]));
			pitepip.setDia(c.get(Calendar.DAY_OF_MONTH));
			pitepip.setMes(c.get(Calendar.MONTH));
			pitepip.setAno(c.get(Calendar.YEAR));
			pITEPIPRepository.save(pitepip);
		}
		return modelAndView;
	}

	public List<String> carregarFrequencias() {
		List<Frequencia> lista = Arrays.asList(Frequencia.values());
		List<String> frequencias = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			frequencias.add(lista.get(i).name());
		}
		return frequencias;
	}
	
	public List<String> carregarTipoTurma() {
		List<TipoTurma> lista = Arrays.asList(TipoTurma.values());
		List<String> tiposTurma = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposTurma.add(lista.get(i).name());
		}
		return tiposTurma;
	}
	
}
