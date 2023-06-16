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
<html>
<head>
    <title>Roupas cadastradas</title>
</head>
<body>
    <h1>Roupas cadastradas</h1>
    <br>
    <table>
        <thead>
        <tr>
            <th>Nome</th>
            <th>Tamanho</th>
            <th>Preco</th>
            <th>Cor</th>
            <th>Descricao</th>
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
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="admin?op=Menu">Voltar</a>

</body>
</html>
