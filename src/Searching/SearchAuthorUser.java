package Searching;

import BookAdvanced.BookAdvanced;
import BookAdvanced.BookAdvancedDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchAuthorUser extends JFrame implements ActionListener {

    private JPanel contents = new JPanel();
    private JTable table1 = new JTable();
    private JScrollPane sp = new JScrollPane();

    private JLabel title = new JLabel("Search Author...") ;
    private JTextField field = new JTextField(10);
    private JButton searchButton = new JButton("Search");


     private String[] columnsHeader = new String[]{"TITLE", "DATA",
            "GENRE", "A.NAME ", "A.SURNAME ", "PUBLISHER ", "PUBLISHER's ADDRESS "};
     private String[][] array = null;









    public SearchAuthorUser()throws SQLException {
        setLayout(new FlowLayout());

       contents.add(title);
       contents.add(field);
       contents.add(searchButton);
       contents.add(table1);

       searchButton.addActionListener(this);

        setContentPane(contents);
        setSize(600,600);
        setVisible(true);

    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton){
            contents.remove(sp);
            contents.remove(table1);

            BookAdvancedDAO dao = new BookAdvancedDAO();
            try {
                dao.fillBookAdvanced();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            array = new String[30][columnsHeader.length ];

            dao.searchRequestByName(field.getText(),columnsHeader,array);

            table1 = new JTable(array,columnsHeader) ;
            table1.setEnabled(false);
            sp = new JScrollPane(table1);

            contents.add(sp);
            contents.validate();
        }




    }
}
