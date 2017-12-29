<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

	<h2>Unidade</h2>
	<p>${requestScope.msg}</p>
	<a href="/unidades">Retornar à listagem</a>
	<form action="/unidades/${requestScope.unidade.id}" method="post">

		<input type="hidden" name="id" value="${requestScope.unidade.id}" />
		<input type="text" name="razaoSocial"
			value="${requestScope.unidade.razaoSocial}" /> <input type="text"
			name="nomeFantazia" value="${requestScope.unidade.nomeFantazia}" />
		<input type="text" name="email" value="${requestScope.unidade.email}" />

		<button type="submit">Salvar</button>
	</form>

<c:import url="../../../partials/footer.jsp"></c:import>