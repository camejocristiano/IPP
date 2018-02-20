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
		
  <!-- Modal Structure -->
  <div id="modal1" class="modal">
    <div class="modal-content">
      <c:url value="/sw/usuario/foto/${usuario.id}" var="enviarImagem"></c:url>
		<form method="POST" enctype="multipart/form-data" action="${enviarImagem}">
			<h3>Foto - Usuário</h3>
			<hr />
			<hr />
			<div class="btn">
		        <span>File</span>
		        <input type="file" name="file" />
		      </div>
		      
			<button class="btn waves-effect waves-light" type="submit" name="action">Submit
			    <i class="material-icons right">send</i>
			  </button>
		</form>
    </div>
    <hr />
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cancelar</a>
    </div>
  </div>
	</div>
	  <c:url value="/sw/usuario/${usuario.nome != null ? usuario.id : null}" var="swUsuarioForm"></c:url>
      <form:form role="form" commandName="usuario" servletRelativeAction="${swUsuarioForm}" method="POST">

    	<div class="row">
            <div class="input-field  s12 col l2">
              <c:url value="/sw/file/${usuario.foto}" var="usuarioPng"></c:url>
        	<!-- Modal Trigger -->
  			<a class="modal-trigger" href="#modal1">
              <img src="${usuarioPng}" alt="FOTO" width="175em" />
  			</a>
            <input type="hidden" value="${usuario.foto}" name="foto" />
            </div><!-- // col -->
            <div class="input-field s12 col l10">
                <div class="row">
                  <div class="input-field s12 col l6">
                    <form:input path='nome' type='text' required="required" />
					<form:errors path='nome'/> 
					<label for="nome">Nome</label>
                  </div><!-- // col -->
                  <div class="input-field s12 col l3">
                    <form:input id="dataDeNascimento" path="dataDeNascimento" type="text" class="validate datepicker" placeholder="Data de Nascimento" value="${usuario.dataDeNascimento}" /> 
                  </div><!-- // col -->
                  <div class="input-field s12 col l3">
                    <form:select path="sexo">
                    	<form:option value="${usuario.sexo}" label="${usuario.sexo == null ? 'Sexo' : usuario.sexo}" />
						<c:forEach var="sexo" items="${requestScope.sexo}">
							<form:option value="${sexo}">${sexo}</form:option>							
						</c:forEach>
					</form:select>	
                  </div><!-- // col -->
                </div><!-- // row -->
                <div class="row">
                    <div class="input-field s12 col l3">
                      	<form:input path='cPF' type='text' required="required" />
						<form:errors path='cPF'/> 
						<label for="cPF">CPF</label>
                    </div><!-- // col -->
                    <div class="input-field s12 col l3">
                      	<form:input path='rG' type='text'/>
						<form:errors path='rG'/> 
						<label for="rG">RG</label>
                    </div><!-- // col -->
                    <div class="input-field s12 col l3">
                      	<form:input path='orgaoEmissorRG' type='text'/>
						<form:errors path='orgaoEmissorRG'/> 
						<label for="orgaoEmissorRG">Orgão Emissor RG</label>
                    </div><!-- // col -->
                    <div class="input-field s12 col l3">
                      <form:input path="dataDeExpedicaoRG" type="text" class="validate datepicker" placeholder="Data de Expedição RG" />
                    </div><!-- // col -->
                </div><!-- // row -->
            </div><!-- // col -->
          </div><!-- // row -->


          <div class="row">
            <div class="input-field col s12">
              <div class="row">
                <div class="input-field s12 col l3">
                    <form:select path="relacaoFuncional">
						<form:option value="${usuario.relacaoFuncional}" label="${usuario.relacaoFuncional == null ? 'Relação Funcional' : usuario.relacaoFuncional}" />
						<c:forEach var="relacaoFuncional" items="${requestScope.relacaoFuncional}">
							<option>${relacaoFuncional}</option>							
						</c:forEach>
					</form:select>
                </div><!-- // col -->
                <div class="input-field s12 col l4">
                  <form:input path='endereco' type='text'/>
						<form:errors path='endereco'/> 
						<label for="endereco">Endereço</label>
                </div><!-- // col -->
                <div class="input-field s12 col l1">
                  <form:input path='numero' type='text'/>
						<form:errors path='numero'/> 
						<label for="numero">Número</label>
                </div><!-- // col -->
                <div class="input-field s12 col l2">
                  <form:input path='telefone' type='text'/>
						<form:errors path='telefone'/> 
						<label for="telefone">Telefone</label>
                </div><!-- // col -->
                <div class="input-field s12 col l2">
                  <form:input path='celular' type='text'/>
						<form:errors path='celular'/> 
						<label for="celular">Celular</label>
                </div><!-- // col -->
              </div><!-- // row -->
            </div><!-- // col -->
          </div><!-- // row -->
          
          
          <div class="row">
              <div class="input-field col s12">
                <div class="row">                  
                  <div class="input-field s12 col l2">
                    <form:input path='complemento' type='text'/>
						<form:errors path='complemento'/> 
						<label for="complemento">Complemento</label>
                  </div><!-- // col -->
                  <div class="input-field s12 col l2">
                    <form:input path='bairro' type='text'/>
						<form:errors path='bairro'/> 
						<label for="bairro">Bairro</label>
                  </div><!-- // col -->
                  <div class="input-field s12 col l2">
                    <form:select path="regiao">
						<form:option value="${usuario.regiao}" label="${usuario.regiao == null ? 'Região' : usuario.regiao}" />
						<c:forEach var="regiao" items="${requestScope.regiao}">
							<option>${regiao}</option>							
						</c:forEach>
					</form:select>
                  </div><!-- // col -->
                  <div class="input-field s12 col l2">
                    <form:input path='cEP' type='text'/>
						<form:errors path='cEP'/> 
						<label for="cEP">CEP</label>
                  </div><!-- // col -->
                  <div class="input-field s12 col l2">
                    <form:input path='estado' type='text'/>
						<form:errors path='estado'/> 
						<label for="estado">Estado</label>
                  </div><!-- // col -->
                  <div class="input-field s12 col l2">
                    <form:input path='cidade' type='text'/>
						<form:errors path='cidade'/> 
						<label for="cidade">Cidade</label>
                  </div><!-- // col -->
                </div><!-- // row -->
              </div><!-- // col -->
            </div><!-- // row -->
          
            <div class="row">
                <div class="input-field col s12">
                  <div class="row">                  
                      <div class="input-field s12 col l3">
                        <form:select path="estadoCivil">
							<form:option value="${usuario.estadoCivil}" label="${usuario.estadoCivil == null ? 'Estado Civil' : usuario.estadoCivil}" />
							<c:forEach var="estadoCivil" items="${requestScope.estadoCivil}">
								<option>${estadoCivil}</option>							
							</c:forEach>
						</form:select>
                      </div><!-- // col -->
                    <div class="input-field s12 col l3">
                      <form:input path='cargo' type='text'/>
						<form:errors path='cargo'/> 
						<label for="cargo">Cargo</label>
                    </div><!-- // col -->
                    <div class="input-field s12 col l3">
                      <form:input path='habilitacao' type='text'/>
						<form:errors path='habilitacao'/> 
						<label for="habilitacao">Habilitação</label>
                    </div><!-- // col -->
                    <div class="input-field s12 col l3">
                      <form:input path='disciplina' type='text'/>
						<form:errors path='disciplina'/> 
						<label for="disciplina">Disciplina</label>
                    </div><!-- // col -->
                  </div><!-- // row -->
                </div><!-- // col -->
              </div><!-- // row -->
              
              		<div class="row">     
                        <div class="input-field s12 col l2 border-form">Admissão
                          <form:input path="dataDeAdmissao" type="text" class="validate datepicker" placeholder="Data de Admissão" />
                          <form:input path="dataDeDesligamento" type="text" class="validate datepicker" placeholder="Data de Desligamento" />
                          <div><br><br><br></div>
                        </div><!-- // col -->
                        
                        <div class="input-field s12 col l3 border-form">CTPS
                          <form:input path="formacao" type="text" class="validate" placeholder="Formação" />
                          <form:input path="numeroCTPS" type="text" class="validate" placeholder="CTPS-Nº" />
                          <form:input path="uFCTPS" type="text" class="validate" placeholder="UF de Expedição CTPS" /> 
                        </div><!-- // col -->
                        <div class="input-field s12 col l3 border-form">...
                          <form:input path="cNPJMEI" type="text" class="validate" placeholder="CNPJ-MEI" />
                          <form:input path="serieCTPS" type="text" class="validate" placeholder="CTPS-Série" />
                          <form:input path="dataExpedicaoCTPS" type="text" class="validate datepicker" placeholder="Data de Expedição CTPS" /> 
                        </div><!-- // col -->
                        
                        <div class="input-field s12 col l4 border-form">Dados de Acesso
							<form:input path='username' type='email' placeholder="E-Mail" required="required" />
							<form:errors path='username'/>
							<c:if test="${usuarioSessao.id == usuario.id}">
							<a class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Link para alteração da senha!"><i class="material-icons" style="color: #222 !important;">info_outline</i></a>
								<c:url value="/sw/alterarSenha" var="swAlterarSenha"></c:url>
								<a href="${swAlterarSenha}">Alterar Senha</a>
							</c:if>
							<input type="hidden" name="password" value="${usuario.password}" />
							<br />
							<br />
							<form:select path="status">
		                    	<form:option value="${usuario.status}" label="${usuario.status == null ? 'Status' : usuario.status}" />
								<c:forEach var="status" items="${requestScope.status}">
									<form:option value="${status}">${status}</form:option>							
								</c:forEach>
							</form:select>	
                        </div>
                	</div><!-- // row -->
          
          		<div class="row">
                    <div class="input-field col s12">
                    	<form:textarea path="curriculoResumido" />
						<form:errors path="curriculoResumido"></form:errors>
						<form:label path="curriculoResumido">Currículo Resumido</form:label>
                    </div><!-- // col -->
                 </div><!-- // row -->
              <div class="row">
              		<div class="input-field col s12 l5">
						<form:select path="unidade">
                			<form:option  value="${usuario.unidade}" label="${usuario.unidade == null ? 'Unidade' : usuario.unidade.nomeFantazia}" />
							<c:forEach var="unidade" items="${requestScope.unidades}">
								<option value="${unidade.id}">${unidade.nomeFantazia}</option>							
							</c:forEach>
						</form:select>
					</div><!-- // col -->
	                <div class="input-field col s12 l5">
	                <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.grupoDePermissoesCadastrar == true
	                 		   || requestScope.usuarioSessao.grupoDePermissoes.grupoDePermissoesEditar == true}">
						<form:select path="grupoDePermissoes">
                			<form:option  value="${usuario.grupoDePermissoes}" label="${usuario.grupoDePermissoes == null ? 'Grupo De Permissoes' : usuario.grupoDePermissoes.grupo}" />
							<c:forEach var="grupoDePermissoes" items="${requestScope.gruposDePermissoes}">
								<option value="${grupoDePermissoes.id}">${grupoDePermissoes.grupo}</option>							
							</c:forEach>
						</form:select>
					</c:if>
					</div><!-- // col -->
	                <div class="col s12 l12">
	                	<a style="margin-left: 2em; float: right" class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Caso este esteja selecionado, mostrará as listas gerais, de todas as unidades."><i class="material-icons" style="color: #222 !important;">info_outline</i></a>
	                	<input type="checkbox" name="admin" class="filled-in" id="admin" <c:if test="${usuario.admin == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="admin">Admin</label>
					</div><!-- // col -->
				</div><!-- // row -->
				<div class="row">
                    <div class="input-field col s12">
                    	<form:textarea path="observacoes" />
						<form:errors path="observacoes"></form:errors>
						<form:label path="observacoes">Observações</form:label>
                    </div><!-- // col -->
                 </div><!-- // row -->
				<br>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.usuarioCadastrar == true && requestScope.usuario.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.usuarioEditar == true && requestScope.usuario.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>


        </form:form>
<br />
<br />
</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>