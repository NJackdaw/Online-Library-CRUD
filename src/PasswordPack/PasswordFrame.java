package PasswordPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PasswordFrame extends JFrame implements ActionListener {
    private String password ;

    private JLabel massage = new JLabel("Insert Admin Password");

    private JPasswordField passField = new JPasswordField(10);

    private JButton login = new JButton("Log In");
    private JButton backUser = new JButton("Back to User Mode");
    public PasswordFrame  () throws SQLException {
     PasswordDAO dao = new PasswordDAO();
     dao.getPassWord();
     password = dao.getPasswords().get(0).getPassword();





        setLayout(new FlowLayout());
        add(massage);
        add(passField);
        add(login);
        login.addActionListener(this);
        add(backUser);
        backUser.addActionListener(this);



        setSize(400,300);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login){
            if (passField.getText().contains(password)){
                setVisible(false);
                OnlineLibraryADMIN frame = new OnlineLibraryADMIN();
            }else {
                JOptionPane.showMessageDialog(this,
                        "Invalid password. Try again.",
                        "Wrong Password",
                        JOptionPane.ERROR_MESSAGE);
                setVisible(false);
                OnlineLibrary frame = new OnlineLibrary();
            }
        }
        if (e.getSource() == backUser){
            setVisible(false);
            OnlineLibrary frame = new OnlineLibrary();
        }
    }
}
