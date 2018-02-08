/*package br.net.ipp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.AgendamentoRepository;
import br.net.ipp.daos.configuracoes.ArquivoRepository;
import br.net.ipp.daos.configuracoes.CanalRepository;
import br.net.ipp.daos.configuracoes.GrupoDePermissoesRepository;
import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.financeiros.BancoRepository;
import br.net.ipp.daos.financeiros.ContaAPagarRepository;
import br.net.ipp.daos.financeiros.ContaAReceberRepository;
import br.net.ipp.daos.financeiros.DemonstrativoRepository;
import br.net.ipp.daos.financeiros.ParametroRepository;
import br.net.ipp.daos.financeiros.Salario13Repository;
import br.net.ipp.daos.financeiros.VRRepository;
import br.net.ipp.daos.financeiros.VTRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.models.financeiros.Parametro;

@Controller
public class MainController2 {

	private UnidadeRepository unidadeRepository;
	private UsuarioRepository usuarioRepository;
	private AgendamentoRepository agendamentoRepository;
	private ArquivoRepository arquivoRepository;
	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	private CanalRepository canalRepository;
	private CursoRepository cursoRepository;
	private JovemRepository jovemRepository;
	private EmpresaRepository empresaRepository;
	private BancoRepository bancoRepository;
	private ContaAPagarRepository contaAPagarRepository;
	private ContaAReceberRepository contaAReceberRepository;
	private DemonstrativoRepository demonstrativoRepository;
	private ParametroRepository parametroRepository;
	private Salario13Repository salario13Repository;
	private VRRepository vRRepository;
	private VTRepository vTRepository;
	private TurmaRepository turmaRepository;

	
	@Autowired
	public MainController2(
			UnidadeRepository unidadeRepository, 
			UsuarioRepository usuarioRepository,
			AgendamentoRepository agendamentoRepository,
			ArquivoRepository arquivoRepository,
			GrupoDePermissoesRepository grupoDePermissoesRepository,
			CanalRepository canalRepository,
			CursoRepository cursoRepository,
			TurmaRepository turmaRepository,
			JovemRepository jovemRepository,
			EmpresaRepository empresaRepository,
			BancoRepository bancoRepository,
			ContaAPagarRepository contaAPagarRepository,
			ContaAReceberRepository contaAReceberRepository,
			DemonstrativoRepository demonstrativoRepository,
			ParametroRepository parametroRepository,
			Salario13Repository salario13Repository,
			VRRepository vRRepository,
			VTRepository vTRepository
			) {
		this.usuarioRepository = usuarioRepository;
		this.unidadeRepository = unidadeRepository;
		this.agendamentoRepository = agendamentoRepository;
		this.arquivoRepository = arquivoRepository;
		this.grupoDePermissoesRepository = grupoDePermissoesRepository;
		this.canalRepository = canalRepository;
		this.cursoRepository = cursoRepository;
		this.jovemRepository = jovemRepository;
		this.empresaRepository = empresaRepository;
		this.bancoRepository = bancoRepository;
		this.contaAPagarRepository = contaAPagarRepository;
		this.contaAReceberRepository = contaAReceberRepository;
		this.demonstrativoRepository = demonstrativoRepository;
		this.parametroRepository = parametroRepository;
		this.salario13Repository = salario13Repository;
		this.vRRepository = vRRepository;
		this.vTRepository = vTRepository;
		this.turmaRepository = turmaRepository;
	}

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@PostMapping("/logar")
	public ModelAndView logar() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView login(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@GetMapping("configuracoes")
	public ModelAndView configuracoes() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/configuracoes");
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		modelAndView.addObject("unidades", unidadeRepository.findAll());
		modelAndView.addObject("arquivos", arquivoRepository.findAll());
		modelAndView.addObject("canais", canalRepository.findAll());
		modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
		modelAndView.addObject("agendamentos", agendamentoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("cursos")
	public ModelAndView cursos() {
		ModelAndView modelAndView = new ModelAndView("cursos/cursos");
		modelAndView.addObject("cursos", cursoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("aprendizes")
	public ModelAndView aprendizes() {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens");
		modelAndView.addObject("jovens", jovemRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("frequencias")
	public ModelAndView frequencias() {
		Usuario usuario = usuarioRepository.findOne((long) 1);
		ModelAndView modelAndView = new ModelAndView("frequencias/frequencias");
		modelAndView.addObject("turmas", turmaRepository.findAllByOrientadorTurma(usuario));
		return modelAndView;
	}
	
	@GetMapping("frequencias/{id}")
	public ModelAndView frequenciasOrientador(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("frequencias/pitsepips/turmas");
		Usuario usuario = usuarioRepository.findOne(id);
		List<Turma> turmas = turmaRepository.findAllByOrientadorTurma(usuario);
		modelAndView.addObject("turmas", turmas);
		return modelAndView;
	}
	
	@GetMapping("empresas")
	public ModelAndView empresas() {
		ModelAndView modelAndView = new ModelAndView("empresas/empresas");
		modelAndView.addObject("empresas", empresaRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("financeiros")
	public ModelAndView financeiros(Parametro parametro) {
		ModelAndView modelAndView = new ModelAndView("financeiros/financeiros");
		modelAndView.addObject("bancos", bancoRepository.findAll());
		modelAndView.addObject("contasAPagar", contaAPagarRepository.findAll());
		modelAndView.addObject("contasAReceber", contaAReceberRepository.findAll());
		modelAndView.addObject("demonstrativos", demonstrativoRepository.findAll());
		modelAndView.addObject("parametros", parametroRepository.findAll());
		modelAndView.addObject("salarios13", salario13Repository.findAll());
		modelAndView.addObject("vrs", vRRepository.findAll());
		modelAndView.addObject("vts", vTRepository.findAll());
		modelAndView.addObject("parametro", parametro);
		return modelAndView;
	}
	
}
*/