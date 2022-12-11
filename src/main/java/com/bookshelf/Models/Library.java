package com.bookshelf.Models;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();

    public Library() {
    }

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public Boolean checkBookPresence(String bookTitle) {
        for (Book book : books) {
            if (book.title.equals(bookTitle)) {
                return true;
            }
        }
        return false;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public ArrayList<Book> getBooksWithTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.title.equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "Books\n";
        for (Book book : books) {
            result += book.toString() + "\n";
        }
        return result;
    }
}
