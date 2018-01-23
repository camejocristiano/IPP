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

import br.net.ipp.daos.aprendizes.JaFoiAprendizRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.JaFoiAprendiz;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/aprendizes")
public class JaFoiAprendizController {

	private JaFoiAprendizRepository aprendizRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void AprendizEndPoint(
			JaFoiAprendizRepository aprendizRepository,
			JovemRepository jovemRepository
			) {
		this.aprendizRepository = aprendizRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView aprendiz(JaFoiAprendiz aprendiz) {
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens");
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView aprendizJovem(JaFoiAprendiz aprendiz, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/laborais/aprendiz/aprendiz");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("aprendiz", aprendiz);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid JaFoiAprendiz aprendiz, BindingResult bindingResult) {
		Long id = aprendiz.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("aprendiz", aprendiz);
		} else {
			aprendizRepository.save(aprendiz);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("aprendiz", aprendiz);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/laborais/aprendiz/aprendiz");
		JaFoiAprendiz aprendiz = aprendizRepository.findOne(id);
		modelAndView.addObject("aprendiz", aprendiz);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid JaFoiAprendiz aprendiz, BindingResult bindingResult) {
		Long id = aprendiz.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("aprendiz", aprendiz);
		} else {
			aprendizRepository.save(aprendiz);
			modelAndView.addObject("aprendiz", aprendiz);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
