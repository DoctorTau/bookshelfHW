package com.bookshelf.Models;

import java.util.ArrayList;

public class Book {
    String title;
    String description;
    String author;
    int year;

    public Book(String title, String description, String author, int year) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book " + "\"" + title + "\"" + " by " + author;
    }

    public static ArrayList<Book> getRandomBooks(int count) {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Book book = new Book("How to find tressure with " + RandomGenerator.getRandomName(),
                    "Description " + RandomGenerator.getRandomDescription(),
                    "Author " + RandomGenerator.getRandomName(), RandomGenerator.getRandomYear());
            if (books.contains(book)) {
                i--;
                continue;
            }
            books.add(book);
        }
        return books;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        return true;
    }
}
