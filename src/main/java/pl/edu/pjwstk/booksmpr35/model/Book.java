package pl.edu.pjwstk.booksmpr35.model;

import com.sun.xml.bind.v2.runtime.Name;
import pl.edu.pjwstk.booksmpr35.model.enums.BookType;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;
    @Column
    @Enumerated(EnumType.STRING)
    private BookType bookType;
    @Column
    private LocalDate publishDate;
    @Column
    private String publisher;


    public Book() {
    }

    public Book(String title, LocalDate publishDate, BookType bookType, Author author) {
        this.title = title;
        this.publishDate = publishDate;
        this.bookType = bookType;
        this.author = author;
    }



    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public BookType getBookType() {
        return bookType;
    }

    public LocalDate getPublishedDate() {
        return publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishDate = publishedDate;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
