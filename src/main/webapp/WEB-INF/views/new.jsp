<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New book</title>
</head>
<body>
<form  action="${pageContext.request.contextPath}/book/add" method="get">
    <div>
        <p>Please fill in this form to create a book.</p>
        <hr>
        <label for="title"><b>Title</b></label>
        <input type="text" placeholder="Enter title" name="title" required>

        <label for="year"><b>Year</b></label>
        <input type="number" placeholder="Enter year" name="year" required>

        <label for="price"><b>Price</b></label>
        <input type="number" placeholder="Enter price" name="price" required>
        <hr>
        <button type="submit">Add</button>
    </div>
</form>
</body>
</html>
