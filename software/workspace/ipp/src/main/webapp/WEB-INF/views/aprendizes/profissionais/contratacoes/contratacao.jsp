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
			<a href="/sw/fichaProfissional/home/${contratacao.jovem != null ? contratacao.jovem.id : jovem.id}">
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
		<c:url value="/sw/contratacao/${contratacao.jovem != null ? contratacao.id : null}" var="swContratacaoId"></c:url>
		<form:form role="form" commandName="contratacao" servletRelativeAction="${swContratacaoId}" method="POST">
		<div class="row">
			<div class="input-field s12 col l12">
				Data de Início da Contratação
			</div>
		</div>
		<div class="row">
			<div class="input-field s12 col l1">
				<form:select path="diaDeInicioDaContratacao">
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
			<div class="input-field s12 col l1">
				<form:select path="mesDeInicioDaContratacao">
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
			<div class="input-field s12 col l2">
				<form:select path="anoDeInicioDaContratacao">
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
			<div class="input-field s12 col l8">
                <form:select path="empresaContratante">
              		<form:option  value="${contratacao.empresaContratante.id != null ? contratacao.empresaContratante.id : empresa.id}" label="${contratacao.empresaContratante == null ? 'Empresa Contratante' : contratacao.empresaContratante.razaoSocial}" />
					<c:forEach var="empresa" items="${requestScope.empresas}">
						<option value="${empresa.id}">${empresa.razaoSocial}</option>							
					</c:forEach>
				</form:select>
            </div>
		</div>
		<div class="row">
			<div class="input-field s12 col l12" style="text-align: right">
				Data Fim da Contratação
			</div>
		</div>
		<div class="row">
			<div class="input-field s12 col l6">
                <form:select path="gestorContratacao">
              		<form:option  value="${contratacao.gestorContratacao.id != null ? contratacao.gestorContratacao.id : gestor.id}" label="${contratacao.gestorContratacao == null ? 'Gestor Contratante' : contratacao.gestorContratacao.nome}" />
					<c:forEach var="gestor" items="${requestScope.gestores}">
						<option value="${gestor.id}">${gestor.nome}</option>							
					</c:forEach>
				</form:select>
            </div>
			<div class="input-field s12 col l2">
				<form:input id="exameAdmissional" path="exameAdmissional" type="text" class="validate datepicker" placeholder="Exame Admissional" /> 
				<label for="exameAdmissional">Exame Admissional</label>
			</div>
			<div class="s12 col l4">
				<div class="input-field s12 col l3">
					<form:select path="diaTerminoDoContrato">
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
				<div class="input-field s12 col l3">
					<form:select path="mesTerminoDoContrato">
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
				<div class="input-field s12 col l6">
					<form:select path="anoTerminoDoContrato">
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
		</div>
		<div class="row">
			<div class="input-field s12 col l3">
				<form:select path="tipoDeContratacao">
	               	<form:option value="${contratacao.tipoDeContratacao != null ? contratacao.tipoDeContratacao : tipoDeContratacao}" label="${contratacao.tipoDeContratacao == null ? 'Tipo de Contratação' : contratacao.tipoDeContratacao}" />
					<c:forEach var="tipoDeContratacao" items="${requestScope.tiposDeContratacao}">
						<option>${tipoDeContratacao}</option>							
					</c:forEach>
				</form:select>	
				<label for="tipoDeContratacao">Tipo de Contratação</label>
			</div>
			<div class="col s1">
				<input type="checkbox" name="segunda" class="filled-in" id="segunda" <c:if test="${contratacao.segunda == true}">checked</c:if> />
				<label for="segunda">Seg</label>
			</div>
			<div class="col s1">
				<input type="checkbox" name="terca" class="filled-in" id="terca" <c:if test="${contratacao.terca == true}">checked</c:if> />
				<label for="terca">Ter</label>
			</div>
			<div class="col s1">
				<input type="checkbox" name="quarta" class="filled-in" id="quarta" <c:if test="${contratacao.quarta == true}">checked</c:if> />
				<label for="quarta">Qua</label>
			</div>
			<div class="col s1">
				<input type="checkbox" name="quinta" class="filled-in" id="quinta" <c:if test="${contratacao.quinta == true}">checked</c:if> />
				<label for="quinta">Qui</label>
			</div>
			<div class="col s1">
				<input type="checkbox" name="sexta" class="filled-in" id="sexta" <c:if test="${contratacao.sexta == true}">checked</c:if> />
				<label for="sexta">Sex</label>
			</div>
			<div class="col s1">
				<input type="checkbox" name="sabado" class="filled-in" id="sabado" <c:if test="${contratacao.sabado == true}">checked</c:if> />
				<label for="sabado">Sáb</label>
			</div>
			<div class="col s3">
				<form:input path='horarioDeTrabalho' type='text' />
				<form:errors path='horarioDeTrabalho'/> 
				<label for="horarioDeTrabalho">Horário de Trabalho</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12" style="border: 1px solid #222">
			Dados do Curso:
				<c:forEach items="${requestScope.matriculas}" var="matricula">
				<c:if test="${matricula.statusDaMatricula == 'CURSANDO'}">
				<div class="row">
					<div class="input-field col s6">
						CBO: ${matricula.turma.curso.cBO.titulo}
					</div>
					<div class="input-field col s6">
						Dia do Curso: ${matricula.turma.diaDaSemana}
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						Data de Início: ${matricula.turma.dataInicioTurma}
					</div>
				</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path='totalDeHorasSemana' type='text' />
				<form:errors path='totalDeHorasSemana'/> 
				<label for="totalDeHorasSemana">Total de Horas Semanais</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path='observacoes' type='text' />
				<form:errors path='observacoes'/> 
				<label for="observacoes">Observações</label>
			</div>
		</div>
       	<form:input path='jovem' type='hidden' value="${requestScope.jovem.id}" />
		
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.contratacaoCadastrar == true && requestScope.contratacao.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.contratacaoEditar == true && requestScope.contratacao.id != null}">
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