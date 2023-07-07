<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 06/07/2023
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Seu carrinho</title>
    <!-- Incluir o CSS do Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
    <h1 class="text-center">Itens no seu carrinho</h1>

    <table class="table">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Tamanho</th>
            <th>Preço</th>
            <th>Cor</th>
            <th>Descrição</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="r" items="${roupas}">
            <tr>
                <td>${r.roupas.nome}</td>
                <td>${r.roupas.tamanho}</td>
                <td>${r.roupas.preco}</td>
                <td>${r.roupas.cor}</td>
                <td>${r.roupas.descricao}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a href="compra?op=VerCatalogo">Voltar</a>
    </div>
</div>

<!-- Incluir o JavaScript do Bootstrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
