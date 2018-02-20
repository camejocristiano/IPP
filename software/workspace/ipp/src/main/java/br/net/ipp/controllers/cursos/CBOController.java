package br.net.ipp.controllers.cursos;

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

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.ArcoOcupacionalRepository;
import br.net.ipp.daos.cursos.CBORepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.CBO;
import br.net.ipp.models.cursos.Curso;

@Controller
@Transactional
@RequestMapping("/sw")
public class CBOController {

private CBORepository cboRepository;
private ArcoOcupacionalRepository arcoOcupacionalRepository;
private CursoRepository cursoRepository;
private UsuarioRepository usuarioRepository;

	@Autowired
	public CBOController(
			CBORepository cboRepository,
			CursoRepository cursoRepository,
			ArcoOcupacionalRepository arcoOcupacionalRepository,
			UsuarioRepository usuarioRepository
			) {
		this.cboRepository = cboRepository;
		this.cursoRepository = cursoRepository;
		this.arcoOcupacionalRepository = arcoOcupacionalRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/cbos")
	public ModelAndView cbos(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCboListar() == true) {
			modelAndView = new ModelAndView("cursos/cbos/cbos");
			modelAndView.addObject("cbos", cboRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/cbo/form")
	public ModelAndView cbo(CBO cbo, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCboCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/cbos/cbo");
			modelAndView.addObject("cbo", cbo);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/cbo/form/{id}")
	public ModelAndView cboCurso(CBO cbo, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCboCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/cbos/cbo");
			Curso curso = cursoRepository.findOne(id);
			modelAndView.addObject("cbo", cbo);
			modelAndView.addObject("curso", curso);
			modelAndView.addObject("arcosOcupacionais", arcoOcupacionalRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/cbo")
	public ModelAndView save(@Valid CBO cbo, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCboCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/cbos/cbo");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("cbo", cbo);
			} else {
				cboRepository.save(cbo);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("cbo", cbo);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/cbo/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCboVisualizar() == true) {
			modelAndView = new ModelAndView("cursos/cbos/cbo");
			CBO cbo = cboRepository.findOne(id);
			modelAndView.addObject("cbo", cbo);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/cbo/{id}")
	public ModelAndView update(@Valid CBO cbo, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCboEditar() == true) {
			modelAndView = new ModelAndView("cursos/cbos/cbo");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("cbo", cbo);
			} else {
				cboRepository.save(cbo);
				modelAndView.addObject("cbo", cbo);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
