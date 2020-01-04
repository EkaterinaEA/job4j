package ru.job4j.pojo;

import java.util.ArrayList;

public class Library {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("War and Peace", 1274);
        Book book2 = new Book("Hamlet", 283);
        Book book3 = new Book("Romeo and Juliet", 100);
        Book book4 = new Book("Clean code", 786);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        for (Book book : books) {
            System.out.println("Book name: " + book.getName() + ", pages: " + book.getPages());
        }

        Book temp = books.get(0);
        books.set(0, books.get(3));
        books.set(3, temp);

        System.out.println("\nAfter rearranging the elements:");
        for (Book book : books) {
            System.out.println("Book name: " + book.getName() + ", pages: " + book.getPages());
        }

        System.out.println("\nOnly \"Clean code\" name:");
        for (Book book : books) {
            if (book.getName() == "Clean code") {
                System.out.println("Book name: " + book.getName() + ", pages: " + book.getPages());
            }
        }
    }

}
