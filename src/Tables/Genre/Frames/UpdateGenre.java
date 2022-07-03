package Tables.Genre.Frames;

import Tables.Genre.Genre;
import Tables.Genre.GenreDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateGenre extends JFrame implements ActionListener {

    //  Label's
    private JLabel upType = new JLabel("New Genre ");
    //  TextFields
    private JTextField insertType = new JTextField(10);
    //  Buttons
    private JButton update = new JButton("UPDATE");

    int id;

    ///// Constructor

    public UpdateGenre () throws SQLException{
        setLayout(new FlowLayout());

        id = Integer.parseInt(JOptionPane.showInputDialog("insert ID you want to change "));

        //**/ ADD Labels And Fields
        add(upType);
        add(insertType);

        //**/    ADD Button's
        add(update);
        update.addActionListener(this);

        //**/ Frame Settings
        setVisible(true);
        setSize(300,80);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update){
            String newType = insertType.getText();

            Genre genre = new Genre(id,newType);
            GenreDAO obj = new GenreDAO();

            try {
                obj.update(genre);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "SUCCESSFULLY UPDATED ");
        }
    }
}
