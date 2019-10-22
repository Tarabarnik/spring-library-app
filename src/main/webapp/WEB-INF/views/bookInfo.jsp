<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book info page</title>
</head>
<body>
<h1>Hello Mate from book info page!</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
        <th>Authors</th>
    </tr>
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.year}</td>
        <td>${book.price}</td>
        <td>${book.authors}</td>
    </tr>
</table>
</body>
</html>
