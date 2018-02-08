<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- <div class="row">
	<div class="input-field  s12 col l12" style="border-top: 2px solid orange;">
		 <h4 class="header right orange-text">Curso:</h4>
	</div>
</div> -->
<div class="row">
	<form:form role="form" commandName="curso" servletRelativeAction="/cursos/${curso.id}" method="POST">
	<div class="s12 col l12">	
		<hr />
		<hr />
		<div class="row">
			<div class="s12 col l12">
				<div class="row">
					<div class="input-field s12 col l6">
						<form:input path='nomeDoCurso' type='text'/>
						<form:errors path='nomeDoCurso'/> 
						<label for="nomeDoCurso">Nome do Curso</label>
					</div>
					<div class="input-field s12 col l2">
						<form:input path='numeroDoCurso' type='text'/>
						<form:errors path='numeroDoCurso'/> 
						<label for="numeroDoCurso">Nº do Curso</label>
					</div>
					<div class="input-field s12 col l2">
	                    <form:select path="status">
		                	<form:option value="${curso.status}" label="${curso.status == null ? 'Status' : curso.status}" />
							<c:forEach var="status" items="${requestScope.status}">
								<option>${status}</option>							
							</c:forEach>
						</form:select>
	                </div>
					<div class="input-field s12 col l2">
	                    <form:select path="unidade">
	                		<form:option  value="${curso.unidade.id}" label="${curso.unidade == null ? 'Unidade' : curso.unidade.nomeFantazia}" />
							<c:forEach var="unidade" items="${requestScope.unidades}">
								<option value="${unidade.id}">${unidade.nomeFantazia}</option>							
							</c:forEach>
						</form:select>
	                </div>
				</div>
				<div class="row">
					<div class="s12 col l3">
						<input type="checkbox" class="filled-in" name="pap" id="pap" <c:if test="${curso.pap == true}">checked</c:if> />
						<label for="pap">PAP</label>
					</div>
					<div class="input-field s12 col l3">
	                    <form:select path="statusPAP">
		                	<form:option value="${curso.statusPAP}" label="${curso.statusPAP == null ? 'Status' : curso.statusPAP}" />
							<c:forEach var="statusPAP" items="${requestScope.statusPAP}">
								<option>${statusPAP}</option>							
							</c:forEach>
						</form:select>
	                </div>
					<div class="s12 col l3">
						<input type="checkbox" class="filled-in" name="livre" id="livre" <c:if test="${curso.livre == true}">checked</c:if> />
						<label for="livre">Livre</label>
					</div>
					<div class="input-field s12 col l3">
	                    <form:select path="statusLivre">
		                	<form:option value="${curso.statusLivre != null ? curso.statusLivre : curso.status}" label="${curso.statusLivre == null ? 'Status Livre' : curso.statusLivre}" />
							<c:forEach var="status" items="${requestScope.status}">
								<option>${status}</option>							
							</c:forEach>
						</form:select>
	                </div>
				</div>
			</div><!-- // col -->
		</div><!-- // row -->
		<div class="row">
			<div class="input-field s12 col l8">
				<div class="row">
						<div class="input-field s12 col l12">
						<hr />
						<hr />
							<form:select path="cBO">
                				<form:option  value="${cBO.id}" label="${curso.cBO == null ? 'CBO' : curso.cBO.titulo}" />
								<c:forEach var="cBO" items="${requestScope.cBOs}">
									<form:option value="${cBO.id}">${cBO.titulo}</form:option>							
								</c:forEach>
							</form:select>
						</div><!-- // col -->
					</div><!-- // row -->
			</div><!-- // col -->
			<div class="input-field s12 col l1">
			</div>
			<div class="input-field s12 col l3">
				<form:input id="dataDoCadastro" path="dataDoCadastro" type="date" class="validate datepicker" placeholder="Data de Cadastro" /> 
				<label for="dataDoCadastro">Data de Cadastro</label>
			</div><!-- // col -->
		</div><!-- // row -->
		<div class="row">
			<div class="input-field s12 col l8">	
				<div class="row">
					<div class="input-field s12 col l12">
					<hr />
					<hr />
						<form:select path="arcoOcupacional">
		            	<form:option  value="${arcoOcupacional.id}" label="${curso.arcoOcupacional == null ? 'Arco Ocupacional' : curso.arcoOcupacional.titulo}" />
						<c:forEach var="arcoOcupacional" items="${requestScope.arcos}">
							<option value="${arcoOcupacional.id}">${arcoOcupacional.titulo}</option>							
						</c:forEach>
						</form:select>
					</div>
				</div>	
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
									<td>${cbo_arco.titulo}</td>
									<td>${cbo_arco.numero}</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div><!-- // col -->
				</div><!-- // row -->
			</div><!-- // col -->
			<div class="input-field s12 col l1">
			</div>
			<div class="input-field s12 col l3">
				<div class="row">
					<div class="input-field s12 col l12">
						<form:input path='cargaHorariaSemanal' type='text'/>
						<form:errors path='cargaHorariaSemanal'/> 
						<label for="cargaHorariaSemanal">Carga Horária Semanal</label>
					</div><!-- // col -->
				</div><!-- // row -->
				<div class="row">
					<div class="input-field s12 col l12">
						<form:input path='cargaHorariaTotal' type='text'/>
						<form:errors path='cargaHorariaTotal'/> 
						<label for="cargaHorariaTotal">Carga Horária Total</label>
					</div><!-- // col -->
				</div><!-- // row -->
				<div class="row">
					<div class="input-field s12 col l12">
						<form:input path='publicoAlvo' type='text'/>
						<form:errors path='publicoAlvo'/> 
						<label for="publicoAlvo">Público Alvo</label>
					</div><!-- // col -->
				</div><!-- // row -->
			</div><!-- // col -->
		</div><!-- // row -->
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
								<td class="td-icon"><a href="/validacoes/${validacao.id}"><i
										class="material-icons">border_color</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div><!-- // col -->
		</div><!-- // row -->
		<div class="row">
			<div class="input-field s12 col l12">
				<form:textarea path="atividadesPraticas" class="materialize-textarea" />
				<form:errors path="atividadesPraticas"></form:errors>
				<form:label path="atividadesPraticas">Atividades Práticas</form:label>
			</div><!-- col -->
		</div><!-- // row -->
		<div class="row">
			<div class="input-field s12 col l12">
				<form:textarea path="articulacaoComOutrasAreas"
					class="materialize-textarea" />
				<form:errors path="articulacaoComOutrasAreas"></form:errors>
				<form:label path="articulacaoComOutrasAreas">Articulação Com Outras Áreas</form:label>
			</div><!-- // col -->
		</div><!-- // row -->
		<div class="row">
			<div class="s12 col l12">
			<h5>Matriz Curricular</h5>
			<hr />
			<hr />
				<div class="row">
					<div class="s12 col l12">
						<table class="striped">
							<thead>
								<tr>
									<th colspan="3">Conteúdos Teóricos Básicos</th>
								</tr>
								<tr>
									<th>INCLUSO</th>
									<th>TITULO</th>
									<th>HORAS / AULA</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="basico_curso" items="${requestScope.basicos_curso}">
									<tr>
										<td>
											<input type="checkbox" class="filled-in" name="conteudosTeoricosBasicos" id="basicos${basico_curso.id}" value="${basico_curso.id}" <c:if test="${basico_curso.id != null}">checked</c:if> />
											<label for="basicos${basico_curso.id}"></label>
								        </td>
										<td>${basico_curso.titulo}</td>
										<td>${basico_curso.horaAula}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<table class="striped">
							<thead>
								<tr>
									<th>NÃO-INCLUSO</th>
									<th>TITULO</th>
									<th>HORAS / AULA</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="basico" items="${requestScope.basicos}">
									<tr>
										<td>
											<input type="checkbox" class="filled-in" name="conteudosTeoricosBasicos" id="basicos${basico.id}" value="${basico.id}" />
											<label for="basicos${basico.id}"></label>
								        </td>
										<td>${basico.titulo}</td>
										<td>${basico.horaAula}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div><!-- // col -->
				</div><!-- // row -->
				<div class="row">
					<div class="s12 col l12">
						<table class="striped">
							<thead>
								<tr>
									<th colspan="3">Conteúdos Teóricos Específicos</th>
								</tr>
								<tr>
									<th>INCLUSO</th>
									<th>TITULO</th>
									<th>HORAS / AULA</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="especifico_curso" items="${requestScope.especificos_curso}">
									<tr>
										<td>
											<input type="checkbox" class="filled-in" name="conteudosTeoricosEspecificos" id="especificos${especifico_curso.id}" value="${especifico_curso.id}" <c:if test="${especifico_curso.id != null}">checked</c:if> />
											<label for="especificos${especifico_curso.id}"></label>
								        </td>
										<td>${especifico_curso.titulo}</td>
										<td>${especifico_curso.horaAula}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<table class="striped">
							<thead>
								<tr>
									<th>NÃO-INCLUSO</th>
									<th>TITULO</th>
									<th>HORAS / AULA</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="especifico_curso" items="${requestScope.especificos}">
									<tr>
										<td>
											<input type="checkbox" class="filled-in" name="conteudosTeoricosEspecificos" id="especificos${especifico_curso.id}" value="${especifico_curso.id}" />
											<label for="especificos${especifico_curso.id}"></label>
								        </td>
										<td>${especifico_curso.titulo}</td>
										<td>${especifico_curso.horaAula}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div><!-- // col -->
				</div><!-- // row -->
			</div><!-- // col -->
		</div><!-- // row -->
		<div class="row">
			<div class="input-field s12 col l12">
				<form:textarea path="resumo" class="materialize-textarea" />
				<form:errors path="resumo"></form:errors>
				<form:label path="resumo">Resumo</form:label>
			</div><!-- // col -->
		</div><!-- // row -->
	</div><!-- // col -->
	<button class="btn waves-effect waves-light right" type="submit">
		Salvar<i class="material-icons right">send</i>
	</button>
	</form:form>
</div><!-- // row -->
