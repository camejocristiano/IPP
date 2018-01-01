<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<footer class="page-footer orange">
	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">Company Bio</h5>
				<p class="grey-text text-lighten-4">We are a team of college
					students working on this project like it's our full time job. Any
					amount would help support and continue development on this project
					and is greatly appreciated.</p>


			</div>
			<div class="col l3 s12">
				<h5 class="white-text">Settings</h5>
				<ul>
					<li><a class="white-text" href="#!">Link 1</a></li>
					<li><a class="white-text" href="#!">Link 2</a></li>
					<li><a class="white-text" href="#!">Link 3</a></li>
					<li><a class="white-text" href="#!">Link 4</a></li>
				</ul>
			</div>
			<div class="col l3 s12">
				<h5 class="white-text">Connect</h5>
				<ul>
					<li><a class="white-text" href="#!">Link 1</a></li>
					<li><a class="white-text" href="#!">Link 2</a></li>
					<li><a class="white-text" href="#!">Link 3</a></li>
					<li><a class="white-text" href="#!">Link 4</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="footer-copyright">
		<div class="container">
			Made by <a class="orange-text text-lighten-3"
				href="http://materializecss.com">Materialize</a>
		</div>
	</div>
</footer>

<c:import url="../../partials/js.jsp"></c:import>

	<!-- Scripts de Inicialização das tabelas -->
    <script type="text/javascript">
        $(document).ready(function() {
            $('#tabelaUsuarios').DataTable();
        } );
    </script>
    
    <script type="text/javascript">
        $(document).ready(function() {
            $('#tabelaUnidades').DataTable();
        } );
    </script>
    
        <script type="text/javascript">
        $(document).ready(function() {
            $('#tabelaGruposDePermissoes').DataTable();
        } );
    </script>
    
    <script type="text/javascript">
        $(document).ready(function() {
            $('#tabelaAgendamentos').DataTable();
        } );
    </script>
    
    <script type="text/javascript">
        $(document).ready(function() {
            $('#tabelaCanais').DataTable();
        } );
    </script>
    
    <script type="text/javascript">
        $(document).ready(function() {
            $('#tabelaArquivos').DataTable();
        } );
    </script>