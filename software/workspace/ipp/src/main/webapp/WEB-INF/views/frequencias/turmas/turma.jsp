<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<div class="row">
		<div class="col s12 l12">
			<h4 class="header right black-text">Turma</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
<c:url value="/sw/frequencia/turma/${turma.id}" var="swFrequenciasTurmaId"></c:url>
<form action="${swFrequenciasTurmaId}" method="POST">
		<div class="row">
			<div class="input-field s12 col l8">
				<select name="diaDaSemana">
					<c:forEach var="dia" items="${requestScope.dias}">
						<option value="${dia}">${dia}</option>							
					</c:forEach>
				</select>					
				<%-- <select name="turno">
					<option value="${turno}" label="${'Turnos'}" />
					<c:forEach var="turno" items="${requestScope.turnos}">
						<option value="${turno}">${turno}</option>
					</c:forEach>
				</select>
				<label for="turno">Turno</label> --%>
			</div>
			<div class="input-field s12 col l1">
				<select name="dia">
					<option value="1">01</option>
					<option value="2">02</option>
					<option value="3">03</option>
					<option value="4">04</option>
					<option value="5">05</option>
					<option value="6">06</option>
					<option value="7">07</option>

					<option value="8">08</option>
					<option value="9">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>

					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>

					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>

					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>

				</select>
				<label for="dia">Dia</label>

			</div>
			<div class="input-field s12 col l1">
				<select name="mes">
					<option value="1">01</option>
					<option value="2">02</option>
					<option value="3">03</option>
					<option value="4">04</option>
					<option value="5">05</option>
					<option value="6">06</option>
					<option value="7">07</option>

					<option value="8">08</option>
					<option value="9">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>

				</select>
				<label for="mes">Mês</label>
			</div>
			<div class="input-field s12 col l2">
				<select name="ano">
					<option value="2018">2018</option>
					<option value="2019">2019</option>
					<option value="2020">2020</option>
					<option value="2021">2021</option>
					<option value="2022">2022</option>
					<option value="2023">2023</option>
					<option value="2024">2024</option>
				</select>
				<label for="ano">Ano</label>
			</div>
		</div>

<br />
<br />

		<table id="tabelaTurmas" class="display centered">
		<thead>
			<tr>
				<th>ID</th>
				<th>JOVEM</th>
				<th>FREQUÊNCIA</th>
<!-- 				<th>DIA_DA_SEMANA</th> -->
				<th>NÚMERO DA TURMA</th>
				<th>TIPO DA TURMA</th>
				<th>CURSO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="matricula" items="${requestScope.matriculas}">
				<tr>
					<td>
						${matricula.id}
						<input type="hidden" name="matriculas" value="${matricula.id}">
					</td>
					<td>${matricula.jovem.nome}</td>
					<td>
						<input type="checkbox" class="filled-in" id="frequencia${matricula.id}" name="frequencias${matricula.id}" value="1" />
						<label for="frequencia${matricula.id}"></label>
					</td>
<%-- 					<td>
						<select name="dias${matricula.id}">
							<c:forEach var="dia" items="${requestScope.dias}">
								<option value="${dia}">${dia}</option>							
							</c:forEach>
						</select>							
					</td>
 --%>					<td>${matricula.turma.numeroTurma}</td>
					<td>${matricula.turma.tipoTurma}</td>
					<td>${matricula.turma.curso.nomeDoCurso}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="row">
		<div class="input-field s12 col l12">
			<input id="required" type="text" required />
			<label for="required">Digite algo para enviar a lista!</label>
		</div><!-- // col -->
	</div><!-- // row -->

			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.frequenciaCadastrar == true && requestScope.frequencia.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

</form>
<br />
<br />
</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>