<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 16/06/2023
  Time: 01:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>AttitudeStore</title>
    <!-- Incluir o CSS do Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<h1 class="text-center">Bem vindo a Attitude Store</h1>
<a href="compra?op=VerCarrinho">Ver itens no carrinho</a>
<div class="container d-flex justify-content-center align-items-center flex-column">

    <c:forEach var="r" items="${roupas}">
        <div class="card" style="width: 18rem;">
            <img src="https://a-static.mlcdn.com.br/450x450/blusa-branca-propria/vidasaudavelefeliz/9c9be39cb43611ec966f4201ac18506b/631c0aa72b2dbf77e3303fdb7137ea5f.jpeg" class="card-img-top" alt="...">
            <div class="card-body text-center">
                <h5 class="card-title">${r.nome}</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="compra?op=AdicionarItem&&id=${r.id}" class="btn btn-primary">Adicionar a compra</a>
            </div>
        </div>
    </c:forEach>


    <div class="mt-3">
        <a href="login?op=sair">Voltar</a>
    </div>

</div>

<!-- Incluir o JavaScript do Bootstrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
