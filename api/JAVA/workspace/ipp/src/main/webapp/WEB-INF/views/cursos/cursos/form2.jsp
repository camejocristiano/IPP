<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<div class="row">
		<div class="input-field  s12 col l12" style="border-top: 2px solid orange;">
			 <h4 class="header right orange-text">Curso</h4>
		</div>
	</div>

<form:form role="form" commandName="curso" servletRelativeAction="/cursos/${curso.id}" method="POST">
			
			<div class="row">
				<div class="input-field s12 col l8">
					<div class="row" style="border:1px solid gray;">
						<div class="input-field s12 col l12">
							<form:select path="cBO">
                				<form:option  value="${cBO.id}" label="${curso.cBO == null ? 'CBO' : curso.cBO.titulo}" />
								<c:forEach var="cBO" items="${requestScope.cBOs}">
									<form:option value="${cBO.id}">${cBO.titulo}</form:option>							
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row" style="border:1px solid gray;">
						<div class="input-field s12 col l12">
						
							<div class="row">
								<div class="input-field s12 col l12">
									<form:select path="arcoOcupacional">
		                				<form:option  value="${arcoOcupacional.id}" label="${curso.arcoOcupacional == null ? 'Arco Ocupacional' : curso.arcoOcupacional.titulo}" />
										<c:forEach var="arcoOcupacional" items="${requestScope.arcos}">
											<option value="${arcoOcupacional.id}">${arcoOcupacional.titulo}</option>							
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="row">
								<div class="input-field s12 col l11" style="border:1px solid gray; margin: 2em;">

									<div class="row">
										<div class="s12 col l12">
											<table class="striped">
										        <thead>
										          <tr>
										              <th>CBO</th>
										              <th>NÚMERO</th>
										          </tr>
										        </thead>
										
										        <tbody>
										           	<c:forEach var="cbo_arco" items="${requestScope.cbos_arco}">
											          <tr>
														<td>
														<input type="checkbox" class="filled-in" name="cbos" id="cbos${cbo_arco.id}" value="${cbo_arco.id}" <c:if test="${cbo_arco.id != null}">checked</c:if> />
														<label for="cbos${cbo_arco.id}"></label>
											            </td>
											            <td>${cbo_arco.titulo}</td>
											            <td>${cbo_arco.numero}</td>
											          </tr>
											        </c:forEach>
										        </tbody>
										      </table>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="input-field s12 col l1">
				</div>
							<div class="row">
								<div class="input-field s12 col l12">

									<div class="row">
										<div class="s12 col l12">
											<table class="striped">
										        <thead>
										          <tr>
										              <th>DATA_DE_ENVIO</th>
										              <th>DATA_DA_VALIDAÇÃO</th>
										              <th>DATA DA SOLICITAÇÃO</th>
										              <th>TIPO</th>
										              <th>EDITAR</th>
										          </tr>
										        </thead>
										
										        <tbody>
										           	<c:forEach var="validacao" items="${requestScope.validacoes}">
											          <tr>
											            <td>${validacao.dataDeEnvio}</td>
											            <td>${validacao.dataDaValidacao}</td>
											            <td>${validacao.dataDaSolicitacao}</td>
											            <td>${validacao.tipoDeValidacao}</td>
											            <td class="td-icon"><a href="/validacoes/${validacao.id}"><i class="material-icons" >border_color</i></a></td>
          											   </tr>
											        </c:forEach>
										        </tbody>
										      </table>
										</div>
									</div>
								</div>
							</div>

						</div>
			
			<div class="row">
				<div class="input-field s12 col l12">
					<form:textarea path="atividadesPraticas" class="materialize-textarea" />
					<form:errors path="atividadesPraticas"></form:errors>
					<form:label path="atividadesPraticas">Atividades Práticas</form:label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12">
					<form:textarea path="articulacaoComOutrasAreas" class="materialize-textarea" />
					<form:errors path="articulacaoComOutrasAreas"></form:errors>
					<form:label path="articulacaoComOutrasAreas">Articulação Com Outras Áreas</form:label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12" style="border:1px solid gray;">
					<div class="row">
					<h5>Matriz Curricular</h5>
					<br />
					<br />
								<div class="input-field s12 col l12">

									<div class="row">
										<div class="s12 col l12">
											<table class="striped">
										        <thead>
										          <tr>
										              <th>TITULO</th>
										              <th>HORAS / AULA</th>
										          </tr>
										        </thead>
										
										        <tbody>
										           	<c:forEach var="basico_curso" items="${requestScope.basicos_curso}">
											          <tr>
											            <td>${basico_curso.titulo}</td>
											            <td>${basico_curso.horaAula}</td>
          											   </tr>
											        </c:forEach>
										        </tbody>
										      </table>
										</div><!-- // col -->
									</div><!-- // row -->
								</div><!-- // col -->
							</div><!-- // row -->
							</div>
						</div>
					<div class="row">
					<br />
					<br />
						<div class="input-field s12 col l8">
							<form:input path='numeroDoCurso' type='text'/>
							<form:errors path='numeroDoCurso'/> 
							<label for="numeroDoCurso">Nº do Curso</label>
						</div>
						<div class="input-field s12 col l2">
							<form:input path='numeroDoCurso' type='text'/>
							<form:errors path='numeroDoCurso'/> 
							<label for="numeroDoCurso">Nº do Curso</label>
						</div>
						<div class="input-field s12 col l2">
							<a class="waves-effect waves-light btn">button</a>
						</div>
					</div>
								<div class="row">
						<div class="input-field s12 col l12">
							<table class="striped">
								        <thead>
								          <tr>
								              <th>Name</th>
								              <th>Item Name</th>
								          </tr>
								        </thead>
								
								        <tbody>
								          <tr>
								            <td>Alvin</td>
								            <td>Eclair</td>
								          </tr>
								          <tr>
								            <td>Alan</td>
								            <td>Jellybean</td>
								          </tr>
								          <tr>
								            <td>Jonathan</td>
								            <td>Lollipop</td>
								          </tr>
								        </tbody>
								      </table>
						</div>
					</div>
			<div class="row">
				<div class="input-field s12 col l12">
					<form:textarea path="resumo" class="materialize-textarea" />
					<form:errors path="resumo"></form:errors>
					<form:label path="resumo">Resumo</form:label>
				</div>
			</div>
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</form:form>									