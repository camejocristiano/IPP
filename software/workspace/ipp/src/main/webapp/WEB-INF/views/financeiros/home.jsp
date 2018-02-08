<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../partials/header.jsp"></c:import>

<style>
/*
 CSS INDEXES
*/
.btn-index:hover {
	background-color: #669999;
	font-weight: bolder;
	font-style: italic;
}
.card-content:hover {
	font-weight: bolder;
	background-color: #669999;
	font-style: italic;
}
</style>

<c:import url="../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	
	<div class="row">
		<div class="col s12 l12">
			<h4 class="header right black-text">Financeiros</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
	<div class="row">
		
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="/sw/parametros">
					<div class="card-content white-text">
						<span class="card-title">Parâmetros<i
							class="material-icons right" style="color: #eee !important;">account_balance_wallet</i></span>
						<p>Manutenção de Parâmetros</p>
					</div>
				</a> 
				<a href="/sw/parametro/form" class="btn-index">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">Novo</h6>
					</div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="/sw/demonstrativos">    
			    	<div class="card-content white-text">
			    		<span class="card-title">Demostrativos<i class="material-icons right" style="color: #eee !important;">local_atm</i></span>
			    		<p>Manutenção de Demostrativos</p>
			    	</div>
		        </a>
				<a class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">...</h6>
			    	</div>
				</a>
			</div>
	   	</div>
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="/sw/vts">
		            <div class="card-content white-text">
		              <span class="card-title">Vale Transportes<i class="material-icons right" style="color: #eee !important;">directions_bus</i></span>
		              <p>Manutenção de Vale Transportes</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="/sw/vrs">
		            <div class="card-content white-text">
		              <span class="card-title">Vale Refeição<i class="material-icons right" style="color: #eee !important;">local_dining</i></span>
		              <p>Manutenção de Vale Refeição</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="/sw/salarios13">
		            <div class="card-content white-text">
		              <span class="card-title">13º<i class="material-icons right" style="color: #eee !important;">mood</i></span>
		              <p>Manutenção de 13º</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="/sw/contas">
		            <div class="card-content white-text">
		              <span class="card-title">Pagar<i class="material-icons right" style="color: #eee !important;">money_off</i></span>
		              <p>Manutenção de Contas à Pagar</p>
	                </div>
	            </a>
				<a href="/sw/conta/form" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="/sw/entradas">
		            <div class="card-content white-text">
		              <span class="card-title">Receber<i class="material-icons right" style="color: #eee !important;">accessibility</i></span>
		              <p>Manutenção de Contas à Receber</p>
	                </div>
	            </a>
				<a href="/sw/entrada/form" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="/sw/bancos">
		            <div class="card-content white-text">
		              <span class="card-title">Bancos<i class="material-icons right" style="color: #eee !important;">business</i></span>
		              <p>Manutenção de Bancos</p>
	                </div>
	            </a>
				<a href="/sw/banco/form" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Novo</h6>
		            </div>
				</a>
			</div>
		</div>

	</div>  

	
</div>

<c:import url="../../partials/js.jsp"></c:import>
<c:import url="../../partials/footer.jsp"></c:import>
<c:import url="../../partials/final.jsp"></c:import>