<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaCursos" class="display" width="100%" cellspacing="0">
        <thead>
          <tr>
            <th>MATRICULA</th>
            <th>JOVEM</th>
            <th>DATA</th>
            <th>FREQUÊNCIA</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="pITEPIP" items="${requestScope.pITsEPIPs}">
          <tr>
            <td>${pITEPIP.matricula.id}</td>
            <td>${pITEPIP.matricula.jovem.nome}</td>
            <td>${pITEPIP.dia}/${pITEPIP.mes}/${pITEPIP.ano}</td>
            <td>${pITEPIP.frequencia}</td>
            <td class="td-icon"><a href="/pITsEPIPs/${pITEPIP.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/pITsEPIPs/form">
                <i class="material-icons">add</i>
            </a>
         </div>