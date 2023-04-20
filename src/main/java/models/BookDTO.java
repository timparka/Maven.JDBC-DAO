package models;

public class BookDTO implements IBookDTO{
    Integer id;
    String title;
    String author;
    String genre;
    Integer year_published;
    String isbn;

    public BookDTO() {

    }

    public BookDTO(String title, String author, String genre, Integer year_published, String isbn) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year_published = year_published;
        this.isbn = isbn;
    }

    public BookDTO(Integer id, String title, String author, String genre, Integer year_published, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year_published = year_published;
        this.isbn = isbn;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear_published() {
        return year_published;
    }

    public void setYear_published(Integer year_published) {
        this.year_published = year_published;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year_published=" + year_published +
                ", isbn=" + isbn +
                '}';
    }

}
