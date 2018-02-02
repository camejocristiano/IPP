<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--     <c:out value="${user.nome}"></c:out>
            <c:out value="${user.telefone}"></c:out>
            <c:out value="${user.ramal}"></c:out>
            <c:out value="${user.username}"></c:out>
            <c:out value="${user.admin}"></c:out> --%>

<c:import url="../partials/header.jsp"></c:import>

<c:import url="../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<div class="row">
    <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
    		<a href="" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Listar Usuários">
    			<i class="material-icons right" style="color: #eee !important;">info_outline</i>
    		</a>
            <a href="#">
	            <div class="card-content white-text">
	              <span class="card-title">Usuários<i class="material-icons right" style="color: #eee !important;">people_outline</i></span>
	              <p>Manutenção de Usuários</p>
	            </div>
            </a>
            <a href="#" class="btn-index">
	            <div class="card-action orange-text lighten-5">
	              <h6 style="color: #eee;" class="btn-index">Cadastrar</h6>
	            </div>
            </a>
          </div></a>
          </div>
    <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
            <a href="#">
	            <div class="card-content white-text">
	              <span class="card-title">Permissões<i class="material-icons right" style="color: #eee !important;">lock_outline</i></span>
	              <p>Manutenção de Permissões</p>
	            </div>
			</a>
			<a href="#" class="btn-index">
	            <div class="card-action">
	              <h6 style="color: #eee !important;">Cadastrar</h6>
	            </div>
            </a>
          </div></a></div>
    <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
            <a href="#">
	            <div class="card-content white-text">
	              <span class="card-title">Unidades<i class="material-icons right" style="color: #eee !important;">business</i></span>
	              <p>Manutenção de Unidades</p>
	            </div>
            </a>
			<a href="#" class="btn-index">
	            <div class="card-action">
	              <h6 style="color: #eee !important;">Cadastrar</h6>
	            </div>
			</a>
          </div></a></div>
  </div>
  <div class="row">
      <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
	        <a href="#">    
	            <div class="card-content white-text">
	              <span class="card-title">Canais<i class="material-icons right" style="color: #eee !important;">language</i></span>
	              <p>Manutenção de Canais</p>
	            </div>
            </a>
			<a href="#" class="btn-index">
	            <div class="card-action">
	              <h6 style="color: #eee !important;">Cadastrar</h6>
	            </div>
			</a>
          </div></a></div>
      <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
      		<a href="#">
	            <div class="card-content white-text">
	              <span class="card-title">Arquivos<i class="material-icons right" style="color: #eee !important;">attach_file</i></span>
	              <p>Gerenciador de Arquivos</p>
                </div>
            </a>
			<a href="#" class="btn-index">
	            <div class="card-action">
	              <h6 style="color: #eee !important;">Cadastrar</h6>
	            </div>
			</a>
          </div></a></div>
      <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
      		<a href="#">
	            <div class="card-content white-text">
	              <span class="card-title">Agendamentos<i class="material-icons right" style="color: #eee !important;">event_note</i></span>
	              <p>Manutenção de Agendamentos</p>
                 </div>
            </a>
			<a href="#" class="btn-index">
	            <div class="card-action">
	              <h6 style="color: #eee !important;">Cadastrar</h6>
	            </div>
			</a>
          </div></a></div>
  </div>  
</div>

<c:import url="../partials/js.jsp"></c:import>

<c:import url="../partials/footer.jsp"></c:import>