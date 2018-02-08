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
			<h4 class="header right black-text">${curso.nomeDoCurso != null ? curso.nomeDoCurso : "Curso"}</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	
	<div class="row">
	
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="/sw/curso/${curso.id}">
					<div class="card-content white-text">
						<span class="card-title">Dados do Curso<i
							class="material-icons right" style="color: #eee !important;">school</i></span>
						<p>Manutenção dos Dados da Curso</p>
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
				<a href="/sw/matriculas/${curso.id}">
					<div class="card-content white-text">
						<span class="card-title">Matrículas<i
							class="material-icons right" style="color: #eee !important;">bookmark_border</i></span>
						<p>Manutenção das Matrículas</p>
					</div>
				</a> 
				<a href="/sw/novaMatricula/${curso.id}" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Nova</h6>
					</div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="/sw/turmas/${curso.id}">
					<div class="card-content white-text">
						<span class="card-title">Turmas<i
							class="material-icons right" style="color: #eee !important;">group</i></span>
						<p>Manutenção de Turmas</p>
					</div>
				</a> 
				<a href="/sw/turmaForm/${curso.id}" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Nova</h6>
					</div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="/sw/validacoesCurso/${curso.id}">
		            <div class="card-content white-text">
		              <span class="card-title">Validações<i class="material-icons right" style="color: #eee !important;">beenhere</i></span>
		              <p>Manutenção de Validações</p>
	                </div>
	            </a>
				<a href="/sw/validacaoCurso/${curso.id}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
	
	</div>  
	
</div>
</div>
</div>

<c:import url="../../partials/js.jsp"></c:import>
<c:import url="../../partials/footer.jsp"></c:import>
<c:import url="../../partials/final.jsp"></c:import>