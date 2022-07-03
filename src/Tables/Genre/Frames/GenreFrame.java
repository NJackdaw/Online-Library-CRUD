package Tables.Genre.Frames;

import Searching.SearchGenreAdmin;
import Tables.Genre.Genre;
import Tables.Genre.GenreDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GenreFrame extends JFrame implements ActionListener {
    /// MenuBar(Items)
    JMenuBar jmb = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenuItem addGenre = new JMenuItem("Add Genre");
    JMenuItem refresh = new JMenuItem("Refresh Page");
    JMenuItem delete = new JMenuItem("Delete Genre");
    JMenuItem update = new JMenuItem("Update Information");
    JMenuItem search = new JMenuItem("Search");


    // {{{{{{{{{{{{{{{{{{}}}}}}}}}}____Constructor FRAME___{{{{{{{{{{{{{{{{}}}}}}}}}}}}}}}}//

    public GenreFrame() throws SQLException {
        GenreDAO dao = new GenreDAO();
        dao.fillGenre();

        //           Preparing Array's for JTable
        Genre[] newList = dao.getGenres().toArray(new Genre[dao.getGenres().size()]);
        String[] columnsHeader = new String[]{"Genre_ID", "Type"};
        String[][] array = new String[newList.length][columnsHeader.length];
        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while (y < columnsHeader.length) {
                array[i][y] = String.valueOf(dao.getGenres().get(i).getGenreId());
                y++;
                array[i][y] = dao.getGenres().get(i).getType();
                y++;
            }
        }

        //      NEXT  add JTable
        JTable table1 = new JTable(array, columnsHeader);
        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table1));
        table1.setEnabled(false);
        //**/ Menu Bar Settings
        setJMenuBar(jmb);
        jmb.add(file);
        file.addSeparator();
        file.add(addGenre);
        file.add(delete);
        file.add(update);
        file.add(refresh);
        file.add(search);
        search.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        addGenre.addActionListener(this);
        refresh.addActionListener(this);


        //  Frame Settings
        setContentPane(contents);
        setVisible(true);
        setSize(900, 400);
        setTitle("About All Genre's (ADMIN) ");

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addGenre) {
            try {
                AddGenre frame = new AddGenre();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == refresh){
            setVisible(false);
            try {
                GenreFrame frame = new GenreFrame();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == delete){
            GenreDAO obj = new GenreDAO();
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
                UpdateGenre frame = new UpdateGenre();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == search){
            SearchGenreAdmin frame = new SearchGenreAdmin();
        }
    }
}
