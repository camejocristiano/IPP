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

import br.net.ipp.daos.aprendizes.FichaProfissionalRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.enums.SituacaoAtual;
import br.net.ipp.enums.Status;
import br.net.ipp.models.aprendizes.FichaProfissional;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/fichasProfissionais")
public class FichaProfissionalController {

	private FichaProfissionalRepository fichaProfissionalRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void FichaProfissionalEndPoint(
			FichaProfissionalRepository fichaProfissionalRepository,
			JovemRepository jovemRepository
			) {
		this.fichaProfissionalRepository = fichaProfissionalRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView fichaProfissional(FichaProfissional fichaProfissional) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView fichaProfissionalJovem(FichaProfissional fichaProfissional, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("jovem", jovem);
		List<String> situacoesAtuais = this.carregarSituacaoAtual();
		modelAndView.addObject("situacoesAtuais", situacoesAtuais);
		List<String> status = this.carregarStatus();
		modelAndView.addObject("status", status);
		return modelAndView;
	}

	@PostMapping
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

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findOne(id);
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
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
	
	public List<String> carregarStatus() {
		List<Status> lista = Arrays.asList(Status.values());
		List<String> status = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			status.add(lista.get(i).name());
		}
		return status;
	}
	
	public List<String> carregarSituacaoAtual() {
		List<SituacaoAtual> lista = Arrays.asList(SituacaoAtual.values());
		List<String> situacoesAtuais = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			situacoesAtuais.add(lista.get(i).name());
		}
		return situacoesAtuais;
	}
}
