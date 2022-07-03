package Tables.Books;
public class Book {
    private int bookID;
    private String title;
    private String pages;
    private String year;
    private int authorID;
    private int genreID;
    private int publisherID;

    public Book() {
    }

    public Book(int bookID, String title, String pages, String year, int authorID, int genreID, int publisherID) {
        this.bookID = bookID;
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authorID = authorID;
        this.genreID = genreID;
        this.publisherID = publisherID;
    }

    public Book(String title, String pages, String year, int authorID, int genreID, int publisherID) {

        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authorID = authorID;
        this.genreID = genreID;
        this.publisherID = publisherID;
    }

    public Book (String title, String pages, String year) {

        this.title = title;
        this.pages = pages;
        this.year = year;

    }
    public Book (String title, String year) {

        this.title = title;
        this.year = year;

    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthor(int authorID) {
        this.authorID = authorID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenre(int genreID) {
        this.genreID = genreID;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisher(int publisherID) {
        this.publisherID = publisherID;
    }
}
