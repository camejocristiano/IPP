<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../partials/header.jsp"></c:import>
<c:import url="../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<div class="row">
		<div class="col s12 l12">
		
			<h4 class="header right black-text">Configurações</h4>
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
			usuarioSessao.grupoDePermissoes.usuarioCadastrar == true ||
			usuarioSessao.grupoDePermissoes.usuarioVisualizar == true ||
			usuarioSessao.grupoDePermissoes.usuarioEditar == true ||
			usuarioSessao.grupoDePermissoes.usuarioListar == true			
				}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/usuarios/" var="swUsuarios"></c:url>
				<a href="${swUsuarios}">
					<div class="card-content white-text">
						<span class="card-title">Usuários<i
							class="material-icons right" style="color: #eee !important;">people_outline</i></span>
						<p>Manutenção de Usuários</p>
					</div>
				</a> 
				<c:url value="/sw/usuario/form" var="swUsuariosForm"></c:url>
				<a href="${swUsuariosForm}" class="btn-index">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">Novo</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			
			usuarioSessao.grupoDePermissoes.grupoDePermissoesCadastrar == true ||
			usuarioSessao.grupoDePermissoes.grupoDePermissoesVisualizar == true ||
			usuarioSessao.grupoDePermissoes.grupoDePermissoesEditar == true ||
			usuarioSessao.grupoDePermissoes.grupoDePermissoesListar == true	
				}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/gruposDePermissoes/" var="swGruposDePermissoes"></c:url>
				<a href="${swGruposDePermissoes}">
					<div class="card-content white-text">
						<span class="card-title">Permissões<i
							class="material-icons right" style="color: #eee !important;">lock_outline</i></span>
						<p>Manutenção de Permissões</p>
					</div>
				</a> 
				<c:url value="/sw/grupoDePermissoes/form" var="swGruposDePermissoesForm"></c:url>
				<a href="${swGruposDePermissoesForm}" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Novo</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			usuarioSessao.grupoDePermissoes.unidadeCadastrar == true ||
			usuarioSessao.grupoDePermissoes.unidadeVisualizar == true ||
			usuarioSessao.grupoDePermissoes.unidadeEditar == true ||
			usuarioSessao.grupoDePermissoes.unidadeListar == true	
				}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/unidades/" var="swUnidades"></c:url>
				<a href="${swUnidades}">
					<div class="card-content white-text">
						<span class="card-title">Unidades<i
							class="material-icons right" style="color: #eee !important;">business</i></span>
						<p>Manutenção de Unidades</p>
					</div>
				</a> 
				<c:url value="/sw/unidade/form" var="swUnidadesForm"></c:url>
				<a href="${swUnidadesForm}" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Novo</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>	

		<c:if test="${
			usuarioSessao.grupoDePermissoes.canalCadastrar == true ||
			usuarioSessao.grupoDePermissoes.canalVisualizar == true ||
			usuarioSessao.grupoDePermissoes.canalEditar == true ||
			usuarioSessao.grupoDePermissoes.canalListar == true
				}">		
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/canais/" var="swCanais"></c:url>
				<a href="${swCanais}">    
			    	<div class="card-content white-text">
			    		<span class="card-title">Canais<i class="material-icons right" style="color: #eee !important;">language</i></span>
			    		<p>Manutenção de Canais</p>
			    	</div>
		        </a>
				<c:url value="/sw/canal/form" var="swCanaisForm"></c:url>
				<a href="${swCanaisForm}" class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">Novo</h6>
			    	</div>
				</a>
			</div>
	   	</div>
</c:if>
<c:if test="${
			usuarioSessao.grupoDePermissoes.arquivoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.arquivoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.arquivoEditar == true ||
			usuarioSessao.grupoDePermissoes.arquivoListar == true
				}">
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<c:url value="/sw/arquivos/" var="swArquivos"></c:url>
				<a href="${swArquivos}">
		            <div class="card-content white-text">
		              <span class="card-title">Arquivos<i class="material-icons right" style="color: #eee !important;">attach_file</i></span>
		              <p>Gerenciador de Arquivos</p>
	                </div>
	            </a>
				<c:url value="/sw/arquivos/form" var="swArquivosForm"></c:url>
				<a href="${swArquivosForm}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
</c:if>
<c:if test="${
			usuarioSessao.grupoDePermissoes.agendamentoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.agendamentoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.agendamentoEditar == true ||
			usuarioSessao.grupoDePermissoes.agendamentoListar == true			
				}">
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/agendamentos/" var="swAgendamentos"></c:url>
				<a href="${swAgendamentos}">
		   			<div class="card-content white-text">
		              <span class="card-title">Agenda<i class="material-icons right" style="color: #eee !important;">event_note</i></span>
		              <p>Manutenção de Agendamentos</p>
	                </div>
	            </a>
				<c:url value="/sw/agendamentos/form" var="swAgendamentosForm"></c:url>
				<a href="${swAgendamentosForm}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
</c:if>	
	</div>  

</div>

<c:import url="../../partials/js.jsp"></c:import>

<c:import url="../../partials/footer.jsp"></c:import>