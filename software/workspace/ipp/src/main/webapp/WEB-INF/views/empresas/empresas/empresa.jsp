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
			<c:url value="/sw/empresa/${empresa.id != null ? empresa.id : null}" var="swEmpresas"></c:url>
			<a href="${swEmpresas}">
				<h4 class="header right black-text">${empresa.nomeFantazia != null ? empresa.nomeFantazia : "Empresa"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
<c:url value="/sw/empresa/${empresa.nomeFantazia != null ? empresa.id : null}" var="swEmpresaId"></c:url>
<form:form role="form" commandName="empresa" servletRelativeAction="${swEmpresaId}" method="POST">
	<div class="row">
		<div class="s12 col l2">
			<c:url value="/images/usuario.png" var="usuarioPng"></c:url>
			<img src="${usuarioPng}" alt="" width="175em" />
		</div><!-- // col -->
		<div class="s12 col l10">
			<div class="row">
				<div class="s12 col l3">
					<form:select path="vendedor">
                		<form:option  value="${empresa.vendedor}" label="${empresa.vendedor == null ? 'Vendedor' : empresa.vendedor.nome}" />
						<c:forEach var="vendedor" items="${requestScope.usuarios}">
							<option value="${vendedor.id}">${vendedor.nome}</option>							
						</c:forEach>
					</form:select>
				</div><!-- // col -->
				<div class="s12 col l3">
					<form:select path="monitor">
                		<form:option  value="${empresa.monitor}" label="${empresa.monitor == null ? 'Monitor' : empresa.monitor.nome}" />
						<c:forEach var="monitor" items="${requestScope.usuarios}">
							<option value="${monitor.id}">${monitor.nome}</option>							
						</c:forEach>
					</form:select>
				</div><!-- // col -->
				<div class="s12 col l3">
					<form:select path="unidade">
                		<form:option  value="${empresa.unidade}" label="${empresa.unidade == null ? 'Unidade' : empresa.unidade.nomeFantazia}" />
						<c:forEach var="unidade" items="${requestScope.unidades}">
							<option value="${unidade.id}">${unidade.nomeFantazia}</option>							
						</c:forEach>
					</form:select>
				</div><!-- // col -->
				<div class="s12 col l3">
					<form:input id="dataDeCadastro" path="dataDeCadastro" type="text" class="validate datepicker" placeholder="Data de Cadastro" value="${usuario.dataDeNascimento}" /> 
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l6">
					<form:input path='razaoSocial' type='text' />
					<form:errors path='razaoSocial' />
					<label for="razaoSocial">Razão Social</label>
				</div><!-- // col -->
				<div class="input-field s12 col l6">
					<form:select path="tipoDeEmpresa">
                    	<form:option value="${empresa.tipoDeEmpresa}" label="${empresa.tipoDeEmpresa == null ? 'Tipo de Empresa' : empresa.tipoDeEmpresa}" />
						<c:forEach var="tipoDeEmpresa" items="${requestScope.tiposDeEmpresas}">
							<form:option value="${tipoDeEmpresa}">${tipoDeEmpresa}</form:option>							
						</c:forEach>
					</form:select>	
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l6">
					<form:input path='nomeFantazia' type='text' required="required" />
					<form:errors path='nomeFantazia' />
					<label for="nomeFantazia">Nome Fantazia</label>
				</div><!-- // col -->
				<div class="input-field s12 col l6">
					<form:input path='cNPJ' type='text' />
					<form:errors path='cNPJ' />
					<label for="cNPJ">CNPJ</label>
				</div><!-- // col -->				
			</div><!-- // row -->
		</div><!-- // col -->
	</div><!-- // row -->
	<div class="row">
		<div class="input-field s12 col l4">
			<form:input path='endereco' type='text' />
			<form:errors path='endereco' />
			<label for="endereco">Endereço</label>
		</div><!-- // col -->
		<div class="input-field s12 col l4">
			<form:input path='complemento' type='text' />
			<form:errors path='complemento' />
			<label for="complemento">Complemento</label>
		</div><!-- // col -->
		<div class="input-field s12 col l4">
			<form:input path='bairro' type='text' />
			<form:errors path='bairro' />
			<label for="bairro">Bairro</label>
		</div><!-- // col -->
	</div><!-- // row -->
	<div class="row">
		<div class="input-field s12 col l4">
			<form:input path='estado' type='text' />
			<form:errors path='estado' />
			<label for="estado">Estado</label>
		</div><!-- // col -->
		<div class="input-field s12 col l4">
			<form:input path='cidade' type='text' />
			<form:errors path='cidade' />
			<label for="cidade">Cidade</label>
		</div><!-- // col -->
		<div class="input-field s12 col l4">
			<form:input path='cEP' type='text' />
			<form:errors path='cEP' />
			<label for="cEP">CEP</label>
		</div><!-- // col -->
	</div><!-- // row -->
		<div class="row">
		<div class="input-field s12 col l4">
			<form:input path='telefone' type='text' />
			<form:errors path='telefone' />
			<label for="telefone">Telefone</label>
		</div><!-- // col -->
		<div class="input-field s12 col l4">
			<form:input path='fax' type='text' />
			<form:errors path='fax' />
			<label for="fax">Fax</label>
		</div><!-- // col -->
		<div class="input-field s12 col l4">
			<form:select path="regiao">
               	<form:option value="${empresa.regiao}" label="${empresa.regiao == null ? 'Região' : empresa.regiao}" />
				<c:forEach var="regiao" items="${requestScope.regioes}">
					<form:option value="${regiao}">${regiao}</form:option>							
				</c:forEach>
			</form:select>
		</div><!-- // col -->
	</div><!-- // row -->
	<div class="row">
		<div class="input-field s12 col l4">
			<form:input path='site' type='text' />
			<form:errors path='site' />
			<label for="site">Site</label>
		</div><!-- // col -->
		<div class="input-field s12 col l4">
			<form:input path='dataDeVencimentoDaFatura' type='text' />
			<form:errors path='dataDeVencimentoDaFatura' />
			<label for="dataDeVencimentoDaFatura">Data de Vencimento da Fatura</label>
		</div><!-- // col -->
		<div class="s12 col l1">
		</div><!-- // col -->
		<div class="s12 col l3">
			<input type="checkbox" class="filled-in" id="vinculoComOIPP" name="vinculoComOIPP" <c:if test="${empresa.vinculoComOIPP == true}">checked</c:if> />
			<label for="vinculoComOIPP">Vínculo com o IPP?</label>
		</div><!-- // col -->
	</div><!-- // row -->
	<div class="row">
		<div class="s12 col l12">
			<form:select path="tipoDeParceria">
               	<form:option value="${empresa.tipoDeParceria}" label="${empresa.tipoDeParceria == null ? 'Tipo de Parceria' : empresa.tipoDeParceria}" />
				<c:forEach var="tipoDeParceria" items="${requestScope.tiposDeParceria}">
					<form:option value="${tipoDeParceria}">${tipoDeParceria}</form:option>							
				</c:forEach>
			</form:select>
		</div><!-- // col -->
	</div><!-- // row -->
	<div class="row">
		<div class="s12 col l4">
			<input type="checkbox" class="filled-in" id="autorizaDivulgacaoDaEmpresaNoSiteDoIpp" name="autorizaDivulgacaoDaEmpresaNoSiteDoIpp" <c:if test="${empresa.autorizaDivulgacaoDaEmpresaNoSiteDoIpp == true}">checked</c:if> />
			<label for="autorizaDivulgacaoDaEmpresaNoSiteDoIpp">Autoriza divulgação da Empresa no site do IPP?</label>
		</div><!-- // col -->
		<div class="s12 col l4">
			Soma dos jovens ativos na empresa			
		</div><!-- // col -->
		<div class="s12 col l4">
			Soma dos jovens que já passaram pela empresa
		</div><!-- // col -->
	</div><!-- // row -->
	<div class="row">
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="valeRefeicao" name="valeRefeicao" <c:if test="${empresa.valeRefeicao == true}">checked</c:if> />
			<label for="valeRefeicao">Vale Refeição</label>
		</div><!-- // col -->
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="vRCurso" name="vRCurso" <c:if test="${empresa.vRCurso == true}">checked</c:if>  />
			<label for="vRCurso">VR Curso?</label>
		</div><!-- // col -->
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="valeAlimentacao" name="valeAlimentacao" <c:if test="${empresa.valeAlimentacao == true}">checked</c:if>  />
			<label for="valeAlimentacao">Vale Alimentação</label>
		</div><!-- // col -->
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="assistenciaMedica" name="assistenciaMedica" <c:if test="${empresa.assistenciaMedica == true}">checked</c:if>  />
			<label for="assistenciaMedica">Assistência Médica</label>
		</div><!-- // col -->
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="assistenciaOdontologica" name="assistenciaOdontologica" <c:if test="${empresa.assistenciaOdontologica == true}">checked</c:if>  />
			<label for="assistenciaOdontologica">Assistência Odontológica</label>
		</div><!-- // col -->
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="outros" name="outros" <c:if test="${empresa.outros == true}">checked</c:if> />
			<label for="outros">Outros</label>
		</div><!-- // col -->
	</div><!-- // row -->
	<br />
	<br />
	
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.empresaCadastrar == true && requestScope.empresa.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.empresaEditar == true && requestScope.empresa.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
	
</form:form>
<br />
<br />
</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>