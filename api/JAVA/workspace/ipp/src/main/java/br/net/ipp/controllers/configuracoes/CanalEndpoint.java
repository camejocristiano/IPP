package br.net.ipp.controllers.configuracoes;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.CanalRepository;
import br.net.ipp.models.configuracoes.Canal;

@Controller
public class CanalEndpoint {

	private CanalRepository canalDAO;

	@Autowired
	public void CanalEndPoint(CanalRepository canalDAO) {
		this.canalDAO = canalDAO;
	}

	@GetMapping("/canal")
	public ModelAndView canal(Canal canal) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/canais/canal");
		return modelAndView;
	}

	@PostMapping("/canais")
	public ModelAndView save(@Valid Canal canal, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return canal(canal);
		}
		ModelAndView modelAndView = new ModelAndView("configuracoes/canais/canal");
		String _canal = canal.getCanal();
		canalDAO.save(canal);
		Canal can = canalDAO.findByCanal(_canal);
		modelAndView.addObject("msg", "Operação realizada com sucesso!");
		modelAndView.addObject("canal", can);
		return modelAndView;
	}

	@GetMapping("/canais/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/canais/canal");
		modelAndView.addObject("canal", canalDAO.findOne(id));
		return modelAndView;
	}

	// put
}