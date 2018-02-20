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
			<h4 class="header right black-text">Canal</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>

<c:url value="/sw/canal/${canal.nomeCanal != null ? canal.id : null}" var="swCanalId"></c:url>
<form:form role="form" commandName="canal" servletRelativeAction="${swCanalId}" method="POST">
	<div class="row">
		<div class="input-field s12 col l12">
			<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='nomeCanal' type='text' required="required" />
					<form:errors path='nomeCanal'/> 
					<label for="nomeCanal">Nome do Canal</label>
				</div>

			</div>
		</div>
	</div>

			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.canalCadastrar == true && requestScope.canal.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.canalEditar == true && requestScope.canal.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

</form:form>

</div>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>