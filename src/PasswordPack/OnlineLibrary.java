package PasswordPack;

import BookAdvanced.ShowBooks2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OnlineLibrary extends JFrame implements ActionListener {

    private JLabel welcome = new JLabel("                           WELCOME TO ONLINE LIBRARY                 ");
    private JLabel w = new JLabel("                                        (USER)                         ");
    private JButton buttonA = new JButton("AUTHORS ");
    private JButton buttonB = new JButton("Book's");
    private JButton buttonG = new JButton("Genre's");
    private JButton buttonP = new JButton("Publisher's");

    private JButton buttonShow2 = new JButton("SHOW BOOK's");

   //private Icon icon = new ImageIcon("resourceImages/library.jpeg");
   public Icon icon = new ImageIcon(getClass().getResource("resourceImages/library.jpeg"));


    private JLabel library = new JLabel(icon);

    /// JMenuBar

    private JMenuBar jmb = new JMenuBar();
    private JMenu option = new JMenu("Options");
    private JMenuItem change = new JMenuItem("Admin Access");

    /// Password
    private JPasswordField passField = new JPasswordField(10);


    public OnlineLibrary() {
        setLayout(new FlowLayout());

        setJMenuBar(jmb);
        jmb.add(option);
        option.add(change);
        change.addActionListener(this);



        add(welcome);
        add(w);
        add(library);

        add(buttonShow2);


        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonG.addActionListener(this);
        buttonP.addActionListener(this);
        buttonShow2.addActionListener(this);


        setSize(600, 500);
        setVisible(true);
        setTitle("Online_Library");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonShow2) {
            try {
                ShowBooks2 framer = new ShowBooks2();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == change) {

            try {
                PasswordFrame frame1 = new PasswordFrame();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            setVisible(false);




        }

    }
}
