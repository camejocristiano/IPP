<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
  <div class="row">
      	<form:form role="form" commandName="salario13" servletRelativeAction="/salarios13/${salario13.id}" method="POST">
   		<div class="row">
            <div class="input-field s12 col l12">
                <div class="row">
                  <div class="input-field s12 col l12">
                    <form:input path='test' type='text' required="required" />
					<form:errors path='test'/> 
					<label for="test">Teste</label>
                  </div>
                </div>
            </div>
        </div>
	    <button class="btn waves-effect waves-light right" type="submit">
    	     Salvar<i class="material-icons right">send</i>
     	</button>
   		</form:form>
      </div>
</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>

<c:import url="../../../partials/final.jsp"></c:import>