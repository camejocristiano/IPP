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
			<c:url value="/sw/empresa/${empresa.id}" var="swEmpresaId"></c:url>
			<a href="${swEmpresaId}">
				<h4 class="header right black-text">${empresa.nomeFantazia != null ? empresa.nomeFantazia : "Empresa"}</h4>
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
			requestScope.usuarioSessao.grupoDePermissoes.empresaCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.empresaVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.empresaEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.empresaListar == true		
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/loadEmpresa/${empresa.id}" var="swLoadEmpresaId"></c:url>
				<a href="${swLoadEmpresaId}">
					<div class="card-content white-text">
						<span class="card-title">Dados Cadastrais<i
							class="material-icons right" style="color: #eee !important;">dvr</i></span>
						<p>Manutenção dos Dados da Empresa</p>
					</div>
				</a> 
				<a class="btn-index">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">Nova</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.representanteLegalCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.representanteLegalVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.representanteLegalEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.representanteLegalListar == true		
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/representantes/${empresa.id}" var="swRepresentantesEmpresaId"></c:url>
				<a href="${swRepresentantesEmpresaId}">
					<div class="card-content white-text">
						<span class="card-title">Representantes<i
							class="material-icons right" style="color: #eee !important;">people_outline</i></span>
						<p>Manutenção de Representantes Legais</p>
					</div>
				</a> 
				<c:url value="/sw/representante/form/${empresa.id}" var="swRepresentanteEmpresaId"></c:url>
				<a href="${swRepresentanteEmpresaId}" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Novo</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.gestorCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.gestorVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.gestorEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.gestorListar == true		
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/gestores/${empresa.id}" var="swGestoresEmpresaId"></c:url>
				<a href="${swGestoresEmpresaId}">
					<div class="card-content white-text">
						<span class="card-title">Gestores<i
							class="material-icons right" style="color: #eee !important;">people_outline</i></span>
						<p>Manutenção de Gestores</p>
					</div>
				</a> 
				<c:url value="/sw/gestor/form/${empresa.id}" var="swGestorEmpresaId"></c:url>
				<a href="${swGestorEmpresaId}" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Novo</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.setorCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.setorVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.setorEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.setorListar == true		
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/setores/empresa/${empresa.id}" var="swSetoresEmpresaId"></c:url>
				<a href="${swSetoresEmpresaId}">    
			    	<div class="card-content white-text">
			    		<span class="card-title">Setores<i class="material-icons right" style="color: #eee !important;">build</i></span>
			    		<p>Manutenção de Setores</p>
			    	</div>
		        </a>
		        <c:url value="/sw/setor/form/${empresa.id}" var="swSetorEmpresaId"></c:url>
				<a href="${swSetorEmpresaId}" class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">Novo</h6>
			    	</div>
				</a>
			</div>
	   	</div>
	    </c:if>
	    <c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.contatoCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.contatoVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.contatoEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.contatoListar == true		
		}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<c:url value="/sw/contatos/empresa/${empresa.id}" var="swContatosEmpresaId"></c:url>
				<a href="${swContatosEmpresaId}">
				    <div class="card-content white-text">
		              <span class="card-title">Contatos<i class="material-icons right" style="color: #eee !important;">contacts</i></span>
		              <p>Gerenciador de Contatos</p>
	                </div>
	            </a>
				<c:url value="/sw/contato/form/${empresa.id}" var="swContatoEmpresaId"></c:url>
				<a class="btn-index" href="${swContatoEmpresaId}">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.cargaHorariaCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.cargaHorariaVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.cargaHorariaEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.cargaHorariaListar == true		
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/cargas/empresa/${empresa.id}" var="swTaxasEmpresaId"></c:url>
				<a href="${swTaxasEmpresaId}">
					<div class="card-content white-text">
						<span class="card-title">Cargas Horárias<i
							class="material-icons right" style="color: #eee !important;">dvr</i></span>
						<p>Manutenção das Cargas Horárias</p>
					</div>
				</a> 
				<c:url value="/sw/carga/form/${empresa.id}" var="swTaxaEmpresaId"></c:url>
				<a class="btn-index" href="${swTaxaEmpresaId}">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">Nova</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.taxaCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.taxaVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.taxaEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.taxaListar == true		
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/taxas/empresa/${empresa.id}" var="swTaxasEmpresaId"></c:url>
				<a href="${swTaxasEmpresaId}">
					<div class="card-content white-text">
						<span class="card-title">Taxas<i
							class="material-icons right" style="color: #eee !important;">dvr</i></span>
						<p>Manutenção das Taxas</p>
					</div>
				</a> 
				<c:url value="/sw/taxa/form/${empresa.id}" var="swTaxaEmpresaId"></c:url>
				<a class="btn-index" href="${swTaxaEmpresaId}">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">Nova</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			requestScope.usuarioSessao.grupoDePermissoes.historicosCadastrar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.historicosVisualizar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.historicosEditar == true ||
			requestScope.usuarioSessao.grupoDePermissoes.historicosListar == true		
		}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/historicos/empresa/${empresa.id}" var="swHistoricosEmpresaId"></c:url>
				<a href="${swHistoricosEmpresaId}">
					<div class="card-content white-text">
						<span class="card-title">Históricos<i
							class="material-icons right" style="color: #eee !important;">dvr</i></span>
						<p>Manutenção dos Históricos</p>
					</div>
				</a> 
				<c:url value="/sw/historico/empresa/form/${empresa.id}" var="swHistoricoEmpresaId"></c:url>
				<a class="btn-index" href="${swHistoricoEmpresaId}">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">Nova</h6>
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