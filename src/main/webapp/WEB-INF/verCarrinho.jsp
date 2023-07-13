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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
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
        <thead class="table-secondary">
        <tr>
            <th>Nome</th>
            <th>Tamanho</th>
            <th>Cor</th>
            <th>Quantidade</th>
            <th>Remover</th>
            <th>Preço</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="r" items="${carrinho.roupas}">
            <tr>
                <td>${r.nome}</td>
                <td>${r.tamanho}</td>
                <td>${r.cor}</td>
                <td>${r.quantidade}</td>
                <td>
                    <a class="btn btn-danger" href="compra?op=RemoverItem&&id=${r.id}">
                        <i class="fas fa-trash-alt"></i>
                    </a>
                </td>
                <td>${r.preco*r.quantidade} (${r.preco}x${r.quantidade})</td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot class="table-secondary">
        <tr>
            <th colspan="5">Valor total:</th>
            <th>${carrinho.totalCompra}</th>
        </tr>
        </tfoot>
    </table>
    <div class="d-flex justify-content-between">
        <div>
            <a href="compra?op=VerCatalogo" class="btn btn-primary">Voltar</a>
        </div>
        <div>
            <a href="compra?op=FinalizarCompra" class="btn btn-primary">Finalizar Compra</a>
        </div>
    </div>

</div>

<!-- Incluir o JavaScript do Bootstrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
