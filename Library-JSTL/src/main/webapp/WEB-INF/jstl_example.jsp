<%--
  Created by IntelliJ IDEA.
  User: shmily
  Date: 03/08/2023
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
"
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL Core Tags Example 01</title>
</head>
<body>
<h2>Departments and Employees</h2>

<c:forEach items="${departments}" var="dept">
    <h3>${dept.deptName}</h3>
    <ul>
        <c:forEach items="${dept.employees}" var="emp">
            <li>
                ${emp.empName} - (${emp.job})
            </li>
        </c:forEach>    </ul>
</c:forEach>
</body>
</html>
