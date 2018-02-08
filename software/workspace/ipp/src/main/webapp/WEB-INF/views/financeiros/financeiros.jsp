<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../partials/header.jsp"></c:import>
<style type="text/css">
	.tabs .indicator{
    	background-color: #222;
    }
</style>
<c:import url="../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

	<div class="row">
		<div class="col s12">
			<ul class="tabs">
				<li class="tab col s1"><a href="#parametros" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Parâmetros"><i class="material-icons" style="color: #222 !important;">account_balance_wallet</i></a></li>
				<li class="tab col s1"><a href="#demonstrativos" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Demonstrativos"><i class="material-icons" style="color: #222 !important;">local_atm</i></a></li>
				<li class="tab col s1"><a href="#vts" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="VTs"><i class="material-icons" style="color: #222 !important;">directions_bus</i></a></li>
				<li class="tab col s1"><a href="#vrs" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="VRs"><i class="material-icons" style="color: #222 !important;">local_dining</i></a></li>
				<li class="tab col s1"><a href="#salarios13" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="13ºs"><i class="material-icons" style="color: #222 !important;">mood</i></a></li>
				<li class="tab col s1"><a href="#pagar" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Contas à pagar"><i class="material-icons" style="color: #222 !important;">money_off</i></a></li>
				<li class="tab col s1"><a href="#receber" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Contas à receber"><i class="material-icons" style="color: #222 !important;">accessibility</i></a></li>
				<li class="tab col s1"><a href="#bancos" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Bancos"><i class="material-icons" style="color: #222 !important;">business</i></a></li>
			</ul>
			
	<br /> 
	
	<br />
		</div>
		<div id="parametros" class="col s12">
			<c:import url="parametros/parametros.jsp"></c:import>
		</div>
		<div id="demonstrativos" class="col s12">
			<c:import url="demonstrativos/demonstrativos.jsp"></c:import>
		</div>
		<div id="vts" class="col s12">
			<c:import url="vts/vts.jsp"></c:import>
		</div>
		<div id="vrs" class="col s12">
			<c:import url="vrs/vrs.jsp"></c:import>
		</div>
		<div id="salarios13" class="col s12">
			<c:import url="salarios/salarios.jsp"></c:import>
		</div>
		<div id="pagar" class="col s12">
			<c:import url="pagar/contas.jsp"></c:import>
		</div>
		<div id="receber" class="col s12">
			<c:import url="receber/contas.jsp"></c:import>
		</div>
		<div id="bancos" class="col s12">
			<c:import url="bancos/bancos.jsp"></c:import>
		</div>
	</div>
</div>

<c:import url="../../partials/js.jsp"></c:import>
<script type="text/javascript">
$(document).ready(function(){
    $('.tooltipped').tooltip({delay: 50});
  });
</script>
<c:import url="../../partials/footer.jsp"></c:import>