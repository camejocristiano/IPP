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
				<a href="#">
					<div class="card-content white-text">
						<span class="card-title">Parâmetros<i
							class="material-icons right" style="color: #eee !important;">developer_board</i></span>
						<p>Manutenção de Parâmetros</p>
					</div>
				</a> 
				<a href="#" class="btn-index">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">Cadastrar</h6>
					</div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="#">
					<div class="card-content white-text">
						<span class="card-title">Demonstrativos<i
							class="material-icons right" style="color: #eee !important;">assessment</i></span>
						<p>Manutenção de Demonstrativos</p>
					</div>
				</a> 
				<a href="#" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Cadastrar</h6>
					</div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="#">
					<div class="card-content white-text">
						<span class="card-title">VTs<i
							class="material-icons right" style="color: #eee !important;">directions_bus</i></span>
						<p>Manutenção de Vts</p>
					</div>
				</a> 
				<a href="#" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Cadastrar</h6>
					</div>
				</a>
			</div>
		</div>
	
	</div>
	<div class="row">
		
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="#">    
			    	<div class="card-content white-text">
			    		<span class="card-title">VRs<i class="material-icons right" style="color: #eee !important;">restaurant</i></span>
			    		<p>Manutenção de VRs</p>
			    	</div>
		        </a>
				<a href="#" class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">Cadastrar</h6>
			    	</div>
				</a>
			</div>
	   	</div>
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="#">
		            <div class="card-content white-text">
		              <span class="card-title">13°s<i class="material-icons right" style="color: #eee !important;">attach_money</i></span>
		              <p>Gerenciador de 13ºs</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Cadastrar</h6>
		            </div>
				</a>
			</div>
		</div>
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<a href="#">
		   			<div class="card-content white-text">
		              <span class="card-title">Pagar<i class="material-icons right" style="color: #eee !important;">payment</i></span>
		              <p>Manutenção de Contas à pagar</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Cadastrar</h6>
		            </div>
				</a>
			</div>
		</div>
	
	</div>  

<div class="row">
		
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="#">    
			    	<div class="card-content white-text">
			    		<span class="card-title">Receber<i class="material-icons right" style="color: #eee !important;">monetization_on</i></span>
			    		<p>Manutenção de Contas à receber</p>
			    	</div>
		        </a>
				<a href="#" class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">Cadastrar</h6>
			    	</div>
				</a>
			</div>
	   	</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="#">
		            <div class="card-content white-text">
		              <span class="card-title">Bancos<i class="material-icons right" style="color: #eee !important;">account_balance</i></span>
		              <p>Gerenciador de Bancos</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Cadastrar</h6>
		            </div>
				</a>
			</div>
		</div>
	
	</div>  

</div>

<c:import url="../../partials/js.jsp"></c:import>
<c:import url="../../partials/footer.jsp"></c:import>
<c:import url="../../partials/final.jsp"></c:import>