<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="login" method="POST">
    <label for="username">Username: </label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password: </label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="Login">
</form>

<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>
</body>
</html>
