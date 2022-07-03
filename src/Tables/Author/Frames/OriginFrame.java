package Tables.Author.Frames;

import Tables.Author.Author;
import Tables.Author.AuthorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OriginFrame extends JFrame implements ActionListener {

    private JTextArea info = new JTextArea(30, 17);

    /////////////    Labels
    private JLabel authorName = new JLabel("Author's name ");
    private JLabel authorSurname = new JLabel("Author's surname ");
    private JLabel authorBirthday = new JLabel("Author's Birthday ");
    private JLabel authorBio = new JLabel("Few word's about ");

    /////////////     Fields to input
    private JTextField name = new JTextField(10);
    private JTextField surname = new JTextField(10);
    private JTextField birthday = new JTextField(10);
    private JTextField bio = new JTextField(10);
    private JTextField deleteField = new JTextField(10);

    /////////////             Buttons
    private JButton add = new JButton("INSERT");
    private JButton refresh = new JButton("Refresh");
    private JButton delete = new JButton("Delete");
    private JButton update = new JButton("UPDATE");


    public OriginFrame() throws SQLException {
        setLayout(new FlowLayout());




        add(authorName);
        add(name);
        add(authorSurname);
        add(surname);
        add(authorBirthday);
        add(birthday);
        add(authorBio);
        add(bio);


        //////////////     ADD Button's


        add(add);
        add.addActionListener(this);

        add(refresh);
        refresh.addActionListener(this);

        add(delete);
        delete.addActionListener(this);
        deleteField.setBackground(Color.red);
        add(deleteField);

        add(update);
        update.addActionListener(this);


        setSize(400, 400);
        setVisible(true);
        setTitle("Admin ToolBar");
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
            JOptionPane.showMessageDialog(this, "SUCCESSFULLY ADDed ");

        }

        if (e.getSource() == refresh) {
            setVisible(false);
            try {
                OriginFrame frameRefresh = new OriginFrame();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == delete) {
            AuthorDAO obj = new AuthorDAO();
            int x = Integer.parseInt(deleteField.getText());
            try {
                obj.delete(x);
                JOptionPane.showMessageDialog(this, "SUCCESSFULLY Deleted ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == update){

            String newName = name.getText();
            String newSurname = surname.getText();
            String newBirthday = birthday.getText();
            String newBio = bio.getText();
            int id = Integer.parseInt(JOptionPane.showInputDialog("insert ID you want to change "));

            Author author = new Author(id,newName, newSurname, newBirthday, newBio);
            AuthorDAO dao = new AuthorDAO();

            try {
                dao.update(author);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "SUCCESSFULLY UPDATED ");
        }
    }
}
