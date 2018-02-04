<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Fichas Profissionais:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/fichasProfissionais/form/${jovem.id}">
		 	<i class="material-icons">add</i>
		 </a>
	</div>
</div>
<table id="tabelaFichasProfissionais" class="display" width="100%" cellspacing="0">
	<thead>
    	<tr>
            <th>ID</th>
            <th>OBSERVAÇÕES</th>
            <th class="td-icon">EDITAR</th>
        </tr>
	</thead>
	<tbody>
        <c:forEach var="fichaProfissional" items="${requestScope.fichasProfissionais}">
          <tr>
            <td>${fichaProfissional.id}</td>
            <td>${fichaProfissional.observacoesSituacaoProfissional}</td>
            <td class="td-icon"><a href="/fichasProfissionais/${fichaProfissional.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
        </c:forEach>
    </tbody>
</table> 
<br />
<br />

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Entrevistas:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/entrevistas/form/${jovem.id}">
		 	<i class="material-icons">add</i>
		 </a>
	</div>
</div>
<c:import url="../profissionais/entrevistas/entrevistas.jsp"></c:import>
<br />
<br />

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Contratações:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/contratacoes/form/${jovem.id}">
		 	<i class="material-icons">add</i>
		 </a>
	</div>
</div>
<c:import url="../profissionais/contratacoes/contratacoes.jsp"></c:import>
<br />
<br />

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Dispensas:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/dispensas/form/${jovem.id}">
		 	<i class="material-icons">add</i>
		 </a>
	</div>
</div>
<c:import url="../profissionais/dispensas/dispensas.jsp"></c:import>
<br />
<br />