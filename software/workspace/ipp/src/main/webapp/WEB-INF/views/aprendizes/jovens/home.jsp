<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<div class="row">
		<div class="col s12 l12">
			<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Jovem"}</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>

	<div class="row">
	
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.jovemCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.jovemVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.jovemEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.jovemListar == true		
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/jovemForm/${jovem.id}" var="swJovemFormJovemId"></c:url>
				<a href="${swJovemFormJovemId}">
					<div class="card-content white-text">
						<span class="card-title">Dados Cadastrais<i
							class="material-icons right" style="color: #eee !important;">dvr</i></span>
						<p>Manutenção dos Dados do Jovem</p>
					</div>
				</a> 
				<a class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">...</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.matriculaCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.matriculaVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.matriculaEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.matriculaListar == true		
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/matriculasJovem/${jovem.id}" var="swMatriculasJovemJovemId"></c:url>
				<a href="${swMatriculasJovemJovemId}">
					<div class="card-content white-text">
						<span class="card-title">Cursos<i
							class="material-icons right" style="color: #eee !important;">school</i></span>
						<p>Cursos pelo IPP</p>
					</div>
				</a> 
				<a class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">...</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.escolaridadeCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.escolaridadeVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.escolaridadeEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.escolaridadeListar == true	
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/escolaridadeJovem/${jovem.id}" var="swEscolaridadeJovemJovemId"></c:url>
				<a href="${swEscolaridadeJovemJovemId}">
					<div class="card-content white-text">
						<span class="card-title">Escolaridade<i
							class="material-icons right" style="color: #eee !important;">book</i></span>
						<p>Manutenção de Escolaridades</p>
					</div>
				</a> 
				<a class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">...</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.situacaoLaboralCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.situacaoLaboralVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.situacaoLaboralEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.situacaoLaboralListar == true			
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/situacaoLaboralJovem/${jovem.id}" var="swSituacaoLaboralJovemJovemId"></c:url>
				<a href="${swSituacaoLaboralJovemJovemId}">    
			    	<div class="card-content white-text">
			    		<span class="card-title">Laboral<i class="material-icons right" style="color: #eee !important;">format_list_bulleted</i></span>
			    		<p>Manutenção de Situação Laboral</p>
			    	</div>
		        </a>
				<a class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">...</h6>
			    	</div>
				</a>
			</div>
	   	</div>
	   	</c:if>
	   	<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.jaFoiAprendizCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.jaFoiAprendizVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.jaFoiAprendizEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.jaFoiAprendizListar == true			
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/jaFoiAprendiz/${jovem.id}" var="swJaFoiAprendizJovemId"></c:url>
				<a href="${swJaFoiAprendizJovemId}">    
			    	<div class="card-content white-text">
			    		<span class="card-title">Já Foi Aprendiz<i class="material-icons right" style="color: #eee !important;">format_list_bulleted</i></span>
			    		<p>Manutenção de Já Foi Aprendiz</p>
			    	</div>
		        </a>
				<c:url value="/sw/aprendizes/form/${jovem.id}" var="swAprendizesFormJovemId"></c:url>
				<a href="${swAprendizesFormJovemId}" class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">Novo</h6>
			    	</div>
				</a>
			</div>
	   	</div>
	   	</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.caracteristicasDomiciliaresCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.caracteristicasDomiciliaresVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.caracteristicasDomiciliaresEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.caracteristicasDomiciliaresListar == true		
		}">
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/caracteristicaDomiciliarJovem/${jovem.id}" var="swCaracteristicaDomiciliarJovemJovemId"></c:url>
	      		<a href="${swCaracteristicaDomiciliarJovemJovemId}">
		            <div class="card-content white-text">
		              <span class="card-title">Domiciliares<i class="material-icons right" style="color: #eee !important;">home</i></span>
		              <p>Manutenção de Caract. Dom.</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.habilidadesCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.habilidadesVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.habilidadesEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.habilidadesListar == true		
		}">
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/habilidadeJovem/${jovem.id}" var="swHabilidadeJovemJovemId"></c:url>
	    		<a href="${swHabilidadeJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Habilidades<i class="material-icons right" style="color: #eee !important;">thumbs_up_down</i></span>
		              <p>Manutenção de Habilidades</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.outroCursoCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.outroCursoVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.outroCursoEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.outroCursoListar == true		
		}">
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/outrosCursos/${jovem.id}" var="swOutrosCursosJovemId"></c:url>
	    		<a href="${swOutrosCursosJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Outros Cursos<i class="material-icons right" style="color: #eee !important;">thumbs_up_down</i></span>
		              <p>Manutenção de Outros Cursos</p>
	                </div>
	            </a>
				<c:url value="/sw/outroCursoForm/${jovem.id}" var="swOutroCursoFormJovemId"></c:url>
		   		<a href="${swOutroCursoFormJovemId}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.situacaoDeSaudeCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.situacaoDeSaudeVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.situacaoDeSaudeEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.situacaoDeSaudeListar == true			
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/situacaoDeSaudeJovem/${jovem.id}" var="swSituacaoDeSaudeJovemJovemId"></c:url>
	    		<a href="${swSituacaoDeSaudeJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Saúde<i class="material-icons right" style="color: #eee !important;">healing</i></span>
		              <p>Situação de Saúde</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.fichaSocialCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.fichaSocialVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.fichaSocialEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.fichaSocialListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/fichaSocialJovem/${jovem.id}" var="swFichaSocialJovemJovemId"></c:url>
	    		<a href="${swFichaSocialJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Social<i class="material-icons right" style="color: #eee !important;">thumb_up</i></span>
		              <p>Manutenção de Ficha Social</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.familiarCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.familiarVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.familiarEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.familiarListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/familiares/${jovem.id}" var="swFamiliaresJovemId"></c:url>
	    		<a href="${swFamiliaresJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Familiares<i class="material-icons right" style="color: #eee !important;">thumb_up</i></span>
		              <p>Manutenção de Familiares</p>
	                </div>
	            </a>
				<c:url value="/sw/familiar/form/${jovem.id}" var="swFamiliaresJovemId"></c:url>
		   		<a href="${swFamiliaresJovemId}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.fichaProfissionalCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.fichaProfissionalVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.fichaProfissionalEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.fichaProfissionalListar == true	
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/profissional/home/${jovem.id}" var="swFichaProfissionalJovemJovemId"></c:url>
	    		<a href="${swFichaProfissionalJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Profissional<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Ficha Profissional</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.dadosFinanceirosCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.dadosFinanceirosVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.dadosFinanceirosEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.dadosFinanceirosListar == true	
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/dadosFinanceirosJovem/${jovem.id}" var="swDadosFinanceirosJovemJovemId"></c:url>
	    		<a href="${swDadosFinanceirosJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Financeiros<i class="material-icons right" style="color: #eee !important;">attach_money</i></span>
		              <p>Manutenção de Dados Finaceiros</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
	
	</div>  

</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>