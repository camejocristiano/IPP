/*package br.net.ipp.controllers.frequencias;

import java.io.IOException;
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
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.models.frequencias.Frequencia;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw/frequenciasTurma")
public class FrequenciasTurmaController {

	private FrequenciaRepository frequenciaRepository;
	private MatriculaRepository matriculaRepository;
	private TurmaRepository turmaRepository;
	Calendar c = Calendar.getInstance();
	private EnumService enumService;
	
	@Autowired
	public void FrequenciasEndPoint(
			FrequenciaRepository frequenciaRepository,
			MatriculaRepository matriculaRepository,
			TurmaRepository turmaRepository,
			EnumService enumService
			) {
		this.frequenciaRepository = frequenciaRepository;
		this.matriculaRepository = matriculaRepository;
		this.turmaRepository = turmaRepository;
		this.enumService = new EnumService();
	}
	
	@GetMapping("/{id}")
	public ModelAndView frequenciaTurma(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("frequencias/turmas/turma");
		Turma turma = turmaRepository.findOne(id);
		modelAndView.addObject("turma", turma);
		List<Matricula> matriculas = matriculaRepository.findAllByTurma(turma);
		modelAndView.addObject("matriculas", matriculas);
		List<String> enumFrequencias = this.enumService.carregarFrequenciasEnum();
		modelAndView.addObject("enumFrequencias", enumFrequencias);
		return modelAndView;
	}

	@PostMapping("/{id}")
	public ModelAndView save(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/frequencias");
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
	
}
*/