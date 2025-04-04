<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="POJO.User" %>
<%@ page import="Services.UserService" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Список користувачів:</h2>
<ul>
    <%
        UserService userService = new UserService();
        List<User> users = userService.getAllUsers();

        for(User user : users) {
    %>
    <li><%= user.getUsername() %></li>
    <%
        }
    %>
</ul>
</body>
</html>
