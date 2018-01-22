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
                    <form:select path="unidade" required="required">
                		<form:option  value="${unidade.id}" label="${curso.unidade == null ? 'Unidade' : curso.unidade.nomeFantazia}" />
						<c:forEach var="unidade" items="${requestScope.unidades}">
							<option value="${unidade.id}">${unidade.nomeFantazia}</option>							
						</c:forEach>
					</form:select>
                </div>
			</div>
			<div class="row">
				<div class="input-field s12 col l3">
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
				<div class="input-field s12 col l3">
					<input type="checkbox" class="filled-in" name="livre" id="livre" <c:if test="${curso.livre == true}">checked</c:if> />
					<label for="livre">Livre</label>
				</div>
				<div class="input-field s12 col l3">
                    <form:select path="status">
	                	<form:option value="${curso.status}" label="${curso.status == null ? 'Status' : curso.status}" />
						<c:forEach var="status" items="${requestScope.status}">
							<option>${status}</option>							
						</c:forEach>
					</form:select>
                </div>
			</div>
			<div class="row">
				<div class="input-field s12 col l8">
					<div class="row" style="border:1px solid gray;">
						<div class="input-field s12 col l9">
							<form:select path="cBO">
                				<form:option  value="${cBO.id}" label="${curso.cBO == null ? 'CBO' : curso.cBO.titulo}" />
								<c:forEach var="cBO" items="${requestScope.cBOs}">
									<option value="${cBO.id}">${cBO.titulo}</option>							
								</c:forEach>
							</form:select>
						</div>
						<div class="input-field s12 col l3">
							<form:input path='numeroDoCurso' type='text'/>
							<form:errors path='numeroDoCurso'/> 
							<label for="numeroDoCurso">Nº do Curso</label>
						</div>
					</div>
					<div class="row" style="border:1px solid gray;">
						<div class="input-field s12 col l12">
						
							<div class="row">
								<div class="input-field s12 col l12">
									<form:select path="arcoOcupacional">
		                				<form:option  value="${arcoOcupacional.id}" label="${curso.arcoOcupacional == null ? 'Arco Ocupacional' : curso.arcoOcupacional.titulo}" />
										<c:forEach var="arcoOcupacional" items="${requestScope.arcosOcupacionais}">
											<option value="${arcoOcupacional.id}">${arcoOcupacional.titulo}</option>							
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="row">
								<div class="input-field s12 col l11" style="border:1px solid gray; margin: 2em;">
									<div class="row">
										<div class="input-field s12 col l6">
											<form:input path='numeroDoCurso' type='text'/>
											<form:errors path='numeroDoCurso'/> 
											<label for="numeroDoCurso">Nº do Curso</label>
										</div>
										<div class="input-field s12 col l3">
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
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="input-field s12 col l1">
				</div>
				<div class="input-field s12 col l3">
			 		<h6 class="header right orange-text">Outros</h6>
					<div class="row" style="display: block; border-top: 2px solid orange;">
						<div class="input-field s12 col l12">
							<input id="dataExpedicao" type="date" class="validate datepicker" placeholder="Data de Expedição" /> 
                		</div>
                	</div>
                	<div class="row">
						<div class="input-field s12 col l12">
                			<form:input path='numeroDoCurso' type='text'/>
							<form:errors path='numeroDoCurso'/> 
							<label for="numeroDoCurso">Nº do Curso</label>
                		</div>
                	</div>
                	<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='numeroDoCurso' type='text'/>
							<form:errors path='numeroDoCurso'/> 
							<label for="numeroDoCurso">Nº do Curso</label>
                		</div>
                	</div>
                	<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='numeroDoCurso' type='text'/>
							<form:errors path='numeroDoCurso'/> 
							<label for="numeroDoCurso">Nº do Curso</label>
                		</div>
                	</div>
                </div>
			</div>
			
			<div class="row">
				<div class="input-field s12 col l12" style="border:1px solid gray;">
					<div class="row">
						<div class="input-field s12 col l2">
							<input id="dataExpedicao" type="date" class="validate datepicker" placeholder="Data de Expedição" /> 
                		</div>
						<div class="input-field s12 col l2">
							<input id="dataExpedicao" type="date" class="validate datepicker" placeholder="Data de Expedição" /> 
                		</div>
						<div class="input-field s12 col l2">
							<input id="dataExpedicao" type="date" class="validate datepicker" placeholder="Data de Expedição" /> 
                		</div>
						<div class="input-field s12 col l4">
							<form:select path="status">
			                	<form:option value="${curso.status}" label="${curso.status == null ? 'Status' : curso.status}" />
								<c:forEach var="status" items="${requestScope.status}">
									<option>${status}</option>							
								</c:forEach>
							</form:select>
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
											  <th>Name</th>
								              <th>Item Name</th>
								              <th>Name</th>
								          </tr>
								        </thead>
								
								        <tbody>
								          <tr>
								            <td>Alvin</td>
								            <td>Eclair</td>
								            <td>Jonathan</td>
								            <td>Lollipop</td>
								            <td>Lollipop</td>
								          </tr>
								          <tr>
								            <td>Alan</td>
								            <td>Jellybean</td>
								            <td>Jonathan</td>
								            <td>Lollipop</td>
								            <td>Lollipop</td>
								          </tr>
								          <tr>
								            <td>Jonathan</td>
								            <td>Lollipop</td>
								            <td>Jonathan</td>
								            <td>Lollipop</td>
								            <td>Lollipop</td>
								          </tr>
								        </tbody>
								      </table>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12">
					<form:textarea path="atividadePraticas" class="materialize-textarea" />
					<form:errors path="atividadePraticas"></form:errors>
					<form:label path="atividadePraticas">Atividade Práticas</form:label>
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