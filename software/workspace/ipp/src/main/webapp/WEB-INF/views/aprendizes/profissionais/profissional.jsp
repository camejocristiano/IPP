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
			<a href="/sw/fichaProfissional/home/${fichaProfissional.jovem != null ? fichaProfissional.jovem.id : jovem.id}">
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
		<c:url value="/sw/fichaProfissional/${fichaProfissional.id != null ? fichaProfissional.id : null}" var="swFichaProfissionalId"></c:url>
		<form:form role="form" commandName="fichaProfissional" servletRelativeAction="${swFichaProfissionalId}" method="POST">
			<div class="row">
				<div class="input-field s12 col l6">
					<form:select path="situacaoAtual">
					    <form:option value="${fichaProfissional.situacaoAtual}" label="${fichaProfissional.situacaoAtual == null ? 'Situação Atual: ' : fichaProfissional.situacaoAtual}" />
						<c:forEach var="situacaoAtual" items="${requestScope.situacoesAtuais}">
							<option>${situacaoAtual}</option>							
						</c:forEach>
					</form:select>
					<label for="situacaoAtual">Situação Atual: </label>
				</div>
				<div class="input-field s12 col l6">
					<form:select path="status">
                		<form:option value="${fichaProfissional.status}" label="${fichaProfissional.status == null ? 'Status' : fichaProfissional.status}" />
						<c:forEach var="status" items="${requestScope.status}">
							<option>${status}</option>							
						</c:forEach>
					</form:select>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12">
					<form:textarea path="observacoesSituacaoProfissional" />
					<form:errors path="observacoesSituacaoProfissional"></form:errors>
					<form:label path="observacoesSituacaoProfissional">Observações:</form:label>
				</div><!-- // col -->
			</div><!-- // row -->

			<form:hidden path="jovem" value="${fichaProfissional.jovem == null ? jovem.id : fichaProfissional.jovem.id}" />

			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.fichaProfissionalCadastrar == true && requestScope.fichaProfissional.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.fichaProfissionalEditar == true && requestScope.fichaProfissional.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

		</form:form>
	<br />
	<br />
</div><!-- // container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>