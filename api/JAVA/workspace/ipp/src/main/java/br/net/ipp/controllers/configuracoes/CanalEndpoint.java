package br.net.ipp.controllers.configuracoes;

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

import br.net.ipp.daos.configuracoes.CanalRepository;
import br.net.ipp.models.configuracoes.Canal;

@Controller
@Transactional
@RequestMapping("/canais")
public class CanalEndpoint {

	private CanalRepository canalDAO;

	@Autowired
	public void CanalEndPoint(CanalRepository canalDAO) {
		this.canalDAO = canalDAO;
	}

	@GetMapping("/form")
	public ModelAndView canal(Canal canal) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/canais/canal");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Canal canal, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return canal(canal);
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/configuracoes");
		canalDAO.save(canal);
		modelAndView.addObject("msg", "Operação realizada com sucesso!");
		modelAndView.addObject("canal", canal);
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/canais/canal");
		modelAndView.addObject("canal", canalDAO.findOne(id));
		return modelAndView;
	}

	@PostMapping("/{id}")
	public ModelAndView update(@Valid Canal canal, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/configuracoes");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("canal", canal);

		} else {
			canalDAO.save(canal);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("canal", canal);

			
		}	
		return modelAndView;
	}
}