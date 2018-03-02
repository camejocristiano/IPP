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
		<c:url value="/sw/avaliacaoPIT/${avaliacaoPIT.historico != null ? avaliacaoPIT.id : null}" var="swAvaliacaoPIPId"></c:url>
		<form:form role="form" commandName="avaliacaoPIT" servletRelativeAction="${swAvaliacaoPIPId}" method="POST">
			<div class="row">
				<div class="col s12">
					<form:hidden path='historico' value="${avaliacaoPIT.historico != null ? avaliacaoPIT.historico.id : historico.id}" />
					<form:errors path='historico'/> 
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<h5 style="text-align: center">Data</h5>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h5 style="text-align: center">Avaliação</h5>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<h5 style="text-align: center">Nota</h5>
				</div><!-- // col -->
				<hr>
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIT_dataAutoAvaliacao" path="avaliacoesPIT_dataAutoAvaliacao" type="text" class="validate datepicker" placeholder="Data Auto Avaliação" /> 
					<label for="avaliacoesPIT_dataAutoAvaliacao">Data Auto Avaliação</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Auto Avaliação</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIT_notaAutoavaliacao" type="text" />
					<form:errors path="avaliacoesPIT_notaAutoavaliacao"></form:errors>
					<form:label path="avaliacoesPIT_notaAutoavaliacao">Nota Auto Avaliação</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIT_dataAvaliacaoOrientador" path="avaliacoesPIT_dataAvaliacaoOrientador" type="text" class="validate datepicker" placeholder="Data Avaliação Orientador" /> 
					<label for="avaliacoesPIT_dataAvaliacaoOrientador">Data Avaliação Orientador</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Orientador</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIT_notaAvaliacaoOrientador" type="text" />
					<form:errors path="avaliacoesPIT_notaAvaliacaoOrientador"></form:errors>
					<form:label path="avaliacoesPIT_notaAvaliacaoOrientador">Nota Orientador</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIT_dataAvaliacaoVivencia" path="avaliacoesPIT_dataAvaliacaoVivencia" type="text" class="validate datepicker" placeholder="Data Avaliação Vivência" /> 
					<label for="avaliacoesPIT_dataAvaliacaoVivencia">Data Avaliação Vivência</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Vivências</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIT_notaAvaliacaoVivencia" type="text" />
					<form:errors path="avaliacoesPIT_notaAvaliacaoVivencia"></form:errors>
					<form:label path="avaliacoesPIT_notaAvaliacaoVivencia">Nota Vivência</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIT_dataAvaliacaoMatematica" path="avaliacoesPIT_dataAvaliacaoMatematica" type="text" class="validate datepicker" placeholder="Data Avaliação Matemática" /> 
					<label for="avaliacoesPIT_dataAvaliacaoMatematica">Data Avaliação Matemática</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Matemática</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIT_notaAvaliacaoMatematica" type="text" />
					<form:errors path="avaliacoesPIT_notaAvaliacaoMatematica"></form:errors>
					<form:label path="avaliacoesPIT_notaAvaliacaoMatematica">Nota Matemática</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIT_dataAvaliacaoInformatica" path="avaliacoesPIT_dataAvaliacaoInformatica" type="text" class="validate datepicker" placeholder="Data Avaliação Informática" /> 
					<label for="avaliacoesPIT_dataAvaliacaoInformatica">Data Avaliação Informática</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Informática</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIT_notaAvaliacaoInformatica" type="text" />
					<form:errors path="avaliacoesPIT_notaAvaliacaoInformatica"></form:errors>
					<form:label path="avaliacoesPIT_notaAvaliacaoInformatica">Nota Informática</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIT_dataAvaliacaoPortugues" path="avaliacoesPIT_dataAvaliacaoPortugues" type="text" class="validate datepicker" placeholder="Data Avaliação Português" /> 
					<label for="avaliacoesPIT_dataAvaliacaoPortugues">Data Avaliação Português</label>
				</div><!-- // col -->
				<div class="col s12 l6">
					<h6 style="text-align: center">Português</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIT_notaAvaliacaoPortugues" type="text" />
					<form:errors path="avaliacoesPIT_notaAvaliacaoPortugues"></form:errors>
					<form:label path="avaliacoesPIT_notaAvaliacaoPortugues">Nota Português</form:label>
				</div><!-- // col -->
			</div><!-- // row -->

			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.pITCadastrar == true && requestScope.avaliacaoPIT.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.pITEditar == true && requestScope.avaliacaoPIT.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

		</form:form>
<br />
		<br />
</div><!-- // Container -->
<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>