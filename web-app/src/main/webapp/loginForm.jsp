<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - TechBook</title>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;500;700&display=swap" rel="stylesheet">

        <style>
            /* Basic reset and font styling */
            body {
                font-family: 'Ubuntu', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
                color: #333;
            }

            /* Header styling */
            header {
                background-color: #fff;
                color: #333;
                padding: 1rem;
                display: flex;
                justify-content: space-between;
                align-items: center;
                border-bottom: 1px solid #ddd;
            }

            header h1 {
                font-size: 2rem;
                margin: 0;
            }

            header nav {
                display: flex;
                gap: 1rem;
            }

            header nav a {
                color: #333;
                text-decoration: none;
                font-weight: 500;
                transition: color 0.3s;
            }

            header nav a:hover {
                color: #ff9800;
            }

            /* Main section */
            main {
                padding: 2rem;
                max-width: 500px;
                margin: 0 auto;
                margin-top: 50px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            main h2 {
                font-size: 2rem;
                margin-bottom: 1rem;
                text-align: center;
            }

            .login-form {
                display: flex;
                flex-direction: column;
                gap: 0.2rem; 
            }

            .login-form label {
                font-size: 1rem;
                margin-bottom: 0.5rem;
            }

            .login-form input[type="text"],
            .login-form input[type="password"] {
                padding: 0.5rem;
                font-size: 1rem;
                border: 1px solid #ddd;
                border-radius: 4px;
            }

            .login-form input[type="submit"] {
                background-color: #333;
                color: #fff;
                border: none;
                padding: 0.75rem;
                border-radius: 4px;
                cursor: pointer;
                font-size: 1rem;
                transition: background-color 0.3s;
            }

            .login-form input[type="submit"]:hover {
                background-color: #ff9800;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>TechBook</h1>
            <nav>
                <a href="${pageContext.request.contextPath}/register">Register</a>
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

        <!-- Uncomment if needed -->
        <!--
        <footer>
            <p>&copy; 2024 TechBook Solutions. All Rights Reserved.</p>
        </footer>
        -->
    </body>
</html>
