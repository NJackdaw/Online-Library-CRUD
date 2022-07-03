package Tables.Books.Frames;

import Tables.Books.Book;
import Tables.Books.BookDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BookOrigin extends JFrame implements ActionListener {

    private JTextArea infoArea = new JTextArea(30,17) ;

    ////////////////////////////        Labels
    private JLabel t = new JLabel("New Book's Title");
    private JLabel y = new JLabel("New Book's Year");
    private JLabel p = new JLabel("New Book's Page's");
    private JLabel aLabel = new JLabel("Authors Id");
    private JLabel gLabel  = new JLabel("Genre Id");
    private JLabel pLabel = new JLabel("Publisher Id");

    //////////////////////// Text Fields
    private JTextField title = new JTextField(10);

    private JTextField year = new JTextField(10);

    private JTextField page = new JTextField(10);
    private JTextField authorId = new JTextField(10);
    private JTextField genreId = new JTextField(10);
    private JTextField publisherId = new JTextField(10);
    private JTextField deleteField = new JTextField(10);

    //////////////////////////// Buttons

    private JButton add = new JButton("INSERT" );
    private JButton refresh = new JButton("REFRESH");
    private JButton delete = new JButton("Delete");
    private JButton update = new JButton("UPDATE");


    public BookOrigin() throws SQLException{
    setLayout(new FlowLayout());
    BookDAO obj = new BookDAO();
    obj.fillBooks();
    infoArea.setText(obj.printer());

        add(infoArea);

        add(t);
        add(title);
        add(y);
        add(year);
        add(p);
        add(page);

        add(aLabel);
        add(authorId);
        add(gLabel);
        add(genreId);
        add(pLabel);
        add(publisherId);


        add(add);
        add.addActionListener(this);

        add(refresh);
        refresh.addActionListener(this);

        add(delete);
        delete.addActionListener(this);
        deleteField.setBackground(Color.red);
        add(deleteField);

        add(update);
        update.addActionListener(this);





        setVisible(true);
        setSize(250,800);
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
    if( e.getSource() == refresh){
        setVisible(false);
        try {
            BookOrigin frame = new BookOrigin();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    if (e.getSource() == delete){
        BookDAO obj = new BookDAO();
        int x = Integer.parseInt(deleteField.getText());
        try {
            obj.delete(x);
            JOptionPane.showMessageDialog(this, "SUCCESSFULLY Deleted ");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
        if (e.getSource() == update){

            String newTitle = title.getText();
            String newPage = page.getText();
            String newYear = year.getText();
           int author_ID = Integer.parseInt(authorId.getText());
           int genre_ID = Integer.parseInt(genreId.getText());
           int publisher_ID = Integer.parseInt(publisherId.getText());
            int id = Integer.parseInt(JOptionPane.showInputDialog("insert ID you want to change "));

            Book book = new Book(id,newTitle,newPage,newYear,author_ID,genre_ID,publisher_ID);
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

