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
			<c:url value="/sw/empresa/${gestor.empresa.id != null ? gestor.empresa.id : empresa.id}" var="swEmpresaId"></c:url>
			<a href="${swEmpresaId}">
				<h4 class="header right black-text">${gestor.nome != null ? gestor.nome : empresa.nomeFantazia}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
		<c:url value="/sw/gestor/${gestor.nome != null ? gestor.id : null}" var="swGestorId"></c:url>
		<form:form role="form" commandName="gestor" servletRelativeAction="${swGestorId}" method="POST">
<div class="row">
<div class="s12 col l2">
			<c:url value="/images/usuario.png" var="usuarioPng"></c:url>
			<img src="${usuarioPng}" alt="" width="175em" />
		</div><!-- // col -->
		<div class="s12 col l10">
			<div class="row">
				<div class="input-field s12 col l7">
					<form:input path='nome' type='text'/>
					<form:errors path='nome'/> 
					<label for="nome">Nome</label>
				</div><!-- // col -->
				<div class="input-field s12 col l3">
					<form:input path='telefone' type='text'/>
					<form:errors path='telefone'/> 
					<label for="telefone">Telefone</label>
				</div><!-- // col -->
				<div class="input-field s12 col l2">
					<form:input path='ramal' type='text'/>
					<form:errors path='ramal'/> 
					<label for="ramal">Ramal</label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='username' type='email' />
					<form:errors path='username' />
					<label for="username">Email</label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l7">
					<form:select path="empresa">
                		<form:option  value="${gestor.empresa}" label="${gestor.empresa == null ? 'Empresa' : gestor.empresa.nomeFantazia}" />
						<c:forEach var="empresa" items="${requestScope.empresas}">
							<option value="${empresa.id}">${empresa.nomeFantazia}</option>							
						</c:forEach>
					</form:select>
				<div class="input-field s12 col l5">
				</div><!-- // col -->	
					<form:select path="status">
		                    	<form:option value="${gestor.status}" label="${gestor.status == null ? 'Status' : gestor.status}" />
								<c:forEach var="status" items="${requestScope.status}">
									<form:option value="${status}">${status}</form:option>							
								</c:forEach>
							</form:select>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l6">
					<c:if test="${usuarioSessao.username == gestor.username}">
						<a class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Link para alteração da senha!"><i class="material-icons" style="color: #222 !important;">info_outline</i></a>
						<c:url value="/sw/alterarSenha" var="swAlterarSenha"></c:url>
						<a href="${swAlterarSenha}">Alterar Senha</a>
					</c:if>
				</div><!-- // col -->
				<div class="s12 col l6">
					<div class="row">
						<div class="s12 col l12">
							<input type="checkbox" class="filled-in" id="permitirQueVisualizeTodosOsJovens" name="permitirQueVisualizeTodosOsJovens" <c:if test="${gestor.permitirQueVisualizeTodosOsJovens == true}">checked</c:if> />
							<label for="permitirQueVisualizeTodosOsJovens">Permitir que visualize todos os Jovens</label>
						</div><!-- // col -->				
						<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.grupoDePermissoesCadastrar == true
	                 		   || requestScope.usuarioSessao.grupoDePermissoes.grupoDePermissoesEditar == true}">
							<div class="input-field col s12 l12">
			                	<form:select path="grupoDePermissoes">
		                			<form:option  value="${usuarioSessao.grupoDePermissoes}" label="Grupo de Permissões" />
									<c:forEach var="grupoDePermissoes" items="${requestScope.gruposDePermissoes}">
										<option value="${grupoDePermissoes.id}">${grupoDePermissoes.grupo}</option>							
									</c:forEach>
								</form:select>
							</div><!-- // col -->
			                <div class="col s12 l12">
			                	<a style="margin-left: 2em; float: right" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Caso este esteja selecionado, mostrará as listas gerais, de todas as unidades."><i class="material-icons" style="color: #222 !important;">info_outline</i></a>
			                	<input type="checkbox" name="admin" class="filled-in" id="admin" <c:if test="${gestor.admin == true}">checked</c:if> />
								<label style="margin-left: 2em; float: right" for="admin">Admin</label>
							</div><!-- // col -->			
						</c:if>
					</div><!-- // row -->
				</div><!-- // col -->				
			</div><!-- // row -->
		</div><!-- // col -->
	</div><!-- // row -->
			<input type="hidden" name="password" value="${gestor.password}" />
			<form:input path='empresa' type='hidden' value="${empresa.id}" />
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.usuarioCadastrar == true && requestScope.usuario.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.usuarioEditar == true && requestScope.usuario.id != null}">
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