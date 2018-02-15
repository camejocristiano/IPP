<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../partials/header.jsp"></c:import>
<c:import url="../partials/navbar.jsp"></c:import>

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
	</div>
	
	  <c:url value="/sw/password" var="swUsuarioPassword"></c:url>
      <form:form role="form" commandName="usuario" servletRelativeAction="${swUsuarioPassword}" method="POST">
          	<div class="row">
				<div class="input-field s12 col l12">
                 	<input name='password' type='password'/>
					<label for="password">Senha</label>
               	</div>                  
            </div>
				<br>
                  <button class="btn waves-effect waves-light right" type="submit">
                    Salvar<i class="material-icons right">send</i>
                  </button>

        </form:form>
<br />
<br />
</div>
<c:import url="../partials/js.jsp"></c:import>
<c:import url="../partials/footer.jsp"></c:import>
<c:import url="../partials/final.jsp"></c:import>