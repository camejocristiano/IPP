package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.FichaProfissionalRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.FichaProfissional;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class FichaProfissionalController {

	private FichaProfissionalRepository fichaProfissionalRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	
	@Autowired
	public FichaProfissionalController (
			FichaProfissionalRepository fichaProfissionalRepository,
			JovemRepository jovemRepository,
			EnumService enumService
			) {
		this.fichaProfissionalRepository = fichaProfissionalRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/fichaProfissional/form")
	public ModelAndView fichaProfissional(FichaProfissional fichaProfissional) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		return modelAndView;
	}
	
	@GetMapping("/fichaProfissional/form/{id}")
	public ModelAndView fichaProfissionalJovem(FichaProfissional fichaProfissional, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("jovem", jovem);
		List<String> situacoesAtuais = this.enumService.carregarSituacaoAtual();
		modelAndView.addObject("situacoesAtuais", situacoesAtuais);
		List<String> status = this.enumService.carregarStatus();
		modelAndView.addObject("status", status);
		return modelAndView;
	}

	@PostMapping("/fichaProfissional")
	public ModelAndView save(@Valid FichaProfissional fichaProfissional, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("fichaProfissional", fichaProfissional);
		} else {
			fichaProfissionalRepository.save(fichaProfissional);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("fichaProfissional", fichaProfissional);
		}		
		return modelAndView;
	}

	@GetMapping("/fichaProfissional/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findOne(id);
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		return modelAndView;
	}
	
	@PostMapping("/fichaProfissional/{id}")
	public ModelAndView update(@Valid FichaProfissional fichaProfissional, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("fichaProfissional", fichaProfissional);
		} else {
			fichaProfissionalRepository.save(fichaProfissional);
			modelAndView.addObject("fichaProfissional", fichaProfissional);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	@GetMapping("/fichaProfissionalJovem/{id}")
	public ModelAndView fichaProfissionalJovem(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		if (fichaProfissionalRepository.findByJovem(jovem) != null) {
			modelAndView.addObject("fichaProfissional", fichaProfissionalRepository.findByJovem(jovem));
		} else {
			FichaProfissional fichaProfissional = new FichaProfissional();
			modelAndView.addObject("fichaProfissional", fichaProfissional);
		}
		List<String> situacoesAtuais = this.enumService.carregarSituacaoAtual();
		modelAndView.addObject("situacoesAtuais", situacoesAtuais);
		List<String> status = this.enumService.carregarStatus();
		modelAndView.addObject("status", status);
		return modelAndView;
	}
	
}
