<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/new" method="post">
    <div>
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="user_name"><b>Name</b></label>
        <input type="text" placeholder="Name" name="firstName" required>

        <label for="user_surname"><b>Surname</b></label>
        <input type="text" placeholder="Surname" name="lastName" required>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Email" name="email" required>

        <label for="login"><b>login</b></label>
        <input type="text" placeholder="Enter login" name="username" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="repeatPassword" required>
        <hr>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="login">Sign in</a>.</p>
    </div>
</form>
</body>
</html>
