package Tables.Author.Frames;

import Tables.Author.Author;
import Tables.Author.AuthorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddAuthor extends JFrame implements ActionListener {

    // Labels
    private JLabel authorName = new JLabel("Author's name ");
    private JLabel authorSurname = new JLabel("Author's surname ");
    private JLabel authorBirthday = new JLabel("Author's Birthday ");
    private JLabel authorBio = new JLabel("Few word's about ");

    /////////////     Fields to input
    private JTextField name = new JTextField(10);
    private JTextField surname = new JTextField(10);
    private JTextField birthday = new JTextField(10);
    private JTextField bio = new JTextField(10);

    /////////////             Buttons
    private JButton add = new JButton("ADD AUTHOR");



    ///// Constructor
    public AddAuthor(){
        setLayout(new FlowLayout());

        //**/ ADD Labels And Fields
        add(authorName);
        add(name);
        add(authorSurname);
        add(surname);
        add(authorBirthday);
        add(birthday);
        add(authorBio);
        add(bio);

        //**/    ADD Button's

        add(add);
        add.addActionListener(this);



        //**/ Frame Settings
        setVisible(true);
        setSize(300,400);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String newName = name.getText();
            String newSurname = surname.getText();
            String newBirthday = birthday.getText();
            String newBio = bio.getText();

            Author author = new Author(newName, newSurname, newBirthday, newBio);
            AuthorDAO dao = new AuthorDAO();

            try {
                dao.insert(author);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "SUCCESSFULLY DONE ");



        }
    }
}
