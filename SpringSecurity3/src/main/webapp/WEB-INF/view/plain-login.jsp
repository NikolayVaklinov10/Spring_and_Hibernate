<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nikolayvaklinov
  Date: 22/06/2021
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom Login Page</title>
    <style>
        .failed {
            color: crimson;
        }
    </style>
</head>
<body>
<h3>My Custom Login Page</h3>

    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                method="POST">
        <! -- Check for login error -->
        <c:if test="${param.error != null}" >
            <i class="failed">Sorry! You entered invalid username or password.</i>
        </c:if>

        <p>
            User name: <input type="text" name="username" />
        </p>
        <p>
            User name: <input type="password" name="password" />
        </p>

        <input type="submit" value="Login" />


    </form:form>


</body>
</html>
