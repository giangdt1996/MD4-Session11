<%--
  Created by IntelliJ IDEA.
  User: shmily
  Date: 02/08/2023
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>


<div style="text-align: center">
  <h1>Add New Product</h1>
<form method="post"  action="/Home" >
  <label>Name</label>
  <input type="text" name="name" style ="height: 50px;width: 300px;margin-top: 30px;margin-left: 100px">
  <br>
  <label>Price</label>
  <input type="text" name="price" style ="height: 50px;width: 300px;margin-top: 30px;margin-left: 100px" >
  <br>
  <label>Description</label>
  <input type="text" name="description" style ="height: 50px;width: 300px;margin-top: 30px;margin-left: 100px">
  <br>
  <input type="submit" value="submit" name="action" style ="height: 50px;width: 100px;background-color: blue;color: white ;margin-top: 30px;border-radius: 10px">
</form>
</div>
</body>
</html>
