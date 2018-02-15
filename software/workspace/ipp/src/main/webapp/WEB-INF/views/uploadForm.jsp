<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
		<h2>${message}</h2>
	</div>

	<div>
	<c:url value="/sw/usuario/foto/7" var="enviarImagem"></c:url>
		<form method="POST" enctype="multipart/form-data" action="${enviarImagem}">
			<table>
				<tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
				<tr><td></td><td><input type="submit" value="Upload" /></td></tr>
			</table>
		</form>
	</div>
	
	${files}
	
	<c:url value="/sw/arquivo/1mediawave.png" var="mediawavePng3"></c:url>
	<img alt="" src="${mediawavePng3}" width="100em">
	
	<c:url value="/sw/arquivo/Usuario_Cristiano Origem Camejo_21-02-2018_camejocristiano@gmail.com_ipp-logo.png" var="mediawavePng1"></c:url>
	<img alt="" src="${mediawavePng1}" width="100em">
	
	<c:url value="/sw/arquivo/banner.png" var="mediawavePng2"></c:url>
	<img alt="" src="${mediawavePng2}" width="100em">

	<c:url value="/sw/arquivo/grupo_de_permissoes.sql" var="mediawavePng4"></c:url>
	<img alt="" src="${mediawavePng4}" width="100em">
	
	<c:url value="/sw/arquivo/Spring Data JPA - Reference Documentation.html" var="mediawavePng5"></c:url>
	<img alt="" src="${mediawavePng5}" width="100em">

	<c:url value="/sw/arquivo/Resume - Camejo, Cristiano.pdf" var="mediawavePng6"></c:url>
	<img alt="" src="${mediawavePng6}" width="100em">
	
	<c:url value="/sw/arquivo/comandos.txt" var="mediawavePng7"></c:url>
	<img alt="" src="${mediawavePng7}" width="100em">



</body>
</html>