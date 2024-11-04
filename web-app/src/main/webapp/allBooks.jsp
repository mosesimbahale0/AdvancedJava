<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kca.web.app.Book" %>

<%
    String username = (String) session.getAttribute("username");
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>All Books</title>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <header>
            <h1>TechBook</h1>
            <nav>
                <span>Welcome, <%= username%>!</span>
                <form action="logout" method="GET" style="display:inline;">
                    <button type="submit">Logout</button>
                </form>
            </nav>
        </header>

        <main>
            <ul>
                <%
                    List<Book> books = (List<Book>) request.getAttribute("books");
                    for (Book book : books) {
                %>
                <li>
                    <div class="book-detail">
                        <strong>Title:</strong> <span><%= book.getTitle()%></span>
                    </div>
                    <div class="book-detail">
                        <strong>Author:</strong> <span><%= book.getAuthor()%></span>
                    </div>
                    <div class="book-detail">
                        <strong>Description:</strong> <span><%= book.getDescription()%></span>
                    </div>
                    <div class="book-detail">
                        <strong>Published Date:</strong> <span><%= book.getCreatedAt()%></span>
                    </div>
                    <div class="book-detail">
                        <strong>Price:</strong> <span>$<%= book.getPrice()%></span>
                    </div>
                    <div class="book-detail">
                        <strong>Rating:</strong> <span><%= book.getRating()%> / 5.0</span>
                    </div>
                    <div class="book-detail">
                        <strong>Stock:</strong> <span><%= book.getStock()%></span>
                    </div>
                    <img src="<%= book.getImg()%>" alt="Book cover">




                    <form action="cart" method="post" style="display: inline;">
                        <input type="hidden" name="title" value="<%= book.getTitle()%>"/>

                        <!-- Quantity control section -->
                        <div style="display: inline-flex; align-items: center; gap: 5px;">
                            <!-- Decrease button -->
                            <button type="button" onclick="changeQuantity(this, -1)" style="width: 30px; height: 30px; font-size: 18px; border: 1px solid #ccc; background-color: #f9f9f9; color: #333; cursor: pointer; border-radius: 4px;">−</button>

                            <!-- Quantity input -->
                            <input type="number" name="quantity" value="1" min="1" style="width: 50px; text-align: center; border: 1px solid #ccc; border-radius: 4px; height: 30px; font-size: 16px;" />

                            <!-- Increase button -->
                            <button type="button" onclick="changeQuantity(this, 1)" style="width: 30px; height: 30px; font-size: 18px; border: 1px solid #ccc; background-color: #f9f9f9; color: #333; cursor: pointer; border-radius: 4px;">+</button>
                        </div>

                        <!-- Add to Cart button -->
                        <input type="hidden" name="action" value="add"/>
                        <button type="submit">Add to Cart</button>
                    </form>

                </li>
                <% }%>
            </ul>
        </main>

    </body>

    <script>
        // Function to change the quantity
        function changeQuantity(button, change) {
            const quantityInput = button.parentNode.querySelector('input[name="quantity"]');
            let currentQuantity = parseInt(quantityInput.value) || 1;

            // Ensure quantity does not go below the minimum value of 1
            const newQuantity = currentQuantity + change;
            if (newQuantity >= 1) {
                quantityInput.value = newQuantity;
            }
        }
    </script>
</html>
