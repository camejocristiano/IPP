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
			<c:url value="/sw/profissional/home/${ferias.feriasDataDeVencimento != null ? ferias.fichaProfissional.jovem.id : jovem.id}" var="swProfissionalHomeJovemId"></c:url>
			<a href="${swProfissionalHomeJovemId}">
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
		<c:url value="/sw/ferias/${ferias.fichaProfissional != null ? ferias.id : null}" var="swFeriasId"></c:url>
		<form:form role="form" commandName="ferias" servletRelativeAction="${swFeriasId}" method="POST">
		<div class="row">
			<div class="input-field s12 col l12">
				Data de Início das Férias
			</div>
		</div>
		<div class="row">
			<div class="input-field s12 col l4">
            	<form:input id="feriasDataDeVencimento" path="feriasDataDeVencimento" type="text" class="validate datepicker" placeholder="Férias Data de Vencimento" /> 
				<label for="feriasDataDeVencimento">Férias Data de Vencimento</label>
			</div>
			<div class="input-field s12 col l2">
				<form:select path="diaDeInicioFerias">
					<form:option value="1">01</form:option>
					<form:option value="2">02</form:option>
					<form:option value="3">03</form:option>
					<form:option value="4">04</form:option>
					<form:option value="5">05</form:option>
					<form:option value="6">06</form:option>
					<form:option value="7">07</form:option>
					
					<form:option value="8">08</form:option>
					<form:option value="9">09</form:option>
					<form:option value="10">10</form:option>
					<form:option value="11">11</form:option>
					<form:option value="12">12</form:option>
					<form:option value="13">13</form:option>
					<form:option value="14">14</form:option>
					
					<form:option value="15">15</form:option>
					<form:option value="16">16</form:option>
					<form:option value="17">17</form:option>
					<form:option value="18">18</form:option>
					<form:option value="19">19</form:option>
					<form:option value="20">20</form:option>
					<form:option value="21">21</form:option>
					
					<form:option value="22">22</form:option>
					<form:option value="23">23</form:option>
					<form:option value="24">24</form:option>
					<form:option value="25">25</form:option>
					<form:option value="26">26</form:option>
					<form:option value="27">27</form:option>
					<form:option value="28">28</form:option>
					
					<form:option value="29">29</form:option>
					<form:option value="30">30</form:option>
					<form:option value="31">31</form:option>							

				</form:select>
            	<label for="dia">Dia</label>

			</div>
			<div class="input-field s12 col l2">
				<form:select path="mesDeInicioFerias">
					<form:option value="1">01</form:option>
					<form:option value="2">02</form:option>
					<form:option value="3">03</form:option>
					<form:option value="4">04</form:option>
					<form:option value="5">05</form:option>
					<form:option value="6">06</form:option>
					<form:option value="7">07</form:option>
					
					<form:option value="8">08</form:option>
					<form:option value="9">09</form:option>
					<form:option value="10">10</form:option>
					<form:option value="11">11</form:option>
					<form:option value="12">12</form:option>

				</form:select>
                <label for="mes">Mês</label>
			</div>
			<div class="input-field s12 col l4">
				<form:select path="anoDeInicioFerias">
					<form:option value="2018">2018</form:option>
					<form:option value="2019">2019</form:option>
					<form:option value="2020">2020</form:option>
					<form:option value="2021">2021</form:option>
					<form:option value="2022">2022</form:option>
					<form:option value="2023">2023</form:option>
					<form:option value="2024">2024</form:option>
				</form:select>
                <label for="ano">Ano</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field s12 col l12" style="text-align: right">
				Data Fim das Férias
			</div>
		</div>
		<div class="row">
			<div class="input-field s12 col l4">
				<form:input path='feriasDiasAGozar' type='text' />
				<form:errors path='feriasDiasAGozar'/> 
				<label for="feriasDiasAGozar">Dias à Gozar</label>
			</div>
				<div class="input-field s12 col l2">
					<form:select path="diaDeFimFerias">
						<form:option value="1">01</form:option>
						<form:option value="2">02</form:option>
						<form:option value="3">03</form:option>
						<form:option value="4">04</form:option>
						<form:option value="5">05</form:option>
						<form:option value="6">06</form:option>
						<form:option value="7">07</form:option>
						
						<form:option value="8">08</form:option>
						<form:option value="9">09</form:option>
						<form:option value="10">10</form:option>
						<form:option value="11">11</form:option>
						<form:option value="12">12</form:option>
						<form:option value="13">13</form:option>
						<form:option value="14">14</form:option>
						
						<form:option value="15">15</form:option>
						<form:option value="16">16</form:option>
						<form:option value="17">17</form:option>
						<form:option value="18">18</form:option>
						<form:option value="19">19</form:option>
						<form:option value="20">20</form:option>
						<form:option value="21">21</form:option>
						
						<form:option value="22">22</form:option>
						<form:option value="23">23</form:option>
						<form:option value="24">24</form:option>
						<form:option value="25">25</form:option>
						<form:option value="26">26</form:option>
						<form:option value="27">27</form:option>
						<form:option value="28">28</form:option>
						
						<form:option value="29">29</form:option>
						<form:option value="30">30</form:option>
						<form:option value="31">31</form:option>							
	
					</form:select>
	            	<label for="dia">Dia</label>
	
				</div>
				<div class="input-field s12 col l2">
					<form:select path="mesDeFimFerias">
						<form:option value="1">01</form:option>
						<form:option value="2">02</form:option>
						<form:option value="3">03</form:option>
						<form:option value="4">04</form:option>
						<form:option value="5">05</form:option>
						<form:option value="6">06</form:option>
						<form:option value="7">07</form:option>
						
						<form:option value="8">08</form:option>
						<form:option value="9">09</form:option>
						<form:option value="10">10</form:option>
						<form:option value="11">11</form:option>
						<form:option value="12">12</form:option>
	
					</form:select>
	                <label for="mes">Mês</label>
				</div>
				<div class="input-field s12 col l4">
					<form:select path="anoDeFimFerias">
						<form:option value="2018">2018</form:option>
						<form:option value="2019">2019</form:option>
						<form:option value="2020">2020</form:option>
						<form:option value="2021">2021</form:option>
						<form:option value="2022">2022</form:option>
						<form:option value="2023">2023</form:option>
						<form:option value="2024">2024</form:option>
					</form:select>
	                <label for="ano">Ano</label>
				</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path='observacoes' type='text' />
				<form:errors path='observacoes'/> 
				<label for="observacoes">Observações</label>
			</div>
		</div>
       	<form:input path='fichaProfissional' type='hidden' value="${ferias.fichaProfissional != null ? ferias.fichaProfissional.id : fichaProfissional.id}" />
		
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.feriasCadastrar == true && requestScope.ferias.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.feriasEditar == true && requestScope.ferias.id != null}">
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