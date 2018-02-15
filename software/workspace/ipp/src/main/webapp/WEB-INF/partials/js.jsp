<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<c:url value="/js/jquery-1.12.4.js" var="jquery" />
	<script src="${jquery}"></script>
	<c:url value="/js/materialize.js" var="materializeJs" />
	<script src="${materializeJs}"></script>
	<c:url value="/js/init.js" var="initJs" />
	<script src="${initJs}"></script>
	
	<c:url value="/js/jquery.dataTables.min.js" var="jqueryDataTablesMinJs" />
    <script src="${jqueryDataTablesMinJs}"></script>    
	<c:url value="/js/tables.js" var="tablesJs" />
    <script src="${tablesJs}"></script>    
    
    <c:url value="/js/dateMaterialize.js" var="dateMaterializeJs" />
	<script src="${dateMaterializeJs}"></script>
	<c:url value="/js/timeMaterialize.js" var="timeMaterializeJs" />
	<script src="${timeMaterializeJs}"></script>
	<c:url value="/js/selectMaterialize.js" var="selectMaterializeJs" />
	<script src="${selectMaterializeJs}"></script>
	<c:url value="/js/modalMaterialize.js" var="modalMaterializeJs" />
	<script src="${modalMaterializeJs}"></script>
	