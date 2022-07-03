package Tables.Publisher.Frames;

import Tables.Publisher.Publisher;
import Tables.Publisher.PublisherDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PublisherOrigin extends JFrame implements ActionListener {
    private JTextArea info = new JTextArea(30,17);

    ///////////////////// Labels
    private JLabel insertName = new JLabel("Publisher Name");
    private JLabel insertAddress = new JLabel("Publisher Address");
    private JLabel insertPhone = new JLabel("Publisher Phone");
    private JLabel insertManager = new JLabel("Publisher Manager") ;

    /////////////////// TEXT FIELDS

    private JTextField name = new JTextField(10);
    private JTextField address = new JTextField(10);
    private JTextField phone = new JTextField(10);
    private  JTextField manager = new JTextField(10);
    private JTextField deleteField = new JTextField(10);

    ///////////////////////// Buttons
    private JButton insert = new JButton("INSERT");
    private JButton refresh = new JButton("REFRESH");

    private JButton update = new JButton("UPDATE");

    private JButton delete = new JButton("DELETE");



    public PublisherOrigin() throws SQLException {
        setLayout(new FlowLayout());
        PublisherDAO obj = new PublisherDAO();
        obj.fillPublishers();

        info.setText(obj.printer());
        add(info);

        add(insertName);
        add(name);
        add(insertAddress);
        add(address);
        add(insertPhone);
        add(phone);
        add(insertManager);
        add(manager);

        add(insert);
        insert.addActionListener(this);

        add(refresh);
        refresh.addActionListener(this);

        add(update);
        update.addActionListener(this);

        add(delete);
        delete.addActionListener(this);
        deleteField.setBackground(Color.red);
        add(deleteField);

        setVisible(true);
        setSize(200,800);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insert) {
            String newName = name.getText();
            String newAddress = address.getText();
            String newPhone = phone.getText();
            String newManager = manager.getText();

            Publisher publisher = new Publisher(newName,newAddress,newPhone,newManager);
            PublisherDAO dao = new PublisherDAO();

            try {
                dao.insert(publisher);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "SUCCESSFULLY ADDed ");
        }

        if (e.getSource() == refresh){
            setVisible(false);
            try {
                PublisherOrigin newFrame = new PublisherOrigin();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }


        if (e.getSource() == update){

            String newName = name.getText();
            String newAddress = address.getText();
            String newPhone = phone.getText();
            String newManager = manager.getText();
            int numId = Integer.parseInt(JOptionPane.showInputDialog("insert ID you want to change "));

            Publisher publisher = new Publisher(numId,newName,newAddress,newPhone,newManager);
            PublisherDAO dao = new PublisherDAO();

            try {
                dao.update(publisher);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == delete){
            PublisherDAO obj = new PublisherDAO();
            int x = Integer.parseInt(deleteField.getText());
            try {
                obj.delete(x);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
