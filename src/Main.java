
import PasswordPack.OnlineLibrary;
import Tables.Author.Author;
import Tables.Author.AuthorDAO;
import Tables.Books.Book;
import Tables.Books.BookDAO;
import Tables.Genre.Genre;
import Tables.Genre.GenreDAO;
import Tables.Publisher.Publisher;
import Tables.Publisher.PublisherDAO;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("AUTHORS...");
        AuthorDAO daoAuthor = new AuthorDAO();
        daoAuthor.fillAuthor();
        for (Author author:daoAuthor.getAuthors()) {
            System.out.println(author);
        }


        System.out.println();
        System.out.println("GENRES...");
        GenreDAO daoGenre = new GenreDAO();
        daoGenre.fillGenre();
        for (Genre genre : daoGenre.getGenres()){
            System.out.println(genre);
        }

        System.out.println();
        System.out.println("PUBLISHERS...");
        PublisherDAO daoPublisher = new PublisherDAO();
        daoPublisher.fillPublishers();
        for (Publisher publisher:daoPublisher.getPublishers()){
            System.out.println(publisher);
        }

        System.out.println();
        System.out.println("Book's...");
        BookDAO daoBook = new BookDAO();
        daoBook.fillBooks();
        for (Book book : daoBook.getBooks()){
            System.out.println(book.getTitle() + book.getGenreID() + book.getPages());
        }


        OnlineLibrary myFrame = new OnlineLibrary();

        System.out.println(Math.log(10));


    }
}