package com.kodilla.exception.Project_6_6;
import java.util.*;

public class BookLibrary {
    LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) {
            return bookList;
        }
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20)
            return bookList;
        bookList = resultList;
        return bookList;
    }
    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        return libraryDatabase.listBooksInHandsOf(libraryUser);
    }
}
