<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
<hr />
<hr />
<h6>CONTATO</h6>
	<div class="row">
		
		<form:form role="form" commandName="contato" servletRelativeAction="/contatos/${contato.id}" method="POST"
			class="col s12">
 
 <div class="row">
				<div class="input-field s12 col l12">
					<form:input path='username' type='email'/>
					<form:errors path='username'/> 
					<label for="username">username</label>
				</div>
			</div>
 
    <div class="row">
				<div class="s12 col l12">
					<input type="checkbox" name="admin" class="filled-in" id="admin" <c:if test="${contato.admin == true}">checked</c:if> />
					<label for="admin"></label>
				</div>
			</div>
    
    <div class="row">
				<div class="input-field s12 col l12">
					<form:input path='password' type='password'/>
					<form:errors path='password'/> 
					<label for="password">password</label>
				</div>
			</div>
    
    <hr />
    <hr />
    
			<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='nome' type='text'/>
					<form:errors path='nome'/> 
					<label for="nome">nome</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='departamento' type='text'/>
					<form:errors path='departamento'/> 
					<label for="departamento">departamento</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='cargo' type='text'/>
					<form:errors path='cargo'/> 
					<label for="cargo">cargo</label>
				</div>
			</div>
						<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='observacoes' type='text'/>
					<form:errors path='observacoes'/> 
					<label for="observacoes">observacoes</label>
				</div>
			</div>
						<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='telefone' type='text'/>
					<form:errors path='telefone'/> 
					<label for="telefone">telefone</label>
				</div>
			</div>
						<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='tipoDeContato' type='text'/>
					<form:errors path='tipoDeContato'/> 
					<label for="tipoDeContato">tipoDeContato</label>
				</div>
			</div>
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</form:form>
	</div>

</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>
<c:import url="../../../partials/final.jsp"></c:import>