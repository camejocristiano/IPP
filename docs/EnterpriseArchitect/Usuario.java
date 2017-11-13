package Configuracoes;
import Cursos.Turma_Usuario;
import Aprendizes.SituacaoDeSaude;
import Empresas.Empresa;

/**
 * @author Cristiano
 * @version 1.0
 * @created 13-nov-2017 07:04:32
 */
public class Usuario extends Turma_Usuario {

	private string bairro;
	private string cargo;
	private string celular;
	private string cEP;
	private string cidade;
	private string cNPJMEI;
	private string complemento;
	private int cPF;
	/**
	 * Campo TEXT LONG
	 */
	private text curriculoResumido;
	private Date dataDeAdmissao;
	private Date DataDeDesligamento;
	private string dataDeExpedicao;
	private Date dataDeNascimento;
	private Date dataExpedicaoCTPS;
	private string disciplina;
	private string email;
	private string endereco;
	private string estado;
	private EstadoCivil estadoCivil;
	private string formacao;
	private string habilitacao;
	private string nome;
	private string numero;
	private string numeroCTPS;
	private text observacoes;
	private string orgaoEmissor;
	private long permissoes_id;
	private Regiao regiao;
	private RelacaoFuncional relacaoFuncional;
	private string rG;
	private string serieCTPS;
	private Sexo sexo;
	private Status status;
	private string telefone;
	private string uFCTPS;
	private long usuario_id;
	public SituacaoDeSaude m_SituacaoDeSaude;
	public Empresa m_Empresa;

	public Usuario(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param usuario
	 */
	public void cadastrarUsuario(Usuario usuario){

	}

	/**
	 * 
	 * @param usuario
	 * @param usuario_id
	 */
	public void editarUsuario(Usuario usuario, long usuario_id){

	}

	public List<Usuario> listarUsuarios(){
		return null;
	}

	/**
	 * 
	 * @param usuario_id
	 */
	public Usuario visualizarUsuario(long usuario_id){
		return null;
	}

}