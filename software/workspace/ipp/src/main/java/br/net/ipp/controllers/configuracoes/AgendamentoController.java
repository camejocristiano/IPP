package br.net.ipp.controllers.configuracoes;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class AgendamentoController {
	
	private AgendamentoRepository agendamentoRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public AgendamentoController(
			AgendamentoRepository agendamentoRepository,
			UsuarioRepository usuarioRepository
			) {
		this.agendamentoRepository = agendamentoRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/agendamentos")
	public ModelAndView agenda(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isAgendamentoListar() == true) {
			modelAndView = new ModelAndView("configuracoes/agendamentos/agendamentos");
			if (usuarioSessao.isAdmin()) {
				modelAndView.addObject("agendamentos", agendamentoRepository.findAll());
				modelAndView.addObject("agendamentosResponsavel", agendamentoRepository.findAlByUsuarioResponsavel(usuarioSessao));
				modelAndView.addObject("agendamentosEnvolvido", agendamentoRepository.findAlByUsuariosEnvolvidos(usuarioSessao));
			} else {
				modelAndView.addObject("agendamentosResponsavel", agendamentoRepository.findAlByUsuarioResponsavel(usuarioSessao));
				modelAndView.addObject("agendamentosEnvolvido", agendamentoRepository.findAlByUsuariosEnvolvidos(usuarioSessao));
			}
		} else {
			// retorna erro sem permissao
		}
		return modelAndView;
	}
	
	@GetMapping("/agendamento/form")
	public ModelAndView form(Agendamento agendamento) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/agendamento")
	public ModelAndView save(@Valid Agendamento agendamento, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("corMsg", "orange");
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
		} else {
			agendamentoRepository.save(agendamento);
			modelAndView.addObject("color", "#26a69a");
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
			modelAndView.addObject("agendamento", agendamento);
		}
		return modelAndView;
	}
	
	@GetMapping("/agendamento/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		Agendamento agendamento = agendamentoRepository.findOne(id);
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		modelAndView.addObject("agendamento", agendamento);
		return modelAndView;
	}
	
	@PostMapping("/agendamento/{id}")
	public ModelAndView update(@PathVariable("id") String id, @Valid Agendamento agendamento,
			BindingResult bindingResult) {
		agendamento.setId(Long.parseLong(id));
		ModelAndView modelAndView = new ModelAndView("configuracoes/agendamentos/agendamento");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("corMsg", "orange");
			modelAndView.addObject("msg",
					"Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
		} else {
			agendamentoRepository.save(agendamento);
			modelAndView.addObject("color", "#26a69a");
			modelAndView.addObject("agendamento", agendamento);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}
		return modelAndView;
	}

}