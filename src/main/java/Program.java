import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-3-16-148410-0", 1925));
        library.addBook(new Book("The Grapes of Wrath", "John Steinbeck", "978-3-16-148410-1", 1939));
        library.addBook(new Book("Nineteen Eighty-Four", "George Orwell", "978-3-16-148410-2", 1949));
        library.addBook(new Book("Ulysses", "James Joyce", "978-3-16-148410-3", 1922));
        library.addBook(new Book("Lolita", "Vladimir Nabokov", "978-3-16-148410-4", 1955));
        library.addBook(new Book("Catch-22", "Joseph Heller", "978-3-16-148410-5", 1961));
        library.addBook(new Book("The Catcher in the Rye", "J. D. Salinger", "978-3-16-148410-6", 1951));
        library.addBook(new Book("Beloved", "Toni Morrison", "978-3-16-148410-7", 1987));
        library.addBook(new Book("The Sound and the Fury", "William Faulkner", "978-3-16-148410-8", 1929));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "978-3-16-148410-9", 1960));

        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Main menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Find a book by name");
            System.out.println("3. Remove a book by ISBN");
            System.out.println("4. List all books");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.next();
            scanner.nextLine();

            System.out.println();

            switch (choice) {
                case "0" -> running = false;
                case "1" -> {
                    System.out.print("Enter the name of the book: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter the ISBN of the book: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter the year of the book: ");
                    int year = scanner.nextInt();

                    library.addBook(new Book(name, author, isbn, year));

                    System.out.println();
                }
                case "2" -> {
                    System.out.print("Enter the name of the book: ");
                    String name = scanner.nextLine();

                    Book book = library.findBookByName(name);

                    if (book == null) {
                        System.out.println("Book not found.");
                    } else {
                        System.out.println(book);
                    }

                    System.out.println();
                }
                case "3" -> {
                    System.out.print("Enter the ISBN of the book: ");
                    String isbn = scanner.nextLine();

                    if (library.removeBookByISBN(isbn)) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }

                    System.out.println();
                }
                case "4" -> {
                    System.out.println("Books in the library:");
                    for (Book book : library.getBooks()) {
                        System.out.println(book);
                    }

                    System.out.println();
                }
                default -> {
                    System.out.println("Invalid choice.");
                    System.out.println();
                }
            }
        } while (running);
    }
}