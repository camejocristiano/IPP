<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../partials/header.jsp"></c:import>
<c:import url="../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<div class="row">
    <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Usuários</span>
              <p>Manutenção de Usuários</p>
            </div>
            <div class="card-action">
              <a href="#">Listar</a>
              <a href="#">Cadastrar</a>
            </div>
          </div></a>
          </div>
    <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Permissões</span>
              <p>Manutenção de Permissões</p>
            </div>
            <div class="card-action">
              <a href="#">Listar</a>
              <a href="#">Cadastrar</a>
            </div>
          </div></a></div>
    <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Unidades</span>
              <p>Manutenção de Unidades</p>
            </div>
            <div class="card-action">
              <a href="#">Listar</a>
              <a href="#">Cadastrar</a>
            </div>
          </div></a></div>
  </div>
  <div class="row">
      <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Canais</span>
              <p>Manutenção de Canais</p>
            </div>
            <div class="card-action">
              <a href="#">Listar</a>
              <a href="#">Cadastrar</a>
            </div>
          </div></a></div>
      <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Gerenciador de Arquivos</span>
              <p>Gerenciador de Arquivos</p>
            </div>
            <div class="card-action">
              <a href="#">Listar</a>
              <a href="#">Cadastrar</a>
            </div>
          </div></a></div>
      <div class="col s12 m6 l4"><a><div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Agendamentos</span>
              <p>Manutenção de Agendamentos</p>
            </div>
            <div class="card-action">
              <a href="#">Listar</a>
              <a href="#">Cadastrar</a>
            </div>
          </div></a></div>
  </div>  
</div>

<c:import url="../partials/js.jsp"></c:import>

<c:import url="../partials/footer.jsp"></c:import>