<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>IPP</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">  
<c:url value="/css/materialize.css" var="materializeCss" />
<link href="${materializeCss}" type="text/css" rel="stylesheet" media="screen,projection" />
<c:url value="/css/style.css" var="styleCss" />
<link href="${styleCss}" type="text/css" rel="stylesheet" media="screen,projection" />
<c:url value="/css/jquery.dataTables.min.css" var="jqueryDataTablesMinCss" />
<link href="${jqueryDataTablesMinCss}" rel="stylesheet" media="screen,projection" />
	
</head>
<body>