package PasswordPack;

import Tables.Author.Frames.AuthorFrame;
import Tables.Books.Frames.BookFrame;
import Tables.Genre.Frames.GenreFrame;
import Tables.Publisher.Frames.PublisherFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OnlineLibraryADMIN extends JFrame implements ActionListener {

    private JLabel welcome = new JLabel("                           WELCOME TO ONLINE LIBRARY                 ");
    private JLabel w = new JLabel("                                        (ADMIN)                         ");
    private JButton buttonA = new JButton("AUTHORS ");
    private JButton buttonB = new JButton(" BOOK'S");
    private JButton buttonG = new JButton("GENRE'S");
    private JButton buttonP = new JButton("PUBLISHER'S");

    public Icon icon = new ImageIcon(getClass().getResource("resourceImages/library.jpeg"));


    private JLabel library = new JLabel(icon);
    private JMenuBar jmb = new JMenuBar();
    private JMenu option = new JMenu("Options");
    private JMenuItem userMode = new JMenuItem("USER Mode");
    private JMenuItem changePass = new JMenuItem("Change Password");









    public OnlineLibraryADMIN(){
        setLayout(new FlowLayout());
        add(welcome);
        add(w);
        add(library);

        add(buttonA);
        add(buttonB);
        add(buttonG);
        add(buttonP);



        setJMenuBar(jmb);
        jmb.add(option);
        option.add(userMode);
        option.add(changePass);

        changePass.addActionListener(this);
        userMode.addActionListener(this);
        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonG.addActionListener(this);
        buttonP.addActionListener(this);




        setSize(600,500);
        setVisible(true);
        setTitle("Online_Library");
    }












    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonA ){
            try {
                AuthorFrame frame2 = new AuthorFrame();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
            if (e.getSource() == buttonB){
                try {
                    BookFrame frame = new BookFrame();
                }catch (SQLException ex ){
                    throw new RuntimeException(ex);
                }
            }


         if (e.getSource() == buttonG){
            try {
                GenreFrame frame = new GenreFrame();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } if (e.getSource() == buttonP ){
            try{
                PublisherFrame frame = new PublisherFrame();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }



        if (e.getSource() == userMode){
            setVisible(false);
            OnlineLibrary frame = new OnlineLibrary();
            JOptionPane.showMessageDialog(this,"       USER Mode");

        }
        if (e.getSource() == changePass){
            ChangePassword frame = new ChangePassword();

        }

    }
}

