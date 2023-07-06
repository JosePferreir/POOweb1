<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 16/06/2023
  Time: 03:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Incluir o CSS do Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Menu admin</title>
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
    <div class="card">
        <div class="card-body">
            <h1 class="card-title">Bem vindo admin</h1>
            <a href="roupas?op=VerRoupas" class="card-link btn btn-primary">Ver roupas cadastradas</a> <br>
            <a href="admin?op=CadastrarRoupa" class="card-link btn btn-primary">Cadastrar roupa</a> <br> <br>
            <a href="clientes?op=getAllUsuarios" class="card-link btn btn-primary">Ver clientes cadastrados</a> <br> <br>
            <a href="index.jsp" class="card-link">Sair</a>
        </div>
    </div>
</div>

<!-- Incluir o JavaScript do Bootstrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
