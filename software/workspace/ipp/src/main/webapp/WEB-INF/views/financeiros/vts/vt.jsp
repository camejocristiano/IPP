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
			<c:url value="/sw/vts" var="swVts"></c:url>
			<a href="${swVts}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "VT"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div><!-- // col -->
	</div><!-- // row -->
   		<div class="row">
            <div class="input-field s12 col l12">

			<table class="display">
				<thead>
					<tr>
						<th colspan="7" style="text-align: center">VALE TRANSPORTE DO APRENDIZ</th>
					</tr>
					<tr>
						<th colspan="1">CÓDIGO</th>
						<th colspan="2">APRENDIZ</th>
						<th colspan="2">EMPRESA</th>
						<th colspan="1">INÍCIO</th>
						<th colspan="1">PAP</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="1">${jovem.id}</td>
						<td colspan="2">${jovem.nome}</td>
						<td colspan="2">IPP</td>
						<td colspan="1">01/01/2012</td>
						<td colspan="1">PAP</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="2">ÚNICO</th>
						<th colspan="1">ÚNICO</th>
						<th colspan="2">PARA JOVEM</th>
						<th colspan="2">PARA SPTRANS</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2">4.75</td>
						<td colspan="1">42.00</td>
						<td colspan="2">250.00</td>
						<td colspan="2">250.00</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="2">BOM</th>
						<th colspan="1">BOM</th>
						<th colspan="2">PARA JOVEM</th>
						<th colspan="2">PARA CMT</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2">4.75</td>
						<td colspan="1">42.00</td>
						<td colspan="2">250.00</td>
						<td colspan="2">250.00</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="2">BEM</th>
						<th colspan="2">BEM</th>
						<th colspan="3">PARA JOVEM</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2">4.75</td>
						<td colspan="2">42.00</td>
						<td colspan="3">250.00</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="1">2ª</th>
						<th colspan="1">3ª</th>
						<th colspan="1">4ª</th>
						<th colspan="1">5ª</th>
						<th colspan="1">6ª</th>
						<th colspan="1">Sáb</th>
						<th colspan="1">DIAS DO MÊS</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="1">4.75</td>
						<td colspan="1">4.75</td>
						<td colspan="1">4.75</td>
						<td colspan="1">4.75</td>
						<td colspan="1">4.75</td>
						<td colspan="1">4.75</td>
						<td colspan="1">30</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="3">FALTA / CUR</th>
						<th colspan="2">Falta Empresa Injustificada Será Imputada</th>
						<th colspan="2">Falta Empresa Justificada Será Imputada</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="3">2</td>
						<td colspan="2">2</td>
						<td colspan="2">0</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="3">DIAS À PAGAR</th>
						<th colspan="2">TOTAL ALUNO</th>
						<th colspan="2">TOTAL CONSSESSIONÁRIA</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="3">29</td>
						<td colspan="2">880.00</td>
						<td colspan="2">880.00</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="7">OBSERVAÇÕES</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="7"> Testando as obsedrvações dos vales transportes do Jovem Aprendiz...</td>
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
<c:import url="../../../partials/final.jsp"></c:import>