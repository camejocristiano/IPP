<!--
<table id="tabelaUsuarios" class="display">
        <thead>
          <tr>
            <th>ID</th>
            <th>NOME</th>
             <th>EMPRESA</th>
            <th>INÍCIO</th>
            <th>PAP</th>

            <th>ÚNICO</th>
            <th>ÚNICO_IDA_E_VOLTA</th>
            <th>ÚNICO_PARA_JOVEM</th>
            <th>ÚNICO_PARA_SPTRANS</th>

            <th>BOM</th>
            <th>BOM_IDA_E_VOLTA</th>
            <th>BOM_PARA_JOVEM</th>
            <th>BOM_PARA_CMT</th>
	
	        <th>BEM</th>
            <th>BEM_IDA_E_VOLTA</th>
            <th>BEM_PARA_JOVEM</th>
	
            <th>TOTAL_DO_ALUNO</th>
            <th>TOTAL_DA_CONCESSIONÁRIA</th>
	
            <th>VALOR_IPP</th>
            <th>VALOR_EMPRESA</th>
            <th>DATA_INÍCIO_DO_CONTRATO</th>
            <th>DATA_FIM_DO_CONTRATO</th>
     
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="contratacao" items="${requestScope.contratacoes}">
          <tr>
            <td>${contratacao.jovem.codigoDoJovem}</td>
            <td>${contratacao.jovem.nome}</td>
             <td>${vt.empresa}</td>
            <td>${vt.inicio}</td>
            <td>${vt.pap}</td>
            <td>${vt.unico}</td>
            <td>${vt.unicoIdaEVolta}</td>
            <td>${vt.unicoParaJovem}</td>
            <td>${vt.unicoParaSPTans}</td>
            <td>${vt.bom}</td>
            <td>${vt.bomIdaEVolta}</td>
            <td>${vt.bomParaJovem}</td>
            <td>${vt.bomParaCMT}</td>
            <td>${vt.bEM}</td>
            <td>${vt.bEMIdaEVolta}</td>
            <td>${vt.bEMParaJovem}</td>
            <td>${vt.totalAluno}</td>
            <td>${vt.totalConcessionaria}</td>
            <td>${vt.valorIPP}</td>
            <td>${vt.valorEmpresa}</td>
            <td>${vt.dataInicioContrato}</td>
            <td>${vt.dataFimContrato}</td>
	 
            <c:url value="/sw/vt/${jovem.id}" var="swVtId"></c:url>
            <td class="td-icon"><a href="${swVtId}"><i class="material-icons" >border_color</i></a></td>
          </tr>
              
          </c:forEach>
          </tbody>
          
      </table> 
     -->