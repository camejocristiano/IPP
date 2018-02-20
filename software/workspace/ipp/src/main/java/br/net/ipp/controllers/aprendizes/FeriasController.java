package br.net.ipp.controllers.aprendizes;

import java.util.ArrayList;
import java.util.List;

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

import br.net.ipp.daos.aprendizes.FeriasRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.models.aprendizes.Ferias;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class FeriasController {

	private FeriasRepository feriasRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	public FeriasController (
			FeriasRepository feriasRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository,
			MatriculaRepository matriculaRepository
			) {
		this.feriasRepository = feriasRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
		this.matriculaRepository = matriculaRepository;
	}

	@GetMapping("/ferias/form")
	public ModelAndView ferias(Ferias ferias, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isFeriasCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/ferias");
			modelAndView.addObject("ferias", ferias);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/feriasJovem/{id}")
	public ModelAndView feriasJovem(Ferias ferias, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isFeriasCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/ferias");
			modelAndView.addObject("ferias", ferias);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/ferias")
	public ModelAndView save(@Valid Ferias ferias, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(ferias.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isFeriasCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/ferias");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("ferias", ferias);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
			} else {
				feriasRepository.save(ferias);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("ferias", ferias);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/ferias/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Ferias ferias = feriasRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(ferias.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isFeriasVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/ferias");
			modelAndView.addObject("ferias", ferias);
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/ferias/{id}")
	public ModelAndView update(@Valid Ferias ferias, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(ferias.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isFeriasEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/ferias");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("ferias", ferias);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
			} else {
				feriasRepository.save(ferias);
				modelAndView.addObject("ferias", ferias);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/feriassJovem/{id}")
	public ModelAndView feriassJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isFeriasListar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/feriass");
			if (feriasRepository.findAllByJovem(jovem).size() > 0) {
				modelAndView.addObject("feriass", feriasRepository.findAllByJovem(jovem));
			} else {
				List<Ferias> ferias = new ArrayList<Ferias>();
				modelAndView.addObject("ferias", ferias);
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
