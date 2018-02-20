<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    
<nav class="white" role="navigation">
    <div class="nav-wrapper container">
    <c:url value="/images/ipp-logo.png" var="ippLogoPng" />
    <c:url value="/" var="index" />
    <a id="logo-container" href="${index}" class="brand-logo"><img width="133em" style="margin-top: .2em;" id="logo" src="${ippLogoPng}"></a>
      <ul class="right hide-on-med-and-down">
      
      <!-- 
      	CONFIGURAÇÕES
       -->
      <c:if test="${
			usuarioSessao.grupoDePermissoes.usuarioCadastrar == true ||
			usuarioSessao.grupoDePermissoes.usuarioVisualizar == true ||
			usuarioSessao.grupoDePermissoes.usuarioEditar == true ||
			usuarioSessao.grupoDePermissoes.usuarioListar == true ||
			
			usuarioSessao.grupoDePermissoes.grupoDePermissoesCadastrar == true ||
			usuarioSessao.grupoDePermissoes.grupoDePermissoesVisualizar == true ||
			usuarioSessao.grupoDePermissoes.grupoDePermissoesEditar == true ||
			usuarioSessao.grupoDePermissoes.grupoDePermissoesListar == true ||
			
			usuarioSessao.grupoDePermissoes.unidadeCadastrar == true ||
			usuarioSessao.grupoDePermissoes.unidadeVisualizar == true ||
			usuarioSessao.grupoDePermissoes.unidadeEditar == true ||
			usuarioSessao.grupoDePermissoes.unidadeListar == true ||
			
			usuarioSessao.grupoDePermissoes.canalCadastrar == true ||
			usuarioSessao.grupoDePermissoes.canalVisualizar == true ||
			usuarioSessao.grupoDePermissoes.canalEditar == true ||
			usuarioSessao.grupoDePermissoes.canalListar == true ||
			
			usuarioSessao.grupoDePermissoes.arquivoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.arquivoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.arquivoEditar == true ||
			usuarioSessao.grupoDePermissoes.arquivoListar == true ||
			
			usuarioSessao.grupoDePermissoes.agendamentoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.agendamentoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.agendamentoEditar == true ||
			usuarioSessao.grupoDePermissoes.agendamentoListar == true			
				}">
      		<c:url value="/sw/configuracoes" var="swConfiguracoes" />
        	<li><a href="${swConfiguracoes}" style="color: #222 !important;">Configurações</a></li>
        </c:if>
    
      <!-- 
      	CURSOS
       -->
      <c:if test="${
			usuarioSessao.grupoDePermissoes.cursoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.cursoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.cursoEditar == true ||
			usuarioSessao.grupoDePermissoes.cursoListar == true ||
			
			usuarioSessao.grupoDePermissoes.turmaCadastrar == true ||
			usuarioSessao.grupoDePermissoes.turmaVisualizar == true ||
			usuarioSessao.grupoDePermissoes.turmaEditar == true ||
			usuarioSessao.grupoDePermissoes.turmaListar == true ||
			
			usuarioSessao.grupoDePermissoes.matriculaCadastrar == true ||
			usuarioSessao.grupoDePermissoes.matriculaVisualizar == true ||
			usuarioSessao.grupoDePermissoes.matriculaEditar == true ||
			usuarioSessao.grupoDePermissoes.matriculaListar == true ||
			
			usuarioSessao.grupoDePermissoes.cboCadastrar == true ||
			usuarioSessao.grupoDePermissoes.cboVisualizar == true ||
			usuarioSessao.grupoDePermissoes.cboEditar == true ||
			usuarioSessao.grupoDePermissoes.cboListar == true ||
			
			usuarioSessao.grupoDePermissoes.arcoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.arcoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.arcoEditar == true ||
			usuarioSessao.grupoDePermissoes.arcoListar == true ||
			
			usuarioSessao.grupoDePermissoes.basicoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.basicoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.basicoEditar == true ||
			usuarioSessao.grupoDePermissoes.basicoListar == true ||
			
			usuarioSessao.grupoDePermissoes.especificoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.especificoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.especificoEditar == true ||
			usuarioSessao.grupoDePermissoes.especificoListar == true
			}">
        <c:url value="/sw/homeCursos" var="swCursos" />
        <li><a href="${swCursos}" style="color: #222 !important;">Cursos</a></li>
        </c:if>
    
    <!-- 
      	JOVENS
       -->
      <c:if test="${
			usuarioSessao.grupoDePermissoes.jovemCadastrar == true ||
			usuarioSessao.grupoDePermissoes.jovemVisualizar == true ||
			usuarioSessao.grupoDePermissoes.jovemEditar == true ||
			usuarioSessao.grupoDePermissoes.jovemListar == true
				}">
        <c:url value="/sw/jovens" var="swJovens" />
        <li><a href="${swJovens}" style="color: #222 !important;">Aprendizes</a></li>
		</c:if>    
        <c:url value="/sw/frequencias" var="swFrequencias" />
        <li><a href="${swFrequencias}" style="color: #222 !important;">Frequências</a></li>
        <c:url value="/sw/empresas" var="swEmpresas" />
        <li><a href="${swEmpresas}" style="color: #222 !important;">Empresas</a></li>
        
		<c:if test="${
			usuarioSessao.grupoDePermissoes.parametrosCadastrar == true ||
			usuarioSessao.grupoDePermissoes.parametrosVisualizar == true ||
			usuarioSessao.grupoDePermissoes.parametrosEditar == true ||
			usuarioSessao.grupoDePermissoes.parametrosListar == true ||
			
			usuarioSessao.grupoDePermissoes.demonstrativoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.demonstrativoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.demonstrativoEditar == true ||
			usuarioSessao.grupoDePermissoes.demonstrativoListar == true ||
			
			usuarioSessao.grupoDePermissoes.vtCadastrar == true ||
			usuarioSessao.grupoDePermissoes.vtVisualizar == true ||
			usuarioSessao.grupoDePermissoes.vtEditar == true ||
			usuarioSessao.grupoDePermissoes.vtListar == true ||
			
			usuarioSessao.grupoDePermissoes.vrCadastrar == true ||
			usuarioSessao.grupoDePermissoes.vrVisualizar == true ||
			usuarioSessao.grupoDePermissoes.vrEditar == true ||
			usuarioSessao.grupoDePermissoes.vrListar == true ||
			
			usuarioSessao.grupoDePermissoes.contaAPagarCadastrar == true ||
			usuarioSessao.grupoDePermissoes.contaAPagarVisualizar == true ||
			usuarioSessao.grupoDePermissoes.contaAPagarEditar == true ||
			usuarioSessao.grupoDePermissoes.contaAPagarListar == true ||
			
			usuarioSessao.grupoDePermissoes.contaAReceberCadastrar == true ||
			usuarioSessao.grupoDePermissoes.contaAReceberVisualizar == true ||
			usuarioSessao.grupoDePermissoes.contaAReceberEditar == true ||
			usuarioSessao.grupoDePermissoes.contaAReceberListar == true ||
			
			usuarioSessao.grupoDePermissoes.bancoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.bancoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.bancoEditar == true ||
			usuarioSessao.grupoDePermissoes.bancoListar == true	
			}">	
    		<c:url value="/sw/financeiros" var="swFinanceiros" />
    		<li><a href="${swFinanceiros}" style="color: #222 !important;">Financeiro</a></li>
		</c:if>
        
        <c:url value="/logout" var="logout" />
        <li><a href="${logout}"><i class="material-icons" style="color: #222 !important;">exit_to_app</i></a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
      <!-- 
      	CONFIGURAÇÕES
       -->
      <c:if test="${
			usuarioSessao.grupoDePermissoes.usuarioCadastrar == true ||
			usuarioSessao.grupoDePermissoes.usuarioVisualizar == true ||
			usuarioSessao.grupoDePermissoes.usuarioEditar == true ||
			usuarioSessao.grupoDePermissoes.usuarioListar == true ||
			
			usuarioSessao.grupoDePermissoes.grupoDePermissoesCadastrar == true ||
			usuarioSessao.grupoDePermissoes.grupoDePermissoesVisualizar == true ||
			usuarioSessao.grupoDePermissoes.grupoDePermissoesEditar == true ||
			usuarioSessao.grupoDePermissoes.grupoDePermissoesListar == true ||
			
			usuarioSessao.grupoDePermissoes.unidadeCadastrar == true ||
			usuarioSessao.grupoDePermissoes.unidadeVisualizar == true ||
			usuarioSessao.grupoDePermissoes.unidadeEditar == true ||
			usuarioSessao.grupoDePermissoes.unidadeListar == true ||
			
			usuarioSessao.grupoDePermissoes.canalCadastrar == true ||
			usuarioSessao.grupoDePermissoes.canalVisualizar == true ||
			usuarioSessao.grupoDePermissoes.canalEditar == true ||
			usuarioSessao.grupoDePermissoes.canalListar == true ||
			
			usuarioSessao.grupoDePermissoes.arquivoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.arquivoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.arquivoEditar == true ||
			usuarioSessao.grupoDePermissoes.arquivoListar == true ||
			
			usuarioSessao.grupoDePermissoes.agendamentoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.agendamentoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.agendamentoEditar == true ||
			usuarioSessao.grupoDePermissoes.agendamentoListar == true			
				}">
        <c:url value="/sw/configuracoes" var="swConfiguracoes" />
        <li><a href="${swConfiguracoes}" style="color: #222 !important;">Configurações</a></li>
    	</c:if>
    
      <!-- 
      	CURSOS
       -->
      <c:if test="${
			usuarioSessao.grupoDePermissoes.cursoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.cursoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.cursoEditar == true ||
			usuarioSessao.grupoDePermissoes.cursoListar == true ||
			
			usuarioSessao.grupoDePermissoes.turmaCadastrar == true ||
			usuarioSessao.grupoDePermissoes.turmaVisualizar == true ||
			usuarioSessao.grupoDePermissoes.turmaEditar == true ||
			usuarioSessao.grupoDePermissoes.turmaListar == true ||
			
			usuarioSessao.grupoDePermissoes.matriculaCadastrar == true ||
			usuarioSessao.grupoDePermissoes.matriculaVisualizar == true ||
			usuarioSessao.grupoDePermissoes.matriculaEditar == true ||
			usuarioSessao.grupoDePermissoes.matriculaListar == true ||
			
			usuarioSessao.grupoDePermissoes.cboCadastrar == true ||
			usuarioSessao.grupoDePermissoes.cboVisualizar == true ||
			usuarioSessao.grupoDePermissoes.cboEditar == true ||
			usuarioSessao.grupoDePermissoes.cboListar == true ||
			
			usuarioSessao.grupoDePermissoes.arcoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.arcoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.arcoEditar == true ||
			usuarioSessao.grupoDePermissoes.arcoListar == true ||
			
			usuarioSessao.grupoDePermissoes.basicoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.basicoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.basicoEditar == true ||
			usuarioSessao.grupoDePermissoes.basicoListar == true ||
			
			usuarioSessao.grupoDePermissoes.especificoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.especificoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.especificoEditar == true ||
			usuarioSessao.grupoDePermissoes.especificoListar == true
			}">

        <c:url value="/sw/homeCursos" var="swCursos" />
        <li><a href="${swCursos}" style="color: #222 !important;">Cursos</a></li>
    	</c:if>

        <c:url value="/sw/jovens" var="swJovens" />
        <li><a href="${swJovens}" style="color: #222 !important;">Aprendizes</a></li>
        <c:url value="/sw/frequencias" var="swFrequencias" />
        <li><a href="${swFrequencias}" style="color: #222 !important;">Frequências</a></li>
        <c:url value="/sw/empresas" var="swEmpresas" />
        <li><a href="${swEmpresas}" style="color: #222 !important;">Empresas</a></li>
        
        <c:if test="${
			usuarioSessao.grupoDePermissoes.parametrosCadastrar == true ||
			usuarioSessao.grupoDePermissoes.parametrosVisualizar == true ||
			usuarioSessao.grupoDePermissoes.parametrosEditar == true ||
			usuarioSessao.grupoDePermissoes.parametrosListar == true ||
			
			usuarioSessao.grupoDePermissoes.demonstrativoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.demonstrativoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.demonstrativoEditar == true ||
			usuarioSessao.grupoDePermissoes.demonstrativoListar == true ||
			
			usuarioSessao.grupoDePermissoes.vtCadastrar == true ||
			usuarioSessao.grupoDePermissoes.vtVisualizar == true ||
			usuarioSessao.grupoDePermissoes.vtEditar == true ||
			usuarioSessao.grupoDePermissoes.vtListar == true ||
			
			usuarioSessao.grupoDePermissoes.vrCadastrar == true ||
			usuarioSessao.grupoDePermissoes.vrVisualizar == true ||
			usuarioSessao.grupoDePermissoes.vrEditar == true ||
			usuarioSessao.grupoDePermissoes.vrListar == true ||
			
			usuarioSessao.grupoDePermissoes.contaAPagarCadastrar == true ||
			usuarioSessao.grupoDePermissoes.contaAPagarVisualizar == true ||
			usuarioSessao.grupoDePermissoes.contaAPagarEditar == true ||
			usuarioSessao.grupoDePermissoes.contaAPagarListar == true ||
			
			usuarioSessao.grupoDePermissoes.contaAReceberCadastrar == true ||
			usuarioSessao.grupoDePermissoes.contaAReceberVisualizar == true ||
			usuarioSessao.grupoDePermissoes.contaAReceberEditar == true ||
			usuarioSessao.grupoDePermissoes.contaAReceberListar == true ||
			
			usuarioSessao.grupoDePermissoes.bancoCadastrar == true ||
			usuarioSessao.grupoDePermissoes.bancoVisualizar == true ||
			usuarioSessao.grupoDePermissoes.bancoEditar == true ||
			usuarioSessao.grupoDePermissoes.bancoListar == true	
			}">	
        <c:url value="/sw/financeiros" var="swFinanceiros" />
        <li><a href="${swFinanceiros}" style="color: #222 !important;">Financeiro</a></li>
        </c:if>
        
        <c:url value="/logout" var="logout" />
        <li><a href="${logout}"><i class="material-icons" style="color: #222 !important;">exit_to_app</i></a></li>
      </ul>
      <c:url value="/logout" var="logout" />
      <a href="${logout}" data-activates="nav-mobile" class="button-collapse"><i class="material-icons" style="color: #222 !important;">menu</i></a>
    </div>
  </nav>

  <br />
  <br />

<c:if test="${msg != null}">
	<div class="container">
		<nav>
			<div class="nav-wrapper">
				<div class="col s12"
					style="text-align: center; background-color: ${color}">
					${msg}</div>
			</div>
		</nav>
	</div>
</c:if>
