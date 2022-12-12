package pl.edu.pjwstk.booksmpr35.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.booksmpr35.model.Author;
import pl.edu.pjwstk.booksmpr35.model.Book;
import pl.edu.pjwstk.booksmpr35.model.enums.BookType;
import pl.edu.pjwstk.booksmpr35.service.AuthorService;
import pl.edu.pjwstk.booksmpr35.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book/")
public class BookController {
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllAuthors() {
        bookService.createBook(new Book());
        bookService.createBook(new Book());
        bookService.createBook(new Book());
        bookService.createBook(new Book());
        bookService.createBook(new Book());
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    //localhost:8080/author/1
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    //localhost:8080/author/gat?id=2
    @GetMapping("/get")
    public ResponseEntity<Book> getBookByIdRequestParam(@RequestParam("id") Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @DeleteMapping
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("ok");
    }
    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id)")Long id){
        return ResponseEntity.ok(bookService.updateBook(id,book));
    }
    @GetMapping("/type/{type}")
    public  ResponseEntity<List<Book>> findBooksByBookType(BookType bookType){
        return ResponseEntity.ok(bookService.getBooksByBookType(bookType));
    }
}

