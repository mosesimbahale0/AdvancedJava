<%-- 
    Document   : register
    Created on : Nov 4, 2024, 9:31:53 PM
    Author     : moses-imbahale
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register - TechBook</title>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>


    <body>

        <header>
            <h1>TechBook</h1>
            <nav>
                <a href="${pageContext.request.contextPath}/register">Register</a>
                <a href="${pageContext.request.contextPath}/view-books">Books</a>
            </nav>
        </header>
        <main>
            <h2 style="text-align:center;">Register</h2>
            <form method="POST" action="${pageContext.request.contextPath}/register" class="login-form">
                <label for="username">Username:</label><br>
                <input type="text" id="username" name="username" required><br>

                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password" required><br>

                <label for="confirmPassword">Confirm Password:</label><br>
                <input type="password" id="confirmPassword" name="confirmPassword" required><br>

                <input type="submit" value="Register">
            </form>
            <p><a href="${pageContext.request.contextPath}/login">Already have an account? Login</a></p>
        </main>
    </body>
</html>
