package br.net.ipp.controllers.financeiros;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.ContratacaoRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.financeiros.ParametroRepository;
import br.net.ipp.daos.frequencias.FrequenciaRepository;
import br.net.ipp.enums.FrequenciaEnum;
import br.net.ipp.models.aprendizes.Contratacao;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.frequencias.Frequencia;

@Controller
@Transactional
@RequestMapping("/sw")
public class DemonstrativoController {

	private JovemRepository jovemRepository;
	private ParametroRepository parametroRepository;
	private MatriculaRepository matriculaRepository;
	private FrequenciaRepository frequenciaRepository;
	private ContratacaoRepository contratacaoRepository;
	Calendar c = Calendar.getInstance();
	
	@Autowired
	public void DemonstrativoEndPoint(
			JovemRepository jovemRepository,
			ParametroRepository parametroRepository,
			MatriculaRepository matriculaRepository,
			FrequenciaRepository frequenciaRepository,
			ContratacaoRepository contratacaoRepository
			) {
		this.jovemRepository = jovemRepository;
		this.parametroRepository = parametroRepository;
		this.matriculaRepository = matriculaRepository;
		this.frequenciaRepository = frequenciaRepository;
		this.contratacaoRepository = contratacaoRepository;
	}

	@GetMapping("/demonstrativos")
	public ModelAndView demonstrativos() {
		ModelAndView modelAndView = new ModelAndView("financeiros/demonstrativos/demonstrativos");
		modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
		return modelAndView;
	}
	
/*	@GetMapping("/demonstrativo/form")
	public ModelAndView demonstrativo(Demonstrativo demonstrativo) {
		ModelAndView modelAndView = new ModelAndView("financeiros/demonstrativos/demonstrativo");
		modelAndView.addObject("demonstrativo", demonstrativo);
		return modelAndView;
	}

	@PostMapping("/demonstrativo")
	public ModelAndView save(@Valid Demonstrativo demonstrativo, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("demonstrativo", demonstrativo);
		} else {
			demonstrativoRepository.save(demonstrativo);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("demonstrativo", demonstrativo);
		}		
		return modelAndView;
	}*/

	@GetMapping("/demonstrativo/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/demonstrativos/demonstrativo");
		Contratacao contratacao = contratacaoRepository.findOne(id);
		modelAndView.addObject("contratacao", contratacao);
		Jovem jovem = jovemRepository.findOne(contratacao.getJovem().getId());
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("parametros", parametroRepository.findOne((long) 1));
		Matricula matricula = matriculaRepository.findOne((long) 7);
		modelAndView.addObject("matricula", matricula);
		List<Frequencia> frequencias = frequenciaRepository.findByMatriculaAndMes(matricula, c.get(Calendar.MONTH));
		modelAndView.addObject("frequencias", frequencias);
		int faltasCurso = 0;
		double diasTrabalho = 0;
		for (Frequencia frequencia : frequencias) {
			if(!frequencia.getFrequenciaManha().equals(FrequenciaEnum.C)) {
				faltasCurso++;
			} else {
				diasTrabalho = diasTrabalho + 0.5;
			}
			if(!frequencia.getFrequenciaTarde().equals(FrequenciaEnum.C)) {
				faltasCurso++;
			} else {
				diasTrabalho = diasTrabalho + 0.5;
			}
		}
		modelAndView.addObject("faltasCurso", faltasCurso);
		modelAndView.addObject("diasTrabalho", diasTrabalho);
		
		return modelAndView;
	}
	
/*	@PostMapping("/demonstrativo/{id}")
	public ModelAndView update(@Valid Demonstrativo demonstrativo, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("demonstrativo", demonstrativo);
		} else {
			demonstrativoRepository.save(demonstrativo);
			modelAndView.addObject("demonstrativo", demonstrativo);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}*/
	
}
