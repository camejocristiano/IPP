package br.net.ipp.controllers.configuracoes;

import java.util.ArrayList;
import java.util.Arrays;
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

import br.net.ipp.daos.configuracoes.GrupoDePermissoesRepository;
import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.enums.Status;
import br.net.ipp.models.configuracoes.GrupoDePermissoes;
import br.net.ipp.models.frequencias.Frequencia;

@Controller
@Transactional
@RequestMapping("/sw/gruposDePermissoes")
public class GruposDePermissoesEndpoint {

	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	private UnidadeRepository unidadesRepository;

	@Autowired
	public void GrupoDePermissoesEndPoint(
			GrupoDePermissoesRepository grupoDePermissoesRepository,
			UnidadeRepository unidadesRepository
			) {
		this.grupoDePermissoesRepository = grupoDePermissoesRepository;
		this.unidadesRepository = unidadesRepository;
	}
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/gruposDePermissoes");
		modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/form")
	public ModelAndView form(GrupoDePermissoes grupoDePermissoes) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
		List<String> status = carregarStatus();
		modelAndView.addObject("status", status);
		modelAndView.addObject("unidades", unidadesRepository.findAll());
		modelAndView.addObject("pitepip", new Frequencia());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid GrupoDePermissoes grupoDePermissoes, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
		List<String> status = carregarStatus();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("status", status);
			modelAndView.addObject("corMsg", "red");
			modelAndView.addObject("msg",
					"Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
		} else {
			grupoDePermissoesRepository.save(grupoDePermissoes);
			modelAndView.addObject("status", status);
			modelAndView.addObject("corMsg", "green");
			modelAndView.addObject("unidades", unidadesRepository.findAll());
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
		GrupoDePermissoes grupoDePermissoes = grupoDePermissoesRepository.findOne(id);
		modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
		List<String> status = carregarStatus();
		modelAndView.addObject("unidades", unidadesRepository.findAll());
		modelAndView.addObject("status", status);
		return modelAndView;
	}

	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable("id") String id, @Valid GrupoDePermissoes grupoDePermissoes,
			BindingResult bindingResult) {
		grupoDePermissoes.setId(Long.parseLong(id));
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
		List<String> status = carregarStatus();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("status", status);
			modelAndView.addObject("corMsg", "red");
			modelAndView.addObject("msg",
					"Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
		} else {
			grupoDePermissoesRepository.save(grupoDePermissoes);
			modelAndView.addObject("status", status);
			modelAndView.addObject("corMsg", "green");
			modelAndView.addObject("unidades", unidadesRepository.findAll());
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}
		return modelAndView;
	}

	public List<String> carregarStatus() {
		List<Status> lista = Arrays.asList(Status.values());
		List<String> status = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			status.add(lista.get(i).name());
		}
		return status;
	}
}
