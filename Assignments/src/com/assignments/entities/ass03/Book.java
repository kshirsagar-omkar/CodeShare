package com.assignments.entities.ass03;

public class Book {
    protected int bookISBN;
    protected String bookName;
    protected double bookPrice;
    protected String bookAuthor;
    protected String bookPublication;
    private static int bookCount;

    public Book() {
        this.bookISBN = 0;
        this.bookName = null;
        this.bookPrice = 0.00;
        this.bookAuthor = null;
        this.bookPublication = null;
    }

    public Book(int bookISBN, String bookName, double bookPrice, String bookAuthor, String bookPublication, int bookCount) {
        this.bookISBN = bookISBN;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
        this.bookPublication = bookPublication;
    }

    public int getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(int bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookPublication() {
        return bookPublication;
    }

    public void setBookPublication(String bookPublication) {
        this.bookPublication = bookPublication;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public static int getBookCount() {
        return bookCount;
    }
}
