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
			<h4 class="header right black-text">${usuario.nome != null ? usuario.nome : "Usuário"}</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>

    <c:url value="/sw/arquivo/${arquivo.nomeDoArquivo != null ? arquivo.id : null}" var="enviarArquivo"></c:url>
		<form method="POST" enctype="multipart/form-data" action="${enviarArquivo}">
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
                <select name="localDoArquivo">
                    	<option value="${arquivo.localDoArquivo}" label="${arquivo.localDoArquivo == null ? 'Local do Arquivo' : arquivo.localDoArquivo}" />
						<c:forEach var="localDoArquivo" items="${requestScope.locaisDosArquivos}">
							<option value="${localDoArquivo}">${localDoArquivo}</option>							
						</c:forEach>
					</select>	
                <label for="localDoArquivo"></label>
          </div>
      </div>
      <br><br>
      
      <button class="btn waves-effect waves-light right" type="submit">
          Salvar<i class="material-icons right">send</i>
        </button>
    </form>
</div>
<br />
<br />
<br />
<br />


</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>