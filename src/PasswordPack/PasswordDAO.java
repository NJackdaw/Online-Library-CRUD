package PasswordPack;

import java.sql.* ;
import java.sql.Statement;
import java.util.ArrayList;

public class PasswordDAO {

    private ArrayList<Password> passwords = new ArrayList<>();

    public void getPassWord () throws SQLException {
        PasswordConnection connect = new PasswordConnection();
        Statement stm = connect.connectionPW().createStatement();
        ResultSet resultSet = stm.executeQuery("select * from passwords");

        while (resultSet.next()){
            Password password = new Password();
            password.setPasswordID(resultSet.getInt(1));
            password.setPassword(resultSet.getString(2));
            passwords.add(password);
        }
        connect.connectionPW().close();
        stm.close();

    }

    public void updatePassword(Password password)throws SQLException{
        PasswordConnection connect = new PasswordConnection();
        Statement stm = connect.connectionPW().createStatement();

        String newPassword = password.getPassword();
        String query = "update passwords set password = " + "'" + newPassword + "'";
        stm.executeUpdate(query);


    }
    public ArrayList<Password> getPasswords() {
        return passwords;
    }
}
