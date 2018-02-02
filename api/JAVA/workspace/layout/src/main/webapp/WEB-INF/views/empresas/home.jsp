<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../partials/header.jsp"></c:import>

<style>
/*
 CSS INDEXES
*/
.btn-index:hover {
	background-color: #669999;
	font-weight: bolder;
	font-style: italic;
}
.card-content:hover {
	font-weight: bolder;
	background-color: #669999;
	font-style: italic;
}
</style>

<c:import url="../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<h4 class="header right black-text">Tom Jobim S/A</h4>
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
				<a href="#">
					<div class="card-content white-text">
						<span class="card-title">Dados Cadastrais<i
							class="material-icons right" style="color: #eee !important;">dvr</i></span>
						<p>Manutenção dos Dados da Empresa</p>
					</div>
				</a> 
				<a href="#" class="btn-index">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">Cadastrar</h6>
					</div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="#">
					<div class="card-content white-text">
						<span class="card-title">Representantes<i
							class="material-icons right" style="color: #eee !important;">person_outline</i></span>
						<p>Manutenção de Representantes Legais</p>
					</div>
				</a> 
				<a href="#" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Cadastrar</h6>
					</div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="#">
					<div class="card-content white-text">
						<span class="card-title">Gestores<i
							class="material-icons right" style="color: #eee !important;">people_outline</i></span>
						<p>Manutenção de Gestores</p>
					</div>
				</a> 
				<a href="#" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Cadastrar</h6>
					</div>
				</a>
			</div>
		</div>
	
	</div>
	<div class="row">
		
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="#">    
			    	<div class="card-content white-text">
			    		<span class="card-title">Setores<i class="material-icons right" style="color: #eee !important;">build</i></span>
			    		<p>Manutenção de Setores</p>
			    	</div>
		        </a>
				<a href="#" class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">Cadastrar</h6>
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
		              <h6 style="color: #eee !important;">Cadastrar</h6>
		            </div>
				</a>
			</div>
		</div>
	
	</div>  

</div>

<c:import url="../../partials/js.jsp"></c:import>
<c:import url="../../partials/footer.jsp"></c:import>
<c:import url="../../partials/final.jsp"></c:import>