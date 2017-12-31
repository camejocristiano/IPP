<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

        <h5>Gerenciador de Arquivos</h5>
        <br><br>

<div class="row">
    <form class="col s12">

      <div class="row">         
          <div class="file-field input-field s12 col l12">
              <div class="btn s12 col l1">
                  <span>Arquivo</span>
                  <input type="file" multiple>
              </div>              
              <div class="file-path-wrapper s12 col l11">
                <input class="file-path validate" type="text" placeholder="Upload um ou mais arquivos">
              </div>
            </div>
            <div class="input-field s12 col l3">
                <select>
                  <option value="" disabled selected>Localização</option>
                  <option value="1">JOVENS</option>
                  <option value="2">USUARIOS</option>
                  <option value="2">BANCOS</option>
                </select>
                <label></label>
          </div>
      </div>
      <br><br>
      <button class="btn waves-effect waves-light right" type="submit">
          Salvar<i class="material-icons right">send</i>
        </button>
    </form>
  </div>

</div>

<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>