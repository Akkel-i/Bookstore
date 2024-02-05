package hh.sof3.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    // attribuutit
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "bookId")
    private Integer id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String isbn;
    private Integer price;
    
    public Book() {
        super();
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbn = null;
        this.price = 0;
    }


    public Book(String title, String author, Integer publicationYear, String isbn, Integer price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    // getters

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPrice() {
        return price;
    }


    // setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn + ", price=" + price + "]";
    }



}
