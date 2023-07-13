<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 12/07/2023
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Incluir o CSS do Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Editar usuário</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Seus dados cadastrados</h1>

    <div class="card">
        <div class="card-body">
            <form method="post" action="clientes">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" class="form-control" id="nome" name="nome" value="${usuario.nome}">
                </div>
                <div class="form-group">
                    <label for="idade">Idade:</label>
                    <input type="number" class="form-control" id="idade" name="idade" value="${usuario.idade}">
                </div>
                <div class="form-group">
                    <label for="cpf">CPF:</label>
                    <input type="text" class="form-control" id="cpf" name="cpf" value="${usuario.cpf}">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" class="form-control" id="email" name="email" value="${usuario.email}">
                </div>
                <div class="form-group">
                    <label for="senha">Senha:</label>
                    <input type="password" class="form-control" id="senha" name="senha" value="${usuario.senha}">
                </div>
                <input type="hidden" name="op" value="confirmarEditar">
                <input type="hidden" name="id" value="${usuario.id}">
                <br />
                <br />
                <button type="submit" class="btn btn-primary">Salvar Perfil</button>
            </form>

            <a href="compra?op=VerHistoricoUsuario" class="btn btn-primary mt-2">Histórico de Compras</a>
        <%--
            <c:choose>
                <c:when test="${usuario.endereco != null}">
                    <p>Editar Endereço</p>
                </c:when>
                <c:otherwise>
                    <a href="endereco?op=AdicionarEndereco" class="btn btn-primary mt-2">Adicionar Endereco</a>
                </c:otherwise>
            </c:choose>
            --%>
        </div>
    </div>

    <a href="compra?op=VerCatalogo" class="btn btn-primary mt-3">Voltar</a>
</div>

<!-- Incluir o JavaScript do Bootstrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>