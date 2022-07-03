package Tables.Genre;

public class Genre {
    private int genreId;
    private String type;

    public Genre() {
    }


    public Genre(int genreId, String type) {
        this.genreId = genreId;
        this.type = type;
    }
    public Genre( String type) {
        this.type = type;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", type='" + type + '\'' +
                '}';
    }
}
