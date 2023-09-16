public record Book(String name, String author, String isbn, int year) {
    public String toString() {
        return String.format("%s by %s (%d) [%s]", this.name, this.author, this.year, this.isbn);
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        if (!(compared instanceof Book comparedBook)) {
            return false;
        }

        return this.name.equals(comparedBook.name) &&
                this.author.equals(comparedBook.author) &&
                this.isbn.equals(comparedBook.isbn) &&
                this.year == comparedBook.year;
    }
}