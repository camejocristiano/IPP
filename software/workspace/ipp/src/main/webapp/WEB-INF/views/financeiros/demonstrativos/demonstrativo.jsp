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
			<c:url value="/sw/demonstrativos" var="swDemonstrativos"></c:url>
			<a href="${swDemonstrativos}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Demonstrativos"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
   		<div class="row">
            <div class="input-field s12 col l12">
			<table border="1">
				<thead>
					<tr>
						<th colspan="8">DADOS DA EMPRESA</th>
					</tr>
					<tr>
						<th colspan="6">Nome da Empresa</th>
						<th colspan="2">Demonstrativo de Folha de Pagamento</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="6">CNPJ Empresa</td>
						<td colspan="2">Data Referente</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="8">DADOS DO JOVEM</th>
					</tr>
					<tr>
						<th>Código</th>
						<th colspan="2">Nome do Jovem</th>
						<th>Idade do Jovem</th>
						<th>Admissão</th>
						<th>CBO</th>
						<th colspan="2">Local de Trabalho</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${jovem.id}</td>
						<td colspan="2">${jovem.nome}</td>
						<td>${jovem.idade}</td>
						<td>10/10/1998</td>
						<td>123</td>
						<td colspan="2">IPP</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="8">DADOS DO CURSO</th>
					</tr>
					<tr>
						<th colspan="3">Curso</th>
						<th colspan="2">PAP</th>
						<th>Data de Início:</th>
						<th>Dias Mês:</th>
						<th>Término do Contrato:</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="3"></td>	
						<td colspan="2"></td>
						<td>${contratacao.dataDeInicioDaContratacao}</td>
						<td>30</td>	
						<td>${contratacao.terminoDoContrato}</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="8">FREQUÊNCIAS</th>
					</tr>
					<tr>
						<th>Faltas Curso:</th>
						<th>Falta Esa Injustificada:</th>
						<th>Falta Esa Justificada:</th>
						<th>Estorno Faltas:</th>
						<th>Dias Trabalho:</th>
						<th>Atrasos hrs:</th>
						<th>Desconto Portfolio hrs:</th>
						<th>Valor:</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${faltasCurso}</td>
						<td></td>						
						<td></td>
						<td></td>						
						<td>${diasTrabalho}</td>						
						<td></td>
						<td></td>						
						<td></td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th colspan="8">DETALHAMENTO FINANCEIRO</th>
					</tr>
					<tr>
						<th>Código</th>
						<th colspan="3">Descrição</th>
						<th>Frequência</th>
						<th>Vencimentos</th>
						<th colspan="2">Descontos</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>0001</td>
						<td colspan="3">Salário Base</td>
						<td>${parametros.salarioMinimoFederalSMF}</td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0002</td>
						<td colspan="3">VT</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0003</td>
						<td colspan="3">VR</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0004</td>
						<td colspan="3">Seguro de Vida/PCMSO:</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0005</td>
						<td colspan="3">INSS - 20%</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0006</td>
						<td colspan="3">FGTS - 2%:</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0007</td>
						<td colspan="3">PIS - 1%</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<!-- <tr>
						<td>0008</td>
						<td colspan="3">Acidente de Trabalho - 2%</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0009</td>
						<td colspan="3">Sistema S - 3,5%</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0010</td>
						<td colspan="3">Salário Educação - 1%</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>00011</td>
						<td colspan="3">VT 20 dias Contrato</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0012</td>
						<td colspan="3">VT ref. Admissão</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0013</td>
						<td colspan="3">VT próximo mês + 2,5%</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0014</td>
						<td colspan="3">VR 20 dias contrato</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0015</td>
						<td colspan="3">VR Ref. Admissão</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0016</td>
						<td colspan="3">VR Próximo Mês + 2,60%</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0017</td>
						<td colspan="3">Plano de saúde</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0018</td>
						<td colspan="3">Plano odonto</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0019</td>
						<td colspan="3">Tx Extra Adicional 18% s/min</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0020</td>
						<td colspan="3">Media Taxas</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>0021</td>
						<td colspan="3">Media Prov 13 + Férias + Encargos</td>
						<td></td>
						<td></td>
						<td colspan="2"></td>
					</tr> -->
					<tr>
						<th colspan="8">RESUMO</th>
					</tr>
					<tr>
						<th colspan="4" rowspan="3"></th>
						<th>Total Vencimentos</th>
						<th>Total Descontos</th>
						<th colspan="2"></th>
					</tr>
					<tr>
						<td>910.00</td>
						<td>1,080.20</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<th colspan="2">Total por Jovem</th>
						<th colspan="2">1,258.20</th>			
					</tr>
				</tbody>
			</table>
			<br />
		</div><!-- // col -->
        </div><!-- // row -->
   		<br />
   		<br />
	</div><!-- // container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>