package Tables.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AuthorDAO {

    private ArrayList <Author> authors = new ArrayList<>() ;

    public void fillAuthor() throws SQLException {

        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();
        ResultSet resultSet = stm.executeQuery("select * from author");

    while (resultSet.next()) {
        Author author = new Author();
        author.setAuthorId(resultSet.getInt(1));
        author.setName(resultSet.getString(2));
        author.setSurname(resultSet.getString(3));
        author.setBirthday(resultSet.getString(4));
        author.setBiography(resultSet.getString(5));
        authors.add(author);
    }
        connect.connectDB().close();
        stm.close();
    }

    public String printAuthors (){
        String str = " ";
        for (Author author : authors ){
            str += "(ID_"+author.getAuthorId()+") _" + author.getName() +"  "+ author.getSurname() + ","  +"\n";
        }
        return str;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }



    public void  insert(Author author) throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();

        String newName = author.getName();
        String newSurname = author.getSurname();
        String date = author.getBirthday();
        String bio = author.getBiography();
        String query = "insert into author values (null,'" + newName +"','" + newSurname + "','"  + date +"','" +bio +"')";
        System.out.println(query);
        stm.executeUpdate(query);


        connect.connectDB().close();
        stm.close();
    }

    public void delete (int id) throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();

        String query = "delete from author where author_id = " + id;
        stm.executeUpdate(query);

        connect.connectDB().close();
        stm.close();
    }

    public void update(Author author) throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();


        String newName = author.getName();
        String newSurname = author.getSurname();
        String newBirthday = author.getBirthday();
        String newBio = author.getBiography();
        int id = author.getAuthorId();

        String query = "update author set name = " + "'" + newName + "', surname =" +"'" + newSurname + "', birthday = " +"'" + newBirthday + "'," +
                "biography = " + "'" + newBio + "' where author_id = "  + id + ";" ;


        stm.executeUpdate(query);
        connect.connectDB().close();
        stm.close();
    }

    public void searchByID (String str,String[][] array,String [] header){
        try {
            fillAuthor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Author> searchedQuestion = new ArrayList<>();

        for (int i = 0; i < getAuthors().size(); i++) {
            if (String.valueOf(getAuthors().get(i).getAuthorId()).contains(str)){
                searchedQuestion.add(getAuthors().get(i));
            }
        }

        Author[] newList = searchedQuestion.toArray(new Author[searchedQuestion.size()]);


        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while (y < header.length) {
                array[i][y] = String.valueOf(searchedQuestion.get(i).getAuthorId());
                y++;
                array[i][y] = searchedQuestion.get(i).getName();
                y++;
                array[i][y] = searchedQuestion.get(i).getSurname();
                y++;
                array[i][y] = searchedQuestion.get(i).getBirthday();
                y++;
                array[i][y] = searchedQuestion.get(i).getBiography();
                y++;
            }
        }

    }

    public void searchByName (String str,String[][] array,String [] header){
        try {
            fillAuthor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Author> searchedQuestion = new ArrayList<>();

        for (int i = 0; i < getAuthors().size(); i++) {
            if (getAuthors().get(i).getName().contains(str) || getAuthors().get(i).getSurname().contains(str)){
                searchedQuestion.add(getAuthors().get(i));
            }
        }

        Author[] newList = searchedQuestion.toArray(new Author[searchedQuestion.size()]);


        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while (y < header.length) {
                array[i][y] = String.valueOf(searchedQuestion.get(i).getAuthorId());
                y++;
                array[i][y] = searchedQuestion.get(i).getName();
                y++;
                array[i][y] = searchedQuestion.get(i).getSurname();
                y++;
                array[i][y] = searchedQuestion.get(i).getBirthday();
                y++;
                array[i][y] = searchedQuestion.get(i).getBiography();
                y++;
            }
        }

    }


}
