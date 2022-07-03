package Tables.Publisher.Frames;

import Tables.Publisher.Publisher;
import Tables.Publisher.PublisherDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddPublisher extends JFrame implements ActionListener {

    // Labels
    private JLabel insertName = new JLabel("Publisher Name");
    private JLabel insertAddress = new JLabel("Publisher Address");
    private JLabel insertPhone = new JLabel("Publisher Phone");
    private JLabel insertManager = new JLabel("Publisher Manager") ;

    // Fields

    private JTextField name = new JTextField(10);
    private JTextField address = new JTextField(10);
    private JTextField phone = new JTextField(10);
    private  JTextField manager = new JTextField(10);

    // Buttons

    private JButton insert = new JButton("ADD PUBLISHER");

    ///// Constructor

    public AddPublisher(){
        setLayout(new FlowLayout());


        //**/ ADD Labels And Fields
        add(insertName);
        add(name);
        add(insertAddress);
        add(address);
        add(insertPhone);
        add(phone);
        add(insertManager);
        add(manager);

        //**/    ADD Button's
        add(insert);
        insert.addActionListener(this);

        //**/ Frame Settings
        setVisible(true);
        setSize(300,400);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insert){
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
    }
}
