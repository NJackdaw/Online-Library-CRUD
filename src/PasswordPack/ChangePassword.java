package PasswordPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ChangePassword extends JFrame implements ActionListener {

    private JLabel printNew = new JLabel("Insert New Password");
    private JTextField field = new JTextField(10);

    private JButton change = new JButton("Update Password");

    public ChangePassword(){
        setLayout(new FlowLayout());

        add(printNew);
        add(field);
        add(change);
        change.addActionListener(this);



        setSize(400,100);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change){
            String newPassword = field.getText();

            Password password = new Password(newPassword);
            PasswordDAO dao = new PasswordDAO();

            try {
                dao.updatePassword(password);
                JOptionPane.showMessageDialog(this,"DONE");
                setVisible(false);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
