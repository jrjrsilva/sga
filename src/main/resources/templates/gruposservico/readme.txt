<div class="form-group col-xs-4">
					<label for="nome">Nome</label>

					<input id="nome" type="text" class="form-control"  
						required="required"
						th:field="*{nome}" />
				</div>
				<div class="form-group col-xs-4">
					<label for="letra">Grupo</label>

					<input id="letra" type="text" class="form-control"  
						required="required"
						th:field="*{letra}" />
				</div>
				
			th:object="${gruposervico}" th:action="@{/gruposservico/novo}"
			
			<!DOCTYPE html>
<html lang="pt"
    xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
    layout:decorate="~{layout/layout-padrao}">
<head>
</head>

<body>
	<section layout:fragment="conteudo">
		<div class="page-header">
			<div class="container-fluid">
				<div class="row">
					<div class="col-xs-8">
						<h1>
							Cadastro de Grupo
						</h1>
					</div>

					<div class="col-xs-2">
						<div class="aw-page-header-controls">
							<a class="btn btn-primary" th:href="@{/gruposservico}">
								<i class="fa fa-table"></i>

								<span class="hidden-xs hidden-sm">Lista de grupos</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid">

			<form method="POST" class="form-vertical  js-form-loading">
				<div class="alert  alert-danger  alert-dismissible" role="alert"
					th:if="${#fields.hasAnyErrors()}">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

					<div th:each="erro: ${#fields.detailedErrors()}">
						<i class="fa fa-exclamation-circle"></i>
						
						<span th:text="${erro.message}">Mensagem erro.</span>
					</div>
				</div>

				<div class="alert  alert-success"
					th:if="${!#strings.isEmpty(mensagem)}">
					<i class="fa fa-check-circle"></i>
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span th:text="${mensagem}">Mensagem sucesso!</span>
					</button>

					
				</div>
				
				<input type="hidden" th:field="*{id}" />

				
				


				<div class="form-group col-xs-12">
					<button class="btn  btn-primary" type="submit">Salvar</button>
				</div>
			</form>
		</div>
	</section>
</body>
</html>
			<!DOCTYPE html>
<html lang="pt"
    xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
    layout:decorate="~{layout/layout-padrao}">
<head>
</head>

<body>
	<section layout:fragment="conteudo">
		<div class="page-header">
			<div class="container-fluid">
				<div class="row">
					<div class="col-xs-8">
						<h1>
							Cadastro de Grupo
						</h1>
					</div>

					<div class="col-xs-2">
						<div class="aw-page-header-controls">
							<a class="btn btn-primary" th:href="@{/gruposservico}">
								<i class="fa fa-table"></i>

								<span class="hidden-xs hidden-sm">Lista de grupos</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid">

			<form method="POST" class="form-vertical  js-form-loading">
				<div class="alert  alert-danger  alert-dismissible" role="alert"
					th:if="${#fields.hasAnyErrors()}">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

					<div th:each="erro: ${#fields.detailedErrors()}">
						<i class="fa fa-exclamation-circle"></i>
						
						<span th:text="${erro.message}">Mensagem erro.</span>
					</div>
				</div>

				<div class="alert  alert-success"
					th:if="${!#strings.isEmpty(mensagem)}">
					<i class="fa fa-check-circle"></i>
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span th:text="${mensagem}">Mensagem sucesso!</span>
					</button>

					
				</div>
				
				<input type="hidden" th:field="*{id}" />

				
				


				<div class="form-group col-xs-12">
					<button class="btn  btn-primary" type="submit">Salvar</button>
				</div>
			</form>
		</div>
	</section>
</body>
</html>
			