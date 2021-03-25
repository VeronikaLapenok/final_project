<%--
  Created by IntelliJ IDEA.
  User: veronika
  Date: 3/25/21
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Result: ${numResult}
<br/>
    <table>
        <c:forEach var="elem" items="${lst}" varStatus="status">
            <tr>
                <td><c:out value="${ elem.userId }" /></td>
                <td><c:out value="${ elem.name }" /></td>
                <td><c:out value="${ elem.surname }" /></td>
                <td><c:out value="${ elem.age }" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
