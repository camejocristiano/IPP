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
			<a href="/sw/empresa/${empresa.id}">
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

<form:form role="form" commandName="empresa" servletRelativeAction="/empresas/${empresa.id}" method="POST">
	<div class="row">
		<div class="s12 col l2">
			<img src="../../../assets/images/usuario.png" alt="" width="175em" />
		</div><!-- // col -->
		<div class="s12 col l10">
			<div class="row">
				<div class="s12 col l3">
					select
				</div><!-- // col -->
				<div class="s12 col l3">
					select
				</div><!-- // col -->
				<div class="s12 col l3">
					select
				</div><!-- // col -->
				<div class="s12 col l3">
					data
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l6">
					<form:input path='razaoSocial' type='text' />
					<form:errors path='razaoSocial' />
					<label for="razaoSocial">Razão Social</label>
				</div><!-- // col -->
				<div class="s12 col l2">
					select
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l6">
					<form:input path='nomeFantazia' type='text' />
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
			select regiao
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
			<input type="checkbox" class="filled-in" id="vinculoComOIPP" name="vinculoComOIPP" />
			<label for="vinculoComOIPP">Vínculo com o IPP?</label>
		</div><!-- // col -->
	</div><!-- // row -->
	<div class="row">
		<div class="s12 col l6">
			tipoDeParceria select
		</div><!-- // col -->
		<div class="s12 col l6">
			Carga Horária Taxa
		</div><!-- // col -->
	</div><!-- // row -->
	<div class="row">
		<div class="s12 col l4">
			<input type="checkbox" class="filled-in" id="autorizaDivulgacaoDaEmpresaNoSiteDoIpp" name="autorizaDivulgacaoDaEmpresaNoSiteDoIpp" />
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
			<input type="checkbox" class="filled-in" id="valeRefeicao" name="valeRefeicao" />
			<label for="valeRefeicao">Vale Refeição</label>
		</div><!-- // col -->
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="vRCurso" name="vRCurso" />
			<label for="vRCurso">VR Curso?</label>
		</div><!-- // col -->
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="valeAlimentacao" name="valeAlimentacao" />
			<label for="valeAlimentacao">Vale Alimentação</label>
		</div><!-- // col -->
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="assistenciaMedica" name="assistenciaMedica" />
			<label for="assistenciaMedica">Assistência Médica</label>
		</div><!-- // col -->
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="assistenciaOdontologica" name="assistenciaOdontologica" />
			<label for="assistenciaOdontologica">Assistência Odontológica</label>
		</div><!-- // col -->
		<div class="s12 col l2">
			<input type="checkbox" class="filled-in" id="outros" name="outros" />
			<label for="outros">Outros</label>
		</div><!-- // col -->
	</div><!-- // row -->
	<div class="row">
		<div class="s12 col l12">
			Contatos
		</div><!-- // col -->
	</div><!-- // row -->
	<div class="row">
		<div class="s12 col l12">
			Representantes Legais
		</div><!-- // col -->
	</div><!-- // row -->
	<br />
	<hr />
	<button class="btn waves-effect waves-light right" type="submit">
		Salvar<i class="material-icons right">send</i>
	</button>
</form:form>
<br />
<br />
</div>
<c:import url="../../../partials/js.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>