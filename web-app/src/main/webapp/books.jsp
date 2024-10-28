<%-- 
    Document   : books
    Created on : Oct 28, 2024, 10:20:31 AM
    Author     : moses-imbahale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Books List</title>
    </head>
    <body>
        <h2>List of Books</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Description</th>
                    <th>Created At</th>
                    <th>Image</th>
                    <th>Rating</th>
                    <th>Price</th>
                    <th>Stock</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.description}</td>
                    <td>${book.createdAt}</td>
                    <td><img src="${book.img}" alt="${book.title} image" height="50" /></td>
                    <td>${book.rating}</td>
                    <td>${book.price}</td>
                    <td>${book.stock}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
