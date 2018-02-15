<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<c:import url="../partials/header.jsp"></c:import>
<div class="row">
	<div class="col s12">
<br><br>
<div class="row">
	<div class="col s12 offset-l4 l4 offset-l4">
		<div class="z-depth-1 grey lighten-4 row"
			style="padding: 32px 48px 32px 48px; border: 1px solid #EEE;">
			<c:url value="/images/ipp-logo.png" var="ippLogoPng" />
			<img class="col s12 l12" src="${ippLogoPng}" />
			<c:url value="/login" var="login" />
			<form action="${login}" method="POST">
				<div class='row'>
					<div class='col s12'>
						<hr />
						<c:if test="${msg != null}">
						<nav>
						    <div class="nav-wrapper">
						      <div class="col s12" style="text-align: center; background-color: ${color}">
						        ${msg}
						      </div>
						    </div>
						  </nav>
						</c:if>
					</div>
				</div>
				<div class='row'>
					<div class='input-field col s12'>
						<input name='username' id='username' type='email' required="required" />
						<label for="username">Username</label>
					</div>
				</div>
				<div class='row'>
					<div class='input-field col s12'>
						<input name='password' id='password' type='password' required="required" />
						<label for="password">Senha</label>
					</div>
					<c:url value="/esqueciMinhaSenha" var="swEsqueciMinhaSenha"></c:url>
					<label style='float: right;'> <a href='${swEsqueciMinhaSenha}'
						style="color: #ccc !important;"><b>Esqueceu a senha?</b></a>
					</label>
				</div>
				<br />
				<div class='row'>
					<div>
						<button type='submit' name='btn_login'
							class='col s12 btn btn-large waves-effect indigo orange'>Autenticar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
</div>

<c:import url="../partials/js.jsp"></c:import>
<c:import url="../partials/final.jsp"></c:import>