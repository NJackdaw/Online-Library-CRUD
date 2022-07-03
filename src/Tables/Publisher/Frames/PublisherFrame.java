package Tables.Publisher.Frames;

import Searching.SearchPublisherAdmin;
import Tables.Publisher.Publisher;
import Tables.Publisher.PublisherDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PublisherFrame extends JFrame implements ActionListener {

    /// MenuBar(Items)
    private JMenuBar jmb = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenuItem addPublisher = new JMenuItem("Add Publisher");
    private JMenuItem refresh = new JMenuItem("Refresh Page");
    private JMenuItem delete = new JMenuItem("Delete Publisher");
    private JMenuItem update = new JMenuItem("Update Information");
    private JMenuItem search = new JMenuItem("Search");

    // {{{{{{{{{{{{{{{{{{}}}}}}}}}}____Constructor FRAME___{{{{{{{{{{{{{{{{}}}}}}}}}}}}}}}}//

    public PublisherFrame ()throws SQLException {
        PublisherDAO dao = new PublisherDAO();
        dao.fillPublishers();

        //           Preparing Array's for JTable
        Publisher [] newList = dao.getPublishers().toArray(new Publisher [dao.getPublishers().size()]);
        String[] columnsHeader = new String[]{"PUBLISHER ID","PUBLISHER NAME", "PUBLISHER ADDRESS", "PUBLISHER PHONE", "OFFICE MANAGER"};
        String[][] array = new String[newList.length][columnsHeader.length];

        for (int i = 0; i < newList.length; i++) {
            int y = 0;
            while(y < columnsHeader.length){
                array[i][y] = String.valueOf(dao.getPublishers().get(i).getPublisherId()); y++;
                array[i][y] = String.valueOf(dao.getPublishers().get(i).getName());y++;
                array[i][y] = String.valueOf(dao.getPublishers().get(i).getAddress()); y++;
                array[i][y] = String.valueOf(dao.getPublishers().get(i).getPhone()); y++;
                array[i][y] = String.valueOf(dao.getPublishers().get(i).getManager()); y++;
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
        file.add(addPublisher);
        file.add(delete);
        file.add(update);
        file.add(refresh);
        file.add(search);
        search.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        addPublisher.addActionListener(this);
        refresh.addActionListener(this);

        //  Frame Settings
        setContentPane(contents);
        setVisible(true);
        setSize(900, 400);
        setTitle("About All Genre's (ADMIN) ");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPublisher){
            AddPublisher frame = new AddPublisher();
        }
        if (e.getSource() == refresh){
            setVisible(false);
            try {
                PublisherFrame frame = new PublisherFrame();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == delete){
            PublisherDAO obj = new PublisherDAO();
            int id = Integer.parseInt(JOptionPane.showInputDialog("insert ID you Want to Delete "));
            try {
                obj.delete(id);
                JOptionPane.showMessageDialog(this, "SUCCESSFULLY DONE ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == update){
            UpdatePublisher frame = new UpdatePublisher();

        }
        if (e.getSource() == search){
            SearchPublisherAdmin frame = new SearchPublisherAdmin();
        }
    }
}
