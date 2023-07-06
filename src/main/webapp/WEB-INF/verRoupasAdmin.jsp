<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 16/06/2023
  Time: 06:02
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
    <title>Roupas cadastradas</title>
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
    <h1>Roupas cadastradas</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Tamanho</th>
            <th>Preço</th>
            <th>Cor</th>
            <th>Descrição</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="r" items="${roupas}">
            <tr>
                <td>${r.nome}</td>
                <td>${r.tamanho}</td>
                <td>${r.preco}</td>
                <td>${r.cor}</td>
                <td>${r.descricao}</td>
                <td>
                    <a href="roupas?op=Excluir&&id=${r.id}">Excluir</a>
                    <a href="roupas?op=Editar&&id=${r.id}">Editar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a class="btn btn-primary" href="admin?op=Menu">Voltar</a>
</div>

<!-- Incluir o JavaScript do Bootstrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

