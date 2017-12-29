<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../partials/header.jsp"></c:import>
<c:import url="../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<div class="row">
    <div class="col s12">
      <ul class="tabs">
        <li class="tab col s2"><a href="#usuarios">Usuários</a></li>
        <li class="tab col s2"><a href="#permissoes">Permissões</a></li>
        <li class="tab col s2"><a href="#unidades">Unidades</a></li>
        <li class="tab col s2"><a href="#canais">Canais</a></li>
        <li class="tab col s2"><a href="#arquivos">Arquivos</a></li>
        <li class="tab col s2"><a href="#agendamentos">Agendamentos</a></li>
      </ul>
    </div>
    <div id="usuarios" class="col s12">
        <div class="row">
            <c:import url="usuarios/usuarios.jsp"></c:import>           
        </div>
    </div>
    <div id="permissoes" class="col s12">
       permissoes
    </div>
    <div id="unidades" class="col s12">
       <c:import url="unidades/unidades.jsp"></c:import>  
    </div>  
    <div id="canais" class="col s12">
        canais
    </div> 
    
    <div id="arquivos" class="col s12">
        arquivos
    </div>  
    
    <div id="agendamentos" class="col s12">
        agendamentos
    </div>
  </div>
  
  </div>
  
<c:import url="../../partials/footer.jsp"></c:import>