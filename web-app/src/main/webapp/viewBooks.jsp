<%-- 
    Document   : viewBooks
    Created on : Oct 28, 2024, 1:52:57 PM
    Author     : moses-imbahale
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Book List</title>
    </head>
    <body>
        <h1>Book List</h1>
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Stock</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Book> books = (List<Book>) request.getAttribute("books");
                    if (books != null && !books.isEmpty()) {
                        for (Book book : books) {
                %>
                <tr>
                    <td><%= book.getTitle()%></td>
                    <td><%= book.getAuthor()%></td>
                    <td><%= book.getDescription()%></td>
                    <td><%= book.getPrice()%></td>
                    <td><%= book.getStock()%></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="5">No books found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
