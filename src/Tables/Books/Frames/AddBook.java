package Tables.Books.Frames;

import Tables.Books.Book;
import Tables.Books.BookDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddBook extends JFrame implements ActionListener {

    // Labels

    private JLabel t = new JLabel("New Book's Title");
    private JLabel y = new JLabel("New Book's Year");
    private JLabel p = new JLabel("New Book's Page's");
    private JLabel aLabel = new JLabel("Authors Id       ");
    private JLabel gLabel  = new JLabel("Genre Id        ");
    private JLabel pLabel = new JLabel("Publisher Id      ");

    // Fields

    private JTextField title = new JTextField(10);

    private JTextField year = new JTextField(10);

    private JTextField page = new JTextField(10);
    private JTextField authorId = new JTextField(10);
    private JTextField genreId = new JTextField(10);
    private JTextField publisherId = new JTextField(10);

    // Buttons

    private JButton add = new JButton("ADD BOOK");

    ///// Constructor

    public AddBook (){

        setLayout(new FlowLayout());
        //**/ ADD Labels And Fields
        add(t);
        add(title);
        add(p);
        add(page);
        add(y);
        add(year);
        add(aLabel);
        add(authorId);
        add(gLabel);
        add(genreId);
        add(pLabel);
        add(publisherId);

        //**/    ADD Button's

        add(add);
        add.addActionListener(this);



        //**/ Frame Settings
        setVisible(true);
        setSize(270,400);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String titleSet = title.getText();
            String yearSet = year.getText();
            String pageSet = page.getText();
            int author_id = Integer.parseInt(authorId.getText());
            int genre_id = Integer.parseInt(genreId.getText());
            int publisher_id = Integer.parseInt(publisherId.getText());

            Book book = new Book(titleSet, pageSet, yearSet,author_id,genre_id,publisher_id);
            BookDAO dao = new BookDAO();

            try {
                dao.insert(book);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "SUCCESSFULLY ADDed ");
        }
    }
}
