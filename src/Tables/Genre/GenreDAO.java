package Tables.Genre;
import Tables.Author.ConnectorDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GenreDAO {

    private ArrayList <Genre> genres = new ArrayList<>();

    public void fillGenre () throws SQLException{
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();
        ResultSet resultSet = stm.executeQuery("select * from genre");
        while(resultSet.next()){
            Genre genre = new Genre();
            genre.setGenreId(resultSet.getInt(1));
            genre.setType(resultSet.getString(2));
            genres.add(genre);
        }
        connect.connectDB().close();
        stm.close();
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public String printer(){
        String str = " ";
        for (Genre genre: genres){
            str += genre.getType() + "," + "\n";
        }
        return str;
    }

    public void insert(Genre genre) throws SQLException{
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();
        String newType = genre.getType();
        String query = "insert into genre values (null,'" + newType  +"')";
        stm.executeUpdate(query);
        connect.connectDB().close();
        stm.close();
    }
    public void delete (int id) throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();

        String query = "delete from genre where genre_id = " + id;
        stm.executeUpdate(query);

        connect.connectDB().close();
        stm.close();
    }
    public void update(Genre genre) throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();


        String newType = genre.getType();
        int id = genre.getGenreId();

        String query = "update genre set type = " + "'" + newType + "'"  + " where genre_id = "  + id + ";" ;
        stm.executeUpdate(query);

        connect.connectDB().close();
        stm.close();
    }

    public void searchByID(String str,String[][] array,String [] header){
        try {
            fillGenre();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        ArrayList<Genre> searchedQuestion = new ArrayList<>();

        for (int i = 0; i < getGenres().size(); i++) {
            if (String.valueOf(getGenres().get(i).getGenreId()).contains(str)) {
                searchedQuestion.add(getGenres().get(i));
            }
        }

        Genre[] newList = searchedQuestion.toArray(new Genre[searchedQuestion.size()]);




        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while (y < header.length) {
                array[i][y] = String.valueOf(searchedQuestion.get(i).getGenreId());
                y++;
                array[i][y] = searchedQuestion.get(i).getType();
                y++;

            }
        }
    }
    public void searchByType(String str,String[][] array,String [] header){
        try {
            fillGenre();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        ArrayList<Genre> searchedQuestion = new ArrayList<>();

        for (int i = 0; i < getGenres().size(); i++) {
            if (String.valueOf(getGenres().get(i).getType()).contains(str)) {
                searchedQuestion.add(getGenres().get(i));
            }
        }

        Genre[] newList = searchedQuestion.toArray(new Genre[searchedQuestion.size()]);




        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while (y < header.length) {
                array[i][y] = String.valueOf(searchedQuestion.get(i).getGenreId());
                y++;
                array[i][y] = searchedQuestion.get(i).getType();
                y++;

            }
        }
    }
}
