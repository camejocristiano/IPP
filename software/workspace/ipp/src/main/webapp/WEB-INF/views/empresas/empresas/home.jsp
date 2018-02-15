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
						<h6 style="color: #eee;" class="btn-index">...</h6>
					</div>
				</a>
			</div>
		</div>
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
				<c:url value="/sw/representanteEmpresa/${empresa.id}" var="swRepresentanteEmpresaId"></c:url>
				<a href="${swRepresentanteEmpresaId}" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Novo</h6>
					</div>
				</a>
			</div>
		</div>
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
				<c:url value="/sw/gestorEmpresa/${empresa.id}" var="swGestorEmpresaId"></c:url>
				<a href="${swGestorEmpresaId}" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Novo</h6>
					</div>
				</a>
			</div>
		</div>
	
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/setores/${empresa.id}" var="swSetoresEmpresaId"></c:url>
				<a href="${swSetoresEmpresaId}">    
			    	<div class="card-content white-text">
			    		<span class="card-title">Setores<i class="material-icons right" style="color: #eee !important;">build</i></span>
			    		<p>Manutenção de Setores</p>
			    	</div>
		        </a>
		        <c:url value="/sw/setorEmpresa/${empresa.id}" var="swSetorEmpresaId"></c:url>
				<a href="${swSetorEmpresaId}" class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">Novo</h6>
			    	</div>
				</a>
			</div>
	   	</div>
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="#">
		            <div class="card-content white-text">
		              <span class="card-title">Contatos<i class="material-icons right" style="color: #eee !important;">contacts</i></span>
		              <p>Gerenciador de Contatos</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
	
	</div>  

</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>