
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Payments</h1>


</form>

<form action="payment-servlet" method="POST">
    <label for="title">Titel</label>
    <input type="text" id="title" name="title">

    <label for="date">Date</label>
    <input type="date" id="date" name="date">

    <label for="description">Description</label>
    <textarea id="description" name="description"></textarea>

    <label for="category">Category</label>
    <textarea id="category" name="category"></textarea>

    <label for="price">Price €: </label>
    <input type="number" id="price" name="price">

    <input type="submit" value="Submit">

</form>


</body>
</html>
