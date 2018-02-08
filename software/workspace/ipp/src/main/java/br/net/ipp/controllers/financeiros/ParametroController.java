package br.net.ipp.controllers.financeiros;

import java.util.Calendar;

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

import br.net.ipp.daos.financeiros.ParametroRepository;
import br.net.ipp.models.financeiros.Parametro;

@Controller
@Transactional
@RequestMapping("/sw")
public class ParametroController {

	private ParametroRepository parametroRepository;
	Calendar c = Calendar.getInstance();
	
	@Autowired
	public void ParametroEndPoint(
			ParametroRepository parametroRepository
			) {
		this.parametroRepository = parametroRepository;
	}

	@GetMapping("/parametros")
	public ModelAndView parametros() {
		ModelAndView modelAndView = new ModelAndView("financeiros/parametros/parametros");
		modelAndView.addObject("parametros", parametroRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/parametro/form")
	public ModelAndView parametro(Parametro parametro) {
		ModelAndView modelAndView = new ModelAndView("financeiros/parametros/parametro");
		modelAndView.addObject("parametro", parametro);
		return modelAndView;
	}

	@PostMapping("/parametro")
	public ModelAndView save(@Valid Parametro parametro, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("parametro", parametro);
		} else {
			parametro.setDia(c.get(Calendar.DAY_OF_MONTH));
			parametro.setMes(c.get(Calendar.MONTH));
			parametro.setAno(c.get(Calendar.YEAR));
			parametroRepository.save(parametro);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("parametro", parametro);
		}		
		return modelAndView;
	}

	@GetMapping("/parametro/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/parametros/parametro");
		Parametro parametro = parametroRepository.findOne(id);
		modelAndView.addObject("parametro", parametro);
		return modelAndView;
	}
	
	@PostMapping("/parametro/{id}")
	public ModelAndView update(@Valid Parametro parametro, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("parametro", parametro);
		} else {
			parametro.setDia(c.get(Calendar.DAY_OF_MONTH));
			parametro.setMes(c.get(Calendar.MONTH));
			parametro.setAno(c.get(Calendar.YEAR));
			parametroRepository.save(parametro);
			modelAndView.addObject("parametro", parametro);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
