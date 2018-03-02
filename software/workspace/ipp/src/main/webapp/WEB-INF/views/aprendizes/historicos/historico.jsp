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
			<a href="/sw/historicos/home/${jovem.id}">
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
		<c:url value="/sw/historico/${historico.jovem != null ? historico.id : null}" var="swHistoricoId"></c:url>
		<form:form role="form" commandName="historico" servletRelativeAction="${swHistoricoId}" method="POST"
			class="col s12">
			<div class="row">
				<div class="input-field s12 col l12">
					<form:textarea path='observacoes' />
					<form:errors path='observacoes'/> 
					<label for="observacoes">Observações</label>
					<form:hidden path="jovem" value="${jovem.id}" />
				</div>
			</div>
			<br />
		<br />
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.pAPEmpresaCadastrar == true && requestScope.avaliacaoPAPEmpresa.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.pAPEmpresaCadastrar == true && requestScope.avaliacaoPAPEmpresa.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
		<br />
		<br />	
		</form:form>
		<br />
		<br />
</div><!-- // Container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>