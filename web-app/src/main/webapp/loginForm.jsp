<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - TechBook</title>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
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
        <h2>Login</h2>
        <form method="POST" action="${pageContext.request.contextPath}/login" class="login-form">
            <label for="username">Username:</label><br>
            <input type="text" id="username" name="username" required><br>

            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password" required><br>

            <input type="submit" value="Login">
        </form>
    </main>

<!--    <footer>
        <p>&copy; 2024 TechBook Solutions. All Rights Reserved.</p>
    </footer>-->
</body>
</html>
