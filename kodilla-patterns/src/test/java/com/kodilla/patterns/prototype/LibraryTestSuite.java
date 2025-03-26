package com.kodilla.patterns.prototype;

import com.kodilla.patterns.prototype.library.Library;
import com.kodilla.patterns.prototype.library.Book;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTestSuite {

    @Test
    void testGetBooks() throws CloneNotSupportedException {
        Library library = new Library("Library 1");
        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("Book " + n, "Author " + n, LocalDate.of(2020 + n, 1, 1))));

        Library shallowClonedLibrary = library.shallowCopy();
        Library deepClonedLibrary = library.deepCopy();
        library.setName("Library city");
        library.getBooks().remove(library.getBooks().iterator().next());

        assertEquals("Library city", library.getName());
        assertEquals("Library 1", shallowClonedLibrary.getName());
        assertEquals("Library 1", deepClonedLibrary.getName());

        assertEquals(4, library.getBooks().size());
        assertEquals(4, shallowClonedLibrary.getBooks().size());
        assertEquals(5, deepClonedLibrary.getBooks().size());
        assertSame(library.getBooks(), shallowClonedLibrary.getBooks());
        assertNotSame(library.getBooks(), deepClonedLibrary.getBooks());
    }
}
