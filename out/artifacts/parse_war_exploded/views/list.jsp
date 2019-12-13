<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Отель</title>
</head>
<body>
    Добро пожаловать!

    <c:if test="${rooms != null && !rooms.isEmpty()}">
        <table border="1">

            <caption> Клиенты </caption>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Price</th>
                <th>Sale</th>
                <th>Number</th>
                <th>Count Of Rooms</th>
            </tr>

            <c:forEach var="room" items="${rooms}">
                <tr>
                    <td>${room.getName()}</td>
                    <td>${room.getSurname()}</td>
                    <td>${room.getPrice()}</td>
                    <td>${room.getSale()}</td>
                    <td>${room.getNumber()}</td>
                    <td>${room.getCountOfRoom()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${rooms == null || rooms.isEmpty()}">
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
