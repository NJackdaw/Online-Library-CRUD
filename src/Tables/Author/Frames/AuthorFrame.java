package Tables.Author.Frames;

import Searching.SearchAuthorAdmin;
import Tables.Author.Author;
import Tables.Author.AuthorDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AuthorFrame extends JFrame implements  ActionListener  {


    /// MenuBar(Items)
    private JMenuBar jmb = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenuItem addAuthor = new JMenuItem("Add Author");
    private JMenuItem refresh = new JMenuItem("Refresh Page");
    private JMenuItem delete = new JMenuItem("Delete Author");
     private JMenuItem update = new JMenuItem("Update Information");
    private JMenuItem search = new JMenuItem("Search");








    // {{{{{{{{{{{{{{{{{{}}}}}}}}}}____Constructor FRAME___{{{{{{{{{{{{{{{{}}}}}}}}}}}}}}}}//


    public AuthorFrame() throws SQLException {

        AuthorDAO dao = new AuthorDAO();
        dao.fillAuthor();

        //           Preparing Array's for JTable

        Author[] newList = dao.getAuthors().toArray(new Author[dao.getAuthors().size()]);

        String[] columnsHeader = new String[] {"AuthorID","Name","Surname","Birthday","Biography"};
        String[][] array = new String[newList.length][columnsHeader.length ];

        for (int i = 0 ; i < newList.length ; i++ ){
            int y = 0;
            while ( y < columnsHeader.length){
                array[i][y] = String.valueOf(dao.getAuthors().get(i).getAuthorId());y++;
                array[i][y] = dao.getAuthors().get(i).getName();y++;
                array[i][y] = dao.getAuthors().get(i).getSurname();y++;
                array[i][y] = dao.getAuthors().get(i).getBirthday();y++;
                array[i][y] = dao.getAuthors().get(i).getBiography();y++;
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
        file.add(addAuthor);
        file.add(delete);
        file.add(update);
        file.add(refresh);
        file.add(search);

        update.addActionListener(this);
        delete.addActionListener(this);
        addAuthor.addActionListener(this);
        refresh.addActionListener(this);
        search.addActionListener(this);




        //  Frame Settings
        setContentPane(contents);
        setVisible(true);
        setSize(900,400);
        setTitle("About All Authors (ADMIN) ");

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addAuthor){
            System.out.println("Add Author...");
            AddAuthor frame = new AddAuthor();
        }

        if(e.getSource() == refresh){
            setVisible(false);
            try {
                AuthorFrame frame = new AuthorFrame();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == delete) {
            AuthorDAO obj = new AuthorDAO();
            int id = Integer.parseInt(JOptionPane.showInputDialog("insert ID you Want to Delete "));
            try {
                obj.delete(id);
                JOptionPane.showMessageDialog(this, "SUCCESSFULLY DONE ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == update){
            try {
                UpdateAuthor frame = new UpdateAuthor();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        if (e.getSource() == search){
            try {
                SearchAuthorAdmin frame = new SearchAuthorAdmin();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }



    }

}
