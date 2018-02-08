package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.aprendizes.SituacaoDeSaudeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.SituacaoDeSaude;

@Controller
@Transactional
@RequestMapping("/sw")
public class SituacaoDeSaudeController {

	private SituacaoDeSaudeRepository situacaoDeSaudeRepository;
	private UsuarioRepository usuarioRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public SituacaoDeSaudeController(
			SituacaoDeSaudeRepository situacaoDeSaudeRepository,
			UsuarioRepository usuarioRepository,
			JovemRepository jovemRepository
			) {
		this.situacaoDeSaudeRepository = situacaoDeSaudeRepository;
		this.usuarioRepository = usuarioRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/situacaoDeSaude/form")
	public ModelAndView situacaoDeSaude(SituacaoDeSaude situacaoDeSaude) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/saudes/saude");
		modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/situacaoDeSaude/form/{id}")
	public ModelAndView situacaoDeSaudeJovem(SituacaoDeSaude situacaoDeSaude, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/saudes/saude");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
	}

	@PostMapping("/situacaoDeSaude")
	public ModelAndView save(@Valid SituacaoDeSaude situacaoDeSaude, BindingResult bindingResult) {
		Long id = situacaoDeSaude.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		} else {
			situacaoDeSaudeRepository.save(situacaoDeSaude);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		}		
		return modelAndView;
	}

	@GetMapping("/situacaoDeSaude/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/saudes/saude");
		SituacaoDeSaude situacaoDeSaude = situacaoDeSaudeRepository.findOne(id);
		modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/situacaoDeSaude/{id}")
	public ModelAndView update(@Valid SituacaoDeSaude situacaoDeSaude, BindingResult bindingResult) {
		Long id = situacaoDeSaude.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		} else {
			situacaoDeSaudeRepository.save(situacaoDeSaude);
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	@GetMapping("/situacaoDeSaudeJovem/{id}")
	public ModelAndView situacaoDeSaudeJovem(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/saudes/saude");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		if (situacaoDeSaudeRepository.findByJovem(jovem) != null) {
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaudeRepository.findByJovem(jovem));
		} else {
			SituacaoDeSaude situacaoDeSaude = new SituacaoDeSaude();
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		}
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
	}
	
}
