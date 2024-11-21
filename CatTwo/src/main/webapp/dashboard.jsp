<%-- 
    Document   : dashboard
    Created on : Nov 21, 2024, 12:22:28 PM
    Author     : moses-imbahale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
        <h1>Welcome, ${username}!</h1>
        <p>Your role is: ${role}</p>
        <p>This page demonstrates session tracking and inter-servlet communication.</p>
        <a href="preferences">Manage Preferences</a>
    </body>
</html>
