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
      <form:form role="form" commandName="usuario" servletRelativeAction="/usuarios/${usuario.id}" method="POST">
    		<div class="row">
            <div class="input-field  s12 col l2">
              <img src="../../../assets/images/usuario.png" alt="" width="175em" />
            </div>
            <div class="input-field s12 col l10">
                <div class="row">
                  <div class="input-field s12 col l6">
                    <form:input path='nome' type='text' required="required" />
					<form:errors path='nome'/> 
					<label for="nome">Nome</label>
                  </div>
                  <div class="input-field s12 col l3">
                    <form:input id="dataDeNascimento" path="dataDeNascimento" type="date" class="validate datepicker" placeholder="Data de Nascimento" /> 
                  </div>
                  <div class="input-field s12 col l3">
					Sexo
                  </div>
                </div>
                <div class="row">
                    <div class="input-field s12 col l3">
                      	<form:input path='cPF' type='text' required="required" />
						<form:errors path='cPF'/> 
						<label for="cPF">CPF</label>
                    </div>
                    <div class="input-field s12 col l3">
                      	<form:input path='rG' type='text'/>
						<form:errors path='rG'/> 
						<label for="rG">RG</label>
                    </div>
                    <div class="input-field s12 col l3">
                      	<form:input path='orgaoEmissorRG' type='text'/>
						<form:errors path='orgaoEmissorRG'/> 
						<label for="orgaoEmissorRG">Orgão Emissor RG</label>
                    </div>
                    <div class="input-field s12 col l3">
                      <form:input path="dataDeExpedicaoRG" type="date" class="validate datepicker" placeholder="Data de Expedição RG" />
                    </div>
                </div>
            </div>
          </div>

          <div class="row">
            <div class="input-field col s12">
              <div class="row">
                <div class="input-field s12 col l3">
					Relação Funcional
                </div>
                <div class="input-field s12 col l4">
                  <form:input path='endereco' type='text'/>
						<form:errors path='endereco'/> 
						<label for="endereco">Endereço</label>
                </div>
                <div class="input-field s12 col l1">
                  <form:input path='numero' type='text'/>
						<form:errors path='numero'/> 
						<label for="numero">Número</label>
                </div>
                <div class="input-field s12 col l2">
                  <form:input path='telefone' type='text'/>
						<form:errors path='telefone'/> 
						<label for="telefone">Telefone</label>
                </div>
                <div class="input-field s12 col l2">
                  <form:input path='celular' type='text'/>
						<form:errors path='celular'/> 
						<label for="celular">Celular</label>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
              <div class="input-field col s12">
                <div class="row">                  
                  <div class="input-field s12 col l2">
                    <form:input path='complemento' type='text'/>
						<form:errors path='complemento'/> 
						<label for="complemento">Complemento</label>
                  </div>
                  <div class="input-field s12 col l2">
                    <form:input path='bairro' type='text'/>
						<form:errors path='bairro'/> 
						<label for="bairro">Bairro</label>
                  </div>
                  <div class="input-field s12 col l2">
						Região
                  </div>
                  <div class="input-field s12 col l2">
                    <form:input path='cEP' type='text'/>
						<form:errors path='cEP'/> 
						<label for="cEP">CEP</label>
                  </div>
                  <div class="input-field s12 col l2">
                    <form:input path='estado' type='text'/>
						<form:errors path='estado'/> 
						<label for="estado">Estado</label>
                  </div>
                  <div class="input-field s12 col l2">
                    <form:input path='cidade' type='text'/>
						<form:errors path='cidade'/> 
						<label for="cidade">Cidade</label>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
                <div class="input-field col s12">
                  <div class="row">                  
                      <div class="input-field s12 col l2">
							Estado Civil
                      </div>
                    <div class="input-field s12 col l2">
                      <form:input path='cargo' type='text'/>
						<form:errors path='cargo'/> 
						<label for="cargo">Cargo</label>
                    </div>
                    <div class="input-field s12 col l2">
                      <form:input path='habilitacao' type='text'/>
						<form:errors path='habilitacao'/> 
						<label for="habilitacao">Habilitação</label>
                    </div>
                    <div class="input-field s12 col l2">
                      <form:input path='disciplina' type='text'/>
						<form:errors path='disciplina'/> 
						<label for="disciplina">Disciplina</label>
                    </div>
                    <div class="input-field s12 col l2">
                      <form:input path='formacao' type='text'/>
						<form:errors path='formacao'/> 
						<label for="formacao">Formação</label>
                    </div>
                    <div class="input-field s12 col l2">
						Status
                    </div>
                  </div>
                </div>
              </div>
          
              <div class="row">
                  <div class="input-field col s12">
                    <div class="row">                  
                      <div class="input-field s12 col l3">
                        <form:input path="dataExpedicaoCTPS" type="text" class="validate datepicker" placeholder="Data Expedição CTPS" />
                      </div>
                      <div class="input-field s12 col l3">
						Numero
                      </div>
                      <div class="input-field s12 col l3">
                        <form:input path='serieCTPS' type='text' />
						<form:errors path='serieCTPS'/> 
						<label for="serieCTPS">Série CTPS</label>
                      </div>
                      <div class="input-field s12 col l3">
                        <form:input path='cNPJMEI' type='text'/>
						<form:errors path='cNPJMEI'/> 
						<label for="cNPJMEI">CNPJ / MEI</label>
                      </div>
                      
                    </div>
                  </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                      <div class="row">     
                        <div class="input-field s12 col l3 border-form">Admissão
                          <form:input path="dataDeAdmissao" type="text" class="validate datepicker" placeholder="Data de Admissão" />
                          <form:input path="dataDeDesligamento" type="text" class="validate datepicker" placeholder="Data de Desligamento" />
                          <div><br><br><br></div>
                        </div>
                        <div class="input-field s12 col l5 border-form">CTPS
                          <form:input path="uFCTPS" type="text" class="validate" placeholder="CTPS-UF" />
                          <form:input id="dataExpedicaoCTPS" path="dataExpedicaoCTPS" type="date" class="validate datepicker" placeholder="Data de Expedição CTPS" /> 
                        </div>
                        <div class="input-field s12 col l4 border-form">Dados de Acesso
                          	<form:input path='email' type='text' placeholder="E-Mail" required="required" />
							<form:errors path='email'/> 
							<br />
							<form:input path='username' type='text' placeholder="Username" required="required" />
							<form:errors path='username'/> 
                        </div>
                      </div>
                    </div>
                  </div>
                  
                  <div class="row">
	                <div class="input-field col s12">
						Permissões
					</div>
                    <div class="input-field col s12">
                    <form:textarea path="observacoes" />
                    <form:label path="observacoes"></form:label>
                    </div>
                  </div>
				  <div>
				<br>
			</div>
                  <button class="btn waves-effect waves-light right" type="submit">
                    Salvar<i class="material-icons right">send</i>
                  </button>

        </form:form>
      </div>

              <div class="row">
                  <div class="input-field col s12">
  <a class="waves-effect waves-light btn modal-trigger" href="#modal1">Lista de Permissões</a>
</div>
</div>

				  <!-- Modal Structure -->
				<div id="modal1" class="modal">
					<div class="modal-content">
						<div class="row" style="background-color: white !important">
							<div class="col s12">
								<hr>
								<h5>Lista de Permissões</h5>
								<!-- Modal Trigger -->

								<div class="row">
									<div class="col s12">
										<p id="descricao">
											Descrição <label style="margin-left: 2em; float: right"
												for="filled-in-box">Listar</label> <label
												style="margin-left: 2em; float: right" for="filled-in-box">Editar</label>
											<label style="margin-left: 2em; float: right"
												for="filled-in-box">Visualizar</label> <label
												style="margin-left: 2em; float: right" for="filled-in-box">Cadastrar</label>
										</p>
										<hr>
									</div>
								</div>

								<div class="row">

									<div class="col s12">
										<h6>Configurações</h6>
										<p>
											Usuários <input type="checkbox" name="usuarioListar"
												class="filled-in" id="usuarioListar"
												<c:if test="${grupoDePermissoes.usuarioListar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="usuarioListar"></label> <input type="checkbox"
												name="usuarioEditar" class="filled-in" id="usuarioEditar"
												<c:if test="${grupoDePermissoes.usuarioEditar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="usuarioEditar"></label> <input type="checkbox"
												name="usuarioVisualizar" class="filled-in"
												id="usuarioVisualizar"
												<c:if test="${grupoDePermissoes.usuarioVisualizar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="usuarioVisualizar"></label> <input type="checkbox"
												name="usuarioCadastrar" class="filled-in"
												id="usuarioCadastrar"
												<c:if test="${grupoDePermissoes.usuarioCadastrar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="usuarioCadastrar"></label>
										</p>
										<hr>
										<p>
											Grupos de Permissões <input type="checkbox"
												name="grupoDePermissoesListar" class="filled-in"
												id="grupoDePermissoesListar"
												<c:if test="${grupoDePermissoes.grupoDePermissoesListar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="grupoDePermissoesListar"></label> <input
												type="checkbox" name="grupoDePermissoesEditar"
												class="filled-in" id="grupoDePermissoesEditar"
												<c:if test="${grupoDePermissoes.grupoDePermissoesEditar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="grupoDePermissoesEditar"></label> <input
												type="checkbox" name="grupoDePermissoesVisualizar"
												class="filled-in" id="grupoDePermissoesVisualizar"
												<c:if test="${grupoDePermissoes.grupoDePermissoesVisualizar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="grupoDePermissoesVisualizar"></label> <input
												type="checkbox" name="grupoDePermissoesCadastrar"
												class="filled-in" id="grupoDePermissoesCadastrar"
												<c:if test="${grupoDePermissoes.grupoDePermissoesCadastrar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="grupoDePermissoesCadastrar"></label>
										</p>
										<hr>
										<p>
											Unidades <input type="checkbox" name="unidadeListar"
												class="filled-in" id="unidadeListar"
												<c:if test="${grupoDePermissoes.unidadeListar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="unidadeListar"></label> <input type="checkbox"
												name="unidadeEditar" class="filled-in" id="unidadeEditar"
												<c:if test="${grupoDePermissoes.unidadeEditar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="unidadeEditar"></label> <input type="checkbox"
												name="unidadeVisualizar" class="filled-in"
												id="unidadeVisualizar"
												<c:if test="${grupoDePermissoes.unidadeVisualizar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="unidadeVisualizar"></label> <input type="checkbox"
												name="unidadeCadastrar" class="filled-in"
												id="unidadeCadastrar"
												<c:if test="${grupoDePermissoes.unidadeCadastrar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="unidadeCadastrar"></label>
										</p>
										<hr>
										<p>
											Canais <input type="checkbox" name="canalListar"
												class="filled-in" id="canalListar"
												<c:if test="${grupoDePermissoes.canalListar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="canalListar"></label> <input type="checkbox"
												name="canalEditar" class="filled-in" id="canalEditar"
												<c:if test="${grupoDePermissoes.canalEditar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="canalEditar"></label> <input type="checkbox"
												name="canalVisualizar" class="filled-in"
												id="canalVisualizar"
												<c:if test="${grupoDePermissoes.canalVisualizar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="canalVisualizar"></label> <input type="checkbox"
												name="canalCadastrar" class="filled-in" id="canalCadastrar"
												<c:if test="${grupoDePermissoes.canalCadastrar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="canalCadastrar"></label>
										</p>
										<hr>
										<p>
											Gerenciador de Arquivos <input type="checkbox"
												name="arquivoListar" class="filled-in" id="arquivoListar"
												<c:if test="${grupoDePermissoes.arquivoListar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="arquivoListar"></label> <input type="checkbox"
												name="arquivoEditar" class="filled-in" id="arquivoEditar"
												<c:if test="${grupoDePermissoes.arquivoEditar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="arquivoEditar"></label> <input type="checkbox"
												name="arquivoVisualizar" class="filled-in"
												id="arquivoVisualizar"
												<c:if test="${grupoDePermissoes.arquivoVisualizar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="arquivoVisualizar"></label> <input type="checkbox"
												name="arquivoCadastrar" class="filled-in"
												id="arquivoCadastrar"
												<c:if test="${grupoDePermissoes.arquivoCadastrar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="arquivoCadastrar"></label>
										</p>
										<hr>
										<p>
											Agendamentos <input type="checkbox" name="agendamentoListar"
												class="filled-in" id="agendamentoListar"
												<c:if test="${grupoDePermissoes.agendamentoListar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="agendamentoListar"></label> <input type="checkbox"
												name="agendamentoEditar" class="filled-in"
												id="agendamentoEditar"
												<c:if test="${grupoDePermissoes.agendamentoEditar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="agendamentoEditar"></label> <input type="checkbox"
												name="agendamentoVisualizar" class="filled-in"
												id="agendamentoVisualizar"
												<c:if test="${grupoDePermissoes.agendamentoVisualizar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="agendamentoVisualizar"></label> <input type="checkbox"
												name="agendamentoCadastrar" class="filled-in"
												id="agendamentoCadastrar"
												<c:if test="${grupoDePermissoes.agendamentoCadastrar == true}">checked</c:if> />
											<label style="margin-left: 2em; float: right"
												for="agendamentoCadastrar"></label>
										</p>
										<hr>
									</div>
								</div>


								<div class="row">

									<div class="col s12">
										<h6>Cursos</h6>
										<p>
											Cursos <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Mtrículas <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Turmas <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>

									</div>
								</div>


								<div class="row">

									<div class="col s12">
										<h6>Aprendizes</h6>
										<p>
											Jovens <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Cursos IPP <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Escolaridade <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Situação Laboral <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Características Domiciliares <input type="checkbox"
												class="filled-in" id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Habilidades <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Situação de Saúde <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Ficha Social <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Ficha Profissional <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Históricos <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Dados Financeiros <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
									</div>
								</div>

								<div class="row">

									<div class="col s12">
										<h6>Frequências</h6>
										<p>
											PIT e PIP <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											PAP <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											PIO <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Aulas Extras <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>

									</div>
								</div>


								<div class="row">

									<div class="col s12">
										<h6>Empresas</h6>
										<p>
											Empresas <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Gestores <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Setores <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
										<p>
											Históricos <input type="checkbox" class="filled-in"
												id="filled-in-box" checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
											<input type="checkbox" class="filled-in" id="filled-in-box"
												checked="checked" /><label
												style="margin-left: 2em; float: right" for="filled-in-box"></label>
										</p>
										<hr>
				  	<br>
	
					<div class="modal-footer">
						<a class="modal-close btn-flat"><i class="material-icons" >close</i></a>
					</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					</div>

</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<script type="text/javascript">
$(document).ready(function() {
	$('select').material_select();
});

$('.datepicker').pickadate({
	monthsFull: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
	monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
	weekdaysFull: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabádo'],
	weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
	weekdaysLetter: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
	today: 'Hoje',
	clear: 'Limpar',
	close: 'Pronto',
	labelMonthNext: 'Próximo mês',
	labelMonthPrev: 'Mês anterior',
	labelMonthSelect: 'Selecione um mês',
	labelYearSelect: 'Selecione um ano',
	selectMonths: true,
	selectYears: 99,
    format: 'dd/mm/yyyy' 
});
  
$('.timepicker').pickatime({
	"default": 'now',
	twelvehour: false, // change to 12 hour AM/PM clock from 24 hour
	donetext: 'OK',
	autoclose: false,
	vibrate: true // vibrate the device when dragging clock hand
});


$(document).ready(function(){
    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });
        
</script>

<c:import url="../../../partials/final.jsp"></c:import>