package br.net.ipp.controllers.frequencias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.daos.frequencias.PITEPIPRepository;
import br.net.ipp.enums.Frequencia;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.models.frequencias.PITEPIP;

@Controller
@Transactional
@RequestMapping("/pITsEPIPs")
public class PITEPIPController {

	private PITEPIPRepository pITEPIPRepository;
	private MatriculaRepository matriculaRepository;
	private TurmaRepository turmaRepository;
	Calendar c = Calendar.getInstance();
	
	@Autowired
	public void PITEPIPEndPoint(
			PITEPIPRepository pITEPIPRepository,
			MatriculaRepository matriculaRepository,
			TurmaRepository turmaRepository
			) {
		this.pITEPIPRepository = pITEPIPRepository;
		this.matriculaRepository = matriculaRepository;
		this.turmaRepository = turmaRepository;
	}

	@GetMapping("/form")
	public ModelAndView pitEPip(PITEPIP pitepip) {
		ModelAndView modelAndView = new ModelAndView("frequencias/pitsepips/pitepip");
		modelAndView.addObject("pitepip", pitepip);
		modelAndView.addObject("matriculas", matriculaRepository.findAll());
		List<String> frequencias = this.carregarFrequencias();
		modelAndView.addObject("frequencias", frequencias);
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView pitEPipTurma(PITEPIP pitepip, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("frequencias/pitsepips/pitepip");
		modelAndView.addObject("pitepip", pitepip);
		Turma turma = turmaRepository.findOne(id);
		modelAndView.addObject("matriculas", matriculaRepository.findAllByTurma(turma));
		List<String> frequencias = this.carregarFrequencias();
		modelAndView.addObject("frequencias", frequencias);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid PITEPIP pitepip, BindingResult bindingResult) {
		pitepip.setDia(c.get(Calendar.DAY_OF_MONTH));
		pitepip.setMes(c.get(Calendar.MONTH));
		pitepip.setAno(c.get(Calendar.YEAR));
		ModelAndView modelAndView = new ModelAndView("redirect:/frequencias");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("pitepip", pitepip);
		} else {
			pITEPIPRepository.save(pitepip);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("pitepip", pitepip);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("frequencias/pitsepips/pitepip");
		PITEPIP pitepip = pITEPIPRepository.findOne(id);
		modelAndView.addObject("pitepip", pitepip);
		List<String> frequencias = this.carregarFrequencias();
		modelAndView.addObject("frequencias", frequencias);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid PITEPIP pitepip, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/frequencias");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("pitepip", pitepip);
		} else {
			pITEPIPRepository.save(pitepip);
			modelAndView.addObject("pitepip", pitepip);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
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
	
}
