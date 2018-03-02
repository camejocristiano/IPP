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
		<c:url value="/sw/avaliacaoPIO/${avaliacaoPIO.historico != null ? avaliacaoPIO.id : null}" var="swAvaliacaoPIOId"></c:url>
		<form:form role="form" commandName="avaliacaoPIO" servletRelativeAction="${swAvaliacaoPIOId}" method="POST">
			<div class="row">
				<div class="input-field col s12 l12">
					<form:hidden path='historico' value="${avaliacaoPIO.historico != null ? avaliacaoPIO.historico.id : historico.id}" />
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
				<div class="input-field col s12 l2">
					<h5 style="text-align: center">AutoAvaliação</h5>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<h5 style="text-align: center">Orientador</h5>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<h5 style="text-align: center">Cont.</h5>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPIO_data1avaliacao" path="avaliacoesPIO_data1avaliacao" type="date" class="validate datepicker" placeholder="Data 1ª Avaliação" /> 
					<label for="avaliacoesPIO_data1avaliacao">Data 1ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">1ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_autoav1avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_autoav1avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_autoav1avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avOrient1avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avOrient1avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avOrient1avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avCont1avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avCont1avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avCont1avaliacao">Nota Cont.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPIO_data2avaliacao" path="avaliacoesPIO_data2avaliacao" type="date" class="validate datepicker" placeholder="Data 2ª Avaliação" /> 
					<label for="avaliacoesPIO_data2avaliacao">Data 2ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">2ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_autoav2avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_autoav2avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_autoav2avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avOrient2avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avOrient2avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avOrient2avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avCont2avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avCont2avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avCont2avaliacao">Nota Cont.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPIO_data3avaliacao" path="avaliacoesPIO_data3avaliacao" type="date" class="validate datepicker" placeholder="Data 3ª Avaliação" /> 
					<label for="avaliacoesPIO_data3avaliacao">Data 3ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">3ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_autoav3avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_autoav3avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_autoav3avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avOrient3avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avOrient3avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avOrient3avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avCont3avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avCont3avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avCont3avaliacao">Nota Cont.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPIO_data4avaliacao" path="avaliacoesPIO_data4avaliacao" type="date" class="validate datepicker" placeholder="Data 4ª Avaliação" /> 
					<label for="avaliacoesPIO_data4avaliacao">Data 4ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">4ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_autoav4avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_autoav4avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_autoav4avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avOrient4avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avOrient4avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avOrient4avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avCont4avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avCont4avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avCont4avaliacao">Nota Cont.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPIO_data5avaliacao" path="avaliacoesPIO_data5avaliacao" type="date" class="validate datepicker" placeholder="Data 5ª Avaliação" /> 
					<label for="avaliacoesPIO_data5avaliacao">Data 5ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">5ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_autoav5avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_autoav5avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_autoav5avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avOrient5avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avOrient5avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avOrient5avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avCont5avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avCont5avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avCont5avaliacao">Nota Cont.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPIO_data6avaliacao" path="avaliacoesPIO_data6avaliacao" type="date" class="validate datepicker" placeholder="Data 6ª Avaliação" /> 
					<label for="avaliacoesPIO_data6avaliacao">Data 6ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">6ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_autoav6avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_autoav6avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_autoav6avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avOrient6avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avOrient6avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avOrient6avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avCont6avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avCont6avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avCont6avaliacao">Nota Cont.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPIO_data7avaliacao" path="avaliacoesPIO_data7avaliacao" type="date" class="validate datepicker" placeholder="Data 7ª Avaliação" /> 
					<label for="avaliacoesPIO_data7avaliacao">Data 7ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">7ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_autoav7avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_autoav7avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_autoav7avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avOrient7avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avOrient7avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avOrient7avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avCont7avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avCont7avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avCont7avaliacao">Nota Cont.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPIO_data8avaliacao" path="avaliacoesPIO_data8avaliacao" type="date" class="validate datepicker" placeholder="Data 8ª Avaliação" /> 
					<label for="avaliacoesPIO_data8avaliacao">Data 8ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">8ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_autoav8avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_autoav8avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_autoav8avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avOrient8avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avOrient8avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avOrient8avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPIO_avCont8avaliacao" type="text" />
					<form:errors path="avaliacoesPIO_avCont8avaliacao"></form:errors>
					<form:label path="avaliacoesPIO_avCont8avaliacao">Nota Cont.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->

			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.pIOCadastrar == true && requestScope.avaliacaoPIO.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.pIOEditar == true && requestScope.avaliacaoPIO.id != null}">
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