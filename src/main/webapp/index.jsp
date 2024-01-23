<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Welcome to my server!" %>
</h1>

<form action="hello-servlet" method="GET">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name"><br>
    <input type="submit" value="Continue to Servlet">
</form>


<form action="login" method="post">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br>
    <input type="submit" value="Login">
</form>

<br/>

<h3>För testande endast</h3>

<a href="hello-servlet">Hello Servlet</a>

<a href="data-servlet">MySQL Database</a>

<a href="homepage-servlet">Homepage</a>



</body>
</html>