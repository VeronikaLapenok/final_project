<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Log in - Delivery service</title>
</head>
<body>
    <form name="Login form" method="post" action="controller">
        <input type="hidden" name="command" value="login" />
        Login:<br/>
        <input type="text" name="Login" value="" />
        <br/>Password:<br/>
        <input type="password" name="password" value="" /> <br/>
        ${errorLoginPassMessage} <br/>
        ${wrongAction} <br/>
        ${nullPage} <br/>
        <input type="submit" value="Log in" />
    </form>
</body>
</html>
