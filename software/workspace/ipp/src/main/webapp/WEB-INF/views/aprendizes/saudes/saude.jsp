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
			<c:url value="/sw/jovem/${jovem.id}" var="swJovemJovemId"></c:url>
			<a href="${swJovemJovemId}">
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

		<form:form role="form" commandName="situacaoDeSaude" servletRelativeAction="/sw/situacaoDeSaude/${situacaoDeSaude.id}" method="POST">
			<div class="row">
				<div class="input-field s12 col l12">
					<div class="row">
						<div class="input-field s12 col l7">
							<form:input path='nomeDoEntrevistado' type='text'/>
							<form:errors path='nomeDoEntrevistado'/> 
							<label for="nomeDoEntrevistado">Nome do entrevistado:</label>
						</div><!-- // col -->
						<div class="input-field s12 col l5">
							<form:input path='grauDeParentesco' type='text'/>
							<form:errors path='grauDeParentesco'/> 
							<label for="grauDeParentesco">Grau de parentesco:</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:select path="quemEntrevistou">
	                			<form:option  value="${usuario.id}" label="${situacaoDeSaude.quemEntrevistou == null ? 'Usuário' : situacaoDeSaude.quemEntrevistou.nome}" />
								<c:forEach var="usuario" items="${requestScope.usuarios}">
									<option value="${usuario.id}">${usuario.nome}</option>							
								</c:forEach>
							</form:select>
							<label for="quemEntrevistou">Quem Entrevistou?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input id="dataDaEntrevista" path="dataDaEntrevista" type="text" class="validate datepicker" placeholder="Data da Entrevista" /> 
							<form:label path="dataDaEntrevista">Data Da Entrevista</form:label>
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l12">
					Plano de Saúde
					<hr />
					<hr />
					<div class="row">
						<div class="s12 col l12">
							<input type="checkbox" name="possuiConvenioMedicoFamiliar" class="filled-in" id="possuiConvenioMedicoFamiliar" <c:if test="${situacaoDeSaude.possuiConvenioMedicoFamiliar == true}">checked</c:if> />
							<label for="possuiConvenioMedicoFamiliar">Possui convênio médico familiar?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='sePossuiQual' type='text'/>
							<form:errors path='sePossuiQual'/> 
							<label for="sePossuiQual">Se possui, qual?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="s12 col l12">
							<input type="checkbox" name="fornecidoPelaEmpresa" class="filled-in" id="fornecidoPelaEmpresa" <c:if test="${situacaoDeSaude.fornecidoPelaEmpresa == true}">checked</c:if> />
							<label for="fornecidoPelaEmpresa">Fornecido pela empresa?</label>
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l12">
					Em caso de emergência?
					<hr />
					<hr />
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='emCasoDeEmergenciaNome' type='text'/>
							<form:errors path='emCasoDeEmergenciaNome'/> 
							<label for="emCasoDeEmergenciaNome">Nome</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l4">
							<form:input path='emCasoDeEmergenciaGrauDeParentesco' type='text'/>
							<form:errors path='emCasoDeEmergenciaGrauDeParentesco'/> 
							<label for="emCasoDeEmergenciaGrauDeParentesco">Grau de Parentesco</label>
						</div><!-- // col -->
						<div class="input-field s12 col l8">
							<form:input path='emCasoDeEmergenciaTelefones' type='text'/>
							<form:errors path='emCasoDeEmergenciaTelefones'/> 
							<label for="emCasoDeEmergenciaTelefones">Telefones</label>
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l12">
					Situação de Saúde
					<hr />
					<hr />
					<div class="row">
						<div class="input-field s12 col l12">
							<form:textarea path='alergiasContraIndicacoes' />
							<form:errors path='alergiasContraIndicacoes'/> 
							<label for="alergiasContraIndicacoes">Alergias / Contra-Indicações</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:textarea path='medicamentosEmUso' />
							<form:errors path='medicamentosEmUso'/> 
							<label for="medicamentosEmUso">Medicamentos em uso</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="s12 col l12">
							<input type="checkbox" name="diabetes" class="filled-in" id="diabetes" <c:if test="${situacaoDeSaude.diabetes == true}">checked</c:if> />
							<label for="diabetes">Diabetes</label><br />
							<input type="checkbox" name="convulcoes" class="filled-in" id="convulcoes" <c:if test="${situacaoDeSaude.convulcoes == true}">checked</c:if> />
							<label for="convulcoes">Convulções</label><br />
							<input type="checkbox" name="asma" class="filled-in" id="asma" <c:if test="${situacaoDeSaude.asma == true}">checked</c:if> />
							<label for="asma">Asma</label><br />
							<input type="checkbox" name="epilepsia" class="filled-in" id="epilepsia" <c:if test="${situacaoDeSaude.epilepsia == true}">checked</c:if> />
							<label for="epilepsia">Epilepsia</label><br />
							<input type="checkbox" name="hipoglicemia" class="filled-in" id="hipoglicemia" <c:if test="${situacaoDeSaude.hipoglicemia == true}">checked</c:if> />
							<label for="hipoglicemia">Hipoglicemia</label><br />
							<input type="checkbox" name="enxaqueca" class="filled-in" id="enxaqueca" <c:if test="${situacaoDeSaude.enxaqueca == true}">checked</c:if> />
							<label for="enxaqueca">Enxaqueca</label><br />
							<input type="checkbox" name="desmaios" class="filled-in" id="desmaios" <c:if test="${situacaoDeSaude.desmaios == true}">checked</c:if> />
							<label for="desmaios">Desmaios</label><br />
							<input type="checkbox" name="cardiopatias" class="filled-in" id="cardiopatias" <c:if test="${situacaoDeSaude.cardiopatias == true}">checked</c:if> />
							<label for="cardiopatias">Cardiopatias</label><br />
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:textarea path='outrasDoencas' />
							<form:errors path='outrasDoencas'/> 
							<label for="outrasDoencas">Outras Doenças</label>
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l12">
					Observações
					<hr />
					<hr />
					<div class="row">
						<div class="input-field s12 col l12">
							<form:textarea path='situacaoDeSaudeObservacoes' />
							<form:errors path='situacaoDeSaudeObservacoes'/> 
							<label for="situacaoDeSaudeObservacoes">Observações</label>
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			
			<form:hidden path="jovem" value="${jovem.id}" />

			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.situacaoDeSaudeCadastrar == true && requestScope.situacaoDeSaude.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.situacaoDeSaudeEditar == true && requestScope.situacaoDeSaude.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

		</form:form>
		<br />
		<br />
</div><!-- // container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>