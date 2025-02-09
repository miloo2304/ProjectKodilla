package com.kodilla.testing.Project_6_6;

import java.util.*;

public class LibraryDatabaseImpl implements LibraryDatabase {

    @Override
    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> books = new ArrayList<>();
        // Simulate a small database of books based on the title fragment
        if (titleFragment.contains("Java")) {
            books.add(new Book("Effective Java", "Joshua Bloch", 2008));
            books.add(new Book("Java Concurrency in Practice", "Brian Goetz", 2006));
        }
        return books;
    }

    @Override
    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> books = new ArrayList<>();
        // Simulate books in hands of a user
        books.add(new Book("Design Patterns", "Erich Gamma", 1994));
        books.add(new Book("The Pragmatic Programmer", "Andrew Hunt", 1999));
        return books;
    }
}