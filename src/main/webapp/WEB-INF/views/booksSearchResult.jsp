<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search result</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
        <th>Info</th>
        <th>Authors</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.year}</td>
            <td>${book.price}</td>
            <td>
                <a href="${pageContext.request.contextPath}/book/info/${book.id}">Info</a>
            </td>
            <td>${book.authors}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
