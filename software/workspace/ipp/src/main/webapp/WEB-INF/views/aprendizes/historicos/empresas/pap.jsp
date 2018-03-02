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
		<c:url value="/sw/avaliacaoPAPEmpresa/${avaliacaoPAPEmpresa.historico != null ? avaliacaoPAPEmpresa.id : null}" var="swAvaliacaoPAPEmpresaId"></c:url>
		<form:form role="form" commandName="avaliacaoPAPEmpresa" servletRelativeAction="${swAvaliacaoPAPEmpresaId}" method="POST">
			<div class="row">
				<div class="input-field col s12 l12">
					<form:hidden path='historico' value="${avaliacaoPAPEmpresa.historico != null ? avaliacaoPAPEmpresa.historico.id : historico.id}" />
					<form:errors path='historico'/> 
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<h5 style="text-align: center">Data</h5>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h5 style="text-align: center">Avaliações</h5>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h5 style="text-align: center">Avaliador</h5>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<h5 style="text-align: center">Nota</h5>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data1avaliacao" path="avaliacoesPAPEmpresa_data1avaliacao" type="text" class="validate datepicker" placeholder="Data 1ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data1avaliacao">Data 1ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">1ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador1avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador1avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador1avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota1avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota1avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota1avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data2avaliacao" path="avaliacoesPAPEmpresa_data2avaliacao" type="text" class="validate datepicker" placeholder="Data 2ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data2avaliacao">Data 2ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">2ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador2avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador2avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador2avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota2avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota2avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota2avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data3avaliacao" path="avaliacoesPAPEmpresa_data3avaliacao" type="text" class="validate datepicker" placeholder="Data 3ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data3avaliacao">Data 3ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">3ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador3avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador3avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador3avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota3avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota3avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota3avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data4avaliacao" path="avaliacoesPAPEmpresa_data4avaliacao" type="text" class="validate datepicker" placeholder="Data 4ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data4avaliacao">Data 4ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">4ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador4avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador4avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador4avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota4avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota4avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota4avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data5avaliacao" path="avaliacoesPAPEmpresa_data5avaliacao" type="text" class="validate datepicker" placeholder="Data 5ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data5avaliacao">Data 5ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">5ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador5avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador5avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador5avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota5avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota5avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota5avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data6avaliacao" path="avaliacoesPAPEmpresa_data6avaliacao" type="text" class="validate datepicker" placeholder="Data 6ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data6avaliacao">Data 6ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">6ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador6avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador6avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador6avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota6avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota6avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota6avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data7avaliacao" path="avaliacoesPAPEmpresa_data7avaliacao" type="text" class="validate datepicker" placeholder="Data 7ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data7avaliacao">Data 7ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">7ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador7avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador7avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador7avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota7avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota7avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota7avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data8avaliacao" path="avaliacoesPAPEmpresa_data8avaliacao" type="text" class="validate datepicker" placeholder="Data 8ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data8avaliacao">Data 8ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">8ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador8avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador8avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador8avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota8avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota8avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota8avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			
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
				
		</form:form>
		<br />
		<br />
</div><!-- // Container -->
<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>