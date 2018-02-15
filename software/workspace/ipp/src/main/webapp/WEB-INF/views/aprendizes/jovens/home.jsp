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
		<div class="col s12 l12">
			<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Jovem"}</h4>
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
				<c:url value="/sw/jovemForm/${jovem.id}" var="swJovemFormJovemId"></c:url>
				<a href="${swJovemFormJovemId}">
					<div class="card-content white-text">
						<span class="card-title">Dados Cadastrais<i
							class="material-icons right" style="color: #eee !important;">dvr</i></span>
						<p>Manutenção dos Dados do Jovem</p>
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
				<c:url value="/sw/matriculasJovem/${jovem.id}" var="swMatriculasJovemJovemId"></c:url>
				<a href="${swMatriculasJovemJovemId}">
					<div class="card-content white-text">
						<span class="card-title">Cursos<i
							class="material-icons right" style="color: #eee !important;">school</i></span>
						<p>Cursos pelo IPP</p>
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
				<c:url value="/sw/escolaridadeJovem/${jovem.id}" var="swEscolaridadeJovemJovemId"></c:url>
				<a href="${swEscolaridadeJovemJovemId}">
					<div class="card-content white-text">
						<span class="card-title">Escolaridade<i
							class="material-icons right" style="color: #eee !important;">book</i></span>
						<p>Manutenção de Escolaridades</p>
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
				<c:url value="/sw/situacaoLaboralJovem/${jovem.id}" var="swSituacaoLaboralJovemJovemId"></c:url>
				<a href="${swSituacaoLaboralJovemJovemId}">    
			    	<div class="card-content white-text">
			    		<span class="card-title">Laboral<i class="material-icons right" style="color: #eee !important;">format_list_bulleted</i></span>
			    		<p>Manutenção de Situação Laboral</p>
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
	    		<c:url value="/sw/caracteristicaDomiciliarJovem/${jovem.id}" var="swCaracteristicaDomiciliarJovemJovemId"></c:url>
	      		<a href="${swCaracteristicaDomiciliarJovemJovemId}">
		            <div class="card-content white-text">
		              <span class="card-title">Domiciliares<i class="material-icons right" style="color: #eee !important;">home</i></span>
		              <p>Manutenção de Caract. Dom.</p>
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
	    		<c:url value="/sw/habilidadeJovem/${jovem.id}" var="swHabilidadeJovemJovemId"></c:url>
	    		<a href="${swHabilidadeJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Habilidades<i class="material-icons right" style="color: #eee !important;">thumbs_up_down</i></span>
		              <p>Manutenção de Habilidades</p>
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
	    		<c:url value="/sw/situacaoDeSaudeJovem/${jovem.id}" var="swSituacaoDeSaudeJovemJovemId"></c:url>
	    		<a href="${swSituacaoDeSaudeJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Saúde<i class="material-icons right" style="color: #eee !important;">healing</i></span>
		              <p>Situação de Saúde</p>
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
	    		<c:url value="/sw/fichaSocialJovem/${jovem.id}" var="swFichaSocialJovemJovemId"></c:url>
	    		<a href="${swFichaSocialJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Social<i class="material-icons right" style="color: #eee !important;">thumb_up</i></span>
		              <p>Manutenção de Ficha Social</p>
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
	    		<c:url value="/sw/fichaProfissionalJovem/${jovem.id}" var="swFichaProfissionalJovemJovemId"></c:url>
	    		<a href="${swFichaProfissionalJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Profissional<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Ficha Profissional</p>
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
	    		<c:url value="/sw/entrevistasJovem/${jovem.id}" var="swEntrevistasJovemJovemId"></c:url>
	    		<a href="${swEntrevistasJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Entrevistas<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Entrevistas</p>
	                </div>
	            </a>
	            <c:url value="/sw/entrevistaJovem/${jovem.id}" var="swEntrevistaJovemJovemId"></c:url>
				<a href="${swEntrevistaJovemJovemId}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Nova</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/contratacoesJovem/${jovem.id}" var="swContratacoesJovemJovemId"></c:url>
	    		<a href="${swContratacoesJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Contratações<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Contratações</p>
	                </div>
	            </a>
	            <c:url value="/sw/contratacaoJovem/${jovem.id}" var="swContratacaoJovemJovemId"></c:url>
				<a href="${swContratacaoJovemJovemId}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Nova</h6>
		            </div>
				</a>
			</div>
		</div>
		<div class="col s12 m6 l4">
	    	<div class="card blue-grey darken-1">
	    		<c:url value="/sw/dispensasJovem/${jovem.id}" var="swDispensasJovemJovemId"></c:url>
	    		<a href="${swDispensasJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Dispensas<i class="material-icons right" style="color: #eee !important;">receipt</i></span>
		              <p>Manutenção de Dispensas</p>
	                </div>
	            </a>
	            <c:url value="/sw/dispensaJovem/${jovem.id}" var="swDispensaJovemJovemId"></c:url>
				<a href="${swDispensaJovemJovemId}" class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">Nova</h6>
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
	    		<c:url value="/sw/dadosFinanceirosJovem/${jovem.id}" var="swDadosFinanceirosJovemJovemId"></c:url>
	    		<a href="${swDadosFinanceirosJovemJovemId}">
		   			<div class="card-content white-text">
		              <span class="card-title">Financeiros<i class="material-icons right" style="color: #eee !important;">attach_money</i></span>
		              <p>Manutenção de Dados Finaceiros</p>
	                </div>
	            </a>
				<a class="btn-index">
		            <div class="card-action">
		              <h6 style="color: #eee !important;">...</h6>
		            </div>
				</a>
			</div>
		</div>
	
	</div>  

</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>