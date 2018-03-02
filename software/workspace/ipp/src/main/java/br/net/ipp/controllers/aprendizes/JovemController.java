package br.net.ipp.controllers.aprendizes;

import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.services.EnumService;
import br.net.ipp.storage.StorageService;

@Controller
@Transactional
@RequestMapping("/sw")
public class JovemController {

	private JovemRepository jovemRepository;
	private EnumService enumService;
	private UsuarioRepository usuarioRepository;
	private final StorageService storageService;
	Calendar c = Calendar.getInstance();
	private ContatoRepository contatoRepository;
    private RepresentanteLegalRepository representanteLegalRepository;
    private GestorRepository gestorRepository;
    private UnidadeRepository unidadeRepository;
	
	@Autowired
	public JovemController (
			JovemRepository jovemRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository,
			StorageService storageService,
			ContatoRepository contatoRepository,
    		RepresentanteLegalRepository representanteLegalRepository,
    		GestorRepository gestorRepository,
    		UnidadeRepository unidadeRepository
    		) {
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
		this.storageService = storageService;
		this.contatoRepository = contatoRepository;
        this.representanteLegalRepository = representanteLegalRepository;
        this.gestorRepository = gestorRepository;
        this.unidadeRepository = unidadeRepository;
	}
	
	/**
	 * @param userDetails
	 * @return
	 * 		List<Jovem>
	 * @exception
	 * 		Index
	 */
	@GetMapping("/jovens")
	public ModelAndView aprendizes(@AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isJovemListar() == true) {
			modelAndView = new ModelAndView("aprendizes/jovens");
			if (usuarioSessao.isAdmin() == true) {
				modelAndView.addObject("jovens", jovemRepository.findAll());
			} else {
				modelAndView.addObject("jovens", jovemRepository.findAllByUnidade(usuarioSessao.getUnidade()));
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/jovem")
	public ModelAndView aprendiz(@AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isJovemVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/jovens/home");
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/jovem/form")
	public ModelAndView jovem(Jovem jovem, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isJovemCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/jovens/jovem");
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("unidades", unidadeRepository.findAll());
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
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/jovem")
	public ModelAndView save(@Valid Jovem jovem, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isJovemCadastrar() == true) {
			if (bindingResult.hasErrors()) {
				modelAndView = new ModelAndView("aprendizes/jovens/jovem/");
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
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
				modelAndView = new ModelAndView("aprendizes/jovens/jovem");
				modelAndView.addObject("color", "#26a69a");
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
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/jovemForm/{id}")
	public ModelAndView jovemForm(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isJovemVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/jovens/jovem");
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
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/jovem/{id}")
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
		if (usuarioSessao.getGrupoDePermissoes().isJovemVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/jovens/home");
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
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/jovem/{id}")
	public ModelAndView update(@Valid Jovem jovem, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isJovemEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/jovens/jovem");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
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
				modelAndView.addObject("color", "#26a69a");
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
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/jovem/foto/{id}")
    public ModelAndView foto(@PathVariable Long id, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/jovem");
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
		if (usuarioSessao.getGrupoDePermissoes().isJovemEditar() == true) {
			if (file == null) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "A imagem não pode ser nula!");
			} else {
				if (jovem.getFoto() != null && jovem.getFoto() != "") {
					storageService.deleteOne(jovem.getFoto());					
				}
				String classe = "Foto-Jovem"; 
				String nome = jovem.getNome();
				String dia = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
				String mes = Integer.toString(c.get(Calendar.MONTH));
				String ano = Integer.toString(c.get(Calendar.YEAR));
				String data = dia+"-"+mes+"-"+ano;
				String email = jovem.getUsername();
				storageService.store(file, classe, nome, data, email);
				jovem.setFoto(classe + "_" + nome + "_" + data + "_" + email + "_" + file.getOriginalFilename());
				jovemRepository.save(jovem);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso! -->> ->" + classe + "_" + nome + "_" + data + "_" + email + "_" + file.getOriginalFilename());
			}		
		} else {
			modelAndView.addObject("color", "orange");
			modelAndView.addObject("msg", "Sem Permissão!");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
    }

}
