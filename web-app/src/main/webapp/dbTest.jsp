<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Database Test</title>
    </head>
    <body>
        <h1>Database Connection Test</h1>
        <% Boolean dbConnection = (Boolean) request.getAttribute("dbConnection"); %>
        <% if (dbConnection != null && dbConnection) { %>
            <p style="color:green;">Connection successful!</p>
        <% } else { %>
            <p style="color:red;">Connection failed!</p>
        <% } %>
    </body>
</html>
