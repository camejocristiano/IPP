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
		<div class="input-field  s12 col l12" style="border-top: 2px solid orange;">
			 <h4 class="header right orange-text">Ficha Profissional: <a class="header right" href="/jovens/${fichaProfissional.jovem != null ? fichaProfissional.jovem.id : jovem.id}">${fichaProfissional.jovem != null ? fichaProfissional.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
	
	<div class="row">
		<form:form role="form" commandName="fichaProfissional" servletRelativeAction="/fichasProfissionais/${fichaProfissional.id}" method="POST"
			class="col s12">
			<div class="row">
				<div class="input-field s12 col l6">
					<form:hidden path="jovem" value="${jovem.id}" />
					<form:select path="situacaoAtual">
					    <form:option value="${situacaoAtual}" label="${fichaProfissional.situacaoAtual == null ? 'Situação Atual: ' : fichaProfissional.situacaoAtual}" />
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
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</form:form>
	</div>

</div>

<c:import url="../../../partials/js.jsp"></c:import>
<script type="text/javascript">
$(document).ready(function() {
	$('select').material_select();
});
</script>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>