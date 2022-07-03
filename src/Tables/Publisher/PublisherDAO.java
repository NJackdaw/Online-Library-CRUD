package Tables.Publisher;

import Tables.Author.ConnectorDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PublisherDAO {

    private ArrayList<Publisher> publishers = new ArrayList<>();

    public void fillPublishers() throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();
        ResultSet resultSet = stm.executeQuery("select * from publisher");
        while(resultSet.next()){
            Publisher publisher = new Publisher();
            publisher.setPublisherId(resultSet.getInt(1));
            publisher.setName(resultSet.getString(2));
            publisher.setAddress(resultSet.getString(3));
            publisher.setPhone(resultSet.getString(4));
            publisher.setManager(resultSet.getString(5));
            publishers.add(publisher);
        }
    }
    public ArrayList<Publisher> getPublishers(){
        return publishers;
    }
    public String printer(){
        String str = " ";
        for (Publisher publisher : publishers){
            str += publisher.getName() + "," + publisher.getAddress() +","+ publisher.getPhone()+ "\n";
        }
        return str;
    }

    public void insert(Publisher publisher) throws SQLException{
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();

        String newName = publisher.getName();
        String newAddress = publisher.getAddress();
        String newPhone = publisher.getPhone();
        String newBoss = publisher.getManager();
        String query = "insert into publisher values (null,'" + newName +"','" + newAddress + "','"  + newPhone +"','" +newBoss +"')";
        stm.executeUpdate(query);

        connect.connectDB().close();
        stm.close();

    }

    public void update (Publisher publisher) throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();

        String newName = publisher.getName();
        String newAddress = publisher.getAddress();
        String newPhone = publisher.getPhone();
        String newBoss = publisher.getManager();
        int id = publisher.getPublisherId();

        String query = "update publisher set  name = " + "'" + newName + "', address = "+"'" + newAddress + "', phone = "+"'" + newPhone + "'," +
                "boss = " + "'" + newBoss + "' where publisher_id = " + "'" + id + "'";
        System.out.println(query);

        stm.executeUpdate(query);
        connect.connectDB().close();
        stm.close();
    }

    public void delete (int id) throws SQLException {
        ConnectorDB connect = new ConnectorDB();
        Statement stm = connect.connectDB().createStatement();

        String query = "delete from publisher where publisher_id = " + id;
        stm.executeUpdate(query);

        connect.connectDB().close();
        stm.close();

    }

    public void searchByName(String str,String[][] array,String [] header) {
        try {
            fillPublishers();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        ArrayList<Publisher> searchedQuestion = new ArrayList<>();

        for (int i = 0; i < getPublishers().size(); i++) {
            if (getPublishers().get(i).getName().contains(str) ){
                searchedQuestion.add(getPublishers().get(i));
            }
        }

        Publisher[] newList = searchedQuestion.toArray(new Publisher[searchedQuestion.size()]);



        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while (y < header.length) {
                array[i][y] = String.valueOf(searchedQuestion.get(i).getPublisherId());
                y++;
                array[i][y] = searchedQuestion.get(i).getName();
                y++;
                array[i][y] = searchedQuestion.get(i).getAddress();
                y++;
                array[i][y] = searchedQuestion.get(i).getPhone();
                y++;
                array[i][y] = searchedQuestion.get(i).getManager();
                y++;
            }
        }
    }


    public void searchByID(String str,String[][] array,String [] header) {

        try {
            fillPublishers();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        ArrayList<Publisher> searchedQuestion = new ArrayList<>();

        for (int i = 0; i < getPublishers().size(); i++) {
            if (String.valueOf(getPublishers().get(i).getPublisherId()).contains(str)) {
                searchedQuestion.add(getPublishers().get(i));
            }
        }

        Publisher[] newList = searchedQuestion.toArray(new Publisher[searchedQuestion.size()]);




        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while (y < header.length) {
                array[i][y] = String.valueOf(searchedQuestion.get(i).getPublisherId());
                y++;
                array[i][y] = searchedQuestion.get(i).getName();
                y++;
                array[i][y] = searchedQuestion.get(i).getAddress();
                y++;
                array[i][y] = searchedQuestion.get(i).getPhone();
                y++;
                array[i][y] = searchedQuestion.get(i).getManager();
                y++;
            }
        }
    }


}
