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
		<div class="input-field  s12 col l12" style="border-top: 2px solid orange;">
			 <h4 class="header right orange-text">Familiar: <a class="header right" href="/jovens/${familiar.jovem != null ? familiar.jovem.id : jovem.id}">${familiar.jovem != null ? familiar.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
	
	<div class="row">
		<form:form role="form" commandName="familiar" servletRelativeAction="/familiares/${familiar.id}" method="POST"
			class="col s12">
			<div class="row">
				<div class="input-field s12 col l12">
				<hr />
				<hr />
					<form:hidden path="jovem" value="${jovem.id}" />
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l2">
					<form:input path='nomeFamiliar' type='text'/>
					<form:errors path='nomeFamiliar'/> 
					<label for="nomeFamiliar">Nome</label>
				</div><!-- // col -->
				<div class="input-field s12 col l2">
					<form:input path='vinculoFamiliar' type='text'/>
					<form:errors path='vinculoFamiliar'/> 
					<label for="vinculoFamiliar">Vínculo Parentesco</label>
				</div><!-- // col -->
				<div class="input-field s12 col l1">
					<form:input path='idadeFamiliar' type='text'/>
					<form:errors path='idadeFamiliar'/> 
					<label for="idadeFamiliar">Idade</label>
				</div><!-- // col -->
				<div class="input-field s12 col l2">
					<form:select path="estadoCivil">
						<form:option value="${estadoCivil}" label="${familiar.estadoCivil == null ? 'Estado Civil: ' : familiar.estadoCivil}" />
						<c:forEach var="estadoCivil" items="${requestScope.estadosCivis}">
							<option>${estadoCivil}</option>							
						</c:forEach>
					</form:select>
					<label for="dadosSalariais_administradoPor">Estado Civil: </label>
				</div><!-- // col -->
				<div class="input-field s12 col l2">
					<form:input path='grauInstrucaoFamiliar' type='text'/>
					<form:errors path='grauInstrucaoFamiliar'/> 
					<label for="grauInstrucaoFamiliar">Grau Instr.</label>
				</div><!-- // col -->
				<div class="input-field s12 col l2">
					<form:input path='profissaoOcupacaoFamiliar' type='text'/>
					<form:errors path='profissaoOcupacaoFamiliar'/> 
					<label for="profissaoOcupacaoFamiliar">Prof. / Ocup.</label>
				</div><!-- // col -->
				<div class="input-field s12 col l1">
					<form:input path='salarioFamiliar' type='text'/>
					<form:errors path='salarioFamiliar'/> 
					<label for="salarioFamiliar">Salário</label>
				</div><!-- // col -->
			</div><!-- // row -->
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</form:form>
	</div>

</div>

<c:import url="../../../../partials/js.jsp"></c:import>
<script type="text/javascript">
$(document).ready(function() {
	$('select').material_select();
});
</script>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>