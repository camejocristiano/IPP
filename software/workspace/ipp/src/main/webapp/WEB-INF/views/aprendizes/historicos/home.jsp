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
			<c:url value="/sw/profissional/home/${historico.jovem == null ? jovem.id : historico.jovem.id}" var="swJovemJovemId"></c:url>
			<a href="${swJovemJovemId}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Jovem"}</h4>
			</a>
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
			requestScope.usuarioSessao.grupoDePermissoes.historicoCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.historicoVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.historicoEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.historicoListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/historico/form/${jovem.id}" var="swHistoricoJovemId"></c:url>
	    		<a href="${swHistoricoJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Observações<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Observações</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div><!-- / card -->
		</div><!-- / col -->
		</c:if>
		<c:if test="${profissional.id != null}">
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.ocorrenciaCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.ocorrenciaVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.ocorrenciaEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.ocorrenciaListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/ocorrencias/${jovem.id}" var="swOcorrenciasJovemId"></c:url>
	    		<a href="${swOcorrenciasJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Ocorrências<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Ocorrências</p>
	                </div>
	            </a>
				<c:url value="/sw/ocorrencia/form/${jovem.id}" var="swOcorrenciaJovemId"></c:url>
		   		<a href="${swOcorrenciaJovemId}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Nova</h6>
		            </div>
				</a>
			</div><!-- / card -->
		</div><!-- / col -->
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.pIPCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pIPVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pIPEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pIPListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/avaliacaoPIP/form/${jovem.id}" var="swAvaliacaoPIPFormJovemId"></c:url>
	    		<a href="${swAvaliacaoPIPFormJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">PIP<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Avaliação PIP</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div><!-- / card -->
		</div><!-- / col -->
		</c:if>
			<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.pITCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pITVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pITEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pITListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/avaliacaoPIT/form/${jovem.id}" var="swAvaliacaoPITFormJovemId"></c:url>
	    		<a href="${swAvaliacaoPITFormJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">PIT<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Avaliação PIT</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div><!-- / card -->
		</div><!-- / col -->
		</c:if>
			<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.pIOCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pIOVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pIOEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pIOListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/avaliacaoPIO/form/${jovem.id}" var="swAvaliacaoPIOFormJovemId"></c:url>
	    		<a href="${swAvaliacaoPIOFormJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">PIO<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Avaliação PIO</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div><!-- / card -->
		</div><!-- / col -->
		</c:if>
			<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.pAPEmpresaCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pAPEmpresaVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pAPEmpresaEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pAPEmpresaListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/avaliacaoPAPEmpresa/form/${jovem.id}" var="swAvaliacaoPAPEmpresaJovemId"></c:url>
	    		<a href="${swAvaliacaoPAPEmpresaJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">PAP Empresa<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Avaliação PAP Empresa</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div><!-- / card -->
		</div><!-- / col -->
		</c:if>
			<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.pAPIPPCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pAPIPPVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pAPIPPEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.pAPIPPListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/avaliacaoPAPIPP/form/${jovem.id}" var="swFichaProfissionalJovemJovemId"></c:url>
	    		<a href="${swFichaProfissionalJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">PAP IPP<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Avaliação PAP IPP</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div><!-- / card -->
		</div><!-- / col -->
		</c:if>
	</c:if>
		
	</div><!-- / row -->  
</div><!-- / container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>