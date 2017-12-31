<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
  
<h3 class="${requestScope.corMsg} col s12">${requestScope.msg}</h3>
  <div class="row">
      <form:form role="form" commandName="usuario" servletRelativeAction="/usuarios/${usuario.id}" method="POST">
    		<div class="row">
            <div class="input-field  s12 col l2">
              <img src="../../../assets/images/usuario.png" alt="" width="175em" />
            </div>
            <div class="input-field s12 col l10">
                <div class="row">
                  <div class="input-field s12 col l6">
                    <form:input path="nome"/>
                    <form:label path="nome"></form:label>
                  </div>
                  <div class="input-field s12 col l3">
                    <input id="nome" type="text" class="validate datepicker" placeholder="Data de Nascimento"> 
                  </div>
                  <div class="input-field s12 col l3">
                        <select>
                          <option value="" disabled selected>Sexo</option>
                          <option value="1">MASCULINO</option>
                          <option value="2">FEMININO</option>
                        </select>
                        <label></label>
                  </div>
                </div>
                <div class="row">
                    <div class="input-field s12 col l3">
                      <input id="last_name" type="text" class="validate">
                      <label for="last_name">CPF</label>
                    </div>
                    <div class="input-field s12 col l3">
                      <input id="last_name" type="text" class="validate">
                      <label for="last_name">RG</label>
                    </div>
                    <div class="input-field s12 col l3">
                      <input id="last_name" type="text" class="validate">
                      <label for="last_name">Órgão Emissor</label>
                    </div>
                    <div class="input-field s12 col l3">
                      <input id="last_name" type="text" class="validate datepicker" placeholder="Data de Expedição">
                    </div>
                </div>
            </div>
          </div>

          <div class="row">
            <div class="input-field col s12">
              <div class="row">
                <div class="input-field s12 col l3">
                    <select>
                      <option value="" disabled selected>Relação Funcional</option>
                      <option value="1">CELETISTA</option>
                      <option value="2">PRESTADOR_DE_SERVICOS</option>
                      <option value="2">ESTAGIARIO</option>
                      <option value="2">APRENDIZ</option>
                      <option value="2">VOLUNTARIO</option>
                      <option value="2">AUTONOMO</option>
                      <option value="2">MEI</option>
                    </select>
                    <label></label>
                </div>
                <div class="input-field s12 col l4">
                  <input id="last_name" type="text" class="validate">
                  <label for="last_name">Endereço</label>
                </div>
                <div class="input-field s12 col l1">
                  <input id="last_name" type="text" class="validate">
                  <label for="last_name">Número</label>
                </div>
                <div class="input-field s12 col l2">
                  <input id="last_name" type="text" class="validate">
                  <label for="last_name">Telefone</label>
                </div>
                <div class="input-field s12 col l2">
                  <input id="last_name" type="text" class="validate">
                  <label for="last_name">Celular</label>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
              <div class="input-field col s12">
                <div class="row">                  
                  <div class="input-field s12 col l2">
                    <input id="last_name" type="text" class="validate">
                    <label for="last_name">Complemento</label>
                  </div>
                  <div class="input-field s12 col l2">
                    <input id="last_name" type="text" class="validate">
                    <label for="last_name">Bairro</label>
                  </div>
                  <div class="input-field s12 col l2">
                      <select>
                        <option value="" disabled selected>Região</option>
                        <option value="1">NORTE</option>
                        <option value="2">SUL</option>
                        <option value="2">LESTE</option>
                        <option value="2">OESTE</option>
                        <option value="2">CENTRO</option>
                        <option value="2">NORDESTE</option>
                        <option value="2">NOROESTE</option>
                        <option value="2">SUDESTE</option>
                        <option value="2">SUDOESTE</option>
                      </select>
                      <label></label>
                  </div>
                  <div class="input-field s12 col l2">
                    <input id="last_name" type="text" class="validate">
                    <label for="last_name">CEP</label>
                  </div>
                  <div class="input-field s12 col l2">
                    <input id="last_name" type="text" class="validate">
                    <label for="last_name">Estado</label>
                  </div>
                  <div class="input-field s12 col l2">
                    <input id="last_name" type="text" class="validate">
                    <label for="last_name">Cidade</label>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
                <div class="input-field col s12">
                  <div class="row">                  
                      <div class="input-field s12 col l2">
                          <select>
                            <option value="" disabled selected>Estado Civil</option>
                            <option value="1">SOLTEIRO</option>
                            <option value="2">CASADO</option>
                          </select>
                          <label></label>
                      </div>
                    <div class="input-field s12 col l2">
                      <input id="last_name" type="text" class="validate">
                      <label for="last_name">Cargo</label>
                    </div>
                    <div class="input-field s12 col l2">
                      <input id="last_name" type="text" class="validate">
                      <label for="last_name">Habilitação</label>
                    </div>
                    <div class="input-field s12 col l2">
                      <input id="last_name" type="text" class="validate">
                      <label for="last_name">Disciplina</label>
                    </div>
                    <div class="input-field s12 col l2">
                      <input id="last_name" type="text" class="validate">
                      <label for="last_name">Formação</label>
                    </div>
                    <div class="input-field s12 col l2">
                        <select>
                          <option value="" disabled selected>Status</option>
                          <option value="1">ATIVO</option>
                          <option value="2">INATIVO</option>
                        </select>
                        <label></label>
                    </div>
                  </div>
                </div>
              </div>
          
              <div class="row">
                  <div class="input-field col s12">
                    <div class="row">                  
                      <div class="input-field s12 col l3">
                        <input id="last_name" type="text" class="validate datepicker" placeholder="Data de Admissão">
                      </div>
                      <div class="input-field s12 col l3">
                        <input id="last_name" type="text" class="validate">
                        <label for="last_name">Número</label>
                      </div>
                      <div class="input-field s12 col l3">
                        <input id="last_name" type="text" class="validate">
                        <label for="last_name">Série</label>
                      </div>
                      <div class="input-field s12 col l3">
                        <input id="last_name" type="text" class="validate">
                        <label for="last_name">CNPJ | MEI</label>
                      </div>
                      
                    </div>
                  </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                      <div class="row">     
                        <div class="input-field s12 col l3 border-form">Admissão
                          <input id="last_name" type="text" class="validate datepicker" placeholder="Data de Desligamento">
                          <div><br><br><br></div>
                        </div>
                        <div class="input-field s12 col l5 border-form">CTPS
                          <input id="last_name" type="text" class="validate" placeholder="UF">
                          <input id="last_name" type="text" class="validate datepicker" placeholder="Data de Expedição">
                        </div>
                        <div class="input-field s12 col l4 border-form">Dados de Acesso
                          <form:input id="email" path="email" class="validate" placeholder="E-mail" value="${usuario.email}" />
                          <form:input id="username" path="username" class="validate" placeholder="Username" value="${usuario.email}" />
                          <div><br><br><br></div>
                        </div>
                      </div>
                    </div>
                  </div>

                  <button class="btn waves-effect waves-light right" type="submit">
                    Salvar<i class="material-icons right">send</i>
                  </button>

        </form:form>
      </div>


<div class="row" style="background-color: white !important">
    <div class="col s12">
      <hr>
      <h5>Lista de Permissões</h5>


      <div class="row">   
          
    <div class="col s12">
        <h6>Configurações</h6> 
      <p>Usuários
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr>
        <p>Grupos de Permissões
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr>
      <p>Unidades
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr> 
      <p>Canais
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr> 
      <p>Gerenciador de Arquivos
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr> 
      <p>Agendamentos
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr> 
    </div>
</div>


<div class="row"> 
            
    <div class="col s12">
        <h6>Cursos</h6> 
      <p>Cursos
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr>
        <p>Mtrículas
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr>
      <p>Turmas
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr> 
     
    </div>
</div>


<div class="row">  
        
<div class="col s12">
    <h6>Aprendizes</h6>
  <p>Jovens
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
  </p> <hr>
  <p>Cursos IPP
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
  </p> <hr>
  <p>Escolaridade
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
  </p> <hr> 
  <p>Situação Laboral
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
  </p> <hr> 
  <p>Características Domiciliares
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
  </p> <hr> 
  <p>Habilidades
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
  </p> <hr> 
  <p>Situação de Saúde
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    </p> <hr>
    <p>Ficha Social
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    </p> <hr>
    <p>Ficha Profissional
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    </p> <hr> 
    <p>Históricos
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    </p> <hr> 
    <p>Dados Financeiros
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    </p> <hr> 
</div>
</div>

<div class="row">        
   
  <div class="col s12">
      <h6>Frequências</h6> 
    <p>PIT e PIP
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    </p> <hr>
      <p>PAP
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    </p> <hr>
    <p>PIO
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    </p> <hr> 
    <p>Aulas Extras
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
    </p> <hr> 

  </div>
</div>


<div class="row">            
  
    <div class="col s12">
        <h6>Empresas</h6>
      <p>Empresas
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr>
        <p>Gestores
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr>
      <p>Setores
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr> 
      <p>Históricos
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
        <input type="checkbox" class="filled-in" id="filled-in-box" checked="checked" /><label style="margin-left: 2em; float: right" for="filled-in-box"></label>
      </p> <hr> 
      
    </div>
</div>     
             
</div>
</div>

</div>

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
    today: 'Hoje',
    clear: 'Limpar',
    close: 'Pronto',
    labelMonthNext: 'Próximo mês',
    labelMonthPrev: 'Mês anterior',
    labelMonthSelect: 'Selecione um mês',
    labelYearSelect: 'Selecione um ano',
    selectMonths: true, 
    selectYears: 15 
});
  
$('.timepicker').pickatime({
"default": 'now',
twelvehour: false, // change to 12 hour AM/PM clock from 24 hour
donetext: 'OK',
autoclose: false,
vibrate: true // vibrate the device when dragging clock hand
});
</script>
<c:import url="../../../partials/final.jsp"></c:import>