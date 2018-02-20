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
			<h4 class="header right black-text">Agenda</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>


<table id="tabelaAgendamentos" class="display">
        <thead>
          <tr>
            <th>HORÁRIO</th>
            <th>TÍTULO</th>
            <th>DESCRIÇÃO</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        		<c:forEach var="agendamentoResponsavel" items="${requestScope.agendamentosResponsavel}">
        			<c:forEach var="agendamentoEnvolvido" items="${requestScope.agendamentosEnvolvido}">
			            <c:if test="${agendamentoResponsavel.hora == 8 || agendamentoEnvolvido.hora == 8}">
              			<tr>
			            	<td>08:00</td>
				            <td>
								${agendamentoResponsavel.hora == 8 ? agendamentoResponsavel.titulo : null}
				            	${agendamentoEnvolvido.hora == 8 ? agendamentoEnvolvido.titulo : null}
							</td>
				            <td>
								${agendamentoResponsavel.hora == 8 ? agendamentoResponsavel.descricao : null}
				            	${agendamentoEnvolvido.hora == 8 ? agendamentoEnvolvido.descricao : null}
							</td>
							<td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						<c:if test="${agendamentoResponsavel.hora != 8 || agendamentoEnvolvido.hora != 8}">
			            <tr>	
			            	<td>08:00</td>
				            <td></td>
				            <td></td>
				            <td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						
						<c:if test="${agendamentoResponsavel.hora == 9 || agendamentoEnvolvido.hora == 9}">
			            <tr>	
			            	<td>09:00</td>
				            <td>
								${agendamentoResponsavel.hora == 9 ? agendamentoResponsavel.titulo : null}
				            	${agendamentoEnvolvido.hora == 9 ? agendamentoEnvolvido.titulo : null}
							</td>
				            <td>
								${agendamentoResponsavel.hora == 9 ? agendamentoResponsavel.descricao : null}
				            	${agendamentoEnvolvido.hora == 9 ? agendamentoEnvolvido.descricao : null}
							</td>
							<td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						<c:if test="${agendamentoResponsavel.hora != 9 || agendamentoEnvolvido.hora != 9}">
			            <tr>
			            	<td>09:00</td>
				            <td></td>
				            <td></td>
				            <td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>

						<c:if test="${agendamentoResponsavel.hora == 10 || agendamentoEnvolvido.hora == 10}">
			            <tr>
			            	<td>10:00</td>
				            <td>
								${agendamentoResponsavel.hora == 10 ? agendamentoResponsavel.titulo : null}
				            	${agendamentoEnvolvido.hora == 10 ? agendamentoEnvolvido.titulo : null}
							</td>
				            <td>
								${agendamentoResponsavel.hora == 10 ? agendamentoResponsavel.descricao : null}
				            	${agendamentoEnvolvido.hora == 10 ? agendamentoEnvolvido.descricao : null}
							</td>
							<td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						<c:if test="${agendamentoResponsavel.hora != 10 || agendamentoEnvolvido.hora != 10}">
			            <tr>
			            	<td>10:00</td>
				            <td></td>
				            <td></td>
				            <td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						
						<c:if test="${agendamentoResponsavel.hora == 11 || agendamentoEnvolvido.hora == 11}">
			            <tr>
			            	<td>11:00</td>
				            <td>
								${agendamentoResponsavel.hora == 11 ? agendamentoResponsavel.titulo : null}
				            	${agendamentoEnvolvido.hora == 11 ? agendamentoEnvolvido.titulo : null}
							</td>
				            <td>
								${agendamentoResponsavel.hora == 11 ? agendamentoResponsavel.descricao : null}
				            	${agendamentoEnvolvido.hora == 11 ? agendamentoEnvolvido.descricao : null}
							</td>
							<td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						<c:if test="${agendamentoResponsavel.hora != 11 || agendamentoEnvolvido.hora != 11}">
			            <tr>
			            	<td>11:00</td>
				            <td></td>
				            <td></td>
				            <td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						
						<c:if test="${agendamentoResponsavel.hora == 12 || agendamentoEnvolvido.hora == 12}">
			            <tr>
			            	<td>12:00</td>
				            <td>
								${agendamentoResponsavel.hora == 12 ? agendamentoResponsavel.titulo : null}
				            	${agendamentoEnvolvido.hora == 12 ? agendamentoEnvolvido.titulo : null}
							</td>
				            <td>
								${agendamentoResponsavel.hora == 12 ? agendamentoResponsavel.descricao : null}
				            	${agendamentoEnvolvido.hora == 12 ? agendamentoEnvolvido.descricao : null}
							</td>
							<td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						<c:if test="${agendamentoResponsavel.hora != 12 || agendamentoEnvolvido.hora != 12}">
			            <tr>
			            	<td>12:00</td>
				            <td></td>
				            <td></td>
				            <td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						
						<c:if test="${agendamentoResponsavel.hora == 13 || agendamentoEnvolvido.hora == 13}">
			            <tr>
			            	<td>13:00</td>
				            <td>
								${agendamentoResponsavel.hora == 13 ? agendamentoResponsavel.titulo : null}
				            	${agendamentoEnvolvido.hora == 13 ? agendamentoEnvolvido.titulo : null}
							</td>
				            <td>
								${agendamentoResponsavel.hora == 13 ? agendamentoResponsavel.descricao : null}
				            	${agendamentoEnvolvido.hora == 13 ? agendamentoEnvolvido.descricao : null}
							</td>
							<td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						<c:if test="${agendamentoResponsavel.hora != 13 || agendamentoEnvolvido.hora != 13}">
			            <tr>
			            	<td>13:00</td>
				            <td></td>
				            <td></td>
				            <td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						
						<c:if test="${agendamentoResponsavel.hora == 14 || agendamentoEnvolvido.hora == 14}">
			            <tr>
			            	<td>14:00</td>
				            <td>
								${agendamentoResponsavel.hora == 14 ? agendamentoResponsavel.titulo : null}
				            	${agendamentoEnvolvido.hora == 14 ? agendamentoEnvolvido.titulo : null}
							</td>
				            <td>
								${agendamentoResponsavel.hora == 14 ? agendamentoResponsavel.descricao : null}
				            	${agendamentoEnvolvido.hora == 14 ? agendamentoEnvolvido.descricao : null}
							</td>
							<td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						<c:if test="${agendamentoResponsavel.hora != 14 || agendamentoEnvolvido.hora != 14}">
			            <tr>
			            	<td>14:00</td>
				            <td></td>
				            <td></td>
				            <td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						
						<c:if test="${agendamentoResponsavel.hora == 15 || agendamentoEnvolvido.hora == 15}">
			            <tr>
			            	<td>15:00</td>
				            <td>
								${agendamentoResponsavel.hora == 15 ? agendamentoResponsavel.titulo : null}
				            	${agendamentoEnvolvido.hora == 15 ? agendamentoEnvolvido.titulo : null}
							</td>
				            <td>
								${agendamentoResponsavel.hora == 15 ? agendamentoResponsavel.descricao : null}
				            	${agendamentoEnvolvido.hora == 15 ? agendamentoEnvolvido.descricao : null}
							</td>
							<td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						<c:if test="${agendamentoResponsavel.hora != 15 || agendamentoEnvolvido.hora != 15}">
			            <tr>
			            	<td>15:00</td>
				            <td></td>
				            <td></td>
				            <td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						
						<c:if test="${agendamentoResponsavel.hora == 16 || agendamentoEnvolvido.hora == 16}">
			            <tr>
			            	<td>16:00</td>
				            <td>
								${agendamentoResponsavel.hora == 16 ? agendamentoResponsavel.titulo : null}
				            	${agendamentoEnvolvido.hora == 16 ? agendamentoEnvolvido.titulo : null}
							</td>
				            <td>
								${agendamentoResponsavel.hora == 16 ? agendamentoResponsavel.descricao : null}
				            	${agendamentoEnvolvido.hora == 16 ? agendamentoEnvolvido.descricao : null}
							</td>
							<td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						<c:if test="${agendamentoResponsavel.hora != 16 || agendamentoEnvolvido.hora != 16}">
			            <tr>
			            	<td>16:00</td>
				            <td></td>
				            <td></td>
				            <td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						
						<c:if test="${agendamentoResponsavel.hora == 17 || agendamentoEnvolvido.hora == 17}">
			            <tr>
			            	<td>17:00</td>
				            <td>
								${agendamentoResponsavel.hora == 17 ? agendamentoResponsavel.titulo : null}
				            	${agendamentoEnvolvido.hora == 17 ? agendamentoEnvolvido.titulo : null}
							</td>
				            <td>
								${agendamentoResponsavel.hora == 17 ? agendamentoResponsavel.descricao : null}
				            	${agendamentoEnvolvido.hora == 17 ? agendamentoEnvolvido.descricao : null}
							</td>
							<td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						<c:if test="${agendamentoResponsavel.hora != 17 || agendamentoEnvolvido.hora != 17}">
			            <tr>
			            	<td>17:00</td>
				            <td></td>
				            <td></td>
				            <td class="td-icon"><a href="/sw/agendamento/${agendamento.id}"><i class="material-icons" >border_color</i></a></td>
						</tr>
						</c:if>
						
          			</c:forEach>
        		</c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/sw/agendamentos/form">
                <i class="material-icons">add</i>
            </a>
         </div>
         
                  
         
	</div>  
<c:import url="../../../partials/js.jsp"></c:import>

<c:import url="../../../partials/footer.jsp"></c:import>