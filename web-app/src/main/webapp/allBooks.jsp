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


        <style>
            body {
                font-family: 'Ubuntu', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
                color: #333;
            }

            header {
                background-color: #fff;
                color: #333;
                padding: 1rem 2rem;
                display: flex;
                justify-content: space-between;
                align-items: center;
                border-bottom: 1px solid #ddd;
                position: fixed;
                top: 0;
                right: 0;
                left: 0;
                z-index: 100;
            }

            header h1 {
                font-size: 2rem;
                font-weight: 700;
                margin: 0;
            }

            header nav {
                display: flex;
                gap: 1.5rem;
            }

            header nav a {
                color: #333;
                text-decoration: none;
                font-weight: 500;
                transition: color 0.3s ease;
            }

            header nav a:hover {
                color: #ff9800;
            }

            main {
                padding: 100px 2rem 2rem; /* Adjusted for fixed header */

                margin: 0 auto;

                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            .book-list {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
                gap: 1.5rem;
                margin-top: 2rem;
            }

            .book-item {
                background-color: #fff;
                padding: 1.5rem;
                border-radius: 10px;
                box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
                transition: transform 0.2s;
                text-align: left;
            }

            .book-item:hover {
                transform: translateY(-10px);
            }

            .book-item img {
                height: 200px;
                width: auto;
                object-fit: cover;
                border-radius: 8px;
                margin-bottom: 1rem;
            }

            .book-detail {
                font-size: 1rem;
                color: #666;
                margin-bottom: 0.5rem;
            }

            .book-detail strong {
                font-weight: 600;
                color: #333;
            }

            .quantity-controls {
                display: flex;
                justify-content: left;
                align-items: center;
                margin-bottom: 1rem;
                margin-top: 10px;
            }

            .quantity-controls button {
                background-color: #333;
                color: white;
                border: none;
                padding: 0.4rem 0.8rem;
                cursor: pointer;
                font-size: 1rem;
                border-radius: 4px;
                transition: background-color 0.3s;
            }

            .quantity-controls button:hover {
                background-color: #ff9800;
            }

            input[type="number"] {
                text-align: center;
                width: 50px;
                border: 1px solid #ddd;
                padding: 0.4rem;
                margin: 0 0.5rem;
                border-radius: 4px;
            }

            form button {
                background-color: #ff9800;
                color: white;
                border: none;
                padding: 0.7rem 1.2rem;
                cursor: pointer;
                font-size: 1rem;
                border-radius: 4px;
                transition: background-color 0.3s;
            }

            form button:hover {
                background-color: #e68900;
            }

            footer {
                text-align: center;
                padding: 2rem;
                background-color: #f4f4f4;
                color: #777;
                font-size: 0.9rem;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>TechBook</h1>
            <span>Welcome, <%= username%>!</span>
            <nav>
                <form action="logout" method="GET">
                    <button type="submit">Logout</button>
                </form>
            </nav>
        </header>

        <main>
            <h2>Available Books</h2>
            <div class="book-list">
                <%
                    List<Book> books = (List<Book>) request.getAttribute("books");
                    for (Book book : books) {
                %>
                <div class="book-item">
                    <img src="<%= book.getImg()%>" alt="Book cover">
                    <div>
                        <div class="book-detail">
                            <strong>Title:</strong> <%= book.getTitle()%>
                        </div>
                        <div class="book-detail">
                            <strong>Author:</strong> <%= book.getAuthor()%>
                        </div>
                        <div class="book-detail">
                            <%= book.getDescription()%>
                        </div>
                        <div class="book-detail">
                            <strong>Price:</strong> $<%= book.getPrice()%>
                        </div>
                        <div class="book-detail">
                            <strong>Rating:</strong> <%= book.getRating()%> / 5.0
                        </div>
                        <div class="book-detail">
                            <strong>Stock:</strong> <%= book.getStock()%> available
                        </div>

                        <form action="cart" method="post">
                            <input type="hidden" name="title" value="<%= book.getTitle()%>" />
                            <div class="quantity-controls">
                                <button type="button" onclick="changeQuantity(this, -1)">−</button>
                                <input type="number" name="quantity" value="1" min="1" />
                                <button type="button" onclick="changeQuantity(this, 1)">+</button>
                            </div>
                            <input type="hidden" name="action" value="add" />
                            <button type="submit">Add to Cart</button>
                        </form>
                    </div>
                </div>
                <% }%>
            </div>
        </main>

        <footer>
            &copy; 2024 TechBook Solutions. All Rights Reserved.
        </footer>

        <script>
            function changeQuantity(button, change) {
                const quantityInput = button.parentNode.querySelector('input[name="quantity"]');
                let currentQuantity = parseInt(quantityInput.value) || 1;
                const newQuantity = currentQuantity + change;
                if (newQuantity >= 1) {
                    quantityInput.value = newQuantity;
                }
            }
        </script>
    </body>
</html>
