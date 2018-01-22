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

import br.net.ipp.daos.aprendizes.AvaliacaoPAPEmpresaRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.AvaliacaoPAPEmpresa;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/avaliacoesPAPsEmpresa")
public class AvaliacaoPAPEmpresaController {

	private AvaliacaoPAPEmpresaRepository avaliacaoPAPEmpresaRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void AvaliacaoPAPEmpresaEndPoint(
			AvaliacaoPAPEmpresaRepository avaliacaoPAPEmpresaRepository,
			JovemRepository jovemRepository
			) {
		this.avaliacaoPAPEmpresaRepository = avaliacaoPAPEmpresaRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView avaliacaoPAPEmpresa(AvaliacaoPAPEmpresa avaliacaoPAPEmpresa) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
		modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView avaliacaoPAPEmpresa(AvaliacaoPAPEmpresa avaliacaoPAPEmpresa, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid AvaliacaoPAPEmpresa avaliacaoPAPEmpresa, BindingResult bindingResult) {
		Long id = avaliacaoPAPEmpresa.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
		} else {
			avaliacaoPAPEmpresaRepository.save(avaliacaoPAPEmpresa);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
		AvaliacaoPAPEmpresa avaliacaoPAPEmpresa = avaliacaoPAPEmpresaRepository.findOne(id);
		modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid AvaliacaoPAPEmpresa avaliacaoPAPEmpresa, BindingResult bindingResult) {
		Long id = avaliacaoPAPEmpresa.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
		} else {
			avaliacaoPAPEmpresaRepository.save(avaliacaoPAPEmpresa);
			modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}

}
