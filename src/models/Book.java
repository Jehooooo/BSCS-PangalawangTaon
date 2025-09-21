package models;

import java.util.ArrayList;

public class Book {
    private static int counter = 1;
    private final int bookNumber;
    private String title;
    private String author;
    private String category;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author,String category, String isbn) {
        this.bookNumber = counter++;
        this.title = title;
        this.author = author;
        this.category = "General"; // Default category
        this.isbn = isbn;
        this.isAvailable = true; // New books are available by default
    }
    public int getBookNumber() {
        return bookNumber;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\nBook Number: "+ bookNumber+
                "Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Category='" + category + '\'' +
                ", Isbn='" + isbn + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
    public String displayInfo() {
        return "\nBook Number: "+ bookNumber+"\nTitle:" + title + ", \nAuthor: " + author + ", \nCategory: " + category + ", \nISBN: " + isbn + ", \nAvailable: " + isAvailable;
    }
}
