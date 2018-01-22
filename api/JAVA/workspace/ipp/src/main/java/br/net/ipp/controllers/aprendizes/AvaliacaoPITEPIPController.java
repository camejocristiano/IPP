package br.net.ipp.controllers.aprendizes;

import java.util.ArrayList;
import java.util.Arrays;
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

import br.net.ipp.daos.aprendizes.AvaliacaoPITEPIPRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.enums.TipoAvaliacaoEnum;
import br.net.ipp.models.aprendizes.AvaliacaoPITEPIP;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/avaliacoesPITsEPIPs")
public class AvaliacaoPITEPIPController {

	private AvaliacaoPITEPIPRepository avaliacaoPITEPIPRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void AvaliacaoPITEPIPEndPoint(
			AvaliacaoPITEPIPRepository avaliacaoPITEPIPRepository,
			JovemRepository jovemRepository
			) {
		this.avaliacaoPITEPIPRepository = avaliacaoPITEPIPRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView avaliacaoPITEPIP(AvaliacaoPITEPIP avaliacaoPITEPIP) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/pitsepips/pitepip");
		modelAndView.addObject("avaliacaoPITEPIP", avaliacaoPITEPIP);
		List<String> tiposAvaliacoesEnum = this.carregarTipoAvaliacaoEnum();
		modelAndView.addObject("tiposAvaliacoesEnum", tiposAvaliacoesEnum);
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView avaliacaoPITEPIP(AvaliacaoPITEPIP avaliacaoPITEPIP, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/pitsepips/pitepip");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("avaliacaoPITEPIP", avaliacaoPITEPIP);
		List<String> tiposAvaliacoesEnum = this.carregarTipoAvaliacaoEnum();
		modelAndView.addObject("tiposAvaliacoesEnum", tiposAvaliacoesEnum);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid AvaliacaoPITEPIP avaliacaoPITEPIP, BindingResult bindingResult) {
		Long id = avaliacaoPITEPIP.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("avaliacaoPITEPIP", avaliacaoPITEPIP);
		} else {
			avaliacaoPITEPIPRepository.save(avaliacaoPITEPIP);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("avaliacaoPITEPIP", avaliacaoPITEPIP);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/pitsepips/pitepip");
		AvaliacaoPITEPIP avaliacaoPITEPIP = avaliacaoPITEPIPRepository.findOne(id);
		modelAndView.addObject("avaliacaoPITEPIP", avaliacaoPITEPIP);
		List<String> tiposAvaliacoesEnum = this.carregarTipoAvaliacaoEnum();
		modelAndView.addObject("tiposAvaliacoesEnum", tiposAvaliacoesEnum);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid AvaliacaoPITEPIP avaliacaoPITEPIP, BindingResult bindingResult) {
		Long id = avaliacaoPITEPIP.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("avaliacaoPITEPIP", avaliacaoPITEPIP);
		} else {
			avaliacaoPITEPIPRepository.save(avaliacaoPITEPIP);
			modelAndView.addObject("avaliacaoPITEPIP", avaliacaoPITEPIP);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	public List<String> carregarTipoAvaliacaoEnum() {
		List<TipoAvaliacaoEnum> lista = Arrays.asList(TipoAvaliacaoEnum.values());
		List<String> tiposAvaliacoesEnum = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposAvaliacoesEnum.add(lista.get(i).name());
		}
		return tiposAvaliacoesEnum;
	}
	
}
