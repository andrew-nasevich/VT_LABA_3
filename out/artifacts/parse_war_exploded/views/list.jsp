<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="app.AutoBase.Vehicle" %><%--
  Created by IntelliJ IDEA.
  User: serge
  Date: 23.11.2019
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car list</title>
</head>
<body>
    Hi, everybody

    <c:if test="${vehicles != null && !vehicles.isEmpty()}">
        <table border="1">
            <caption> Vehicle table </caption>
            <tr>
                <th>Make</th>
                <th>Model</th>
                <th>Price</th>
                <th>FuelConsumption</th>
                <th>Power</th>
                <th>Year</th>
                <th>FuelType</th>
            </tr>

            <c:forEach var="vehicle" items="${vehicles}">
                <tr>
                    <td>${vehicle.getMake()}</td>
                    <td>${vehicle.getModel()}</td>
                    <td>${vehicle.getPrice()}</td>
                    <td>${vehicle.getFuelConsumption()}</td>
                    <td>${vehicle.getPower()}</td>
                    <td>${vehicle.getYear()}</td>
                    <td>${vehicle.getFuelType()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${vehicles == null || vehicles.isEmpty()}">
        <p>Empty list</p>
    </c:if>
    <c:if test="${pageIndex != 1}">
        <a href="/list?pageIndex=1">Start</a>
        <a href="/list?pageIndex=${pageIndex - 1}"><</a>
    </c:if>
    <c:if test="${pageIndex != pageCount}">
        <a href="/list?pageIndex=${pageIndex + 1}">></a>
    </c:if>
</body>
</html>
