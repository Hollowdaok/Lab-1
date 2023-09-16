import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book newBook) {
        this.books.add(newBook);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book findBookByName(String name) {
        for (Book book : this.books) {
            if (book.name().contentEquals(name)) {
                return book;
            }
        }

        return null;
    }

    public boolean removeBookByISBN(String isbn) {
        for (Book book : this.books) {
            if (book.isbn().contentEquals(isbn)) {
                this.books.remove(book);
                return true;
            }
        }

        return false;
    }
}