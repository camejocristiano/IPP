<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<div class="row">
		<div class="input-field s12 col l12" style="border-bottom: 2px solid orange;">
			 <h4 class="header right orange-text">Jovem: ${jovem.nome}</h4>
		</div>
	</div>

<form:form role="form" commandName="jovem" servletRelativeAction="/jovens/${jovem.id}" method="POST">
	<div class="row">
		<div class="s12 col l2">
			<img src="../../../assets/images/usuario.png" alt="" width="175em" />
		</div>
		
		<div class="s12 col l10">
			<div class="row">
				<div class="input-field s12 col l4">
					<form:input path='nome' type='text' required="required" />
					<form:errors path='nome'/> 
					<label for="nome">Nome</label>
				</div>
				<div class="input-field s12 col l2">
                    <form:select path="status">
	                	<form:option value="${jovem.status}" label="${jovem.status == null ? 'Status' : jovem.status}" />
						<c:forEach var="status" items="${requestScope.status}">
							<option>${status}</option>							
						</c:forEach>
					</form:select>
                </div>
				<div class="input-field s12 col l3">
                    <form:input id="dataDeNascimento" path="dataDeNascimento" type="date" class="validate datepicker" placeholder="Data de Nascimento" /> 
                </div>
				<div class="input-field s12 col l1">
					<form:input path='idade' type='text' />
					<form:errors path='idade'/> 
					<label for="idade">Idade</label>
				</div>
				<div class="input-field s12 col l2">
                    <form:select path="sexo">
                    	<form:option value="${jovem.sexo}" label="${jovem.sexo == null ? 'Sexo' : jovem.sexo}" />
						<c:forEach var="sexo" items="${requestScope.sexo}">
							<form:option value="${sexo}">${sexo}</form:option>							
						</c:forEach>
					</form:select>	
                </div>
			</div>
		</div>
		<div class="s12 col l10">
			<div class="row">
				<div class="input-field s12 col l3">
                    <form:select path="unidade">
                		<form:option  value="${unidade.id}" label="${jovem.unidade == null ? 'Unidade' : jovem.unidade.nomeFantazia}" />
						<c:forEach var="unidade" items="${requestScope.unidades}">
							<option value="${unidade.id}">${unidade.nomeFantazia}</option>							
						</c:forEach>
					</form:select>
                </div>
				<div class="input-field s12 col l3">
					<form:input path='cPF' type='text' />
					<form:errors path='cPF'/> 
					<label for="cPF">CPF</label>
				</div>
				<div class="input-field s12 col l3">
					<form:input path='rG' type='text' />
					<form:errors path='rG'/> 
					<label for="rG">RG</label>
				</div>
				<div class="input-field s12 col l1">
					<form:input path='orgaoEmissor' type='text' />
					<form:errors path='orgaoEmissor'/> 
					<label for="orgaoEmissor">Órg.Em.</label>
				</div>
				<div class="input-field s12 col l2">
                    <form:input id="dataExpedicao" path="dataExpedicao" type="date" class="validate datepicker" placeholder="Data de Expedição" /> 
                </div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="s12 col l12">
			<div class="row">
				<div class="input-field s12 col l2">
					<form:input path='telefone' type='text'  />
					<form:errors path='telefone'/> 
					<label for="telefone">Telefone</label>
				</div>
				<div class="input-field s12 col l2">
					<form:input path='celular' type='text'  />
					<form:errors path='celular'/> 
					<label for="celular">Celular</label>
				</div>
				<div class="input-field s12 col l5">
					<form:input path='endereco' type='text'  />
					<form:errors path='endereco'/> 
					<label for="endereco">Endereço</label>
				</div>
				<div class="input-field s12 col l1">
					<form:input path='numeroResidencia' type='text'  />
					<form:errors path='numeroResidencia'/> 
					<label for="numeroResidencia">Número</label>
				</div>
				<div class="input-field s12 col l2">
                    <form:select path="area" >
                    	<form:option value="${jovem.area}" label="${jovem.area == null ? 'Area' : jovem.area}" />
						<c:forEach var="area" items="${requestScope.area}">
							<form:option value="${area}">${area}</form:option>							
						</c:forEach>
					</form:select>	
                </div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="s12 col l12">
			<div class="row">
				<div class="input-field s12 col l2">
					<form:input path='complemento' type='text' />
					<form:errors path='complemento'/> 
					<label for="complemento">Complemento</label>
				</div>
				<div class="input-field s12 col l2">
					<form:input path='bairro' type='text'  />
					<form:errors path='bairro'/> 
					<label for="bairro">Bairro</label>
				</div>
				<div class="input-field s12 col l2">
                    <form:select path="regiao" >
                    	<form:option value="${jovem.regiao}" label="${jovem.regiao == null ? 'Região' : jovem.regiao}" />
						<c:forEach var="regiao" items="${requestScope.regiao}">
							<form:option value="${regiao}">${regiao}</form:option>							
						</c:forEach>
					</form:select>	
                </div>
                <div class="input-field s12 col l2">
					<form:input path='cEP' type='text' />
					<form:errors path='cEP'/> 
					<label for="cEP">CEP</label>
				</div>
				<div class="input-field s12 col l2">
					<form:input path='estado' type='text' />
					<form:errors path='estado'/> 
					<label for="estado">Estado</label>
				</div>
				<div class="input-field s12 col l2">
					<form:input path='cidade' type='text' />
					<form:errors path='cidade'/> 
					<label for="cidade">Cidade</label>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="s12 col l12">
			<div class="row">
				<div class="input-field s12 col l3">
					<form:input path='email' type='text' required="required" />
					<form:errors path='email'/> 
					<label for="email">Email do Jovem</label>
				</div>
				<div class="input-field s12 col l5">
					<form:input path='nomeDaMae' type='text' />
					<form:errors path='nomeDaMae'/> 
					<label for="nomeDaMae">Nome da Mãe</label>
				</div>
				<div class="input-field s12 col l2">
                    <form:select path="estadoCivil" >
                    	<form:option value="${jovem.estadoCivil}" label="${jovem.estadoCivil == null ? 'Estado Civil' : jovem.estadoCivil}" />
						<c:forEach var="estadoCivil" items="${requestScope.estadoCivil}">
							<form:option value="${estadoCivil}">${estadoCivil}</form:option>							
						</c:forEach>
					</form:select>	
                </div>
				<div class="input-field s12 col l2">
					<form:input path='codigoDoJovem' type='text' />
					<form:errors path='codigoDoJovem'/> 
					<label for="codigoDoJovem">Código do Jovem</label>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="s12 col l12">
			<div class="row">
				<div class="input-field s12 col l4">
					<form:input path='nomeDoPai' type='text' />
					<form:errors path='nomeDoPai'/> 
					<label for="nomeDoPai">Nome do Pai</label>
				</div>
				<div class="input-field s12 col l1">
					<form:input path='rGPai' type='text' />
					<form:errors path='rGPai'/> 
					<label for="rGPai">RG do Pai</label>
				</div>
				<div class="input-field s12 col l1">
					<form:input path='cPFPai' type='text' />
					<form:errors path='cPFPai'/> 
					<label for="cPFPai">CPF(Pai)</label>
				</div>
				<div class="input-field s12 col l4">
					<form:input path='responsavelLegal' type='text' />
					<form:errors path='responsavelLegal'/> 
					<label for="responsavelLegal">Responsavel Legal</label>
				</div>
				<div class="input-field s12 col l1">
					<form:input path='rGResp' type='text' />
					<form:errors path='rGResp'/> 
					<label for="rGResp">RG(Resp.)</label>
				</div>
				<div class="input-field s12 col l1">
					<form:input path='cPFResp' type='text' />
					<form:errors path='cPFResp'/> 
					<label for="cPFResp">CPF(Resp.)</label>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="s12 col l12">
			<div class="row">
				<div class="s12 col l3">
					<div class="row">
						<div class="input-field s12 col l6">
							<form:select path="tipoDeInsercao">
								<form:option value="${jovem.tipoDeInsercao}"
									label="${jovem.tipoDeInsercao == null ? 'Tipo Inserção' : jovem.tipoDeInsercao}" />
								<c:forEach var="tipoDeInsercao"
									items="${requestScope.tipoDeInsercao}">
									<form:option value="${tipoDeInsercao}">${tipoDeInsercao}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="input-field s12 col l6">
							<form:select path="canal">
								<form:option value="${canal.id}"
									label="${jovem.canal == null ? 'Canal' : jovem.canal.nomeCanal}" />
								<c:forEach var="canal" items="${requestScope.canais}">
									<option value="${canal.id}">${canal.nomeCanal}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
				<div class="s12 col l9">
					<div class="row">
						<div class="input-field s12 col l1"
							style="border: 1px solid black;">
							<form:input path='numeroPIT' type='text' />
							<form:errors path='numeroPIT' />
							<label for="numeroPIT" style="font-size: 11px;">Nº PIT</label>
						</div>
						<div class="input-field s12 col l1"
							style="border: 1px solid black;">
							<form:input path='numeroPIP' type='text' />
							<form:errors path='numeroPIP' />
							<label for="numeroPIP" style="font-size: 11px;">Nº PIP</label>
						</div>
						<div class="input-field s12 col l1"
							style="border: 1px solid black;">
							<form:input path='numeroPIO' type='text' />
							<form:errors path='numeroPIO' />
							<label for="numeroPIO" style="font-size: 11px;">Nº PIO</label>
						</div>
						<div class="input-field s12 col l1"
							style="border: 1px solid black;">
							<form:input path='numeroPAP' type='text' />
							<form:errors path='numeroPAP' />
							<label for="numeroPAP" style="font-size: 11px;">Nº PAP</label>
						</div>
						<div class="input-field s12 col l2"
							style="border: 1px solid black;">
							<form:select path="pAPDiaDaSemana">
				               	<form:option value="${jovem.pAPDiaDaSemana}" label="${jovem.pAPDiaDaSemana == null ? 'AE Dia Sem' : jovem.pAPDiaDaSemana}" />
								<c:forEach var="pAPDiaDaSemana" items="${requestScope.diasDaSemana}">
									<form:option value="${pAPDiaDaSemana}">${pAPDiaDaSemana}</form:option>							
								</c:forEach>
							</form:select>	
						</div>
						<div class="input-field s12 col l1"
							style="border: 1px solid black;">
							<form:input path='hrEmPAP' type='text' />
							<form:errors path='hrEmPAP' />
							<label for="hrEmPAP" style="font-size: 11px;"> HrEmPAP</label>
						</div>
						<div class="input-field s12 col l1"
							style="border: 1px solid black;">
							<form:input path='hrSdPAP' type='text' />
							<form:errors path='hrSdPAP' />
							<label for="hrSdPAP" style="font-size: 11px;">HrSdPAP</label>
						</div>
						<div class="input-field s12 col l2"
							style="border: 1px solid black;">
							<form:select path="aEDiaSem">
				               	<form:option value="${jovem.aEDiaSem}" label="${jovem.aEDiaSem == null ? 'AE Dia Sem' : jovem.aEDiaSem}" />
								<c:forEach var="aEDiaDaSemana" items="${requestScope.aEDiasDaSemana}">
									<form:option value="${aEDiaDaSemana}">${aEDiaDaSemana}</form:option>							
								</c:forEach>
							</form:select>	
						</div>
						<div class="input-field s12 col l2"
							style="border: 1px solid black;">
							<form:input path='aETurma' type='text' />
							<form:errors path='aETurma' />
							<label for="aETurma" style="font-size: 11px;">AE Turma</label>
						</div>

					</div>
				</div>
				 
				<div class="row">
					<div class="s12 col l4" style="border:1px solid gray;">
						<h6 class="header center" style="border-bottom: 2px solid gray; display: block;" >Naturalidade</h6>
						<div class="row">
							<div class="input-field s12 col l4">
								<form:input path='naturalidadeEstado' type='text' />
								<form:errors path='naturalidadeEstado' />
								<label for="naturalidadeEstado" style="font-size: 11px;">Estado</label>
							</div>
							<div class="input-field s12 col l8">
								<form:input path='naturalidadeCidade' type='text' />
								<form:errors path='naturalidadeCidade' />
								<label for="naturalidadeCidade" style="font-size: 11px;">Cidade</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field s12 col l12">
								<form:input path='naturalidadePais' type='text' />
								<form:errors path='naturalidadePais' />
								<label for="naturalidadePais" style="font-size: 11px;">País</label>
							</div>
						</div>
						
					</div>
					<div class="s12 col l4" style="border:1px solid gray;">
						<h6 class="header center" style="border-bottom: 2px solid gray; display: block;" >CTPS</h6>
						<div class="row">
							<div class="input-field s12 col l6">
							 	<form:input path='cTPSNumero' type='text' />
								<form:errors path='cTPSNumero' />
								<label for="cTPSNumero" style="font-size: 11px;">Nº</label>
							</div>
							<div class="input-field s12 col l6">
							 	<form:input path='cTPSSerie' type='text' />
								<form:errors path='cTPSSerie' />
								<label for="cTPSSerie" style="font-size: 11px;">Série</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field s12 col l6">
							 	<form:input path='cTPSUF' type='text' />
								<form:errors path='cTPSUF' />
								<label for="cTPSUF" style="font-size: 11px;">UF</label>
							</div>
							<div class="input-field s12 col l6">
								<form:input id="cTPSdataExpedicao" path="cTPSdataExpedicao" type="date" class="validate datepicker" placeholder="Data de Expedição" /> 
								<label for="cTPSdataExpedicao" style="font-size: 11px;">CTPS Data Expedição</label>
							</div>
						</div>
					</div>
					<div class="s12 col l4" style="border:1px solid gray;">
						<h6 class="header center" style="border-bottom: 2px solid gray; display: block;" >Medidas Sócio Educativas</h6>
						<br />
						<br />
						<br />
						<div class="row">
							<div class="s12 col l12">
								<input type="checkbox" name="medidasSocioEducativasEstaCumprindo" class="filled-in" id="medidasSocioEducativasEstaCumprindo" <c:if test="${jovem.medidasSocioEducativasEstaCumprindo == true}">checked</c:if> />
								<label for="medidasSocioEducativasEstaCumprindo">Medidas Sócio Educativas, está Cumprindo?</label>
							</div>
						</div>
						<div class="row">
							<div class="s12 col l12">
								<input type="checkbox" name="medidasSocioEducativasJaTeveProblemasComALei" class="filled-in" id="medidasSocioEducativasJaTeveProblemasComALei" <c:if test="${jovem.medidasSocioEducativasJaTeveProblemasComALei == true}">checked</c:if> />
								<label for="medidasSocioEducativasJaTeveProblemasComALei">Já teve problemas com a lei?</label>
							</div>
						</div>
						<div class="row">
							<div class="s12 col l12">
								<input type="checkbox" name="medidasSocioEducativasEUsuarioDeDrogas" class="filled-in" id="medidasSocioEducativasEUsuarioDeDrogas" <c:if test="${jovem.medidasSocioEducativasEUsuarioDeDrogas == true}">checked</c:if> />
								<label for="medidasSocioEducativasEUsuarioDeDrogas">É usuário de drogas?</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="s12 col l4" style="border:1px solid gray;">
						<h6 class="header center" style="border-bottom: 2px solid gray; display: block;" >Certidão de Nascimento</h6>
						<div class="row">
							<div class="s12 col l6">
								<input type="checkbox" name="certidaoDeNascimentoTem" class="filled-in" id="certidaoDeNascimentoTem" <c:if test="${jovem.certidaoDeNascimentoTem == true}">checked</c:if> />
								<label for="certidaoDeNascimentoTem">Certidão de Nascimento, Tem?</label>
							</div>
							<div class="input-field s12 col l6">
								<form:input path='certidaoDeNascimentoCartorio' type='text' />
								<form:errors path='certidaoDeNascimentoCartorio' />
								<label for="certidaoDeNascimentoCartorio" style="font-size: 11px;">Cartório</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field s12 col l6">
								<form:input path='certidaoDeNascimentoLivro' type='text' />
								<form:errors path='certidaoDeNascimentoLivro' />
								<label for="certidaoDeNascimentoLivro" style="font-size: 11px;">Livro</label>
							</div>
							<div class="input-field s12 col l6">
								<form:input path='certidaoDeNascimentoFolhaNumero' type='text' />
								<form:errors path='certidaoDeNascimentoFolhaNumero' />
								<label for="certidaoDeNascimentoFolhaNumero" style="font-size: 11px;">Folha Nº</label>
							</div>
						</div>
					</div>
					<div class="s12 col l4" style="border:1px solid gray;">
						<h6 class="header center" style="border-bottom: 2px solid gray; display: block;" >Título de Eleitor</h6>
							<div class="row">
							<div class="s12 col l6">
								<input type="checkbox" name="tituloDeEleitorTem" class="filled-in" id="tituloDeEleitorTem" <c:if test="${jovem.tituloDeEleitorTem == true}">checked</c:if> />
								<label for="tituloDeEleitorTem">Título de Eleitor, Tem?</label>
							</div>
							<div class="input-field s12 col l6">
								<form:input path='tituloDeEleitorNumero' type='text' />
								<form:errors path='tituloDeEleitorNumero' />
								<label for="tituloDeEleitorNumero" style="font-size: 11px;">Número</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field s12 col l6">
								<form:input path='tituloDeEleitorZona' type='text' />
								<form:errors path='tituloDeEleitorZona' />
								<label for="tituloDeEleitorZona" style="font-size: 11px;">Zona</label>
							</div>
							<div class="input-field s12 col l6">
								<form:input path='tituloDeEleitorSessao' type='text' />
								<form:errors path='tituloDeEleitorSessao' />
								<label for="tituloDeEleitorSessao" style="font-size: 11px;">Sessão</label>
							</div>
						</div>
					</div>
					<div class="s12 col l4" style="border:1px solid gray;">
						<h6 class="header center" style="border-bottom: 2px solid gray; display: block;" >CNH</h6>
						<div class="row">
							<div class="s12 col l6">
								<input type="checkbox" name="cNHTem" class="filled-in" id="cNHTem" <c:if test="${jovem.cNHTem == true}">checked</c:if> />
								<label for="cNHTem">Tem CNH?</label>
							</div>
							<div class="input-field s12 col l6">
								<form:input path='cNHNumero' type='text' />
								<form:errors path='cNHNumero' />
								<label for="cNHNumero" style="font-size: 11px;">Nº</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field s12 col l12">
								<form:select path="cNHTipo">
					               	<form:option value="${jovem.cNHTipo}" label="${jovem.cNHTipo == null ? 'CNH Tipo' : jovem.cNHTipo}" />
									<c:forEach var="cNHTipo" items="${requestScope.tiposDeCNH}">
										<form:option value="${cNHTipo}">${cNHTipo}</form:option>							
									</c:forEach>
								</form:select>	
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="s12 col l4" style="border:1px solid gray;">
					<h6 class="header center" style="border-bottom: 2px solid gray; display: block;" >Serviço Militar</h6>
						<div class="row">
							<div class="s12 col l6">
								<input type="checkbox" name="servicoMilitarSeAlistou" class="filled-in" id="servicoMilitarSeAlistou" <c:if test="${jovem.servicoMilitarSeAlistou == true}">checked</c:if> />
								<label for="servicoMilitarSeAlistou">Se alistou?</label>
							</div>
							<div class="input-field s12 col l6">
								<form:input path='servicoMilitarNumero' type='text' />
								<form:errors path='servicoMilitarNumero' />
								<label for="servicoMilitarNumero" style="font-size: 11px;">Número</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field s12 col l12">
								<form:select path="servicoMilitarSituacao">
					               	<form:option value="${jovem.servicoMilitarSituacao}" label="${jovem.servicoMilitarSituacao == null ? 'Situação' : jovem.servicoMilitarSituacao}" />
									<c:forEach var="servicoMilitarSituacao" items="${requestScope.servicoMilitarSituacoes}">
										<form:option value="${servicoMilitarSituacao}">${servicoMilitarSituacao}</form:option>							
									</c:forEach>
								</form:select>	
							</div>
						</div>
					</div>
					<div class="s12 col l4" style="border:1px solid gray;">
						<h6 class="header center" style="border-bottom: 2px solid gray; display: block;" >Deficiência Física</h6>
						<br />
						<div class="row">
							<div class="s12 col l12">
								<input type="checkbox" name="deficienciaFisicaTem" class="filled-in" id="deficienciaFisicaTem" <c:if test="${jovem.deficienciaFisicaTem == true}">checked</c:if> />
								<label for="deficienciaFisicaTem">Deficiência física, tem?</label>
							<br />
							<br />
							</div>
						</div>
						<div class="row">
							<div class="input-field s12 col l12">
								<form:textarea path="deficienciaFisicaDescricao" />
								<form:errors path="deficienciaFisicaDescricao"></form:errors>
								<form:label path="deficienciaFisicaDescricao">Deficiência física descrição</form:label>
							 <br />
							 <br />	
							</div>
						</div>
					</div>
					<div class="s12 col l4" style="border:1px solid gray;">
					<h6 class="header center" style="border-bottom: 2px solid gray; display: block;" >PIS</h6>
						<div class="row">
							<div class="input-field s12 col l12">
								<form:input path='pISNumero' type='text' />
								<form:errors path='pISNumero' />
								<label for="pISNumero" style="font-size: 11px;">Número</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field s12 col l12">
							 <br />
							 <br />
							 <br />
							</div>
						</div>
					</div>
				</div> 
				
			</div>
		</div>
	</div>
	<div class="row">
		<div class="input-field s12 col l12">
			<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='username' type='text' required="required" />
					<form:errors path='username'/> 
					<label for="username">Username</label>
				</div>
			</div>
		</div>
	</div>
	<button class="btn waves-effect waves-light right" type="submit">
		Salvar<i class="material-icons right">send</i>
	</button>
</form:form>