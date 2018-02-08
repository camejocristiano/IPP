<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>

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

<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<a href="/sw/empresa/${empresa.id}">
				<h4 class="header right black-text">${gestor.nome != null ? gestor.nome : empresa.nomeFantazia}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>

		<form:form role="form" commandName="gestor" servletRelativeAction="/sw/gestor/${gestor.nome != null ? gestor.id : null}" method="POST">
<div class="row">
<div class="s12 col l2">
			<img src="../../../assets/images/usuario.png" alt="" width="175em" />
		</div><!-- // col -->
		<div class="s12 col l10">
			<div class="row">
				<div class="input-field s12 col l7">
					<form:input path='nome' type='text'/>
					<form:errors path='nome'/> 
					<label for="nome">Nome</label>
				</div><!-- // col -->
				<div class="input-field s12 col l3">
					<form:input path='telefone' type='text'/>
					<form:errors path='telefone'/> 
					<label for="telefone">Telefone</label>
				</div><!-- // col -->
				<div class="input-field s12 col l2">
					<form:input path='ramal' type='text'/>
					<form:errors path='ramal'/> 
					<label for="ramal">Ramal</label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l6">
					<form:input path='email' type='email' />
					<form:errors path='email' />
					<label for="email">Email</label>
				</div><!-- // col -->
				<div class="input-field s12 col l5">
					<form:input path='username' type='text' />
					<form:errors path='username' />
					<label for="username">Username</label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l6">
					<form:input path='password' type='password' />
					<form:errors path='password' />
					<label for="password">Senha</label>
				</div><!-- // col -->
				<div class="s12 col l6">
					<div class="row">
						<div class="s12 col l12">
							<input type="checkbox" class="filled-in" id="permitirQueVisualizeTodosOsJovens" name="permitirQueVisualizeTodosOsJovens" <c:if test="${gestor.permitirQueVisualizeTodosOsJovens == true}">checked</c:if> />
							<label for="permitirQueVisualizeTodosOsJovens">Permitir que visualize todos os Jovens</label>
						</div><!-- // col -->				
						<div class="s12 col l12">
							<input type="checkbox" class="filled-in" id="admin" name="admin" <c:if test="${gestor.admin == true}">checked</c:if> />
							<label for="admin">Admin</label>
						</div><!-- // col -->				
					</div><!-- // row -->
				</div><!-- // col -->				
			</div><!-- // row -->
		</div><!-- // col -->
	</div><!-- // row -->

			<form:input path='empresa' type='hidden' value="${empresa.id}" />
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</form:form>
<br />
<br />
	</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>
<c:import url="../../../partials/final.jsp"></c:import>