<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 16/06/2023
  Time: 04:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar Roupa</title>
</head>
<body>
  <h1>Cadastrar Roupas</h1>
  <br>
  <form method="post" action="roupas">
    <label for="nome">Nome: </label>
    <input type="text" id="nome" name="nome"><br />
    <label for="tamanho">Tamanho: </label>
    <input type="text" id="tamanho" name="tamanho"><br />
    <label for="preco">Preço: </label>
    <input type="number" id="preco" name="preco"><br />
    <label for="cor">Cor: </label>
    <input type="text" id="cor" name="cor"><br />
    <label for="descricao">Descricao: </label>
    <input type="text" id="descricao" name="descricao">
    <input type="hidden" name="op" value="CadastrarRoupa">
    <br />
    <br />
    <button type="submit">Cadastrar Roupa</button>
  </form>

  <a href="admin?op=Menu">Voltar</a>
</body>
</html>
