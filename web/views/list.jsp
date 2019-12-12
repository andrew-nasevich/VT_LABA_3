<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Hotel list</title>
</head>
<body>
    Добро пожаловать)

    <c:if test="${vehicles != null && !vehicles.isEmpty()}">
        <table border="1">

            <caption> Таблица </caption>
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
