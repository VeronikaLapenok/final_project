<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="pagecontent" />
<!DOCTYPE html>
<html>
<head>
    <title>System "Delivery service"</title>
</head>
<body>
    <h1>Delivery service</h1>
    <br/>
    <h3>Welcome!</h3>
    <hr/>
        ${user}, hello!
    <hr/>
    <form action="controller" method="post">
        <input type="text" name="user_surname">
        <input type="hidden" name="command" value="find_user_by_surname">
        <input type="submit" name="submit" value="Find user by surname">
    </form>
    <br/>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="show_all_users">
        <input type="submit" name="submit" value="Show all users">
    </form>
    <br/>
    <a href="controller?command=logout">Log out</a>
</body>
</html>