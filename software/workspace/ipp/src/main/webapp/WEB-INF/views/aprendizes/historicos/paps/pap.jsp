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
		<c:url value="/sw/avaliacaoPAPIPP/${avaliacaoPAPIPP.historico != null ? avaliacaoPAPIPP.id : null}" var="swAvaliacoesPAPsIPPId"></c:url>
		<form:form role="form" commandName="avaliacaoPAPIPP" servletRelativeAction="${swAvaliacoesPAPsIPPId}" method="POST">
			<div class="row">
				<div class="input-field col s12 l12">
					<form:hidden path='historico' value="${avaliacaoPAPIPP.historico != null ? avaliacaoPAPIPP.historico.id : historico.id}" />
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
					<h5 style="text-align: center">Conteudo.</h5>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPIPP_data1avaliacao" path="avaliacoesPAPIPP_data1avaliacao" type="text" class="validate datepicker" placeholder="Data 1ª Avaliação" /> 
					<label for="avaliacoesPAPIPP_data1avaliacao">Data 1ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">1ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_autoav1avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_autoav1avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_autoav1avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avOrient1avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avOrient1avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avOrient1avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avConteudo1avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avConteudo1avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avConteudo1avaliacao">Nota Conteudo.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPIPP_data2avaliacao" path="avaliacoesPAPIPP_data2avaliacao" type="text" class="validate datepicker" placeholder="Data 2ª Avaliação" /> 
					<label for="avaliacoesPAPIPP_data2avaliacao">Data 2ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">2ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_autoav2avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_autoav2avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_autoav2avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avOrient2avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avOrient2avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avOrient2avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avConteudo2avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avConteudo2avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avConteudo2avaliacao">Nota Conteudo.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPIPP_data3avaliacao" path="avaliacoesPAPIPP_data3avaliacao" type="text" class="validate datepicker" placeholder="Data 3ª Avaliação" /> 
					<label for="avaliacoesPAPIPP_data3avaliacao">Data 3ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">3ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_autoav3avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_autoav3avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_autoav3avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avOrient3avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avOrient3avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avOrient3avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avConteudo3avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avConteudo3avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avConteudo3avaliacao">Nota Conteudo.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPIPP_data4avaliacao" path="avaliacoesPAPIPP_data4avaliacao" type="text" class="validate datepicker" placeholder="Data 4ª Avaliação" /> 
					<label for="avaliacoesPAPIPP_data4avaliacao">Data 4ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">4ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_autoav4avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_autoav4avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_autoav4avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avOrient4avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avOrient4avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avOrient4avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avConteudo4avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avConteudo4avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avConteudo4avaliacao">Nota Conteudo.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPIPP_data5avaliacao" path="avaliacoesPAPIPP_data5avaliacao" type="text" class="validate datepicker" placeholder="Data 5ª Avaliação" /> 
					<label for="avaliacoesPAPIPP_data5avaliacao">Data 5ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">5ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_autoav5avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_autoav5avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_autoav5avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avOrient5avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avOrient5avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avOrient5avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avConteudo5avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avConteudo5avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avConteudo5avaliacao">Nota Conteudo.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPIPP_data6avaliacao" path="avaliacoesPAPIPP_data6avaliacao" type="text" class="validate datepicker" placeholder="Data 6ª Avaliação" /> 
					<label for="avaliacoesPAPIPP_data6avaliacao">Data 6ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">6ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_autoav6avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_autoav6avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_autoav6avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avOrient6avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avOrient6avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avOrient6avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avConteudo6avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avConteudo6avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avConteudo6avaliacao">Nota Conteudo.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPIPP_data7avaliacao" path="avaliacoesPAPIPP_data7avaliacao" type="text" class="validate datepicker" placeholder="Data 7ª Avaliação" /> 
					<label for="avaliacoesPAPIPP_data7avaliacao">Data 7ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">7ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_autoav7avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_autoav7avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_autoav7avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avOrient7avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avOrient7avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avOrient7avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avConteudo7avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avConteudo7avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avConteudo7avaliacao">Nota Conteudo.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPIPP_data8avaliacao" path="avaliacoesPAPIPP_data8avaliacao" type="text" class="validate datepicker" placeholder="Data 8ª Avaliação" /> 
					<label for="avaliacoesPAPIPP_data8avaliacao">Data 8ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">8ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_autoav8avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_autoav8avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_autoav8avaliacao">Nota Auto Avaliação</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avOrient8avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avOrient8avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avOrient8avaliacao">Nota Orientador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPIPP_avConteudo8avaliacao" type="text" />
					<form:errors path="avaliacoesPAPIPP_avConteudo8avaliacao"></form:errors>
					<form:label path="avaliacoesPAPIPP_avConteudo8avaliacao">Nota Conteudo.</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.pAPIPPCadastrar == true && requestScope.avaliacaoPAPIPP.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.pAPIPPEditar == true && requestScope.avaliacaoPAPIPP.id != null}">
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