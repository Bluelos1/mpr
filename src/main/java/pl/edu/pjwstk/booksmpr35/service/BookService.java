package pl.edu.pjwstk.booksmpr35.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr35.model.Book;
import pl.edu.pjwstk.booksmpr35.model.enums.BookType;
import pl.edu.pjwstk.booksmpr35.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(Long id){
      //  return bookRepository.getReferenceById(id);
        Optional<Book> b = bookRepository.findById(id);
        if (b.isPresent()){
            return b.get();

        }
        throw  new IllegalArgumentException();
    }

    public Book updateBook(Long id, Book updateBook){
        Book bookToUpdate=getBookById(id);

        if(updateBook.getPublisher() != null){
            bookToUpdate.setPublisher((updateBook.getPublisher()));
        }
        if (updateBook.getTitle() != null) {
            bookToUpdate.setTitle(updateBook.getTitle());
        }
        if(updateBook.getAuthor()!= null){
            bookToUpdate.setAuthor(updateBook.getAuthor());
        }
         return bookRepository.save(bookToUpdate);


    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public List<Book> getBooksByBookType(BookType bookType){
        return bookRepository.findBooksByBookType(bookType);
    }
}
