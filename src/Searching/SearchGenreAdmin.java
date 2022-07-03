package Searching;
import Tables.Author.AuthorDAO;
import Tables.Genre.Genre;
import Tables.Genre.GenreDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchGenreAdmin extends JFrame implements ActionListener {


    private Checkbox ifId = new Checkbox("Search By ID (!ONLY!)");
    private boolean selected ;

    private JTable table1 = new JTable();
    private JScrollPane sp = new JScrollPane();

    private JPanel contents = new JPanel();
    private JLabel title = new JLabel("Search Genre...");
    private JTextField field = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private String[] columnsHeader = new String[]{"Genre_ID", "Type"};
    private String[][] array;





    /////////////////////////////////////////  Constructor /////////////////////////////

    public SearchGenreAdmin(){
        setLayout(new FlowLayout());

        contents.add(title);
        contents.add(field);
        contents.add(searchButton);
        contents.add(ifId);
        ifId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selected = true;
                } else {
                    selected = false;
                }
            }
        });
        searchButton.addActionListener(this);

        setContentPane(contents);
        setSize(600, 550);
        setVisible(true);


    }











    @Override
    public void actionPerformed(ActionEvent e) {
        if(selected){
            contents.remove(sp);
            contents.remove(table1);

            GenreDAO dao = new GenreDAO();
            array = new String[30][columnsHeader.length ];
            dao.searchByID(field.getText(),array,columnsHeader);

            table1 = new JTable(array, columnsHeader);
            contents.add(new JScrollPane(table1));
            table1.setEnabled(false);
            sp = new JScrollPane(table1);

            contents.add(sp);
            contents.validate();
        }else {
            contents.remove(sp);
            contents.remove(table1);

            GenreDAO dao = new GenreDAO();
            array = new String[30][columnsHeader.length ];
            dao.searchByType(field.getText(),array,columnsHeader);

            table1 = new JTable(array, columnsHeader);
            contents.add(new JScrollPane(table1));
            table1.setEnabled(false);
            sp = new JScrollPane(table1);

            contents.add(sp);
            contents.validate();
        }

    }

}
