package Tables.Books;
import Tables.Author.ConnectorDB;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO {

    private ArrayList <Book> books = new ArrayList<>();

    public void fillBooks() throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();
        ResultSet resultSet = stm.executeQuery("select * from book");
        while(resultSet.next()){
            Book book = new Book();
            book.setBookID(resultSet.getInt(1));
            book.setTitle(resultSet.getString(2));
            book.setPages(resultSet.getString(3));
            book.setYear(resultSet.getString(4));
            book.setAuthor(resultSet.getInt(5));
            book.setGenre(resultSet.getInt(6));
            book.setPublisher(resultSet.getInt(7));
            books.add(book);
        }
        connect.connectDB().close();
        stm.close();

    }

    public ArrayList<Book> getBooks() {
        return books;
    }


    public String printer(){
        String str = " ";
        for (Book book : books){
            str += book.getTitle() + "," + book.getPages() +","+ book.getYear()+ "\n";
        }
        return str;
    }

    public void insert(Book book) throws SQLException{
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();

        String newNTitle = book.getTitle();
        String newPage = book.getPages();
        String newYear = book.getYear();
        int author_id = book.getAuthorID();
        int genre_id = book.getGenreID();
        int publisher_id = book.getPublisherID();
        String query = "insert into book values (null,'" + newNTitle +"','" + newPage + "',"  + newYear +",'"+ author_id + "','" + genre_id + "','" + publisher_id  +"')";
        stm.executeUpdate(query);
        connect.connectDB().close();
        stm.close();

    }

    public void delete (int id) throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();

        String query = "delete from book where book_id = " + id;
        stm.executeUpdate(query);

        connect.connectDB().close();
        stm.close();
    }

    public void update(Book book) throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();


        String newTitle = book.getTitle();
        String newPages = book.getPages();
        String newYear = book.getYear();
        int authorId = book.getAuthorID();
        int genreId = book.getGenreID();
        int publisherId = book.getPublisherID();
        int id = book.getBookID();

        String query = "update book set title = " + "'" + newTitle + "', page =" +"'" + newPages + "', year = " +"'" + newYear + "'," +
                "author_id = " + "'" + authorId + "', genre_id = " +"'"+genreId+"', publisher_id = " +"'"+publisherId+"'"+"where book_id = "  + id + ";" ;

        stm.executeUpdate(query);
        connect.connectDB().close();
        stm.close();
    }

    public void searchByID(String str,String[][] array,String [] header){
        try {
            fillBooks();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        ArrayList<Book> searchedQuestion = new ArrayList<>();

        for (int i = 0; i < getBooks().size(); i++) {
            if (String.valueOf(getBooks().get(i).getBookID()).contains(str)) {
                searchedQuestion.add(getBooks().get(i));
            }
        }

        Book[] newList = searchedQuestion.toArray(new Book[searchedQuestion.size()]);

        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while (y < header.length) {
                array[i][y] = String.valueOf(searchedQuestion.get(i).getBookID());
                y++;
                array[i][y] = searchedQuestion.get(i).getTitle();
                y++;
                array[i][y] = searchedQuestion.get(i).getPages();
                y++;
                array[i][y] = searchedQuestion.get(i).getYear();
                y++;
                array[i][y] = String.valueOf(searchedQuestion.get(i).getAuthorID());
                y++;
                array[i][y] = String.valueOf(searchedQuestion.get(i).getGenreID());
                y++;
                array[i][y] = String.valueOf(searchedQuestion.get(i).getPublisherID());
                y++;
            }
        }
    }


    public void searchByTitle (String str,String[][] array,String [] header){
        try {
            fillBooks();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        ArrayList<Book> searchedQuestion = new ArrayList<>();

        for (int i = 0; i < getBooks().size(); i++) {
            if (getBooks().get(i).getTitle().contains(str)) {
                searchedQuestion.add(getBooks().get(i));
            }
        }

        Book[] newList = searchedQuestion.toArray(new Book[searchedQuestion.size()]);


        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while (y < header.length) {
                array[i][y] = String.valueOf(searchedQuestion.get(i).getBookID());
                y++;
                array[i][y] = searchedQuestion.get(i).getTitle();
                y++;
                array[i][y] = searchedQuestion.get(i).getPages();
                y++;
                array[i][y] = searchedQuestion.get(i).getYear();
                y++;
                array[i][y] = String.valueOf(searchedQuestion.get(i).getAuthorID());
                y++;
                array[i][y] = String.valueOf(searchedQuestion.get(i).getGenreID());
                y++;
                array[i][y] = String.valueOf(searchedQuestion.get(i).getPublisherID());
                y++;
            }
        }
    }

}
