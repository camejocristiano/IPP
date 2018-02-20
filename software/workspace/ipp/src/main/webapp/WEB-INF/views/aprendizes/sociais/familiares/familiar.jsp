<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../../partials/header.jsp"></c:import>
<c:import url="../../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<c:url value="/sw/jovem/${familiar.jovem == null ? jovem.id : familiar.jovem.id}" var="swJovemJovemId"></c:url>
			<a href="${swJovemJovemId}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Familiar"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
		<c:url value="/sw/familiar/${familiar.id != null ? familiar.id : null}" var="swFamiliarId"></c:url>
		<form:form role="form" commandName="familiar" servletRelativeAction="${swFamiliarId}" method="POST">
			<div class="row">
				<div class="input-field s12 col l4">
					<form:input path='nomeFamiliar' type='text'/>
					<form:errors path='nomeFamiliar'/> 
					<label for="nomeFamiliar">Nome</label>
				</div><!-- // col -->
				<div class="input-field s12 col l4">
					<form:input path='vinculoFamiliar' type='text'/>
					<form:errors path='vinculoFamiliar'/> 
					<label for="vinculoFamiliar">Vínculo Parentesco</label>
				</div><!-- // col -->
				<div class="input-field s12 col l4">
					<form:input path='idadeFamiliar' type='text'/>
					<form:errors path='idadeFamiliar'/> 
					<label for="idadeFamiliar">Idade</label>
				</div><!-- // col -->
			</div>
			<div class="row">
				<div class="input-field s12 col l3">
					<form:select path="estadoCivil">
						<form:option value="${estadoCivil}" label="${familiar.estadoCivil == null ? 'Estado Civil: ' : familiar.estadoCivil}" />
						<c:forEach var="estadoCivil" items="${requestScope.estadosCivis}">
							<option>${estadoCivil}</option>							
						</c:forEach>
					</form:select>
					<label for="dadosSalariais_administradoPor">Estado Civil: </label>
				</div><!-- // col -->
				<div class="input-field s12 col l3">
					<form:input path='grauInstrucaoFamiliar' type='text'/>
					<form:errors path='grauInstrucaoFamiliar'/> 
					<label for="grauInstrucaoFamiliar">Grau Instr.</label>
				</div><!-- // col -->
				<div class="input-field s12 col l3">
					<form:input path='profissaoOcupacaoFamiliar' type='text'/>
					<form:errors path='profissaoOcupacaoFamiliar'/> 
					<label for="profissaoOcupacaoFamiliar">Prof. / Ocup.</label>
				</div><!-- // col -->
				<div class="input-field s12 col l3">
					<form:input path='salarioFamiliar' type='text'/>
					<form:errors path='salarioFamiliar'/> 
					<label for="salarioFamiliar">Salário</label>
				</div><!-- // col -->
			</div><!-- // row -->
			<form:hidden path="jovem" value="${familiar.jovem != null ? familiar.jovem.id : jovem.id}" />
			
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.familiarCadastrar == true && requestScope.familiar.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.familiarEditar == true && requestScope.familiar.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

		</form:form>
		<br />
		<br />
</div><!-- // container -->
<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>