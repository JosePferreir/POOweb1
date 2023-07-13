<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 13/07/2023
  Time: 01:34
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
    <h1>Histórico de Vendas</h1>

    <div class="card mt-3">
        <div class="card-body">
            <table class="table">
                <thead>
                    <tr>
                        <th>Cliente</th>
                        <th>Valor</th>
                        <th>Detalhes</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="compra" items="${historico}">
                        <tr>
                            <td>${compra.cliente.nome}</td>
                            <td>${compra.totalCompra}</td>
                            <td>
                                <a href="compra?op=VerCompra&&id=${compra.id}&&valor=${compra.totalCompra}" class="btn btn-success">
                                    <i class="fas fa-plus"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <a href="admin?op=Menu" class="btn btn-primary mt-3">Voltar</a>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
