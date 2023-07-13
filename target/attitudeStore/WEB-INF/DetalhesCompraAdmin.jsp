<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 13/07/2023
  Time: 02:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/css/bootstrap.min.css">
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
    <h1>Detalhes da compra</h1>

        <div class="card mt-3">
            <div class="card-body">
                <table class="table">
                    <thead class="table-secondary">
                    <tr>
                        <th>Nome</th>
                        <th>Tamanho</th>
                        <th>Cor</th>
                        <th>Quantidade</th>
                        <th>Preço</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="r" items="${compra.roupas}">
                        <tr>
                            <td>${r.nome}</td>
                            <td>${r.tamanho}</td>
                            <td>${r.cor}</td>
                            <td>${r.quantidade}</td>
                            <td>${r.preco*r.quantidade} (${r.preco}x${r.quantidade})</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th colspan="4">Valor total:</th>
                        <th>${compra.totalCompra}</th>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>

    <a href="compra?op=getHistoricoAdmin" class="card-link btn btn-primary mt-2">Voltar</a>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>