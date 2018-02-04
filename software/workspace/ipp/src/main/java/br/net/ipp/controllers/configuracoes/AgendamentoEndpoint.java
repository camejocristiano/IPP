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
@RequestMapping("/agendamentos")
public class AgendamentoEndpoint {
	
	private AgendamentoRepository agendamentoDAO;
	private UsuarioRepository usuarioDAO;
	
	@Autowired
	public void AgendamentoEndPoint(
			AgendamentoRepository agendamentoDAO,
			UsuarioRepository usuarioDAO
			) {
		this.agendamentoDAO = agendamentoDAO;
		this.usuarioDAO = usuarioDAO;
	}
	
	@GetMapping("/form")
	public ModelAndView form(Agendamento agendamento) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		modelAndView.addObject("usuarios", usuarioDAO.findAll());
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView save(@Valid Agendamento agendamento, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("corMsg", "red");
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
		} else {
			agendamentoDAO.save(agendamento);
			modelAndView.addObject("corMsg", "green");
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("usuarios", usuarioDAO.findAll());
			modelAndView.addObject("agendamento", agendamento);
		}
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		Agendamento agendamento = agendamentoDAO.findOne(id);
		modelAndView.addObject("usuarios", usuarioDAO.findAll());
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
			agendamentoDAO.save(agendamento);
			modelAndView.addObject("corMsg", "green");
			modelAndView.addObject("agendamento", agendamento);
			modelAndView.addObject("usuarios", usuarioDAO.findAll());
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}
		return modelAndView;
	}

}