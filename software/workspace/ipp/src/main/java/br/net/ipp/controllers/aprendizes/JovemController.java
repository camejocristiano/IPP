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

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class JovemController {

	private JovemRepository jovemRepository;
	private EnumService enumService;
	
	@Autowired
	public JovemController (
			JovemRepository jovemRepository,
			EnumService enumService
			) {
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
	}
	
	@GetMapping("/jovens")
	public ModelAndView aprendizes() {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens");
		modelAndView.addObject("jovens", jovemRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/jovem")
	public ModelAndView aprendiz() {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/home");
		return modelAndView;
	}

	@GetMapping("/jovem/form")
	public ModelAndView jovem(Jovem jovem) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/jovem");
		modelAndView.addObject("jovem", jovem);
		List<String> status = enumService.carregarStatus();
		modelAndView.addObject("status", status);
		List<String> sexo = enumService.carregarSexo();
		modelAndView.addObject("sexo", sexo);
		List<String> area = enumService.carregarArea();
		modelAndView.addObject("area", area);
		List<String> regiao = enumService.carregarRegiao();
		modelAndView.addObject("regiao", regiao);
		List<String> estadoCivil = enumService.carregarEstadoCivil();
		modelAndView.addObject("estadoCivil", estadoCivil);
		List<String> tipoDeInsercao = enumService.carregarTipoDeInsercao();
		modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
		List<String> aEDiasDaSemana = enumService.carregarAEDiasDaSemana();
		modelAndView.addObject("aEDiasDaSemana", aEDiasDaSemana);
		List<String> diasDaSemana = enumService.carregarDiasDaSemana();
		modelAndView.addObject("diasDaSemana", diasDaSemana);
		List<String> tiposDeCNH = enumService.carregarTiposDeCNH();
		modelAndView.addObject("tiposDeCNH", tiposDeCNH);
		List<String> servicoMilitarSituacoes = enumService.carregarServicoMilitarSituacoes();
		modelAndView.addObject("servicoMilitarSituacoes", servicoMilitarSituacoes);
		return modelAndView;
	}

	@PostMapping("/jovem")
	public ModelAndView save(@Valid Jovem jovem, BindingResult bindingResult) {
		Long id = null;
		ModelAndView modelAndView = null;
		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("redirect:/jovens/");
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("jovem", jovem);
			List<String> status = enumService.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> sexo = enumService.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> area = enumService.carregarArea();
			modelAndView.addObject("area", area);
			List<String> regiao = enumService.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			List<String> estadoCivil = enumService.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> tipoDeInsercao = enumService.carregarTipoDeInsercao();
			modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
			List<String> aEDiasDaSemana = enumService.carregarAEDiasDaSemana();
			modelAndView.addObject("aEDiasDaSemana", aEDiasDaSemana);
			List<String> diasDaSemana = enumService.carregarDiasDaSemana();
			modelAndView.addObject("diasDaSemana", diasDaSemana);
			List<String> tiposDeCNH = enumService.carregarTiposDeCNH();
			modelAndView.addObject("tiposDeCNH", tiposDeCNH);
			List<String> servicoMilitarSituacoes = enumService.carregarServicoMilitarSituacoes();
			modelAndView.addObject("servicoMilitarSituacoes", servicoMilitarSituacoes);
		} else {
			jovemRepository.save(jovem);
			Jovem jov = jovemRepository.findByEmail(jovem.getEmail());
			id = jov.getId();
			modelAndView = new ModelAndView("redirect:/jovens/"+id);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("jovem", jovem);		
			List<String> status = enumService.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> sexo = enumService.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> area = enumService.carregarArea();
			modelAndView.addObject("area", area);
			List<String> regiao = enumService.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			List<String> estadoCivil = enumService.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> tipoDeInsercao = enumService.carregarTipoDeInsercao();
			modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
			List<String> aEDiasDaSemana = enumService.carregarAEDiasDaSemana();
			modelAndView.addObject("aEDiasDaSemana", aEDiasDaSemana);
			List<String> diasDaSemana = enumService.carregarDiasDaSemana();
			modelAndView.addObject("diasDaSemana", diasDaSemana);
			List<String> tiposDeCNH = enumService.carregarTiposDeCNH();
			modelAndView.addObject("tiposDeCNH", tiposDeCNH);
			List<String> servicoMilitarSituacoes = enumService.carregarServicoMilitarSituacoes();
			modelAndView.addObject("servicoMilitarSituacoes", servicoMilitarSituacoes);
		}		
		return modelAndView;
	}

	@GetMapping("/jovemForm/{id}")
	public ModelAndView jovemForm(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/jovem");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		List<String> status = enumService.carregarStatus();
		modelAndView.addObject("status", status);
		List<String> sexo = enumService.carregarSexo();
		modelAndView.addObject("sexo", sexo);
		List<String> area = enumService.carregarArea();
		modelAndView.addObject("area", area);
		List<String> regiao = enumService.carregarRegiao();
		modelAndView.addObject("regiao", regiao);
		List<String> estadoCivil = enumService.carregarEstadoCivil();
		modelAndView.addObject("estadoCivil", estadoCivil);
		List<String> tipoDeInsercao = enumService.carregarTipoDeInsercao();
		modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
		List<String> diasDaSemana = enumService.carregarDiasDaSemana();
		modelAndView.addObject("diasDaSemana", diasDaSemana);
		List<String> aEDiasDaSemana = enumService.carregarAEDiasDaSemana();
		modelAndView.addObject("aEDiasDaSemana", aEDiasDaSemana);
		List<String> tiposDeCNH = enumService.carregarTiposDeCNH();
		modelAndView.addObject("tiposDeCNH", tiposDeCNH);
		List<String> servicoMilitarSituacoes = enumService.carregarServicoMilitarSituacoes();
		modelAndView.addObject("servicoMilitarSituacoes", servicoMilitarSituacoes);
		return modelAndView;
	}
	
	@GetMapping("/jovem/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/home");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		List<String> status = enumService.carregarStatus();
		modelAndView.addObject("status", status);
		List<String> sexo = enumService.carregarSexo();
		modelAndView.addObject("sexo", sexo);
		List<String> area = enumService.carregarArea();
		modelAndView.addObject("area", area);
		List<String> regiao = enumService.carregarRegiao();
		modelAndView.addObject("regiao", regiao);
		List<String> estadoCivil = enumService.carregarEstadoCivil();
		modelAndView.addObject("estadoCivil", estadoCivil);
		List<String> tipoDeInsercao = enumService.carregarTipoDeInsercao();
		modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
		List<String> diasDaSemana = enumService.carregarDiasDaSemana();
		modelAndView.addObject("diasDaSemana", diasDaSemana);
		List<String> aEDiasDaSemana = enumService.carregarAEDiasDaSemana();
		modelAndView.addObject("aEDiasDaSemana", aEDiasDaSemana);
		List<String> tiposDeCNH = enumService.carregarTiposDeCNH();
		modelAndView.addObject("tiposDeCNH", tiposDeCNH);
		List<String> servicoMilitarSituacoes = enumService.carregarServicoMilitarSituacoes();
		modelAndView.addObject("servicoMilitarSituacoes", servicoMilitarSituacoes);
		return modelAndView;
	}
	
	@PostMapping("/jovem/{id}")
	public ModelAndView update(@Valid Jovem jovem, BindingResult bindingResult) {
		Long id = jovem.getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("jovem", jovem);
			List<String> status = enumService.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> sexo = enumService.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> area = enumService.carregarArea();
			modelAndView.addObject("area", area);
			List<String> regiao = enumService.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			List<String> estadoCivil = enumService.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> tipoDeInsercao = enumService.carregarTipoDeInsercao();
			modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
			List<String> aEDiasDaSemana = enumService.carregarAEDiasDaSemana();
			modelAndView.addObject("aEDiasDaSemana", aEDiasDaSemana);
			List<String> diasDaSemana = enumService.carregarDiasDaSemana();
			modelAndView.addObject("diasDaSemana", diasDaSemana);
			List<String> tiposDeCNH = enumService.carregarTiposDeCNH();
			modelAndView.addObject("tiposDeCNH", tiposDeCNH);
			List<String> servicoMilitarSituacoes = enumService.carregarServicoMilitarSituacoes();
			modelAndView.addObject("servicoMilitarSituacoes", servicoMilitarSituacoes);
		} else {
			jovemRepository.save(jovem);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("jovem", jovem);
			List<String> status = enumService.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> sexo = enumService.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> area = enumService.carregarArea();
			modelAndView.addObject("area", area);
			List<String> regiao = enumService.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			List<String> estadoCivil = enumService.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> tipoDeInsercao = enumService.carregarTipoDeInsercao();
			modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
			List<String> aEDiasDaSemana = enumService.carregarAEDiasDaSemana();
			modelAndView.addObject("aEDiasDaSemana", aEDiasDaSemana);
			List<String> diasDaSemana = enumService.carregarDiasDaSemana();
			modelAndView.addObject("diasDaSemana", diasDaSemana);
			List<String> tiposDeCNH = enumService.carregarTiposDeCNH();
			modelAndView.addObject("tiposDeCNH", tiposDeCNH);
			List<String> servicoMilitarSituacoes = enumService.carregarServicoMilitarSituacoes();
			modelAndView.addObject("servicoMilitarSituacoes", servicoMilitarSituacoes);
		}	
		return modelAndView;
	}

}
