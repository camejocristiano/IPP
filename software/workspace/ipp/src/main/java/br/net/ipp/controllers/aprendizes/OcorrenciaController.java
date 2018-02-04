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

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.aprendizes.OcorrenciaRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.enums.TipoDeOcorrencia;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.Ocorrencia;

@Controller
@Transactional
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

	private OcorrenciaRepository ocorrenciaRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void OcorrenciaEndPoint(
			OcorrenciaRepository ocorrenciaRepository,
			UsuarioRepository usuarioRepository,
			JovemRepository jovemRepository
			) {
		this.ocorrenciaRepository = ocorrenciaRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/form")
	public ModelAndView ocorrencia(Ocorrencia ocorrencia) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/ocorrencias/form");
		modelAndView.addObject("ocorrencia", ocorrencia);
		Jovem jovem = jovemRepository.findOne((long)1);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		List<String> tiposDeOcorrencias = this.carregarTipoDeOcorrencia();
		modelAndView.addObject("tiposDeOcorrencias", tiposDeOcorrencias);	
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView ocorrenciaJovem(@PathVariable Long id, Ocorrencia ocorrencia) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/ocorrencias/ocorrencia");
		modelAndView.addObject("ocorrencia", ocorrencia);
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		List<String> tiposDeOcorrencias = this.carregarTipoDeOcorrencia();
		modelAndView.addObject("tiposDeOcorrencias", tiposDeOcorrencias);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Ocorrencia ocorrencia, BindingResult bindingResult) {
		Long id = ocorrencia.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("ocorrencia", ocorrencia);
		} else {
			ocorrenciaRepository.save(ocorrencia);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("ocorrencia", ocorrencia);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/ocorrencias/ocorrencia");
		Ocorrencia ocorrencia = ocorrenciaRepository.findOne(id);
		modelAndView.addObject("ocorrencia", ocorrencia);
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		List<String> tiposDeOcorrencias = this.carregarTipoDeOcorrencia();
		modelAndView.addObject("tiposDeOcorrencias", tiposDeOcorrencias);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Ocorrencia ocorrencia, BindingResult bindingResult) {
		Long id = ocorrencia.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("ocorrencia", ocorrencia);
		} else {
			ocorrenciaRepository.save(ocorrencia);
			modelAndView.addObject("ocorrencia", ocorrencia);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	public List<String> carregarTipoDeOcorrencia() {
		List<TipoDeOcorrencia> lista = Arrays.asList(TipoDeOcorrencia.values());
		List<String> tiposDeOcorrencias = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeOcorrencias.add(lista.get(i).name());
		}
		return tiposDeOcorrencias;
	}
	
}
