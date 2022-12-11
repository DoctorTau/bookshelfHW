package com.bookshelf;

import java.util.ArrayList;
import java.util.Scanner;

import com.bookshelf.Models.Book;
import com.bookshelf.Models.Library;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library(Book.getRandomBooks(20)), reader = new Library();
        String command = "";
        while (command != "/quit") {
            System.out.println("Enter command:");
            command = scanner.next();
            if ("/quit".equals(command)) {
                System.out.println("Goodbye!");
                break;
            }
            if ("/get".equals(command)) {
                changeBookLocation(library, reader);
                continue;
            }
            if ("/put".equals(command)) {
                changeBookLocation(reader, library);
                continue;
            }
            if ("/ask".equals(command)) {
                askBook(library);
                continue;
            }
            if ("/list".equals(command)) {
                System.out.println("Reader has " + reader);
                continue;
            }
            if ("/all".equals(command)) {
                System.out.println("Library has " + library);
                System.out.println("Reader has " + reader);
                continue;
            }
            System.out.println("Unknown command");
        }
    }

    private static void askBook(Library library) {
        String title = scanner.next();
        if (library.checkBookPresence(title)) {
            System.out.println("The book is in the library");
        } else {
            System.out.println("The book is not in the library");
        }
    }

    private static void changeBookLocation(Library library, Library reader) {
        String title = scanner.nextLine();
        title = title.trim();
        ArrayList<Book> books = library.getBooksWithTitle(title);
        if (books.size() == 0) {
            System.out.println("No books found");
            return;
        }
        if (books.size() == 1) {
            System.out.println("You changed the book: " + books.get(0));
            reader.addBook(books.get(0));
            library.removeBook(books.get(0));
            return;
        }
        System.out.println("There are several books with this title. Which one do you want to change?");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + 1 + ". " + books.get(i));
        }
        int index = scanner.nextInt();
        System.out.println("You got the book: " + books.get(index - 1));
        reader.addBook(books.get(index - 1));
        library.removeBook(books.get(index - 1));
    }
}
