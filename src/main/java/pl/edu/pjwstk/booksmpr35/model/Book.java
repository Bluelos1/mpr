package pl.edu.pjwstk.booksmpr35.model;

import pl.edu.pjwstk.booksmpr35.model.enums.BookType;

import java.time.LocalDate;

public class Book {
    private String title;
    private Author author;
    private BookType bookType;
    private LocalDate publishedDate;
    private String publisher;

    public Book() {
    }

    public Book(String title, Author author, BookType bookType, LocalDate publishedDate, String publisher) {
        this.title = title;
        this.author = author;
        this.bookType = bookType;
        this.publishedDate = publishedDate;
        this.publisher = publisher;
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
        return publishedDate;
    }

    public String getPublisher() {
        return publisher;
    }
}
