package kca.desktop.app;

public class Book {
    private int id;
    private String title;
    private String author;
    private String description; // Add description field
    private double price;
    private String createTime;
    private String img; // Add img field
    private int rating; // Add rating field
    private int stock;  // Add stock field

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getImg() {
        return img;
    }

    public int getRating() {
        return rating;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
