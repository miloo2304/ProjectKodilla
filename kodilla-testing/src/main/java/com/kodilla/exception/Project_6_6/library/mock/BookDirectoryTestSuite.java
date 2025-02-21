package com.kodilla.exception.Project_6_6.library.mock;

import com.kodilla.exception.Project_6_6.LibraryDatabase;
import com.kodilla.exception.Project_6_6.BookLibrary;
import com.kodilla.exception.Project_6_6.Book;
import com.kodilla.exception.Project_6_6.LibraryUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;
    private BookLibrary bookLibrary;

    @BeforeEach
    void setUp() {
        bookLibrary = new BookLibrary(libraryDatabaseMock);
        System.out.println("\nTesting on");
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        System.out.println("Generated books: " + booksQuantity);
        return resultList;
    }

    @Test
    void testListBooksWithConditionMoreThan20() {
        // Given
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("Any title"))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        System.out.println("Books found for 'ZeroBooks': " + theListOfBooks0.size());
        System.out.println("Books found for 'Any title': " + theListOfBooks15.size());
        System.out.println("Books found for 'FortyBooks': " + theListOfBooks40.size());

        // Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size()); // Expected 0 because we limit the list size to 20
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        // No need to mock libraryDatabaseMock here as it's already done in the setUp()

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        System.out.println("Books found for 'An': " + theListOfBooks10.size());

        // Then
        assertEquals(0, theListOfBooks10.size()); // Fragment should be rejected as it's shorter than 3 characters
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString()); // No interaction with mock
    }

    @Test
    void testListBooksInHandsOfWhenUserHasNoBooks() {
        // Given
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "12345678901");
        List<Book> emptyList = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(emptyList);

        // When
        List<Book> books = bookLibrary.listBooksInHandsOf(libraryUser);
        System.out.println("List size: " + books.size());

        // Then
        assertTrue(books.isEmpty(), "The list should be empty when the user has no books.");
    }

    @Test
    void testListBooksInHandsOfWhenUserHasOneBook() {
        // Given
        LibraryUser libraryUser = new LibraryUser("Jane", "Doe", "98765432101");
        List<Book> oneBook = new ArrayList<>();
        oneBook.add(new Book("Effective Java", "Joshua Bloch", 2008));
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(oneBook);

        // When
        List<Book> books = bookLibrary.listBooksInHandsOf(libraryUser);
        System.out.println("List size: " + books.size());
        // Then
        assertEquals(1, books.size(), "The list should contain 1 book.");
        assertEquals("Effective Java", books.get(0).getTitle(), "The title of the book should match.");
    }

    @Test
    void testListBooksInHandsOfWhenUserHasMultipleBooks() {
        // Given
        LibraryUser libraryUser = new LibraryUser("Alice", "Johnson", "11223344556");
        List<Book> fiveBooks = new ArrayList<>();
        fiveBooks.add(new Book("Clean Code", "Robert C. Martin", 2008));
        fiveBooks.add(new Book("Design Patterns", "Erich Gamma", 1994));
        fiveBooks.add(new Book("The Pragmatic Programmer", "Andrew Hunt", 1999));
        fiveBooks.add(new Book("Head First Java", "Kathy Sierra", 2003));
        fiveBooks.add(new Book("Refactoring", "Martin Fowler", 1999));

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(fiveBooks);

        // When
        List<Book> books = bookLibrary.listBooksInHandsOf(libraryUser);
        System.out.println("List size: " + books.size());

        // Then
        assertEquals(5, books.size(), "The list should contain 5 books.");
        assertEquals("Clean Code", books.get(0).getTitle(), "The first book title should match.");
    }
}