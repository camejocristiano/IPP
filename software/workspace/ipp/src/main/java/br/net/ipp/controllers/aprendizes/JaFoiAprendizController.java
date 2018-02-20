package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.JaFoiAprendizRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.JaFoiAprendiz;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class JaFoiAprendizController {

	private JaFoiAprendizRepository aprendizRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	private JaFoiAprendizRepository jaFoiAprendizRepository;
	
	@Autowired
	public void AprendizEndPoint(
			JaFoiAprendizRepository aprendizRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository,
			JaFoiAprendizRepository jaFoiAprendizRepository
			) {
		this.aprendizRepository = aprendizRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
		this.jaFoiAprendizRepository = jaFoiAprendizRepository;
	}

	@GetMapping("/jaFoiAprendiz/{id}")
	public ModelAndView aprendizes(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isJaFoiAprendizListar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/aprendiz/aprendizes");
			modelAndView.addObject("aprendizes", jaFoiAprendizRepository.findAllByJovem(jovem));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}
	
	@GetMapping("/aprendizes/form/{id}")
	public ModelAndView aprendizJovem(JaFoiAprendiz aprendiz, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isJaFoiAprendizCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/aprendiz/aprendiz");
			Jovem jovem = jovemRepository.findOne(id);
			modelAndView.addObject("aprendiz", aprendiz);
			modelAndView.addObject("jovem", jovem);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/aprendizes")
	public ModelAndView save(@Valid JaFoiAprendiz aprendiz, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isJaFoiAprendizCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/aprendiz/aprendiz");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("aprendiz", aprendiz);
				modelAndView.addObject("jovem", jovemRepository.findOne(aprendiz.getJovem().getId()));
			} else {
				aprendizRepository.save(aprendiz);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("aprendiz", aprendiz);
				modelAndView.addObject("jovem", jovemRepository.findOne(aprendiz.getJovem().getId()));
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+aprendiz.getJovem().getId());			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/aprendizes/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		JaFoiAprendiz aprendiz = aprendizRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isJaFoiAprendizVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/aprendiz/aprendiz");
			modelAndView.addObject("aprendiz", aprendiz);
			modelAndView.addObject("jovem", jovemRepository.findOne(aprendiz.getJovem().getId()));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+aprendiz.getJovem().getId());			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/aprendizes/{id}")
	public ModelAndView update(@Valid JaFoiAprendiz aprendiz, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isJaFoiAprendizEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/aprendiz/aprendiz");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("aprendiz", aprendiz);
				modelAndView.addObject("jovem", jovemRepository.findOne(aprendiz.getJovem().getId()));
			} else {
				aprendizRepository.save(aprendiz);
				modelAndView.addObject("aprendiz", aprendiz);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("jovem", jovemRepository.findOne(aprendiz.getJovem().getId()));
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovemRepository.findOne(aprendiz.getJovem().getId()));			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
