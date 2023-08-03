<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shmily
  Date: 02/08/2023
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="./view/add.jsp">Add Product</a>

<h1>Products List</h1>
<table border="5" cellpadding="10">
    <tr>
        <th> ID</th>
        <th> Name</th>
        <th> Price</th>
        <th> Description</th>
        <th colspan="2">Action </th>
    </tr>
    <c:forEach items="${products}" var="$">
        <tr>
            <td>${$.id}</td>
            <td>${$.name}</td>
            <td>${$.price}</td>
            <td>${$.description}</td>
            <td><a onclick="return confirm('Are you sure???')" href="/Home?action=delete&id=${$.id}">Delete</a></td>
            <td><a href="/Home?action=edit&id=${$.id}">Edit</a></td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
