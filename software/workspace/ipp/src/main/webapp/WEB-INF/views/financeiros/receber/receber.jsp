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
			<c:url value="/sw/entradas" var="swEntradas"></c:url>
			<a href="${swEntradas}">
				<h4 class="header right black-text">Conta à Receber</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>

      	<form:form role="form" commandName="contaAReceber" servletRelativeAction="/sw/entrada/${contaAPagar.id}" method="POST">
<%--   			<div class="row">
            	<div class="input-field s12 col l3">
					<img src="../../../assets/images/usuario.png" alt="" width="175em" />
            	</div><!-- // col -->
            	<div class="input-field s12 col l9">
            		<div class="row">
            			<div class="input-field s12 col l7">
            			</div><!-- // col -->
            			<div class="input-field s12 col l5">
            			</div><!-- // col -->
        			</div><!-- // row -->
         			<div class="row">
            			<div class="input-field s12 col l6">
            				<form:input path='razaoSocial' type='text' />
							<form:errors path='razaoSocial'/> 
							<form:label path="razaoSocial">Razão Social</form:label>
            			</div><!-- // col -->
            			<div class="input-field s12 col l6">
            				<form:select path="tipoDeEmpresa">
		                    	<form:option value="${contaAPagar.tipoDeEmpresa}" label="${contaAPagar.tipoDeEmpresa == null ? 'Tipo de Empresa' : contaAPagar.tipoDeEmpresa}" />
								<c:forEach var="tipoDeEmpresa" items="${requestScope.tiposDeEmpresa}">
									<form:option value="${tipoDeEmpresa}">${tipoDeEmpresa}</form:option>							
								</c:forEach>
							</form:select>	
            			</div><!-- // col -->
        			</div><!-- // row -->
        			<div class="row">
            			<div class="input-field s12 col l6">
            				<form:input path='nomeFantazia' type='text' />
							<form:errors path='nomeFantazia'/> 
							<form:label path="nomeFantazia">Nome Fantazia</form:label>
            			</div><!-- // col -->
            			<div class="input-field s12 col l6">
            				<form:input path='cNPJ' type='text' />
							<form:errors path='cNPJ'/> 
							<form:label path="cNPJ">CNPJ</form:label>
            			</div><!-- // col -->
            		</div><!-- // row -->
        		</div><!-- // col -->
        	</div><!-- // row -->
        	<div class="row">
		    	<div class="input-field s12 col l4">
					<form:input path='endereco' type='text' />
					<form:errors path='endereco'/> 
					<form:label path="endereco">Endereço</form:label>
		        </div><!-- // col -->
		        <div class="input-field s12 col l4">
					<form:input path='complemento' type='text' />
					<form:errors path='complemento'/> 
					<form:label path="complemento">Complemento</form:label>
		        </div><!-- // col -->
		        <div class="input-field s12 col l4">
					<form:input path='bairro' type='text' />
					<form:errors path='bairro'/> 
					<form:label path="bairro">Bairro</form:label>
		        </div><!-- // col -->
		    </div><!-- // row -->
		    <div class="row">
		    	<div class="input-field s12 col l4">
					<form:input path='estado' type='text' />
					<form:errors path='estado'/> 
					<form:label path="estado">Estado</form:label>
		            </div><!-- // col -->
		        <div class="input-field s12 col l4">
					<form:input path='cidade' type='text' />
					<form:errors path='cidade'/> 
					<form:label path="cidade">Cidade</form:label>
		        </div><!-- // col -->
		        <div class="input-field s12 col l4">
					<form:input path='cEP' type='text' />
					<form:errors path='cEP'/> 
					<form:label path="cEP">CEP</form:label>
		        </div><!-- // col -->
		    </div><!-- // row -->
			<div class="row">
		    	<div class="input-field s12 col l4">
					<form:input path='telefone' type='text' />
					<form:errors path='telefone'/> 
					<form:label path="telefone">Telefone</form:label>
		        </div><!-- // col -->
		        <div class="input-field s12 col l4">
					<form:input path='fax' type='text' />
					<form:errors path='fax'/> 
					<form:label path="fax">Fax</form:label>
		        </div><!-- // col -->
		        <div class="input-field s12 col l4">
					<form:select path="regiao">
		            	<form:option value="${contaAPagar.regiao}" label="${contaAPagar.regiao == null ? 'Região' : contaAPagar.regiao}" />
							<c:forEach var="regiao" items="${requestScope.regioes}">
								<form:option value="${regiao}">${regiao}</form:option>							
							</c:forEach>
						</form:select>	
		        </div><!-- // col -->
		    </div><!-- // row -->
		    <div class="row">
	            <div class="input-field s12 col l8">
					<form:input path='site' type='text' />
					<form:errors path='site'/> 
					<form:label path="site">Site</form:label>
	            </div><!-- // col -->
	            <div class="input-field s12 col l4">
	            </div><!-- // col -->
	        </div><!-- // row -->
	        <div class="row">
	            <div class="input-field s12 col l12">
					<form:select path="tipoDeParceria">
	                    <form:option value="${tipoDeParceria}" label="${contaAPagar.tipoDeParceria == null ? 'Tipo de Parceria' : contaAPagar.tipoDeParceria}" />
						<c:forEach var="tipoDeParceria" items="${requestScope.tiposDeParceria}">
							<form:option value="${tipoDeParceria}">${tipoDeParceria}</form:option>							
						</c:forEach>
					</form:select>	
	            </div><!-- // col -->
	        </div><!-- // row -->
 --%>	    
 		<button class="btn waves-effect waves-light right" type="submit">
    	     Salvar<i class="material-icons right">send</i>
     	</button>
     	<br />
     	<br />
   		</form:form>
</div><!-- // container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>