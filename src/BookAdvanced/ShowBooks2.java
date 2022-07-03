package BookAdvanced;

import Searching.SearchAuthorUser;
import Searching.SearchTitleUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShowBooks2 extends JFrame implements ActionListener {

    private JTable table1 ;

    private Box contents = new Box(BoxLayout.Y_AXIS);
    private JMenuBar jmb = new JMenuBar();
    private JMenu options = new JMenu("Options");
    private JMenu search = new JMenu("Search");

    private JMenuItem searchByTitle = new JMenuItem("Search By Title");
    private JMenuItem searchByAuthor = new JMenuItem("Search By Author");



    public ShowBooks2() throws SQLException {
        BookAdvancedDAO dao = new BookAdvancedDAO();
        dao.fillBookAdvanced();
        BookAdvanced[] newList = dao.getBookAdvanced().toArray(new BookAdvanced[dao.getBookAdvanced().size()]);

        //           Preparing Array's for JTable
        String[] columnsHeader = new String[]{"TITLE", "DATA",
                "GENRE", "A.NAME ", "A.SURNAME ", "PUBLISHER ", "PUBLISHER's ADDRESS "};
        String[][] array = new String[newList.length][columnsHeader.length];
        for (int i = 0; i < newList.length; i++) {
            for (int j = 1; j < columnsHeader.length; j++) {
                array[i][0] = dao.getBookAdvanced().get(i).getBook().getTitle();
                array[i][j++] = dao.getBookAdvanced().get(i).getBook().getYear();
                array[i][j++] = dao.getBookAdvanced().get(i).getGenre().getType();
                array[i][j++] = dao.getBookAdvanced().get(i).getAuthor().getName();
                array[i][j++] = dao.getBookAdvanced().get(i).getAuthor().getSurname();
                array[i][j++] = dao.getBookAdvanced().get(i).getPublisher().getName();
                array[i][j++] = dao.getBookAdvanced().get(i).getPublisher().getAddress();
            }
        }

        //      NEXT  add JTable
        JTable table1 = new JTable(array, columnsHeader);
        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table1));
        table1.setEnabled(false);
        //**/ Menu Bar Settings
        setJMenuBar(jmb);
        jmb.add(options);
        options.add(search);
        search.add(searchByTitle);
        search.add(searchByAuthor);

        searchByAuthor.addActionListener(this);
        searchByTitle.addActionListener(this);



        ////////// Frame Settings
        setContentPane(contents);
        setVisible(true);
        setSize(900, 400);


    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == searchByAuthor) {
            try {
                SearchAuthorUser frame = new SearchAuthorUser() ;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        if (e.getSource() == searchByTitle){
            try {
                SearchTitleUser frame = new SearchTitleUser();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
