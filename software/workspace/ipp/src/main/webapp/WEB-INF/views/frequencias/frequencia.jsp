<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../partials/header.jsp"></c:import>
<c:import url="../../partials/navbar.jsp"></c:import>


<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<c:url value="/sw/frequencias/jovem/mes/${frequencia.matricula.id}" var="swFrequenciasMesJovemId"></c:url>
			<a href="${swFrequenciasMesJovemId}">
				<h4 class="header right black-text">${frequencia.matricula.jovem.nome != null ? frequencia.matricula.jovem.nome : 'Jovem'}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
		<c:url value="/sw/frequencia/${frequencia.id != null ? frequencia.id : null}" var="swFrequenciaId"></c:url>
		<form:form role="form" commandName="frequencia" servletRelativeAction="${swFrequenciaId}" method="POST">
			<div class="row">
				<div class="input-field col s4">
					<h6>JOVEM: ${requestScope.frequencia.matricula.jovem.nome}</h6>
				</div>
				<div class="input-field col s4">
					<h6>TURMA: ${requestScope.frequencia.matricula.turma.numeroTurma}</h6>
				</div>
				<div class="input-field col s4">
					<form:input path="matricula" />
					<form:errors path="matricula"></form:errors>
					<form:label path="matricula">Matrícula</form:label>				
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 l3">
					<div class="row">
						<div class="input-field col s3">
							<form:input path="dia" />
							<form:errors path="dia"></form:errors>
							<form:label path="dia">Dia</form:label>
						</div>
						<div class="input-field col s3">
							<form:input path="mes" />
							<form:errors path="mes"></form:errors>
							<form:label path="mes">Mês</form:label>
						</div>
						<div class="input-field col s6">
							<form:input path="ano" />
							<form:errors path="ano"></form:errors>
							<form:label path="ano">Ano</form:label>
						</div>
					</div>
				</div>
				<div class="input-field col s12 l3">
					<div class="row">
						<div class="input-field col s12">
							<form:select path="tipoDeInsercao">
								<form:option value="IPP">IPP</form:option>
								<form:option value="EMPRESA">EMPRESA</form:option>							
							</form:select>
						</div>
					</div>
				</div>
				<div class="input-field col s12 l3">
					<div class="row">
						<div class="input-field col s12">
							<form:select path="diaDaSemana">
								<form:option value="${diaDaSemana.dia}" label="${diaDaSemana.dia == null ? 'Dia da Semana: ' : diaDaSemana.dia}" />
								<c:forEach var="dia" items="${dias}">
									<form:option value="${dia}">${dia}</form:option>
								</c:forEach>							
							</form:select>
						</div>
					</div>
				</div>
				<div class="input-field col s12 l3">
					<div class="row">
						<div class="input-field col s12">
							<form:select path="comparecido">
								<form:option value="1">Presente</form:option>
								<form:option value="0">Ausente</form:option>							
							</form:select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12 l3">
					<input type="checkbox" name="justificativa" class="filled-in" id="justificativa" <c:if test="${frequencia.justificativa == true}">checked</c:if> />
					<label for="justificativa">Falta Justificada</label>
				</div>
				<div class="input-field col s12 l9">
					<form:textarea path="observacao" />
					<form:errors path="observacao"></form:errors>
					<form:label path="observacao">Observação</form:label>
				</div>
			</div>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.frequenciaEditar == true && requestScope.frequencia.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
		</form:form>
		<br />
		<br />
</div><!-- // container -->
<c:import url="../../partials/js.jsp"></c:import>
<c:import url="../../partials/footer.jsp"></c:import>
<c:import url="../../partials/final.jsp"></c:import>