package Baiseasion8;

public class Book
{
    String title;
    String author;
    Double price;

    public  Book(String title, String author, Double price)
    {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public static void main(String[] args)
    {
        Book b = new Book("Hary Potter", "JK Rolling", 12.5);
        System.out.println("Title: " + b.title + ", Author: " + b.author + ", Price: " + b.price);
    }
}
