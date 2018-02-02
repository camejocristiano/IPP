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
			<h4 class="header right black-text">Joãozinho da Silva</h4>
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
						<span class="card-title">Dados Cadastrais<i
							class="material-icons right" style="color: #eee !important;">dvr</i></span>
						<p>Manutenção dos Dados do Jovem</p>
					</div>
				</a> 
				<a href="#" class="btn-index">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">Editar</h6>
					</div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="#">
					<div class="card-content white-text">
						<span class="card-title">Cursos<i
							class="material-icons right" style="color: #eee !important;">school</i></span>
						<p>Cursando</p>
					</div>
				</a> 
				<a href="#" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Listar</h6>
					</div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="#">
					<div class="card-content white-text">
						<span class="card-title">Escolaridade<i
							class="material-icons right" style="color: #eee !important;">book</i></span>
						<p>Manutenção de Escolaridades</p>
					</div>
				</a> 
				<a href="#" class="btn-index">
					<div class="card-action">
						<h6 style="color: #eee !important;">Atualizar</h6>
					</div>
				</a>
			</div>
		</div>
	
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<a href="#">    
			    	<div class="card-content white-text">
			    		<span class="card-title">Laboral<i class="material-icons right" style="color: #eee !important;">format_list_bulleted</i></span>
			    		<p>Manutenção de Situação Laboral</p>
			    	</div>
		        </a>
				<a href="#" class="btn-index">
			    	<div class="card-action">
			    		<h6 style="color: #eee !important;">Atualizar</h6>
			    	</div>
				</a>
			</div>
	   	</div>
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	      		<a href="#">
		            <div class="card-content white-text">
		              <span class="card-title">Domiciliares<i class="material-icons right" style="color: #eee !important;">home</i></span>
		              <p>Manutenção de Caract. Dom.</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Atualizar</h6>
		            </div>
				</a>
			</div>
		</div>
	    <div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<a href="#">
		   			<div class="card-content white-text">
		              <span class="card-title">Habilidades<i class="material-icons right" style="color: #eee !important;">thumbs_up_down</i></span>
		              <p>Manutenção de Habilidades</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Atualizar</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<a href="#">
		   			<div class="card-content white-text">
		              <span class="card-title">Saúde<i class="material-icons right" style="color: #eee !important;">healing</i></span>
		              <p>Manutenção de Situação de Saúde</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Atualizar</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<a href="#">
		   			<div class="card-content white-text">
		              <span class="card-title">Social<i class="material-icons right" style="color: #eee !important;">thumb_up</i></span>
		              <p>Manutenção de Ficha Social</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Atualizar</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<a href="#">
		   			<div class="card-content white-text">
		              <span class="card-title">Profissional<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Ficha Profissional</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Atualizar</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<a href="#">
		   			<div class="card-content white-text">
		              <span class="card-title">Históricos<i class="material-icons right" style="color: #eee !important;">reply_all</i></span>
		              <p>Manutenção de Históricos</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Atualizar</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<a href="#">
		   			<div class="card-content white-text">
		              <span class="card-title">Financeiros<i class="material-icons right" style="color: #eee !important;">attach_money</i></span>
		              <p>Manutenção de Dados Finaceiros</p>
	                </div>
	            </a>
				<a href="#" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Atualizar</h6>
		            </div>
				</a>
			</div>
		</div>
	
	</div>  

</div>

<c:import url="../../partials/js.jsp"></c:import>
<c:import url="../../partials/footer.jsp"></c:import>
<c:import url="../../partials/final.jsp"></c:import>