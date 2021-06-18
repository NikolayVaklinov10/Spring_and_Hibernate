<%--
  Created by IntelliJ IDEA.
  User: nikolayvaklinov
  Date: 18/06/2021
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <! -- add our html table here  -->

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
                <!--    loop over and print out customer   -->
                <c:forEach var="tempCustomer" items="${customers}">

                    <tr>
                        <td> ${tempCustomer.firstName} </td>
                        <td> ${tempCustomer.lastName} </td>
                        <td> ${tempCustomer.email} </td>
                    </tr>
                </c:forEach>


            </table>

        </div>
    </div>


</body>
</html>
