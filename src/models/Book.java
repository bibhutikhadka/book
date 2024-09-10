package models;

public class Book {
    private String title;
    private String author;
    private String description;
    private float price;
    private int stock;
    private boolean available;
    private Genre genre;

    public Book(String title, String author, String description, float price, int stock, boolean available, Genre genre) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.available = available;
        this.genre = genre;
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

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Genre getGenre() {
        return genre;
    }
}
