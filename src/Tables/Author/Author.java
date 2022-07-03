package Tables.Author;
public class Author {

    private int authorId ;
    private String name;
    private String surname;
    private String birthday;
    private String biography;

    public Author() {
    }

    public Author(int authorId, String name, String surname, String birthday, String biography) {
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.biography = biography;
    }
    public Author( String name, String surname, String birthday, String biography) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.biography = biography;
    }
    public Author(String name, String surname, String biography) {

        this.name = name;
        this.surname = surname;
        this.biography = biography;
    }

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", biography='" + biography + '\'' +
                '}';
    }
}
