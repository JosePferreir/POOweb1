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

    <c:forEach var="c" items="${clientes}">
        ${c.nome}
    </c:forEach>
</body>
</html>
