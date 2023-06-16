<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 14/06/2023
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Clientes</title>
</head>
<body>
    <h1>Clientes cadastrados</h1>

    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Idade</th>
                <th>CPF</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${cliente}">
                <c:if test="${c.permissao.nome == 'CLIENTE'}">
                    <tr>
                        <td>${c.nome}</td>
                        <td>${c.idade}</td>
                        <td>${c.cpf}</td>
                        <td>${c.email}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>

    <a href="admin?op=Menu">Voltar</a>


</body>
</html>
