<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Ocorrências:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/ocorrencias/form/${jovem.id}">
		 	<i class="material-icons">add</i>
		 </a>
	</div>
</div>
<c:import url="../historicos/ocorrencias/ocorrencias.jsp"></c:import>
<br />
<br />

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Avaliações PITs e PIPs:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/avaliacoesPITsEPIPs/form/${jovem.id}">
                <i class="material-icons">add</i>
            </a>
	</div>
</div>
<c:import url="../historicos/pitsepips/pitsepips.jsp"></c:import>
<br />
<br />

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Avaliações PIOs:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/avaliacoesPIOs/form/${jovem.id}">
                <i class="material-icons">add</i>
            </a>
	</div>
</div>
<c:import url="../historicos/pios/pios.jsp"></c:import>
<br />
<br />

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Avaliações PAPs IPP:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/avaliacoesPAPsIPP/form/${jovem.id}">
                <i class="material-icons">add</i>
            </a>
	</div>
</div>
<c:import url="../historicos/paps/paps.jsp"></c:import>
<br />
<br />

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Avaliações PAPs Empresa:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/avaliacoesPAPsEmpresa/form/${jovem.id}">
                <i class="material-icons">add</i>
            </a>
	</div>
</div>
<c:import url="../historicos/empresas/paps.jsp"></c:import>
<br />
<br />

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Históricos:</h4>
		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/historicos/form/${jovem.id}">
		   	 <i class="material-icons">add</i>
		 </a>
	</div>
</div>
<table id="tabelaAgendamentos" class="display" width="100%" cellspacing="0">
    <thead>
    	<tr>
            <th>ID</th>
            <th>OBSERVAÇÕES</th>
            <th class="td-icon">EDITAR</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="historico" items="${requestScope.historicos}">
    	<tr>
            <td>${historico.id}</td>
            <td>${historico.observacoes}</td>
            <td class="td-icon"><a href="/historicos/${historico.id}"><i class="material-icons" >border_color</i></a></td>
        </tr>
    </c:forEach>
	</tbody>
</table> 