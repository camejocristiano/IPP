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
		<c:url value="/sw/avaliacaoPIP/${avaliacaoPIP.historico != null ? avaliacaoPIP.id : null}" var="swAvaliacaoPIPId"></c:url>
		<form:form role="form" commandName="avaliacaoPIP" servletRelativeAction="${swAvaliacaoPIPId}" method="POST">
			<div class="row">
				<div class="col s12">
					<form:hidden path='historico' value="${avaliacaoPIP.historico != null ? avaliacaoPIP.historico.id : historico.id}" />
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
					<form:input id="avaliacoesPIP_dataAutoAvaliacao" path="avaliacoesPIP_dataAutoAvaliacao" type="text" class="validate datepicker" placeholder="Data Auto Avaliação" /> 
					<label for="avaliacoesPIP_dataAutoAvaliacao">Data Auto Avaliação</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Auto Avaliação</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIP_notaAutoavaliacao" type="text" />
					<form:errors path="avaliacoesPIP_notaAutoavaliacao"></form:errors>
					<form:label path="avaliacoesPIP_notaAutoavaliacao">Nota Auto Avaliação</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIP_dataAvaliacaoOrientador" path="avaliacoesPIP_dataAvaliacaoOrientador" type="text" class="validate datepicker" placeholder="Data Avaliação Orientador" /> 
					<label for="avaliacoesPIP_dataAvaliacaoOrientador">Data Avaliação Orientador</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Orientador</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIP_notaAvaliacaoOrientador" type="text" />
					<form:errors path="avaliacoesPIP_notaAvaliacaoOrientador"></form:errors>
					<form:label path="avaliacoesPIP_notaAvaliacaoOrientador">Nota Orientador</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIP_dataAvaliacaoVivencia" path="avaliacoesPIP_dataAvaliacaoVivencia" type="text" class="validate datepicker" placeholder="Data Avaliação Vivência" /> 
					<label for="avaliacoesPIP_dataAvaliacaoVivencia">Data Avaliação Vivência</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Vivências</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIP_notaAvaliacaoVivencia" type="text" />
					<form:errors path="avaliacoesPIP_notaAvaliacaoVivencia"></form:errors>
					<form:label path="avaliacoesPIP_notaAvaliacaoVivencia">Nota Vivência</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIP_dataAvaliacaoMatematica" path="avaliacoesPIP_dataAvaliacaoMatematica" type="text" class="validate datepicker" placeholder="Data Avaliação Matemática" /> 
					<label for="avaliacoesPIP_dataAvaliacaoMatematica">Data Avaliação Matemática</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Matemática</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIP_notaAvaliacaoMatematica" type="text" />
					<form:errors path="avaliacoesPIP_notaAvaliacaoMatematica"></form:errors>
					<form:label path="avaliacoesPIP_notaAvaliacaoMatematica">Nota Matemática</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIP_dataAvaliacaoInformatica" path="avaliacoesPIP_dataAvaliacaoInformatica" type="text" class="validate datepicker" placeholder="Data Avaliação Informática" /> 
					<label for="avaliacoesPIP_dataAvaliacaoInformatica">Data Avaliação Informática</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Informática</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIP_notaAvaliacaoInformatica" type="text" />
					<form:errors path="avaliacoesPIP_notaAvaliacaoInformatica"></form:errors>
					<form:label path="avaliacoesPIP_notaAvaliacaoInformatica">Nota Informática</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPIP_dataAvaliacaoPortugues" path="avaliacoesPIP_dataAvaliacaoPortugues" type="text" class="validate datepicker" placeholder="Data Avaliação Português" /> 
					<label for="avaliacoesPIP_dataAvaliacaoPortugues">Data Avaliação Português</label>
				</div><!-- // col -->
				<div class="col s12 l6">
					<h6 style="text-align: center">Português</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIP_notaAvaliacaoPortugues" type="text" />
					<form:errors path="avaliacoesPIP_notaAvaliacaoPortugues"></form:errors>
					<form:label path="avaliacoesPIP_notaAvaliacaoPortugues">Nota Português</form:label>
				</div><!-- // col -->
			</div><!-- // row -->

			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.pIPCadastrar == true && requestScope.avaliacaoPIP.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.pIPEditar == true && requestScope.avaliacaoPIP.id != null}">
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