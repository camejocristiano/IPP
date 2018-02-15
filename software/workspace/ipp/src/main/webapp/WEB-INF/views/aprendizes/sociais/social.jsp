<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<c:url value="/sw/jovem/${jovem.id}" var="swJovemJovemId"></c:url>
			<a href="${swJovemJovemId}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Jovem"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>

		<form:form role="form" commandName="fichaSocial" servletRelativeAction="/sw/fichaSocial/${fichaSocial.id}" method="POST">
			<div class="row">
				<div class="input-field s12 col l12">
					<div class="row">
						<div class="input-field s12 col l12">
							<form:hidden path="jovem" value="${jovem.id}" />
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:select path="tipoDeMoradia">
								<form:option value="${tipoDeMoradia}" label="${fichaSocial.tipoDeMoradia == null ? 'Tipo de Moradia: ' : fichaSocial.tipoDeMoradia}" />
								<c:forEach var="tipoDeMoradia" items="${requestScope.tiposDeMoradia}">
									<option>${tipoDeMoradia}</option>							
								</c:forEach>
							</form:select>
							<label for="tipoDeMoradia">Tipo de Moradia: </label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:select path="situacaoDaMoradia">
								<form:option value="${situacaoDaMoradia}" label="${fichaSocial.situacaoDaMoradia == null ? 'situação da Moradia: ' : fichaSocial.situacaoDaMoradia}" />
								<c:forEach var="situacaoDaMoradia" items="${requestScope.situacoesDeMoradia}">
									<option>${situacaoDaMoradia}</option>							
								</c:forEach>
							</form:select>
							<label for="tipoDeMoradia">Situação de Moradia: </label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='seEntidadeSocialQualONome' type='text'/>
							<form:errors path='seEntidadeSocialQualONome'/> 
							<label for="seEntidadeSocialQualONome">Se entidade social, qual o nome?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:select path="tipoDeConstrucao">
								<form:option value="${tipoDeConstrucao}" label="${fichaSocial.tipoDeConstrucao == null ? 'situação da Construcao: ' : fichaSocial.tipoDeConstrucao}" />
								<c:forEach var="tipoDeConstrucao" items="${requestScope.tiposDeConstrucao}">
									<option>${tipoDeConstrucao}</option>							
								</c:forEach>
							</form:select>
							<label for="tipoDeMoradia">Tipo de Construcao: </label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='quantidadeDeComodos' type='text'/>
							<form:errors path='quantidadeDeComodos'/> 
							<label for="quantidadeDeComodos">Quantidade de cômodos?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='quantidadeDeBanheiros' type='text'/>
							<form:errors path='quantidadeDeBanheiros'/> 
							<label for="quantidadeDeBanheiros">Quantidade de Banheiros?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row Situação Habitacional -->
			<div class="row">
				<div class="input-field s12 col l12">
				Internações
				<hr />
				<hr />
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='primeiraInternacaoMotivo' type='text'/>
							<form:errors path='primeiraInternacaoMotivo'/> 
							<label for="primeiraInternacaoMotivo">Motivo da 1ª Internação</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='segundaInternacaoMotivo' type='text'/>
							<form:errors path='segundaInternacaoMotivo'/> 
							<label for="segundaInternacaoMotivo">Motivo da 2ª Internação</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='terceiraInternacaoMotivo' type='text'/>
							<form:errors path='terceiraInternacaoMotivo'/> 
							<label for="terceiraInternacaoMotivo">Motivo da 3ª Internação</label>
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l12">
				Situação Sócio Cultural
				<hr />
				<hr />
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='comoFoiAAdaptacaoAoMeioEscolar' type='text'/>
							<form:errors path='comoFoiAAdaptacaoAoMeioEscolar'/> 
							<label for="comoFoiAAdaptacaoAoMeioEscolar">Como foi a adaptação ao meio escolar?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<input type="checkbox" name="jaRepetiuDeAno" class="filled-in" id="jaRepetiuDeAno" <c:if test="${fichaSocial.jaRepetiuDeAno == true}">checked</c:if> />
							<label for="jaRepetiuDeAno">Já repetiu de ano?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='casoRepetiuQualAno' type='text'/>
							<form:errors path='casoRepetiuQualAno'/> 
							<label for="casoRepetiuQualAno">Caso repetiu, qual ano?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<input type="checkbox" name="temDificuldadesEmAlgumaMateria" class="filled-in" id="temDificuldadesEmAlgumaMateria" <c:if test="${fichaSocial.temDificuldadesEmAlgumaMateria == true}">checked</c:if> />
							<label for="temDificuldadesEmAlgumaMateria">Tem dificuldade em alguma matéria?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='seTemDificuldadesQual' type='text'/>
							<form:errors path='seTemDificuldadesQual'/> 
							<label for="seTemDificuldadesQual">Se tem dificuldades, qual?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='comoSeRelacionaComOsColegas' type='text'/>
							<form:errors path='comoSeRelacionaComOsColegas'/> 
							<label for="comoSeRelacionaComOsColegas">Como se relaciona com os colegas?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:input path='queTipoDeLaserMaisGosta' type='text'/>
							<form:errors path='queTipoDeLaserMaisGosta'/> 
							<label for="queTipoDeLaserMaisGosta">Que tipo de laser mais gosta?</label>
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l12">
				Situação Familiar
				<hr />
				<hr />
					<div class="row">
						<div class="input-field s12 col l12">
							<form:textarea path="observacoesFamiliares" />
							<form:errors path="observacoesFamiliares"></form:errors>
							<form:label path="observacoesFamiliares">Observações Familiares</form:label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
							<form:textarea path="dinamicaFamiliar" />
							<form:errors path="dinamicaFamiliar"></form:errors>
							<form:label path="dinamicaFamiliar">Dinâmica Familiar</form:label>
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l12">
				Situação Sócio Econômica Familiar
				<hr />
				<hr />
					<div class="row">
						<div class="input-field s12 col l2">
						Despesas
						</div><!-- // col -->
						<div class="input-field s12 col l10">
							<div class="row">
								<div class="input-field s12 col l9">	
									Aluguel, prestação de casa ou apartamento:
								</div><!-- // col -->
								<div class="input-field s12 col l3">	
									<form:input path='despesaAluguelPrestacaoCasaApartamento' type='text'/>
									<form:errors path='despesaAluguelPrestacaoCasaApartamento'/> 
									<label for="despesaAluguelPrestacaoCasaApartamento">R$</label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l9">	
									Condomínio:
								</div><!-- // col -->
								<div class="input-field s12 col l3">	
									<form:input path='despesaCondominio' type='text'/>
									<form:errors path='despesaCondominio'/> 
									<label for="despesaCondominio">R$</label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l9">	
									Luz:
								</div><!-- // col -->
								<div class="input-field s12 col l3">	
									<form:input path='despesaLuz' type='text'/>
									<form:errors path='despesaLuz'/> 
									<label for="despesaLuz">R$</label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l9">	
									Água:
								</div><!-- // col -->
								<div class="input-field s12 col l3">	
									<form:input path='despesaAgua' type='text'/>
									<form:errors path='despesaAgua'/> 
									<label for="despesaAgua">R$</label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l9">	
									Telefone:
								</div><!-- // col -->
								<div class="input-field s12 col l3">	
									<form:input path='despesaTelefone' type='text'/>
									<form:errors path='despesaTelefone'/> 
									<label for="despesaTelefone">R$</label>
								</div><!-- // col -->
							</div><!-- // row -->	
							<div class="row">
								<div class="input-field s12 col l9">	
									Alimentação:
								</div><!-- // col -->
								<div class="input-field s12 col l3">	
									<form:input path='despesaAlimentacao' type='text'/>
									<form:errors path='despesaAlimentacao'/> 
									<label for="despesaAlimentacao">R$</label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l9">	
									Transporte:
								</div><!-- // col -->
								<div class="input-field s12 col l3">	
									<form:input path='despesaTransporte' type='text'/>
									<form:errors path='despesaTransporte'/> 
									<label for="despesaTransporte">R$</label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l9">	
									Impostos:
								</div><!-- // col -->
								<div class="input-field s12 col l3">	
									<form:input path='despesaImpostos' type='text'/>
									<form:errors path='despesaImpostos'/> 
									<label for="despesaImpostos">R$</label>
								</div><!-- // col -->
							</div><!-- // row -->	
							<div class="row">
								<div class="input-field s12 col l4">	
									Descrição dos impostos:
								</div><!-- // col -->
								<div class="input-field s12 col l8">	
									<form:textarea path="despesaDescricaoDosImpostos" />
							<form:errors path="despesaDescricaoDosImpostos"></form:errors>
							<form:label path="despesaDescricaoDosImpostos">R$</form:label>
								</div><!-- // col -->
							</div><!-- // row -->					
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="input-field s12 col l12">
						<hr />
						<hr />
							<form:textarea path="parecerConclusivo" />
							<form:errors path="parecerConclusivo"></form:errors>
							<form:label path="parecerConclusivo">Parecer Conclusivo</form:label>
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</form:form>
	<br />
	<br />
</div><!-- // container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>