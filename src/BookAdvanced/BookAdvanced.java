package BookAdvanced;

import Tables.Author.Author;
import Tables.Books.Book;
import Tables.Genre.Genre;
import Tables.Publisher.Publisher;

public class BookAdvanced {

    private Author author = new Author();
    private Genre genre = new Genre();
    private Publisher publisher = new Publisher();
    private Book book = new Book();


    public BookAdvanced() {
    }

    public BookAdvanced(Author author, Genre genre, Publisher publisher) {
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
    }

    public BookAdvanced (String title, String year, String type , String name , String surname, String publisherName, String address){
        this.book.setTitle(title);
        this.book.setYear(year);
        this.genre.setType(type);
        this.author.setName(name);
        this.author.setSurname(surname);
        this.publisher.setName(publisherName);
        this.publisher.setAddress(address);

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


}
