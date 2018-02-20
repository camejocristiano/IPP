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
			<h4 class="header right black-text">Cursos</h4>
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
			usuarioSessao.grupoDePermissoes.cursoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.cursoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.cursoEditar == true ||
			usuarioSessao.grupoDePermissoes.cursoListar == true			
				}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/cursos/" var="swCursos"></c:url>
				<a href="${swCursos}">
					<div class="card-content white-text">
						<span class="card-title">Cursos<i
							class="material-icons right" style="color: #eee !important;">school</i></span>
						<p>Manutenção de Curso</p>
					</div>
				</a> 
				<c:url value="/sw/curso/form" var="swCursoForm"></c:url>
				<a href="${swCursoForm}" class="btn-index">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">Novo</h6>
					</div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			usuarioSessao.grupoDePermissoes.cboCadastrar == true ||
			usuarioSessao.grupoDePermissoes.cboVisualizar == true ||
			usuarioSessao.grupoDePermissoes.cboEditar == true ||
			usuarioSessao.grupoDePermissoes.cboListar == true			
				}">
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/cbos/" var="swCbos"></c:url>
				<a href="${swCbos}">    
			    	<div class="card-content white-text">
			    		<span class="card-title">CBOS<i class="material-icons right" style="color: #eee !important;">turned_in_not</i></span>
			    		<p>Manutenção de CBOS</p>
			    	</div>
		        </a>
		        <c:url value="/sw/cbo/form" var="swCbosForm"></c:url>
				<a href="${swCbosForm}" class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">Novo</h6>
			    	</div>
				</a>
			</div>
	   	</div>
	   	</c:if>
	    <c:if test="${
			usuarioSessao.grupoDePermissoes.arcoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.arcoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.arcoEditar == true ||
			usuarioSessao.grupoDePermissoes.arcoListar == true			
				}">
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/arcos" var="swArcos"></c:url>
	      		<a href="${swArcos}">
		            <div class="card-content white-text">
		              <span class="card-title">Arcos<i class="material-icons right" style="color: #eee !important;">turned_in_not</i></span>
		              <p>Manutenção de Arcos Ocupacionais</p>
	                </div>
	            </a>
	            <c:url value="/sw/arco/form" var="swArcoForm"></c:url>
				<a href="${swArcoForm}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			usuarioSessao.grupoDePermissoes.basicoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.basicoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.basicoEditar == true ||
			usuarioSessao.grupoDePermissoes.basicoListar == true			
				}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/basicos" var="swBasicos"></c:url>
	      		<a href="${swBasicos}">
		            <div class="card-content white-text">
		              <span class="card-title">Básicos<i class="material-icons right" style="color: #eee !important;">turned_in_not</i></span>
		              <p>Manutenção de Conteúdos Teóricos</p>
	                </div>
	            </a>
	            <c:url value="/sw/basico/form" var="swBasicosForm"></c:url>
				<a href="${swBasicosForm}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
		</c:if>
		<c:if test="${
			usuarioSessao.grupoDePermissoes.especificoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.especificoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.especificoEditar == true ||
			usuarioSessao.grupoDePermissoes.especificoListar == true			
				}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/especificos" var="swEspecificos"></c:url>
	      		<a href="${swEspecificos}">
		            <div class="card-content white-text">
		              <span class="card-title">Específicos<i class="material-icons right" style="color: #eee !important;">turned_in_not</i></span>
		              <p>Manutenção de Conteúdos Teóricos</p>
	                </div>
	            </a>
	            <c:url value="/sw/especifico/form" var="swEspecificosForm"></c:url>
				<a href="${swEspecificosForm}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
		
		<c:if test="${usuarioSessao.admin == true}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/validacoes" var="swValidacoes"></c:url>
	      		<a href="${swValidacoes}">
		            <div class="card-content white-text">
		              <span class="card-title">Validações<i class="material-icons right" style="color: #eee !important;">beenhere</i></span>
		              <p>Manutenção de Validações</p>
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

		<c:if test="${usuarioSessao.admin == true && usuarioSessao.grupoDePermissoes.matriculaListar == true}">
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/matriculas" var="swMatriculas"></c:url>
	      		<a href="${swMatriculas}">
		            <div class="card-content white-text">
		              <span class="card-title">Matrículas<i class="material-icons right" style="color: #eee !important;">beenhere</i></span>
		              <p>Manutenção de Matrículas</p>
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

<c:import url="../../partials/js.jsp"></c:import>
<c:import url="../../partials/footer.jsp"></c:import>
<c:import url="../../partials/final.jsp"></c:import>