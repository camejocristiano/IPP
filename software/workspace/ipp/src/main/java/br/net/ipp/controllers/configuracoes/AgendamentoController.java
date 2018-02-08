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

import br.net.ipp.daos.configuracoes.AgendamentoRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.Agendamento;

@Controller
@Transactional
@RequestMapping("/sw/agendamentos")
public class AgendamentoController {
	
	private AgendamentoRepository agendamentoRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void AgendamentoEndPoint(
			AgendamentoRepository agendamentoRepository,
			UsuarioRepository usuarioRepository
			) {
		this.agendamentoRepository = agendamentoRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamentos");
		modelAndView.addObject("agendamentos", agendamentoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/form")
	public ModelAndView form(Agendamento agendamento) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView save(@Valid Agendamento agendamento, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("corMsg", "red");
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
		} else {
			agendamentoRepository.save(agendamento);
			modelAndView.addObject("corMsg", "green");
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
			modelAndView.addObject("agendamento", agendamento);
		}
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		Agendamento agendamento = agendamentoRepository.findOne(id);
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		modelAndView.addObject("agendamento", agendamento);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable("id") String id, @Valid Agendamento agendamento,
			BindingResult bindingResult) {
		agendamento.setId(Long.parseLong(id));
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("corMsg", "red");
			modelAndView.addObject("msg",
					"Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
		} else {
			agendamentoRepository.save(agendamento);
			modelAndView.addObject("corMsg", "green");
			modelAndView.addObject("agendamento", agendamento);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}
		return modelAndView;
	}

}