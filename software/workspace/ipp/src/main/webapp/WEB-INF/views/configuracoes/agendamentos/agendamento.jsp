<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<h3 class="${requestScope.corMsg} col s12">${requestScope.msg}</h3>
 <div class="row">
    <form:form role="form" commandName="agendamento" servletRelativeAction="/agendamentos/${agendamento.id}" method="POST">
        <hr>
        <h6>Agendamento</h6>
      <div class="row">
        <div class="input-field col s12">
          <div class="row">               

            <div class="input-field s12 col l3">
                <input id="data" name="data" value="${agendamento.data}" type="text" class="validate datepicker" placeholder="Data do Evento">
            </div>
            <div class="input-field s12 col l3">
                <input id="hora" name="hora" value="${agendamento.hora}" type="text" class="validate timepicker" placeholder="Hora do Evento">
                <label for="hora">Hora</label>
            </div>
            <div class="input-field s12 col l3">
				<form:input path='tempoPrevisto' type='text' />
				<label for='tempoPrevisto'>Tempo Previsto</label>
				<form:errors path='tempoPrevisto' />
            </div>
            <div class="input-field s12 col l3">
				<form:select path="usuario">
					<option value="${agendamento.usuario.id}">${agendamento.usuario.nome}</option>
					<c:forEach var="usuario" items="${requestScope.usuarios}">
						<option value="${usuario.id}">${usuario.nome}</option>							
					</c:forEach>
				</form:select>        
            </div>
            
          </div>
        </div>
      </div>

      <div class="row">
            <div class="input-field s12  col l12">
              <div class="row">                  
                <div class="input-field s12  col l12">
                   <form:textarea path="descricao" id="descricao" class="materialize-textarea"></form:textarea>
                   <label for="descricao">Descrição</label>
                   <form:errors path='descricao' />
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