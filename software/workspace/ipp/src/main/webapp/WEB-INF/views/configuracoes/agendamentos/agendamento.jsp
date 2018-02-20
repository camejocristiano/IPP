<%@page import="java.util.Calendar"%>
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
		<div class="col s12 l12">
			<h4 class="header right black-text">Agendamento</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
	
<c:url value="/sw/agendamento/${agendamento.usuarioResponsavel != null ? agendamento.id : null}" var="swAgendamentoId"></c:url>
    <form:form role="form" commandName="agendamento" servletRelativeAction="${swAgendamentoId}" method="POST">
      <div class="row">
        <div class="input-field col s12">
          <div class="row">               

            <div class="input-field s12 col l3">
            	<form:select path="dia">
					<form:option value="1">01</form:option>
					<form:option value="2">02</form:option>
					<form:option value="3">03</form:option>
					<form:option value="4">04</form:option>
					<form:option value="5">05</form:option>
					<form:option value="6">06</form:option>
					<form:option value="7">07</form:option>
					
					<form:option value="8">08</form:option>
					<form:option value="9">09</form:option>
					<form:option value="10">10</form:option>
					<form:option value="11">11</form:option>
					<form:option value="12">12</form:option>
					<form:option value="13">13</form:option>
					<form:option value="14">14</form:option>
					
					<form:option value="15">15</form:option>
					<form:option value="16">16</form:option>
					<form:option value="17">17</form:option>
					<form:option value="18">18</form:option>
					<form:option value="19">19</form:option>
					<form:option value="20">20</form:option>
					<form:option value="21">21</form:option>
					
					<form:option value="22">22</form:option>
					<form:option value="23">23</form:option>
					<form:option value="24">24</form:option>
					<form:option value="25">25</form:option>
					<form:option value="26">26</form:option>
					<form:option value="27">27</form:option>
					<form:option value="28">28</form:option>
					
					<form:option value="29">29</form:option>
					<form:option value="30">30</form:option>
					<form:option value="31">31</form:option>							

				</form:select>
            	<label for="dia">Dia</label>
            </div>
            <div class="input-field s12 col l3">
            	<form:select path="mes">
					<form:option value="1">01</form:option>
					<form:option value="2">02</form:option>
					<form:option value="3">03</form:option>
					<form:option value="4">04</form:option>
					<form:option value="5">05</form:option>
					<form:option value="6">06</form:option>
					<form:option value="7">07</form:option>
					
					<form:option value="8">08</form:option>
					<form:option value="9">09</form:option>
					<form:option value="10">10</form:option>
					<form:option value="11">11</form:option>
					<form:option value="12">12</form:option>

				</form:select>
                <label for="mes">Mês</label>
            </div>
            <div class="input-field s12 col l3">
            	<form:select path="ano">
					<form:option value="2018">2018</form:option>
					<form:option value="2019">2019</form:option>
					<form:option value="2020">2020</form:option>
					<form:option value="2021">2021</form:option>
					<form:option value="2022">2022</form:option>
					<form:option value="2023">2023</form:option>
					<form:option value="2024">2024</form:option>
				</form:select>
                <label for="ano">Ano</label>
            </div>
            <div class="input-field s12 col l3">
            	<form:select path="hora">
					<form:option value="08">08:00</form:option>
					<form:option value="09">09:00</form:option>
					<form:option value="10">10:00</form:option>
					<form:option value="11">11:00</form:option>
					<form:option value="12">12:00</form:option>
					<form:option value="13">13:00</form:option>
					<form:option value="14">14:00</form:option>
					<form:option value="15">15:00</form:option>
					<form:option value="16">16:00</form:option>
					<form:option value="17">17:00</form:option>
				</form:select>
                <label for="ano">Horário</label>
            </div>
          </div>
        </div>
      </div>

      <div class="row">
            <div class="input-field s12  col l12">
            	<form:input path="titulo" />
            	<form:errors path="titulo"></form:errors>
            	<label for="titulo">Título</label>
            </div>
          </div>
              <div class="row">                  
                <div class="input-field s12  col l12">
                   <form:textarea path="descricao" id="descricao" class="materialize-textarea"></form:textarea>
                   <form:errors path='descricao' />
                   <label for="descricao">Descrição</label>
                </div>                  
              </div>
          
          
          <input type="hidden" name="usuarioResponsavel" value="${usuarioSessao}">

	<table id="tabelaUsuarios" class="display">
        <thead>
          <tr>
          	<th>INCLUSOS</th>
            <th>TITULO</th>
            <th>NUMERO</th>
          </tr>
        </thead>
        <tbody>
		<c:forEach var="usuarioEnvolvido" items="${requestScope.usuariosEnvolvidos}">
          <tr>
			<td>
			<input type="checkbox" class="filled-in" name="usuariosEnvolvidos" id="usuarioEnvolvido${usuarioEnvolvido.id}" value="${usuarioEnvolvido.id}" <c:if test="${usuarioEnvolvido.id != null}">checked</c:if> />
			<label for="usuarioEnvolvido${usuarioEnvolvido.id}"></label>
            </td>
            <td>${usuarioEnvolvido.titulo}</td>
            <td>${usuarioEnvolvido.numero}</td>
          </tr>
        </c:forEach>
		<c:forEach var="usuario" items="${requestScope.usuarios}">
          <tr>
			<td>
			<input type="checkbox" class="filled-in" name="usuariosEnvolvidos" id="usuario${usuario.id}" value="${usuario.id}" />
			<label for="usuario${usuario.id}"></label>
            </td>
            <td>${usuario.nome}</td>
            <td>${usuario.username}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table> 

<br />
<br />

              <button class="btn waves-effect waves-light right" type="submit">
                Salvar<i class="material-icons right">send</i>
              </button>

    </form:form>
<br />
<br />
  </div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>