<%--
  Created by IntelliJ IDEA.
  User: josep
  Date: 16/06/2023
  Time: 06:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        </tr>
        </thead>
        <tbody>
        <c:forEach var="r" items="${roupas}">
            <tr>
                <td>${r.nome}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
