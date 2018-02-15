/*package br.net.ipp.controllers.frequencias;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.daos.frequencias.FrequenciaRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.models.frequencias.Frequencia;

@Controller
@Transactional
@RequestMapping("/sw/frequencias")
public class FrequenciasController {

	private FrequenciaRepository frequenciaRepository;
	private MatriculaRepository matriculaRepository;
	private TurmaRepository turmaRepository;
	Calendar c = Calendar.getInstance();
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void FrequenciasEndPoint(
			FrequenciaRepository frequenciaRepository,
			MatriculaRepository matriculaRepository,
			TurmaRepository turmaRepository,
			UsuarioRepository usuarioRepository
			) {
		this.frequenciaRepository = frequenciaRepository;
		this.matriculaRepository = matriculaRepository;
		this.turmaRepository = turmaRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	// Método para Listagem Geral de Frequências pelo Usuário
	@GetMapping
	public ModelAndView frequencias() {
		ModelAndView modelAndView = new ModelAndView("frequencias/home");
		return modelAndView;
	}
	
	// Método para Listagem Geral de Frequências pelo Usuário
	@GetMapping("/{id}")
	public ModelAndView frequenciasOrientador(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("frequencias/turmas");
		Usuario usuario = usuarioRepository.findOne(id);
		List<Turma> turmas = turmaRepository.findAllByOrientadorTurma(usuario);
		modelAndView.addObject("turmas", turmas);
		return modelAndView;
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
	
	@GetMapping("frequencias/{id}")
	public ModelAndView frequenciasOrientador(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("frequencias/pitsepips/turmas");
		Usuario usuario = usuarioRepository.findOne(id);
		List<Turma> turmas = turmaRepository.findAllByOrientadorTurma(usuario);
		modelAndView.addObject("turmas", turmas);
		return modelAndView;
	}

	
}
*/