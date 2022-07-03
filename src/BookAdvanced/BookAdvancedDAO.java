package BookAdvanced;

import Tables.Author.Author;
import Tables.Author.ConnectorDB;
import Tables.Books.Book;
import Tables.Genre.Genre;
import Tables.Publisher.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookAdvancedDAO {

    private ArrayList<BookAdvanced> bookAdvanced = new ArrayList<>();

    public void fillBookAdvanced () throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement() ;
        String query = "Select book.title , book.year, genre.type, author.name, author.surname, publisher.name, publisher.address " +
                "From book,genre,publisher,author where author.author_id = book.author_id and genre.genre_id = book.genre_id and " +
                "publisher.publisher_id = book.publisher_id";
        ResultSet resultSet = stm.executeQuery(query);
        while(resultSet.next()) {
            BookAdvanced book = new BookAdvanced();
            book.setBook(new Book(resultSet.getString(1),resultSet.getString(2)));
            book.setGenre(new Genre(resultSet.getString(3)));
            book.setAuthor(new Author(resultSet.getString(4),resultSet.getString(5)));
            book.setPublisher(new Publisher(resultSet.getString(6),resultSet.getString(7)));

            bookAdvanced.add(book);

        }
        connect.connectDB().close();
        stm.close();
    }

    public String printer (){
        String str = "\n";
        for (BookAdvanced books : bookAdvanced){
           str +=  " \n                                                 [Book Title]_"+ books.getBook().getTitle() +",\n [Book Year]_" + books.getBook().getYear() +
                ",[Book Genre]_" +   books.getGenre().getType() + ",[Author]_"
                   + books.getAuthor().getName() +","+ books.getAuthor().getSurname()
                   + ",[Publisher]_"+ books.getPublisher().getName() + ",[Pub.Address]_" + books.getPublisher().getAddress()   +"\n";
        }
        return str;
    }

    public ArrayList <BookAdvanced> getBookAdvanced (){
        return bookAdvanced;
    }




    public void searchRequestByName(String str,String[] header, String[][] array){
        ArrayList <BookAdvanced> searchedBooks = new ArrayList<>();

        for (int i = 0; i < getBookAdvanced().size(); i++) {
            if (getBookAdvanced().get(i).getAuthor().getName().contains(str) || getBookAdvanced().get(i).getAuthor().getSurname().contains(str))
            {
                searchedBooks.add(getBookAdvanced().get(i));
            }
        }

        BookAdvanced[] newList = searchedBooks.toArray(new BookAdvanced[searchedBooks.size()]);





        for (int i = 0; i < newList.length; i++) {
            for (int j = 1; j < header.length; j++) {
                array[i][0] = searchedBooks.get(i).getBook().getTitle();
                array[i][j++] = searchedBooks.get(i).getBook().getYear();
                array[i][j++] = searchedBooks.get(i).getGenre().getType();
                array[i][j++] = searchedBooks.get(i).getAuthor().getName();
                array[i][j++] = searchedBooks.get(i).getAuthor().getSurname();
                array[i][j++] = searchedBooks.get(i).getPublisher().getName();
                array[i][j++] = searchedBooks.get(i).getPublisher().getAddress();
            }
        }


    }
    public void searchRequestByTitle(String str,String[] header, String[][] array){
        ArrayList <BookAdvanced> searchedBooks = new ArrayList<>();

        for (int i = 0; i < getBookAdvanced().size(); i++) {
            if (getBookAdvanced().get(i).getBook().getTitle().contains(str) )
            {
                searchedBooks.add(getBookAdvanced().get(i));
            }
        }

        BookAdvanced[] newList = searchedBooks.toArray(new BookAdvanced[searchedBooks.size()]);





        for (int i = 0; i < newList.length; i++) {
            for (int j = 1; j < header.length; j++) {
                array[i][0] = searchedBooks.get(i).getBook().getTitle();
                array[i][j++] = searchedBooks.get(i).getBook().getYear();
                array[i][j++] = searchedBooks.get(i).getGenre().getType();
                array[i][j++] = searchedBooks.get(i).getAuthor().getName();
                array[i][j++] = searchedBooks.get(i).getAuthor().getSurname();
                array[i][j++] = searchedBooks.get(i).getPublisher().getName();
                array[i][j++] = searchedBooks.get(i).getPublisher().getAddress();
            }
        }


    }
}
