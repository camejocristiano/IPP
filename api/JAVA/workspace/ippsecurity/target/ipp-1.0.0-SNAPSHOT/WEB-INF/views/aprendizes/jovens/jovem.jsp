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
		<div class="col s12">
			<ul class="tabs">
		<li class="tab col s1"><a href="#jovem">Jovem</a></li>
		<li class="tab col s1"><a href="#contratacao">Contratacao</a></li> 
		<li class="tab col s1"><a href="#dadosFinanceiros">DadosFinanceiros</a></li> 
		<li class="tab col s1"><a href="#escolaridade">Escolaridade</a></li> 
		<li class="tab col s1"><a href="#familiar">Familiar</a></li> 
		<li class="tab col s1"><a href="#fichaProfissional">FichaProfissional</a></li> 
		<li class="tab col s1"><a href="#fichaSocial">FichaSocial</a></li> 
		<li class="tab col s1"><a href="#habilidades">Habilidades</a></li> 
		<li class="tab col s1"><a href="#historico">Historico</a></li> 
		<li class="tab col s1"><a href="#ocorrencia">Ocorrencia</a></li> 
		<li class="tab col s1"><a href="#outrosCursos">OutrosCursos</a></li> 
		<li class="tab col s1"><a href="#situacaoDeSaude">SituacaoDeSaude</a></li> 
			</ul>
			
	<br /> 
	
	<br />
		</div>
		<div id="jovem" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div>
		<div id="contratacao" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div> 
		<div id="dadosFinanceiros" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div> 
		<div id="escolaridade" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div> 
		<div id="familiar" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div> 
		<div id="fichaProfissional" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div> 
		<div id="fichaSocial" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div> 
		<div id="habilidades" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div> 
		<div id="historico" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div> 
		<div id="ocorrencia" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div> 
		<div id="outrosCursos" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div>
		<div id="situacaoDeSaude" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div> 
	</div>
</div>

<c:import url="../../../partials/js.jsp"></c:import>

<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>
