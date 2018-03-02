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
			<c:url value="/sw/jovem/${fichaProfissional.jovem == null ? jovem.id : fichaProfissional.jovem.id}" var="swJovemJovemId"></c:url>
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
			requestScope.usuarioSessao.grupoDePermissoes.fichaProfissionalCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.fichaProfissionalVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.fichaProfissionalEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.fichaProfissionalListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:if test="${profissional.id == null}">
	    			<c:url value="/sw/profissional/form/${jovem.id}" var="swFichaProfissionalJovemJovemId"></c:url>
	    		</c:if>
	    		<c:if test="${profissional.id != null}">
	    			<c:url value="/sw/profissional/${profissional.id}" var="swFichaProfissionalJovemJovemId"></c:url>
	    		</c:if>
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
		<c:if test="${profissional.id != null}">
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.entrevistaCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.entrevistaVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.entrevistaEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.entrevistaListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/entrevistasJovem/${jovem.id}" var="swEntrevistasJovemJovemId"></c:url>
	    		<a href="${swEntrevistasJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Entrevistas<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Entrevistas</p>
	                </div>
	            </a>
	            <c:url value="/sw/entrevistaJovem/${jovem.id}" var="swEntrevistaJovemJovemId"></c:url>
				<a href="${swEntrevistaJovemJovemId}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Nova</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.contratacaoCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.contratacaoVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.contratacaoEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.contratacaoListar == true 
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/contratacoes/profissional/${profissional.id}" var="swContratacoesJovemJovemId"></c:url>
	    		<a href="${swContratacoesJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Contratações<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Contratações</p>
	                </div>
	            </a>
	            <c:url value="/sw/contratacao/profissional/${jovem.id}" var="swContratacaoJovemJovemId"></c:url>
				<a href="${swContratacaoJovemJovemId}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Nova</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.feriasCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.feriasVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.feriasEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.feriasListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/feriassJovem/${jovem.id}" var="swFeriassJovemJovemId"></c:url>
	    		<a href="${swFeriassJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Férias<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Férias</p>
	                </div>
	            </a>
	            <c:url value="/sw/feriasJovem/${jovem.id}" var="swFeriasJovemJovemId"></c:url>
				<a href="${swFeriasJovemJovemId}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Nova</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.dispensaCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.dispensaVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.dispensaEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.dispensaListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/dispensasJovem/${jovem.id}" var="swDispensasJovemJovemId"></c:url>
	    		<a href="${swDispensasJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Dispensas<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Dispensas</p>
	                </div>
	            </a>
	            <c:url value="/sw/dispensaJovem/${jovem.id}" var="swDispensaJovemJovemId"></c:url>
				<a href="${swDispensaJovemJovemId}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Nova</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.historicoCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.historicoVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.historicoEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.historicoListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/historicos/home/${jovem.id}" var="swHistoricosHomeJovemId"></c:url>
	    		<a href="${swHistoricosHomeJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Históricos<i class="material-icons right" style="color: #eee !important;">reply_all</i></span>
		              <p>Manutenção de Históricos</p>
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
		</c:if>
	
	</div>  

</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>