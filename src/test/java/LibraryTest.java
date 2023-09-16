import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        library.addBook(book);

        assertTrue(library.getBooks().contains(book));
    }
    @Test
    public void testGetAllBooks() {
        Library library = new Library();
        Book book1 = new Book("Book 1", "Author 1", "1111111111", 2000);
        Book book2 = new Book("Book 2", "Author 2", "2222222222", 2010);
        library.addBook(book1);
        library.addBook(book2);

        ArrayList<Book> allBooks = library.getBooks();

        assertTrue(allBooks.contains(book1));
        assertTrue(allBooks.contains(book2));
        assertEquals(2, allBooks.size());
    }

    @Test
    public void testFindBookByNameFound() {
        Library library = new Library();
        Book book1 = new Book("Book 1", "Author 1", "1111111111", 2000);
        Book book2 = new Book("Book 2", "Author 2", "2222222222", 2010);
        library.addBook(book1);
        library.addBook(book2);

        assertEquals(book1, library.findBookByName("Book 1"));
        assertEquals(book2, library.findBookByName("Book 2"));
    }
    @Test
    public void testFindBookByNameNotFound() {
        Library library = new Library();
        Book book1 = new Book("Book 1", "Author 1", "1111111111", 2000);
        Book book2 = new Book("Book 2", "Author 2", "2222222222", 2010);
        library.addBook(book1);
        library.addBook(book2);

        assertNull(library.findBookByName("Non-existent Book"));
    }

    @Test
    public void testRemoveBookByISBNSuccess() {
        Library library = new Library();
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        library.addBook(book);

        assertTrue(library.removeBookByISBN("1234567890"));
    }
    @Test
    public void testRemoveBookByISBNNotFound() {
        Library library = new Library();
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        library.addBook(book);

        assertFalse(library.removeBookByISBN("Non-existent ISBN"));
    }
}