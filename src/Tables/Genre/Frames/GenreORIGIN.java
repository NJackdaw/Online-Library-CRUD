package Tables.Genre.Frames;

import Tables.Genre.Genre;
import Tables.Genre.GenreDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GenreORIGIN extends JFrame implements ActionListener {


    private JTextArea info = new JTextArea(30,17);

    ///////////////// Labels
    private JLabel type = new JLabel("Book's Genre ");

    /////////////// TextFields
    private JTextField insertType = new JTextField(10);
    private JTextField deleteField = new JTextField(10);

    //////////////// Buttons

    private JButton insert = new JButton("INSERT");

    private JButton refresh = new JButton("REFRESH");

    private JButton delete = new JButton("Delete");
    private JButton update = new JButton("UPDATE");







    public GenreORIGIN()throws SQLException{
        setLayout(new FlowLayout());
        GenreDAO obj = new GenreDAO();
        obj.fillGenre();
        info.setText(obj.printer());

        add(info);



        add(type);
        /////////////// TextFields (for user)
        add(insertType);


        //////////////// Buttons
        add(insert);
        insert.addActionListener(this);

        add(refresh);
        refresh.addActionListener(this);

        add(delete);
        delete.addActionListener(this);
        deleteField.setBackground(Color.red);
        add(deleteField);

        add(update);
        update.addActionListener(this);


        setSize(200,800);
        setVisible(true);
    }








    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == insert){
            String newType = insertType.getText();
            Genre genre = new Genre(newType);
            GenreDAO dao = new GenreDAO();
            try {
                dao.insert(genre);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "SUCCESSFULLY ADDed ");

        }

        if (e.getSource() == refresh){
            setVisible(false);
            try {
                GenreORIGIN frameRefresh = new GenreORIGIN();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == delete) {
            GenreDAO obj = new GenreDAO();
            int x = Integer.parseInt(deleteField.getText());
            try {
                obj.delete(x);
                JOptionPane.showMessageDialog(this, "SUCCESSFULLY Deleted ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == update){

            String newType = insertType.getText();

            int id = Integer.parseInt(JOptionPane.showInputDialog("insert ID you want to change "));

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
