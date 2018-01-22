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

import br.net.ipp.daos.aprendizes.AvaliacaoPAPIPPRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.AvaliacaoPAPIPP;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/avaliacoesPAPsIPP")
public class AvaliacaoPAPIPPController {

	private AvaliacaoPAPIPPRepository avaliacaoPAPIPPRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void AvaliacaoPAPIPPEndPoint(
			AvaliacaoPAPIPPRepository avaliacaoPAPIPPRepository,
			JovemRepository jovemRepository
			) {
		this.avaliacaoPAPIPPRepository = avaliacaoPAPIPPRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView avaliacaoPAPIPP(AvaliacaoPAPIPP avaliacaoPAPIPP) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/paps/pap");
		modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView avaliacaoPAPIPP(AvaliacaoPAPIPP avaliacaoPAPIPP, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/paps/pap");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid AvaliacaoPAPIPP avaliacaoPAPIPP, BindingResult bindingResult) {
		Long id = avaliacaoPAPIPP.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
		} else {
			avaliacaoPAPIPPRepository.save(avaliacaoPAPIPP);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
		AvaliacaoPAPIPP avaliacaoPAPIPP = avaliacaoPAPIPPRepository.findOne(id);
		modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid AvaliacaoPAPIPP avaliacaoPAPIPP, BindingResult bindingResult) {
		Long id = avaliacaoPAPIPP.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
		} else {
			avaliacaoPAPIPPRepository.save(avaliacaoPAPIPP);
			modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
