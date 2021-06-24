<%--
  Created by IntelliJ IDEA.
  User: nikolayvaklinov
  Date: 24/06/2021
  Time: 00:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Default Home Page</title>
</head>
<body>
Spring REST Demo
<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
<br>
<a href="${pageContext.request.contextPath}/api/students">Get All Students</a>

</body>
</html>
