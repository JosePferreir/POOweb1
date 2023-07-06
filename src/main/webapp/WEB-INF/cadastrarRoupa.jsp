<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 16/06/2023
  Time: 04:18
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
  <title>Cadastrar Roupa</title>
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
      <h1 class="card-title">Cadastrar Roupas</h1>
      <br>
      <form method="post" action="roupas">
        <div class="form-group">
          <label for="nome">Nome:</label>
          <input type="text" class="form-control" id="nome" name="nome">
        </div>
        <div class="form-group">
          <label for="tamanho">Tamanho:</label>
          <input type="text" class="form-control" id="tamanho" name="tamanho">
        </div>
        <div class="form-group">
          <label for="preco">Preço:</label>
          <input type="number" class="form-control" id="preco" name="preco">
        </div>
        <div class="form-group">
          <label for="cor">Cor:</label>
          <input type="text" class="form-control" id="cor" name="cor">
        </div>
        <div class="form-group">
          <label for="descricao">Descrição:</label>
          <input type="text" class="form-control" id="descricao" name="descricao">
        </div>
        <input type="hidden" name="op" value="CadastrarRoupa">
        <br>
        <br>
        <button class="btn btn-primary" type="submit">Cadastrar Roupa</button>
      </form>

      <a href="admin?op=Menu">Voltar</a>
    </div>
  </div>
</div>

<!-- Incluir o JavaScript do Bootstrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
