<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaArquivos" class="display" width="100%" cellspacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>NOME DO ARQUIVO</th>
            <th>URL</th>
            <th>LOCAL DO ARQUIVO</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="arquivo" items="${requestScope.arquivos}">
          <tr>
            <td>${arquivo.id}</td>
            <td>${arquivo.nomeDoArquivo}</td>
            <td>${arquivo.url}</td>
            <td>${arquivo.localDoArquivo}</td>
            <td class="td-icon"><a href="/arquivos/${arquivo.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/arquivo">
                <i class="material-icons">add</i>
            </a>
         </div>