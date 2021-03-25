<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>System "Delivery service"</title>
</head>
<body>
<table>
    <c:forEach var="user" items="${users}" varStatus="status">
        <tr>
            <td><c:out value="${ user.userId }" /></td>
            <td><c:out value="${ user.name }" /></td>
            <td><c:out value="${ user.surname }" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
