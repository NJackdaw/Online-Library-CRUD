package Tables.Books.Frames;
import Searching.SearchBookAdmin;
import Tables.Books.Book;
import Tables.Books.BookDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BookFrame extends JFrame implements ActionListener {

    /// MenuBar(Items)
    private JMenuBar jmb = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenuItem addBook = new JMenuItem("Add Book");
    private JMenuItem refresh = new JMenuItem("Refresh Page");
    private JMenuItem delete = new JMenuItem("Delete Book");
    private JMenuItem update = new JMenuItem("Update Information");

    private JMenuItem search = new JMenuItem("Search");



    // {{{{{{{{{{{{{{{{{{}}}}}}}}}}____Constructor FRAME___{{{{{{{{{{{{{{{{}}}}}}}}}}}}}}}}//

    public BookFrame () throws SQLException {
        BookDAO dao = new BookDAO();
        dao.fillBooks();


        //           Preparing Array's for JTable

        Book[] newList = dao.getBooks().toArray(new Book[dao.getBooks().size()]);

        String[] columnsHeader = new String[] {"Book ID","Title","Page's","Year","Author(ID)","Genre(ID)","Publisher(ID)"};
        String[][] array = new String[newList.length][columnsHeader.length ];

        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while ( y < columnsHeader.length){
                array[i][y] = String.valueOf(dao.getBooks().get(i).getBookID()); y++;
                array[i][y] = String.valueOf(dao.getBooks().get(i).getTitle()); y++;
                array[i][y] = String.valueOf(dao.getBooks().get(i).getPages()); y++;
                array[i][y] = String.valueOf(dao.getBooks().get(i).getYear()); y++;
                array[i][y] = String.valueOf(dao.getBooks().get(i).getAuthorID()); y++;
                array[i][y] = String.valueOf(dao.getBooks().get(i).getGenreID()); y++;
                array[i][y] = String.valueOf(dao.getBooks().get(i).getPublisherID()); y++;
            }
        }
        //      NEXT  add JTable
        JTable table1 = new JTable( array, columnsHeader);
        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table1));
        table1.setEnabled(false);

        //**/ Menu Bar Settings
        setJMenuBar(jmb);
        jmb.add(file);
        file.addSeparator();
        file.add(addBook);
        file.add(delete);
        file.add(update);
        file.add(refresh);
        file.add(search);
        search.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        addBook.addActionListener(this);
        refresh.addActionListener(this);



        //  Frame Settings
        setContentPane(contents);
        setVisible(true);
        setSize(900,400);
        setTitle("About All Authors (ADMIN) ");


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addBook){
            AddBook frame = new AddBook();
        }
        if (e.getSource() == refresh){
            setVisible(false);
            try {
                BookFrame frame = new BookFrame();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == delete) {
           BookDAO obj = new BookDAO();
            int id = Integer.parseInt(JOptionPane.showInputDialog("insert ID you Want to Delete "));
            try {
                obj.delete(id);
                JOptionPane.showMessageDialog(this, "SUCCESSFULLY DONE ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == update){
            UpdateBook frame = new UpdateBook();

        }
        if (e.getSource() == search){
            SearchBookAdmin frame = new SearchBookAdmin();
        }



    }
}
