<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<style>
table, th {
    border: 2px solid black;
}
table, td {
    border: 1px solid black;
}
</style>

<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">


	<div class="row">
		<div class="col s12 l12">
			<a href="/sw/demonstrativos">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "VR"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
<!-- 			contratacao
empresa
jovem
fichaProfissional
dadosFinanceiros
parametro
frequencias
diasAPagar
valor -->
		</div><!-- // col -->
	</div><!-- // row -->
   		<div class="row">
            <div class="input-field s12 col l12">

			<table class="display">
				<thead>
					<tr>
						<th colspan="7" style="text-align: center">VALE REFEIÇÃO DO APRENDIZ</th>
					</tr>
					<tr>
						<th>CÓDIGO</th>
						<th colspan="4">APRENDIZ</th>
						<th colspan="2">EMPRESA</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${jovem.id}</td>
						<td colspan="4">${jovem.nome}</td>
						<td colspan="2">${empresa.nomeFantazia}</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="3">ADMISSÃO</th>
						<th colspan="4">STATUS_DA_CONTRATAÇÃO</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="3">${contratacao.dataDeInicioDaContratacao}</td>
						<td colspan="4">${contratacao.statusDaContratacao}</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="3">TOTAL_DIAS</th>
						<th colspan="1">FALTAS_CURSO</th>
						<th colspan="1">FALTAS_EMPRESA</th>
						<th colspan="2">DIAS_A_PAGAR</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="3">###</td>
						<td colspan="1">###</td>
						<td colspan="1">###</td>
						<td colspan="2">###</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="1">VR_UNITÁRIO</th>
						<th colspan="2">VALOR_JOVEM</th>
						<th colspan="2">VALOR_EMPRESA</th>
						<th colspan="2">TOTAL</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="1">${dadosFinanceiros.valeRefeicao_valorIPPRS}</td>
						<td colspan="2">$$$.$$</td>
						<td colspan="2">$$$.$$</td>
						<td colspan="2">$$$.$$</td>
					</tr>
				</tbody>
																
			</table>
			</div><!-- // col -->
        </div><!-- // row -->
   		<br />
   		<br />
	</div><!-- // container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>
<c:import url="../../../partials/final.jsp"></c:import>