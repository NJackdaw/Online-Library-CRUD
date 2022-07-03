package Tables.Genre.Frames;

import Tables.Genre.Genre;
import Tables.Genre.GenreDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddGenre extends JFrame implements ActionListener {

    //  Label's
    private JLabel upType = new JLabel("Book's Genre ");
    //  TextFields
    private JTextField insertType = new JTextField(10);
    //  Buttons
    private JButton add = new JButton("ADD GENRE");

    ///// Constructor

    public AddGenre()throws SQLException{
        setLayout(new FlowLayout());

        //**/ ADD Labels And Fields
        add(upType);
        add(insertType);

        //**/    ADD Button's
        add(add);
        add.addActionListener(this);

        //**/ Frame Settings
        setVisible(true);
        setSize(300,400);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String newType = insertType.getText();
            Genre genre = new Genre(newType);
            GenreDAO dao = new GenreDAO();
            try {
                dao.insert(genre);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "SUCCESSFULLY DONE ");
        }
    }
}
