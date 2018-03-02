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
			<c:url value="/sw/jovem/${dadosFinanceiros.jovem == null ? jovem.id : dadosFinanceiros.jovem.id}" var="swJovemJovemId"></c:url>
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
		<c:url value="/sw/dadosFinanceiros/${dadosFinanceiros.observacoes != null ? dadosFinanceiros.id : null}" var="swDadosFinanceirosId"></c:url>
		<form:form role="form" commandName="dadosFinanceiros" servletRelativeAction="${swDadosFinanceirosId}" method="POST">
			<form:hidden path='jovem' value="${dadosFinanceiros.jovem != null ? dadosFinanceiros.jovem.id : jovem.id}" />
			<div class="row">
				<div class="col s12 l6">
					<div class="row">
						<div class="col s12">
						Dados Salariais
						<hr /><hr /><br />
							<div class="row">
								<div class="input-field s12 col l6">
									<form:input path='dadosSalariais_salarioRS' type='text' />
									<form:errors path='dadosSalariais_salarioRS'/> 
									<label for="dadosSalariais_salarioRS">Salário: R$</label>
								</div>
								<div class="input-field s12 col l6">
									<form:input path='dadosSalariais_salarioSMF' type='text'/>
									<form:errors path='dadosSalariais_salarioSMF'/> 
									<label for="dadosSalariais_salarioSMF">Salário: % SMF</label>
								</div>
							</div>	
							<div class="row">
								<div class="input-field s12 col l12">
									<form:select path="dadosSalariais_administradoPor">
					                	<form:option value="${dadosSalariais_administradoPor}" label="${dadosFinanceiros.dadosSalariais_administradoPor == null ? 'Administrado Por: ' : dadosFinanceiros.dadosSalariais_administradoPor}" />
										<c:forEach var="dadosSalariais_administradoPor" items="${requestScope.tiposDeContratacoes}">
											<option>${dadosSalariais_administradoPor}</option>							
										</c:forEach>
									</form:select>
									<label for="dadosSalariais_administradoPor">Administrado Por: </label>
								</div>
							</div>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="col s12">
						Conta Salário
						<hr /><hr /><br />
							<div class="row">
								<div class="input-field s12 col l6">
									<form:input path='contaSalario_banco' type='text'/>
									<form:errors path='contaSalario_banco'/> 
									<label for="contaSalario_banco">Banco</label>
								</div>
								<div class="input-field s12 col l6">
									<form:input path='contaSalario_numeroDoBanco' type='text'/>
									<form:errors path='contaSalario_numeroDoBanco'/> 
									<label for="contaSalario_numeroDoBanco">Nº do Banco</label>
								</div>
							</div>	
							<div class="row">
								<div class="input-field s12 col l6">
									<form:input path='contaSalario_agencia' type='text'/>
									<form:errors path='contaSalario_agencia'/> 
									<label for="contaSalario_agencia">Agência</label>
								</div>
								<div class="input-field s12 col l6">
									<form:input path='contaSalario_cs' type='text'/>
									<form:errors path='contaSalario_cs'/> 
									<label for="contaSalario_cs">C/S</label>
								</div>
							</div>	
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="col s12">
						Conta Corrente
						<hr /><hr /><br />
							<div class="row">
								<div class="input-field s12 col l6">
									<form:input path='contaCorrente_banco' type='text'/>
									<form:errors path='contaCorrente_banco'/> 
									<label for="contaCorrente_banco">Banco</label>
								</div>
								<div class="input-field s12 col l6">
									<form:input path='contaCorrente_numeroDoBanco' type='text'/>
									<form:errors path='contaCorrente_numeroDoBanco'/> 
									<label for="contaCorrente_numeroDoBanco">Nº do Banco</label>
								</div>
							</div>	
							<div class="row">
								<div class="input-field s12 col l6">
									<form:input path='contaCorrente_agencia' type='text'/>
									<form:errors path='contaCorrente_agencia'/> 
									<label for="contaCorrente_agencia">Agência</label>
								</div>
								<div class="input-field s12 col l6">
									<form:input path='contaCorrente_cc' type='text'/>
									<form:errors path='contaCorrente_cc'/> 
									<label for="contaCorrente_cc">C/S</label>
								</div>
							</div>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="col s12">
						Vale Refeição
						<hr /><hr /><br />
							<div class="row">
								<div class="col s12 l8">
									Usa vale refeição?
								</div>
								<div class="col s6 l4">
									<input type="checkbox" name="valeRefeicao_usaValeRefeicao" class="filled-in" id="valeRefeicao_usaValeRefeicao" <c:if test="${dadosFinanceiros.valeRefeicao_usaValeRefeicao == true}">checked</c:if> />
									<label for="valeRefeicao_usaValeRefeicao">Sim</label>
								</div>
							</div>
							<div class="row">
								<div class="col s4">
									Valor IPP:
								</div>
								<div class="input-field col s4">
									<form:input path="valeRefeicao_valorIPPRS" />
									<form:label path="valeRefeicao_valorIPPRS">R$</form:label>
								</div>
								<div class="input-field col s4">
									<form:select path="valeRefeicao_valorIPPRSPeriodo">
					                	<form:option value="${dadosFinanceiros.valeRefeicao_valorIPPRSPeriodo}" label="${dadosFinanceiros.valeRefeicao_valorIPPRSPeriodo == null ? 'Período: ' : dadosFinanceiros.valeRefeicao_valorIPPRSPeriodo}" />
										<c:forEach var="periodo" items="${requestScope.periodos}">
											<option>${periodo}</option>							
										</c:forEach>
									</form:select>
									<label for="valeRefeicao_valorIPPRSPeriodo">Período: </label>
								</div>
							</div>
							<div class="row">
								<div class="col s4">
									Valor IPP:
								</div>
								<div class="input-field col s4">
									<form:input path="valeRefeicao_valorIPPSMF" />
									<form:label path="valeRefeicao_valorIPPSMF">SMF %</form:label>
								</div>
								<div class="input-field col s4">
									<form:select path="valeRefeicao_valorIPPSMFPeriodo">
					                	<form:option value="${dadosFinanceiros.valeRefeicao_valorIPPSMFPeriodo}" label="${dadosFinanceiros.valeRefeicao_valorIPPSMFPeriodo == null ? 'Período: ' : dadosFinanceiros.valeRefeicao_valorIPPSMFPeriodo}" />
										<c:forEach var="periodo" items="${requestScope.periodos}">
											<option>${periodo}</option>							
										</c:forEach>
									</form:select>
									<label for="valeRefeicao_valorIPPSMFPeriodo">Período: </label>
								</div>
							</div>
							<div class="row">
								<div class="s12 col l12">
									<form:select path="valeRefeicaoIPP_administradoPor">
					                	<form:option value="${dadosFinanceiros.valeRefeicaoIPP_administradoPor}" label="${dadosFinanceiros.valeRefeicaoIPP_administradoPor == null ? 'Administrado Por: ' : dadosFinanceiros.valeRefeicaoIPP_administradoPor}" />
										<c:forEach var="valeRefeicaoIPP_administradoPor" items="${requestScope.tiposDeContratacoes}">
											<option>${valeRefeicaoIPP_administradoPor}</option>							
										</c:forEach>
									</form:select>
									<label for="valeRefeicaoIPP_administradoPor">Administrado Por: </label>
								</div>
							</div>
							<div class="row">
								<div class="col s4">
									Valor Empresa:
								</div>
								<div class="input-field col s4">
									<form:input path="valeRefeicao_valorEmpresaRS" />
									<form:label path="valeRefeicao_valorEmpresaRS">R$</form:label>
								</div>
								<div class="input-field col s4">
									<form:select path="valeRefeicao_valorEmpresaRSPeriodo">
					                	<form:option value="${dadosFinanceiros.valeRefeicao_valorEmpresaRSPeriodo}" label="${dadosFinanceiros.valeRefeicao_valorEmpresaRSPeriodo == null ? 'Período: ' : dadosFinanceiros.valeRefeicao_valorEmpresaRSPeriodo}" />
										<c:forEach var="periodo" items="${requestScope.periodos}">
											<option>${periodo}</option>							
										</c:forEach>
									</form:select>
									<label for="valeRefeicao_valorEmpresaRSPeriodo">Período: </label>
								</div>
							</div>
							<div class="row">
								<div class="col s4">
									Valor Empresa:
								</div>
								<div class="input-field col s4">
									<form:input path="valeRefeicao_valorEmpresaSMF" />
									<form:label path="valeRefeicao_valorEmpresaSMF">SMF %</form:label>
								</div>
								<div class="input-field col s4">
									<form:select path="valeRefeicao_valorEmpresaSMFPeriodo">
					                	<form:option value="${dadosFinanceiros.valeRefeicao_valorEmpresaSMFPeriodo}" label="${dadosFinanceiros.valeRefeicao_valorEmpresaSMFPeriodo == null ? 'Período: ' : dadosFinanceiros.valeRefeicao_valorEmpresaSMFPeriodo}" />
										<c:forEach var="periodo" items="${requestScope.periodos}">
											<option>${periodo}</option>							
										</c:forEach>
									</form:select>
									<label for="valeRefeicao_valorEmpresaSMFPeriodo">Período: </label>
								</div>
							</div>
							<div class="row">
								<div class="s12 col l12">
									<form:select path="valeRefeicaoEmpresa_administradoPor">
					                	<form:option value="${dadosFinanceiros.valeRefeicaoEmpresa_administradoPor}" label="${dadosFinanceiros.valeRefeicaoEmpresa_administradoPor == null ? 'Administrado Por: ' : dadosFinanceiros.valeRefeicaoEmpresa_administradoPor}" />
										<c:forEach var="valeRefeicaoEmpresa_administradoPor" items="${requestScope.tiposDeContratacoes}">
											<option>${valeRefeicaoEmpresa_administradoPor}</option>							
										</c:forEach>
									</form:select>
									<label for="valeRefeicaoIPP_administradoPor">Administrado Por: </label>
								</div>
							</div>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="col s12">
						Vale Alimentação
						<hr /><hr /><br />
							<div class="row">
								<div class="col s12 l8">
									Usa vale Alimentação?
								</div>
								<div class="col s6 l4">
									<input type="checkbox" name="valeAlimentacao_usa" class="filled-in" id="valeAlimentacao_usa" <c:if test="${dadosFinanceiros.valeAlimentacao_usa == true}">checked</c:if> />
									<label for="valeAlimentacao_usa">Sim</label>
								</div>
							</div>
							<div class="row">
								<div class="col s4">
									Valor:
								</div>
								<div class="input-field col s4">
									<form:input path="valeAlimentacao_valorRS" />
									<form:label path="valeAlimentacao_valorRS">R$</form:label>
								</div>
								<div class="input-field col s4">
									<form:select path="valeAlimentacao_valorRSPeriodo">
					                	<form:option value="${dadosFinanceiros.valeAlimentacao_valorRSPeriodo}" label="${dadosFinanceiros.valeAlimentacao_valorRSPeriodo == null ? 'Período: ' : dadosFinanceiros.valeAlimentacao_valorRSPeriodo}" />
										<c:forEach var="periodo" items="${requestScope.periodos}">
											<option>${periodo}</option>							
										</c:forEach>
									</form:select>
									<label for="valeAlimentacao_valorRSPeriodo">Período: </label>
								</div>
							</div>
							<div class="row">
								<div class="col s4">
									Valor:
								</div>
								<div class="input-field col s4">
									<form:input path="valeAlimentacao_valorSMF" />
									<form:label path="valeAlimentacao_valorSMF">SMF %</form:label>
								</div>
								<div class="input-field col s4">
									<form:select path="valeAlimentacao_valorSMFPeriodo">
					                	<form:option value="${dadosFinanceiros.valeAlimentacao_valorSMFPeriodo}" label="${dadosFinanceiros.valeAlimentacao_valorSMFPeriodo == null ? 'Período: ' : dadosFinanceiros.valeAlimentacao_valorSMFPeriodo}" />
										<c:forEach var="periodo" items="${requestScope.periodos}">
											<option>${periodo}</option>							
										</c:forEach>
									</form:select>
									<label for="valeAlimentacao_valorSMFPeriodo">Período: </label>
								</div>
							</div>
							<div class="row">
								<div class="s12 col l12">
									<form:select path="valeAlimentacao_administradoPor">
					                	<form:option value="${dadosFinanceiros.valeAlimentacao_administradoPor}" label="${dadosFinanceiros.valeAlimentacao_administradoPor == null ? 'Administrado Por: ' : dadosFinanceiros.valeAlimentacao_administradoPor}" />
										<c:forEach var="valeAlimentacao_administradoPor" items="${requestScope.tiposDeContratacoes}">
											<option>${valeAlimentacao_administradoPor}</option>							
										</c:forEach>
									</form:select>
									<label for="valeAlimentacao_administradoPor">Administrado Por: </label>
								</div>
							</div>
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col Up Left -->
				<div class="col s12 l6">
					<div class="row">
						<div class="col s12">
						Vale Transporte Empresa Trabalho
						<hr /><hr /><br />
							<div class="row">
								<div class="s12 col l8">
								Usa vale transporte entre empresa e trabalho?
								</div>
								<div class="s12 col l4">
									<div class="row">
										<div class="col s12">
											<input type="checkbox" name="valeTransporteEmpresaTrabalho_usa" class="filled-in" id="valeTransporteEmpresaTrabalho_usa" <c:if test="${dadosFinanceiros.valeTransporteEmpresaTrabalho_usa == true}">checked</c:if> />
											<label for="valeTransporteEmpresaTrabalho_usa">Sim</label>
										</div>
									</div>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="s12 col l2">
								Tipo:
								</div>
								<div class="s12 col l10">
									<div class="row">
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteEmpresaTrabalho_metro" class="filled-in" id="valeTransporteEmpresaTrabalho_metro" <c:if test="${dadosFinanceiros.valeTransporteEmpresaTrabalho_metro == true}">checked</c:if> />
											<label for="valeTransporteEmpresaTrabalho_metro">Metrô</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteEmpresaTrabalho_metroValor" type="text" />
											<form:label path="valeTransporteEmpresaTrabalho_metroValor">R$</form:label>
										</div>
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteEmpresaTrabalho_trem" class="filled-in" id="valeTransporteEmpresaTrabalho_trem" <c:if test="${dadosFinanceiros.valeTransporteEmpresaTrabalho_trem == true}">checked</c:if> />
											<label for="valeTransporteEmpresaTrabalho_trem">Trem</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteEmpresaTrabalho_tremValor"/>
											<form:label path="valeTransporteEmpresaTrabalho_tremValor">R$</form:label>
										</div>
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteEmpresaTrabalho_onibusMunicipal" class="filled-in" id="valeTransporteEmpresaTrabalho_onibusMunicipal" <c:if test="${dadosFinanceiros.valeTransporteEmpresaTrabalho_onibusMunicipal == true}">checked</c:if> />
											<label for="valeTransporteEmpresaTrabalho_onibusMunicipal">Ônibus Municipal</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteEmpresaTrabalho_onibusMunicipalValor"/>
											<form:label path="valeTransporteEmpresaTrabalho_onibusMunicipalValor">R$</form:label>
										</div>
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteEmpresaTrabalho_integracao" class="filled-in" id="valeTransporteEmpresaTrabalho_integracao" <c:if test="${dadosFinanceiros.valeTransporteEmpresaTrabalho_integracao == true}">checked</c:if> />
											<label for="valeTransporteEmpresaTrabalho_integracao">Integração</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteEmpresaTrabalho_integracaoValor"/>
											<form:label path="valeTransporteEmpresaTrabalho_integracaoValor">R$</form:label>
										</div>
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteEmpresaTrabalho_bom" class="filled-in" id="valeTransporteEmpresaTrabalho_bom" <c:if test="${dadosFinanceiros.valeTransporteEmpresaTrabalho_bom == true}">checked</c:if> />
											<label for="valeTransporteEmpresaTrabalho_bom">Bom</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteEmpresaTrabalho_bomValor"/>
											<form:label path="valeTransporteEmpresaTrabalho_bomValor">R$</form:label>
										</div>
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteEmpresaTrabalho_bem" class="filled-in" id="valeTransporteEmpresaTrabalho_bem" <c:if test="${dadosFinanceiros.valeTransporteEmpresaTrabalho_bem == true}">checked</c:if> />
											<label for="valeTransporteEmpresaTrabalho_bem">Bem</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteEmpresaTrabalho_bemValor"/>
											<form:label path="valeTransporteEmpresaTrabalho_bemValor">R$</form:label>
										</div>
									</div>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l12">
									Vale transporte empresa R$ ${requestScope.totalEmpresa} por dia.
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l12">
									<form:select path="valeTransporteEmpresaTrabalho_administradoPor">
										<form:option value="${dadosFinanceiros.valeTransporteEmpresaTrabalho_administradoPor}" label="${dadosFinanceiros.valeTransporteEmpresaTrabalho_administradoPor == null ? 'Administrado Por: ' : dadosFinanceiros.valeTransporteEmpresaTrabalho_administradoPor}" />
										<c:forEach var="valeTransporteEmpresaTrabalho_administradoPor" items="${requestScope.tiposDeContratacoes}">
											<option>${valeTransporteEmpresaTrabalho_administradoPor}</option>							
										</c:forEach>
									</form:select>
									<label for="valeTransporteEmpresaTrabalho_administradoPor">Administrado Por: </label>
								</div><!-- // col -->
							</div><!-- // row -->
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="col s12">
						Vale Transporte Ipp Curso
						<hr /><hr /><br />
							<div class="row">
								<div class="s12 col l12">
									<div class="row">
										<div class="s12 col l8">
											Usa vale transporte?
										</div>
										<div class="s12 col l4">
											<div class="row">
												<div class="col s12">
													<input type="checkbox" name="valeTransporteEmpresaTrabalho_usa" class="filled-in" id="valeTransporteEmpresaTrabalho_usa" <c:if test="${dadosFinanceiros.valeTransporteEmpresaTrabalho_usa == true}">checked</c:if> />
													<label for="valeTransporteEmpresaTrabalho_usa">Sim</label>
												</div>
											</div>
										</div>
									</div>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="s12 col l2">
									Tipo:
								</div>
								<div class="s12 col l10">
									<div class="row">
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteIPPCurso_metro" class="filled-in" id="valeTransporteIPPCurso_metro" <c:if test="${dadosFinanceiros.valeTransporteIPPCurso_metro == true}">checked</c:if> />
											<label for="valeTransporteIPPCurso_metro">Metrô</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteIPPCurso_metroValor"/>
											<form:label path="valeTransporteIPPCurso_metroValor">R$</form:label>
										</div>
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteIPPCurso_trem" class="filled-in" id="valeTransporteIPPCurso_trem" <c:if test="${dadosFinanceiros.valeTransporteIPPCurso_trem == true}">checked</c:if> />
											<label for="valeTransporteIPPCurso_trem">Trem</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteIPPCurso_tremValor"/>
											<form:label path="valeTransporteIPPCurso_tremValor">R$</form:label>
										</div>
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteIPPCurso_onibusMunicipal" class="filled-in" id="valeTransporteIPPCurso_onibusMunicipal" <c:if test="${dadosFinanceiros.valeTransporteIPPCurso_onibusMunicipal == true}">checked</c:if> />
											<label for="valeTransporteIPPCurso_onibusMunicipal">Ônibus Municipal</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteIPPCurso_onibusMunicipalValor"/>
											<form:label path="valeTransporteIPPCurso_onibusMunicipalValor">R$</form:label>
										</div>
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteIPPCurso_integracao" class="filled-in" id="valeTransporteIPPCurso_integracao" <c:if test="${dadosFinanceiros.valeTransporteIPPCurso_integracao == true}">checked</c:if> />
											<label for="valeTransporteIPPCurso_integracao">Integração</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteIPPCurso_integracaoValor"/>
											<form:label path="valeTransporteIPPCurso_integracaoValor">R$</form:label>
										</div>
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteIPPCurso_bom" class="filled-in" id="valeTransporteIPPCurso_bom" <c:if test="${dadosFinanceiros.valeTransporteIPPCurso_bom == true}">checked</c:if> />
											<label for="valeTransporteIPPCurso_bom">Bom</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteIPPCurso_bomValor"/>
											<form:label path="valeTransporteIPPCurso_bomValor">R$</form:label>
										</div>
										<div class="s12 col l6">
											<input type="checkbox" name="valeTransporteIPPCurso_bem" class="filled-in" id="valeTransporteIPPCurso_bem" <c:if test="${dadosFinanceiros.valeTransporteIPPCurso_bem == true}">checked</c:if> />
											<label for="valeTransporteIPPCurso_bem">Bem</label>
										</div>
										<div class="input-field s12 col l6">
											<form:input path="valeTransporteIPPCurso_bemValor"/>
											<form:label path="valeTransporteIPPCurso_bemValor">R$</form:label>
										</div>
									</div>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l12">
									Vale transporte curso R$ ${requestScope.totalIPP} por dia.
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l12">
									<form:select path="valeTransporteIPPCurso_administradoPor">
							           	<form:option value="${dadosFinanceiros.valeTransporteIPPCurso_administradoPor}" label="${dadosFinanceiros.valeTransporteIPPCurso_administradoPor == null ? 'Administrado Por: ' : dadosFinanceiros.valeTransporteIPPCurso_administradoPor}" />
										<c:forEach var="valeTransporteIPPCurso_administradoPor" items="${requestScope.tiposDeContratacoes}">
											<option>${valeTransporteIPPCurso_administradoPor}</option>							
										</c:forEach>
									</form:select>
									<label for="valeTransporteIPPCurso_administradoPor">Administrado Por: </label>
								</div><!-- // col -->
							</div><!-- // row -->							
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="col s12">
						Assistencia Médica
						<hr /><hr /><br />
							<div class="row">
								<div class="s12 col l4">
									<div class="row">
										<div class="col s12">
											<input type="checkbox" name="assistenciaMedica_possui" class="filled-in" id="assistenciaMedica_possui" <c:if test="${dadosFinanceiros.assistenciaMedica_possui == true}">checked</c:if> />
											<label for="assistenciaMedica_possui">Sim</label>
										</div>
									</div>
								</div><!-- // col -->
								<div class="input-field s12 col l8">
									<form:input path="assistenciaMedica_valor"/>
									<form:label path="assistenciaMedica_valor">R$ </form:label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l12">
									<form:select path="assistenciaMedica_administradoPor">
					                	<form:option value="${dadosSalariais_administradoPor}" label="${dadosFinanceiros.assistenciaMedica_administradoPor == null ? 'Administrado Por: ' : dadosFinanceiros.assistenciaMedica_administradoPor}" />
										<c:forEach var="assistenciaMedica_administradoPor" items="${requestScope.tiposDeContratacoes}">
											<option>${assistenciaMedica_administradoPor}</option>							
										</c:forEach>
									</form:select>
									<label for="assistenciaMedica_administradoPor">Administrado Por: </label>
								</div><!-- // col -->
							</div><!-- // row -->
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="col s12">
						Assistência Odontológica
						<hr /><hr /><br />
							<div class="row">
								<div class="s12 col l4">
									<div class="row">
										<div class="col s12">
											<input type="checkbox" name="assistenciaOdontologica_possui" class="filled-in" id="assistenciaOdontologica_possui" <c:if test="${dadosFinanceiros.assistenciaOdontologica_possui == true}">checked</c:if> />
											<label for="assistenciaOdontologica_possui">Sim</label>
										</div>
									</div>
								</div><!-- // col -->
								<div class="input-field s12 col l8">
									<form:input path="assistenciaOdontologica_valor"/>
									<form:label path="assistenciaOdontologica_valor">R$ </form:label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l12">
									<form:select path="assistenciaOdontologica_administradoPor">
					                	<form:option value="${dadosSalariais_administradoPor}" label="${dadosFinanceiros.assistenciaOdontologica_administradoPor == null ? 'Administrado Por: ' : dadosFinanceiros.assistenciaOdontologica_administradoPor}" />
										<c:forEach var="assistenciaOdontologica_administradoPor" items="${requestScope.tiposDeContratacoes}">
											<option>${assistenciaOdontologica_administradoPor}</option>							
										</c:forEach>
									</form:select>
									<label for="assistenciaMedica_administradoPor">Administrado Por: </label>
								</div><!-- // col -->
							</div><!-- // row -->
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col Up Right -->
			</div><!-- // row Up -->
			<div class="row">
				<div class="col s12 l12">
				 Observações
				 <hr /><hr /><br />
				 <form:textarea path="observacoes" value="${dadosFinanceiros.observacoes}" required="required"/>
				</div><!-- // col Down -->
			</div><!-- // row Down -->
			<hr /><hr /><br />
			<form:hidden path="jovem" value="${dadosFinanceiros.jovem == null ? jovem.id : dadosFinanceiros.jovem.id}" />
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.arcoCadastrar == true && requestScope.arcoOcupacional.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.arcoEditar == true && requestScope.arcoOcupacional.id != null}">
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