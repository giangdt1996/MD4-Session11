<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h1>Update Product</h1>
<form method="post" action="/Home">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${param.id}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${products.name}">
    <br>
    <label for="price">Price:</label>
    <input type="double" id="price" name="price" value="${products.price}">
    <br>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" value="${products.description}" >
    <br>
    <input type="submit" value="Update">
</form>
</body>
</html>
