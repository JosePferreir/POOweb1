<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 15/06/2023
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar-se</title>
</head>
<body>
    <form method="post" action="clientes">
        <label for="nome">Nome: </label>
        <input type="text" id="nome" name="nome"><br />
        <label for="idade">Idade: </label>
        <input type="number" id="idade" name="idade"><br />
        <label for="cpf">CPF: </label>
        <input type="text" id="cpf" name="cpf"><br />
        <label for="email">Email: </label>
        <input type="text" id="email" name="email"><br />
        <label for="senha">Senha: </label>
        <input type="password" id="senha" name="senha">
        <input type="hidden" name="op" value="cadastrar">
        <br />
        <br />
        <button type="submit">Cadastrar-se</button>
    </form>
    <a href="index.jsp">Login</a>

</body>
</html>
