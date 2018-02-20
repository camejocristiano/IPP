package br.net.ipp.controllers.cursos;

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

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.ArcoOcupacionalRepository;
import br.net.ipp.daos.cursos.CBORepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.ArcoOcupacional;
import br.net.ipp.models.cursos.CBO;
import br.net.ipp.models.cursos.Curso;

@Controller
@Transactional
@RequestMapping("/sw")
public class ArcoOcupacionalController {

private ArcoOcupacionalRepository arcoOcupacionalRepository;
private CursoRepository cursoRepository;
private CBORepository cBORepository;
private UsuarioRepository usuarioRepository;

	@Autowired
	public void ArcoOcupacionalEndPoint(
			ArcoOcupacionalRepository arcoOcupacionalRepository,
			CursoRepository cursoRepository,
			CBORepository cBORepository,
			UsuarioRepository usuarioRepository
			) {
		this.arcoOcupacionalRepository = arcoOcupacionalRepository;
		this.cursoRepository = cursoRepository;
		this.cBORepository = cBORepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/arcos")
	public ModelAndView arcos(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isArcoListar() == true) {
			modelAndView = new ModelAndView("cursos/arcos/arcos");
			modelAndView.addObject("arcos", arcoOcupacionalRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/arco/form")
	public ModelAndView arcoOcupacional(ArcoOcupacional arcoOcupacional, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isArcoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/arcos/arco");
			modelAndView.addObject("arcoOcupacional", arcoOcupacional);
			modelAndView.addObject("cbos", cBORepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/arco/form/{id}")
	public ModelAndView arcoOcupacionalCurso(ArcoOcupacional arcoOcupacional, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isArcoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/arcos/arco");
			Curso curso = cursoRepository.findOne(id);
			modelAndView.addObject("curso", curso);
			modelAndView.addObject("arcoOcupacional", arcoOcupacional);
			modelAndView.addObject("cbos", cBORepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/arco")
	public ModelAndView save(@Valid ArcoOcupacional arcoOcupacional, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isArcoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/arcos/arco");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("arcoOcupacional", arcoOcupacional);
			} else {
				arcoOcupacionalRepository.save(arcoOcupacional);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				Curso curso = cursoRepository.findByArcoOcupacional(arcoOcupacional);
				modelAndView.addObject("arcoOcupacional", arcoOcupacional);
				modelAndView.addObject("curso", curso);
				modelAndView.addObject("cbos", cBORepository.findAll());
				List<CBO> cbos_arco = arcoOcupacional.getCbos();
				modelAndView.addObject("cbos_arco", cbos_arco);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/arco/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isArcoVisualizar() == true) {
			modelAndView = new ModelAndView("cursos/arcos/arco");
			ArcoOcupacional arcoOcupacional = arcoOcupacionalRepository.findOne(id);
			Curso curso = cursoRepository.findByArcoOcupacional(arcoOcupacional);
			modelAndView.addObject("arcoOcupacional", arcoOcupacional);
			modelAndView.addObject("curso", curso);
			modelAndView.addObject("cbos", cBORepository.findAll());
			List<CBO> cbos_arco = arcoOcupacional.getCbos();
			modelAndView.addObject("cbos_arco", cbos_arco);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/arco/{id}")
	public ModelAndView update(@Valid ArcoOcupacional arcoOcupacional, BindingResult bindingResult, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isArcoVisualizar() == true) {
			modelAndView = new ModelAndView("cursos/arcos/arco");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("arcoOcupacional", arcoOcupacional);
			} else {
				arcoOcupacionalRepository.save(arcoOcupacional);
				Curso curso = cursoRepository.findByArcoOcupacional(arcoOcupacional);
				modelAndView.addObject("arcoOcupacional", arcoOcupacional);
				modelAndView.addObject("curso", curso);
				modelAndView.addObject("cbos", cBORepository.findAll());
				List<CBO> cbos_arco = arcoOcupacional.getCbos();
				modelAndView.addObject("cbos_arco", cbos_arco);
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
