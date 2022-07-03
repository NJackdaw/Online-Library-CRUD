package Tables.Books.Frames;

import Tables.Books.Book;
import Tables.Books.BookDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateBook extends JFrame implements ActionListener {

    // Labels

    private JLabel t = new JLabel("New Book's Title");
    private JLabel y = new JLabel("New Book's Year");
    private JLabel p = new JLabel("New Book's Page's");
    private JLabel aLabel = new JLabel("Authors Id       ");
    private JLabel gLabel = new JLabel("Genre Id         ");
    private JLabel pLabel = new JLabel("Publisher Id     ");

    // Fields

    private JTextField title = new JTextField(10);

    private JTextField year = new JTextField(10);

    private JTextField page = new JTextField(10);
    private JTextField authorId = new JTextField(10);
    private JTextField genreId = new JTextField(10);
    private JTextField publisherId = new JTextField(10);

    // Buttons

    private JButton update = new JButton("UPDATE BOOK");

    ///// Constructor
    int id;

    public UpdateBook() {
        setLayout(new FlowLayout());
        id = Integer.parseInt(JOptionPane.showInputDialog("insert ID you want to change "));
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

        add(update);
        update.addActionListener(this);


        //**/ Frame Settings
        setVisible(true);
        setSize(270, 400);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String newTitle = title.getText();
            String newPage = page.getText();
            String newYear = year.getText();
            int author_ID = Integer.parseInt(authorId.getText());
            int genre_ID = Integer.parseInt(genreId.getText());
            int publisher_ID = Integer.parseInt(publisherId.getText());

            Book book = new Book(id, newTitle, newPage, newYear, author_ID, genre_ID, publisher_ID);
            BookDAO dao = new BookDAO();

            try {
                dao.update(book);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(this, "SUCCESSFULLY UPDATED ");
        }
    }
}
