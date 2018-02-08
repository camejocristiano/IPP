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

import br.net.ipp.daos.aprendizes.FichaSocialRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.FichaSocial;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class FichaSocialController {

	private FichaSocialRepository fichaSocialRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	
	@Autowired
	public FichaSocialController(
			FichaSocialRepository fichaSocialRepository,
			JovemRepository jovemRepository,
			EnumService enumService
			) {
		this.fichaSocialRepository = fichaSocialRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/fichaSocial/form")
	public ModelAndView fichaSocial(FichaSocial fichaSocial) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/social");
		modelAndView.addObject("fichaSocial", fichaSocial);
		List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
		modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
		List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
		modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
		List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
		modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		return modelAndView;
	}
	
	@GetMapping("/fichaSocial/form/{id}")
	public ModelAndView fichaSocialJovem(FichaSocial fichaSocial, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/social");
		modelAndView.addObject("fichaSocial", fichaSocial);
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
		modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
		List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
		modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
		List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
		modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		return modelAndView;
	}

	@PostMapping("/fichaSocial")
	public ModelAndView save(@Valid FichaSocial fichaSocial, BindingResult bindingResult) {
		Long id = fichaSocial.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("fichaSocial", fichaSocial);
		} else {
			fichaSocialRepository.save(fichaSocial);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("fichaSocial", fichaSocial);
		}		
		return modelAndView;
	}

	@GetMapping("/fichaSocial/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/social");
		FichaSocial fichaSocial = fichaSocialRepository.findOne(id);
		modelAndView.addObject("fichaSocial", fichaSocial);
		List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
		modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
		List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
		modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
		List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
		modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		return modelAndView;
	}
	
	@PostMapping("/fichaSocial/{id}")
	public ModelAndView update(@Valid FichaSocial fichaSocial, BindingResult bindingResult) {
		Long id = fichaSocial.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("fichaSocial", fichaSocial);
		} else {
			fichaSocialRepository.save(fichaSocial);
			modelAndView.addObject("fichaSocial", fichaSocial);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}

	@GetMapping("/fichaSocialJovem/{id}")
	public ModelAndView fichaSocialJovem(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/social");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		if (fichaSocialRepository.findByJovem(jovem) != null) {
			modelAndView.addObject("fichaSocial", fichaSocialRepository.findByJovem(jovem));
		} else {
			FichaSocial fichaSocial = new FichaSocial();
			modelAndView.addObject("fichaSocial", fichaSocial);
		}
		List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
		modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
		List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
		modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
		List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
		modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		return modelAndView;
	}
	
}
