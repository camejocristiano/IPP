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

import br.net.ipp.daos.configuracoes.GrupoDePermissoesRepository;
import br.net.ipp.models.configuracoes.GrupoDePermissoes;

@Controller
@Transactional
@RequestMapping("/gruposDePermissoes")
public class GruposDePermissoesEndpoint {

	private GrupoDePermissoesRepository grupoDePermissoesDAO;

	@Autowired
	public void GrupoDePermissoesEndPoint(
			GrupoDePermissoesRepository grupoDePermissoesDAO
			) {
		this.grupoDePermissoesDAO = grupoDePermissoesDAO;
	}

	@GetMapping("/form")
	public ModelAndView form(GrupoDePermissoes grupoDePermissoes) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
		modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid GrupoDePermissoes grupoDePermissoes, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
		} else {
			grupoDePermissoesDAO.save(grupoDePermissoes);
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
		GrupoDePermissoes grupoDePermissoes = grupoDePermissoesDAO.findOne(id);
		modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
		return modelAndView;
	}

	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable("id") String id, @Valid GrupoDePermissoes grupoDePermissoes, BindingResult bindingResult) {
		grupoDePermissoes.setId(Long.parseLong(id));
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
		} else {
			grupoDePermissoesDAO.save(grupoDePermissoes);
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}
		return modelAndView;
	}

}
