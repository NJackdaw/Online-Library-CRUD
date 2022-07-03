package PasswordPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PasswordConnection {
    public Connection connectionPW(){

        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/password_library", "root", "admin");

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return  con;
    }


}
