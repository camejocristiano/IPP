package br.net.ipp.controllers.aprendizes;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.DadosFinanceirosRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.DadosFinanceiros;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class DadosFinanceirosController {

	private DadosFinanceirosRepository dadosFinanceirosRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	private UsuarioRepository usuarioRepository;
	private ContatoRepository contatoRepository;
    private RepresentanteLegalRepository representanteLegalRepository;
    private GestorRepository gestorRepository;
    
	
	@Autowired
	public DadosFinanceirosController (
			DadosFinanceirosRepository dadosFinanceirosRepository,
			JovemRepository jovemRepository,
			EnumService enumService,
			ContatoRepository contatoRepository,
    		RepresentanteLegalRepository representanteLegalRepository,
    		GestorRepository gestorRepository,
    		UsuarioRepository usuarioRepository
			) {
		this.dadosFinanceirosRepository = dadosFinanceirosRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
		this.contatoRepository = contatoRepository;
        this.representanteLegalRepository = representanteLegalRepository;
        this.gestorRepository = gestorRepository;
    }

	@GetMapping("/dadosFinanceiros/form")
	public ModelAndView dadosFinanceiros(DadosFinanceiros dadosFinanceiros, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isDadosFinanceirosCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
			modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+dadosFinanceiros.getJovem().getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/dadosFinanceirosJovem/{id}")
	public ModelAndView dadosFinanceiros(DadosFinanceiros dadosFinanceiros, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isDadosFinanceirosVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
			if (dadosFinanceirosRepository.findByJovem(jovem) != null) {
				DadosFinanceiros daFinanceiros = dadosFinanceirosRepository.findByJovem(jovem);
				BigDecimal totalIPP = new BigDecimal("0.00");
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bemValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bomValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_integracaoValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_metroValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_onibusMunicipalValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_tremValor());
				modelAndView.addObject("totalIPP", totalIPP.toString());
				
				BigDecimal totalEmpresa = new BigDecimal("0.00");
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bemValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bomValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_integracaoValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_metroValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_onibusMunicipalValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_tremValor());
				modelAndView.addObject("totalEmpresa", totalEmpresa.toString());
				
				modelAndView.addObject("dadosFinanceiros", daFinanceiros);
			} else {
				modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
			}
			List<String> tiposDeContratacoes = this.enumService.carregarTipoDeContratacao();
			modelAndView.addObject("tiposDeContratacoes", tiposDeContratacoes);
			List<String> periodos = this.enumService.carregarPeriodo();
			modelAndView.addObject("periodos", periodos);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/dadosFinanceiros")
	public ModelAndView save(@Valid DadosFinanceiros dadosFinanceiros, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		Jovem jovem = jovemRepository.findOne(dadosFinanceiros.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isDadosFinanceirosCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
				DadosFinanceiros daFinanceiros = dadosFinanceirosRepository.findByJovem(jovem);
				BigDecimal totalIPP = new BigDecimal("0.00");
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bemValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bomValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_integracaoValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_metroValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_onibusMunicipalValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_tremValor());
				modelAndView.addObject("totalIPP", totalIPP.toString());
				
				BigDecimal totalEmpresa = new BigDecimal("0.00");
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bemValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bomValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_integracaoValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_metroValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_onibusMunicipalValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_tremValor());
				modelAndView.addObject("totalEmpresa", totalEmpresa.toString());
			} else {
				dadosFinanceirosRepository.save(dadosFinanceiros);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
				DadosFinanceiros daFinanceiros = dadosFinanceirosRepository.findByJovem(jovem);
				BigDecimal totalIPP = new BigDecimal("0.00");
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bemValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bomValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_integracaoValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_metroValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_onibusMunicipalValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_tremValor());
				modelAndView.addObject("totalIPP", totalIPP.toString());
				
				BigDecimal totalEmpresa = new BigDecimal("0.00");
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bemValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bomValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_integracaoValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_metroValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_onibusMunicipalValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_tremValor());
				modelAndView.addObject("totalEmpresa", totalEmpresa.toString());
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/dadosFinanceiros/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		DadosFinanceiros dadosFinanceiros = dadosFinanceirosRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(dadosFinanceiros.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isDadosFinanceirosVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
			modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
			List<String> tiposDeContratacoes = this.enumService.carregarTipoDeContratacao();
			modelAndView.addObject("tiposDeContratacoes", tiposDeContratacoes);
			List<String> periodos = this.enumService.carregarPeriodo();
			modelAndView.addObject("periodos", periodos);
			DadosFinanceiros daFinanceiros = dadosFinanceirosRepository.findByJovem(jovem);
			BigDecimal totalIPP = new BigDecimal("0.00");
			totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bemValor());
			totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bomValor());
			totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_integracaoValor());
			totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_metroValor());
			totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_onibusMunicipalValor());
			totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_tremValor());
			modelAndView.addObject("totalIPP", totalIPP.toString());
			
			BigDecimal totalEmpresa = new BigDecimal("0.00");
			totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bemValor());
			totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bomValor());
			totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_integracaoValor());
			totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_metroValor());
			totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_onibusMunicipalValor());
			totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_tremValor());
			modelAndView.addObject("totalEmpresa", totalEmpresa.toString());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/dadosFinanceiros/{id}")
	public ModelAndView update(@Valid DadosFinanceiros dadosFinanceiros, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		Jovem jovem = jovemRepository.findOne(dadosFinanceiros.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isDadosFinanceirosEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
				DadosFinanceiros daFinanceiros = dadosFinanceirosRepository.findByJovem(jovem);
				BigDecimal totalIPP = new BigDecimal("0.00");
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bemValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bomValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_integracaoValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_metroValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_onibusMunicipalValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_tremValor());
				modelAndView.addObject("totalIPP", totalIPP.toString());
				
				BigDecimal totalEmpresa = new BigDecimal("0.00");
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bemValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bomValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_integracaoValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_metroValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_onibusMunicipalValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_tremValor());
				modelAndView.addObject("totalEmpresa", totalEmpresa.toString());
			} else {
				dadosFinanceirosRepository.save(dadosFinanceiros);
				modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				DadosFinanceiros daFinanceiros = dadosFinanceirosRepository.findByJovem(jovem);
				BigDecimal totalIPP = new BigDecimal("0.00");
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bemValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_bomValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_integracaoValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_metroValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_onibusMunicipalValor());
				totalIPP = totalIPP.add(daFinanceiros.getValeTransporteIPPCurso_tremValor());
				modelAndView.addObject("totalIPP", totalIPP.toString());
				
				BigDecimal totalEmpresa = new BigDecimal("0.00");
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bemValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_bomValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_integracaoValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_metroValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_onibusMunicipalValor());
				totalEmpresa = totalEmpresa.add(daFinanceiros.getValeTransporteEmpresaTrabalho_tremValor());
				modelAndView.addObject("totalEmpresa", totalEmpresa.toString());
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

}
